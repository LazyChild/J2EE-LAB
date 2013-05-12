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
    <h1>在线测试</h1>
    <form action="TestProcess" method="post">
    <fieldset>
	    <legend>一、填空题：</legend>
	    <label>现在的复旦校长姓名？ <input type="text" name="name" /></label>
	    
	    <legend>二、单选题：</legend>
	    <label>你在哪个校区？</label>
	    <label class="radio inline">
	       <input type="radio" name="campus" value="handan" /> 邯郸
	    </label>
	    <label class="radio inline">
	       <input type="radio" name="campus" value="zhangjiang" /> 张江
	    </label>
	    <label class="radio inline">
	       <input type="radio" name="campus" value="jiangwan" /> 江湾
	    </label>
	    
	    <legend>三、多选题：</legend>
	    <label>Java Web编程已学过什么？</label>
	    <label class="checkbox inline">
	       <input type="checkbox" name="techs" value="servlet" /> Servlet
	    </label>
	    <label class="checkbox inline">
	       <input type="checkbox" name="techs" value="jsp" /> JSP
	    </label>
	    <label class="checkbox inline">
	       <input type="checkbox" name="techs" value="java_bean" /> Java Bean
	    </label>
	    <label class="checkbox inline">
	       <input type="checkbox" name="techs" value="java_mail" /> Java Mail
	    </label>
	    
	    <legend>四、判断题：</legend>
	    <label>学了Java Web编程是否有用？
	       <input type="text" name="judge" placeholder="T 或 F" />
	    </label>
	    <div class="form-actions">
	       <button type="submit" class="btn btn-primary">提交</button>
	       <button type="reset" class="btn">重置</button>
	    </div>
    </fieldset>
    </form>
</div>
</body>
</html>