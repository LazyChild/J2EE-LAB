<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/include/header.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<div class="container">
    <sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://10.12.8.28:3306/je1124061" user="je1124061"
                       password="283245" var="dataSource" scope="page"/>
    <sql:query var="customers" dataSource="${dataSource}" sql="SELECT * FROM customer;" scope="page"/>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>密码</th>
            <th>Email</th>
        </tr>
        <c:forEach var="row" items="${customers.rows}">
            <tr>
                <td>${row.ID}</td>
                <td>${row.name}</td>
                <td>${row.password}</td>
                <td>${row.email}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>