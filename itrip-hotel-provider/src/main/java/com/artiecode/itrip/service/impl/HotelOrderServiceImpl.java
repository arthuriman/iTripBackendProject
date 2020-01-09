package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.HotelDao;
import com.artiecode.itrip.dao.HotelOrderDao;
import com.artiecode.itrip.dao.HotelRoomDao;
import com.artiecode.itrip.dao.LabelDicDao;
import com.artiecode.itrip.pojo.entity.*;
import com.artiecode.itrip.pojo.vo.*;
import com.artiecode.itrip.service.HotelOrderService;
import com.artiecode.itrip.util.DateUtil;
import com.artiecode.itrip.util.OrderNoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
	@Autowired
	private LabelDicDao labelDicDao;

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

	/**
	 * <b>根据订单ID查看个人订单详情</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<HotelOrder> getPersonalOrderInfo(Long orderId) throws Exception {
		// 封装查询参数Map集合
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("id", orderId);

		// 进行查询，获得结果集
		List<HotelOrder> orderList = hotelOrderDao.findOrderByQuery(queryMap);

		return orderList;
	}

	/**
	 * <b>根据订单ID查看个人订单详情-房型相关信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public PersonalOrderRoomVO getPersonalOrderRoomInfo(Long orderId) throws Exception {
		PersonalOrderRoomVO personalOrderRoomVO = new PersonalOrderRoomVO();

		Map<String, Object> queryMap = new HashMap<String, Object>();
		// 根据订单主键查询订单详情，
		queryMap.put("id", orderId);
		List<HotelOrder> orderList = hotelOrderDao.findOrderByQuery(queryMap);
		if (orderList != null && orderList.size() > 0) {
			// 根据订单获取酒店主键，查询酒店详情
			queryMap.put("id", orderList.get(0).getHotelId());
			List<Hotel> hotelList = hotelDao.findHotelListByQuery(queryMap);
			Hotel hotel = hotelList.get(0);
			// 根据定点获取房间主键，查询房间想抢
			queryMap.put("id", orderList.get(0).getRoomId());
			List<HotelRoom> roomList = hotelRoomDao.findHotelRoomListByQuery(queryMap);
			HotelRoom room = roomList.get(0);

			// 封装结果
			personalOrderRoomVO.setId(orderId);
			personalOrderRoomVO.setHotelId(hotel.getId());
			personalOrderRoomVO.setHotelName(hotel.getHotelName());
			personalOrderRoomVO.setHotelLevel(hotel.getHotelLevel());
			personalOrderRoomVO.setAddress(hotel.getAddress());

			personalOrderRoomVO.setRoomId(room.getId());
			personalOrderRoomVO.setRoomTitle(room.getRoomTitle());
			personalOrderRoomVO.setRoomBedTypeId(room.getRoomBedTypeId());
			// 根据床型ID，查询对应的文本内容
			queryMap.put("id", room.getRoomBedTypeId());
			List<LabelDic> labelDicList = labelDicDao.findLabelDicListByQuery(queryMap);
			personalOrderRoomVO.setRoomBedTypeName(labelDicList.get(0).getName());
			personalOrderRoomVO.setRoomPayType(room.getPayType());
			personalOrderRoomVO.setIsHavingBreakfast(room.getIsHavingBreakfast());

			personalOrderRoomVO.setCheckInDate(orderList.get(0).getCheckInDate());
			personalOrderRoomVO.setCheckOutDate(orderList.get(0).getCheckOutDate());
			personalOrderRoomVO.setCount(orderList.get(0).getCount());
			personalOrderRoomVO.setBookingDays(orderList.get(0).getBookingDays());
			personalOrderRoomVO.setLinkUserName(orderList.get(0).getLinkUserName());
			personalOrderRoomVO.setSpecialRequirement(orderList.get(0).getSpecialRequirement());
			personalOrderRoomVO.setPayAmount(orderList.get(0).getPayAmount());
		}

		return personalOrderRoomVO;
	}

	/**
	 * <b>根据订单ID获取订单信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public ModifyHotelOrderVO queryOrderById(Long orderId) throws Exception {
		// 创建ModifyHotelOrderVO对象
		ModifyHotelOrderVO hotelOrderVO = new ModifyHotelOrderVO();
		// 创建查询Map集合
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("id", orderId);

		List<HotelOrder> orderList = hotelOrderDao.findOrderByQuery(queryMap);
		if (orderList != null && orderList.size() > 0) {
			HotelOrder order = orderList.get(0);
			hotelOrderVO.setId(order.getId());
			hotelOrderVO.setPayType(order.getPayType());
			hotelOrderVO.setOrderType(order.getOrderType());
			hotelOrderVO.setOrderNo(order.getOrderNo());
			hotelOrderVO.setHotelId(order.getHotelId());
			hotelOrderVO.setHotelName(order.getHotelName());
			hotelOrderVO.setRoomId(order.getRoomId());
			hotelOrderVO.setCount(order.getCount());
			hotelOrderVO.setBookingDays(order.getBookingDays());
			hotelOrderVO.setCheckInDate(order.getCheckInDate());
			hotelOrderVO.setCheckOutDate(order.getCheckOutDate());
			hotelOrderVO.setNoticePhone(order.getNoticePhone());
			hotelOrderVO.setNoticeEmail(order.getNoticeEmail());
			hotelOrderVO.setSpecialRequirement(order.getSpecialRequirement());
			hotelOrderVO.setIsNeedInvoice(order.getIsNeedInvoice());
			hotelOrderVO.setInvoiceType(order.getInvoiceType());
			hotelOrderVO.setInvoiceHead(order.getInvoiceHead());
			hotelOrderVO.setLinkUserName(order.getLinkUserName());
			hotelOrderVO.setBookType(order.getBookType());

			// 根据订单编号查询联系人列表
			queryMap.remove("id");
			queryMap.put("orderId", orderId);
			List<OrderLinkUser> orderLinkUserList = hotelOrderDao.findOrderLinkUserListByQuery(queryMap);
			// 进行切换
			List<OrderLinkUserVO> orderLinkUserVOList = new ArrayList<>();
			for (OrderLinkUser orderLinkUser : orderLinkUserList) {
				OrderLinkUserVO orderLinkUserVO = new OrderLinkUserVO();
				BeanUtils.copyProperties(orderLinkUser, orderLinkUserVO);
				orderLinkUserVOList.add(orderLinkUserVO);
			}

			hotelOrderVO.setOrderLinkUserList(orderLinkUserVOList);
		}

		return hotelOrderVO;
	}

	public HotelOrder getOrderByNo(String orderNo) throws Exception {
		// 封装查询参数Map集合
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("orderNo", orderNo);

		// 进行查询，获得结果集
		List<HotelOrder> orderList = hotelOrderDao.findOrderByQuery(queryMap);

		if (orderList != null && orderList.size() > 0) {
			return orderList.get(0);
		}
		return null;
	}
}
