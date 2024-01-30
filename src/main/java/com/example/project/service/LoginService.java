package com.example.project.service;

import java.sql.SQLException;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.LoginParam;

public interface LoginService {
	
	public boolean saveUser(LoginParam loginParam) throws SQLException;
	
	public UserModel validateLoginUser(LoginParam loginParam) throws SQLException;
	
	public boolean checkDuplicateEmail(LoginParam loginParam) throws SQLException;
	
}
