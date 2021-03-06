<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    </p>
    <table class="table table-striped">
        <tbody>
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
            <td><a href="GetSourceServlet?class=com.ryliu.j2ee.lab01.FirstServlet">FirstServlet.java</a></td>
        </tr>
        <tr>
            <td>1.3</td>
            <td>this page</td>
            <td><a href="GetSourceServlet?file=index.jsp">index.jsp</a></td>
        </tr>
        <tr>
            <td>1.4</td>
            <td><a href="lab01/online-test.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=lab01/online-test.jsp">online-test.jsp</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab01.TestProcess">TestProcess.java</a></td>
        </tr>
        <tr>
            <td>1.5</td>
            <td><a href="lab01/cube/cube.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=lab01/cube/cube.jsp">cube.jsp</a> |
                <a href="GetSourceServlet?file=lab01/cube/show-cube.jsp">show-cube.jsp</a> |
                <a href="GetSourceServlet?file=lab01/cube/calc-cube.jsp">calc-cube.jsp</a></td>
        </tr>
        <tr>
            <td>1.6</td>
            <td><a href="lab01/chatroom/login.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=lab01/chatroom/login.jsp">login.jsp</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab01.chatroom.ChatroomLogin">ChatroomLogin.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab01.chatroom.ChatroomChat">ChatroomChat.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab01.chatroom.MySessionListener">MySessionListener.java</a>
            </td>
        </tr>
        <tr>
            <td>1.7</td>
            <td>N/A</td>
            <td><a href="GetSourceServlet?file=login.jsp">login.jsp</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab01.LoginServlet">LoginServlet.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab01.AuthorityFilter">AuthorityFilter.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab01.GetSourceServlet">GetSourceServlet.java</a> |
                <a href="GetSourceServlet?file=WEB-INF/jsp/lab01/show_code.jsp">show_code.jsp</a>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <th>题号</th>
            <th>演示</th>
            <th>源代码</th>
        </tr>
        <tr>
            <td>2.1</td>
            <td><a href="lab02/calc.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=lab02/calc.jsp">calc.jsp</a> |
                <a href="GetSourceServlet?file=lab02/result.jsp">result.jsp</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab02.CalcBean">CalcBean.java</a>
            </td>
        </tr>
        <tr>
            <td>2.2</td>
            <td><a href="lab02/guessnum.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=lab02/guessnum.jsp">guessnum.jsp</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab02.fm.action.Control">Control.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab02.fm.service.Guessnum">Guessnum.java</a>
            </td>
        </tr>
        <tr>
            <td>2.3</td>
            <td><a href="lab02/shop">execute</a></td>
            <td><a href="GetSourceServlet?file=/WEB-INF/jsp/lab02/shop.jsp">shop.jsp</a> |
                <a href="GetSourceServlet?file=lab02/chart.jsp">chart.jsp</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab02.shop.Good">Good.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab02.shop.Chart">Chart.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab02.shop.ShopControl">ShopControl.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab02.shop.BuyControl">BuyControl.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab02.shop.RemoveControl">RemoveControl.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab02.shop.ClearControl">ClearControl.java</a>
            </td>
        </tr>
        <tr>
            <td>2.4</td>
            <td><a href="lab02/input.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=lab02/input.jsp">input.jsp</a> |
                <a href="GetSourceServlet?file=lab02/convert.jsp">convert.jsp</a> |
                <a href="GetSourceServlet?file=WEB-INF/taglib/convertTag.tld">convertTag.tld</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab02.Convert">Convert.java</a>
            </td>
        </tr>
        <tr>
            <td>2.5</td>
            <td><a href="lab02/travel.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=lab02/travel.jsp">travel.jsp</a></td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <th>题号</th>
            <th>演示</th>
            <th>源代码</th>
        </tr>
        <tr>
            <td>3.1</td>
            <td><a href="lab03/jstl_query.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=lab03/jstl_query.jsp">jstl_query.jsp</a></td>
        </tr>
        <tr>
            <td>3.2</td>
            <td><a href="lab03/input.jsp">execute</a></td>
            <td><a href="GetSourceServlet?file=lab03/input.jsp">input.jsp</a> |
                <a href="GetSourceServlet?file=lab03/query.jsp">query.jsp</a>
            </td>
        </tr>
        <tr>
            <td>3.3</td>
            <td><a href="lab03/customer">execute</a></td>
            <td><a href="GetSourceServlet?class=com.ryliu.j2ee.lab03.Customer">Customer.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.services.AbstractDAO">AbstractDAO.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.services.RowCallbackHandler">RowCallbackHandler.java</a>
                |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab03.CustomerDAO">CustomerDAO.java</a> |<br>
                <a href="GetSourceServlet?class=com.ryliu.j2ee.lab03.CustomerController">CustomerController.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.utils.ConnectionFactory">ConnectionFactory.java</a> |
                <a href="GetSourceServlet?class=com.ryliu.j2ee.utils.Helper">Helper.java</a> |
                <a href="GetSourceServlet?file=WEB-INF/jsp/lab03/list.jsp">list.jsp</a> |
                <a href="GetSourceServlet?file=WEB-INF/jsp/lab03/form.jsp">form.jsp</a></td>
        </tr>
        </tbody>
    </table>

    <div class="alert alert-info">
        点击此链接访问期末大作业：<a href="cloud"><strong>复旦云</strong></a>


        <h5>Models:</h5>
        <ul class="inline">
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.models.User">User.java</a></li>
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.models.Role">Role.java</a></li>
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.models.UploadFile">UploadFile.java</a></li>
        </ul>
        <h5>Services:</h5>
        <ul class="inline">
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.services.AbstractDAO">AbstractDAO.java</a></li>
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.services.RowCallbackHandler">RowCallbackHandler.java</a></li>
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.services.StatementSetter">StatementSetter.java</a></li>
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.services.UserDAO">UserDAO.java</a></li>
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.services.UploadFileDAO">UploadFileDAO.java</a></li>
        </ul>
        <h5>Controllers:</h5>
        <ul class="inline">
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.controllers.CloudAuthorityFilter">CloudAuthorityFilterr.java</a></li>
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.controllers.UserController">UserController.java</a></li>
            <li><a href="GetSourceServlet?class=com.ryliu.j2ee.labfinal.controllers.FileController">FileController.java</a></li>
        </ul>
        <h5>Views:</h5>
        <ul class="inline">
            <li><a href="GetSourceServlet?file=/cloud/index.jsp">index.jsp</a></li>
            <li><a href="GetSourceServlet?file=/cloud/login.jsp">login.jsp</a></li>
            <li><a href="GetSourceServlet?file=/cloud/register.jsp">register.jsp</a></li>
            <li><a href="GetSourceServlet?file=/WEB-INF/jsp/labfinal/edit.jsp">edit.jsp</a></li>
            <li><a href="GetSourceServlet?file=/WEB-INF/jsp/labfinal/upload.jsp">upload.jsp</a></li>
            <li><a href="GetSourceServlet?file=/WEB-INF/jsp/labfinal/list.jsp">list.jsp</a></li>
            <li><a href="GetSourceServlet?file=/WEB-INF/jsp/labfinal/manage.jsp">manage.jsp</a></li>
        </ul>
    </div>
</div>
</body>
</html>