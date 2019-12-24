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
	 * <b>校验是否可以注册使用</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	boolean checkUserCodeForRegistry(String userCode) throws Exception;

	/**
	 * <b>使用电子邮件完成用户注册</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean registryUser(User user) throws Exception;

	/**
	 * <b>用户进行账户激活</b>
	 * @param userCode
	 * @param activeCode
	 * @return
	 * @throws Exception
	 */
	boolean activateUser(String userCode, String activeCode) throws Exception;

	/**
	 * <b>使用userCode和userPassword查找登录用户</b>
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	User getUserForLogin(String userCode, String userPassword) throws Exception;
}
