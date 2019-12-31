package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.hotel.transport.HotelTransport;
import com.artiecode.itrip.pojo.entity.AreaDic;
import com.artiecode.itrip.pojo.entity.Hotel;
import com.artiecode.itrip.pojo.entity.LabelDic;
import com.artiecode.itrip.pojo.vo.ResponseResult;
import com.artiecode.itrip.pojo.vo.SearchDetailsHotelVO;
import com.artiecode.itrip.pojo.vo.SearchPolicyHotelVO;
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

	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfeature", method = RequestMethod.GET)
	public ResponseResult<Object> queryHotelFeature() throws Exception {
		List<LabelDic> labelDicList = hotelTransport.queryHotelFeature();
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, labelDicList);
	}

	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getvideodesc/{hotelId}", method = RequestMethod.GET)
	public ResponseResult<Object> getVideoDesc(@PathVariable("hotelId") Long hotelId) throws Exception {
		// 根据酒店id查询具体的酒店对象
		Hotel hotel = hotelTransport.queryHotelVideoDescByHotelId(hotelId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, hotel);
	}

	/**
	 * <b>根据酒店id查询酒店政策</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelpolicy/{hotelId}", method = RequestMethod.GET)
	public ResponseResult<Object> queryHotelPolicy(@PathVariable("hotelId") Long hotelId) throws Exception {
		String hotelPolicy = hotelTransport.queryHotelPolicy(hotelId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, "", hotelPolicy);
	}

	/**
	 * <b>查询酒店详情</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhoteldetails/{hotelId}", method = RequestMethod.GET)
	public ResponseResult<Object> queryHotelDetails(@PathVariable("hotelId") Long hotelId) throws Exception {
		List<SearchDetailsHotelVO> detailsHotelVOList = hotelTransport.queryHotelDetails(hotelId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, detailsHotelVOList);
	}

	/**
	 * <b>根据酒店id查询酒店设施</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfacilities/{hotelId}", method = RequestMethod.GET)
	public ResponseResult<Object> queryHotelFacilities(@PathVariable("hotelId") Long hotelId) throws Exception {
		String hotelfacilities = hotelTransport.queryHotelFacilities(hotelId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, "", hotelfacilities);
	}
}
