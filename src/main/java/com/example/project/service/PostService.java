package com.example.project.service;

import java.sql.SQLException;

import com.example.project.beans.param.PostParam;

public interface PostService {

	public int savePost(PostParam postParam) throws SQLException;
	
	public int udtPost(PostParam postParam) throws SQLException;
	
	public int dltPost(PostParam postParam) throws SQLException;
}
