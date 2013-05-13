<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp"%>
</head>
<body>
    <%@ include file="/include/navbar.jsp"%>
    <div class="container">
        <form>
            <fieldset>
                <legend>旅游费用查询</legend>
                <select name="location">
                    <option value="">地点</option>
                    <option value="bj">北京</option>
                    <option value="hz">杭州</option>
                    <option value="nj">南京</option>
                    <option value="gz">广州</option>
                    <option value="cd">成都</option>
                    <option value="hk">香港</option>
                </select>
                <button type="submit" class="btn btn-primary">提交</button>
            </fieldset>
        </form>
        <c:set var="lo" value="${param.location}" />
        <c:if test='${lo != null && lo != ""}'>
            <c:choose>
                <c:when test='${lo == "bj"}'>
                    <c:set var="locationName" value="北京" />
                    <c:set var="locationPrice" value="100" />
                </c:when>
                <c:when test='${lo == "hz"}'>
                    <c:set var="locationName" value="杭州" />
                    <c:set var="locationPrice" value="200" />
                </c:when>
                <c:when test='${lo == "nj"}'>
                    <c:set var="locationName" value="南京" />
                    <c:set var="locationPrice" value="300" />
                </c:when>
                <c:when test='${lo == "gz"}'>
                    <c:set var="locationName" value="广州" />
                    <c:set var="locationPrice" value="400" />
                </c:when>
                <c:when test='${lo == "cd"}'>
                    <c:set var="locationName" value="成都" />
                    <c:set var="locationPrice" value="500" />
                </c:when>
                <c:when test='${lo == "hk"}'>
                    <c:set var="locationName" value="香港" />
                    <c:set var="locationPrice" value="600" />
                </c:when>
            </c:choose>
            ${locationName}的费用为${locationPrice}元
        </c:if>
    </div>
</body>
</html>