<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<p>欢迎光临：<a href="serverPage/personPage.jsp">${account.personInfo.firstName }</a>,<a href="/Bank/logout">登出</a></p>
	<h3>您可以执行如下操作：</h3>
	<a href="serverPage/save.jsp">存款</a>
	<a href="serverPage/withdraw.jsp">取款</a>
	<a href="serverPage/check.jsp">查询</a>
	<a href="serverPage/transfer.jsp">转账</a>
</body>
</html>