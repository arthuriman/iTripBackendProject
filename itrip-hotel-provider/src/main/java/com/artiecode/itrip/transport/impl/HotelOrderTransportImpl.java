package com.artiecode.itrip.transport.impl;

import com.artiecode.itrip.hotel.transport.HotelOrderTransport;
import com.artiecode.itrip.pojo.vo.HotelOrderAddVO;
import com.artiecode.itrip.pojo.vo.RoomStoreVO;
import com.artiecode.itrip.pojo.vo.ValidateRoomStoreVO;
import com.artiecode.itrip.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("hotelOrderTransport")
@RequestMapping("/hotelorder")
public class HotelOrderTransportImpl implements HotelOrderTransport {
	@Autowired
	private HotelOrderService hotelOrderService;

	/**
	 * <b>生成订单前,获取预订信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpreorderinfo", method = RequestMethod.POST)
	public RoomStoreVO getPreOrderInfo(@RequestBody ValidateRoomStoreVO validateRoomStoreVO) throws Exception {
		return hotelOrderService.getPreOrderInfo(validateRoomStoreVO);
	}

	/**
	 * <b>新增酒店订单</b>
	 * @param hotelOrderAddVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addhotelorder", method = RequestMethod.POST)
	public Map<String, Object> addHotelOrder(@RequestBody HotelOrderAddVO hotelOrderAddVO) throws Exception {
		return hotelOrderService.addHotelOrder(hotelOrderAddVO);
	}
}
