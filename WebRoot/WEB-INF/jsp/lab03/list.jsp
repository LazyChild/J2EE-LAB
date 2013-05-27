<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%@ include file="/include/header.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<div class="container">
    <table class="table table-striped">
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>电话</th>
            <th>手机号码</th>
            <th>地址</th>
            <th>修改 | 删除</th>
        </tr>
        <jsp:useBean id="list" scope="request" type="java.util.List"/>
        <c:forEach var="customer" items="${list}">
            <tr>
                <td>${customer.cid}</td>
                <td>${customer.cname}</td>
                <td>${customer.phone}</td>
                <td>${customer.mobile}</td>
                <td>${customer.address}</td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>