package com.example.project.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
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
	public List<GroupModel> searchGroupSeq(GroupParam groupParam) throws SQLException{
		List<GroupModel> groupModelSeq = null;
		try{
			if (groupParam.getGroupId()==null){
				logger.warn("GroupServiceImpl::searchGroupSeq::Warn: parameter is null!");
				return null;
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("groupId", groupParam.getGroupId());
			groupModelSeq = sDbDao.getMapper(SGroupDao.class).sltGroupSeq(map);
		}catch(Exception e){
			logger.error("GroupServiceImpl::searchGroupSeq::Error: " + e.getMessage());
			return null;
		}
		return groupModelSeq;
	}

}
