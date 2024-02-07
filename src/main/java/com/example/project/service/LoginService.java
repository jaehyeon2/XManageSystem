package com.example.project.service;

import java.sql.SQLException;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.AuthParam;

public interface LoginService {
	
	public boolean saveUser(AuthParam loginParam) throws SQLException;
	
	public UserModel validateLoginUser(AuthParam loginParam) throws SQLException;
	
	public boolean checkDuplicateEmail(AuthParam loginParam) throws SQLException;
	
}
