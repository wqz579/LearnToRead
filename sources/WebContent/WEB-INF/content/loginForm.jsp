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
<title>登录页面</title>
</head>
<body>
<div class="container">
<img alt="学前识字" src="${pageContext.request.contextPath}/imgs/XueQianShiZi_Logo.png">
<form method="post" action="login">
<div class="form-group row">
	<label for="name" class="col-sm-3 col-form-label">用户名：</label>
	<div class="col-sm-7">
		<input type="text" id="name" name="name" 
			class="form-control" placeholder="输入用户名">
	</div>
</div>
<div class="form-group row">
	<label for="password" class="col-sm-3 col-form-label">密码：</label>
	<div class="col-sm-7">
		<input type="password" id="password" name="password"
			class="form-control" placeholder="输入密码">
	</div>
</div>
<div class="form-group row">
	<label for="vercode" class="col-sm-3 col-form-label">验证码：</label>
	<div class="col-sm-2">
		<input type="text" id="vercode" name="vercode"
			class="form-control" placeholder="输入验证码">
	</div>
	<div class="col-sm-2">
		<img src="${pageContext.request.contextPath}/vercode" alt="验证码">
	</div>
	<div class="col-sm-5">
		<label for="vercode" class="col-sm-5 col-form-label">区分大小写</label>
	</div>
</div>
<div class="form-group row">
	<div class="col-sm-12 text-center">
		<button type="submit" class="btn btn-success">登录</button>
		<button type="reset" class="btn btn-danger">重设</button>
	</div>
</div>
<div class="form-group row">
	<a href="${pageContext.request.contextPath}/register">注册页面</a>
</div>
</form>
<c:if test="${not empty tip}">
	<div class="alert alert-danger">
		${tip}
	</div>
</c:if>
</div>
</body>
</html>