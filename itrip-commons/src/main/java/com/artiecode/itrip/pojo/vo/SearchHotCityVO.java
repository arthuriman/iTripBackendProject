package com.artiecode.itrip.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 根据热门城市搜酒店的传入参数 VO
 * Created by XX on 17-5-15.
 */
@ApiModel(value = "SearchHotCityVO",description = "搜索热门城市酒店VO")
public class SearchHotCityVO implements Serializable{

    @ApiModelProperty("[必填] 城市id")
    private Integer cityId;

    @ApiModelProperty("[必填] 数目")
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
