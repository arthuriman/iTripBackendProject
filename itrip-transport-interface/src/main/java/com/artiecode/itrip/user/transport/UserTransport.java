package com.artiecode.itrip.user.transport;

import com.artiecode.itrip.pojo.entity.User;
import com.artiecode.itrip.pojo.entity.UserLinkUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	 * @param userCode
	 * @param activeCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/activateUser", method = RequestMethod.POST)
	boolean activateUser(@RequestParam String userCode, @RequestParam String activeCode) throws Exception;

	/**
	 * <b>使用userCode和userPassword进行登录</b>
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	User getUserForLogin(@RequestParam String userCode, @RequestParam String userPassword) throws Exception;

	@RequestMapping(value = "/queryuserlinkuser", method = RequestMethod.POST)
	List<UserLinkUser> getLinkUserListByLogin(@RequestParam String userCode) throws Exception;

	@RequestMapping(value = "/queryUserByUserCode", method = RequestMethod.POST)
	User getUserByUserCode(@RequestParam String userCode) throws Exception;
}
