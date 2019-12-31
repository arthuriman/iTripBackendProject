package com.artiecode.itrip.transport.impl;

import com.artiecode.itrip.hotel.transport.HotelRoomTransport;
import com.artiecode.itrip.pojo.entity.HotelImage;
import com.artiecode.itrip.pojo.vo.HotelRoomVO;
import com.artiecode.itrip.pojo.vo.LabelDicVO;
import com.artiecode.itrip.pojo.vo.SearchHotelRoomVO;
import com.artiecode.itrip.service.HotelRoomService;
import com.artiecode.itrip.service.LabelDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>酒店房间项目传输层接口实现类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("hotelRoomTransport")
@RequestMapping("/hotelroom")
public class HotelRoomTransportImpl implements HotelRoomTransport {
	@Autowired
	private HotelRoomService hotelRoomService;
	@Autowired
	private LabelDicService labelDicService;

	/**
	 * <b>查询酒店房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelroombyhotel", method = RequestMethod.POST)
	public List<HotelRoomVO> queryHotelRoomByHotel(@RequestBody SearchHotelRoomVO searchHotelRoomVO) throws Exception {
		return hotelRoomService.queryHotelRoomByHotel(searchHotelRoomVO);
	}

	/**
	 * <b>查询酒店房间床型列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelroombed", method = RequestMethod.POST)
	public List<LabelDicVO> queryHotelRoombed() throws Exception {
		return labelDicService.queryLabelDicVOListByParent(1L);
	}

	/**
	 * <b>根据targetId和typeId获得酒店图片列表</b>
	 * @param targetId
	 * @param typeId
	 * @return
	 */
	@RequestMapping(value = "/getimg", method = RequestMethod.POST)
	public List<HotelImage> getImgByTargetIdAndTypeId(@RequestParam Long targetId, @RequestParam String typeId) throws Exception {
		return hotelRoomService.getImgByTargetIdAndTypeId(targetId, typeId);
	}
}
