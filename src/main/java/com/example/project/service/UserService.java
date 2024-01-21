package com.example.project.service;

import java.sql.SQLException;
import java.util.List;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.SearchParam;
import com.example.project.beans.param.common.UserParam;

public interface UserService {
	
	public UserModel searchUser(UserParam userParam) throws SQLException;
	
	public List<UserModel> searchUserList(SearchParam searchParam) throws SQLException;
	
	public boolean updateUser(UserParam userParam) throws SQLException;
	
}
