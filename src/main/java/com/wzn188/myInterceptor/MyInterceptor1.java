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
public class MyInterceptor1 extends HandlerInterceptorAdapter {
	@Override    //这里是执行请求前的操作
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("这里是执行请求前的操作!!");
		//形参中有一个HandlerMethod对象    用来实现验证的基本    可以从这个对象中获取到拦截的类、方法、方法上的参数等
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		String methodName = handlerMethod.getMethod().getName();
		//获取拦截的方法
		System.out.println("拦截的方法：" + methodName);
		if(!"login".equals(methodName)) {   //不是登录的方法   这里是手动排除拦截login方法
			//从session域中获取用户信息  判断是否登录
			if((User)request.getSession().getAttribute("currUser") == null) {
				System.out.println("未登录,请登录后操作!!");
				return false;
			}
		}
		System.out.println("以登录,可操作!!");
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
