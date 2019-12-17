package com.artiecode.itrip.transport;

import com.artiecode.itrip.pojo.entity.AreaDic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>区域字典信息传输层接口</b>
 * @author Arthur
 * @version 3.1.1 2019-12-17
 * @since 3.1.1
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/area")
public interface AreaDicTransport {
	/**
	 * <b>根据是否为国内还是国外，查找热门城市列表</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHotCityByIsChina", method = RequestMethod.POST)
	List<AreaDic> getHotCityListByIsChina(@RequestParam Integer isChina) throws Exception;
}
