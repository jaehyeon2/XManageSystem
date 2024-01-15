package com.example.project.beans.param.common;

public class PagingParam {
	
	private int allCount;
	private int rowPage;
	private int nowPage;
	
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getRowPage() {
		return rowPage;
	}
	public void setRowPage(int rowPage) {
		this.rowPage = rowPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

}
