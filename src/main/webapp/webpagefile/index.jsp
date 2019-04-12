<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>米斯特吴</title>
	</head>
	<body>
		<h1>我若成佛,天下无魔!!我若成魔,佛奈我何!!</h1>
		<form action="/mySpringMVC/user/login.wzn" method="post">
			用户名：<input type="text" name="username" value="米斯特吴" />
			<br /> 年龄：
			<input type="text" name="age" value="18" />
			<br /> 生日：
			<input type="text" name="birthday" value="2019-03-25 20:05:55" />
			<br /> 电话：
			<input type="text" name="userInfo.phone" value="18818877374" />
			<br /> 地址：
			<input type="text" name="userInfo.address" value="南宁高新区" />
			<br />
			<input type="submit" value="登录" />
		</form>
	</body>
</html>