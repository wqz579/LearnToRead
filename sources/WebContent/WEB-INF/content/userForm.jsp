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
<title>个人中心</title>
</head>
<body>
<div class="container">
<img alt="学前识字" src="${pageContext.request.contextPath}/imgs/XueQianShiZi_Logo.png">
${sessionScope.currentUserName}，欢迎进入个人中心
<br>
<a href="${pageContext.request.contextPath}/read">识字页面</a><br>
<div class="form-group row">
<form method="get" action="knownWords">
	<button type="submit" >已经认识</button>
</form>
<form method="get" action="unknownWords">
	<button type="submit" >不认识</button>
</form>
</div>
${flag}${count}
<!-- 此处需要迭代、显示所有生字 -->
<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col">序号</th>
			<th scope="col">字表</th>
			<th scope="col">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${words}" var="c">
			<tr>
				<td scope="col"></td>
				<td scope="col"><img src="${pageContext.request.contextPath}/printChars/${c.id}"></td>
				<td scope="col">
					<form method="post" action="updateKnownStatus/${c.id}">
						<button type="submit" >修改为：${status}</button>
					</form>
				</td>			
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>