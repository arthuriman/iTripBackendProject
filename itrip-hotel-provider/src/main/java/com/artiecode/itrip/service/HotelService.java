package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.entity.Hotel;

/**
 * <b>酒店业务层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public interface HotelService {
	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	Hotel queryHotelVideoDescByHotelId(Long hotelId) throws Exception;
}
