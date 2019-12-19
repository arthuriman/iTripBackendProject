package com.artiecode.itrip.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <b>热门城市查询视图对象</b>
 * @version 3.1.1
 * @since 3.1.1
 */
@ApiModel(value = "热门城市查询视图", description = "当需要查询热门城市时，需要传递该视图")
public class SearchHotCityVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "城市主键[必填]", dataType = "Integer")
	private Integer cityId;
	@ApiModelProperty(value = "查询数量[必填]", dataType = "Integer")
	private Integer count;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
