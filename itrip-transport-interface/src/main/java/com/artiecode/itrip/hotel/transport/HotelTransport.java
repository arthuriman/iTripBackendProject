package com.artiecode.itrip.hotel.transport;

import com.artiecode.itrip.pojo.entity.AreaDic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>酒店项目传输层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@FeignClient(name = "itrip-hotel-provider")
@RequestMapping("/hotel")
public interface HotelTransport {
	/**
	 * <b>根据是否是中国查询对应的热门城市</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotcity", method = RequestMethod.POST)
	List<AreaDic> queryHotCityByIsChina(@RequestParam Integer isChina) throws Exception;
}
