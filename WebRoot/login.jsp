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
<form action="login" method="post" class="form-signin">
<fieldset>
    <legend>登录</legend>
    <p><input type="text" name="username" placeholder="用户名"/></p>
    <p><input type="password" name="password" placeholder="密码"/></p>
    <%
        if (null != request.getParameter("error") && "true".equals(request.getParameter("error"))) {
            out.println("<p class=\"text-error\">用户名或密码错误！</p>");
        }
    %>
    <button type="submit" class="btn btn-primary">登录</button>
    <button type="reset" class="btn">重置</button>
</fieldset>
</form>
</div>
</body>
</html>