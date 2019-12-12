package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.pojo.entity.User;
import com.artiecode.itrip.pojo.vo.Dto;
import com.artiecode.itrip.transport.UserTransport;
import com.artiecode.itrip.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>认证子项目控制器</b>
 * @author Arthur
 * @version 3.1.0 2019-12-12
 * @since 3.1.0
 */
@RestController("authController")
@RequestMapping("/auth")
public class AuthController extends BaseController {
	@Autowired
	private UserTransport userTransport;

	/**
	 * <b>检查用户所填写的注册时所填写的邮箱/手机号码是否可用</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/ckusr", method = RequestMethod.GET)
	public Dto<User> checkUserCodeForRegistry(String name) throws Exception {
		// 创建数据返回对象
		Dto<User> result = new Dto<User>();
		// 判断所提交的邮箱/手机号码是否符合格式要求
		if (UserUtil.checkUserCodePattern(name)) {
			// 在格式正确的情况下，进行唯一性校验
			User user = userTransport.getUserByUserCode(name);
			if (user == null) {
				// 此时该注册信息可用
				result.setSuccess("true");
				return result;
			}
		}
		// 如果格式正确，那么在校验是否唯一
		result.setSuccess("false");
		result.setMsg("该邮箱地址或手机号码格式不正确，或者已被占用");
		return result;
	}

	/**
	 * <b>使用邮箱注册新用户</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/doregister", method = RequestMethod.POST)
	public Dto<User> registryUserByEmail(@RequestBody User user) throws Exception {
		// 1、校验用户所填写的信息是否格式有效，包含用户的Email地址和密码
		// 2、对于用户的登录密码进行MD5加密
		// 3、保存用户数据，并且在业务层保存成功的是否使用邮箱功能发送激活码，并且将激活码设定到redis中保存，并且设定有效时间
		return null;
	}
}
