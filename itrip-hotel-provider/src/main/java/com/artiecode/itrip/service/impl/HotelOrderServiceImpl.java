package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.HotelDao;
import com.artiecode.itrip.dao.HotelOrderDao;
import com.artiecode.itrip.dao.HotelRoomDao;
import com.artiecode.itrip.pojo.entity.Hotel;
import com.artiecode.itrip.pojo.entity.HotelRoom;
import com.artiecode.itrip.pojo.vo.RoomStoreVO;
import com.artiecode.itrip.pojo.vo.ValidateRoomStoreVO;
import com.artiecode.itrip.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>酒店订单模块业务层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Service("hotelOrderService")
@Transactional
public class HotelOrderServiceImpl implements HotelOrderService {
	@Autowired
	private HotelOrderDao hotelOrderDao;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private HotelRoomDao hotelRoomDao;

	/**
	 * <b>生成订单前,获取预订信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	public RoomStoreVO getPreOrderInfo(ValidateRoomStoreVO validateRoomStoreVO) throws Exception {
		RoomStoreVO roomStoreVO = new RoomStoreVO();

		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("hotelId", validateRoomStoreVO.getHotelId());
		queryMap.put("roomId", validateRoomStoreVO.getRoomId());
		queryMap.put("checkInDate", validateRoomStoreVO.getCheckInDate());
		queryMap.put("checkOutDate", validateRoomStoreVO.getCheckOutDate());

		// 查询临时库存表获得对应的库存信息
		Integer store = hotelOrderDao.findStoreByPreOrder(queryMap);
		// 查询此时酒店中已经下单预定，未付款的订单所占用的酒店库存
		Integer count = hotelOrderDao.findCountByOrderNoPay(queryMap);

		if (store != null) {
			roomStoreVO.setStore(store - count);
		} else {
			Integer totalStore = hotelRoomDao.findTotalRoomStore(validateRoomStoreVO.getRoomId());
			roomStoreVO.setStore(totalStore);
		}

		// 获得hotel信息
		Map<String, Object> hotelQueryMap = new HashMap<>();
		hotelQueryMap.put("id", validateRoomStoreVO.getHotelId());
		List<Hotel> hotelList = hotelDao.findHotelListByQuery(hotelQueryMap);
		if (hotelList != null && hotelList.size() > 0) {
			roomStoreVO.setHotelId(hotelList.get(0).getId());
			roomStoreVO.setHotelName(hotelList.get(0).getHotelName());
		}

		// 获得房间信息
		Map<String, Object> roomQueryMap = new HashMap<>();
		roomQueryMap.put("id", validateRoomStoreVO.getRoomId());
		List<HotelRoom> roomList = hotelRoomDao.findHotelRoomListByQuery(roomQueryMap);
		if (roomList != null && roomList.size() > 0) {
			roomStoreVO.setPrice(roomList.get(0).getRoomPrice());
		}

		return roomStoreVO;
	}
}
