package com.artiecode.itrip.hotel.transport;

import com.artiecode.itrip.pojo.entity.HotelOrder;
import com.artiecode.itrip.pojo.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

	/**
	 * <b>根据订单ID查看个人订单详情</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderinfo", method = RequestMethod.POST)
	List<HotelOrder> getPersonalOrderInfo(@RequestParam Long orderId) throws Exception;

	/**
	 * <b>根据订单ID查看个人订单详情-房型相关信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderroominfo", method = RequestMethod.POST)
	PersonalOrderRoomVO getPersonalOrderRoomInfo(@RequestParam Long orderId) throws Exception;

	/**
	 * <b>根据订单ID获取订单信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryOrderById", method = RequestMethod.POST)
	ModifyHotelOrderVO queryOrderByID(@RequestParam Long orderId) throws Exception;

	@RequestMapping(value = "/queryOrderByNo", method = RequestMethod.POST)
	HotelOrder getHotelOrderByNo(@RequestParam String orderNo) throws Exception;

	@RequestMapping(value = "/getpersonalorderlist", method = RequestMethod.POST)
	Page<HotelOrder> getHotelOrderListByPage(@RequestBody SearchOrderVO searchOrderVO) throws Exception;
}
