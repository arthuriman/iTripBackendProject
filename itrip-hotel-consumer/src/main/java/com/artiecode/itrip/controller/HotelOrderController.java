package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.hotel.transport.HotelOrderTransport;
import com.artiecode.itrip.pojo.entity.User;
import com.artiecode.itrip.pojo.vo.HotelOrderAddVO;
import com.artiecode.itrip.pojo.vo.ResponseResult;
import com.artiecode.itrip.pojo.vo.RoomStoreVO;
import com.artiecode.itrip.pojo.vo.ValidateRoomStoreVO;
import com.artiecode.itrip.user.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
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
}
