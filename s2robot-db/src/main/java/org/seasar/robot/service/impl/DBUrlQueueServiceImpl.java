/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
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
package org.seasar.robot.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.seasar.framework.util.StringUtil;
import org.seasar.robot.Constants;
import org.seasar.robot.db.cbean.AccessResultCB;
import org.seasar.robot.db.cbean.UrlQueueCB;
import org.seasar.robot.db.exbhv.AccessResultBhv;
import org.seasar.robot.db.exbhv.UrlQueueBhv;
import org.seasar.robot.db.exentity.AccessResult;
import org.seasar.robot.dbflute.cbean.PagingResultBean;
import org.seasar.robot.entity.UrlQueue;
import org.seasar.robot.service.UrlQueueService;
import org.seasar.robot.util.LruHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shinsuke
 *
 */
public class DBUrlQueueServiceImpl implements UrlQueueService {

    private static final String EMPTY_STRING = "";

    private static final Logger logger = LoggerFactory
        .getLogger(DBUrlQueueServiceImpl.class);

    protected static volatile Map<String, LinkedList<UrlQueue>> URL_QUEUE_MAP =
        new HashMap<>();

    private static ConcurrentHashMap<String, Map<String, String>> VISITED_URL_CACHE_MAP =
        new ConcurrentHashMap<>();

    public int cacheSize = 1000;

    public int visitedUrlCacheSize = 1000;

    public int generatedUrlQueueSize = 1000;

    @Resource
    protected UrlQueueBhv urlQueueBhv;

    @Resource
    protected AccessResultBhv accessResultBhv;

