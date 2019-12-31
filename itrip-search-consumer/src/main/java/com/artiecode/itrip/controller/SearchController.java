package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.pojo.vo.HotelVO;
import com.artiecode.itrip.pojo.vo.ResponseResult;
import com.artiecode.itrip.pojo.vo.SearchHotCityVO;
import com.artiecode.itrip.search.transport.SearchTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>搜索模块控制器</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("searchController")
@RequestMapping("/search/api")
public class SearchController extends BaseController {
	@Autowired
	private SearchTransport searchTransport;

	/**
	 * <b>根据查询视图，查询搜索热门城市</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/hotellist/searchItripHotelListByHotCity", method = RequestMethod.POST)
	public ResponseResult<Object> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO searchHotCityVO)
			throws Exception {
		// 校验所传递的数据是否有效
		if (searchHotCityVO.getCityId() != null && searchHotCityVO.getCityId() > 0
				&& searchHotCityVO.getCount() != null && searchHotCityVO.getCount() > 0) {
			List<HotelVO> itripHotelVOList = searchTransport.searchItripHotelListByHotCity(searchHotCityVO);
			return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, itripHotelVOList);
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "请填写有效信息");
		}
	}
}
