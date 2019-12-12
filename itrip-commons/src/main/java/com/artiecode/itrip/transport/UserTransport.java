package com.artiecode.itrip.transport;

import com.artiecode.itrip.pojo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>用户信息传输层接口</b>
 * @author Arthur
 * @version 3.1.1 2019-12-12
 * @since 3.1.1
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/user")
public interface UserTransport {
	/**
	 * <b>通过userCode查询User对象</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	User getUserByUserCode(@RequestParam String userCode) throws Exception;
}
