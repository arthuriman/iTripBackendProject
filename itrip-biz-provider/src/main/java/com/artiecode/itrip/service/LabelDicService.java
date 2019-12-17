package com.artiecode.itrip.service;

import com.artiecode.itrip.pojo.entity.LabelDic;

import java.util.List;

/**
 * <b>通用字典/特色信息业务层接口</b>
 * @author  Arthur
 * @version 3.1.1 2019-12-11
 * @since 2019-12-17
 */
public interface LabelDicService {
	/**
	 * <b>获得通用字典信息列表</b>
	 * @return
	 * @throws Exception
	 */
	List<LabelDic> getLabelDicList() throws Exception;
}
