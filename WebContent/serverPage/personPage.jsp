<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a href="/Bank/logout">登出</a>,<a href="/Bank/confirm">主页</a>
	<p>姓：${account.personInfo.firstName }</p>
	<p>名：${account.personInfo.lastName }</p>
	<p>id：${account.personInfo.id }</p>
	<p>余额：${account.personInfo.money }</p>
	<p>交易历史：</p>
	<ul>
	<c:forEach items="${account.recordInfo.map }" var="item">
		<li>
		<p><c:out value="${item.key }" default="none"/>:<c:out value="${item.value }" default="none"/></p>
		</li>
	</c:forEach>
	</ul>
</body>
</html>