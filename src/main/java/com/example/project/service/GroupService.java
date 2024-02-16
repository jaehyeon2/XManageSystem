package com.example.project.service;

import java.sql.SQLException;
import java.util.List;

import com.example.project.beans.model.common.GroupModel;
import com.example.project.beans.param.common.GroupParam;

public interface GroupService {

	public GroupModel searchGroup(GroupParam groupParam) throws SQLException;
	
	public List<GroupModel> searchGroupList(GroupParam groupParam) throws SQLException;
	
}
