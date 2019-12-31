package com.artiecode.itrip.hotel.transport;

import com.artiecode.itrip.pojo.entity.Comment;
import com.artiecode.itrip.pojo.entity.ScoreComment;
import com.artiecode.itrip.pojo.vo.CommentCountVO;
import com.artiecode.itrip.pojo.vo.Page;
import com.artiecode.itrip.pojo.vo.SearchCommentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>评论传输层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@FeignClient(name = "itrip-hotel-provider")
@RequestMapping("/comment")
public interface CommentTransport {

	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getcommentlist", method = RequestMethod.POST)
	Page<Comment> getCommentListByPage(@RequestBody SearchCommentVO queryVO) throws Exception;

	/**
	 * <b>据酒店id查询酒店平均分</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gethotelscore", method = RequestMethod.POST)
	ScoreComment getHotelScoreByHotelId(@RequestParam Long hotelId) throws Exception;

	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getcount", method = RequestMethod.POST)
	CommentCountVO getCommentCountByHotelId(@RequestParam Long hotelId) throws Exception;
}
