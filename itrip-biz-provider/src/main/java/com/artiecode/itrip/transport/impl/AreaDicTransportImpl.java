package com.artiecode.itrip.transport.impl;

import com.artiecode.itrip.pojo.entity.AreaDic;
import com.artiecode.itrip.service.AreaDicService;
import com.artiecode.itrip.transport.AreaDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>区域字典信息传输层接口实现类</b>
 * @author Arthur
 * @version 3.1.1 2019-12-17
 * @since 3.1.1
 */
@RestController("areaDicTransport")
@RequestMapping("/area")
public class AreaDicTransportImpl implements AreaDicTransport {
	@Autowired
	private AreaDicService areaDicService;

	/**
	 * <b>根据是否为国内还是国外，查找热门城市列表</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHotCityByIsChina", method = RequestMethod.POST)
	public List<AreaDic> getHotCityListByIsChina(@RequestParam Integer isChina) throws Exception {
		return areaDicService.getHotCityListByIsChina(isChina);
	}
}
