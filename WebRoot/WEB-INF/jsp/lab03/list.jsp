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
                <td>
                    <a href="lab03/customer?form&cid=${customer.cid}">修改</a> |
                    <a href="lab03/customer?delete&cid=${customer.cid}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="lab03/customer?form">
        <button class="btn btn-primary">插入</button>
    </a>
</div>
</body>
</html>