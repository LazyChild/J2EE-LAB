<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         import="com.ryliu.j2ee.labfinal.models.Role" %>
<div class="navbar">
    <div class="navbar-inner">
        <span class="brand">FDisk</span>
        <ul class="nav">
            <c:choose>
                <c:when test='${param.active == "index"}'>
                    <li class="active"><a href="#">首页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="#">首页</a></li>
                </c:otherwise>
            </c:choose>

            <c:if test='${sessionScope.user != null}'>
                <c:choose>
                    <c:when test='${param.active == "my"}'>
                        <li class="active"><a href="file?list">我的云</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="file?list">我的云</a></li>
                    </c:otherwise>
                </c:choose>
            </c:if>

            <c:if test='${sessionScope.user != null && sessionScope.user.role == "ADMIN"}'>
                <c:choose>
                    <c:when test='${param.active == "admin"}'>
                        <li class="active"><a href="file?manage">管理</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="file?manage">管理</a></li>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </ul>
        <ul class="nav pull-right">
            <c:choose>
                <c:when test='${sessionScope.user != null}'>
                    <li><a href="user?edit">您好：${sessionScope.user.name}</a></li>
                    <li><a href="user?logout">登出</a></li>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test='${param.active == "login"}'>
                            <li class="active"><a href="login.jsp">登录</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="login.jsp">登录</a></li>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test='${param.active == "register"}'>
                            <li class="active"><a href="register.jsp">注册</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="register.jsp">注册</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>