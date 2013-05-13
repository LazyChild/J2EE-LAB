<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp"%>
</head>
<body>
    <%@ include file="/include/navbar.jsp"%>
    <div class="container">
        <h2>购物车</h2>
        <table class="table table-striped">
            <tbody>
            <tr>
            <th>商品名</th><th>单价</th><th>操作</th>
            <c:forEach var="good" items="${chart.goods}">
            <tr>
            <td>${good.name}</td><td>${good.price}</td>
            <td>
            <form action="lab02/remove" method="post" style="margin: 0 0;">
                <input type="hidden" name="id" value="${good.id}"/>
                <input type="hidden" name="name" value="${good.name}"/>
                <input type="hidden" name="price" value="${good.price}"/>
                <button class="btn">删除商品</button>
            </form>
            </td>
            </tr>
            </c:forEach>
            </tr>
            </tbody>
        </table>
        <a href="lab02/shop" ><button class="btn btn-primary">返回继续购物</button></a>
        <a href="lab02/clear" ><button class="btn btn-primary">结账</button></a>
    </div>
</body>
</html>