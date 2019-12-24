package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.LabelDicDao;
import com.artiecode.itrip.pojo.entity.LabelDic;
import com.artiecode.itrip.service.LabelDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>系统字典业务层接口实现类</b>
 * @author Arthur
 * @since 4.0.0
 * @version 4.0.0
 */
@Service("labelDicService")
@Transactional
public class LabelDicServiceImpl implements LabelDicService {
	@Autowired
	private LabelDicDao labelDicDao;

	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	public List<LabelDic> queryHotelFeature() throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("parentId", 16);
		List<LabelDic> labelDicList = labelDicDao.findLabelDicListByQuery(queryMap);
		return labelDicList;
	}
}
