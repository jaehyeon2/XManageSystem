package com.example.project.beans.param;

import com.example.project.beans.param.common.PagingParam;

public class SearchParam extends PagingParam{
	
	private String searchCate;
	
	private String searchKey;

	public String getSearchCate() {
		return searchCate;
	}

	public void setSearchCate(String searchCate) {
		this.searchCate = searchCate;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	
}
