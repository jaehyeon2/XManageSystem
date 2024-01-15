package com.example.project.beans.model.common;

import java.io.Serializable;

public class UserModel extends GroupModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String userNo;
	private String userNm;
	private String userRank;
	private String userPos;
	private String userEmail;
	private String userPwd;
	private String userPhone;
	
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
	public void setUserPos(String userPos) {
		this.userPos = userPos;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPhone(){
		return userPhone;
	}
	public void setUserPhone(String userPhone){
		this.userPhone = userPhone;
	}
	
	
}
