package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.entity.AreaDic;

import java.util.List;

/**
 * <b>区域字典业务层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public interface AreaDicService {
	/**
	 * <b>根据是否是中国查询对应的热门城市</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	List<AreaDic> queryHotCityByIsChina(Integer isChina) throws Exception;
}
