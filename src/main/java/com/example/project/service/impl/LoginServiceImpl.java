package com.example.project.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.AuthParam;
import com.example.project.dao.MUserDao;
import com.example.project.dao.SUserDao;
import com.example.project.service.LoginService;

import jakarta.validation.Valid;

@Service
public class LoginServiceImpl implements LoginService{
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession mDbDao;
	
	@Autowired
	private SqlSession sDbDao;
	
	@Override
	public boolean saveUser(AuthParam authParam) throws SQLException{
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userNo", authParam.getUserNo());
			map.put("userNm", authParam.getUserNm());
			map.put("userRank", authParam.getUserRank());
			map.put("userPos", authParam.getUserPos());
			map.put("userEmail", authParam.getUserEmail());
			map.put("userPwd", authParam.getUserPwd());
			map.put("userPhone", authParam.getUserPhone());
			map.put("groupNo", authParam.getGroupNo());
			map.put("groupNm", authParam.getGroupNm());
			
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
	public UserModel validateLoginUser(AuthParam authParam) throws SQLException{
		
		UserModel userModel = null;
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			if (authParam.getUserEmail()==null || authParam.getUserPwd()==null){
				logger.warn("LoginServiceImpl::validateLoginUser::Warn: parameter is null");
				return null;
			}
			map.put("userEmail", authParam.getUserEmail());
			map.put("userPwd", authParam.getUserPwd());
			userModel =	sDbDao.getMapper(SUserDao.class).sltUser(map);
			
		}catch(Exception e){
			logger.error("LoginServiceImpl::validateLoginUser::Error: " + e.getMessage());
			return null;
		}
		
		if (userModel==null){
			logger.info("LoginServiceImpl::validateLoginUser::Info: userModel is null");
			// ID or PW are not matched
			return null;
		}
		
		return userModel;
	}
	
	@Override
	public boolean checkDuplicateEmail(AuthParam authParam) throws SQLException {
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			
			if (authParam.getUserEmail()==null){
				logger.warn("LoginServiceImpl::checkDuplicateEmail::Warn: email is null");
				return false;
			}
			
			map.put("userEmail", authParam.getUserEmail());
			
			boolean result = sDbDao.getMapper(SUserDao.class).checkEmail(map);
			
			return result;
			
		}catch(Exception e){
			logger.error("LoginServiceImpl::checkDuplicateEmail::Error: " + e.getMessage());
			return false;
		}
	}

	
}
