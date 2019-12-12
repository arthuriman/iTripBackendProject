package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.UserDao;
import com.artiecode.itrip.pojo.entity.User;
import com.artiecode.itrip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>用户信息业务层接口实现类</b>
 * @author Arthur
 * @version 3.1.1 2019-12-12
 * @since 3.1.1
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * <b>通过userCode查询User对象</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User getUserByUserCode(String userCode) throws Exception {
		// 封装查询参数
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userCode", userCode);

		// 进行查询
		List<User> userList = userDao.findUserByQuery(queryMap);

		// 对于得到的结果进行判断
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}
}
