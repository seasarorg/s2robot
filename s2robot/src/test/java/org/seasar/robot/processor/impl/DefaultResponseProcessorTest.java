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
package org.seasar.robot.processor.impl;

import org.seasar.extension.unit.S2TestCase;
import org.seasar.robot.entity.ResponseData;

/**
 * @author shinsuke
 * 
 */
public class DefaultResponseProcessorTest extends S2TestCase {

    public void test_isSuccessful() {
        DefaultResponseProcessor processor = new DefaultResponseProcessor();
        processor.setSuccessfulHttpCodes(new int[] { 200 });
        processor.setNotModifiedHttpCodes(new int[] { 304 });

        ResponseData responseData = new ResponseData();
        responseData.setHttpStatusCode(200);
        assertTrue(processor.isSuccessful(responseData));

        responseData.setHttpStatusCode(100);
        assertFalse(processor.isSuccessful(responseData));
        responseData.setHttpStatusCode(304);
        assertFalse(processor.isSuccessful(responseData));
        responseData.setHttpStatusCode(404);
        assertFalse(processor.isSuccessful(responseData));
    }

    public void test_isNotModified() {
        DefaultResponseProcessor processor = new DefaultResponseProcessor();
        processor.setSuccessfulHttpCodes(new int[] { 200 });
        processor.setNotModifiedHttpCodes(new int[] { 304 });

        ResponseData responseData = new ResponseData();
        responseData.setHttpStatusCode(304);
        assertTrue(processor.isNotModified(responseData));

        responseData.setHttpStatusCode(100);
        assertFalse(processor.isNotModified(responseData));
        responseData.setHttpStatusCode(200);
        assertFalse(processor.isNotModified(responseData));
        responseData.setHttpStatusCode(404);
        assertFalse(processor.isNotModified(responseData));
    }
}
