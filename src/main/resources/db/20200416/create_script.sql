CREATE TABLE IF NOT EXISTS MESSAGE_M (
	message_id INTEGER PRIMARY KEY NOT NULL,
	message_nm VARCHAR(2000) NOT NULL,
	create_user VARCHAR(6) NOT NULL,
  	create_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  	create_pgid VARCHAR(15) NOT NULL,
  	update_user VARCHAR(6) NOT NULL,
  	update_date TIMESTAMP WITH TIME ZONE NOT NULL,
  	update_pgid VARCHAR(15) NOT NULL,
  FOREIGN KEY (create_user) REFERENCES employees_m(man_no),
  FOREIGN KEY (update_user) REFERENCES employees_m(man_no)
);
