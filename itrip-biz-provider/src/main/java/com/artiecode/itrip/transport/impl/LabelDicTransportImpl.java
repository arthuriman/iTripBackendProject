package com.artiecode.itrip.transport.impl;

import com.artiecode.itrip.pojo.entity.LabelDic;
import com.artiecode.itrip.service.LabelDicService;
import com.artiecode.itrip.transport.LabelDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>通用字典/特色信息传输层接口</b>
 * @author  Arthur
 * @version 3.1.1 2019-12-11
 * @since 2019-12-17
 */
@RestController("labelDicTransport")
@RequestMapping("/label")
public class LabelDicTransportImpl implements LabelDicTransport {
	@Autowired
	private LabelDicService labelDicService;

	/**
	 * <b>获得所有酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<LabelDic> getHotelFeatureList() throws Exception {
		return labelDicService.getLabelDicList();
	}
}
