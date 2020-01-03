package com.artiecode.itrip.pojo.vo;

import com.artiecode.itrip.pojo.entity.UserLinkUser;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <b>酒店下单视图对象</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public class HotelOrderAddVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer orderType;
	private Long hotelId;
	private String hotelName;
	private Long roomId;
	private Integer count;
	private String checkInDate;
	private String checkOutDate;
	private String noticePhone;
	private String noticeEmail;
	private String specialRequirement;
	private Integer isNeedInvoice;
	private Integer invoiceType;
	private String invoiceHead;
	private List<UserLinkUser> linkUser;
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
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

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

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

	public String getNoticePhone() {
		return noticePhone;
	}

	public void setNoticePhone(String noticePhone) {
		this.noticePhone = noticePhone;
	}

	public String getNoticeEmail() {
		return noticeEmail;
	}

	public void setNoticeEmail(String noticeEmail) {
		this.noticeEmail = noticeEmail;
	}

	public String getSpecialRequirement() {
		return specialRequirement;
	}

	public void setSpecialRequirement(String specialRequirement) {
		this.specialRequirement = specialRequirement;
	}

	public Integer getIsNeedInvoice() {
		return isNeedInvoice;
	}

	public void setIsNeedInvoice(Integer isNeedInvoice) {
		this.isNeedInvoice = isNeedInvoice;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceHead() {
		return invoiceHead;
	}

	public void setInvoiceHead(String invoiceHead) {
		this.invoiceHead = invoiceHead;
	}

	public List<UserLinkUser> getLinkUser() {
		return linkUser;
	}

	public void setLinkUser(List<UserLinkUser> linkUser) {
		this.linkUser = linkUser;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
