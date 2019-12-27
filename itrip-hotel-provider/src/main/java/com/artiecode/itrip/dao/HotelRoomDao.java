package com.artiecode.itrip.dao;

import com.artiecode.itrip.pojo.entity.HotelRoom;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>酒店房间数据持久层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Repository
public interface HotelRoomDao {
	/**
	 * <b>根据查询条件查询酒店房间列表</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<HotelRoom> findHotelRoomListByQuery(Map<String, Object> queryMap) throws Exception;
}
