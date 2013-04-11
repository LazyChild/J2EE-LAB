<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<div class="container">
    <%! int x; %>
    <% x = Integer.valueOf(request.getParameter("value")); %>
    <p>
    <%= x %>的立方是：<%= x * x * x %>
    </p>
</div>
</body>
</html>