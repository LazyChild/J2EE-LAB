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
        <h2>货品展示</h2>
        <table class="table table-striped">
            <tbody>
            <tr>
            <th>商品名</th><th>单价</th><th>操作</th>
            <c:forEach var="good" items="${goods}">
            <tr>
            <td>${good.name}</td><td>${good.price}</td>
            <td>
            <form action="lab02/buy" method="post" style="margin: 0 0;">
                <input type="hidden" name="id" value="${good.id}"/>
                <input type="hidden" name="name" value="${good.name}"/>
                <input type="hidden" name="price" value="${good.price}"/>
                <button class="btn">加入购物车</button>
            </form>
            </td>
            </tr>
            </c:forEach>
            </tr>
            </tbody>
        </table>
        <a href="lab02/chart.jsp" ><button class="btn btn-primary">查看购物车</button></a>
    </div>
    <c:if test="${param.ok != null }">
    <script type="text/javascript">alert('商品成功加入购物车！');</script>
    </c:if>
</body>
</html>