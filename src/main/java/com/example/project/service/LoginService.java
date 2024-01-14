package com.example.project.service;

import com.example.project.beans.param.UserParam;

public interface LoginService {
	
	public void saveUser(UserParam userParam) throws Exception;
	
	public boolean validateLoginUser(UserParam userParam) throws Exception;
	
	public boolean checkDuplicateEmail(UserParam userParam) throws Exception;
	
}
