package com.artiecode.itrip.dao;

import com.artiecode.itrip.pojo.entity.AreaDic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>区域字典数据持久层接口</b>
 */
@Repository
public interface AreaDicDao {
	/**
	 * <b>根据查询信息查询区域字典列表</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<AreaDic> findAreaDisListByQuery(Map<String, Object> queryMap) throws Exception;
}
