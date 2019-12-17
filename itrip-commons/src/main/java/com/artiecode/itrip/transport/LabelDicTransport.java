package com.artiecode.itrip.transport;

import com.artiecode.itrip.pojo.entity.LabelDic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <b>通用字典/特色信息传输层接口</b>
 * @author  Arthur
 * @version 3.1.1 2019-12-11
 * @since 2019-12-17
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/label")
public interface LabelDicTransport {
	/**
	 * <b>获得所有酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	List<LabelDic> getHotelFeatureList() throws Exception;
}
