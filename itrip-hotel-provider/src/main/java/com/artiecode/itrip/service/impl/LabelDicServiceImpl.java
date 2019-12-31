package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.dao.LabelDicDao;
import com.artiecode.itrip.pojo.entity.LabelDic;
import com.artiecode.itrip.pojo.vo.LabelDicVO;
import com.artiecode.itrip.service.LabelDicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

	/**
	 * <b>根据父级主键查询视图列表</b>
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<LabelDicVO> queryLabelDicVOListByParent(Long parentId) throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("parentId", parentId);
		List<LabelDic> labelDicList = labelDicDao.findLabelDicListByQuery(queryMap);
		// 将对应的实体对象切换成视图对象
		List<LabelDicVO> labelDicVOList = new ArrayList<LabelDicVO>();
		if (labelDicList != null && labelDicList.size() > 0) {
			for (LabelDic labelDic : labelDicList) {
				LabelDicVO labelDicVO = new LabelDicVO();
				BeanUtils.copyProperties(labelDic, labelDicVO);
				labelDicVOList.add(labelDicVO);
			}
		}
		return labelDicVOList;
	}
}
