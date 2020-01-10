package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.hotel.transport.HotelOrderTransport;
import com.artiecode.itrip.pojo.entity.HotelOrder;
import com.artiecode.itrip.pojo.entity.User;
import com.artiecode.itrip.pojo.vo.*;
import com.artiecode.itrip.user.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("hotelOrderController")
@RequestMapping("/biz/api/hotelorder")
public class HotelOrderController extends BaseController {
	@Autowired
	private HotelOrderTransport hotelOrderTransport;
	@Autowired
	private UserTransport userTransport;

	/**
	 * <b>生成订单前,获取预订信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpreorderinfo", method = RequestMethod.POST)
	public ResponseResult<Object> getPreOrderInfo(@RequestBody ValidateRoomStoreVO validateRoomStoreVO) throws Exception {
		RoomStoreVO roomStoreVO = hotelOrderTransport.getPreOrderInfo(validateRoomStoreVO);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, roomStoreVO);
	}

	/**
	 * <b>生成订单</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addhotelorder", method = RequestMethod.POST)
	public ResponseResult<Object> addHotelOrder(@RequestBody HotelOrderAddVO hotelOrderAddVO) throws Exception {
		// 判断此时是否有房间库存
		ValidateRoomStoreVO queryVO = new ValidateRoomStoreVO();
		queryVO.setCheckInDate(hotelOrderAddVO.getCheckInDate());
		queryVO.setCheckOutDate(hotelOrderAddVO.getCheckOutDate());
		queryVO.setCount(hotelOrderAddVO.getCount());
		queryVO.setHotelId(hotelOrderAddVO.getHotelId());
		queryVO.setRoomId(hotelOrderAddVO.getRoomId());

		RoomStoreVO roomStoreVO = hotelOrderTransport.getPreOrderInfo(queryVO);
		// 获得库存信息
		Integer store = roomStoreVO.getStore();
		if (store != null && store >= hotelOrderAddVO.getCount()) {
			// 获得当前登录用户
			Cookie[] cookies = request.getCookies();
			String userCode = "";
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					userCode = cookie.getValue();
				}
			}
			System.out.println(userCode);
			// 酒店的数据满足
			// 开始进行入库操作
			// 获得当前登录用户主键
			User user = userTransport.getUserByUserCode(userCode);
			hotelOrderAddVO.setUserId(user.getId());
			Map<String, Object> resultMap = hotelOrderTransport.addHotelOrder(hotelOrderAddVO);
			if (resultMap != null) {
				return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, resultMap);
			}
		} else {
			return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "库存不足");
		}

		return null;
	}

	/**
	 * <b>根据订单ID查看个人订单详情</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderinfo/{orderId}", method = RequestMethod.GET)
	public ResponseResult<Object> getPersonalOrderInfo(@PathVariable("orderId") Long orderId) throws Exception {
		List<HotelOrder> orderList = hotelOrderTransport.getPersonalOrderInfo(orderId);
		if (orderList != null && orderList.size() > 0) {
			return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, orderList.get(0));
		}
		return new ResponseResult<>(SuccessEnum.SUCCESS_FALSE, "未获得结果");
	}

	/**
	 * <b>根据订单ID查看个人订单详情-房型相关信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderroominfo/{orderId}", method = RequestMethod.GET)
	public ResponseResult<Object> getPersonalOrderRoomInfo(@PathVariable("orderId") Long orderId) throws Exception {
		PersonalOrderRoomVO personalOrderRoomVO = hotelOrderTransport.getPersonalOrderRoomInfo(orderId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, personalOrderRoomVO);
	}

	/**
	 * <b>根据订单ID获取订单信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryOrderById/{orderId}", method = RequestMethod.GET)
	public ResponseResult<Object> queryOrderById(@PathVariable("orderId") Long orderId) throws Exception {
		ModifyHotelOrderVO hotelOrderVO = hotelOrderTransport.queryOrderByID(orderId);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, orderId);
	}

	/**
	 * <b>根据个人订单列表，并分页显示</b>
	 * @param searchOrderVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getpersonalorderlist", method = RequestMethod.POST)
	public ResponseResult<Object> getPersonalOrderList(@RequestBody SearchOrderVO searchOrderVO) throws Exception {
		// 获得当前登录用户信息
		String userCode = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				userCode = cookie.getValue();
			}
		}

		// 将userCode封装到SearchOrderVO中
		searchOrderVO.setUserCode(userCode);

		Page<HotelOrder> page = hotelOrderTransport.getHotelOrderListByPage(searchOrderVO);
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, page);
	}
}
