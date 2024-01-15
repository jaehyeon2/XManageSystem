package com.example.project.service;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.LoginParam;

public interface LoginService {
	
	public boolean saveUser(LoginParam loginParam) throws Exception;
	
	public UserModel validateLoginUser(LoginParam loginParam) throws Exception;
	
	public boolean checkDuplicateEmail(LoginParam loginParam) throws Exception;
	
}
