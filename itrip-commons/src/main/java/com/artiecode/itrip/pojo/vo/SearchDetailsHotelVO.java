package com.artiecode.itrip.pojo.vo;

import java.io.Serializable;

/**
 * <b>酒店详情视图类</b>
 */
public class SearchDetailsHotelVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name = "酒店介绍";
	private String description;

	public SearchDetailsHotelVO() {}
	public SearchDetailsHotelVO(String name, String description) {
		this.name = name;
		this.description = description;
	}

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
