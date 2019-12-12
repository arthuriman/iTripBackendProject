package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.entity.User;

/**
 * <b>用户信息业务层接口</b>
 * @author Arthur
 * @version 3.1.1 2019-12-12
 * @since 3.1.1
 */
public interface UserService {
	/**
	 * <b>通过userCode查询User对象</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	User getUserByUserCode(String userCode) throws Exception;
}
