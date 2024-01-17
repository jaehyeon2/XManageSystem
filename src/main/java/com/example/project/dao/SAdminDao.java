package com.example.project.dao;

import java.sql.SQLException;
import java.util.Map;

import com.example.project.beans.model.AdminModel;

public interface SAdminDao {
	
	public AdminModel sltAdmin(Map<String, Object> map) throws SQLException;
	
}
