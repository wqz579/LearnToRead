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
<script type=text/javascript>
	function toggle(id){
	var tb=document.getElementById(id);
	tb.style.display=(tb.style.display=='none')?'block':'none';
	}
</script>
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
			<th scope="col">前次记录时间</th>
			<th scope="col">拼音</th>
			<th scope="col">生字</th>
			<th scope="col">修改认识状态</th>
			<th scope="col">复习</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${words}" var="c" end="9">
			<tr>
				<td scope="col"></td>
				<td scope="col"></td>
				<td scope="col" width="150">
					<div style="cursor:hand" onclick="toggle('pinyin${c.id}')"><b>拼音</b></div>
					<div id="pinyin${c.id}" style="display:none; font-size:80px">${c.name.substring(1)}</div>
				</td>
				<td scope="col" style="font-size:200px;color=green;text-algn:center;font-family:黑体">${c.name.substring(0,1)}</td>
				<td scope="col">
					<div class="col-sm-12 text-center">
						<form method="post" action="updateKnownStatus/${c.id}">
							<button type="submit" class="btn btn-danger">修改为：${status}</button>
						</form>
					</div>
				</td>
				<td scope="col">
					<div class="col-sm-12 text-center">
						<form method="post" action="updateDate/${c.id}">
							<button type="submit" class="btn btn-success">已复习</button>
						</form>
					</div>
				</td>			
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>