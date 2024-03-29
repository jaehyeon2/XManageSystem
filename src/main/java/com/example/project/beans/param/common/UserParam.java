package com.example.project.beans.param.common;

import jakarta.validation.constraints.Email;

public class UserParam extends GroupParam{
	
	private String userId;
	private String userNo;
	private String userNm;
	private String userRank;
	private String userPos;
	@Email
	private String userEmail;
	private String userPwd;
	private String userPhone;
	private String userAuth;
	private String searchUserCate;
	private String searchUserKey;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserRank() {
		return userRank;
	}
	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}
	public String getUserPos() {
		return userPos;
	}
	public void setUserPosi(String userPos) {
		this.userPos = userPos;
	}
	public String getUserEmail(){
		return userEmail;
	}
	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}
	public String getSearchUserCate() {
		return searchUserCate;
	}
	public void setSearchUserCate(String searchUserCate) {
		this.searchUserCate = searchUserCate;
	}
	public String getSearchUserKey() {
		return searchUserKey;
	}
	public void setSearchUserKey(String searchUserKey) {
		this.searchUserKey = searchUserKey;
	}
	public void setUserPos(String userPos) {
		this.userPos = userPos;
	}
	
	
}
