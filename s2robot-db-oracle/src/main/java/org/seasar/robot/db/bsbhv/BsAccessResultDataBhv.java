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
package org.seasar.robot.db.bsbhv;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.exception.*;
import org.seasar.dbflute.optional.OptionalEntity;
import org.seasar.dbflute.outsidesql.executor.*;
import org.seasar.robot.db.exbhv.*;
import org.seasar.robot.db.exentity.*;
import org.seasar.robot.db.bsentity.dbmeta.*;
import org.seasar.robot.db.cbean.*;

/**
 * The behavior of ACCESS_RESULT_DATA as TABLE. <br />
 * <pre>
 * [primary key]
 *     ID
 *
 * [column]
 *     ID, TRANSFORMER_NAME, DATA, ENCODING
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     ACCESS_RESULT
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     accessResult
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsAccessResultDataBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    public static final String PATH_deleteAll = "deleteAll";
    public static final String PATH_deleteBySessionId = "deleteBySessionId";
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "ACCESS_RESULT_DATA"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return AccessResultDataDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public AccessResultDataDbm getMyDBMeta() { return AccessResultDataDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public AccessResultData newMyEntity() { return new AccessResultData(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public AccessResultDataCB newMyConditionBean() { return new AccessResultDataCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * AccessResultDataCB cb = new AccessResultDataCB();
     * cb.query().setFoo...(value);
     * int count = accessResultDataBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of AccessResultData. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(AccessResultDataCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(AccessResultDataCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(AccessResultDataCB cb) { // called by selectPage(cb)
        assertCBStateValid(cb);
        return delegateSelectCountPlainly(cb);
    }

    @Override
    protected int doReadCount(ConditionBean cb) {
        return selectCount(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean. #beforejava8 <br />
     * <span style="color: #AD4747; font-size: 120%">The return might be null if no data, so you should have null check.</span> <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, use selectEntityWithDeletedCheck().</span>
     * <pre>
     * AccessResultDataCB cb = new AccessResultDataCB();
     * cb.query().setFoo...(value);
     * AccessResultData accessResultData = accessResultDataBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     * if (accessResultData != null) { <span style="color: #3F7E5E">// null check</span>
     *     ... = accessResultData.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of AccessResultData. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public AccessResultData selectEntity(AccessResultDataCB cb) {
        return doSelectEntity(cb, AccessResultData.class);
    }

    protected <ENTITY extends AccessResultData> ENTITY doSelectEntity(AccessResultDataCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, AccessResultDataCB>() {
            public List<ENTITY> callbackSelectList(AccessResultDataCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends AccessResultData> OptionalEntity<ENTITY> doSelectOptionalEntity(AccessResultDataCB cb, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check. <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, this method is good.</span>
     * <pre>
     * AccessResultDataCB cb = new AccessResultDataCB();
     * cb.query().setFoo...(value);
     * AccessResultData accessResultData = accessResultDataBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = accessResultData.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of AccessResultData. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public AccessResultData selectEntityWithDeletedCheck(AccessResultDataCB cb) {
        return doSelectEntityWithDeletedCheck(cb, AccessResultData.class);
    }

    protected <ENTITY extends AccessResultData> ENTITY doSelectEntityWithDeletedCheck(AccessResultDataCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, AccessResultDataCB>() {
            public List<ENTITY> callbackSelectList(AccessResultDataCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param id : PK, NotNull, NUMBER(19), FK to ACCESS_RESULT. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public AccessResultData selectByPKValue(Long id) {
        return doSelectByPK(id, AccessResultData.class);
    }

    protected <ENTITY extends AccessResultData> ENTITY doSelectByPK(Long id, Class<ENTITY> entityType) {
        return doSelectEntity(xprepareCBAsPK(id), entityType);
    }

    protected <ENTITY extends AccessResultData> OptionalEntity<ENTITY> doSelectOptionalByPK(Long id, Class<ENTITY> entityType) {
        return createOptionalEntity(doSelectByPK(id, entityType), id);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param id : PK, NotNull, NUMBER(19), FK to ACCESS_RESULT. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public AccessResultData selectByPKValueWithDeletedCheck(Long id) {
        return doSelectByPKWithDeletedCheck(id, AccessResultData.class);
    }

    protected <ENTITY extends AccessResultData> ENTITY doSelectByPKWithDeletedCheck(Long id, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(xprepareCBAsPK(id), entityType);
    }

    protected AccessResultDataCB xprepareCBAsPK(Long id) {
        assertObjectNotNull("id", id);
        AccessResultDataCB cb = newMyConditionBean(); cb.acceptPrimaryKey(id);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * AccessResultDataCB cb = new AccessResultDataCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;AccessResultData&gt; accessResultDataList = accessResultDataBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (AccessResultData accessResultData : accessResultDataList) {
     *     ... = accessResultData.get...();
     * }
     * </pre>
     * @param cb The condition-bean of AccessResultData. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<AccessResultData> selectList(AccessResultDataCB cb) {
        return doSelectList(cb, AccessResultData.class);
    }

    protected <ENTITY extends AccessResultData> ListResultBean<ENTITY> doSelectList(AccessResultDataCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, AccessResultDataCB>() {
            public List<ENTITY> callbackSelectList(AccessResultDataCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
    }

    @Override
    protected ListResultBean<? extends Entity> doReadList(ConditionBean cb) {
        return selectList(downcast(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result bean. <br />
     * (both count-select and paging-select are executed)
     * <pre>
     * AccessResultDataCB cb = new AccessResultDataCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;AccessResultData&gt; page = accessResultDataBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (AccessResultData accessResultData : page) {
     *     ... = accessResultData.get...();
     * }
     * </pre>
     * @param cb The condition-bean of AccessResultData. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<AccessResultData> selectPage(AccessResultDataCB cb) {
        return doSelectPage(cb, AccessResultData.class);
    }

    protected <ENTITY extends AccessResultData> PagingResultBean<ENTITY> doSelectPage(AccessResultDataCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, AccessResultDataCB>() {
            public int callbackSelectCount(AccessResultDataCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(AccessResultDataCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    @Override
    protected PagingResultBean<? extends Entity> doReadPage(ConditionBean cb) {
        return selectPage(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * AccessResultDataCB cb = new AccessResultDataCB();
     * cb.query().setFoo...(value);
     * accessResultDataBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;AccessResultData&gt;() {
     *     public void handle(AccessResultData entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of AccessResultData. (NotNull)
     * @param entityRowHandler The handler of entity row of AccessResultData. (NotNull)
     */
    public void selectCursor(AccessResultDataCB cb, EntityRowHandler<AccessResultData> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, AccessResultData.class);
    }

    protected <ENTITY extends AccessResultData> void doSelectCursor(AccessResultDataCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, AccessResultDataCB>() {
            public void callbackSelectCursor(AccessResultDataCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) { delegateSelectCursor(cb, handler, tp); }
            public List<ENTITY> callbackSelectList(AccessResultDataCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * accessResultDataBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(AccessResultDataCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<AccessResultDataCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends AccessResultDataCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends AccessResultDataCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
        return new SLFunction<CB, RESULT>(cb, tp);
    }

    protected <RESULT> SLFunction<? extends ConditionBean, RESULT> doReadScalar(Class<RESULT> tp) {
        return doScalarSelect(tp, newMyConditionBean());
    }

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    @Override
    protected Number doReadNextVal() {
        String msg = "This table is NOT related to sequence: " + getTableDbName();
        throw new UnsupportedOperationException(msg);
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'AccessResult'.
     * @param accessResultDataList The list of accessResultData. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<AccessResult> pulloutAccessResult(List<AccessResultData> accessResultDataList) {
        return helpPulloutInternally(accessResultDataList, new InternalPulloutCallback<AccessResultData, AccessResult>() {
            public AccessResult getFr(AccessResultData et)
            { return et.getAccessResult(); }
            public boolean hasRf() { return true; }
            public void setRfLs(AccessResult et, List<AccessResultData> ls)
            { if (!ls.isEmpty()) { et.setAccessResultDataAsOne(ls.get(0)); } }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key id.
     * @param accessResultDataList The list of accessResultData. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractIdList(List<AccessResultData> accessResultDataList) {
        return helpExtractListInternally(accessResultDataList, new InternalExtractCallback<AccessResultData, Long>() {
            public Long getCV(AccessResultData et) { return et.getId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * AccessResultData accessResultData = new AccessResultData();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * accessResultData.setFoo...(value);
     * accessResultData.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//accessResultData.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//accessResultData.set...;</span>
     * accessResultDataBhv.<span style="color: #DD4747">insert</span>(accessResultData);
     * ... = accessResultData.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param accessResultData The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(AccessResultData accessResultData) {
        doInsert(accessResultData, null);
    }

    protected void doInsert(AccessResultData accessResultData, InsertOption<AccessResultDataCB> op) {
        assertObjectNotNull("accessResultData", accessResultData);
        prepareInsertOption(op);
        delegateInsert(accessResultData, op);
    }

    protected void prepareInsertOption(InsertOption<AccessResultDataCB> op) {
        if (op == null) { return; }
        assertInsertOptionStatus(op);
        if (op.hasSpecifiedInsertColumn()) {
            op.resolveInsertColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    @Override
    protected void doCreate(Entity et, InsertOption<? extends ConditionBean> op) {
        if (op == null) { insert(downcast(et)); }
        else { varyingInsert(downcast(et), downcast(op)); }
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * AccessResultData accessResultData = new AccessResultData();
     * accessResultData.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * accessResultData.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//accessResultData.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//accessResultData.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * accessResultData.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     accessResultDataBhv.<span style="color: #DD4747">update</span>(accessResultData);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param accessResultData The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final AccessResultData accessResultData) {
        doUpdate(accessResultData, null);
    }

    protected void doUpdate(AccessResultData accessResultData, final UpdateOption<AccessResultDataCB> op) {
        assertObjectNotNull("accessResultData", accessResultData);
        prepareUpdateOption(op);
        helpUpdateInternally(accessResultData, new InternalUpdateCallback<AccessResultData>() {
            public int callbackDelegateUpdate(AccessResultData et) { return delegateUpdate(et, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<AccessResultDataCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) {
            op.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (op.hasSpecifiedUpdateColumn()) {
            op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected AccessResultDataCB createCBForVaryingUpdate() {
        AccessResultDataCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected AccessResultDataCB createCBForSpecifiedUpdate() {
        AccessResultDataCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(Entity et, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { update(downcast(et)); }
        else { varyingUpdate(downcast(et), downcast(op)); }
    }

    @Override
    protected void doModifyNonstrict(Entity et, UpdateOption<? extends ConditionBean> op) {
        doModify(et, op);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param accessResultData The entity of insert or update target. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(AccessResultData accessResultData) {
        doInesrtOrUpdate(accessResultData, null, null);
    }

    protected void doInesrtOrUpdate(AccessResultData accessResultData, final InsertOption<AccessResultDataCB> iop, final UpdateOption<AccessResultDataCB> uop) {
        helpInsertOrUpdateInternally(accessResultData, new InternalInsertOrUpdateCallback<AccessResultData, AccessResultDataCB>() {
            public void callbackInsert(AccessResultData et) { doInsert(et, iop); }
            public void callbackUpdate(AccessResultData et) { doUpdate(et, uop); }
            public AccessResultDataCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(AccessResultDataCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdate(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<AccessResultDataCB>();
            uop = uop != null ? uop : new UpdateOption<AccessResultDataCB>();
            varyingInsertOrUpdate(downcast(et), downcast(iop), downcast(uop));
        }
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        doCreateOrModify(et, iop, uop);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * AccessResultData accessResultData = new AccessResultData();
     * accessResultData.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * accessResultData.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     accessResultDataBhv.<span style="color: #DD4747">delete</span>(accessResultData);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param accessResultData The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(AccessResultData accessResultData) {
        doDelete(accessResultData, null);
    }

    protected void doDelete(AccessResultData accessResultData, final DeleteOption<AccessResultDataCB> op) {
        assertObjectNotNull("accessResultData", accessResultData);
        prepareDeleteOption(op);
        helpDeleteInternally(accessResultData, new InternalDeleteCallback<AccessResultData>() {
            public int callbackDelegateDelete(AccessResultData et) { return delegateDelete(et, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<AccessResultDataCB> op) {
        if (op == null) { return; }
        assertDeleteOptionStatus(op);
    }

    @Override
    protected void doRemove(Entity et, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { delete(downcast(et)); }
        else { varyingDelete(downcast(et), downcast(op)); }
    }

    @Override
    protected void doRemoveNonstrict(Entity et, DeleteOption<? extends ConditionBean> op) {
        doRemove(et, op);
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list modified-only of same-set columns. (DefaultConstraintsEnabled) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <p><span style="color: #DD4747; font-size: 120%">The columns of least common multiple are registered like this:</span></p>
     * <pre>
     * for (... : ...) {
     *     AccessResultData accessResultData = new AccessResultData();
     *     accessResultData.setFooName("foo");
     *     if (...) {
     *         accessResultData.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     accessResultDataList.add(accessResultData);
     * }
     * accessResultDataBhv.<span style="color: #DD4747">batchInsert</span>(accessResultDataList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param accessResultDataList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<AccessResultData> accessResultDataList) {
        InsertOption<AccessResultDataCB> op = createInsertUpdateOption();
        return doBatchInsert(accessResultDataList, op);
    }

    protected int[] doBatchInsert(List<AccessResultData> accessResultDataList, InsertOption<AccessResultDataCB> op) {
        assertObjectNotNull("accessResultDataList", accessResultDataList);
        prepareBatchInsertOption(accessResultDataList, op);
        return delegateBatchInsert(accessResultDataList, op);
    }

    protected void prepareBatchInsertOption(List<AccessResultData> accessResultDataList, InsertOption<AccessResultDataCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(accessResultDataList);
        prepareInsertOption(op);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> op) {
        if (op == null) { return batchInsert(downcast(ls)); }
        else { return varyingBatchInsert(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     AccessResultData accessResultData = new AccessResultData();
     *     accessResultData.setFooName("foo");
     *     if (...) {
     *         accessResultData.setFooPrice(123);
     *     } else {
     *         accessResultData.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//accessResultData.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     accessResultDataList.add(accessResultData);
     * }
     * accessResultDataBhv.<span style="color: #DD4747">batchUpdate</span>(accessResultDataList);
     * </pre>
     * @param accessResultDataList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<AccessResultData> accessResultDataList) {
        UpdateOption<AccessResultDataCB> op = createPlainUpdateOption();
        return doBatchUpdate(accessResultDataList, op);
    }

    protected int[] doBatchUpdate(List<AccessResultData> accessResultDataList, UpdateOption<AccessResultDataCB> op) {
        assertObjectNotNull("accessResultDataList", accessResultDataList);
        prepareBatchUpdateOption(accessResultDataList, op);
        return delegateBatchUpdate(accessResultDataList, op);
    }

    protected void prepareBatchUpdateOption(List<AccessResultData> accessResultDataList, UpdateOption<AccessResultDataCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(accessResultDataList);
        prepareUpdateOption(op);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return batchUpdate(downcast(ls)); }
        else { return varyingBatchUpdate(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * accessResultDataBhv.<span style="color: #DD4747">batchUpdate</span>(accessResultDataList, new SpecifyQuery<AccessResultDataCB>() {
     *     public void specify(AccessResultDataCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * accessResultDataBhv.<span style="color: #DD4747">batchUpdate</span>(accessResultDataList, new SpecifyQuery<AccessResultDataCB>() {
     *     public void specify(AccessResultDataCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param accessResultDataList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<AccessResultData> accessResultDataList, SpecifyQuery<AccessResultDataCB> updateColumnSpec) {
        return doBatchUpdate(accessResultDataList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param accessResultDataList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<AccessResultData> accessResultDataList) {
        return doBatchDelete(accessResultDataList, null);
    }

    protected int[] doBatchDelete(List<AccessResultData> accessResultDataList, DeleteOption<AccessResultDataCB> op) {
        assertObjectNotNull("accessResultDataList", accessResultDataList);
        prepareDeleteOption(op);
        return delegateBatchDelete(accessResultDataList, op);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(op)); }
    }

    @Override
    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        return doLumpRemove(ls, op);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * accessResultDataBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;AccessResultData, AccessResultDataCB&gt;() {
     *     public ConditionBean setup(accessResultData entity, AccessResultDataCB intoCB) {
     *         FooCB cb = FooCB();
     *         cb.setupSelect_Bar();
     *
     *         <span style="color: #3F7E5E">// mapping</span>
     *         intoCB.specify().columnMyName().mappedFrom(cb.specify().columnFooName());
     *         intoCB.specify().columnMyCount().mappedFrom(cb.specify().columnFooCount());
     *         intoCB.specify().columnMyDate().mappedFrom(cb.specify().specifyBar().columnBarDate());
     *         entity.setMyFixedValue("foo"); <span style="color: #3F7E5E">// fixed value</span>
     *         <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     *         <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     *         <span style="color: #3F7E5E">//entity.set...;</span>
     *         <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     *
     *         return cb;
     *     }
     * });
     * </pre>
     * @param setupper The setup-per of query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(QueryInsertSetupper<AccessResultData, AccessResultDataCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<AccessResultData, AccessResultDataCB> sp, InsertOption<AccessResultDataCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        AccessResultData e = new AccessResultData();
        AccessResultDataCB cb = createCBForQueryInsert();
        return delegateQueryInsert(e, cb, sp.setup(e, cb), op);
    }

    protected AccessResultDataCB createCBForQueryInsert() {
        AccessResultDataCB cb = newMyConditionBean();
        cb.xsetupForQueryInsert();
        return cb;
    }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> option) {
        if (option == null) { return queryInsert(downcast(setupper)); }
        else { return varyingQueryInsert(downcast(setupper), downcast(option)); }
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * AccessResultData accessResultData = new AccessResultData();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//accessResultData.setPK...(value);</span>
     * accessResultData.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//accessResultData.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//accessResultData.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//accessResultData.setVersionNo(value);</span>
     * AccessResultDataCB cb = new AccessResultDataCB();
     * cb.query().setFoo...(value);
     * accessResultDataBhv.<span style="color: #DD4747">queryUpdate</span>(accessResultData, cb);
     * </pre>
     * @param accessResultData The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of AccessResultData. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(AccessResultData accessResultData, AccessResultDataCB cb) {
        return doQueryUpdate(accessResultData, cb, null);
    }

    protected int doQueryUpdate(AccessResultData accessResultData, AccessResultDataCB cb, UpdateOption<AccessResultDataCB> op) {
        assertObjectNotNull("accessResultData", accessResultData); assertCBStateValid(cb);
        prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(accessResultData, cb, op) : 0;
    }

    @Override
    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return queryUpdate(downcast(et), (AccessResultDataCB)cb); }
        else { return varyingQueryUpdate(downcast(et), (AccessResultDataCB)cb, downcast(op)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * AccessResultDataCB cb = new AccessResultDataCB();
     * cb.query().setFoo...(value);
     * accessResultDataBhv.<span style="color: #DD4747">queryDelete</span>(accessResultData, cb);
     * </pre>
     * @param cb The condition-bean of AccessResultData. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(AccessResultDataCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(AccessResultDataCB cb, DeleteOption<AccessResultDataCB> op) {
        assertCBStateValid(cb);
        prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return queryDelete((AccessResultDataCB)cb); }
        else { return varyingQueryDelete((AccessResultDataCB)cb, downcast(op)); }
    }

    // ===================================================================================
    //                                                                      Varying Update
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Entity Update
    //                                         -------------
    /**
     * Insert the entity with varying requests. <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as insert(entity).
     * <pre>
     * AccessResultData accessResultData = new AccessResultData();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * accessResultData.setFoo...(value);
     * accessResultData.setBar...(value);
     * InsertOption<AccessResultDataCB> option = new InsertOption<AccessResultDataCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * accessResultDataBhv.<span style="color: #DD4747">varyingInsert</span>(accessResultData, option);
     * ... = accessResultData.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param accessResultData The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(AccessResultData accessResultData, InsertOption<AccessResultDataCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(accessResultData, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * AccessResultData accessResultData = new AccessResultData();
     * accessResultData.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * accessResultData.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * accessResultData.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;AccessResultDataCB&gt; option = new UpdateOption&lt;AccessResultDataCB&gt;();
     *     option.self(new SpecifyQuery&lt;AccessResultDataCB&gt;() {
     *         public void specify(AccessResultDataCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     accessResultDataBhv.<span style="color: #DD4747">varyingUpdate</span>(accessResultData, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param accessResultData The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(AccessResultData accessResultData, UpdateOption<AccessResultDataCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(accessResultData, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param accessResultData The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(AccessResultData accessResultData, InsertOption<AccessResultDataCB> insertOption, UpdateOption<AccessResultDataCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(accessResultData, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param accessResultData The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(AccessResultData accessResultData, DeleteOption<AccessResultDataCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(accessResultData, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param accessResultDataList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<AccessResultData> accessResultDataList, InsertOption<AccessResultDataCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(accessResultDataList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param accessResultDataList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<AccessResultData> accessResultDataList, UpdateOption<AccessResultDataCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(accessResultDataList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param accessResultDataList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<AccessResultData> accessResultDataList, DeleteOption<AccessResultDataCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(accessResultDataList, option);
    }

    // -----------------------------------------------------
    //                                          Query Update
    //                                          ------------
    /**
     * Insert the several entities by query with varying requests (modified-only for fixed value). <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as queryInsert(entity, setupper).
     * @param setupper The setup-per of query-insert. (NotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The inserted count.
     */
    public int varyingQueryInsert(QueryInsertSetupper<AccessResultData, AccessResultDataCB> setupper, InsertOption<AccessResultDataCB> option) {
        assertInsertOptionNotNull(option);
        return doQueryInsert(setupper, option);
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br />
     * Other specifications are same as queryUpdate(entity, cb).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * AccessResultData accessResultData = new AccessResultData();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//accessResultData.setPK...(value);</span>
     * accessResultData.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//accessResultData.setVersionNo(value);</span>
     * AccessResultDataCB cb = new AccessResultDataCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;AccessResultDataCB&gt; option = new UpdateOption&lt;AccessResultDataCB&gt;();
     * option.self(new SpecifyQuery&lt;AccessResultDataCB&gt;() {
     *     public void specify(AccessResultDataCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * accessResultDataBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(accessResultData, cb, option);
     * </pre>
     * @param accessResultData The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of AccessResultData. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(AccessResultData accessResultData, AccessResultDataCB cb, UpdateOption<AccessResultDataCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(accessResultData, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of AccessResultData. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(AccessResultDataCB cb, DeleteOption<AccessResultDataCB> option) {
        assertDeleteOptionNotNull(option);
        return doQueryDelete(cb, option);
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the basic executor of outside-SQL to execute it. <br />
     * The invoker of behavior command should be not null when you call this method.
     * <pre>
     * You can use the methods for outside-SQL are as follows:
     * {Basic}
     *   o selectList()
     *   o execute()
     *   o call()
     *
     * {Entity}
     *   o entityHandling().selectEntity()
     *   o entityHandling().selectEntityWithDeletedCheck()
     *
     * {Paging}
     *   o autoPaging().selectList()
     *   o autoPaging().selectPage()
     *   o manualPaging().selectList()
     *   o manualPaging().selectPage()
     *
     * {Cursor}
     *   o cursorHandling().selectCursor()
     *
     * {Option}
     *   o dynamicBinding().selectList()
     *   o removeBlockComment().selectList()
     *   o removeLineComment().selectList()
     *   o formatSql().selectList()
     * </pre>
     * @return The basic executor of outside-SQL. (NotNull)
     */
    public OutsideSqlBasicExecutor<AccessResultDataBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(AccessResultDataCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(AccessResultDataCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends AccessResultData> void delegateSelectCursor(AccessResultDataCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends AccessResultData> List<ENTITY> delegateSelectList(AccessResultDataCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(AccessResultData et, InsertOption<AccessResultDataCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(AccessResultData et, UpdateOption<AccessResultDataCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(AccessResultData et, UpdateOption<AccessResultDataCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(AccessResultData et, DeleteOption<AccessResultDataCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(AccessResultData et, DeleteOption<AccessResultDataCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<AccessResultData> ls, InsertOption<AccessResultDataCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<AccessResultData> ls, UpdateOption<AccessResultDataCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<AccessResultData> ls, UpdateOption<AccessResultDataCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<AccessResultData> ls, DeleteOption<AccessResultDataCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<AccessResultData> ls, DeleteOption<AccessResultDataCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(AccessResultData et, AccessResultDataCB inCB, ConditionBean resCB, InsertOption<AccessResultDataCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(AccessResultData et, AccessResultDataCB cb, UpdateOption<AccessResultDataCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(AccessResultDataCB cb, DeleteOption<AccessResultDataCB> op)
    { if (!processBeforeQueryDelete(cb, op)) { return 0; } return invoke(createQueryDeleteCBCommand(cb, op));  }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(Entity et) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasUpdateDateValue(Entity et) {
        return false;
    }

    // ===================================================================================
    //                                                                     Downcast Helper
    //                                                                     ===============
    protected AccessResultData downcast(Entity et) {
        return helpEntityDowncastInternally(et, AccessResultData.class);
    }

    protected AccessResultDataCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, AccessResultDataCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<AccessResultData> downcast(List<? extends Entity> ls) {
        return (List<AccessResultData>)ls;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<AccessResultDataCB> downcast(InsertOption<? extends ConditionBean> op) {
        return (InsertOption<AccessResultDataCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<AccessResultDataCB> downcast(UpdateOption<? extends ConditionBean> op) {
        return (UpdateOption<AccessResultDataCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<AccessResultDataCB> downcast(DeleteOption<? extends ConditionBean> op) {
        return (DeleteOption<AccessResultDataCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<AccessResultData, AccessResultDataCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp) {
        return (QueryInsertSetupper<AccessResultData, AccessResultDataCB>)sp;
    }
}
