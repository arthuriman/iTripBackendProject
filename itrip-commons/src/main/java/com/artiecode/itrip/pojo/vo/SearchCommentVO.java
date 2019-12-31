package com.artiecode.itrip.pojo.vo;

import java.io.Serializable;

public class SearchCommentVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long hotelId;
	private Integer isHavingImg;//是否有评论图片（0 无图片 1 有图片）
	private Integer isOk;//是否满意（0：有待改善 1：值得推荐）
	private Integer pageSize;
	private Integer pageNo;

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getIsHavingImg() {
		return isHavingImg;
	}

	public void setIsHavingImg(Integer isHavingImg) {
		this.isHavingImg = isHavingImg;
	}

	public Integer getIsOk() {
		return isOk;
	}

	public void setIsOk(Integer isOk) {
		this.isOk = isOk;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
}
