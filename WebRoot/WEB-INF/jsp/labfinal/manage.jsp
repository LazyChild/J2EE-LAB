<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/labfinal/include/header.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/labfinal/include/navbar.jsp" flush="true">
    <jsp:param name="active" value="list"/>
</jsp:include>
<div class="container">
    <div class="row">
        <div class="span10 offset1 well">
            <table class="table table-striped">
                <tbody>
                <tr>
                    <th>文件名</th>
                    <th>上传者</th>
                    <th>文件大小</th>
                    <th>上传日期</th>
                    <th>下载量</th>
                    <th>操作</th>
                </tr>
                <jsp:useBean id="list" scope="request" type="java.util.List"/>
                <c:forEach var="file" items="${list}">
                    <tr>
                        <td><a href="file?download&key=${file.keyCode}">${file.fileName}</a></td>
                        <td>
                            <c:choose>
                                <c:when test="${file.fileSize < 1024}">
                                    ${file.fileSize}B
                                </c:when>
                                <c:otherwise>
                                    <fmt:parseNumber value="${file.fileSize / 1024}" integerOnly="true"/>KB
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${file.uploadDate}</td>
                        <td>
                            <a href="file?delete&id=${file.id}" type="button" class="btn btn-info"
                               onclick='return confirm("你确认要删除这个文件吗？");'>删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="alert alert-info pull-right">
                总文件大小：
                <strong>
                    <jsp:useBean id="sum" scope="request" type="java.lang.Long"/>
                    <c:choose>
                        <c:when test="${sum < 1024}">
                            ${sum}B
                        </c:when>
                        <c:otherwise>
                            <fmt:parseNumber value="${sum / 1024}" integerOnly="true"/>KB
                        </c:otherwise>
                    </c:choose>
                </strong>
            </div>
        </div>
    </div>
</div>
</body>
</html>