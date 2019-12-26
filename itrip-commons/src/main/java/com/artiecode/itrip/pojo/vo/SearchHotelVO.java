package com.artiecode.itrip.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 前端输入-查询酒店搜索条件VO
 * Created by XX on 17-5-10.
 */
@ApiModel(value = "SearchHotelVO",description = "搜索酒店VO")
public class SearchHotelVO implements Serializable {

    @ApiModelProperty("[必填] 目的地")
    private String destination;
    @ApiModelProperty("[非必填] 酒店级别(1-5)")
    private Integer hotelLevel;
    @ApiModelProperty("[非必填] 关键词")
    private String keywords;
    @ApiModelProperty("[非必填] 商圈id(每次只能选一个)")
    private String tradeAreaIds;
    @ApiModelProperty("[非必填] 最低价")
    private Double minPrice;
    @ApiModelProperty("[非必填] 最高价")
    private Double maxPrice;
    @ApiModelProperty("[非必填] 酒店特色id(每次只能选一个)")
    private String featureIds;
    @ApiModelProperty("[非必填] 按照某个字段升序,取值为(isOkCount或avgScore或minPrice或hotelLevel)")
    private String ascSort;
    @ApiModelProperty("[非必填] 按照某个字段降序,取值为(isOkCount或avgScore或minPrice或hotelLevel)")
    private String  descSort;
    @ApiModelProperty("[非必填] 入住日期")
    private Date checkInDate;
    @ApiModelProperty("[非必填] 退房日期")
    private Date checkOutDate;

    private Integer pageSize;

    private Integer pageNo;

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

    public String getAscSort() {
        return ascSort;
    }

    public void setAscSort(String ascSort) {
        this.ascSort = ascSort;
    }

    public String getDescSort() {
        return descSort;
    }

    public void setDescSort(String descSort) {
        this.descSort = descSort;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(Integer hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTradeAreaIds() {
        return tradeAreaIds;
    }

    public void setTradeAreaIds(String tradeAreaIds) {
        this.tradeAreaIds = tradeAreaIds;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getFeatureIds() {
        return featureIds;
    }

    public void setFeatureIds(String featureIds) {
        this.featureIds = featureIds;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

}
