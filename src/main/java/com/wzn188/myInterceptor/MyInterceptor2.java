package com.wzn188.myInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wzn188.VO.User;

/**
 * 这里是自定义拦截器
 * SpringMVC提供了拦截请求的功能
 * 实现HandlerInterceptor接口
 * 继承HandlerInterceptorAdapter类      这个类是适配器
 * @author 吴宗宁
 */
public class MyInterceptor2 extends HandlerInterceptorAdapter {
	@Override    //这里是执行请求前的操作
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("这里是执行请求前的操作!!");
		//形参中有一个HandlerMethod对象    用来实现验证的基本    可以从这个对象中获取到拦截的类、方法、方法上的参数等
		//判断handler对象的类型时候符合HandlerMethod,因为当我们请求的路径不对、页面请求静态资源文件时handler的对象不是HandlerMethod
		if(handler instanceof HandlerMethod) {   //当请求的方法成功     //此时我们使用了配置文件的方式去排除拦截的方法
			//判断session域中是否有用户信息
			if((User)request.getSession().getAttribute("currUser") == null) {
				System.out.println("未登录,请登录后操作!!");
				return false;
			}
			System.out.println("已登录,请操作!!");
		} else {
			System.out.println("请求失败!!");
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("这里是执行请求是的操作!!");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("这里是执行请求后的操作!!");
	}
}
