package com.example.project.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.beans.param.common.GroupParam;
import com.example.project.beans.param.common.UserParam;
import com.example.project.dao.MGroupDao;
import com.example.project.dao.MUserDao;
import com.example.project.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession mDbDao;
	
	@Autowired
	private SqlSession sDbDao;
	
	
	@Override
	public boolean saveUser(UserParam userParam) throws SQLException{
		
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userNo", "1");
			map.put("userNm", userParam.getUserNm());
			map.put("userRank", "2");
			map.put("userPos", "1");
			map.put("userAuth", "2");
			map.put("userEmail", userParam.getUserEmail());
			map.put("userPwd", userParam.getUserPwd());
			map.put("userPhone", userParam.getUserPhone());
			map.put("groupNo", userParam.getGroupNo());
			map.put("groupNm", userParam.getGroupNm());
			
			int result = mDbDao.getMapper(MUserDao.class).istUser(map);
			
			if (result<1){
				logger.info("AdminServiceImpl::saveUser::Info: NoInsert");;
				return false;
			}
		}catch(Exception e){
			logger.error("AdminServiceImpl::saveUser::Error: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean updateUserAuth(UserParam userParam) throws SQLException{
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", userParam.getUserId());
			
			int result = mDbDao.getMapper(MUserDao.class).udtUserAuth(map);
			
			if (result<1){
				logger.info("AdminServiceImpl::updateUserAuth::Info: NoInsert");
				return false;
			}
		}catch (Exception e) {
			logger.error("AdminServiceImpl::updateUserAuth::Error: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean removeUser(UserParam userParam) throws SQLException{
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userNo", userParam.getUserNo());
			
			int result = mDbDao.getMapper(MUserDao.class).dltUser(map);
			
			if (result<1){
				logger.info("AdminServiceImpl::removeUser::Info: NoDelete");;
				return false;
			}
		}catch(Exception e){
			logger.error("AdminServiceImpl::removeUser::Error: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean saveGroup(GroupParam groupParam) throws SQLException {
		try{
			if (groupParam.getGroupNm()==null||groupParam.getGroupPNo()==null){
				logger.warn("GroupServiceImpl::saveGroup::Warn: parameter is null!");
				return false;
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("groupNm", groupParam.getGroupNm());
			map.put("groupPNo", groupParam.getGroupPNo());
			
			int result = mDbDao.getMapper(MGroupDao.class).istGroup(map);
			
			if (result<1){
				logger.info("GroupServiceImpl::saveGroup::Warn: result warn");
			}
			
		}catch (Exception e) {
			logger.error("GroupServiceImpl::saveGroup::Error: " + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateGroup(GroupParam groupParam) throws SQLException {
		try{
			if (groupParam.getGroupNm()==null||groupParam.getGroupPNo()==null){
				logger.warn("GroupServiceImpl::updateGroup::Warn: parameter is null!");
				return false;
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("groupNo", groupParam.getGroupNo());
			map.put("groupNm", groupParam.getGroupNm());
			map.put("groupPNo", groupParam.getGroupPNo());
			
			int result = mDbDao.getMapper(MGroupDao.class).udtGroup(map);
			
			if (result<1){
				logger.info("GroupServiceImpl::updateGroup::Warn: result warn");
			}
		}catch(Exception e){
			logger.error("GroupServiceImpl::updateGroup::Error: " + e.getMessage());
			return false;
		}
		return true;
	}

}
