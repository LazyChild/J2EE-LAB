<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB2312">
<title>JavaEE Homework</title>
</head>
<body>
    <h1>欢迎使用聊天室</h1>
    <p>您好，${sessionScope.username }</p>
    
    <%
        Set<HttpSession> sessions = (Set<HttpSession>) application.getAttribute("sessions");
        List<String> messages = (List<String>) application.getAttribute("messages");
    %>
    <h2>当前在线用户数 <%= sessions.size()%> </h2>
    <p>用户列表：</p>
    
    <%
        out.println("<ul>");
        for (HttpSession s : sessions) {
            out.println("<li>" + s.getAttribute("username") + "</li>");
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
    <form action="ChatroomChat" method="post">
        <input name="text"/>
        <input type="hidden" name="username" value="${sessionScope.username }"/>
        <input type="submit" value="发送"/>
    </form>
</body>
</html>