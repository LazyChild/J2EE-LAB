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
    <form action="lab01/cube/calc-cube.jsp">
        <fieldset>
        <legend>计算立方</legend>
        <input type="text" name="value" placeholder="Please input value"/>
        <button type="submit" class="btn btn-primary">提交</button>
        <button type="reset" class="btn">重置</button>
        </fieldset>
    </form>
</div>
</body>
</html>