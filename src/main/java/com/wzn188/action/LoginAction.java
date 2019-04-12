package com.wzn188.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.wzn188.VO.User;
import com.wzn188.myInterface.ILoginGroup;

@Controller      //让当前类变成一个控制处理器
@RequestMapping("/user/*")  //当这个注解在这做映射时,表示设置父路径
public class LoginAction {
	//@RequestMapping("login")		//此时的注解表示当前方法的请求处理映射路径     次方式进行请求是不分请求方式的
	//method: 有请求方式方式区分,规定的请求方式才可以访问该方法
	//hearders: 
	@RequestMapping(value="login",method={RequestMethod.POST,RequestMethod.GET})   
	//这里是使用其他的方法进行数据的传递和页面跳转    
	public String login (@Validated({ILoginGroup.class}) User user, BindingResult errMessage, HttpServletRequest request){
		System.out.println("这里是使用其他方式进行跳转：" + user);
		if(errMessage.hasErrors()) {
			List<ObjectError> allErrors = errMessage.getAllErrors();
			for (ObjectError error : allErrors) {
				System.out.println(error.getDefaultMessage());
			}
			return "redirect:../webpagefile/main.jsp";
		}
		//同样默认的是请求转发,如果想将数据传递到页面中,可以通过HttpRequest将数据存储在request域中
		//return "../webpagefile/main.jsp";
		//将用户信息存储到session域中
		System.out.println("登录成功!!");
		request.getSession().setAttribute("currUser", user);
		//使用重定向转发时不可以将接收到的请求数据传递给页面
		return "redirect:../webpagefile/main.jsp";
	}
	//这里是没有页面跳转的方法
	/*public void login (User user){  //接收请求数据,SpringMVC自动封装
		System.out.println("这里是处理登录的请求方法");
		System.out.println("请求数据：" + user);
	}*/
	//这里使用的是ModelAndView的方式进行数据传递和页面跳转
	/*public ModelAndView login (User user){  //接收请求数据,SpringMVC自动封装
		System.out.println("这里是处理登录的请求方法");
		System.out.println("请求数据：" + user);
		//使用ModelAndView跳转页面和向页面传递数据     默认的跳转方式是请求转发(forward),可以传递参数给页面,地址栏不变,默认的请求转发可以不用写关键字  
										   //当我们使用重定向转发的时候需要设置关键字(redirect),不可以传递参数给页面,地址栏改变
		//创建ModelAndView对象
		//ModelAndView modelAndView = new ModelAndView();  //当使用无参构造时,使用setViewName()的方法设置条转的页面
		//modelAndView.setViewName("../webpagefile/main.jsp");   //可以手动设置跳转页面
		//ModelAndView modelAndView = new ModelAndView("../webpagefile/main.jsp"); //使用有参构造可以直接设置跳转页面
		//设置跳转方式为重定向跳转(redirect)   但是不可以传递数据给页面
		ModelAndView modelAndView = new ModelAndView("redirect:../webpagefile/main.jsp"); //使用有参构造可以直接设置跳转页面
		//将数据传递给页面的Request域中   
		//modelAndView.addObject("currUser", user);
		return modelAndView;
	}*/

	//因为SpringMVC对请求参数的自动封装只对分封装类中的基本数据类型和String
	//因为请求的参数都是String类型的,SpringMVC只会将String类型的数据转换成基本数据类型(比如int)
	//而SpringMVC不会将String类型的数据转换成Date类型，会封装失败
	//所以SpringMVC提供了相关的转换器
	@InitBinder      //这个注解表示这个方法是转换器
	public void transformDate (WebDataBinder dataBinder){    //转换器方法中接收WebDataBinder作为参数
		//设置时间的格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//将接收到的数据转换成Date类型然后封装      CustomDateEditor类是Spring提供的日期转换工具
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
