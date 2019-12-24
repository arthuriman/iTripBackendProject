package com.artiecode.itrip.transport.impl;

import com.artiecode.itrip.pojo.entity.User;
import com.artiecode.itrip.service.UserService;
import com.artiecode.itrip.user.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>用户模块传输层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("userTransport")
@RequestMapping("/user")
public class UserTransportImpl implements UserTransport {
	@Autowired()
	private UserService userService;

	/**
	 * <b>根据用户提供的电子邮件地址，校验是否可以注册使用</b>
	 * @param email
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkEmailForRegistry", method = RequestMethod.POST)
	public boolean checkEmailForRegistry(@RequestParam String email) throws Exception {
		return userService.checkEmailForRegistry(email);
	}

	/**
	 * <b>使用电子邮件完成用户注册</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/registryUserByEmail", method = RequestMethod.POST)
	public boolean registryUserByEmail(@RequestBody User user) throws Exception {
		return userService.registryUserByEmail(user);
	}

	/**
	 * <b>为使用电子邮件注册用户进行激活操作</b>
	 * @param email
	 * @param activeCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/activateUserForEmail", method = RequestMethod.POST)
	public boolean activateUserForEmail(@RequestParam String email, @RequestParam String activeCode) throws Exception {
		return userService.activateUser(email, activeCode);
	}

	/**
	 * <b>使用userCode和userPassword进行登录</b>
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User getUserForLogin(@RequestParam String userCode, @RequestParam String userPassword) throws Exception {
		return userService.getUserForLogin(userCode, userPassword);
	}
}
