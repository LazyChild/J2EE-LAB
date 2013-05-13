<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<div class="container">
    <jsp:useBean id="calc" class="com.ryliu.j2ee.lab02.CalcBean" scope="page" />
    <jsp:setProperty property="operation1" name="calc" param="operation1"/>
    <jsp:setProperty property="operation2" name="calc" param="operation2"/>
    <jsp:setProperty property="operator" name="calc" param="operator"/>
    <h2> 运算的结果: ${calc.operation1 } ${calc.operator } ${calc.operation2 } = <%=calc.calc() %></h2>
</div>
</body>
</html>