package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.CommentDao;
import com.artiecode.itrip.pojo.entity.Comment;
import com.artiecode.itrip.pojo.entity.ScoreComment;
import com.artiecode.itrip.pojo.vo.CommentCountVO;
import com.artiecode.itrip.pojo.vo.Page;
import com.artiecode.itrip.pojo.vo.SearchCommentVO;
import com.artiecode.itrip.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>评论业务层接口实现类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;

	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	public Page<Comment> getCommentListByPage(SearchCommentVO queryVO) throws Exception {
		// 根据查询视图进行封装查询Map集合
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("hotelId", queryVO.getHotelId());
		if (queryVO.getIsHavingImg() != -1) {
			queryMap.put("isHavingImg", queryVO.getIsHavingImg());
		}
		if (queryVO.getIsOk() != -1) {
			queryMap.put("isOk", queryVO.getIsOk());
		}
		queryMap.put("start", (queryVO.getPageNo() - 1) * queryVO.getPageSize());
		queryMap.put("size", queryVO.getPageSize());

		// 获取分页列表
		List<Comment> commentList = commentDao.findCommentByQuery(queryMap);
		// 获得总条数
		queryMap.remove("start");
		queryMap.remove("size");
		Integer total = commentDao.findCommentByQuery(queryMap).size();

		// 封装分页对象
		Page<Comment> page = new Page<Comment>(queryVO.getPageNo(), queryVO.getPageSize(), total);
		page.setRows(commentList);

		return page;
	}

	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	public ScoreComment getHotelScoreByHotelId(Long hotelId) throws Exception {
		return commentDao.findScoreCommentByHotelId(hotelId);
	}

	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	public CommentCountVO getCommentCountByHotelId(Long hotelId) throws Exception {
		CommentCountVO commentCountVO = new CommentCountVO();
		// 设定查询参数
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("hotelId", hotelId);
		// 查询总评论数
		commentCountVO.setAllcomment(commentDao.findCommentByQuery(queryMap).size());
		// 查询值得推荐
		queryMap.put("isOk", 1);
		commentCountVO.setIsok(commentDao.findCommentByQuery(queryMap).size());
		// 值得改善
		queryMap.put("isOk", 0);
		commentCountVO.setImprove(commentDao.findCommentByQuery(queryMap).size());
		// 有图片
		queryMap.remove("isOk");
		queryMap.put("isHavingImg", 1);
		commentCountVO.setHavingimg(commentDao.findCommentByQuery(queryMap).size());

		return commentCountVO;
	}
}
