package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.entity.LabelDic;

import java.util.List;

/**
 * <b>系统字典业务层接口</b>
 * @author Arthur
 * @since 4.0.0
 * @version 4.0.0
 */
public interface LabelDicService {
	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	List<LabelDic> queryHotelFeature() throws Exception;
}
