DELETE FROM one.admin;
INSERT INTO one.admin (admin_id,admin_name,admin_email,admin_phone,admin_pwd,admin_auth,admin_status,admin_delete,insert_time,update_time) VALUES ('itBscAdmin',HEX(AES_ENCRYPT('BSC관리자', 'test')),HEX(AES_ENCRYPT('snsjoonkim@gmail.com', 'test')),HEX(AES_ENCRYPT('07088928283', 'test')),'$2a$10$t0cTiSxGGLboQY.WMwgQ/uVAcbSiH3aCp2psKgP9J/NhBzU66c6pG','1','0','0',now(),now());

DELETE FROM one.user;
INSERT INTO one.user (user_id,user_name,user_email,user_phone,user_pwd,user_company,user_information,user_status,user_delete,insert_time,update_time) VALUES ('user001', HEX(AES_ENCRYPT('사용자1', 'test')), HEX(AES_ENCRYPT('snsjoonkim@gmail.com', 'test')), HEX(AES_ENCRYPT('07088928283', 'test')), '$2a$10$F48lvu8F1J5X2GFRaI9vreTYeTNu4mrfaMlcsRuBNiU3QSaYzNRMC', '회사1', '설명란', '0', '0', now(), now());
