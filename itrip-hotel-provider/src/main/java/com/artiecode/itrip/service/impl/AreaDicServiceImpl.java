package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.AreaDicDao;
import com.artiecode.itrip.pojo.entity.AreaDic;
import com.artiecode.itrip.service.AreaDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>区域字典业务层接口实现类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Service("areaDicService")
@Transactional
public class AreaDicServiceImpl implements AreaDicService {
	@Autowired
	private AreaDicDao areaDicDao;

	/**
	 * <b>根据是否是中国查询对应的热门城市</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	public List<AreaDic> queryHotCityByIsChina(Integer isChina) throws Exception {
		// 设定查询参数
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("isHot", 1);
		queryMap.put("isChina", isChina);
		queryMap.put("isActivated", 1);

		return areaDicDao.findAreaDicListByQuery(queryMap);
	}
}
