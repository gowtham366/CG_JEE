
 CREATE TABLE reacharge_plans
 (
 plan_name VARCHAR2(8) PRIMARY KEY, 
 amount NUMBER(5) NOT NULL
 );

 CREATE TABLE reacharge_history
 (
 rechId NUMBER(5) PRIMARY KEY,
 name VARCHAR2(20),
 email VARCHAR2(20),
 mobile NUMBER(10),
 status VARCHAR2(10),
 plan_name VARCHAR2(8),
 amount NUMBER(5)
 );