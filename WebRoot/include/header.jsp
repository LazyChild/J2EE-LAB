<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta charset="UTF-8">
<title>JavaEE Lab</title>
<base href="<%=basePath%>">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/javaee.css" rel="stylesheet" media="screen">
<script src="js/bootstrap.min.js"></script>