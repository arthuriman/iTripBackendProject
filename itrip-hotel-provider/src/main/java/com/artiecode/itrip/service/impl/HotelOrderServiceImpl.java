package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.HotelDao;
import com.artiecode.itrip.dao.HotelOrderDao;
import com.artiecode.itrip.dao.HotelRoomDao;
import com.artiecode.itrip.pojo.entity.Hotel;
import com.artiecode.itrip.pojo.entity.HotelOrder;
import com.artiecode.itrip.pojo.entity.HotelRoom;
import com.artiecode.itrip.pojo.entity.UserLinkUser;
import com.artiecode.itrip.pojo.vo.HotelOrderAddVO;
import com.artiecode.itrip.pojo.vo.RoomStoreVO;
import com.artiecode.itrip.pojo.vo.ValidateRoomStoreVO;
import com.artiecode.itrip.service.HotelOrderService;
import com.artiecode.itrip.util.DateUtil;
import com.artiecode.itrip.util.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

	/**
	 * <b>新增酒店订单</b>
	 * @param hotelOrderAddVO
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> addHotelOrder(HotelOrderAddVO hotelOrderAddVO) throws Exception {
		// 创建酒店订单实体对象
		HotelOrder hotelOrder = new HotelOrder();
		hotelOrder.setUserId(hotelOrderAddVO.getUserId());
		// 设定订单编号
		hotelOrder.setOrderNo(OrderNoUtil.createOrderNo(hotelOrderAddVO.getHotelId(), hotelOrderAddVO.getRoomId()));
		// 设定订单类型
		hotelOrder.setOrderType(hotelOrderAddVO.getOrderType());
		hotelOrder.setHotelId(hotelOrderAddVO.getHotelId());
		hotelOrder.setHotelName(hotelOrderAddVO.getHotelName());
		hotelOrder.setRoomId(hotelOrderAddVO.getRoomId());
		hotelOrder.setCount(hotelOrderAddVO.getCount());
		// 获取订阅天数
		Date checkInDate = DateUtil.parseToDate(hotelOrderAddVO.getCheckInDate());
		hotelOrder.setCheckInDate(checkInDate);
		Date checkOutDate = DateUtil.parseToDate(hotelOrderAddVO.getCheckOutDate());
		hotelOrder.setCheckOutDate(checkOutDate);
		Integer days = (int) (checkOutDate.getTime() - checkInDate.getTime()) / 1000 / 60 / 60 /24;
		hotelOrder.setBookingDays(days);

		hotelOrder.setOrderStatus(0);

		// 计算总价格
		Map<String, Object> hotelRoomQuery = new HashMap<String, Object>();
		hotelRoomQuery.put("id", hotelOrder.getRoomId());
		List<HotelRoom> hotelRoomList = hotelRoomDao.findHotelRoomListByQuery(hotelRoomQuery);
		if (hotelRoomList != null && hotelRoomList.size() > 0) {
			hotelOrder.setPayAmount(hotelRoomList.get(0).getRoomPrice() * hotelOrder.getBookingDays());
		}

		hotelOrder.setNoticePhone(hotelOrderAddVO.getNoticePhone());
		hotelOrder.setNoticeEmail(hotelOrderAddVO.getNoticeEmail());
		hotelOrder.setSpecialRequirement(hotelOrderAddVO.getSpecialRequirement());
		hotelOrder.setIsNeedInvoice(hotelOrderAddVO.getIsNeedInvoice());
		hotelOrder.setInvoiceType(hotelOrderAddVO.getInvoiceType());
		hotelOrder.setInvoiceHead(hotelOrderAddVO.getInvoiceHead());

		// 拼接联系人
		StringBuffer sb = new StringBuffer();
		for (UserLinkUser userLinkUser : hotelOrderAddVO.getLinkUser()) {
			sb.append(userLinkUser.getLinkUserName() + ",");
		}
		hotelOrder.setLinkUserName(sb.toString());

		hotelOrder.setCreationDate(new Date());

		// 保存用户信息
		try {
			hotelOrderDao.saveOrder(hotelOrder);
			// 根据订单编号查询订单信息
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("orderNo", hotelOrder.getOrderNo());

			List<HotelOrder> hotelOrderList = hotelOrderDao.findOrderByQuery(queryMap);
			if (hotelOrderList != null && hotelOrderList.size() > 0) {
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("id", hotelOrderList.get(0).getId());
				resultMap.put("orderNo", hotelOrderList.get(0).getOrderNo());
				return resultMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
