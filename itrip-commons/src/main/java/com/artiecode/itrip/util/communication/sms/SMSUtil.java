package com.artiecode.itrip.util.communication.sms;

import com.artiecode.itrip.util.ConstantUtil;
import com.cloopen.rest.sdk.CCPRestSDK;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

/**
 * <b>使用容联云发送短信工具类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Component("smsUtil")
public class SMSUtil {

	/**
	 * <b>使用手机号码发送验证码</b>
	 * @param cellphone
	 * @param activeCode
	 * @throws Exception
	 */
	@Async("asyncServieExecutor")
	public void sendSMS(String cellphone, String activeCode) throws Exception {
		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount(ConstantUtil.SMS_ACCOUNT_SID, ConstantUtil.SMS_ACCOUNT_TOKEN);// 初始化主帐号和主帐号TOKEN
		restAPI.setAppId(ConstantUtil.SMS_APPID);// 初始化应用ID
		result = restAPI.sendTemplateSMS(cellphone,ConstantUtil.SMS_TEMPLATE_ID , new String[] {activeCode, String.valueOf(ConstantUtil.ACTIVE_CODE_TIMEOUT)});

		System.out.println("SDKTestSendTemplateSMS result=" + result);

		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
	}
}
