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
package org.seasar.robot.rule;

import java.io.Serializable;

import org.seasar.robot.entity.ResponseData;
import org.seasar.robot.transformer.Transformer;

/**
 * @author shinsuke
 * 
 */
public interface Rule extends Serializable {

    public abstract boolean match(ResponseData responseData);

    public abstract String getRuleId();

    public abstract void setRuleId(String ruleId);

    public abstract Transformer getTransformer();

    public abstract void setTransformer(Transformer transformer);
}