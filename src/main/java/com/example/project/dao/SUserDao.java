package com.example.project.dao;

import java.sql.SQLException;
import java.util.Map;

import com.example.project.beans.model.common.UserModel;

public interface SUserDao {

	public UserModel sltUser(Map<String, Object> map) throws SQLException;
	
	public boolean checkEmail(Map<String, Object> map) throws SQLException;
}
