<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaEE Homework</title>
</head>
<body>
	<h1>Online Test</h1>
	<form action="TestProcess" method="post">
	<h2>一、简答题</h2>
	<p>
		复旦现任校长是？
		<input type="text" name="name" />
	</p>
	
	<h2>¶þ¡¢µ¥Ñ¡Ìâ£º</h2>
	<p>
		ÄãÔÚÄÄ¸öÐ£Çø£¿
		<input type="radio" name="campus" value="handan" />ºªµ¦
		<input type="radio" name="campus" value="zhangjiang" />ÕÅ½­
		<input type="radio" name="campus" value="jiangwan" />½­Íå
	</p>
	
	<h2>Èý¡¢¶àÑ¡Ìâ£º</h2>
	<p>
		Java Web±à³ÌÒÑÑ§¹ýÊ²Ã´£¿
		<input type="checkbox" name="techs" value="servlet" />Servlet
		<input type="checkbox" name="techs" value="jsp" />JSP
		<input type="checkbox" name="techs" value="java_bean" />Java Bean
		<input type="checkbox" name="techs" value="java_mail" />Java Mail
	</p>
	
	<h2>ËÄ¡¢ÅÐ¶ÏÌâ£º</h2>
	<p>
		Ñ§ÁËJava Web±à³ÌÊÇ·ñÓÐÓÃ£¿
		<input type="text" name="judge" />(T »ò F)
	</p>
	<input type="submit" value="Ìá½»"/>
	<input type="reset" value="ÖØÖÃ"/>
	</form>
</body>
</html>