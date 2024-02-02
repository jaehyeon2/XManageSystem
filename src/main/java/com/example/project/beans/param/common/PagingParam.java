package com.example.project.beans.param.common;

public class PagingParam extends UserParam{
	
	private String allCount;
	private String rowPage;
	private String nowPage;
	
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
	
}
