create table xm_system.x_group(
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
  	group_nm VARCHAR(100) NOT NULL,
  	group_p_id INTEGER(10),
  	group_deleted char(1),
  	insert_time timestamp,
  	update_time timestamp,
  	PRIMARY KEY(id)
) ENGINE=innoDB CHARSET=utf8;

create table xm_system.x_user(
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	user_no VARCHAR(100),
	user_nm VARCHAR(100),
	user_rank VARCHAR(100),
	user_pos VARCHAR(100),
	user_email VARCHAR(200),
	user_pwd VARCHAR(200),
	user_phone VARCHAR(200),
	group_id INTEGER(10),
	group_nm VARCHAR(100),
	user_deleted CHAR(1),
	insert_time timestamp,
	update_time timestamp,
  	PRIMARY KEY(id)
) ENGINE=innoDB CHARSET=utf8;