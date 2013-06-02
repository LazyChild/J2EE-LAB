<jsp:useBean id="message" scope="request" type="java.lang.String"/>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/labfinal/include/navbar.jsp" flush="true">
    <jsp:param name="active" value="index"/>
</jsp:include>
<div class="container">
    <div class="row">
        <div class="span6 offset3 well">
            <div class="alert alert-error">
                <button class="close">&times;</button>
                <strong>
                    ${message}
                </strong>
            </div>
        </div>
    </div>
</div>
</body>
</html>