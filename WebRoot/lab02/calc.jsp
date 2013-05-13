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
        <form action="lab02/result.jsp">
            <fieldset>
                <legend>简单计算器</legend>
                <input type="text" name="operation1" placeholder="Operation One" />
                <select name="operator">
                    <option value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                </select>
                <input type="text" name="operation2" placeholder="Operation Two" />
                <button type="submit" class="btn btn-primary">提交</button>
            </fieldset>
        </form>
    </div>
</body>
</html>