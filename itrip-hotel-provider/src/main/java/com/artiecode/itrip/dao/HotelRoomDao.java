package com.artiecode.itrip.dao;

import com.artiecode.itrip.pojo.entity.HotelImage;
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

	/**
	 * <b>根据条件查询节点图片列表</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<HotelImage> findHotelImageListByQuery(Map<String, Object> queryMap) throws Exception;
}
