<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="convert" uri="/WEB-INF/taglib/convertTag.tld" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp"%>
</head>
<body>
    <%@ include file="/include/navbar.jsp"%>
    <div class="container">
        <h2>转换</h2>
        <p>${param.value}</p>
        <p><convert:convertTag value="${param.value}" /></p>
    </div>
</body>
</html>