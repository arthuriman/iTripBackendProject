package com.artiecode.itrip.hotel.transport;

import com.artiecode.itrip.pojo.entity.HotelImage;
import com.artiecode.itrip.pojo.vo.HotelRoomVO;
import com.artiecode.itrip.pojo.vo.LabelDicVO;
import com.artiecode.itrip.pojo.vo.SearchHotelRoomVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>酒店房间项目传输层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@FeignClient(name = "itrip-hotel-provider")
@RequestMapping("/hotelroom")
public interface HotelRoomTransport {
	/**
	 * <b>查询酒店房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelroombyhotel", method = RequestMethod.POST)
	List<HotelRoomVO> queryHotelRoomByHotel(@RequestBody SearchHotelRoomVO searchHotelRoomVO) throws Exception;

	/**
	 * <b>查询酒店房间床型列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelroombed", method = RequestMethod.POST)
	List<LabelDicVO> queryHotelRoombed() throws Exception;

	/**
	 * <b>根据targetId和typeId获得酒店图片列表</b>
	 * @param targetId
	 * @param typeId
	 * @return
	 */
	@RequestMapping(value = "/getimg", method = RequestMethod.POST)
	List<HotelImage> getImgByTargetIdAndTypeId(@RequestParam Long targetId, @RequestParam String typeId) throws Exception;
}
