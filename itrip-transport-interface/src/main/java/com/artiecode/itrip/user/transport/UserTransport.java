package com.artiecode.itrip.user.transport;

import com.artiecode.itrip.pojo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <b>用户模块传输层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@FeignClient(name = "itrip-user-provider")
@RequestMapping("/user")
public interface UserTransport {
	/**
	 * <b>校验是否可以注册使用</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkUserCodeForRegistry", method = RequestMethod.POST)
	boolean checkUserCodeForRegistry(@RequestParam String userCode) throws Exception;

	/**
	 * <b>使用电子邮件完成用户注册</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/registryUser", method = RequestMethod.POST)
	boolean registryUser(@RequestBody User user) throws Exception;

	/**
	 * <b>为使用电子邮件注册用户进行激活操作</b>
	 * @param email
	 * @param activeCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/activateUserForEmail", method = RequestMethod.POST)
	boolean activateUserForEmail(@RequestParam String email, @RequestParam String activeCode) throws Exception;

	/**
	 * <b>使用userCode和userPassword进行登录</b>
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	User getUserForLogin(@RequestParam String userCode, @RequestParam String userPassword) throws Exception;
}