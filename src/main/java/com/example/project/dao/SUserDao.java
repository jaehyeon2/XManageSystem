package com.example.project.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.example.project.beans.model.common.UserModel;

public interface SUserDao {
	
	public boolean checkEmail(Map<String, Object> map) throws SQLException;

	public UserModel sltUser(Map<String, Object> map) throws SQLException;
	
	public List<UserModel> sltUserList(Map<String, Object> map) throws SQLException;
	
	public int cntUser(Map<String, Object> map) throws SQLException;
	
}
