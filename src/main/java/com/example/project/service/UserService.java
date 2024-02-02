package com.example.project.service;

import java.sql.SQLException;
import java.util.List;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.SearchUserParam;
import com.example.project.beans.param.common.UserParam;

public interface UserService {
	
	public UserModel sltUser(UserParam userParam) throws SQLException;
	
	public List<UserModel> sltUserList(UserParam userParam) throws SQLException;
	
	public int sltUserCount(UserParam userParam) throws SQLException;
	
	public boolean updateUser(UserParam userParam) throws SQLException;
	
}
