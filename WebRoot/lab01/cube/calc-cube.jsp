<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp" %>
</head>
<body>
    <jsp:forward page="/lab01/cube/show-cube.jsp">
        <jsp:param name="value" value='<%= request.getParameter("value")%>'/>
    </jsp:forward>
</body>
</html>