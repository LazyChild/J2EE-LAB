<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaEE Homework</title>
</head>
<body>
	<%! int x; %>
	<% x = Integer.valueOf(request.getParameter("value")); %>
    <%= x %>的立方是：<%= x * x * x %>
</body>
</html>