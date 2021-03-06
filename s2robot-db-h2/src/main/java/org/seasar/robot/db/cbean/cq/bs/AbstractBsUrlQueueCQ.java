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
package org.seasar.robot.db.cbean.cq.bs;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.seasar.dbflute.cbean.AbstractConditionQuery;
import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.ManualOrderBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.chelper.HpQDRFunction;
import org.seasar.dbflute.cbean.chelper.HpSSQFunction;
import org.seasar.dbflute.cbean.chelper.HpSSQOption;
import org.seasar.dbflute.cbean.chelper.HpSSQSetupper;
import org.seasar.dbflute.cbean.ckey.ConditionKey;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.cbean.coption.FromToOption;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.cbean.coption.RangeOfOption;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import org.seasar.robot.db.allcommon.DBMetaInstanceHandler;
import org.seasar.robot.db.cbean.UrlQueueCB;
import org.seasar.robot.db.cbean.cq.UrlQueueCQ;

/**
 * The abstract condition-query of URL_QUEUE.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsUrlQueueCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsUrlQueueCQ(final ConditionQuery referrerQuery,
            final SqlClause sqlClause, final String aliasName,
            final int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                     DBMeta Provider
    //                                                                     ===============
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    @Override
    public String getTableDbName() {
        return "URL_QUEUE";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as equal. (NullAllowed: if null, no condition)
     */
    public void setId_Equal(final Long id) {
        doSetId_Equal(id);
    }

    protected void doSetId_Equal(final Long id) {
        regId(CK_EQ, id);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as notEqual. (NullAllowed: if null, no condition)
     */
    public void setId_NotEqual(final Long id) {
        doSetId_NotEqual(id);
    }

    protected void doSetId_NotEqual(final Long id) {
        regId(CK_NES, id);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setId_GreaterThan(final Long id) {
        regId(CK_GT, id);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as lessThan. (NullAllowed: if null, no condition)
     */
    public void setId_LessThan(final Long id) {
        regId(CK_LT, id);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setId_GreaterEqual(final Long id) {
        regId(CK_GE, id);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setId_LessEqual(final Long id) {
        regId(CK_LE, id);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of id. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of id. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setId_RangeOf(final Long minNumber, final Long maxNumber,
            final RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueId(), "ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param idList The collection of id as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setId_InScope(final Collection<Long> idList) {
        doSetId_InScope(idList);
    }

    protected void doSetId_InScope(final Collection<Long> idList) {
        regINS(CK_INS, cTL(idList), getCValueId(), "ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param idList The collection of id as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setId_NotInScope(final Collection<Long> idList) {
        doSetId_NotInScope(idList);
    }

    protected void doSetId_NotInScope(final Collection<Long> idList) {
        regINS(CK_NINS, cTL(idList), getCValueId(), "ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setId_IsNull() {
        regId(CK_ISN, DOBJ);
    }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setId_IsNotNull() {
        regId(CK_ISNN, DOBJ);
    }

    protected void regId(final ConditionKey ky, final Object vl) {
        regQ(ky, vl, getCValueId(), "ID");
    }

    protected abstract ConditionValue getCValueId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)}
     * @param sessionId The value of sessionId as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setSessionId_Equal(final String sessionId) {
        doSetSessionId_Equal(fRES(sessionId));
    }

    protected void doSetSessionId_Equal(final String sessionId) {
        regSessionId(CK_EQ, sessionId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)}
     * @param sessionId The value of sessionId as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setSessionId_NotEqual(final String sessionId) {
        doSetSessionId_NotEqual(fRES(sessionId));
    }

    protected void doSetSessionId_NotEqual(final String sessionId) {
        regSessionId(CK_NES, sessionId);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)}
     * @param sessionId The value of sessionId as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setSessionId_GreaterThan(final String sessionId) {
        regSessionId(CK_GT, fRES(sessionId));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)}
     * @param sessionId The value of sessionId as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setSessionId_LessThan(final String sessionId) {
        regSessionId(CK_LT, fRES(sessionId));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)}
     * @param sessionId The value of sessionId as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setSessionId_GreaterEqual(final String sessionId) {
        regSessionId(CK_GE, fRES(sessionId));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)}
     * @param sessionId The value of sessionId as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setSessionId_LessEqual(final String sessionId) {
        regSessionId(CK_LE, fRES(sessionId));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)}
     * @param sessionIdList The collection of sessionId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setSessionId_InScope(final Collection<String> sessionIdList) {
        doSetSessionId_InScope(sessionIdList);
    }

    public void doSetSessionId_InScope(final Collection<String> sessionIdList) {
        regINS(CK_INS, cTL(sessionIdList), getCValueSessionId(), "SESSION_ID");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)}
     * @param sessionIdList The collection of sessionId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setSessionId_NotInScope(final Collection<String> sessionIdList) {
        doSetSessionId_NotInScope(sessionIdList);
    }

    public void doSetSessionId_NotInScope(final Collection<String> sessionIdList) {
        regINS(CK_NINS, cTL(sessionIdList), getCValueSessionId(), "SESSION_ID");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)}
     * @param sessionId The value of sessionId as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setSessionId_PrefixSearch(final String sessionId) {
        setSessionId_LikeSearch(sessionId, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)} <br />
     * <pre>e.g. setSessionId_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param sessionId The value of sessionId as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setSessionId_LikeSearch(final String sessionId,
            final LikeSearchOption likeSearchOption) {
        regLSQ(
            CK_LS,
            fRES(sessionId),
            getCValueSessionId(),
            "SESSION_ID",
            likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * SESSION_ID: {IX+, NotNull, VARCHAR(20)}
     * @param sessionId The value of sessionId as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setSessionId_NotLikeSearch(final String sessionId,
            final LikeSearchOption likeSearchOption) {
        regLSQ(
            CK_NLS,
            fRES(sessionId),
            getCValueSessionId(),
            "SESSION_ID",
            likeSearchOption);
    }

    protected void regSessionId(final ConditionKey ky, final Object vl) {
        regQ(ky, vl, getCValueSessionId(), "SESSION_ID");
    }

    protected abstract ConditionValue getCValueSessionId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)}
     * @param method The value of method as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setMethod_Equal(final String method) {
        doSetMethod_Equal(fRES(method));
    }

    protected void doSetMethod_Equal(final String method) {
        regMethod(CK_EQ, method);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)}
     * @param method The value of method as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMethod_NotEqual(final String method) {
        doSetMethod_NotEqual(fRES(method));
    }

    protected void doSetMethod_NotEqual(final String method) {
        regMethod(CK_NES, method);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)}
     * @param method The value of method as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMethod_GreaterThan(final String method) {
        regMethod(CK_GT, fRES(method));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)}
     * @param method The value of method as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMethod_LessThan(final String method) {
        regMethod(CK_LT, fRES(method));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)}
     * @param method The value of method as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMethod_GreaterEqual(final String method) {
        regMethod(CK_GE, fRES(method));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)}
     * @param method The value of method as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMethod_LessEqual(final String method) {
        regMethod(CK_LE, fRES(method));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)}
     * @param methodList The collection of method as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMethod_InScope(final Collection<String> methodList) {
        doSetMethod_InScope(methodList);
    }

    public void doSetMethod_InScope(final Collection<String> methodList) {
        regINS(CK_INS, cTL(methodList), getCValueMethod(), "METHOD");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)}
     * @param methodList The collection of method as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMethod_NotInScope(final Collection<String> methodList) {
        doSetMethod_NotInScope(methodList);
    }

    public void doSetMethod_NotInScope(final Collection<String> methodList) {
        regINS(CK_NINS, cTL(methodList), getCValueMethod(), "METHOD");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)}
     * @param method The value of method as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setMethod_PrefixSearch(final String method) {
        setMethod_LikeSearch(method, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)} <br />
     * <pre>e.g. setMethod_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param method The value of method as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setMethod_LikeSearch(final String method,
            final LikeSearchOption likeSearchOption) {
        regLSQ(
            CK_LS,
            fRES(method),
            getCValueMethod(),
            "METHOD",
            likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * METHOD: {NotNull, VARCHAR(10)}
     * @param method The value of method as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setMethod_NotLikeSearch(final String method,
            final LikeSearchOption likeSearchOption) {
        regLSQ(
            CK_NLS,
            fRES(method),
            getCValueMethod(),
            "METHOD",
            likeSearchOption);
    }

    protected void regMethod(final ConditionKey ky, final Object vl) {
        regQ(ky, vl, getCValueMethod(), "METHOD");
    }

    protected abstract ConditionValue getCValueMethod();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)}
     * @param url The value of url as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setUrl_Equal(final String url) {
        doSetUrl_Equal(fRES(url));
    }

    protected void doSetUrl_Equal(final String url) {
        regUrl(CK_EQ, url);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)}
     * @param url The value of url as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUrl_NotEqual(final String url) {
        doSetUrl_NotEqual(fRES(url));
    }

    protected void doSetUrl_NotEqual(final String url) {
        regUrl(CK_NES, url);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)}
     * @param url The value of url as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUrl_GreaterThan(final String url) {
        regUrl(CK_GT, fRES(url));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)}
     * @param url The value of url as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUrl_LessThan(final String url) {
        regUrl(CK_LT, fRES(url));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)}
     * @param url The value of url as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUrl_GreaterEqual(final String url) {
        regUrl(CK_GE, fRES(url));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)}
     * @param url The value of url as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUrl_LessEqual(final String url) {
        regUrl(CK_LE, fRES(url));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)}
     * @param urlList The collection of url as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUrl_InScope(final Collection<String> urlList) {
        doSetUrl_InScope(urlList);
    }

    public void doSetUrl_InScope(final Collection<String> urlList) {
        regINS(CK_INS, cTL(urlList), getCValueUrl(), "URL");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)}
     * @param urlList The collection of url as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUrl_NotInScope(final Collection<String> urlList) {
        doSetUrl_NotInScope(urlList);
    }

    public void doSetUrl_NotInScope(final Collection<String> urlList) {
        regINS(CK_NINS, cTL(urlList), getCValueUrl(), "URL");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)}
     * @param url The value of url as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setUrl_PrefixSearch(final String url) {
        setUrl_LikeSearch(url, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)} <br />
     * <pre>e.g. setUrl_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param url The value of url as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setUrl_LikeSearch(final String url,
            final LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(url), getCValueUrl(), "URL", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * URL: {NotNull, VARCHAR(65536)}
     * @param url The value of url as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setUrl_NotLikeSearch(final String url,
            final LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(url), getCValueUrl(), "URL", likeSearchOption);
    }

    protected void regUrl(final ConditionKey ky, final Object vl) {
        regQ(ky, vl, getCValueUrl(), "URL");
    }

    protected abstract ConditionValue getCValueUrl();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     * @param metaData The value of metaData as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setMetaData_Equal(final String metaData) {
        doSetMetaData_Equal(fRES(metaData));
    }

    protected void doSetMetaData_Equal(final String metaData) {
        regMetaData(CK_EQ, metaData);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     * @param metaData The value of metaData as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMetaData_NotEqual(final String metaData) {
        doSetMetaData_NotEqual(fRES(metaData));
    }

    protected void doSetMetaData_NotEqual(final String metaData) {
        regMetaData(CK_NES, metaData);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     * @param metaData The value of metaData as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMetaData_GreaterThan(final String metaData) {
        regMetaData(CK_GT, fRES(metaData));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     * @param metaData The value of metaData as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMetaData_LessThan(final String metaData) {
        regMetaData(CK_LT, fRES(metaData));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     * @param metaData The value of metaData as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMetaData_GreaterEqual(final String metaData) {
        regMetaData(CK_GE, fRES(metaData));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     * @param metaData The value of metaData as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMetaData_LessEqual(final String metaData) {
        regMetaData(CK_LE, fRES(metaData));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     * @param metaDataList The collection of metaData as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMetaData_InScope(final Collection<String> metaDataList) {
        doSetMetaData_InScope(metaDataList);
    }

    public void doSetMetaData_InScope(final Collection<String> metaDataList) {
        regINS(CK_INS, cTL(metaDataList), getCValueMetaData(), "META_DATA");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     * @param metaDataList The collection of metaData as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMetaData_NotInScope(final Collection<String> metaDataList) {
        doSetMetaData_NotInScope(metaDataList);
    }

    public void doSetMetaData_NotInScope(final Collection<String> metaDataList) {
        regINS(CK_NINS, cTL(metaDataList), getCValueMetaData(), "META_DATA");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     * @param metaData The value of metaData as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setMetaData_PrefixSearch(final String metaData) {
        setMetaData_LikeSearch(metaData, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * META_DATA: {VARCHAR(65536)} <br />
     * <pre>e.g. setMetaData_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param metaData The value of metaData as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setMetaData_LikeSearch(final String metaData,
            final LikeSearchOption likeSearchOption) {
        regLSQ(
            CK_LS,
            fRES(metaData),
            getCValueMetaData(),
            "META_DATA",
            likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     * @param metaData The value of metaData as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setMetaData_NotLikeSearch(final String metaData,
            final LikeSearchOption likeSearchOption) {
        regLSQ(
            CK_NLS,
            fRES(metaData),
            getCValueMetaData(),
            "META_DATA",
            likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     */
    public void setMetaData_IsNull() {
        regMetaData(CK_ISN, DOBJ);
    }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     */
    public void setMetaData_IsNullOrEmpty() {
        regMetaData(CK_ISNOE, DOBJ);
    }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * META_DATA: {VARCHAR(65536)}
     */
    public void setMetaData_IsNotNull() {
        regMetaData(CK_ISNN, DOBJ);
    }

    protected void regMetaData(final ConditionKey ky, final Object vl) {
        regQ(ky, vl, getCValueMetaData(), "META_DATA");
    }

    protected abstract ConditionValue getCValueMetaData();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     * @param encoding The value of encoding as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setEncoding_Equal(final String encoding) {
        doSetEncoding_Equal(fRES(encoding));
    }

    protected void doSetEncoding_Equal(final String encoding) {
        regEncoding(CK_EQ, encoding);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     * @param encoding The value of encoding as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setEncoding_NotEqual(final String encoding) {
        doSetEncoding_NotEqual(fRES(encoding));
    }

    protected void doSetEncoding_NotEqual(final String encoding) {
        regEncoding(CK_NES, encoding);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     * @param encoding The value of encoding as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setEncoding_GreaterThan(final String encoding) {
        regEncoding(CK_GT, fRES(encoding));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     * @param encoding The value of encoding as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setEncoding_LessThan(final String encoding) {
        regEncoding(CK_LT, fRES(encoding));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     * @param encoding The value of encoding as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setEncoding_GreaterEqual(final String encoding) {
        regEncoding(CK_GE, fRES(encoding));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     * @param encoding The value of encoding as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setEncoding_LessEqual(final String encoding) {
        regEncoding(CK_LE, fRES(encoding));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     * @param encodingList The collection of encoding as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setEncoding_InScope(final Collection<String> encodingList) {
        doSetEncoding_InScope(encodingList);
    }

    public void doSetEncoding_InScope(final Collection<String> encodingList) {
        regINS(CK_INS, cTL(encodingList), getCValueEncoding(), "ENCODING");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     * @param encodingList The collection of encoding as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setEncoding_NotInScope(final Collection<String> encodingList) {
        doSetEncoding_NotInScope(encodingList);
    }

    public void doSetEncoding_NotInScope(final Collection<String> encodingList) {
        regINS(CK_NINS, cTL(encodingList), getCValueEncoding(), "ENCODING");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     * @param encoding The value of encoding as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setEncoding_PrefixSearch(final String encoding) {
        setEncoding_LikeSearch(encoding, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ENCODING: {VARCHAR(20)} <br />
     * <pre>e.g. setEncoding_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param encoding The value of encoding as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setEncoding_LikeSearch(final String encoding,
            final LikeSearchOption likeSearchOption) {
        regLSQ(
            CK_LS,
            fRES(encoding),
            getCValueEncoding(),
            "ENCODING",
            likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     * @param encoding The value of encoding as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setEncoding_NotLikeSearch(final String encoding,
            final LikeSearchOption likeSearchOption) {
        regLSQ(
            CK_NLS,
            fRES(encoding),
            getCValueEncoding(),
            "ENCODING",
            likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     */
    public void setEncoding_IsNull() {
        regEncoding(CK_ISN, DOBJ);
    }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     */
    public void setEncoding_IsNullOrEmpty() {
        regEncoding(CK_ISNOE, DOBJ);
    }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * ENCODING: {VARCHAR(20)}
     */
    public void setEncoding_IsNotNull() {
        regEncoding(CK_ISNN, DOBJ);
    }

    protected void regEncoding(final ConditionKey ky, final Object vl) {
        regQ(ky, vl, getCValueEncoding(), "ENCODING");
    }

    protected abstract ConditionValue getCValueEncoding();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     * @param parentUrl The value of parentUrl as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setParentUrl_Equal(final String parentUrl) {
        doSetParentUrl_Equal(fRES(parentUrl));
    }

    protected void doSetParentUrl_Equal(final String parentUrl) {
        regParentUrl(CK_EQ, parentUrl);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     * @param parentUrl The value of parentUrl as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setParentUrl_NotEqual(final String parentUrl) {
        doSetParentUrl_NotEqual(fRES(parentUrl));
    }

    protected void doSetParentUrl_NotEqual(final String parentUrl) {
        regParentUrl(CK_NES, parentUrl);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     * @param parentUrl The value of parentUrl as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setParentUrl_GreaterThan(final String parentUrl) {
        regParentUrl(CK_GT, fRES(parentUrl));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     * @param parentUrl The value of parentUrl as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setParentUrl_LessThan(final String parentUrl) {
        regParentUrl(CK_LT, fRES(parentUrl));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     * @param parentUrl The value of parentUrl as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setParentUrl_GreaterEqual(final String parentUrl) {
        regParentUrl(CK_GE, fRES(parentUrl));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     * @param parentUrl The value of parentUrl as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setParentUrl_LessEqual(final String parentUrl) {
        regParentUrl(CK_LE, fRES(parentUrl));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     * @param parentUrlList The collection of parentUrl as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setParentUrl_InScope(final Collection<String> parentUrlList) {
        doSetParentUrl_InScope(parentUrlList);
    }

    public void doSetParentUrl_InScope(final Collection<String> parentUrlList) {
        regINS(CK_INS, cTL(parentUrlList), getCValueParentUrl(), "PARENT_URL");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     * @param parentUrlList The collection of parentUrl as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setParentUrl_NotInScope(final Collection<String> parentUrlList) {
        doSetParentUrl_NotInScope(parentUrlList);
    }

    public void doSetParentUrl_NotInScope(final Collection<String> parentUrlList) {
        regINS(CK_NINS, cTL(parentUrlList), getCValueParentUrl(), "PARENT_URL");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     * @param parentUrl The value of parentUrl as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setParentUrl_PrefixSearch(final String parentUrl) {
        setParentUrl_LikeSearch(parentUrl, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)} <br />
     * <pre>e.g. setParentUrl_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param parentUrl The value of parentUrl as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setParentUrl_LikeSearch(final String parentUrl,
            final LikeSearchOption likeSearchOption) {
        regLSQ(
            CK_LS,
            fRES(parentUrl),
            getCValueParentUrl(),
            "PARENT_URL",
            likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     * @param parentUrl The value of parentUrl as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setParentUrl_NotLikeSearch(final String parentUrl,
            final LikeSearchOption likeSearchOption) {
        regLSQ(
            CK_NLS,
            fRES(parentUrl),
            getCValueParentUrl(),
            "PARENT_URL",
            likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     */
    public void setParentUrl_IsNull() {
        regParentUrl(CK_ISN, DOBJ);
    }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     */
    public void setParentUrl_IsNullOrEmpty() {
        regParentUrl(CK_ISNOE, DOBJ);
    }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * PARENT_URL: {VARCHAR(65536)}
     */
    public void setParentUrl_IsNotNull() {
        regParentUrl(CK_ISNN, DOBJ);
    }

    protected void regParentUrl(final ConditionKey ky, final Object vl) {
        regQ(ky, vl, getCValueParentUrl(), "PARENT_URL");
    }

    protected abstract ConditionValue getCValueParentUrl();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * DEPTH: {NotNull, INTEGER(10)}
     * @param depth The value of depth as equal. (NullAllowed: if null, no condition)
     */
    public void setDepth_Equal(final Integer depth) {
        doSetDepth_Equal(depth);
    }

    protected void doSetDepth_Equal(final Integer depth) {
        regDepth(CK_EQ, depth);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * DEPTH: {NotNull, INTEGER(10)}
     * @param depth The value of depth as notEqual. (NullAllowed: if null, no condition)
     */
    public void setDepth_NotEqual(final Integer depth) {
        doSetDepth_NotEqual(depth);
    }

    protected void doSetDepth_NotEqual(final Integer depth) {
        regDepth(CK_NES, depth);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * DEPTH: {NotNull, INTEGER(10)}
     * @param depth The value of depth as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setDepth_GreaterThan(final Integer depth) {
        regDepth(CK_GT, depth);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * DEPTH: {NotNull, INTEGER(10)}
     * @param depth The value of depth as lessThan. (NullAllowed: if null, no condition)
     */
    public void setDepth_LessThan(final Integer depth) {
        regDepth(CK_LT, depth);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * DEPTH: {NotNull, INTEGER(10)}
     * @param depth The value of depth as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setDepth_GreaterEqual(final Integer depth) {
        regDepth(CK_GE, depth);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * DEPTH: {NotNull, INTEGER(10)}
     * @param depth The value of depth as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setDepth_LessEqual(final Integer depth) {
        regDepth(CK_LE, depth);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * DEPTH: {NotNull, INTEGER(10)}
     * @param minNumber The min number of depth. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of depth. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setDepth_RangeOf(final Integer minNumber,
            final Integer maxNumber, final RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueDepth(), "DEPTH", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * DEPTH: {NotNull, INTEGER(10)}
     * @param depthList The collection of depth as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDepth_InScope(final Collection<Integer> depthList) {
        doSetDepth_InScope(depthList);
    }

    protected void doSetDepth_InScope(final Collection<Integer> depthList) {
        regINS(CK_INS, cTL(depthList), getCValueDepth(), "DEPTH");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * DEPTH: {NotNull, INTEGER(10)}
     * @param depthList The collection of depth as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDepth_NotInScope(final Collection<Integer> depthList) {
        doSetDepth_NotInScope(depthList);
    }

    protected void doSetDepth_NotInScope(final Collection<Integer> depthList) {
        regINS(CK_NINS, cTL(depthList), getCValueDepth(), "DEPTH");
    }

    protected void regDepth(final ConditionKey ky, final Object vl) {
        regQ(ky, vl, getCValueDepth(), "DEPTH");
    }

    protected abstract ConditionValue getCValueDepth();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * LAST_MODIFIED: {TIMESTAMP(23, 10)}
     * @param lastModified The value of lastModified as equal. (NullAllowed: if null, no condition)
     */
    public void setLastModified_Equal(final java.sql.Timestamp lastModified) {
        regLastModified(CK_EQ, lastModified);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * LAST_MODIFIED: {TIMESTAMP(23, 10)}
     * @param lastModified The value of lastModified as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setLastModified_GreaterThan(
            final java.sql.Timestamp lastModified) {
        regLastModified(CK_GT, lastModified);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * LAST_MODIFIED: {TIMESTAMP(23, 10)}
     * @param lastModified The value of lastModified as lessThan. (NullAllowed: if null, no condition)
     */
    public void setLastModified_LessThan(final java.sql.Timestamp lastModified) {
        regLastModified(CK_LT, lastModified);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * LAST_MODIFIED: {TIMESTAMP(23, 10)}
     * @param lastModified The value of lastModified as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setLastModified_GreaterEqual(
            final java.sql.Timestamp lastModified) {
        regLastModified(CK_GE, lastModified);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * LAST_MODIFIED: {TIMESTAMP(23, 10)}
     * @param lastModified The value of lastModified as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setLastModified_LessEqual(final java.sql.Timestamp lastModified) {
        regLastModified(CK_LE, lastModified);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * LAST_MODIFIED: {TIMESTAMP(23, 10)}
     * <pre>e.g. setLastModified_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of lastModified. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of lastModified. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setLastModified_FromTo(final Date fromDatetime,
            final Date toDatetime, final FromToOption fromToOption) {
        regFTQ(
            fromDatetime != null ? new java.sql.Timestamp(
                fromDatetime.getTime()) : null,
            toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime())
                : null,
            getCValueLastModified(),
            "LAST_MODIFIED",
            fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * LAST_MODIFIED: {TIMESTAMP(23, 10)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of lastModified. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of lastModified. (NullAllowed: if null, no to-condition)
     */
    public void setLastModified_DateFromTo(final Date fromDate,
            final Date toDate) {
        setLastModified_FromTo(
            fromDate,
            toDate,
            new FromToOption().compareAsDate());
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * LAST_MODIFIED: {TIMESTAMP(23, 10)}
     */
    public void setLastModified_IsNull() {
        regLastModified(CK_ISN, DOBJ);
    }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * LAST_MODIFIED: {TIMESTAMP(23, 10)}
     */
    public void setLastModified_IsNotNull() {
        regLastModified(CK_ISNN, DOBJ);
    }

    protected void regLastModified(final ConditionKey ky, final Object vl) {
        regQ(ky, vl, getCValueLastModified(), "LAST_MODIFIED");
    }

    protected abstract ConditionValue getCValueLastModified();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * CREATE_TIME: {NotNull, TIMESTAMP(23, 10)}
     * @param createTime The value of createTime as equal. (NullAllowed: if null, no condition)
     */
    public void setCreateTime_Equal(final java.sql.Timestamp createTime) {
        regCreateTime(CK_EQ, createTime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * CREATE_TIME: {NotNull, TIMESTAMP(23, 10)}
     * @param createTime The value of createTime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setCreateTime_GreaterThan(final java.sql.Timestamp createTime) {
        regCreateTime(CK_GT, createTime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * CREATE_TIME: {NotNull, TIMESTAMP(23, 10)}
     * @param createTime The value of createTime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setCreateTime_LessThan(final java.sql.Timestamp createTime) {
        regCreateTime(CK_LT, createTime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * CREATE_TIME: {NotNull, TIMESTAMP(23, 10)}
     * @param createTime The value of createTime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setCreateTime_GreaterEqual(final java.sql.Timestamp createTime) {
        regCreateTime(CK_GE, createTime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * CREATE_TIME: {NotNull, TIMESTAMP(23, 10)}
     * @param createTime The value of createTime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setCreateTime_LessEqual(final java.sql.Timestamp createTime) {
        regCreateTime(CK_LE, createTime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * CREATE_TIME: {NotNull, TIMESTAMP(23, 10)}
     * <pre>e.g. setCreateTime_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of createTime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of createTime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setCreateTime_FromTo(final Date fromDatetime,
            final Date toDatetime, final FromToOption fromToOption) {
        regFTQ(
            fromDatetime != null ? new java.sql.Timestamp(
                fromDatetime.getTime()) : null,
            toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime())
                : null,
            getCValueCreateTime(),
            "CREATE_TIME",
            fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * CREATE_TIME: {NotNull, TIMESTAMP(23, 10)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of createTime. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of createTime. (NullAllowed: if null, no to-condition)
     */
    public void setCreateTime_DateFromTo(final Date fromDate, final Date toDate) {
        setCreateTime_FromTo(
            fromDate,
            toDate,
            new FromToOption().compareAsDate());
    }

    protected void regCreateTime(final ConditionKey ky, final Object vl) {
        regQ(ky, vl, getCValueCreateTime(), "CREATE_TIME");
    }

    protected abstract ConditionValue getCValueCreateTime();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;UrlQueueCB&gt;() {
     *     public void query(UrlQueueCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UrlQueueCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand(), UrlQueueCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;UrlQueueCB&gt;() {
     *     public void query(UrlQueueCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UrlQueueCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand(), UrlQueueCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;UrlQueueCB&gt;() {
     *     public void query(UrlQueueCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UrlQueueCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand(), UrlQueueCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;UrlQueueCB&gt;() {
     *     public void query(UrlQueueCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UrlQueueCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand(), UrlQueueCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;UrlQueueCB&gt;() {
     *     public void query(UrlQueueCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UrlQueueCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand(), UrlQueueCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;UrlQueueCB&gt;() {
     *     public void query(UrlQueueCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UrlQueueCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand(), UrlQueueCB.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(final String fn,
            final SubQuery<CB> sq, final String rd, final HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        final UrlQueueCB cb = xcreateScalarConditionCB();
        sq.query((CB) cb);
        final String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB) xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }

    public abstract String keepScalarCondition(UrlQueueCQ sq);

    protected UrlQueueCB xcreateScalarConditionCB() {
        final UrlQueueCB cb = newMyCB();
        cb.xsetupForScalarCondition(this);
        return cb;
    }

    protected UrlQueueCB xcreateScalarConditionPartitionByCB() {
        final UrlQueueCB cb = newMyCB();
        cb.xsetupForScalarConditionPartitionBy(this);
        return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(final String fn, final SubQuery<UrlQueueCB> sq,
            final String al, final DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        final UrlQueueCB cb = new UrlQueueCB();
        cb.xsetupForDerivedReferrer(this);
        try {
            lock();
            sq.query(cb);
        } finally {
            unlock();
        }
        final String pp = keepSpecifyMyselfDerived(cb.query());
        final String pk = "ID";
        registerSpecifyMyselfDerived(
            fn,
            cb.query(),
            pk,
            pk,
            pp,
            "myselfDerived",
            al,
            op);
    }

    public abstract String keepSpecifyMyselfDerived(UrlQueueCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<UrlQueueCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(UrlQueueCB.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(
            final String fn, final SubQuery<CB> sq, final String rd,
            final Object vl, final DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        final UrlQueueCB cb = new UrlQueueCB();
        cb.xsetupForDerivedReferrer(this);
        sq.query((CB) cb);
        final String pk = "ID";
        final String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        final String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(
            fn,
            cb.query(),
            pk,
            pk,
            sqpp,
            "myselfDerived",
            rd,
            vl,
            prpp,
            op);
    }

    public abstract String keepQueryMyselfDerived(UrlQueueCQ sq);

    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfExists(final SubQuery<UrlQueueCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        final UrlQueueCB cb = new UrlQueueCB();
        cb.xsetupForMyselfExists(this);
        try {
            lock();
            subQuery.query(cb);
        } finally {
            unlock();
        }
        final String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }

    public abstract String keepMyselfExists(UrlQueueCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfInScope(final SubQuery<UrlQueueCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        final UrlQueueCB cb = new UrlQueueCB();
        cb.xsetupForMyselfInScope(this);
        try {
            lock();
            subQuery.query(cb);
        } finally {
            unlock();
        }
        final String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }

    public abstract String keepMyselfInScope(UrlQueueCQ sq);

    // ===================================================================================
    //                                                                          Compatible
    //                                                                          ==========
    /**
     * Order along the list of manual values. #beforejava8 <br />
     * This function with Union is unsupported! <br />
     * The order values are bound (treated as bind parameter).
     * <pre>
     * MemberCB cb = new MemberCB();
     * List&lt;CDef.MemberStatus&gt; orderValueList = new ArrayList&lt;CDef.MemberStatus&gt;();
     * orderValueList.add(CDef.MemberStatus.Withdrawal);
     * orderValueList.add(CDef.MemberStatus.Formalized);
     * orderValueList.add(CDef.MemberStatus.Provisional);
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #DD4747">withManualOrder(orderValueList)</span>;
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * @param orderValueList The list of order values for manual ordering. (NotNull)
     */
    public void withManualOrder(final List<? extends Object> orderValueList) { // is user public!
        assertObjectNotNull("withManualOrder(orderValueList)", orderValueList);
        final ManualOrderBean manualOrderBean = new ManualOrderBean();
        manualOrderBean.acceptOrderValueList(orderValueList);
        withManualOrder(manualOrderBean);
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected UrlQueueCB newMyCB() {
        return new UrlQueueCB();
    }

    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() {
        return UrlQueueCQ.class.getName();
    }

    protected String xabLSO() {
        return LikeSearchOption.class.getName();
    }

    protected String xabSSQS() {
        return HpSSQSetupper.class.getName();
    }
}
