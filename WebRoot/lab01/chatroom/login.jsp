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
    <form action="lab01/chatroom/ChatroomLogin" method="post" class="form-signin">
        <fieldset>
	        <legend>登录聊天室：</legend>
	        <input type="text" name="username" placeholder="用户名"/>
	        <button type="submit" class="btn btn-primary">登录</button>
        </fieldset>
    </form>
</div>
</body>
</html>