package com.artiecode.itrip.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.hotel.transport.HotelOrderTransport;
import com.artiecode.itrip.pojo.entity.HotelOrder;
import com.artiecode.itrip.pojo.vo.PersonalOrderRoomVO;
import com.artiecode.itrip.pojo.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController("tradeController")
@RequestMapping("/trade/api")
public class TradeController extends BaseController {
	@Autowired
	private HotelOrderTransport hotelOrderTransport;

	@RequestMapping(value = "/prepay/{orderNo}", method = RequestMethod.GET)
	public ResponseResult<Object> payOrder(@PathVariable("orderNo") String orderNo) throws Exception {
		// 通过订单编号查找对应的订单信息
		HotelOrder hotelOrder = hotelOrderTransport.getHotelOrderByNo(orderNo);

		// 判断该订单是否存在，另外订单处于未支付状态
		if (hotelOrder != null && hotelOrder.getOrderStatus() == 0) {
			// 查询房间信息
			PersonalOrderRoomVO roomVO = hotelOrderTransport.getPersonalOrderRoomInfo(hotelOrder.getId());
			// 该订单可以进行支付
			// 获得订单金额
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			String total_amount = decimalFormat.format(hotelOrder.getPayAmount());
			// 订单编号使用当前时间
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			String out_trade_no = dateFormat.format(new Date()) + System.currentTimeMillis();
			String product_code = orderNo;
			String subject = hotelOrder.getHotelName();
			String body = roomVO.getRoomTitle() + "，" + hotelOrder.getCount() + "间，" + hotelOrder.getBookingDays() + "天";

			// 开始支付
			AlipayClient alipayClient = new DefaultAlipayClient(
					"https://openapi.alipaydev.com/gateway.do",
					"2016101900726066",
					"MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCW+WtRlAt9eyaYqB0ErmHIMQvZqvD/Lt22eBwNUIhHTIS74oIAZiDM5iCbXcGCiu+nw5/1pqEceFE9fkaHPMP1YrNEs5XtqdWil9Xef5lE0zuC3t5Z0MPuT+dEbPk0Hu78I4K1CKPHfS1emvafDE574DUOdO65PtWCksJWi8o8VNSVyyZmEfNWkvmxHFUcFVv3RWFbtWjUnnSdjAVIakvGXLWNXPLYYJWYsxzfoS8V4GsakeXh+RkMrIe+hjZqTtrRtATF4mRa/9eWfklz45Kve2Mw3WltprHAfx3WY729W5e2HJ6PKClvkcuC5w2HN21oXyBH9prSHekf5RVS0jF/AgMBAAECggEAfCHVsHyWOfUQ1gGb4mZy9YQGJ1Fa16Y0G7yD7BqkAmOS21yw4R0XqQEqHDSpT+lmhTzef78ixuLSgUobOUSoJlGh7kHuazvx8L8A1PF7FtDLJJ6UmaqB/qbqEyO6frVUcDHOXYUeDH8K17d4QWt/+HBvj1RrmBpmuPZsHXbQsGsXM/jc8OBtxa9gE2yNwiACE+9QS2B4/2hpFQNc4NhxHU7MKrqabYtYgh1oH4QEDVHaIBCkswfS7i+YXTEoaiPvfFnWy8I2HvQPV2Xy9rddu1s4RxLgiBG2XGew5Ky5+VtdwFImtYqJbyGisM/qDeIYnjXRbyr0zMUMcBjKIxWRKQKBgQDTzgzaBrP+0l2ZH/1L9ZlgvMs65BXog0ZA/nISxEFrn0rAQ7Btzu1SssItSiKG1lP5vZPXEkM1uoItHPSZ3ueom10mInjWeqadGiL40Mbqc0XZfSzgZggZS1XMIWyn+bvojuqvOsejndvzrH/NtZr2/btbUVNlOe8Tz2gd4HXp8wKBgQC2ef2Q4FsWWMVNBJ8BBexLodlmLYGKYXF5UIeQfG2yXDuQXODCZfb7vg7f6Ue9RiEGGBFsaNoYLdBq7D68Ed/epeb2Z27Fbp8kBEvfe5j03PRkIEAvISiyOctf0LFn5YduOEjLvgyZU+l57g9JrEwXBJMwyfpE3Druxghl/rsRRQKBgEHgtN6bdyCrDbGy4XXezfXows1uY+IN8qwEeDaeFDsFMJrccuO0mNw//WVYyaRmxXfIH1OluoHboOGnP+0cB7HJoQ9baXpMa8Yxeu8pALWrZO5goLSrB5nWdLkpLEKSyn9q9FPMVIvvbZo87QNumOR5xuyAPxAdFN90g03HouVBAoGBAJM1GrAzrof6mUCmx7dFlfj12rIpZ+XA8pARvSt8lepbqdmuc8ugAn3YN5u/UBaLarzF0diJRdhXrVl0uK90JAwz/n0tuBkiQtQFe0gRJ7XyQl47/kuHDpOpOD5V16ifbIAoe+GRsgxHu4SX3lFq4/91u2CSsIm4uPpDXCccNsGZAoGBAIlijCWP3Qha/pi1etqUhhPJMxgrWntRa2rauJ8rASlUuaNSr77J/CMu/+izIesD6UtrOYCmbxUeb+cWpDvbqZteXoYJyJ3xT2mFdMzdYqcKU0CDpTx/hcc30S0SrOFF/BY6PC0+FLWIx4OyzlQcunjt6jHkHU8zHl6bOvJox2OC",
					"json",
					"UTF-8",
					"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlvlrUZQLfXsmmKgdBK5hyDEL2arw/y7dtngcDVCIR0yEu+KCAGYgzOYgm13Bgorvp8Of9aahHHhRPX5GhzzD9WKzRLOV7anVopfV3n+ZRNM7gt7eWdDD7k/nRGz5NB7u/COCtQijx30tXpr2nwxOe+A1DnTuuT7VgpLCVovKPFTUlcsmZhHzVpL5sRxVHBVb90VhW7Vo1J50nYwFSGpLxly1jVzy2GCVmLMc36EvFeBrGpHl4fkZDKyHvoY2ak7a0bQExeJkWv/Xln5Jc+OSr3tjMN1pbaaxwH8d1mO9vVuXthyejygpb5HLgucNhzdtaF8gR/aa0h3pH+UVUtIxfwIDAQAB",
					"RSA2"
			); //获得初始化的AlipayClient
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
			alipayRequest.setReturnUrl("http://localhost/itrip");
			alipayRequest.setNotifyUrl("http://itrip.project.bdqn.cn/trade/api/notify/" + hotelOrder.getId());//在公共参数中设置回跳和通知地址

			String json = "{\"out_trade_no\":\"" + out_trade_no
					+ "\", \"product_code\":\"FAST_INSTANT_TRADE_PAY\", "
					+ "\"total_amount\":\"" + total_amount
					+ "\",\"subject\":\"" + subject
					+ "\",\"body\":\"" + body + "\","
					+ "\"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\",\"extend_params\":{}}";
			System.out.println(json);

			alipayRequest.setBizContent(json);//填充业务参数

			String form="";
			try {
				form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(form);//直接将完整的表单html输出到页面
			response.getWriter().flush();
			response.getWriter().close();
		}
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE);
	}

	@RequestMapping(value = "/notify/{orderId}", method = RequestMethod.GET)
	public void updateHotelOrder(@PathVariable("orderId") Long orderId) throws Exception {
		// 修改订单状态
	}
}