    private LinkedList<UrlQueue> getUrlQueueList(final String sessionId) {
        LinkedList<UrlQueue> urlQueueList = URL_QUEUE_MAP.get(sessionId);
        if (urlQueueList == null) {
            synchronized (URL_QUEUE_MAP) {
                urlQueueList = URL_QUEUE_MAP.get(sessionId);
                if (urlQueueList == null) {
                    urlQueueList = new LinkedList<UrlQueue>();
                    URL_QUEUE_MAP.put(sessionId, urlQueueList);
                }
            }
        }
        return urlQueueList;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.seasar.robot.service.UrlQueueService#updateSessionId(java.lang.String
     * , java.lang.String)
     */
    @Override
    public void updateSessionId(final String oldSessionId,
            final String newSessionId) {
        // not MT-safe
        final LinkedList<UrlQueue> urlQueueList = getUrlQueueList(oldSessionId);
        // overwrite
        URL_QUEUE_MAP.put(newSessionId, urlQueueList);
        URL_QUEUE_MAP.remove(oldSessionId);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.seasar.robot.service.UrlQueueService#add(java.lang.String,
     * java.lang.String)
     */
    @Override
    public void add(final String sessionId, final String url) {
        final LinkedList<UrlQueue> urlQueueList = getUrlQueueList(sessionId);
        synchronized (urlQueueList) {
            final UrlQueue urlQueue =
                new org.seasar.robot.db.exentity.UrlQueue();
            urlQueue.setSessionId(sessionId);
            urlQueue.setMethod(Constants.GET_METHOD);
            urlQueue.setUrl(url);
            urlQueue.setDepth(0);
            urlQueue.setCreateTime(new Timestamp(new Date().getTime()));
            urlQueueList.add(urlQueue);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.seasar.robot.service.UrlQueueService#insert(org.seasar.robot.entity
     * .UrlQueue)
     */
    @Override
    public void insert(final UrlQueue urlQueue) {
        urlQueueBhv.insert((org.seasar.robot.db.exentity.UrlQueue) urlQueue);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.seasar.robot.service.UrlQueueService#delete(java.lang.String)
     */
    @Override
    public void delete(final String sessionId) {
        final int count = urlQueueBhv.deleteBySessionId(sessionId);

        if (logger.isDebugEnabled()) {
            logger.debug("Deleted urls in queue: " + count);
        }

        synchronized (URL_QUEUE_MAP) { // clear cache
            URL_QUEUE_MAP.remove(sessionId);
            VISITED_URL_CACHE_MAP.remove(sessionId);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.seasar.robot.service.UrlQueueService#deleteAll()
     */
    @Override
    public void deleteAll() {
        final int count = urlQueueBhv.deleteAll();

        if (logger.isDebugEnabled()) {
            logger.debug("Deleted urls in queue: " + count);
        }

        synchronized (URL_QUEUE_MAP) { // clear cache
            URL_QUEUE_MAP.clear();
            VISITED_URL_CACHE_MAP.clear();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.seasar.robot.service.UrlQueueService#offerAll(java.lang.String,
     * java.util.List)
     */
    @Override
    public void offerAll(final String sessionId,
            final List<UrlQueue> newUrlQueueList) {
        final LinkedList<UrlQueue> urlQueueList = getUrlQueueList(sessionId);
        synchronized (urlQueueList) {
            final List<org.seasar.robot.db.exentity.UrlQueue> targetList =
                new ArrayList<>();
            for (final UrlQueue urlQueue : newUrlQueueList) {
                if (isNewUrl(urlQueue, urlQueueList, true)) {
                    targetList
                        .add((org.seasar.robot.db.exentity.UrlQueue) urlQueue);
                }
            }
            urlQueueBhv.batchInsert(targetList);
        }
    }

    private Map<String, String> getVisitedUrlCache(final String sessionId) {
        Map<String, String> visitedUrlMap =
            VISITED_URL_CACHE_MAP.get(sessionId);
        if (visitedUrlMap == null) {
            visitedUrlMap =
                Collections.synchronizedMap(new LruHashMap<String, String>(
                    visitedUrlCacheSize));
            final Map<String, String> urlMap =
                VISITED_URL_CACHE_MAP.putIfAbsent(sessionId, visitedUrlMap);
            if (urlMap != null) {
                visitedUrlMap = urlMap;
            }
        }
        return visitedUrlMap;
    }

    protected boolean isNewUrl(final UrlQueue urlQueue,
            final List<UrlQueue> urlQueueList, final boolean cache) {

        final String url = urlQueue.getUrl();
        if (StringUtil.isBlank(url)) {
            if (logger.isDebugEnabled()) {
                logger.debug("URL is a blank: " + url);
            }
            return false;
        }

        if (cache) {
            final String sessionId = urlQueue.getSessionId();
            // cache
            String cacheKey = getCacheKey(urlQueue);
            if (getVisitedUrlCache(sessionId).containsKey(cacheKey)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("URL exists in a cache: " + url);
                }
                return false;
            }
            getVisitedUrlCache(sessionId).put(cacheKey, EMPTY_STRING);
        }

        // check it in queue
        for (final UrlQueue urlInQueue : urlQueueList) {
            if (url.equals(urlInQueue.getUrl())) {
                if (logger.isDebugEnabled()) {
                    logger.debug("URL exists in a queue: " + url);
                }
                return false;
            }
        }

        // check it in queue db
        final UrlQueueCB cb1 = new UrlQueueCB();
        cb1.query().setUrl_Equal(url);
        cb1.query().setMetaData_Equal(urlQueue.getMetaData());
        cb1.query().setSessionId_Equal(urlQueue.getSessionId());
        final int count1 = urlQueueBhv.selectCount(cb1);
        if (count1 > 0) {
            if (logger.isDebugEnabled()) {
                logger.debug("URL exists in a queue db: " + url);
            }
            return false;
        }

        // check it in result
        final AccessResultCB cb2 = new AccessResultCB();
        cb2.query().setUrl_Equal(url);
        cb2.query().setSessionId_Equal(urlQueue.getSessionId());
        final int count2 = accessResultBhv.selectCount(cb2);
        if (count2 > 0) {
            if (logger.isDebugEnabled()) {
                logger.debug("URL exists in a result: " + url);
            }
            return false;
        }

        return true;

    }

    private String getCacheKey(final UrlQueue urlQueue) {
        return urlQueue.getUrl() + '\n' + urlQueue.getMetaData();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.seasar.robot.service.UrlQueueService#poll(java.lang.String)
     */
    @Override
    public UrlQueue poll(final String sessionId) {
        final LinkedList<UrlQueue> urlQueueList = getUrlQueueList(sessionId);
        synchronized (urlQueueList) {
            if (urlQueueList.isEmpty()) {
                UrlQueueCB cb = new UrlQueueCB();
                cb.paging(cacheSize, 1);
                cb.query().setSessionId_Equal(sessionId);
                final List<org.seasar.robot.db.exentity.UrlQueue> uqList =
                    urlQueueBhv.selectPage(cb);
                if (!uqList.isEmpty()) {
                    urlQueueList.addAll(uqList);

                    final List<Long> idList = new ArrayList<>(cacheSize);
                    for (final UrlQueue uq : uqList) {
                        idList.add(uq.getId());
                    }
                    cb = new UrlQueueCB();
                    cb.query().setId_InScope(idList);
                    urlQueueBhv.queryDelete(cb);
                }
            }

            return urlQueueList.poll();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.seasar.robot.service.UrlQueueService#saveSession(java.lang.String)
     */
    @Override
    public void saveSession(final String sessionId) {
        final LinkedList<UrlQueue> urlQueueList = getUrlQueueList(sessionId);
        synchronized (urlQueueList) {
            final List<org.seasar.robot.db.exentity.UrlQueue> targetUrlQueueList =
                new ArrayList<>();
            for (final UrlQueue urlQueue : urlQueueList) {
                // clear id
                urlQueue.setId(null);
                targetUrlQueueList
                    .add((org.seasar.robot.db.exentity.UrlQueue) urlQueue);
            }
            urlQueueBhv.batchInsert(targetUrlQueueList);
            urlQueueList.clear();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.seasar.robot.service.UrlQueueService#visited(UrlQueue)
     */
    @Override
    public boolean visited(final UrlQueue urlQueue) {
        final LinkedList<UrlQueue> urlQueueList =
            getUrlQueueList(urlQueue.getSessionId());
        synchronized (urlQueueList) {
            return !isNewUrl(urlQueue, urlQueueList, false);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.seasar.robot.service.UrlQueueService#generateUrlQueues(java.lang.
     * String, java.lang.String)
     */
    @Override
    public void generateUrlQueues(final String previousSessionId,
            final String sessionId) {
        final AccessResultCB cb = new AccessResultCB();
        cb.query().setSessionId_Equal(previousSessionId);
        cb.query().addOrderBy_CreateTime_Asc();
        final int count = accessResultBhv.selectCount(cb);
        final List<org.seasar.robot.db.exentity.UrlQueue> urlQueueList =
            new ArrayList<>();
        for (int i = 0; i * generatedUrlQueueSize < count; i++) {
            urlQueueList.clear();
            cb.paging(generatedUrlQueueSize, i + 1);
            final PagingResultBean<AccessResult> selectPage =
                accessResultBhv.selectPage(cb);
            for (final AccessResult entity : selectPage) {
                final org.seasar.robot.db.exentity.UrlQueue urlQueue =
                    new org.seasar.robot.db.exentity.UrlQueue();
                urlQueue.setSessionId(sessionId);
                urlQueue.setMethod(entity.getMethod());
                urlQueue.setUrl(entity.getUrl());
                urlQueue.setParentUrl(entity.getParentUrl());
                urlQueue.setDepth(0);
                urlQueue.setLastModified(entity.getLastModified());
                urlQueue.setCreateTime(new Timestamp(new Date().getTime()));
                urlQueueList.add(urlQueue);
            }
            urlQueueBhv.batchInsert(urlQueueList);
        }
    }
}
