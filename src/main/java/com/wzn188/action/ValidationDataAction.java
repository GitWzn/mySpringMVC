package com.wzn188.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wzn188.VO.User;
import com.wzn188.myInterface.IAddUserGroup;
import com.wzn188.myInterface.ILoginGroup;

//数据验证
@Controller
public class ValidationDataAction {
	@RequestMapping("validationData")  
	//给指定验证的对象贴上验证注释      SpringMVC会将返回的验证错误信息传递给形参BindingResult
	public void validationData (@Validated({ILoginGroup.class}) User user, BindingResult errorMessge){
		//判断是否要错误信息
		if(errorMessge.hasErrors()) { //有错误信息
			//获取所有的错误信息进行遍历
			List<ObjectError> allErrors = errorMessge.getAllErrors();
			for (ObjectError errMessage : allErrors) {
				System.out.println(errMessage.getDefaultMessage());
			}
		}else {
			System.out.println("接收到的请求数据是：" + user);
		}
	}
}
