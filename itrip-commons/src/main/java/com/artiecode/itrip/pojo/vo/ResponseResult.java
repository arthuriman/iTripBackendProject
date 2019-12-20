package com.artiecode.itrip.pojo.vo;

import com.artiecode.itrip.base.enums.SuccessEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <b>系统处理响应结果视图</b>
 * @param <T>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@ApiModel(value = "系统处理响应结果视图")
public class ResponseResult<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "响应是否成功[必填]：true-成功，false-失败")
	private String success;
	@ApiModelProperty(value = "响应错误码")
	private String errorCode;
	@ApiModelProperty(value = "响应结果信息")
	private String msg;
	@ApiModelProperty(value = "相应数据")
	private T data;

	public ResponseResult(SuccessEnum successEnum) {
		this.success = successEnum.getMsg();
	}
	public ResponseResult(SuccessEnum successEnum, String msg) {
		this.success = successEnum.getMsg();
		this.msg = msg;
	}
	public ResponseResult(SuccessEnum successEnum, T data) {
		this.success = successEnum.getMsg();
		this.data = data;
	}
	public ResponseResult(SuccessEnum successEnum, String msg, T data) {
		this.success = successEnum.getMsg();
		this.msg = msg;
		this.data = data;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
