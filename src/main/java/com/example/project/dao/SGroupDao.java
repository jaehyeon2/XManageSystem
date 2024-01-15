package com.example.project.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.example.project.beans.model.common.GroupModel;

public interface SGroupDao {
	
	public GroupModel sltGroup(Map<String, Object> map) throws SQLException;

	public List<GroupModel> sltGroupSeq(Map<String, Object> map) throws SQLException;
	
}
