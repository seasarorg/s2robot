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
package org.seasar.robot.service;

import java.util.List;

import org.seasar.robot.entity.UrlQueue;

/**
 * @author shinsuke
 * 
 */
public interface UrlQueueService {

    void updateSessionId(String oldSessionId, String newSessionId);

    void add(String sessionId, String url);

    void insert(UrlQueue urlQueue);

    void delete(String sessionId);

    void deleteAll();

    void offerAll(String sessionId, List<UrlQueue> newUrlQueueList);

    UrlQueue poll(String sessionId);

    void saveSession(String sessionId);

    boolean visited(UrlQueue urlQueue);

    void generateUrlQueues(String previousSessionId, String sessionId);
}
