package com.artiecode.itrip.dao;

import com.artiecode.itrip.pojo.entity.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>酒店数据持久层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Repository
public interface HotelDao {
	/**
	 * <b>根据查询条件查询酒店列表</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<Hotel> findHotelListByQuery(Map<String, Object> queryMap) throws Exception;
}
