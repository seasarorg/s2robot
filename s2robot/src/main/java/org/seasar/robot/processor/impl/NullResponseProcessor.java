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

import org.seasar.robot.entity.ResponseData;
import org.seasar.robot.processor.ResponseProcessor;

/**
 * @author kuma
 * 
 */
public class NullResponseProcessor implements ResponseProcessor {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.seasar.robot.processor.ResponseProcessor#process(org.seasar.robot
     * .entity.ResponseData)
     */
    @Override
    public void process(final ResponseData responseData) {
        // do nothing
    }

}
