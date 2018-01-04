package ca.mcmaster.shop.utils;

import java.util.List;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 3, 2018 7:24:02 PM
 */
public class PageInfoBean<T> {
	private Integer currentPage;
	private Integer pageLimit;
	private Integer totalInfo;
	private Integer totalPageNum;
	private List<T> list;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}

	public Integer getTotalInfo() {
		return totalInfo;
	}

	public void setTotalInfo(Integer totalInfo) {
		this.totalInfo = totalInfo;
	}

	public Integer getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(Integer totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
