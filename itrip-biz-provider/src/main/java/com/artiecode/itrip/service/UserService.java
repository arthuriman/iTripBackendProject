package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.entity.User;

/**
 * <b>用户信息业务层接口</b>
 * @author Arthur
 * @version 3.1.1 2019-12-12
 * @since 3.1.1
 */
public interface UserService {
	/**
	 * <b>通过userCode查询User对象</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	User getUserByUserCode(String userCode) throws Exception;

	/**
	 * <b>保存用户信息，保存成功后，根据用户的userCode类型进行相关验证码的发送工作</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean saveUser(User user) throws Exception;
}
