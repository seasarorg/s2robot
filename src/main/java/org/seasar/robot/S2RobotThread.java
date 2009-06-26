/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.robot;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.util.StringUtil;
import org.seasar.robot.client.S2RobotClient;
import org.seasar.robot.client.S2RobotClientFactory;
import org.seasar.robot.entity.AccessResult;
import org.seasar.robot.entity.ResponseData;
import org.seasar.robot.entity.ResultData;
import org.seasar.robot.entity.UrlQueue;
import org.seasar.robot.interval.IntervalGenerator;
import org.seasar.robot.rule.Rule;
import org.seasar.robot.service.DataService;
import org.seasar.robot.service.UrlQueueService;
import org.seasar.robot.transformer.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shinsuke
 *
 */
public class S2RobotThread implements Runnable {
    private static final Logger logger = LoggerFactory
            .getLogger(S2RobotThread.class);

    @Resource
    protected UrlQueueService urlQueueService;

    @Resource
    protected DataService dataService;

    @Resource
    protected IntervalGenerator intervalGenerator;

    @Resource
    protected S2Container container;

    @Resource
    protected S2RobotConfig robotConfig;

    @Resource
    protected S2RobotClientFactory clientFactory;

    protected S2RobotContext robotContext;

    protected void startCrawling() {
        synchronized (robotContext.activeThreadCountLock) {
            robotContext.activeThreadCount++;
        }
    }

    protected void finishCrawling() {
        synchronized (robotContext.activeThreadCountLock) {
            robotContext.activeThreadCount--;
        }
    }

    protected boolean isContinue(int tcCount) {
        boolean isContinue = false;
        if (tcCount < robotConfig.maxThreadCheckCount) {
            isContinue = checkAccessCount();
        }

        if (!isContinue && robotContext.activeThreadCount > 0) {
            // still running..
            return true;
        }

        return isContinue;
    }

    protected boolean checkAccessCount() {
        if (robotConfig.maxAccessCount > 0) {
            if (robotContext.accessCount < robotConfig.maxAccessCount) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        int threadCheckCount = 0;
        while (robotContext.running && isContinue(threadCheckCount)) {
            UrlQueue urlQueue = urlQueueService.poll(robotContext.sessionId);
            if (isValid(urlQueue)) {
                try {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Starting " + urlQueue.getUrl());
                    }

                    S2RobotClient client = getClient(urlQueue.getUrl());
                    if (client == null) {
                        logger.info("Unsupported path: " + urlQueue.getUrl());
                        break;
                    }

                    startCrawling();

                    // access an url
                    long startTime = System.currentTimeMillis();
                    ResponseData responseData = client.doGet(urlQueue
                            .getUrl());
                    responseData.setExecutionTime(System.currentTimeMillis()
                            - startTime);
                    responseData.setParentUrl(urlQueue.getParentUrl());
                    responseData.setSessionId(robotContext.sessionId);

                    if (responseData.getRedirectLocation() != null) {
                        // redirect
                        synchronized (robotContext.accessCountLock) {
                            //  add an url
                            storeChildUrl(responseData.getRedirectLocation(),
                                    urlQueue.getUrl(),
                                    urlQueue.getDepth() != null ? urlQueue
                                            .getDepth() + 1 : 1);
                        }
                    } else {
                        processResponse(urlQueue, responseData);
                    }

                    if (logger.isDebugEnabled()) {
                        logger.debug("Finished " + urlQueue.getUrl());
                    }
                } catch (Exception e) {
                    logger.error("Crawling Exception at " + urlQueue.getUrl(),
                            e);
                } finally {
                    threadCheckCount = 0; // clear
                    finishCrawling();
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("No url in a queue. (" + threadCheckCount
                            + ")");
                }
                try {
                    Thread.sleep(robotConfig.getThreadCheckInterval());
                } catch (InterruptedException e) {
                    logger.warn("Could not sleep a thread: "
                            + Thread.currentThread().getName(), e);
                }
                threadCheckCount++;
            }

            // interval
            if (intervalGenerator != null) {
                try {
                    Thread.sleep(intervalGenerator.getTime());
                } catch (InterruptedException e) {
                    logger.warn("Could not sleep a thread: "
                            + Thread.currentThread().getName(), e);
                }
            }
        }
    }

