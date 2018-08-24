<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%


String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" href="css/bttn.css" />
		<meta charset="UTF-8">
		<title>添加用户</title>
		<style>
			span{
				color: #00BBD4;
				font-size: 20px;
			}
		</style>
	</head>
	<body>
		<form action="AddClients" method="post">
		<span>编号:</span>&nbsp<input type="text" name="cnumber" required="required" />
		<br /><br />
		<span>姓名:</span>&nbsp<input type="text" name="cname" required="required" />
		<br /><br />
		<span>性别:</span>&nbsp<input type="radio" name="sex" value="男"  checked="checked"/>男
		<input type="radio" name="sex" value="女"/>女
		<br /><br />
		<span>等级:</span>&nbsp<input type="text" name="cgrade" />
		<br /><br />
		<span>电话:</span>&nbsp<input type="text" name="cphone" />
		<br /><br />
		<span>入住时间:</span>&nbsp<input type="date" name="cindate" />
		<br /><br />
		<span>退房时间:</span>&nbsp<input type="date" name="coutdate" />
		<br /><br />
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<input type="submit" class="bttn-unite" value="完成" />
		</form>
	</body>
</html>

