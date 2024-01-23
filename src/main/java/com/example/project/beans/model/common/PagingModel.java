package com.example.project.beans.model.common;

import java.util.List;

public class PagingModel {

	private String allCount;
	private String rowPage;
	private String nowPage;
	
	private List<UserModel> userList;
	
	public String getAllCount() {
		return allCount;
	}
	public void setAllCount(String allCount) {
		this.allCount = allCount;
	}
	public String getRowPage() {
		return rowPage;
	}
	public void setRowPage(String rowPage) {
		this.rowPage = rowPage;
	}
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}
	public List<UserModel> getUserList(){
		return userList;
	}
	public void setUserList(List<UserModel> userList){
		this.userList = userList;
	}
	
}
