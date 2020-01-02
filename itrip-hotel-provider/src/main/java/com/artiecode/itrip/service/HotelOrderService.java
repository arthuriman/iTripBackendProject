package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.vo.RoomStoreVO;
import com.artiecode.itrip.pojo.vo.ValidateRoomStoreVO;

/**
 * <b>酒店订单模块业务层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public interface HotelOrderService {

	/**
	 * <b>生成订单前,获取预订信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	RoomStoreVO getPreOrderInfo(ValidateRoomStoreVO validateRoomStoreVO) throws Exception;
}
