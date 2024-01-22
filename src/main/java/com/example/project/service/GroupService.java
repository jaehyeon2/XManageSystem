package com.example.project.service;

import java.sql.SQLException;
import java.util.List;

import com.example.project.beans.model.common.GroupModel;
import com.example.project.beans.param.common.GroupParam;

public interface GroupService {

	public GroupModel searchGroup(GroupParam groupParam) throws SQLException;
	
	public List<GroupModel> searchGroupSeq(GroupParam groupParam) throws SQLException;
	
	public boolean saveGroup(GroupParam groupParam) throws SQLException;
	
	public boolean updateGroup(GroupParam groupParam) throws SQLException;
	
}