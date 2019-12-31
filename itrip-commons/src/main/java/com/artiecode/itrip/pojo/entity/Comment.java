package com.artiecode.itrip.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>评论实体类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long hotelId;
	private Long productId;
	private Long orderId;
	private Integer productType;
	private String content;
	private Long userId;
	private Integer isHavingImg;
	private Integer positionScore;
	private Integer facilitiesScore;
	private Integer serviceScore;
	private Integer hygieneScore;
	private Integer score;
	private Long tripMode;
	private Integer isOk;
	private Date creationDate;
	private Long createdBy;
	private Date modifyDate;
	private Long modifiedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getIsHavingImg() {
		return isHavingImg;
	}

	public void setIsHavingImg(Integer isHavingImg) {
		this.isHavingImg = isHavingImg;
	}

	public Integer getPositionScore() {
		return positionScore;
	}

	public void setPositionScore(Integer positionScore) {
		this.positionScore = positionScore;
	}

	public Integer getFacilitiesScore() {
		return facilitiesScore;
	}

	public void setFacilitiesScore(Integer facilitiesScore) {
		this.facilitiesScore = facilitiesScore;
	}

	public Integer getServiceScore() {
		return serviceScore;
	}

	public void setServiceScore(Integer serviceScore) {
		this.serviceScore = serviceScore;
	}

	public Integer getHygieneScore() {
		return hygieneScore;
	}

	public void setHygieneScore(Integer hygieneScore) {
		this.hygieneScore = hygieneScore;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getTripMode() {
		return tripMode;
	}

	public void setTripMode(Long tripMode) {
		this.tripMode = tripMode;
	}

	public Integer getIsOk() {
		return isOk;
	}

	public void setIsOk(Integer isOk) {
		this.isOk = isOk;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
