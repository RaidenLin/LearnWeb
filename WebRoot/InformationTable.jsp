<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8"></meta>
		<title>客户信息表</title>
		<link rel="stylesheet" href="css/bttn.css" />
		<style type="text/css">
        	table
        	{
            	border-collapse: collapse;
            	margin: 0 auto;
            	text-align: center;
        	}
        	table td, table th
       		{
            	border: 1px solid #cad9ea;
            	color: #666;
            	height: 30px;
        	}
        	table thead th
        	{
            	background-color: #CCE8EB;
            	width: 100px;
       	 	}
        	table tr:nth-child(odd)
        	{
            	background: #fff;
        	}
        	table tr:nth-child(even)
        	{
            	background: #F5FAFA;
        	}
   		</style>
		<script>
			function checkAllfun(){
				var ckall = document.getElementById("checkall");
				var ckitems = document.getElementsByName("check")
				//判断checkAll是否选中
				if(ckall.checked == true){
					for(var i = 0;i<ckitems.length;i++){
						ckitems[i].checked = true;//全部选中
					}
				}else{
					for(var i = 0;i<ckitems.length;i++){
						ckitems[i].checked = false;//全部选中
					}
				}
			}
			function updateMember(){
				var checkItems = document.getElementsByName("check");
				var items = "";
				var k = 0;
				for(var i=0;i<checkItems.length;i++){
					// 如果被选中了 
					if(checkItems[i].checked==true){
						items = items+checkItems[i].value+":";
						k++;  // 有一个被选中的 就 +1
					}
				}
				if(k == 1){
					window.location.href = "ClientPageServlet?action=findUser&items="+items;
				}else{
					alert("只能选择一项进行修改");
				
				}
			}
			function deleteMember(){
				var checkItems = document.getElementsByName("check");
				var items = "";
				var k = 0;
				for(var i=0;i<checkItems.length;i++){
					// 如果被选中了 
					if(checkItems[i].checked==true){
						items = items+checkItems[i].value+":";
						k++;  // 有一个被选中的 就 +1
					}
				}
				if(k>0){
					window.location.href = "ClientPageServlet?action=deleteUser&items="+items;
				}else{
					alert("请选中要删除的一项！！！");
				
				}
			}
			function addMember(){
				window.location.href("addmember.jsp");
			}
			function getName(){
				var uname = document.getElementById("uname").value;
				window.location.href = "ClientPageServlet?action=getALL&uname="+uname;
			}
		</script>
	</head>
	<body>
		<div id="test">
			<input id="uname" name="uname" type="text" placeholder="请输入姓名" value="${param.uname }" />&nbsp<button onclick="getName()">搜索</button>
			<br />
			<table border="1" cellpadding="0" align="center" width="1200px">
				<tr>
					<th height="30px"><center><input type="checkbox" id="checkall" onclick="checkAllfun()"/></center></th>
					<th height="30px"><center>编号</center></th>
					<th height="30px"><center>姓名</center></th>
					<th height="30px"><center>性别</center></th>
					<th height="30px"><center>等级</center></th>
					<th height="30px"><center>电话</center></th>
					<th height="30px"><center>入住时间</center></th>
					<th height="30px"><center>退房时间</center></th>
				</tr>
				<c:forEach items="${list}" var="user">
				<tr>
					<td height="30px"><center><input type="checkbox" name="check" value="${user.ID }"  /></center></td>
					<td height="30px"><center>${user.numberid}</center></td>
					<td height="30px"><center>${user.name}</center></td>
					<td height="30px"><center>${user.sex}</center></td>
					<td height="30px"><center>${user.vipgrade}</center></td>
					<td height="30px"><center>${user.phone}</center></td>
					<td height="30px"><center>${user.indate}</center></td>
					<td height="30px"><center>${user.outdate}</center></td>
				</tr>
				</c:forEach>
			</table>
			<br />
			<center>
				<a href="ClientPageServlet?action=getALL&uname=${param.uname }&nowPage=1">首页</a>&nbsp&nbsp
				<c:if test="${nowPage<=1 }">
				<a href="ClientPageServlet?action=getALL&uname=${param.uname }&nowPage=1">上一页</a>&nbsp&nbsp
				</c:if>
				<c:if test="${nowPage>1 }">
				<a href="ClientPageServlet?action=getALL&uname=${param.uname }&nowPage=${nowPage-1 }">上一页</a>&nbsp&nbsp
				</c:if>
				<c:if test="${nowPage>=pageCount }">
			 	 <a href="ClientPageServlet?action=getALL&uname=${param.uname }&nowPage=${pageCount }">下一页</a>&nbsp&nbsp
				</c:if>
				<c:if test="${nowPage<pageCount }">
				<a href="ClientPageServlet?action=getALL&uname=${param.uname }&nowPage=${nowPage+1 }">下一页</a>&nbsp&nbsp
				</c:if>
				<a href="ClientPageServlet?action=getALL&uname=${param.uname }&nowPage=${pageCount }">尾页</a>&nbsp&nbsp
			</center>
			<br />
			<center>
				<button id="btn_del" onclick="deleteMember()" class="bttn-unite">删除</button>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<button id="btn_upd" onclick="updateMember()" class="bttn-unite">修改</button>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<button id="btn_add" onclick="addMember()" class="bttn-unite">添加</button>
			</center>
		</div>
	</body>
</html>





