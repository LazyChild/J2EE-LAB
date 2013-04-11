<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB2312">
<title>JavaEE Homework</title>
</head>
<body>
	<%! int x; %>
	<% x = Integer.valueOf(request.getParameter("value")); %>
    <%= x %>的立方是：<%= x * x * x %>
</body>
</html>