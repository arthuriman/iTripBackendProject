package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.HotelRoomDao;
import com.artiecode.itrip.pojo.entity.HotelRoom;
import com.artiecode.itrip.pojo.vo.HotelRoomVO;
import com.artiecode.itrip.pojo.vo.SearchHotelRoomVO;
import com.artiecode.itrip.pojo.vo.SearchHotelVO;
import com.artiecode.itrip.service.HotelRoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>酒店房间业务层接口接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Service("hotemRoomService")
@Transactional
public class HotelRoomServiceImpl implements HotelRoomService {
	@Autowired
	private HotelRoomDao hotelRoomDao;

	/**
	 * <b>查询酒店房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	public List<HotelRoomVO> queryHotelRoomByHotel(SearchHotelRoomVO searchHotelRoomVO) throws Exception {
		// 根据搜索视图，封装查询Map集合
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("hotelId", searchHotelRoomVO.getHotelId());
		queryMap.put("isBook", searchHotelRoomVO.getIsBook());
		queryMap.put("isHavingBreakfast", searchHotelRoomVO.getIsHavingBreakfast());
		queryMap.put("isTimelyResponse", searchHotelRoomVO.getIsTimelyResponse());
		queryMap.put("roomBedTypeId", searchHotelRoomVO.getRoomBedTypeId());
		queryMap.put("startDate", searchHotelRoomVO.getStartDate());
		queryMap.put("endDate", searchHotelRoomVO.getEndDate());
		queryMap.put("isCancel", searchHotelRoomVO.getIsCancel());
		queryMap.put("payType", searchHotelRoomVO.getPayType());

		// 使用数据持久层进行查询
		List<HotelRoom> hotelRoomList = hotelRoomDao.findHotelRoomListByQuery(queryMap);
		// 将实体对象的属性复制到视图对象中
		List<HotelRoomVO> hotelRoomVOList = new ArrayList<>();
		if (hotelRoomList != null && hotelRoomList.size() > 0) {
			for (HotelRoom hotelRoom : hotelRoomList) {
				HotelRoomVO hotelRoomVO = new HotelRoomVO();
				BeanUtils.copyProperties(hotelRoom, hotelRoomVO);
				hotelRoomVOList.add(hotelRoomVO);
			}
		}
		return hotelRoomVOList;
	}
}
