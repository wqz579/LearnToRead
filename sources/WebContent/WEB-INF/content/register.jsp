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
<title>用户注册页面</title>
</head>
<body>
<div class="container">
<img alt="学前识字" src="${pageContext.request.contextPath}/imgs/XueQianShiZi_Logo.png">
<form method="post" action="addUser">
<div class="form-group row">
	<label for="name" class="col-sm-3 col-form-label">用户名：</label>
	<div class="col-sm-7">
		<input type="text" id="name" name="name" 
			class="form-control" placeholder="输入用户名">
	</div>
	<div class="col-sm-2">
		<form:errors path="user.name" class="text-danger"></form:errors>
	</div>
</div>
<div class="form-group row">
	<label for="password" class="col-sm-3 col-form-label">密码：</label>
	<div class="col-sm-7">
		<input type="password" id="password" name="password"
			class="form-control" placeholder="输入密码">
	</div>
	<div class="col-sm-2">
		<form:errors path="user.password" class="text-danger"></form:errors>
	</div>	
</div>
<div class="form-group row">
	<div class="col-sm-12 text-center">
		<button type="submit" class="btn btn-success">提交注册</button>
		<button type="reset" class="btn btn-danger">重设</button>
	</div>
</div>
<c:if test="${not empty failure}">
	<div class="alert alert-danger">
		${failure}
	</div>
</c:if>
<c:if test="${not empty success}">
	<div class="alert alert-primary">
		${success}
	</div>
</c:if>
<a href="${pageContext.request.contextPath}/loginForm">登录页面</a>
</form>
</div>
</body>
</html>