    protected S2RobotClient getClient(String url) {
        return clientFactory.getClient(url);
    }

    protected void processResponse(UrlQueue urlQueue, ResponseData responseData) {
        // get a rule
        Rule rule = robotContext.ruleManager.getRule(responseData);
        if (rule != null) {
            responseData.setRuleId(rule.getRuleId());
            Transformer transformer = rule.getTransformer();
            if (transformer != null) {
                ResultData resultData = transformer.transform(responseData);
                if (resultData != null) {
                    processResult(urlQueue, responseData, resultData);
                } else {
                    logger.warn("No data for (" + responseData.getUrl() + ", "
                            + responseData.getMimeType() + ")");
                }
            } else {
                logger.warn("No transformer for (" + responseData.getUrl()
                        + ", " + responseData.getMimeType() + ")");
            }
        } else {
            logger.warn("No rule for (" + responseData.getUrl() + ", "
                    + responseData.getMimeType() + ")");
        }

    }

    protected void processResult(UrlQueue urlQueue, ResponseData responseData,
            ResultData resultData) {
        AccessResult accessResult = (AccessResult) container
                .getComponent(AccessResult.class);
        accessResult.init(responseData, resultData);

        synchronized (robotContext.accessCountLock) {
            if (!urlQueueService.visited(urlQueue)) {
                if (checkAccessCount()) {
                    //  store
                    dataService.store(accessResult);

                    //  add and filter urls 
                    storeChildUrls(resultData.getChildUrlSet(), urlQueue
                            .getUrl(), urlQueue.getDepth() != null ? urlQueue
                            .getDepth() + 1 : 1);

                    // count up
                    if (robotConfig.maxAccessCount > 0) {
                        robotContext.accessCount++;
                    }
                } else {
                    // cancel crawling
                    List<UrlQueue> newUrlQueueList = new ArrayList<UrlQueue>();
                    newUrlQueueList.add(urlQueue);
                    urlQueueService.offerAll(robotContext.sessionId,
                            newUrlQueueList);
                }
            }
        }

    }

    private void storeChildUrls(Set<String> childUrlList, String url, int depth) {
        //  add url and filter 
        List<UrlQueue> childList = new ArrayList<UrlQueue>();
        for (String childUrl : childUrlList) {
            if (robotContext.urlFilter.match(childUrl)) {
                UrlQueue uq = (UrlQueue) container.getComponent(UrlQueue.class);
                uq.setCreateTime(new Timestamp(new Date().getTime()));
                uq.setDepth(depth);
                uq.setMethod(Constants.GET_METHOD);
                uq.setParentUrl(url);
                uq.setSessionId(robotContext.sessionId);
                uq.setUrl(childUrl);
                childList.add(uq);
            }
        }
        urlQueueService.offerAll(robotContext.sessionId, childList);
    }

    private void storeChildUrl(String childUrl, String url, int depth) {
        //  add url and filter 
        if (robotContext.urlFilter.match(childUrl)) {
            List<UrlQueue> childList = new ArrayList<UrlQueue>(1);
            UrlQueue uq = (UrlQueue) container.getComponent(UrlQueue.class);
            uq.setCreateTime(new Timestamp(new Date().getTime()));
            uq.setDepth(depth);
            uq.setMethod(Constants.GET_METHOD);
            uq.setParentUrl(url);
            uq.setSessionId(robotContext.sessionId);
            uq.setUrl(childUrl);
            childList.add(uq);
            urlQueueService.offerAll(robotContext.sessionId, childList);
        }
    }

    protected boolean isValid(UrlQueue urlQueue) {
        if (urlQueue == null) {
            return false;
        }

        if (StringUtil.isBlank(urlQueue.getUrl())) {
            return false;
        }

        if (robotConfig.getMaxDepth() >= 0
                && urlQueue.getDepth() > robotConfig.getMaxDepth()) {
            return false;
        }

        //  url filter
        if (robotContext.urlFilter.match(urlQueue.getUrl())) {
            return true;
        }

        return false;
    }
}
