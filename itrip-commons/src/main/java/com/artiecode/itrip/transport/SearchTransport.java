package com.artiecode.itrip.transport;

import com.artiecode.itrip.pojo.vo.ItripHotelVO;
import com.artiecode.itrip.pojo.vo.SearchHotCityVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <b>查询模块传输层接口</b>
 * @author Arthur
 * @version 3.1.1
 * @since 3.1.1
 */
@FeignClient(name = "itrip-search-provider")
@RequestMapping("/search")
public interface SearchTransport {
	/**
	 * <b>根据查询视图获得热门城市酒店列表</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchItripHotelListByHotCity", method = RequestMethod.POST)
	List<ItripHotelVO> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO searchHotCityVO) throws Exception;
}
