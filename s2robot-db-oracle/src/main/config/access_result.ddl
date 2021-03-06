CREATE TABLE  "ACCESS_RESULT" 
   (    "ID" NUMBER(19,0) NOT NULL ENABLE, 
    "SESSION_ID" VARCHAR2(20) NOT NULL ENABLE, 
    "RULE_ID" VARCHAR2(20), 
    "URL" VARCHAR2(4000) NOT NULL ENABLE, 
    "PARENT_URL" VARCHAR2(4000), 
    "STATUS" NUMBER(4,0) NOT NULL ENABLE, 
    "HTTP_STATUS_CODE" NUMBER(4,0) NOT NULL ENABLE, 
    "METHOD" VARCHAR2(10) NOT NULL ENABLE, 
    "MIME_TYPE" VARCHAR2(100) NOT NULL ENABLE, 
    "CONTENT_LENGTH" NUMBER(19,0) NOT NULL ENABLE, 
    "EXECUTION_TIME" NUMBER(9,0) NOT NULL ENABLE, 
    "LAST_MODIFIED" TIMESTAMP (6) NOT NULL ENABLE, 
    "CREATE_TIME" TIMESTAMP (6) NOT NULL ENABLE, 
     CONSTRAINT "ACCESS_RESULT_PK" PRIMARY KEY ("ID") ENABLE
   ) ;

CREATE INDEX "ACCESS_RESULT_UK_SID" ON "ACCESS_RESULT" ("SESSION_ID");
CREATE INDEX "ACCESS_RESULT_UK_SID_TIME" ON "ACCESS_RESULT" ("SESSION_ID", "CREATE_TIME");
CREATE INDEX "ACCESS_RESULT_UK_SID_URL" ON "ACCESS_RESULT" ("SESSION_ID", "URL");
CREATE INDEX "ACCESS_RESULT_UK_URL_TIME" ON "ACCESS_RESULT" ("URL", "CREATE_TIME");

CREATE SEQUENCE ACCESS_RESULT_SEQ START WITH 1 INCREMENT BY 50;
