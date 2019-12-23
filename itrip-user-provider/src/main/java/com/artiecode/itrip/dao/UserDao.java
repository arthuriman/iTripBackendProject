package com.artiecode.itrip.dao;

import com.artiecode.itrip.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>用户子项目数据持久层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Repository
public interface UserDao {
	/**
	 * <b>根据查询条件查询用户信息列表</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<User> findUserListByQuery(Map<String, Object> queryMap) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @throws Exception
	 */
	void saveUser(User user) throws Exception;
}
