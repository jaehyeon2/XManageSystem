package com.example.project.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.LoginParam;
import com.example.project.dao.MUserDao;
import com.example.project.dao.SUserDao;
import com.example.project.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession mDbDao;
	
	@Autowired
	private SqlSession sDbDao;
	
	@Override
	public boolean saveUser(LoginParam loginParam) throws Exception{
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userNo", loginParam.getUserNo());
			map.put("userNm", loginParam.getUserNm());
			map.put("userRank", loginParam.getUserRank());
			map.put("userPos", loginParam.getUserPos());
			map.put("userEmail", loginParam.getUserEmail());
			map.put("userPwd", loginParam.getUserPwd());
			map.put("userPhone", loginParam.getUserPhone());
			map.put("groupNo", loginParam.getGroupNo());
			map.put("groupNm", loginParam.getGroupNm());
			
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
	public UserModel validateLoginUser(LoginParam loginParam) throws Exception{
		
		UserModel userModel = null;
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			
			if (loginParam.getUserEmail()==null | loginParam.getUserPwd()==null){
				logger.warn("LoginServiceImpl::validateLoginUser::Warn: parameter is null");
				return null;
			}
			
			map.put("userEmail", loginParam.getUserEmail());
			map.put("userPwd", loginParam.getUserPwd());
			userModel =	sDbDao.getMapper(SUserDao.class).sltUser(map);
			
		}catch(Exception e){
			logger.error("LoginServiceImpl::validateLoginUser::Error: " + e.getMessage());
			return null;
		}
		
		if (userModel==null){
			logger.info("LoginServiceImpl::validateLoginUser::Info: userModel is null");
			return null;
		}
		
		return userModel;
	}
	
	@Override
	public boolean checkDuplicateEmail(LoginParam loginParam) throws Exception {
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			
			if (loginParam.getUserEmail()==null){
				logger.warn("LoginServiceImpl::checkDuplicateEmail::Warn: email is null");
				return false;
			}
			
			map.put("userEmail", loginParam.getUserEmail());
			
			boolean result = sDbDao.getMapper(SUserDao.class).checkEmail(map);
			
			return result;
			
		}catch(Exception e){
			logger.error("LoginServiceImpl::checkDuplicateEmail::Error: " + e.getMessage());
			return false;
		}
	}

	
}
