package com.example.project.dao;

import java.sql.SQLException;
import java.util.Map;

public interface MUserDao {
	
	public int istUser(Map<String, Object> map) throws SQLException;
	
	public int udtUser(Map<String, Object> map) throws SQLException;
	
	public int udtUserAuth(Map<String, Object> map) throws SQLException;
	
	public int dltUser(Map<String, Object> map) throws SQLException;

}
