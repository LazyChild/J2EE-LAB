<!DOCTYPE html>
<html>
<head>
<meta charset="GB2312">
<title>JavaEE Homework</title>
</head>
<body>
	<h1>Online Test</h1>
	<form action="TestProcess" method="post">
	<h2>һ������⣺</h2>
	<p>
		���ڵĸ���У��������
		<input type="text" name="name" />
	</p>
	
	<h2>������ѡ�⣺</h2>
	<p>
		�����ĸ�У����
		<input type="radio" name="campus" value="handan" />����
		<input type="radio" name="campus" value="zhangjiang" />�Ž�
		<input type="radio" name="campus" value="jiangwan" />����
	</p>
	
	<h2>������ѡ�⣺</h2>
	<p>
		Java Web�����ѧ��ʲô��
		<input type="checkbox" name="techs" value="servlet" />Servlet
		<input type="checkbox" name="techs" value="jsp" />JSP
		<input type="checkbox" name="techs" value="java_bean" />Java Bean
		<input type="checkbox" name="techs" value="java_mail" />Java Mail
	</p>
	
	<h2>�ġ��ж��⣺</h2>
	<p>
		ѧ��Java Web����Ƿ����ã�
		<input type="text" name="judge" />(T �� F)
	</p>
	<input type="submit" value="�ύ"/>
	<input type="reset" value="����"/>
	</form>
</body>
</html>