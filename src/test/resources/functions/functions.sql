CREATE ALIAS IF NOT EXISTS LAST_INSERT_ID_MAX AS '

@CODE
int lastInsertIdMax(int id) throws Exception {
    return id;
}
';

CREATE ALIAS IF NOT EXISTS DATE_FORMAT AS '

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
@CODE
String dateFormat(String date) throws Exception {
	String defaultFormat = "yyyy-MM";
	SimpleDateFormat sdf = new SimpleDateFormat(defaultFormat);
	return sdf.format(date);
}
';

CREATE ALIAS IF NOT EXISTS AES_ENCRYPT AS '

@CODE
String aesEncrypt(String unhex, String keyPassword) throws Exception {
    return "aes encrypt value";
}
';

CREATE ALIAS IF NOT EXISTS AES_DECRYPT AS '

@CODE
String aesDecrypt(String unhex, String keyPassword) throws Exception {
    return unhex;
}
';

CREATE ALIAS IF NOT EXISTS HEX AS '

@CODE
String hex(String hex) throws Exception {
    return "hex value";
}
';

CREATE ALIAS IF NOT EXISTS UNHEX AS '

@CODE
String unhex(String unhex) throws Exception {
    return unhex;
}
';