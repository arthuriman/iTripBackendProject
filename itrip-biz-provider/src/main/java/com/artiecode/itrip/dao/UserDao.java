package com.artiecode.itrip.dao;

import com.artiecode.itrip.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>用户信息数据持久层接口</b>
 * @author Arthur
 * @version 3.1.1 2019-12-12
 * @since 3.1.1
 */
@Repository
public interface UserDao {
	/**
	 * <b>通过查询条件查询用户信息列表</b>
	 * <p>本方法自带分页查询，前提是携带key为begin的参数</p>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<User> findUserByQuery(Map<String, Object> queryMap) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @throws Exception
	 */
	void saveUser(User user) throws Exception;
}
