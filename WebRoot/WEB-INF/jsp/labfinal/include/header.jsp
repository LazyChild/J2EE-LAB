<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/cloud/";
%>
<meta charset="UTF-8">
<title>FDisk - 复旦云</title>
<base href="<%=basePath%>">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/cloud.css" rel="stylesheet" media="screen">
<script src="js/jquery-1.10.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/cloud.js"></script>