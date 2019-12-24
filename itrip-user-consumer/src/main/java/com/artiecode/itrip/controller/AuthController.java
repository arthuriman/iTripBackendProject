package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.pojo.entity.User;
import com.artiecode.itrip.pojo.vo.ResponseResult;
import com.artiecode.itrip.user.transport.UserTransport;
import com.artiecode.itrip.util.JWTUtil;
import com.artiecode.itrip.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>用户认证控制器</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Api(value = "用户认证控制，集中完成用户的登陆和注册相关操作")
@RestController("authController")
@RequestMapping("/auth/api")
public class AuthController extends BaseController {
	private static final String emailRegEx = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	@Autowired
	private UserTransport userTransport;

	@ApiOperation(value = "校验用户注册所提供的Email地址是否可用")
	@RequestMapping(value = "/ckusr", method = RequestMethod.GET)
	public ResponseResult<User> checkEmailForRegistry(String name) throws Exception {
		// 校验用户所给定的email地址是否符合格式要求
		if (name != null && !"".equals(name.trim())) {
			if (name.matches(emailRegEx)) {
				if (userTransport.checkEmailForRegistry(name)) {
					return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE);
				} else {
					return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "该电子邮件地址已被注册");
				}
			} else {
				return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请正确填写电子邮件地址");
			}
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请填写电子邮件地址");
		}
	}

	/**
	 * <b>根据用户所提供的注册信息（email）完成用户注册</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doregister", method = RequestMethod.POST)
	public ResponseResult<User> registryUserByEmail(@RequestBody User user) throws Exception {
		// 校验用户所填写信息是否正确
		if (user.getUserCode() != null && !"".equals(user.getUserCode().trim())
				&& user.getUserPassword() != null && !"".equals(user.getUserPassword().trim())) {
			if (user.getUserCode().matches(emailRegEx)) {
				if (userTransport.checkEmailForRegistry(user.getUserCode())) {
					// 对于密码进行MDK5加密
					user.setUserPassword(MD5Util.encrypt(user.getUserPassword()));
					if (userTransport.registryUserByEmail(user)) {
						return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE);
					} else {
						return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "注册失败，请稍后再试");
					}
				} else {
					return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "该电子邮件地址已被注册");
				}
			} else {
				return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请正确填写电子邮件地址");
			}
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请填写电子邮件和登录密码");
		}
	}

	/**
	 * <b>使用激活码激活用户账号</b>
	 * @param user
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/activate", method = RequestMethod.PUT)
	public ResponseResult<User> activateUserForEmail(String user, String code) throws Exception {
		// 校验用户所填写的email地址和校验码是否为null
		if (user != null && !"".equals(user.trim()) && code != null && !"".equals(code.trim())) {
			// 此时的email和code都是不为null的
			// 校验电子邮件是否正确
			if (user.matches(emailRegEx)) {
				// 电子邮件格式正确
				// 进行激活的
				if (userTransport.activateUserForEmail(user, code)) {
					return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE);
				} else {
					return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "激活失败，请联系管理员");
				}
			} else {
				return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请填写正确的电子邮件地址");
			}
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请填写电子邮件和激活码");
		}
	}

	/**
	 * <b>用户登录</b>
	 * @param name
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public ResponseResult<User> loginUser(String name, String password) throws Exception {
		// 校验用户所提交的信息有效
		if (name != null && !"".equals(name.trim()) && password != null && !"".equals(password.trim())) {
			// 提交的信息有效，对于密码进行加密
			password = MD5Util.encrypt(password);
			// 进行用户登录
			User user = userTransport.getUserForLogin(name, password);
			if (user != null) {
				// 登陆成功
				// 绑定到Token中
				String token = JWTUtil.createToken(user.getId());
				response.setHeader("Authorization", token);
				return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, user);
			} else {
				return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "登陆失败，请稍后再试");
			}
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请填写手机号码或电子邮件以及登陆密码");
		}
	}
}
