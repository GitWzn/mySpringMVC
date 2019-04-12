package com.wzn188.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wzn188.VO.User;

@Controller
public class ajaxAction {
	@RequestMapping("findUser")
	@ResponseBody    //把返回的数据序列化成JSON字符串返回到页面的body区域
	public List<User> findUser (){
		System.out.println("这里是ajax请求!!");
		ArrayList<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			users.add(new User("用户编号-" + i, 10, new Date(),null));
		}
		return users;		//要把对象，转换成JSON字符串返回
	}
}
