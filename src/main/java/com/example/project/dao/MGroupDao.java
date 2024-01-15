package com.example.project.dao;

import java.sql.SQLException;
import java.util.Map;

public interface MGroupDao {

	public boolean istGroup(Map<String, Object> map) throws SQLException;
	
	public boolean udtGroup(Map<String, Object> map) throws SQLException;
	
}
