package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.pojo.entity.User;
import com.artiecode.itrip.pojo.vo.ResponseResult;
import com.artiecode.itrip.user.transport.UserTransport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
	@Autowired
	private UserTransport userTransport;

	@ApiOperation(value = "校验用户注册所提供的Email地址是否可用")
	@RequestMapping(value = "/ckusr", method = RequestMethod.GET)
	public ResponseResult<User> checkEmailForRegistry(String name) throws Exception {
		// 校验用户所给定的email是否被占用
		boolean flag = userTransport.checkEmailForRegistry(name);
		if (flag) {
			// 校验正确，返回正确的数据
			return new ResponseResult<User>(SuccessEnum.SUCCESS_TRUE);
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "该Email地址不可用");
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
		boolean flag = userTransport.registryUserByEmail(user);
		System.out.println(flag);
		if (flag) {
			return new ResponseResult<User>(SuccessEnum.SUCCESS_TRUE);
		} else {
			return new ResponseResult<User>(SuccessEnum.SUCCESS_FALSE, "注册失败，请稍后再试");
		}
	}
}
