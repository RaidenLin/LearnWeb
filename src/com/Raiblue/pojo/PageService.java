package com.Raiblue.pojo;

public class PageService {
	private int pageSize = 5;//页面记录数
	private int pageCount=0;//页面总数
	private int total = 0;//总共的记录数
	private int nowPage = 1;//当前的页面
	private int offSet = 0;//每页的第一条记录在总记录数的下标
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		pageCount = total/pageSize;
		if(total%pageSize!=0){//除不尽的情况
			pageCount++;
		}
		this.total = total;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		offSet = (nowPage - 1)*getPageSize();
			if(nowPage<1){
				this.nowPage=1;
			}
		this.nowPage = nowPage;
	}
	public int getOffSet() {
		return offSet;
	}
	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}
	
	

}
