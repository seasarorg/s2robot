/*
 * Copyright 2004-2011 the Seasar Foundation and the Others.
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
package org.seasar.robot.db.cbean.bs;

import org.seasar.robot.db.allcommon.DBFluteConfig;
import org.seasar.robot.db.allcommon.DBMetaInstanceHandler;
import org.seasar.robot.db.allcommon.ImplementedInvokerAssistant;
import org.seasar.robot.db.allcommon.ImplementedSqlClauseCreator;
import org.seasar.robot.db.cbean.AccessResultCB;
import org.seasar.robot.db.cbean.AccessResultDataCB;
import org.seasar.robot.db.cbean.cq.AccessResultCQ;
import org.seasar.robot.db.cbean.cq.AccessResultDataCQ;
import org.seasar.robot.db.cbean.nss.AccessResultNss;
import org.seasar.robot.dbflute.cbean.AbstractConditionBean;
import org.seasar.robot.dbflute.cbean.AndQuery;
import org.seasar.robot.dbflute.cbean.ConditionBean;
import org.seasar.robot.dbflute.cbean.ConditionQuery;
import org.seasar.robot.dbflute.cbean.OrQuery;
import org.seasar.robot.dbflute.cbean.SpecifyQuery;
import org.seasar.robot.dbflute.cbean.SubQuery;
import org.seasar.robot.dbflute.cbean.UnionQuery;
import org.seasar.robot.dbflute.cbean.chelper.HpAbstractSpecification;
import org.seasar.robot.dbflute.cbean.chelper.HpCBPurpose;
import org.seasar.robot.dbflute.cbean.chelper.HpCalculator;
import org.seasar.robot.dbflute.cbean.chelper.HpColQyHandler;
import org.seasar.robot.dbflute.cbean.chelper.HpColQyOperand;
import org.seasar.robot.dbflute.cbean.chelper.HpSpQyCall;
import org.seasar.robot.dbflute.cbean.chelper.HpSpecifiedColumn;
import org.seasar.robot.dbflute.cbean.coption.ConditionOption;
import org.seasar.robot.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.robot.dbflute.cbean.sqlclause.SqlClauseCreator;
import org.seasar.robot.dbflute.dbmeta.DBMetaProvider;
import org.seasar.robot.dbflute.twowaysql.factory.SqlAnalyzerFactory;

/**
 * The base condition-bean of ACCESS_RESULT_DATA.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class BsAccessResultDataCB extends AbstractConditionBean {

    // ===================================================================================
    // Attribute
    // =========
    protected AccessResultDataCQ _conditionQuery;

    // ===================================================================================
    // SqlClause
    // =========
    @Override
    protected SqlClause createSqlClause() {
        final SqlClauseCreator creator =
            DBFluteConfig.getInstance().getSqlClauseCreator();
        if (creator != null) {
            return creator.createSqlClause(this);
        }
        return new ImplementedSqlClauseCreator().createSqlClause(this); // as
                                                                        // default
    }

    // ===================================================================================
    // DBMeta Provider
    // ===============
    @Override
    protected DBMetaProvider getDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider(); // as default
    }

    // ===================================================================================
    // Table Name
    // ==========
    public String getTableDbName() {
        return "ACCESS_RESULT_DATA";
    }

    // ===================================================================================
    // PrimaryKey Handling
    // ===================
    public void acceptPrimaryKey(final Long id) {
        assertObjectNotNull("id", id);
        final BsAccessResultDataCB cb = this;
        cb.query().setId_Equal(id);
    }

    public ConditionBean addOrderBy_PK_Asc() {
        query().addOrderBy_Id_Asc();
        return this;
    }

    public ConditionBean addOrderBy_PK_Desc() {
        query().addOrderBy_Id_Desc();
        return this;
    }

    // ===================================================================================
    // Query
    // =====
    /**
     * Prepare for various queries. <br />
     * Examples of main functions are following:
     * 
     * <pre>
     * <span style="color: #3F7E5E">// Basic Queries</span>
     * cb.query().setMemberId_Equal(value);        <span style="color: #3F7E5E">// =</span>
     * cb.query().setMemberId_NotEqual(value);     <span style="color: #3F7E5E">// !=</span>
     * cb.query().setMemberId_GreaterThan(value);  <span style="color: #3F7E5E">// &gt;</span>
     * cb.query().setMemberId_LessThan(value);     <span style="color: #3F7E5E">// &lt;</span>
     * cb.query().setMemberId_GreaterEqual(value); <span style="color: #3F7E5E">// &gt;=</span>
     * cb.query().setMemberId_LessEqual(value);    <span style="color: #3F7E5E">// &lt;=</span>
     * cb.query().setMemberName_InScope(valueList);    <span style="color: #3F7E5E">// in ('a', 'b')</span>
     * cb.query().setMemberName_NotInScope(valueList); <span style="color: #3F7E5E">// not in ('a', 'b')</span>
     * cb.query().setMemberName_PrefixSearch(value);   <span style="color: #3F7E5E">// like 'a%' escape '|'</span>
     * <span style="color: #3F7E5E">// LikeSearch with various options: (versatile)</span>
     * <span style="color: #3F7E5E">// {like ... [options]}</span>
     * cb.query().setMemberName_LikeSearch(value, option);
     * cb.query().setMemberName_NotLikeSearch(value, option); <span style="color: #3F7E5E">// not like ...</span>
     * <span style="color: #3F7E5E">// FromTo with various options: (versatile)</span>
     * <span style="color: #3F7E5E">// {(default) fromDatetime &lt;= BIRTHDATE &lt;= toDatetime}</span>
     * cb.query().setBirthdate_FromTo(fromDatetime, toDatetime, option);
     * <span style="color: #3F7E5E">// DateFromTo: (Date means yyyy/MM/dd)</span>
     * <span style="color: #3F7E5E">// {fromDate &lt;= BIRTHDATE &lt; toDate + 1 day}</span>
     * cb.query().setBirthdate_DateFromTo(fromDate, toDate);
     * cb.query().setBirthdate_IsNull();    <span style="color: #3F7E5E">// is null</span>
     * cb.query().setBirthdate_IsNotNull(); <span style="color: #3F7E5E">// is not null</span>
     * 
     * <span style="color: #3F7E5E">// ExistsReferrer: (co-related sub-query)</span>
     * <span style="color: #3F7E5E">// {where exists (select PURCHASE_ID from PURCHASE where ...)}</span>
     * cb.query().existsPurchaseList(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// referrer sub-query condition</span>
     *     }
     * });
     * cb.query().notExistsPurchaseList...
     * 
     * <span style="color: #3F7E5E">// InScopeRelation: (sub-query)</span>
     * <span style="color: #3F7E5E">// {where MEMBER_STATUS_CODE in (select MEMBER_STATUS_CODE from MEMBER_STATUS where ...)}</span>
     * cb.query().inScopeMemberStatus(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// relation sub-query condition</span>
     *     }
     * });
     * cb.query().notInScopeMemberStatus...
     * 
     * <span style="color: #3F7E5E">// (Query)DerivedReferrer: (co-related sub-query)</span>
     * cb.query().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchasePrice(); <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// referrer sub-query condition</span>
     *     }
     * }).greaterEqual(value);
     * 
     * <span style="color: #3F7E5E">// ScalarCondition: (self-table sub-query)</span>
     * cb.query().scalar_Equal().max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().columnBirthdate(); <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// scalar sub-query condition</span>
     *     }
     * });
     * 
     * <span style="color: #3F7E5E">// OrderBy</span>
     * cb.query().addOrderBy_MemberName_Asc();
     * cb.query().addOrderBy_MemberName_Desc().withManualOrder(valueList);
     * cb.query().addOrderBy_MemberName_Desc().withNullsFirst();
     * cb.query().addOrderBy_MemberName_Desc().withNullsLast();
     * cb.query().addSpecifiedDerivedOrderBy_Desc(aliasName);
     * 
     * <span style="color: #3F7E5E">// Query(Relation)</span>
     * cb.query().queryMemberStatus()...;
     * cb.query().queryMemberAddressAsValid(targetDate)...;
     * </pre>
     * 
     * @return The instance of condition-query for base-point table to set up
     *         query. (NotNull)
     */
    public AccessResultDataCQ query() {
        assertQueryPurpose(); // assert only when user-public query
        return getConditionQuery();
    }

    public AccessResultDataCQ getConditionQuery() { // public for parameter
                                                    // comment and internal
        if (_conditionQuery == null) {
            _conditionQuery = createLocalCQ();
        }
        return _conditionQuery;
    }

    protected AccessResultDataCQ createLocalCQ() {
        return xcreateCQ(null, getSqlClause(), getSqlClause()
            .getBasePointAliasName(), 0);
    }

    protected AccessResultDataCQ xcreateCQ(final ConditionQuery childQuery,
            final SqlClause sqlClause, final String aliasName,
            final int nestLevel) {
        return new AccessResultDataCQ(
            childQuery,
            sqlClause,
            aliasName,
            nestLevel);
    }

    public ConditionQuery localCQ() {
        return getConditionQuery();
    }

    // ===================================================================================
    // Union
    // =====
    /**
     * Set up 'union' for base-point table. <br />
     * You don't need to call SetupSelect in union-query, because it inherits
     * calls before. (Don't call SetupSelect after here)
     * 
     * <pre>
     * cb.query().<span style="color: #FD4747">union</span>(new UnionQuery&lt;AccessResultDataCB&gt;() {
     *     public void query(AccessResultDataCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * 
     * @param unionQuery
     *            The query of 'union'. (NotNull)
     */
    public void union(final UnionQuery<AccessResultDataCB> unionQuery) {
        final AccessResultDataCB cb = new AccessResultDataCB();
        cb.xsetupForUnion(this);
        xsyncUQ(cb);
        unionQuery.query(cb);
        xsaveUCB(cb);
        final AccessResultDataCQ cq = cb.query();
        query().xsetUnionQuery(cq);
    }

    /**
     * Set up 'union all' for base-point table. <br />
     * You don't need to call SetupSelect in union-query, because it inherits
     * calls before. (Don't call SetupSelect after here)
     * 
     * <pre>
     * cb.query().<span style="color: #FD4747">unionAll</span>(new UnionQuery&lt;AccessResultDataCB&gt;() {
     *     public void query(AccessResultDataCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * 
     * @param unionQuery
     *            The query of 'union all'. (NotNull)
     */
    public void unionAll(final UnionQuery<AccessResultDataCB> unionQuery) {
        final AccessResultDataCB cb = new AccessResultDataCB();
        cb.xsetupForUnion(this);
        xsyncUQ(cb);
        unionQuery.query(cb);
        xsaveUCB(cb);
        final AccessResultDataCQ cq = cb.query();
        query().xsetUnionAllQuery(cq);
    }

    // ===================================================================================
    // SetupSelect
    // ===========
    protected AccessResultNss _nssAccessResult;

    public AccessResultNss getNssAccessResult() {
        if (_nssAccessResult == null) {
            _nssAccessResult = new AccessResultNss(null);
        }
        return _nssAccessResult;
    }

    /**
     * Set up relation columns to select clause. <br />
     * ACCESS_RESULT as 'accessResult'.
     * 
     * <pre>
     * AccessResultDataCB cb = new AccessResultDataCB();
     * cb.<span style="color: #FD4747">setupSelect_AccessResult()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     * cb.query().setFoo...(value);
     * AccessResultData accessResultData = accessResultDataBhv.selectEntityWithDeletedCheck(cb);
     * ... = accessResultData.<span style="color: #FD4747">getAccessResult()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * </pre>
     * 
     * @return The set-upper of nested relation.
     *         {setupSelect...().with[nested-relation]} (NotNull)
     */
    public AccessResultNss setupSelect_AccessResult() {
        doSetupSelect(new SsCall() {
            public ConditionQuery qf() {
                return query().queryAccessResult();
            }
        });
        if (_nssAccessResult == null || !_nssAccessResult.hasConditionQuery()) {
            _nssAccessResult = new AccessResultNss(query().queryAccessResult());
        }
        return _nssAccessResult;
    }

    // [DBFlute-0.7.4]
    // ===================================================================================
    // Specify
    // =======
    protected HpSpecification _specification;

    /**
     * Prepare for SpecifyColumn, (Specify)DerivedReferrer. <br />
     * This method should be called after SetupSelect.
     * 
     * <pre>
     * cb.setupSelect_MemberStatus(); <span style="color: #3F7E5E">// should be called before specify()</span>
     * cb.specify().columnMemberName();
     * cb.specify().specifyMemberStatus().columnMemberStatusName();
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *         subCB.query().set...
     *     }
     * }, aliasName);
     * </pre>
     * 
     * @return The instance of specification. (NotNull)
     */
    public HpSpecification specify() {
        assertSpecifyPurpose();
        if (_specification == null) {
            _specification =
                new HpSpecification(this, new HpSpQyCall<AccessResultDataCQ>() {
                    public boolean has() {
                        return true;
                    }

                    public AccessResultDataCQ qy() {
                        return getConditionQuery();
                    }
                }, _purpose, getDBMetaProvider());
        }
        return _specification;
    }

    @Override
    protected boolean hasSpecifiedColumn() {
        return _specification != null
            && _specification.isAlreadySpecifiedRequiredColumn();
    }

    @Override
    protected HpAbstractSpecification<? extends ConditionQuery> localSp() {
        return specify();
    }

    public static class HpSpecification extends
            HpAbstractSpecification<AccessResultDataCQ> {
        protected AccessResultCB.HpSpecification _accessResult;

        public HpSpecification(final ConditionBean baseCB,
                final HpSpQyCall<AccessResultDataCQ> qyCall,
                final HpCBPurpose purpose, final DBMetaProvider dbmetaProvider) {
            super(baseCB, qyCall, purpose, dbmetaProvider);
        }

        /**
         * ID: {PK, NotNull, BIGINT(19), FK to ACCESS_RESULT}
         * 
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnId() {
            return doColumn("ID");
        }

        /**
         * TRANSFORMER_NAME: {NotNull, VARCHAR(255)}
         * 
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnTransformerName() {
            return doColumn("TRANSFORMER_NAME");
        }

        /**
         * DATA: {BLOB(2147483647)}
         * 
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnData() {
            return doColumn("DATA");
        }

        /**
         * ENCODING: {VARCHAR(20)}
         * 
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnEncoding() {
            return doColumn("ENCODING");
        }

        @Override
        protected void doSpecifyRequiredColumn() {
            columnId(); // PK
        }

        @Override
        protected String getTableDbName() {
            return "ACCESS_RESULT_DATA";
        }

        /**
         * Prepare to specify functions about relation table. <br />
         * ACCESS_RESULT as 'accessResult'.
         * 
         * @return The instance for specification for relation table to specify.
         *         (NotNull)
         */
        public AccessResultCB.HpSpecification specifyAccessResult() {
            assertRelation("accessResult");
            if (_accessResult == null) {
                _accessResult =
                    new AccessResultCB.HpSpecification(
                        _baseCB,
                        new HpSpQyCall<AccessResultCQ>() {
                            public boolean has() {
                                return _qyCall.has()
                                    && _qyCall
                                        .qy()
                                        .hasConditionQueryAccessResult();
                            }

                            public AccessResultCQ qy() {
                                return _qyCall.qy().queryAccessResult();
                            }
                        },
                        _purpose,
                        _dbmetaProvider);
                if (xhasSyncQyCall()) { // inherits it
                    _accessResult
                        .xsetSyncQyCall(new HpSpQyCall<AccessResultCQ>() {
                            public boolean has() {
                                return xsyncQyCall().has()
                                    && xsyncQyCall()
                                        .qy()
                                        .hasConditionQueryAccessResult();
                            }

                            public AccessResultCQ qy() {
                                return xsyncQyCall().qy().queryAccessResult();
                            }
                        });
                }
            }
            return _accessResult;
        }
    }

    // [DBFlute-0.9.5.3]
    // ===================================================================================
    // ColumnQuery
    // ===========
    /**
     * Set up column-query. {column1 = column2}
     * 
     * <pre>
     * <span style="color: #3F7E5E">// where FOO &lt; BAR</span>
     * cb.<span style="color: #FD4747">columnQuery</span>(new SpecifyQuery&lt;AccessResultDataCB&gt;() {
     *     public void query(AccessResultDataCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFoo()</span>; <span style="color: #3F7E5E">// left column</span>
     *     }
     * }).lessThan(new SpecifyQuery&lt;AccessResultDataCB&gt;() {
     *     public void query(AccessResultDataCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnBar()</span>; <span style="color: #3F7E5E">// right column</span>
     *     }
     * }); <span style="color: #3F7E5E">// you can calculate for right column like '}).plus(3);'</span>
     * </pre>
     * 
     * @param leftSpecifyQuery
     *            The specify-query for left column. (NotNull)
     * @return The object for setting up operand and right column. (NotNull)
     */
    public HpColQyOperand<AccessResultDataCB> columnQuery(
            final SpecifyQuery<AccessResultDataCB> leftSpecifyQuery) {
        return new HpColQyOperand<AccessResultDataCB>(
            new HpColQyHandler<AccessResultDataCB>() {
                public HpCalculator handle(
                        final SpecifyQuery<AccessResultDataCB> rightSp,
                        final String operand) {
                    return xcolqy(
                        xcreateColumnQueryCB(),
                        xcreateColumnQueryCB(),
                        leftSpecifyQuery,
                        rightSp,
                        operand);
                }
            });
    }

    protected AccessResultDataCB xcreateColumnQueryCB() {
        final AccessResultDataCB cb = new AccessResultDataCB();
        cb.xsetupForColumnQuery(this);
        return cb;
    }

    // [DBFlute-0.9.6.3]
    // ===================================================================================
    // OrScopeQuery
    // ============
    /**
     * Set up the query for or-scope. <br />
     * (Same-column-and-same-condition-key conditions are allowed in or-scope)
     * 
     * <pre>
     * <span style="color: #3F7E5E">// where (FOO = '...' or BAR = '...')</span>
     * cb.<span style="color: #FD4747">orScopeQuery</span>(new OrQuery&lt;AccessResultDataCB&gt;() {
     *     public void query(AccessResultDataCB orCB) {
     *         orCB.query().setFOO_Equal...
     *         orCB.query().setBAR_Equal...
     *     }
     * });
     * </pre>
     * 
     * @param orQuery
     *            The query for or-condition. (NotNull)
     */
    public void orScopeQuery(final OrQuery<AccessResultDataCB> orQuery) {
        xorSQ((AccessResultDataCB) this, orQuery);
    }

    /**
     * Set up the and-part of or-scope. <br />
     * (However nested or-scope query and as-or-split of like-search in and-part
     * are unsupported)
     * 
     * <pre>
     * <span style="color: #3F7E5E">// where (FOO = '...' or (BAR = '...' and QUX = '...'))</span>
     * cb.<span style="color: #FD4747">orScopeQuery</span>(new OrQuery&lt;AccessResultDataCB&gt;() {
     *     public void query(AccessResultDataCB orCB) {
     *         orCB.query().setFOO_Equal...
     *         orCB.<span style="color: #FD4747">orScopeQueryAndPart</span>(new AndQuery&lt;AccessResultDataCB&gt;() {
     *             public void query(AccessResultDataCB andCB) {
     *                 andCB.query().setBar_...
     *                 andCB.query().setQux_...
     *             }
     *         });
     *     }
     * });
     * </pre>
     * 
     * @param andQuery
     *            The query for and-condition. (NotNull)
     */
    public void orScopeQueryAndPart(final AndQuery<AccessResultDataCB> andQuery) {
        xorSQAP((AccessResultDataCB) this, andQuery);
    }

    // ===================================================================================
    // DisplaySQL
    // ==========
    @Override
    protected SqlAnalyzerFactory getSqlAnalyzerFactory() {
        return new ImplementedInvokerAssistant().assistSqlAnalyzerFactory();
    }

    @Override
    protected String getLogDateFormat() {
        return DBFluteConfig.getInstance().getLogDateFormat();
    }

    @Override
    protected String getLogTimestampFormat() {
        return DBFluteConfig.getInstance().getLogTimestampFormat();
    }

    // ===================================================================================
    // Basic Status Determination
    // ==========================
    public boolean hasUnionQueryOrUnionAllQuery() {
        return query().hasUnionQueryOrUnionAllQuery();
    }

    // ===================================================================================
    // Purpose Type
    // ============
    @Override
    protected void xprepareSyncQyCall(final ConditionBean mainCB) {
        final AccessResultDataCB cb;
        if (mainCB != null) {
            cb = (AccessResultDataCB) mainCB;
        } else {
            cb = new AccessResultDataCB();
        }
        specify().xsetSyncQyCall(new HpSpQyCall<AccessResultDataCQ>() {
            public boolean has() {
                return true;
            }

            public AccessResultDataCQ qy() {
                return cb.query();
            }
        });
    }

    // ===================================================================================
    // Internal
    // ========
    // very internal (for suppressing warn about 'Not Use Import')
    protected String getConditionBeanClassNameInternally() {
        return AccessResultDataCB.class.getName();
    }

    protected String getConditionQueryClassNameInternally() {
        return AccessResultDataCQ.class.getName();
    }

    protected String getSubQueryClassNameInternally() {
        return SubQuery.class.getName();
    }

    protected String getConditionOptionClassNameInternally() {
        return ConditionOption.class.getName();
    }
}
