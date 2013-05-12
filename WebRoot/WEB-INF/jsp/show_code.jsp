<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp" %>
<link href="css/prettify.css" rel="stylesheet">
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<div class="container">
<h2>${title}</h2>
<pre class="prettyprint">${code}</pre>
</div>
<script src="js/prettify.js"></script>  
<script>prettyPrint();</script> 
</body>
</html>