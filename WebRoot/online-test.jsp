<!DOCTYPE html>
<html>
<head>
<meta charset="GB2312">
<title>JavaEE Homework</title>
</head>
<body>
	<h1>Online Test</h1>
	<form action="TestProcess" method="post">
	<h2>一、填空题：</h2>
	<p>
		现在的复旦校长姓名？
		<input type="text" name="name" />
	</p>
	
	<h2>二、单选题：</h2>
	<p>
		你在哪个校区？
		<input type="radio" name="campus" value="handan" />邯郸
		<input type="radio" name="campus" value="zhangjiang" />张江
		<input type="radio" name="campus" value="jiangwan" />江湾
	</p>
	
	<h2>三、多选题：</h2>
	<p>
		Java Web编程已学过什么？
		<input type="checkbox" name="techs" value="servlet" />Servlet
		<input type="checkbox" name="techs" value="jsp" />JSP
		<input type="checkbox" name="techs" value="java_bean" />Java Bean
		<input type="checkbox" name="techs" value="java_mail" />Java Mail
	</p>
	
	<h2>四、判断题：</h2>
	<p>
		学了Java Web编程是否有用？
		<input type="text" name="judge" />(T 或 F)
	</p>
	<input type="submit" value="提交"/>
	<input type="reset" value="重置"/>
	</form>
</body>
</html>