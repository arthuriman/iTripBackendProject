package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.pojo.vo.Dto;
import com.artiecode.itrip.pojo.vo.ItripHotelVO;
import com.artiecode.itrip.pojo.vo.Page;
import com.artiecode.itrip.pojo.vo.SearchHotCityVO;
import com.artiecode.itrip.transport.SearchTransport;
import com.artiecode.itrip.util.DtoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>搜索模块控制器</b>
 * @author Arthur
 * @version 3.1.1
 * @since 3.1.1
 */
@Api(value = "搜索控制器")
@RestController("searchController")
@RequestMapping("/search")
public class SearchController extends BaseController {
	@Autowired
	private SearchTransport searchTransport;

	@ApiOperation(value = "根据热门城市搜索酒店列表")
	@ApiImplicitParam(name = "SearchHotCityVO", value = "热门城市搜索视图")
	@RequestMapping(value = "/api/hotellist/searchItripHotelListByHotCity", method = RequestMethod.POST)
	public Dto<Object> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO searchHotCityVO) throws Exception {
		Dto<Object> resultDto = new Dto<Object>();
		List<ItripHotelVO> itripHotelVOList = searchTransport.searchItripHotelListByHotCity(searchHotCityVO);
		// 产生结果数据
		resultDto.setSuccess("true");
		resultDto.setData(itripHotelVOList);
		return resultDto;
	}
}
