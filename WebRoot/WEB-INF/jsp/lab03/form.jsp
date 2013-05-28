<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%@ include file="/include/header.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<div class="container">
    <jsp:useBean id="customer" scope="request" class="com.ryliu.j2ee.lab03.Customer"/>
    <c:choose>
        <c:when test="${customer.cid == null}">
            <c:set var="action" value="insert"/>
        </c:when>
        <c:otherwise>
            <c:set var="action" value="update"/>
        </c:otherwise>
    </c:choose>
    <form class="form-horizontal" action="lab03/customer" method="post">
        <input type="hidden" name="${action}"/>
        <div class="control-group">
            <label class="control-label" for="cid">编号</label>

            <div class="controls">
                <c:choose>
                    <c:when test="${customer.cid == null}">
                        <input id="cid" name="cid" type="text" required="required"/>
                    </c:when>
                    <c:otherwise>
                        <input id="cid" name="cid" type="text" value="${customer.cid}" readonly="readonly"/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="cname">姓名</label>

            <div class="controls">
                <input id="cname" name="cname" type="text" value="${customer.cname}" required="required"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="phone">电话</label>

            <div class="controls">
                <input id="phone" name="phone" type="text" value="${customer.phone}"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="mobile">手机号码</label>

            <div class="controls">
                <input id="mobile" name="mobile" type="text" value="${customer.mobile}"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="address">地址</label>

            <div class="controls">
                <input id="address" name="address" type="text" value="${customer.address}"/>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>