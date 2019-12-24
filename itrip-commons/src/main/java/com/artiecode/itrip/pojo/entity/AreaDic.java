package com.artiecode.itrip.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>区域字典表</b>
 * @version 3.1.1 2019-12-17
 * @since 3.1.1
 */
public class AreaDic implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String areaNo;
	private AreaDic parent;
	private Integer isActivated;
	private Integer isTradingArea;
	private Integer isHot;
	private Integer level;
	private Integer isChina;
	private String pinyin;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaNo() {
		return areaNo;
	}

	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
	}

	public AreaDic getParent() {
		return parent;
	}

	public void setParent(AreaDic parent) {
		this.parent = parent;
	}

	public Integer getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Integer isActivated) {
		this.isActivated = isActivated;
	}

	public Integer getIsTradingArea() {
		return isTradingArea;
	}

	public void setIsTradingArea(Integer isTradingArea) {
		this.isTradingArea = isTradingArea;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getIsChina() {
		return isChina;
	}

	public void setIsChina(Integer isChina) {
		this.isChina = isChina;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
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
