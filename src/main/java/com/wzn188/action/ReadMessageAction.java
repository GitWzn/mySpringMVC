package com.wzn188.action;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//读取资源文件
@Controller
public class ReadMessageAction {
	//从Spring容器中获取MessageSource对象
	@Resource
	private MessageSource messageSource;
	@RequestMapping("readMessage")
	public void readMessage (String key){
		String message = messageSource.getMessage(key, null, Locale.getDefault());
		System.out.println("message：" + message);
	}
}
