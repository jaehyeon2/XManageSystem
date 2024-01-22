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

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.SearchParam;
import com.example.project.beans.param.common.UserParam;
import com.example.project.dao.MUserDao;
import com.example.project.dao.SUserDao;
import com.example.project.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession mDbDao;
	
	@Autowired
	private SqlSession sDbDao;

	@Override
	public UserModel searchUser(UserParam userParam) throws SQLException {
		
		UserModel userModel = null;
		if (userParam.getUserNo()==null){
			logger.error("UserServiceImpl::searchUser::Error: parameter error! userNo is not exist!");
			return null;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userNo", userParam.getUserNo());
		
		userModel = sDbDao.getMapper(SUserDao.class).sltUser(map);
		
		if (userModel==null){
			logger.info("UserServiceImpl::searchUser::Info: userModel is not exist!");
			return null;
		}
		
		return userModel;
	}

	@Override
	public List<UserModel> searchUserList(SearchParam searchParam) throws SQLException {
		List<UserModel> userList = null;
		if (searchParam.getSearchCate()==null || searchParam.getSearchKey()==null){
			logger.error("UserServiceImp l:::searchUserList::Error: parameter is null");
			return null;
		}
		
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			int nowPage = searchParam.getNowPage();
			int start = (nowPage-1)*searchParam.getRowPage();
			map.put("startNo", start);
			map.put("row", searchParam.getRowPage());
			map.put("searchCate", searchParam.getSearchCate());
			map.put("searchKey", searchParam.getSearchKey());
			
			userList =sDbDao.getMapper(SUserDao.class).sltUserList(map); 
		}catch(Exception e){
			logger.error("UserServiceImpl::searchUserList::Error: " + e.getMessage());
			return null;
		}
		
		return userList;
	}

	@Override
	public boolean updateUser(UserParam userParam) throws SQLException {
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("userNm", userParam.getUserNm());
			map.put("userRank", userParam.getUserRank());
			map.put("userPos", userParam.getUserPos());
			map.put("userEmail", userParam.getUserEmail());
			map.put("userPwd", userParam.getUserPwd());
			map.put("userPhone", userParam.getUserPhone());
			map.put("groupNo", userParam.getGroupNo());
			map.put("groupNm", userParam.getGroupNm());
			
			int result = mDbDao.getMapper(MUserDao.class).udtUser(map);
			
			if (result<1){
				logger.info("UserServiceImpl::updateUser::Warn: result warn");
			}
			
		}catch(Exception e){
			logger.error("UserServiceImpl::updateUser::Error: " + e.getMessage());
			return false;
		}
		return true;
	}

}