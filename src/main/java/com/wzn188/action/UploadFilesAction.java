package com.wzn188.action;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

//上传文件
@Controller
public class UploadFilesAction {
	@RequestMapping("uploadFiles")
	public void uploadFiles (MultipartFile imgPhoto){  //参数接收上传的文件对	象
		System.out.println("这里是接收上传的文件：" + imgPhoto);
		//获取文件的MIME类型
		System.out.println("文件类型：" + imgPhoto.getContentType());
		//获取文件的名称
		System.out.println("文件名称：" + imgPhoto.getOriginalFilename());
		//获取文件的大小
		System.out.println("文件大小：" + imgPhoto.getSize());
		//将文件保存到其他地方
		try {
			imgPhoto.transferTo(new File("C:\\Users\\吴宗宁\\Desktop\\java培训\\15.SpringMVC\\SpringMVC02",imgPhoto.getOriginalFilename()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 自定义处理异常的方法
	 * 使用注解的方式自定义处理异常的方法
	 * 当SpringMVC配置文件中已有配置异常处理，这里的自定义权限有限，就不回执行配置文件中的异常处理
	 */
	@ExceptionHandler
	public String HandleExceptions (MaxUploadSizeExceededException musee){ //参数是异常类
		System.out.println("这里是处理异常的方法!!");
		return "abnormalPage";
	}
}
