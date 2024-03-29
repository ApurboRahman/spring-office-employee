CREATE TABLE IF NOT EXISTS EMPLOYEES_M (
       EMPLOYEE_ID VARCHAR(6) PRIMARY KEY NOT NULL,
       FIRST_NAME VARCHAR(25) NOT NULL,
       LAST_NAME VARCHAR(25) NOT NULL,
       GRADE_CODE VARCHAR(2) NOT NULL,
       POST_CODE VARCHAR(4) NOT NULL,
       DEPT_CODE VARCHAR(6) NOT NULL,
       SEX CHAR(1) NOT NULL,
       UNION_NAME VARCHAR(8) NOT NULL,
       JOINING_DATE DATE NOT NULL,
       RETIRE_DATE DATE  NULL,
       DELETE_FLG VARCHAR(1),
       MAIL_ADDRESS VARCHAR(100),
       COMM_CODE BOOLEAN DEFAULT FALSE,
       MANAGE_FLG CHAR(1),
       CREATE_USER VARCHAR(6),
       CREATE_DATE TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
       CREATE_PGID VARCHAR(15),
       UPDATE_USER VARCHAR(6),
       UPDATE_DATE TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
       UPDATE_PGID VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS USERS_ACCOUNT(
		USER_NAME VARCHAR(6) PRIMARY KEY NOT NULL,
	 	PASSWORD VARCHAR(255) NOT NULL,
		PWD_CHANGE_DATE DATE NOT NULL,
		VALIDATE_START_DATE DATE NOT NULL,
		VALIDATE_END_DATE DATE NOT NULL,
		ACTIVE BOOLEAN,
		DELETE BOOLEAN,
		CREATE_USER VARCHAR(6),
		CREATE_DATE TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
		CREATE_PGID VARCHAR(6),
		UPDATE_USER VARCHAR(6),
		UPDATE_DATE TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
		UPDATE_PGID VARCHAR(6)
);

CREATE TABLE IF NOT EXISTS system_params (
  param_id VARCHAR(10) PRIMARY KEY NOT NULL,
  param_nm1 VARCHAR(20),
  param_nm2 VARCHAR(20),
  param_nm3 VARCHAR(20),
  param_nm4 VARCHAR(20),
  param_cd1 TEXT,
  param_cd2 TEXT,
  param_cd3 TEXT,
  param_cd4 TEXT,
  param_date1 TIMESTAMP WITH TIME ZONE,
  param_date2 TIMESTAMP WITH TIME ZONE,
  param_date3 TIMESTAMP WITH TIME ZONE,
  param_date4 TIMESTAMP WITH TIME ZONE,
  create_user VARCHAR(6) NOT NULL,
  create_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  create_pgid VARCHAR(15) NOT NULL,
  update_user VARCHAR(6) NOT NULL,
  update_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  update_pgid VARCHAR(15) NOT NULL
);