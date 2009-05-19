DROP TABLE ACCESS_RESULT_DATA;
DROP TABLE ACCESS_RESULT;
DROP TABLE URL_QUEUE;

/**********************************/
/* Table Name: URL Queue */
/**********************************/
CREATE TABLE URL_QUEUE(
  ID IDENTITY NOT NULL PRIMARY KEY,
  SESSION_ID VARCHAR(20) NOT NULL,
  METHOD VARCHAR(10) NOT NULL,
  URL VARCHAR(65536) NOT NULL,
  PARENT_URL VARCHAR(65536),
  DEPTH INTEGER NOT NULL,
  CREATE_TIME TIMESTAMP NOT NULL
);

/**********************************/
/* Table Name: Access Result */
/**********************************/
CREATE TABLE ACCESS_RESULT(
  ID IDENTITY NOT NULL PRIMARY KEY,
  SESSION_ID VARCHAR(20) NOT NULL,
  RULE_ID VARCHAR(20),
  URL VARCHAR(65536) NOT NULL,
  PARENT_URL VARCHAR(65536),
  STATUS INTEGER NOT NULL,
  HTTP_STATUS_CODE INTEGER NOT NULL,
  METHOD VARCHAR(10) NOT NULL,
  MIME_TYPE VARCHAR(100) NOT NULL,
  EXECUTION_TIME INTEGER NOT NULL,
  CREATE_TIME TIMESTAMP NOT NULL
);

/**********************************/
/* Table Name: Access Result Data */
/**********************************/
CREATE TABLE ACCESS_RESULT_DATA(
  ID BIGINT(20) NOT NULL PRIMARY KEY,
  TRANSFORMER_NAME VARCHAR(255) NOT NULL,
  DATA CLOB,
  FOREIGN KEY (ID) REFERENCES ACCESS_RESULT (ID)
);


CREATE INDEX IDX_URL_QUEUE_SESSION_ID_AND_TIME ON URL_QUEUE (SESSION_ID, CREATE_TIME);

CREATE INDEX IDX_ROBOT_DATA_SESSION_ID_AND_TIME ON ACCESS_RESULT (SESSION_ID, CREATE_TIME);
CREATE INDEX IDX_ROBOT_DATA_SESSION_ID_AND_URL ON ACCESS_RESULT (SESSION_ID, URL);

