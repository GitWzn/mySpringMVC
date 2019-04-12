package com.wzn188.VO;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wzn188.myInterface.IAddUserGroup;
import com.wzn188.myInterface.ILoginGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	//使用Hibernate提供的注释验证        使用读取资源文件内容的方式设置错误信息
	//@Pattern(regexp="^\\w{6,12}$", message="用户名不符合要求!", groups={ILoginGroup.class,IAddUserGroup.class})
	@Pattern(regexp="^\\w{6,12}$", message="{username.error.msg}", groups={ILoginGroup.class,IAddUserGroup.class})
	private String username;
	@Range(min=18, max=60, message="{age.error.msg}", groups={ILoginGroup.class,IAddUserGroup.class})
	private int age;
	@JsonFormat(pattern="yyyy-MM-dd")   //将时间格式化
	private Date birthday;
	//如果进行验证关联就要这个注释
	@Valid
	private UserInfo userInfo;
}
