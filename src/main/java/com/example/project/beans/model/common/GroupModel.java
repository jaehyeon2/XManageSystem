package com.example.project.beans.model.common;

import java.io.Serializable;

public class GroupModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String groupId;
	private String groupNo;
	private String groupNm;
	private String groupPId;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public String getGroupNm() {
		return groupNm;
	}
	public void setGroupNm(String groupNm) {
		this.groupNm = groupNm;
	}
	public String getGroupPId() {
		return groupPId;
	}
	public void setGroupPId(String groupPId) {
		this.groupPId = groupPId;
	}
}
