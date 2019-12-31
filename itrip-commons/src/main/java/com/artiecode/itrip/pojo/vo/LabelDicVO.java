package com.artiecode.itrip.pojo.vo;

import java.io.Serializable;

/**
 * <b>字典视图对象</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public class LabelDicVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String description;
	private String pic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
}
