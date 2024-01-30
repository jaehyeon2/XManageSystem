package com.example.project.beans.param;

import com.example.project.beans.param.common.PagingParam;

public class SearchUserParam extends PagingParam{
	
	private String searchUserCate;
	
	private String searchUserKey;

	public String getSearchUserCate() {
		return searchUserCate;
	}

	public void setSearchCate(String searchUserCate) {
		this.searchUserCate = searchUserCate;
	}

	public String getSearchUserKey() {
		return searchUserKey;
	}

	public void setSearchUserKey(String searchUserKey) {
		this.searchUserKey = searchUserKey;
	}
	
}
