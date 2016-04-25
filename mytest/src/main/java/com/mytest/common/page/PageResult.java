package com.mytest.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * <p> 分页列表，业务domain
 * 		<p> 若是返回分页列表，使用此实体.
 *
 * @author ws
 */
public class PageResult<T> implements Serializable {

    /**
     * 构造分页返回列表
     */
	public PageResult() {
		super();
	}

    /**
     * 构造分页返回列表
     * @param list
     * @param totalPage
     * @param totalCount
     */
	public PageResult(List<T> list, Integer totalPage, Integer totalCount) {
		super();
		this.list = list;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}

	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 2829002972754500115L;

	/** 封装页面实体. */
	private List<T> list;
	
	/**  总页数. */
	private Integer totalPage=0;
	
	/**  总个数. */
	private Integer totalCount=0;

	/**
	 * 获取--- 封装页面实体.
	 *
	 * @return the 封装页面实体
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置--- 封装页面实体.
	 *
	 * @param list the new 封装页面实体
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * 获取--- 总页数.
	 *
	 * @return the 总页数
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * 设置--- 总页数.
	 *
	 * @param totalPage the new 总页数
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 获取--- 总个数.
	 *
	 * @return the 总个数
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * 设置--- 总个数.
	 *
	 * @param totalCount the new 总个数
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "PageResult [list=" + list + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + "]";
	}

}
