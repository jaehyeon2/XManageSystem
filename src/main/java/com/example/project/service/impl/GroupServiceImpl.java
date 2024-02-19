package com.example.project.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.beans.model.common.GroupModel;
import com.example.project.beans.param.common.GroupParam;
import com.example.project.dao.MGroupDao;
import com.example.project.dao.SGroupDao;
import com.example.project.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession mDbDao;
	
	@Autowired
	private SqlSession sDbDao;
	
	@Override
	public GroupModel searchGroup(GroupParam groupParam) throws SQLException {
		GroupModel groupModel = null;
		try{
			if (groupParam.getGroupId()==null){
				logger.warn("GroupServiceImpl::searchGroup::Warn: parameter is null!");
				return null;
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("groupId", groupParam.getGroupId());
			groupModel = sDbDao.getMapper(SGroupDao.class).sltGroup(map);
			
		}catch (Exception e) {
			logger.error("GroupServiceImpl::searchGroup::Error: " + e.getMessage());
			return null;
		}
		
		return groupModel;
	}
	
	@Override
	public String searchGroupList(GroupParam groupParam) throws SQLException{
		String groupJson = null;
		logger.info(groupParam.getGroupId());
		try{
			if (groupParam.getGroupId()==null){
				logger.warn("GroupServiceImpl::searchGroupSeq::Warn: parameter is null!");
				return null;
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
				
			map.put("groupId", groupParam.getGroupId());
			List<GroupModel> groupModelList = sDbDao.getMapper(SGroupDao.class).sltGroupSeq(map);
			
			groupJson = this.groupListToJson(groupModelList);
			
		}catch(Exception e){
			logger.error("GroupServiceImpl::searchGroupSeq::Error: " + e.getMessage());
			return null;
		}
		return groupJson;
	}
	
	private String groupListToJson(List<GroupModel> groupList){
		JSONObject groupJson = null;
		
		StringBuffer tempJson = new StringBuffer("[");
		
		for (GroupModel g : groupList){
			
			tempJson.append("{").append("id:").append("\'" + g.getGroupId() + "\'");
			if (g.getGroupPId()!=null || g.getGroupPId().isEmpty()){
				tempJson.append(",").append("pid:").append("\'" + g.getGroupPId() + "\'");
			}
			tempJson.append(",").append("name:").append("\'" + g.getGroupNm() + "\'").append("},");
		}
		tempJson.append("]");
		System.out.println(tempJson);
		
		return tempJson.toString();
	}

}
