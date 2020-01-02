package com.artiecode.itrip.pojo.vo;

import java.io.Serializable;

/**
 * <b>验证房屋库存是否存足的VO</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public class ValidateRoomStoreVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String checkInDate;
	private String checkOutDate;
	private Integer count;
	private Long hotelId;
	private Long roomId;

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
}
