package com.artiecode.itrip.dao;

import com.artiecode.itrip.pojo.entity.LabelDic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>通用字典/特色信息数据持久层接口</b>
 * @author  Arthur
 * @version 3.1.1 2019-12-11
 * @since 2019-12-17
 */
@Repository
public interface LabelDicDao {
	/**
	 * <b>根据查询条件查询酒店特色列表</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<LabelDic> findLabelDicListByQuery(Map<String, Object> queryMap) throws Exception;
}
