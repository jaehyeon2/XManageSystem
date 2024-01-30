package com.example.project.beans.model;

import java.io.Serializable;

import com.example.project.beans.model.common.UserModel;

public class PostModel extends UserModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String postTitle;
	private String postContent;
	
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
}
