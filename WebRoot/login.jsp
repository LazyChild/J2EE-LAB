<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB2312">
<title>JavaEE Homework</title>
</head>
<body>
<h1>登录</h1>
<form action="login" method="post">
	<p><input name="username"/></p>
	<p><input type="password" name="password"/></p>
	<%
		if (null != request.getParameter("error") && "true".equals(request.getParameter("error"))) {
			out.println("<strong>用户名或密码错误！</strong>");
		}
	%>
	<p><input type="submit" value="登录"/>
	<input type="reset" value="重置"/></p>
</form>

</body>
</html>