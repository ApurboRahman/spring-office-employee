
CREATE TABLE IF NOT EXISTS cards_chk (
  period_month DATE NOT NULL,
  EMPLOYEE_ID CHAR(6) NOT NULL,
  work_nm VARCHAR(200),
  place_nm VARCHAR(200),
  empcard_flg CHAR(1),
  card1_flg CHAR(1),
  card2_flg CHAR(1),
  card3_flg CHAR(1),
  card4_flg CHAR(1),
  card5_flg CHAR(1),
  card6_flg CHAR(1),
  card7_flg CHAR(1),
  chk_user VARCHAR(6),
  chk_date TIMESTAMP WITH TIME ZONE,
  approval_user VARCHAR(6),
  approval_date TIMESTAMP WITH TIME ZONE,
  notes TEXT,
  chk_flg CHAR(1),
  approval_flg CHAR(1),
  edit_flg CHAR(1),
  create_user VARCHAR(6) NOT NULL,
  create_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  create_pgid VARCHAR(15) NOT NULL,
  update_user VARCHAR(6) NOT NULL,
  update_date TIMESTAMP WITH TIME ZONE NOT NULL,
  update_pgid VARCHAR(15) NOT NULL,
  PRIMARY KEY(period_month, EMPLOYEE_ID),
  FOREIGN KEY (create_user) REFERENCES employees_m(EMPLOYEE_ID),
  FOREIGN KEY (update_user) REFERENCES employees_m(EMPLOYEE_ID)
);


CREATE TABLE IF NOT EXISTS dongles_chk (
  period_month DATE NOT NULL,
  EMPLOYEE_ID CHAR(6) NOT NULL,
  manage_num VARCHAR(100) NOT NULL,
  effective_date TIMESTAMP WITH TIME ZONE,
  return_date TIMESTAMP WITH TIME ZONE,
  chk_user VARCHAR(6),
  chk_date TIMESTAMP WITH TIME ZONE,
  approval_user VARCHAR(6),
  approval_date TIMESTAMP WITH TIME ZONE,
  notes TEXT,
  chk_flg CHAR(1),
  approval_flg CHAR(1),
  edit_flg CHAR(1),
  create_user VARCHAR(6) NOT NULL,
  create_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  create_pgid VARCHAR(15) NOT NULL,
  update_user VARCHAR(6) NOT NULL,
  update_date TIMESTAMP WITH TIME ZONE NOT NULL,
  update_pgid VARCHAR(15) NOT NULL,
  PRIMARY KEY(period_month, EMPLOYEE_ID, manage_num),
  FOREIGN KEY (create_user) REFERENCES employees_m(EMPLOYEE_ID),
  FOREIGN KEY (update_user) REFERENCES employees_m(EMPLOYEE_ID)
);
