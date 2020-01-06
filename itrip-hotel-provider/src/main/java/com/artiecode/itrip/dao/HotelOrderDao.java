package com.artiecode.itrip.dao;

import com.artiecode.itrip.pojo.entity.HotelOrder;
import com.artiecode.itrip.pojo.entity.OrderLinkUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>酒店订单模块数据持久层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Repository
public interface HotelOrderDao {
	/**
	 * <b>根据查询条件获得库存数量</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	Integer findStoreByPreOrder(Map<String, Object> queryMap) throws Exception;

	/**
	 * <b>查询已经下单未支付所使用的房间信息</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	Integer findCountByOrderNoPay(Map<String, Object> queryMap) throws Exception;

	void saveOrder(HotelOrder hotelOrder) throws Exception;

	List<HotelOrder> findOrderByQuery(Map<String, Object> queryMap) throws Exception;

	List<OrderLinkUser> findOrderLinkUserListByQuery(Map<String, Object> queryMap) throws Exception;
}
