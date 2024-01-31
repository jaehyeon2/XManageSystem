package com.example.project.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.project.beans.param.PostParam;
import com.example.project.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public int savePost(PostParam postParam) throws SQLException {
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("postTitle", postParam.getPostTitle());
			map.put("postContent", postParam.getPostContent());
			map.put("userId", postParam.getUserId());
		}catch(Exception e){
			logger.info("PostServiceImpl::savePost:Error: " + e.getMessage());
		}
		return 0;
	}

	@Override
	public int udtPost(PostParam postParam) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int dltPost(PostParam postParam) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
