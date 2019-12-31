package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.vo.HotelVO;
import com.artiecode.itrip.pojo.vo.SearchHotCityVO;

import java.util.List;

/**
 * <b>搜索项目业务层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public interface SearchService {

	/**
	 * <b>根据热门城市搜索视图查询酒店列表</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	List<HotelVO> searchItripHotelListByHotCity(SearchHotCityVO searchHotCityVO) throws Exception;
}
