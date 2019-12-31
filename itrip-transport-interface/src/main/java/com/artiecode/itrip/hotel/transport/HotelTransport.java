package com.artiecode.itrip.hotel.transport;

import com.artiecode.itrip.pojo.entity.AreaDic;
import com.artiecode.itrip.pojo.entity.Hotel;
import com.artiecode.itrip.pojo.entity.LabelDic;
import com.artiecode.itrip.pojo.vo.SearchDetailsHotelVO;
import com.artiecode.itrip.pojo.vo.SearchPolicyHotelVO;
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

	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfeature", method = RequestMethod.GET)
	List<LabelDic> queryHotelFeature() throws Exception;

	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getvideodesc", method = RequestMethod.POST)
	Hotel queryHotelVideoDescByHotelId(@RequestParam Long hotelId) throws Exception;

	/**
	 * <b>根据酒店id查询酒店政策</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelpolicy", method = RequestMethod.POST)
	String queryHotelPolicy(@RequestParam Long id) throws Exception;

	/**
	 * <b>查询酒店详情</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhoteldetails", method = RequestMethod.POST)
	List<SearchDetailsHotelVO> queryHotelDetails(@RequestParam Long hotelId) throws Exception;

	/**
	 * <b>根据酒店id查询酒店设施</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelfacilities")
	String queryHotelFacilities(@RequestParam Long hotelId) throws Exception;
}
