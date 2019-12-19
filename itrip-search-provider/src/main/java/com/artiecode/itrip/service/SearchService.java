package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.vo.ItripHotelVO;
import com.artiecode.itrip.pojo.vo.SearchHotCityVO;

import java.util.List;

/**
 * <b>搜索模块业务层接口</b>
 * @author Arthur
 * @version 3.1.1
 * @since 3.1.1
 */
public interface SearchService {
	/**
	 * <b>根据查询视图获得热门城市酒店列表</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	List<ItripHotelVO> searchItripHotelListByHotCity(SearchHotCityVO searchHotCityVO) throws Exception;
}
