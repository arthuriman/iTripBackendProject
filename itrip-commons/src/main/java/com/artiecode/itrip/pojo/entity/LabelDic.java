package com.artiecode.itrip.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>通用字典实体类</b>
 * <p>该实体类的本质就是所有的特色信息实体~~~Shit</p>
 * @author Arthur
 * @version 3.1.1 2019-12-11
 * @since 2019-12-17
 */
public class LabelDic implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String value;
	private String description;
	private LabelDic parent;
	private String pic;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LabelDic getParent() {
		return parent;
	}

	public void setParent(LabelDic parent) {
		this.parent = parent;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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
