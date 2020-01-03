package com.artiecode.itrip.hotel.transport;

import com.artiecode.itrip.pojo.vo.HotelOrderAddVO;
import com.artiecode.itrip.pojo.vo.RoomStoreVO;
import com.artiecode.itrip.pojo.vo.ValidateRoomStoreVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * <b>酒店订单模块传输层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@FeignClient("itrip-hotel-provider")
@RequestMapping("/hotelorder")
public interface HotelOrderTransport {
	/**
	 * <b>生成订单前,获取预订信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpreorderinfo", method = RequestMethod.POST)
	RoomStoreVO getPreOrderInfo(@RequestBody ValidateRoomStoreVO validateRoomStoreVO) throws Exception;

	/**
	 * <b>新增酒店订单</b>
	 * @param hotelOrderAddVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addhotelorder", method = RequestMethod.POST)
	Map<String, Object> addHotelOrder(@RequestBody HotelOrderAddVO hotelOrderAddVO) throws Exception;
}
