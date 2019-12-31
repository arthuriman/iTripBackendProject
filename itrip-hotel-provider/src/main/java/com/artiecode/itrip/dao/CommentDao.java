package com.artiecode.itrip.dao;

import com.artiecode.itrip.pojo.entity.Comment;
import com.artiecode.itrip.pojo.entity.ScoreComment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>评论数据持久层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Repository
public interface CommentDao {
	/**
	 * <b>根据条件查询评论列表</b>
	 * @param queryMap
	 * @return
	 */
	List<Comment> findCommentByQuery(Map<String, Object> queryMap) throws Exception;

	/**
	 * <b>根据酒店id获得分数平均对象</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	ScoreComment findScoreCommentByHotelId(Long hotelId) throws Exception;
}
