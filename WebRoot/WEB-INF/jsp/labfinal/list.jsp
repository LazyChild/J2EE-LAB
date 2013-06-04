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
<div class="modal hide fade" id="print-modal" tabindex="-1">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">&times;</a>

        <h3>打印文档</h3>
    </div>
    <div class="modal-body">
        打印文档将配送到：${sessionScope.user.name} - ${sessionScope.user.address}
    </div>
    <div class="modal-footer">
        <button class="btn btn-primary" data-dismiss="modal">确定</button>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="span10 offset1 well">
            <table class="table table-striped">
                <tbody>
                <tr>
                    <th>文件名</th>
                    <th>文件大小</th>
                    <th>上传日期</th>
                    <th>提取码</th>
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
                        <td><code>${file.keyCode}</code></td>
                        <td>
                            <a type="button" class="btn btn-info" data-toggle="modal" href="#print-modal">打印</a>
                            <a href="file?delete&id=${file.id}" type="button" class="btn"
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