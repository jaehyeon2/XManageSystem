package com.example.project.service;

import java.sql.SQLException;

import com.example.project.beans.param.common.GroupParam;
import com.example.project.beans.param.common.UserParam;

public interface AdminService {
	
	public boolean saveUser(UserParam userParam) throws SQLException;
	
	public boolean removeUser(UserParam userParam) throws SQLException;

	public boolean saveGroup(GroupParam groupParam) throws SQLException;
	
	public boolean updateGroup(GroupParam groupParam) throws SQLException;
}
