package org.zerock.domain;

public class Criteria {

	private Integer page;
	private Integer perPageNum;

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public Integer getPageStart(){
		return (this.page - 1) * perPageNum;
	}

	public Integer getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(Integer perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	

}
