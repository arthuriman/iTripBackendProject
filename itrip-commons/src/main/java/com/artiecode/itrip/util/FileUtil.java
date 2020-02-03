package com.artiecode.itrip.util;

import com.artiecode.itrip.base.controller.BaseController;
import com.artiecode.itrip.base.enums.SuccessEnum;
import com.artiecode.itrip.pojo.vo.ResponseResult;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * <b>文件工具类</b>
 * <p>
 *     用于处理文件的上传、下载等相关操作
 * </p>
 */
@Controller("fileUtil")
@RequestMapping("/file")
public class FileUtil extends BaseController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseResult<Object> uploadFile(MultipartFile uploadFile) throws Exception {
		// 设定文件上传路径文件夹
		String path = "E:/upload";
		// 根据上传文件夹创建对应的File对象
		File uploadFolder = new File(path);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdir();
		}

		// 获得文件名
		String fileName = uploadFile.getName();
		// 获得文件的后缀
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		// 对于文件进行重命名
		fileName = path + File.separator + System.currentTimeMillis() + suffix;
		// 创建对应的目标文件对象
		File descFile = new File(fileName);
		// 判断该文件是否存在，如果不存在，那么创建该文件
		if (!descFile.exists()) {
			descFile.createNewFile();
		}
		// 根据目标文件创建输出流
		OutputStream out = new FileOutputStream(descFile);
		// 获得输入流
		InputStream in = uploadFile.getInputStream();

		// 将输入流的内容放入输出流
		IOUtils.copy(in, out);

		out.close();
		in.close();

		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE, fileName);
	}
}
