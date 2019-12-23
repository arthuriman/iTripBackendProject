package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.UserDao;
import com.artiecode.itrip.pojo.entity.User;
import com.artiecode.itrip.service.UserService;
import com.artiecode.itrip.util.ActiveCodeUtil;
import com.artiecode.itrip.util.ConstantUtil;
import com.artiecode.itrip.util.communication.email.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <b>用户子项目业务层接口实现类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private EmailUtil emailUtil;
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * <b>根据用户提供的电子邮件地址，校验是否可以注册使用</b>
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public boolean checkEmailForRegistry(String email) throws Exception {
		// 根据用户所提供的Email地址在数据库中进行查询
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userCode", email);
		// 进行查询
		List<User> userList = userDao.findUserListByQuery(queryMap);

		if (userList != null && userList.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * <b>使用电子邮件完成用户注册</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean registryUserByEmail(User user) throws Exception {
		try {
			// 保存用户信息
			userDao.saveUser(user);
			// 生成激活码
			String activeCode = ActiveCodeUtil.createActiveCode();
			// 发送邮件
			emailUtil.sendEmail(user.getUserCode(), activeCode);
			// 将激活码保存到Redis中
			redisTemplate.opsForValue().set(user.getUserCode(), activeCode);
			// 对于该存入redis的key设置过期时间
			redisTemplate.expire(user.getUserCode(), ConstantUtil.ACTIVE_CODE_TIMEOUT * 60, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
