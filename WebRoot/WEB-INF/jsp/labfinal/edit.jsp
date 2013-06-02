<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/labfinal/include/header.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/labfinal/include/navbar.jsp" flush="true">
    <jsp:param name="active" value="index"/>
</jsp:include>
<div class="container">
    <div class="row">
        <form action="user" method="post" class="form-horizontal offset3 span6 well">
            <input type="hidden" name="edit"/>

            <div class="control-group">
                <label class="control-label" for="name">姓名</label>

                <div class="controls">
                    <input type="text" id="name" name="name" value="${sessionScope.user.name}"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="address">地址</label>

                <div class="controls">
                    <input type="text" id="address" name="address" value="${sessionScope.user.address}"/>
                </div>
            </div>

            <div class="control-group">
                <div class="controls row">
                    <button type="submit" class="btn btn-primary">更新</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>