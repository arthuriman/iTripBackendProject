package com.artiecode.itrip.base.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>基础控制器</b>
 * @author Arthur
 * @version 3.1.1 2019-12-11 从原有的项目中移入到itrip-commons中
 * @version 3.1.0 2019-12-11
 * @since 3.1.0
 */
public class BaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	@Autowired
	protected HttpSession session;
}
