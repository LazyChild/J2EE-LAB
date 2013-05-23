<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/include/header.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<div class="container">
    <form action="lab03/query.jsp">
        <fieldset>
            <legend>学生姓名</legend>
            <input type="text" name="name" placeholder="姓名"/>
            <button type="submit" class="btn btn-primary">提交</button>
        </fieldset>
    </form>
</div>
</body>
</html>