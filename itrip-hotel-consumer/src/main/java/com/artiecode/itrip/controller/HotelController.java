package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.hotel.transport.HotelTransport;
import com.artiecode.itrip.pojo.entity.AreaDic;
import com.artiecode.itrip.pojo.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>酒店控制层</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("hotelController")
@RequestMapping("/biz/api/hotel")
public class HotelController extends BaseController {
	@Autowired
	private HotelTransport hotelTransport;

	/**
	 * <b>根据是否是国内查询热门城市列表</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotcity/{isChina}", method = RequestMethod.GET)
	public ResponseResult<Object> queryHotCityByIsChina(@PathVariable("isChina") Integer isChina) throws Exception {
		List<AreaDic> areaDicList = hotelTransport.queryHotCityByIsChina(isChina);
		return new ResponseResult<Object>(SuccessEnum.SUCCESS_TRUE, areaDicList);
	}
}
