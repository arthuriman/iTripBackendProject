package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.UserDao;
import com.artiecode.itrip.pojo.entity.User;
import com.artiecode.itrip.service.UserService;
import com.artiecode.itrip.util.ConstantUtil;
import com.artiecode.itrip.util.SystemCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private JavaMailSender mailSender;

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

	/**
	 * <b>保存用户信息，保存成功后，根据用户的userCode类型进行相关验证码的发送工作</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean saveUser(User user) throws Exception {
		try {
			// 将数据保存到数据库中
			userDao.saveUser(user);
			// 产生激活码
			String activeCode = SystemCodeUtil.createActiveCode();
			// 将激活码保存到Redis中
			redisTemplate.opsForValue().set(user.getUserCode(), activeCode);
			// 对于该存入redis的key设置过期时间
			redisTemplate.expire(user.getUserCode(), ConstantUtil.ACTIVE_CODE_TIMEOUT * 60, TimeUnit.SECONDS);

			// 发送邮件到用户邮箱
			// 设定发送人
			// 创建邮件发送对象，使用MimeMailMessage对象可以发送HTML格式的邮件
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(ConstantUtil.MAIL_FROM);
			mailMessage.setTo(user.getUserCode());
			mailMessage.setSubject("爱旅行-爱文强账户激活码");
			mailMessage.setText("您的激活码是："+ activeCode + "请在" + ConstantUtil.ACTIVE_CODE_TIMEOUT + "分钟内登录系统，输入本验证码激活您的账户！");
			mailSender.send(mailMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
