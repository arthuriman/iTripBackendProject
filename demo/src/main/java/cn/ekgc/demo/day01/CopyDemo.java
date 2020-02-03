package cn.ekgc.demo.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyDemo {
	public static void main(String[] args) throws Exception {
		// 对于Java来说，硬盘上的任意一个文件或者目录都对应一个java.io.File对象
		// 创建待复制文件所对应的java.io.File对象
		File srcFile = new File("C:/Users/Administrator/Desktop/123.jpg");
		// 使用输入流将文件进行读取到程序中
		FileInputStream fis = new FileInputStream(srcFile);
		// 设定目标文件的java.io.File对象
		// 对于真实的生产环境来说，就必须考虑到文件的重名问题，必须对目标文件进行重命名
		// 特别要注意的是，文件的扩展名是必须和源文件保持一致的
		// 通过源文件获得该文件的扩展名
		// 首先，获得源文件的名字
		String srcFileName = srcFile.getName();
		System.out.println(srcFileName);
		// 根据源文件名获得对应的文件扩展名
		String suffix = srcFileName.substring(srcFileName.lastIndexOf("."));
		System.out.println(suffix);
		// 可以使用当前时间毫秒数作为文件名
		String descFileName = System.currentTimeMillis() + suffix;
		File descFile = new File(descFileName);
		// 将目标文件对象在硬盘上进行创建
		if (!descFile.exists()) {
			// 创建该文件
			descFile.createNewFile();
//			descFile.mkdir();       // 当File对象所对应的是一个目录/文件夹的时候，所调用的方法，不过要注意的是只有一个文件夹
//			descFile.mkdirs();      // 和mkdir()一样，用于创建文件夹，区别在于，如果是一个多级文件夹，例如 D:/test1/test2..时候所调用
		}

		// 可以根据目标文件对象创建对应的输出流对象
		FileOutputStream fos = new FileOutputStream(descFile);

		// 通过输入流读取数据到程序中
		int i;
		while ((i = fis.read()) != -1) {
			// 只需要让读取到的数据通过输出流放到对应的目标文件中
			fos.write(i);
		}

		fos.close();
		fis.close();
	}
}
