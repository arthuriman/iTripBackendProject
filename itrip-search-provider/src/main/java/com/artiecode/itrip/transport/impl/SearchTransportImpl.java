package com.artiecode.itrip.transport.impl;

import com.artiecode.itrip.pojo.vo.ItripHotelVO;
import com.artiecode.itrip.pojo.vo.SearchHotCityVO;
import com.artiecode.itrip.service.SearchService;
import com.artiecode.itrip.transport.SearchTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>搜索传输层接口实现类</b>
 * @author Arthur
 * @version 3.1.1
 * @since 3.1.1
 */
@RestController("searchTransport")
@RequestMapping("/search")
public class SearchTransportImpl implements SearchTransport {
	@Autowired
	private SearchService searchService;

	/**
	 * <b>根据查询视图获得热门城市酒店列表</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchItripHotelListByHotCity", method = RequestMethod.POST)
	public List<ItripHotelVO> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO searchHotCityVO) throws Exception {
		return searchService.searchItripHotelListByHotCity(searchHotCityVO);
	}
}
