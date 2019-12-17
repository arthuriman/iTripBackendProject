package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.entity.AreaDic;

import java.util.List;

/**
 * <b>区域字典业务层接口</b>
 * @author Arthur
 * @version 3.1.1 2019-12-11
 * @since 2019-12-17
 */
public interface AreaDicService {
	/**
	 * <b>根据是否为国内还是国外，查询热门城市列表</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	List<AreaDic> getHotCityListByIsChina(Integer isChina) throws Exception;
}
