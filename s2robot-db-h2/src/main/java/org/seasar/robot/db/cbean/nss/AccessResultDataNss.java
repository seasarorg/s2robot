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
package org.seasar.robot.db.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.robot.db.cbean.cq.AccessResultDataCQ;

/**
 * The nest select set-upper of ACCESS_RESULT_DATA.
 * @author DBFlute(AutoGenerator)
 */
public class AccessResultDataNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected AccessResultDataCQ _query;

    public AccessResultDataNss(final AccessResultDataCQ query) {
        _query = query;
    }

    public boolean hasConditionQuery() {
        return _query != null;
    }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br />
     * ACCESS_RESULT by my ID, named 'accessResult'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public AccessResultNss withAccessResult() {
        _query.doNss(new AccessResultDataCQ.NssCall() {
            @Override
            public ConditionQuery qf() {
                return _query.queryAccessResult();
            }
        });
        return new AccessResultNss(_query.queryAccessResult());
    }
}
