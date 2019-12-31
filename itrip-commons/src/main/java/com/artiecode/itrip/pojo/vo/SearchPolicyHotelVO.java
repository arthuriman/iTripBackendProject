package com.artiecode.itrip.pojo.vo;

import java.io.Serializable;

/**
 * <b>酒店政策VO</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public class SearchPolicyHotelVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
