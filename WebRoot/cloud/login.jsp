<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/labfinal/include/header.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/labfinal/include/navbar.jsp" flush="true">
    <jsp:param name="active" value="login"/>
</jsp:include>
<div class="container">
    <div class="row">
        <form action="user" method="post" class="form-horizontal offset3 span6 well">
            <input type="hidden" name="login"/>

            <div class="control-group">
                <label class="control-label" for="email">登录邮箱</label>

                <div class="controls">
                    <input type="email" id="email" name="email" placeholder="登录邮箱"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="password">密码</label>

                <div class="controls">
                    <input type="password" id="password" name="password" placeholder="密码"/>
                </div>
            </div>

            <div class="control-group">
                <div class="controls row">
                    <button type="submit" class="btn btn-primary">登录</button>
                    &nbsp;&nbsp;
                    <button type="reset" class="btn">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>