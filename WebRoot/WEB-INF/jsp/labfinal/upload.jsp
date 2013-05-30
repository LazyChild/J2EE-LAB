    <jsp:useBean id="file" scope="request" type="com.ryliu.j2ee.labfinal.models.UploadFile"/>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="span6 offset3 well">
            <div class="alert alert-success">
                <button class="close">&times;</button>
                <strong>上传成功！</strong>
            </div>
            <h4>您的提取码：</h4>
            <h2 id="key">
                <code>${file.keyCode}</code>
            </h2>
            <p>可以访问 <a href="index?download&key=${file.keyCode}">http://~?download&key=${file.keyCode}</a>来下载该文件。</p>
            <a class="btn btn-primary pull-right" href="javascript:history.back();">返回</a>
        </div>
    </div>
</div>
</body>
</html>