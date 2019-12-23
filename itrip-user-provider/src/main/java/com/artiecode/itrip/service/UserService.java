package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.entity.User;

/**
 * <b>用户子项目业务层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public interface UserService {
	/**
	 * <b>根据用户提供的电子邮件地址，校验是否可以注册使用</b>
	 * @param email
	 * @return
	 * @throws Exception
	 */
	boolean checkEmailForRegistry(String email) throws Exception;

	/**
	 * <b>使用电子邮件完成用户注册</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean registryUserByEmail(User user) throws Exception;
}
