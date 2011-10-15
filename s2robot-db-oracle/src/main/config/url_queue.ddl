CREATE TABLE  "URL_QUEUE" 
   (    "ID" NUMBER(12,0) NOT NULL ENABLE, 
    "SESSION_ID" VARCHAR2(20) NOT NULL ENABLE, 
    "METHOD" VARCHAR2(10) NOT NULL ENABLE, 
    "URL" VARCHAR2(4000) NOT NULL ENABLE, 
    "PARENT_URL" VARCHAR2(4000), 
    "DEPTH" NUMBER(5,0) NOT NULL ENABLE, 
    "LAST_MODIFIED" TIMESTAMP (6), 
    "CREATE_TIME" TIMESTAMP (6) NOT NULL ENABLE, 
     CONSTRAINT "URL_QUEUE_PK" PRIMARY KEY ("ID") ENABLE
   ) ;

CREATE INDEX "URL_QUEUE_UK_SID" ON  "URL_QUEUE" ("SESSION_ID");
CREATE INDEX "URL_QUEUE_UK_SID_TIME" ON  "URL_QUEUE" ("SESSION_ID", "CREATE_TIME");
CREATE INDEX "URL_QUEUE_UK_SID_URL" ON  "URL_QUEUE" ("SESSION_ID", "URL");

CREATE SEQUENCE URL_QUEUE_SEQ START WITH 1 INCREMENT BY 50;

