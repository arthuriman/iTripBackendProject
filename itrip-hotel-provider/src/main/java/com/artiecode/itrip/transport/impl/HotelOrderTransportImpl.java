package com.artiecode.itrip.transport.impl;

import com.artiecode.itrip.hotel.transport.HotelOrderTransport;
import com.artiecode.itrip.pojo.entity.HotelOrder;
import com.artiecode.itrip.pojo.vo.*;
import com.artiecode.itrip.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

	/**
	 * <b>根据订单ID查看个人订单详情</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderinfo", method = RequestMethod.POST)
	public List<HotelOrder> getPersonalOrderInfo(@RequestParam Long orderId) throws Exception {
		return hotelOrderService.getPersonalOrderInfo(orderId);
	}

	/**
	 * <b>根据订单ID查看个人订单详情-房型相关信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderroominfo", method = RequestMethod.POST)
	public PersonalOrderRoomVO getPersonalOrderRoomInfo(@RequestParam Long orderId) throws Exception {
		return hotelOrderService.getPersonalOrderRoomInfo(orderId);
	}

	/**
	 * <b>根据订单ID获取订单信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryOrderById", method = RequestMethod.POST)
	public ModifyHotelOrderVO queryOrderByID(@RequestParam Long orderId) throws Exception {
		return hotelOrderService.queryOrderById(orderId);
	}
}
