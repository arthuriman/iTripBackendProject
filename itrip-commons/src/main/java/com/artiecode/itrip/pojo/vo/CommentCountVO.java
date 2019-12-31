package com.artiecode.itrip.pojo.vo;

import java.io.Serializable;

/**
 * <b>各种评论</b>
 */
public class CommentCountVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer allcomment;                     // 总评论数
	private Integer isok;                           // 值得推荐
	private Integer improve;                        // 有待改善
	private Integer havingimg;                      // 有图片

	public Integer getAllcomment() {
		return allcomment;
	}

	public void setAllcomment(Integer allcomment) {
		this.allcomment = allcomment;
	}

	public Integer getIsok() {
		return isok;
	}

	public void setIsok(Integer isok) {
		this.isok = isok;
	}

	public Integer getImprove() {
		return improve;
	}

	public void setImprove(Integer improve) {
		this.improve = improve;
	}

	public Integer getHavingimg() {
		return havingimg;
	}

	public void setHavingimg(Integer havingimg) {
		this.havingimg = havingimg;
	}
}
