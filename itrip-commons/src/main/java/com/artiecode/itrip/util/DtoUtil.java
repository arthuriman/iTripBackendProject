package com.artiecode.itrip.util;

import com.artiecode.itrip.pojo.vo.Dto;

/**
 * <b>用于返回Dto的工具类</b>
 * @author Arthur
 * @version 3.1.1
 * @since 3.1.1
 */
public class DtoUtil {
	public static String success="true";

	public static String fail="false";

	public static String errorCode="0";
	/***
	 * 统一返回成功的DTO
	 */
	public static Dto returnSuccess(){
		Dto dto=new Dto();
		dto.setSuccess(success);
		return  dto;
	}
	/***
	 * 统一返回成功的DTO 带数据
	 */
	public static Dto returnSuccess(String message,Object data){
		Dto dto=new Dto();
		dto.setSuccess(success);
		dto.setMsg(message);
		dto.setErrorCode(errorCode);
		dto.setData(data);
		return  dto;
	}
	/***
	 * 统一返回成功的DTO 不带数据
	 */
	public static Dto returnSuccess(String message){
		Dto dto=new Dto();
		dto.setSuccess(success);
		dto.setMsg(message);
		dto.setErrorCode(errorCode);
		return  dto;
	}
	/***
	 * 统一返回成功的DTO 带数据 没有消息
	 */
	public static Dto returnDataSuccess(Object data){
		Dto dto=new Dto();
		dto.setSuccess(success);
		dto.setErrorCode(errorCode);
		dto.setData(data);
		return  dto;
	}

	public static Dto returnFail(String message,String errorCode){
		Dto dto=new Dto();
		dto.setSuccess(fail);
		dto.setMsg(message);
		dto.setErrorCode(errorCode);
		return  dto;
	}
}
