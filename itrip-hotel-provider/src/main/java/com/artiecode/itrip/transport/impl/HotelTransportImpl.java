package com.artiecode.itrip.transport.impl;

import com.artiecode.itrip.hotel.transport.HotelTransport;
import com.artiecode.itrip.pojo.entity.AreaDic;
import com.artiecode.itrip.service.AreaDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>酒店项目传输层接口实现类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("hotelTransport")
@RequestMapping("/hotel")
public class HotelTransportImpl implements HotelTransport {
	@Autowired
	private AreaDicService areaDicService;

	/**
	 * <b>根据是否是中国查询对应的热门城市</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotcity", method = RequestMethod.POST)
	public List<AreaDic> queryHotCityByIsChina(@RequestParam Integer isChina) throws Exception {
		return areaDicService.queryHotCityByIsChina(isChina);
	}
}
