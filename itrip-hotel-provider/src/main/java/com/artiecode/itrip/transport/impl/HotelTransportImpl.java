package com.artiecode.itrip.transport.impl;

import com.artiecode.itrip.hotel.transport.HotelTransport;
import com.artiecode.itrip.pojo.entity.AreaDic;
import com.artiecode.itrip.pojo.entity.Hotel;
import com.artiecode.itrip.pojo.entity.LabelDic;
import com.artiecode.itrip.pojo.vo.SearchDetailsHotelVO;
import com.artiecode.itrip.pojo.vo.SearchPolicyHotelVO;
import com.artiecode.itrip.service.AreaDicService;
import com.artiecode.itrip.service.HotelService;
import com.artiecode.itrip.service.LabelDicService;
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
	@Autowired
	private LabelDicService labelDicService;
	@Autowired
	private HotelService hotelService;

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

	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfeature", method = RequestMethod.GET)
	public List<LabelDic> queryHotelFeature() throws Exception {
		return labelDicService.queryHotelFeature();
	}

	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getvideodesc", method = RequestMethod.POST)
	public Hotel queryHotelVideoDescByHotelId(@RequestParam Long hotelId) throws Exception {
		return hotelService.queryHotelVideoDescByHotelId(hotelId);
	}

	/**
	 * <b>根据酒店id查询酒店政策</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelpolicy", method = RequestMethod.POST)
	public String queryHotelPolicy(@RequestParam Long id) throws Exception {
		return hotelService.queryHotelPolicy(id);
	}

	/**
	 * <b>查询酒店详情</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhoteldetails", method = RequestMethod.POST)
	public List<SearchDetailsHotelVO> queryHotelDetails(@RequestParam Long hotelId) throws Exception {
		return hotelService.queryHotelDetails(hotelId);
	}

	/**
	 * <b>根据酒店id查询酒店设施</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfacilities")
	public String queryHotelFacilities(@RequestParam Long hotelId) throws Exception {
		return hotelService.queryHotelFacilities(hotelId);
	}
}
