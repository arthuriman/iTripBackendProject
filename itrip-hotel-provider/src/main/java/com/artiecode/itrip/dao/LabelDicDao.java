package com.artiecode.itrip.dao;

import com.artiecode.itrip.pojo.entity.LabelDic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>系统字典数据持久层接口</b>
 * @author Arthur
 * @since 4.0.0
 * @version 4.0.0
 */
@Repository
public interface LabelDicDao {
	/**
	 * <b>根据查询获得字典信息列表</b>
	 * @param queryMap
	 * @return
	 */
	List<LabelDic> findLabelDicListByQuery(Map<String, Object> queryMap) throws Exception;
}
