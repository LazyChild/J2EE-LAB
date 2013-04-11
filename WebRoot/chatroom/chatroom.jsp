<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<div class="container">
    <h2>您好，${sessionScope.username }</h2>
    
    <%
        Set<HttpSession> sessions = (Set<HttpSession>) application.getAttribute("sessions");
        List<String> messages = (List<String>) application.getAttribute("messages");
    %>
    <h2>当前在线用户数 <%= sessions == null ? 0 : sessions.size()%> </h2>
    <p>用户列表：</p>
    
    <%
        out.println("<ul>");
	    if (sessions != null) {
	        for (HttpSession s : sessions) {
	            out.println("<li>" + s.getAttribute("username") + "</li>");
	        }
	    }
        out.println("</ul>");
    %>
    
    <h2>消息：</h2>
    <%
        if (null != messages) {
            for (String s : messages) {
                out.println("<p>" + s + "</p>");
            }
        }
    %>
    <form action="chatroom/ChatroomChat" method="post">
        <input type="text" name="text" placeholder="talk here..."/>
        <input type="hidden" name="username" value="${sessionScope.username}"/>
        <button type="submit" class="btn btn-primary">发送</button>
    </form>
</div>
</body>
</html>