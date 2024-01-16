package com.example.project.dao;

import java.sql.SQLException;
import java.util.Map;

public interface MGroupDao {

	public int istGroup(Map<String, Object> map) throws SQLException;
	
	public int udtGroup(Map<String, Object> map) throws SQLException;
	
}
