<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/res/bootstrap-4.3.1/css/bootstrap.css"/>
<script type="text/javascript" 
	src="${pageContext.request.contextPath}/res/jquery-3.4.1.min.js"></script>
<script type="text/javascript" 
	src="${pageContext.request.contextPath}/res/bootstrap-4.3.1/js/bootstrap.js"></script>
<title>导入生字</title>
</head>
<body>
<div>

<form method="post" action="importPrimaryChars">
	<div class="col-sm-12 text-center">
		<br>
		<button class="btn btn-success" type="submit" >请点击将生词导入数据库</button>
	</div>
</form>

</div>
</body>
</html>