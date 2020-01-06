package com.artiecode.itrip.pojo.vo;

import java.io.Serializable;

/**
 * <b>订单联系人视图对象</b>
 */
public class OrderLinkUserVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long linkUserId;
	private String linkUserName;

	public Long getLinkUserId() {
		return linkUserId;
	}

	public void setLinkUserId(Long linkUserId) {
		this.linkUserId = linkUserId;
	}

	public String getLinkUserName() {
		return linkUserName;
	}

	public void setLinkUserName(String linkUserName) {
		this.linkUserName = linkUserName;
	}
}
