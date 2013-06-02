<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/labfinal/include/header.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/labfinal/include/navbar.jsp" flush="true">
    <jsp:param name="active" value="register"/>
</jsp:include>
<div class="container">
    <div class="row">
        <form action="user" method="post" class="form-horizontal offset3 span6 well">
            <input type="hidden" name="register"/>

            <div class="control-group">
                <label class="control-label" for="email">登录邮箱</label>

                <div class="controls">
                    <input type="email" id="email" name="email" placeholder="登录邮箱"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="password">密码</label>

                <div class="controls">
                    <input type="password" id="password" name="password" placeholder="密码"
                           onchange="form.repeat.pattern = this.value;"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="repeat">密码确认</label>

                <div class="controls">
                    <input type="password" id="repeat" name="repeat" placeholder="密码确认"
                           onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Please enter the same password as above!' : '');"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="name">姓名</label>

                <div class="controls">
                    <input type="text" id="name" name="name" placeholder="姓名"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="address">地址</label>

                <div class="controls">
                    <input type="text" id="address" name="address" placeholder="地址"/>
                </div>
            </div>

            <div class="control-group">
                <div class="controls row">
                    <button type="submit" class="btn btn-primary">注册</button>
                    &nbsp;&nbsp;
                    <button type="reset" class="btn">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>