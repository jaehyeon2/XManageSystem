package com.example.project.service;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.UserParam;

public interface LoginService {
	
	public boolean saveUser(UserParam userParam) throws Exception;
	
	public UserModel validateLoginUser(UserParam userParam) throws Exception;
	
	public boolean checkDuplicateEmail(UserParam userParam) throws Exception;
	
}
