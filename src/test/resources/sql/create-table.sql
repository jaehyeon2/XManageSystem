CREATE TABLE IF NOT EXISTS one.admin (
  admin_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  admin_id VARCHAR(100) NOT NULL,
  admin_name VARCHAR(200) NULL,
  admin_email VARCHAR(200) NULL,
  admin_phone VARCHAR(200) NULL,
  admin_pwd VARCHAR(200) NOT NULL,
  admin_auth VARCHAR(2) NOT NULL DEFAULT '1',
  admin_status VARCHAR(2) NULL,
  admin_delete CHAR(1) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (admin_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS one.users (
  user_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id VARCHAR(100) NOT NULL,
  user_name VARCHAR(256) NOT NULL,
  user_email VARCHAR(256) NOT NULL,
  user_phone VARCHAR(256) NOT NULL,
  user_pwd VARCHAR(200) NOT NULL,
  user_company VARCHAR(256),
  user_information VARCHAR(4096),
  user_status VARCHAR(2),
  user_delete CHAR(1),
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (user_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS one.oauth_api_list (
  oal_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  oal_title VARCHAR(256) NOT NULL,
  oal_api_domain VARCHAR(256) NOT NULL,
  oal_information VARCHAR(4096),
  oal_status VARCHAR(2),
  oal_delete CHAR(1),
  admin_id varchar(100) NOT NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (oal_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS one.oauth_client_details (
  ocd_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  ocd_api_key VARCHAR(256),
  ocd_domain VARCHAR(256),
  ocd_name VARCHAR(256) NOT NULL,
  ocd_client_type VARCHAR(50) NULL,
  ocd_client_id VARCHAR(256) NOT NULL,
  ocd_resource_ids VARCHAR(256) NOT NULL,
  ocd_client_secret VARCHAR(256),
  ocd_scope VARCHAR(256),
  ocd_website_uri VARCHAR(256) NULL,
  ocd_redirect_uri VARCHAR(256) NOT NULL,
  ocd_authorities VARCHAR(256),
  ocd_information VARCHAR(4096),
  ocd_status VARCHAR(2),
  ocd_delete CHAR(1),
  ocu_no BIGINT UNSIGNED NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (ocd_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS one.oauth_access_token (
  oat_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  oat_access_token VARCHAR(512) NOT NULL,
  oat_expire_time TIMESTAMP NULL,
  oat_status VARCHAR(2),
  oat_delete CHAR(1),
  ocd_client_id VARCHAR(256) NOT NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (oat_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS one.oauth_refresh_token (
  ort_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  ort_refresh_token VARCHAR(512) NOT NULL,
  ort_expire_time TIMESTAMP NULL,
  ort_status VARCHAR(2),
  ort_delete CHAR(1),
  ocd_client_id VARCHAR(256) NOT NULL,
  oac_authorization_code VARCHAR(256),
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (ort_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS one.oauth_authorization_code (
  oac_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  oac_authorization_code VARCHAR(256) NOT NULL,
  oac_expire_time TIMESTAMP NULL,
  oac_status VARCHAR(2),
  oac_delete CHAR(1),
  ocd_client_id VARCHAR(256) NOT NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (oac_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS one.oauth_allow_ip (
  oai_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  oai_ipaddress VARCHAR(256),
  oai_status VARCHAR(2),
  oai_delete CHAR(1),
  user_id VARCHAR(100) NOT NULL,
  ocd_client_id VARCHAR(256),
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (oai_no)
) ENGINE=innoDB DEFAULT CHARSET=utf8mb4;