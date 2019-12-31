package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.entity.Hotel;
import com.artiecode.itrip.pojo.vo.SearchDetailsHotelVO;
import com.artiecode.itrip.pojo.vo.SearchPolicyHotelVO;

import java.util.List;

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

	/**
	 * <b>根据酒店id查询酒店政策</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	String queryHotelPolicy(Long hotelId) throws Exception;

	/**
	 * <b>根据主键查询酒店详情描述</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	List<SearchDetailsHotelVO> queryHotelDetails(Long hotelId) throws Exception;

	/**
	 * <b>根据酒店id查询酒店设施</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	String queryHotelFacilities(Long hotelId) throws Exception;
}
