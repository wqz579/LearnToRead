<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type=text/javascript>
	function toggle(id){
	var tb=document.getElementById(id);
	tb.style.display=(tb.style.display=='none')?'block':'none';
	}
</script>

<title>识字页面</title>
</head>
<body>
<div class="container">
<img alt="学前识字" src="${pageContext.request.contextPath}/imgs/XueQianShiZi_Logo.png">
${sessionScope.currentUserName},欢迎您，登录成功！<br>
<a href="${pageContext.request.contextPath}/userForm" >个人中心</a><br>
${flag}${count}
<!-- 此处需要迭代、显示所有生字 -->
<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col">拼音</th>
			<th scope="col">生字</th>
			<th scope="col">操作</th>
		</tr>
	</thead>
	<tbody >
		<c:forEach items="${characters}" var="c" end="5">
			<tr>
				<td scope="col" width="150">
					<div style="cursor:hand" onclick="toggle('pinyin${c.id}')"><b>拼音</b></div>
					<div id="pinyin${c.id}" style="display:none;font-size:80px">${c.name.substring(1)}</div>
				</td>
				<td scope="col" width="220" style="font-size:200px;color=green;text-algn:center;font-family:黑体">${c.name.substring(0,1)}</td>
				<td scope="col" width="100">
					<form method="post" action="insertKnownChars/${c.id}">
						<button type="submit" class="btn btn-success">认识</button>
					</form>
					 <form method="post" action="insertUnknownChars/${c.id}">
						<button type="submit" class="btn btn-danger">不认识</button>
					</form>
				</td>			
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>