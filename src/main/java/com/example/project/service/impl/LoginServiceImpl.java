package com.example.project.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.UserParam;
import com.example.project.dao.SUserDao;
import com.example.project.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession mDbDao;
	
	@Autowired
	private SqlSession sDbDao;
	
	@Override
	public void saveUser(UserParam userParam) throws Exception{
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userNo", userParam.getUserNo());
			map.put("userNm", userParam.getUserNm());
			map.put("userRank", userParam.getUserRank());
			map.put("userPos", userParam.getUserPos());
		}catch(Exception e){
			logger.info("LoginServiceImpl::saveUser::error: " + e.getMessage());
		}
	}
	
	@Override
	public boolean validateLoginUser(UserParam userParam) throws Exception{
		
		UserModel userModel = null;
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			
			if (userParam.getUserEmail()==null | userParam.getUserPwd()==null){
				throw new Exception("parameter is null");
			}
			
			map.put("userEmail", userParam.getUserEmail());
			map.put("userPwd", userParam.getUserPwd());
			userModel =	sDbDao.getMapper(SUserDao.class).sltUser(map);
		}catch(Exception e){
			logger.info("LoginServiceImpl::validateLoginUser::error: " + e.getMessage());
			return false;
		}
		
		if (userModel==null){
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean checkDuplicateEmail(UserParam userParam) throws Exception {
		
		return false;
	}

	
}
