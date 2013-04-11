<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaEE Homework</title>
</head>
<body>
    <jsp:forward page="show-cube.jsp">
        <jsp:param name="value" value='<%= request.getParameter("value")%>'/>
    </jsp:forward>
</body>
</html>