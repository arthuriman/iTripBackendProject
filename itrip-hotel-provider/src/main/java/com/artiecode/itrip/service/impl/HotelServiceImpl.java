package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.HotelDao;
import com.artiecode.itrip.pojo.entity.Hotel;
import com.artiecode.itrip.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>酒店业务层接口实现类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Service("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDao hotelDao;

	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	public Hotel queryHotelVideoDescByHotelId(Long hotelId) throws Exception {
		// 封装查询参数
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("id", hotelId);
		List<Hotel> hotelList = hotelDao.findHotelListByQuery(queryMap);
		if (hotelList != null && hotelList.size() > 0) {
			return hotelList.get(0);
		}
		return null;
	}
}
