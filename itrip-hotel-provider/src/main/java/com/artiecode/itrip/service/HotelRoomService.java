package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.entity.HotelImage;
import com.artiecode.itrip.pojo.vo.HotelRoomVO;
import com.artiecode.itrip.pojo.vo.SearchHotelRoomVO;

import java.util.List;

/**
 * <b>酒店房间业务层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public interface HotelRoomService {
	/**
	 * <b>查询酒店房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	List<HotelRoomVO> queryHotelRoomByHotel(SearchHotelRoomVO searchHotelRoomVO) throws Exception;

	/**
	 * <b>根据targetId和typeId获得酒店图片列表</b>
	 * @param targetId
	 * @param typeId
	 * @return
	 */
	List<HotelImage> getImgByTargetIdAndTypeId(Long targetId, String typeId) throws Exception;
}
