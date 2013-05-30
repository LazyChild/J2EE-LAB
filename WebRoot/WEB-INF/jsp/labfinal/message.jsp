<jsp:useBean id="message" scope="request" type="java.lang.String"/>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<div class="container">
    ${message}
</div>
</body>
</html>