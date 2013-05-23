<jsp:useBean id="message" scope="request" type="java.lang.String"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp"%>
</head>
<body>
    <%@ include file="/include/navbar.jsp"%>
    <jsp:useBean id="guessnum" class="com.ryliu.j2ee.lab02.fm.service.Guessnum" scope="application"/>
    <div class="container">
        <h2>${message}</h2>
        <form action="lab02/Guess">
            <fieldset>
                <legend>猜数字（40~160）</legend>
                <input type=number min="40" max="160" name="value" placeholder="Value" />
                <button type="submit" class="btn btn-primary">我猜我猜我猜猜猜</button>
            </fieldset>
        </form>
    </div>
</body>
</html>