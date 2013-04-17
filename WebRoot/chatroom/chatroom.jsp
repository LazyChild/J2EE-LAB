<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp"%>
</head>
<body>
    <%@ include file="/include/navbar.jsp"%>

    <%
        Set<HttpSession> sessions = (Set<HttpSession>) application.getAttribute("sessions");
        List<String> messages = (List<String>) application.getAttribute("messages");
    %>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span4">
                <h3> 当前在线用户数 <%=sessions == null ? 0 : sessions.size()%> </h3>
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
            </div>
            <div class="span8">
                <h3>您好，${sessionScope.username }</h3>
                <p>消息列表：</p>
                <%
                    if (null != messages) {
                        for (String s : messages) {
                            out.println("<p>" + s + "</p>");
                        }
                    }
                %>
                <form action="chatroom/ChatroomChat" method="post">
                    <input type="text" name="text" placeholder="talk here..." /> <input
                        type="hidden" name="username" value="${sessionScope.username}" />
                    <button type="submit" class="btn btn-primary">发送</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>