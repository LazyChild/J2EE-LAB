<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<div class="container">
    <h1>JavaEE Lab</h1>
    <p>
        为了方便版本控制，本实验全部代码托管于<a href="http://github.com">github.com</a>。查看源码时请确保本机环境可以正常访问。
    </p>
    <table class="table table-striped">
        <tr>
            <th>题号</th>
            <th>演示</th>
            <th>源代码</th>
        </tr>
        <tr>
            <td>1.1</td>
            <td>N/A</td>
            <td><a href="GetSourceServlet?file=WEB-INF/web.xml">web.xml</a></td>
        </tr>
        <tr>
            <td>1.2</td>
            <td><a href="FirstServlet">execute</a></td>
            <td><a href="GetSourceServlet?class=com.ryliu.j2ee.hw01.FirstServlet">FirstServlet.java</a></td>
        </tr>
        <tr>
            <td>1.3</td>
            <td>this page</td>
            <td><a href="GetSourceServlet?file=index.jsp">index.jsp</a></td>
        </tr>
        <tr>
            <td>1.4</td>
            <td><a href="online-test.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=online-test.jsp">online-test.jsp</a> | 
            <a href="GetSourceServlet?class=com.ryliu.j2ee.hw01.TestProcess">TestProcess.java</a></td>
        </tr>
        <tr>
            <td>1.5</td>
            <td><a href="cube/cube.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=cube/cube.jsp">cube.jsp</a> |
            <a href="GetSourceServlet?file=cube/show-cube.jsp">show-cube.jsp</a> |
            <a href="GetSourceServlet?file=cube/calc-cube.jsp">calc-cube.jsp</a></td>
        </tr>
        <tr>
            <td>1.6</td>
            <td><a href="chatroom/login.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=chatroom/login.jsp">login.jsp</a> | 
            <a href="GetSourceServlet?class=com.ryliu.j2ee.hw01.chatroom.ChatroomLogin">ChatroomLogin.java</a> |  
            <a href="GetSourceServlet?class=com.ryliu.j2ee.hw01.chatroom.ChatroomChat">ChatroomChat.java</a> |
            <a href="GetSourceServlet?class=com.ryliu.j2ee.hw01.chatroom.MySessionListener">MySessionListener.java</a></td>
        </tr>
        <tr>
            <td>1.7</td>
            <td>N/A</td>
            <td><a href="GetSourceServlet?file=login.jsp">login.jsp</a> | 
            <a href="GetSourceServlet?class=com.ryliu.j2ee.hw01.LoginServlet">LoginServlet.java</a> | 
            <a href="GetSourceServlet?class=com.ryliu.j2ee.hw01.AuthorityFilter">AuthorityFilter.java</a> |
            <a href="GetSourceServlet?class=com.ryliu.j2ee.hw01.GetSourceServlet">GetSourceServlet.java</a>  
            </td>
        </tr>
    </table>
</div>
</body>
</html>