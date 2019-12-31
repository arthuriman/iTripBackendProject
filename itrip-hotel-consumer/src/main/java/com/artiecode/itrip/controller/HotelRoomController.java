package com.artiecode.itrip.controller;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.hotel.transport.HotelRoomTransport;
import com.artiecode.itrip.pojo.entity.HotelImage;
import com.artiecode.itrip.pojo.vo.HotelRoomVO;
import com.artiecode.itrip.pojo.vo.LabelDicVO;
import com.artiecode.itrip.pojo.vo.ResponseResult;
import com.artiecode.itrip.pojo.vo.SearchHotelRoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>酒店房间控制器</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("hotelRoomController")
@RequestMapping("/biz/api/hotelroom")
public class HotelRoomController extends BaseController {
	@Autowired
	private HotelRoomTransport hotelRoomTransport;

	/**
	 * <b>查询酒店房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelroombyhotel", method = RequestMethod.POST)
	public ResponseResult<Object> queryHotelRoombyHotel(@RequestBody SearchHotelRoomVO searchHotelRoomVO)
			throws Exception {
		List<List<HotelRoomVO>> resultList = new ArrayList<List<HotelRoomVO>>();
		List<HotelRoomVO> hotelRoomVOList = hotelRoomTransport.queryHotelRoomByHotel(searchHotelRoomVO);
		for (HotelRoomVO hotelRoomVO : hotelRoomVOList) {
			List<HotelRoomVO> tempList = new ArrayList<HotelRoomVO>();
			tempList.add(hotelRoomVO);
			resultList.add(tempList);
		}
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, resultList);
	}

	/**
	 * <b>查询酒店房间床型列表</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryhotelroombed", method = RequestMethod.GET)
	public ResponseResult<Object> queryHotelRoombed() throws Exception {
		List<LabelDicVO> labelVOList = hotelRoomTransport.queryHotelRoombed();
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, labelVOList);
	}

	/**
	 * <b>根据targetId查询酒店房型图片(type=1)</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getimg/{targetId}", method = RequestMethod.GET)
	public ResponseResult<Object> getImgByTargetId(@PathVariable("targetId") Long targetId) throws Exception {
		List<HotelImage> hotelImageList = hotelRoomTransport.getImgByTargetIdAndTypeId(targetId, "1");
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, hotelImageList);
	}
}
