<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/Bank/confirm">主页</a>
	<p>
		欢迎光临：<a href="personPage.jsp">${account.personInfo.firstName }</a>,<a href="/Bank/logout">登出</a>
	</p>
	<h1>余额为：${account.personInfo.money }</h1>
</body>
</html>