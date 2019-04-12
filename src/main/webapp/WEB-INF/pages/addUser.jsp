<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/color.css">
		<title>米斯特吴</title>
	</head>
	<body>
		<h1>这里是添加用户!!</h1>
		<!-- 页面中获取静态文件需要当前文件的目录相对路径  方法一： -->
		${pageContext.request.contextPath}
		<br />
		<img src="${pageContext.request.contextPath}/img/logo.gif">
		<%-- ${requestScope.user} --%>
		<br />
		${user}
		<br />
		<c:url value="/img/logo.gif" />
		<br />
		<img src="<c:url value="/img/logo.gif" />">
	</body>
</html>