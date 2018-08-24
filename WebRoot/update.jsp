<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" href="css/bttn.css" />
		<meta charset="UTF-8">
		<style>
			span{
				color: #00BBD4;
				font-size: 20px;
			}
		</style>
		<title>更新信息</title>
	</head>
	<body>
		<form action="ClientPageServlet?action=updateUser" id="form1" method="post">
		<input type="hidden" name="id" value="${user.ID }" />
		<span>编号:</span>&nbsp<input type="text" name="cnumber" value="${user.numberid}" required="required" />
		<br /><br />
		<span>姓名:</span>&nbsp<input type="text" name="cname" value="${user.name}" required="required" />
		<br /><br />
		<span>性别:</span>&nbsp
		<c:if test="${user.sex=='男' }">
			<input type="radio" name="sex" checked="checked" value="男" />男&nbsp;&nbsp;&nbsp;
			<input type="radio" name="sex" value="女" />女<br/>
		</c:if>
		<c:if test="${user.sex=='女' }">
			<input type="radio" name="sex" value="男" />男&nbsp;&nbsp;&nbsp;
			<input type="radio" name="sex" checked="checked" value="女" />女<br/>
		</c:if>
		<br /><br />
		<span>等级:</span>&nbsp<input type="text" value="${user.vipgrade}" name="cgrade" />
		<br /><br />
		<span>电话:</span>&nbsp<input type="text" value="${user.phone}" name="cphone" />
		<br /><br />
		<span>入住时间:</span>&nbsp<input type="date" value="${user.indate}" name="cindate" />
		<br /><br />
		<span>退房时间:</span>&nbsp<input type="date" value="${user.outdate}" name="coutdate" />
		<br /><br />
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<input type="submit" class="bttn-unite" value="完成" />
		</form>
	</body>
</html>
