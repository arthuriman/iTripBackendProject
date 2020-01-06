package com.artiecode.itrip.pojo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>返回前端-根据订单ID查看个人订单详情-房型相关信息VO</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class PersonalOrderRoomVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;                    //订单ID
	private Long hotelId;               //酒店ID
	private String hotelName;           //酒店名称
	private Integer hotelLevel;         //酒店星级
	private String address;             //酒店位置
	private Long roomId;                //房型ID
	private String roomTitle;           //房型名称
	private Long roomBedTypeId;         //床型
	private Date checkInDate;           //入住时间
	private Date checkOutDate;          //退房时间
	private Integer count;              //预定数量
	private Integer bookingDays;        //预定天数
	private String linkUserName;        //入住人
	private String specialRequirement;  //特殊需求
	private Double payAmount;           //支付金额
	private Integer roomPayType;
	private Integer isHavingBreakfast;
	private String roomBedTypeName;
	private Integer checkInWeek;
	private Integer checkOutWeek;

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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Integer getHotelLevel() {
		return hotelLevel;
	}

	public void setHotelLevel(Integer hotelLevel) {
		this.hotelLevel = hotelLevel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getRoomTitle() {
		return roomTitle;
	}

	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public Long getRoomBedTypeId() {
		return roomBedTypeId;
	}

	public void setRoomBedTypeId(Long roomBedTypeId) {
		this.roomBedTypeId = roomBedTypeId;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getBookingDays() {
		return bookingDays;
	}

	public void setBookingDays(Integer bookingDays) {
		this.bookingDays = bookingDays;
	}

	public String getLinkUserName() {
		return linkUserName;
	}

	public void setLinkUserName(String linkUserName) {
		this.linkUserName = linkUserName;
	}

	public String getSpecialRequirement() {
		return specialRequirement;
	}

	public void setSpecialRequirement(String specialRequirement) {
		this.specialRequirement = specialRequirement;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getRoomPayType() {
		return roomPayType;
	}

	public void setRoomPayType(Integer roomPayType) {
		this.roomPayType = roomPayType;
	}

	public Integer getIsHavingBreakfast() {
		return isHavingBreakfast;
	}

	public void setIsHavingBreakfast(Integer isHavingBreakfast) {
		this.isHavingBreakfast = isHavingBreakfast;
	}

	public String getRoomBedTypeName() {
		return roomBedTypeName;
	}

	public void setRoomBedTypeName(String roomBedTypeName) {
		this.roomBedTypeName = roomBedTypeName;
	}

	public Integer getCheckInWeek() {
		return checkInWeek;
	}

	public void setCheckInWeek(Integer checkInWeek) {
		this.checkInWeek = checkInWeek;
	}

	public Integer getCheckOutWeek() {
		return checkOutWeek;
	}

	public void setCheckOutWeek(Integer checkOutWeek) {
		this.checkOutWeek = checkOutWeek;
	}
}
