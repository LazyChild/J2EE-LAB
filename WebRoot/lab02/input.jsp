<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp"%>
</head>
<body>
    <%@ include file="/include/navbar.jsp"%>
    <div class="container">
        <form action="lab02/convert.jsp">
            <fieldset>
                <legend>输入阿拉伯数字</legend>
                <input type="text" name="value" placeholder="Number" />
                <button type="submit" class="btn btn-primary">提交</button>
            </fieldset>
        </form>
    </div>
</body>
</html>