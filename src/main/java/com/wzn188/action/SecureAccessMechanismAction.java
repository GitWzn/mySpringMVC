package com.wzn188.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.wzn188.VO.User;
import com.wzn188.myInterface.IAddUserGroup;

/**
 * 安全访问机制
 * 因为在web项目中WEB-INF目录下的文件是不能直接在地址栏中直接访问的,但在实际应用中,为了保护文件的安全性
 * 我们会把相应的文件(jsp、js、css等)放到WEB-INF目录中,提高文件的安全性,不让用户随意的拿去使用
 * 此时SpringMVC提供了访问安全文件的应用方式     默认是关闭的   我们需要在SpringMVC的配置文件中进行开启
 * 开启安全访问机制后,就告诉系统，在WEB-INF目录下是内部,访问的方式只能是内部访问,WEB-INF目录下的文件只能通过跳转的方式打开  不可以直接打开
 * 当我们跳转页面的时默认的时请求跳转(请求跳转是内部访问),所以访问文件的路径中都会有WEB-INF/pages的父路径  
 * 当我们需要访问WEB-INF目录以外(外部访问)的文件时需要往目录上级跳(../的方式),或者是使用重定向请求(外部访问)的方式
 * @author 吴宗宁
 */
@Controller
public class SecureAccessMechanismAction {
	@RequestMapping("addUser")
	public ModelAndView addUser (@Validated({IAddUserGroup.class}) User user, BindingResult errMessage){
		System.out.println("这里是安全访问机制的测试：" + user);
		if(errMessage.hasErrors()) {
			List<ObjectError> allErrors = errMessage.getAllErrors();
			for (ObjectError error : allErrors) {
				System.out.println(error.getDefaultMessage());
			}
		}
		//ModelAndView modelAndView = new ModelAndView("redirect:webpagefile/main.jsp");
		ModelAndView modelAndView = new ModelAndView("addUser");
		return modelAndView;
	}
}
