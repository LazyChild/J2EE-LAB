<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB2312">
<title>JavaEE Homework</title>
</head>
<body>
    <jsp:forward page="show-cube.jsp">
    	<jsp:param name="value" value='<%= request.getParameter("value")%>'/>
    </jsp:forward>
</body>
</html>