package com.example.project.service;

import com.example.project.beans.param.PostParam;

public interface BoardService {
	
	public boolean savePost(PostParam postParam) throws Exception;  
}
