package com.example.project.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.UserParam;
import com.example.project.dao.MUserDao;
import com.example.project.dao.SUserDao;
import com.example.project.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession mDbDao;
	
	@Autowired
	private SqlSession sDbDao;
	
	@Override
	public boolean saveUser(UserParam userParam) throws Exception{
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userNo", userParam.getUserNo());
			map.put("userNm", userParam.getUserNm());
			map.put("userRank", userParam.getUserRank());
			map.put("userPos", userParam.getUserPos());
			map.put("userEmail", userParam.getUserEmail());
			map.put("userPwd", userParam.getUserPwd());
			map.put("userPhone", userParam.getUserPhone());
			map.put("groupNo", userParam.getGroupNo());
			
			int result = mDbDao.getMapper(MUserDao.class).istUser(map);
			
			if (result<1){
				logger.info("LoginServiceImpl::saveUser::Info: NoInsert");;
				return false;
			}
		}catch(Exception e){
			logger.error("LoginServiceImpl::saveUser::Error: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean validateLoginUser(UserParam userParam) throws Exception{
		
		UserModel userModel = null;
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			
			if (userParam.getUserEmail()==null | userParam.getUserPwd()==null){
				logger.info("LoginServiceImpl::validateLoginUser::Info: parameter is null");
				return false;
			}
			
			map.put("userEmail", userParam.getUserEmail());
			map.put("userPwd", userParam.getUserPwd());
			userModel =	sDbDao.getMapper(SUserDao.class).sltUser(map);
			
		}catch(Exception e){
			logger.error("LoginServiceImpl::validateLoginUser::Error: " + e.getMessage());
			return false;
		}
		
		if (userModel==null){
			logger.info("LoginServiceImpl::validateLoginUser::Info: userModel is null");
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean checkDuplicateEmail(UserParam userParam) throws Exception {
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			
			if (userParam.getUserEmail()==null){
				logger.info("LoginServiceImpl::checkDuplicateEmail::Info: email is null");
				return false;
			}
			
			map.put("userEmail", userParam.getUserEmail());
			
			boolean result = sDbDao.getMapper(SUserDao.class).checkEmail(map);
			
			return result;
			
		}catch(Exception e){
			logger.error("LoginServiceImpl::checkDuplicateEmail::Error: " + e.getMessage());
			return false;
		}
	}

	
}
