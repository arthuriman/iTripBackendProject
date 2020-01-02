package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.pojo.entity.UserLinkUser;
import com.artiecode.itrip.pojo.vo.ResponseResult;
import com.artiecode.itrip.pojo.vo.ValidateRoomStoreVO;
import com.artiecode.itrip.user.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import java.util.List;

/**
 * <b>用户信息控制器</b>
 */
@RestController("userInfoController")
@RequestMapping("/biz/api/userinfo")
public class UserInfoController extends BaseController {
	@Autowired
	private UserTransport userTransport;

	@RequestMapping(value = "/queryuserlinkuser", method = RequestMethod.POST)
	public ResponseResult<Object> queryUserLinkUser(@RequestBody ValidateRoomStoreVO vo) throws Exception {
		// 获得所有的Cookie
		Cookie[] cookies = request.getCookies();
		String userCode = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				userCode = cookie.getValue();
			}
		}

		// 根据当前登录用户信息获得常用联系人表
		List<UserLinkUser> linkUserList = userTransport.getLinkUserListByLogin(userCode);
		return new ResponseResult<Object>(SuccessEnum.SUCCESS_TRUE, linkUserList);
	}
}
