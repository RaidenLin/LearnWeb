<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<meta charset="UTF-8">
		<title>酒店管理系统</title>
	</head>
	<link rel="stylesheet" href="css/bttn.css" />
	<script type="text/javascript">
		function freshDIVwithTable(){
			document.getElementById("div_concent").innerHTML = "<iframe src='InformationTable.jsp' marginheight='50px' marginwidth='60px' width='1250px' height='570px' scrolling='no' style='border: none;'></iframe>";
			//window.location.href = "ClientPageServlet?action=getALL";
			
		}
		function freshDIVwithLogAnalysis(){
			document.getElementById("div_concent").innerHTML = "<iframe src='LogAnalysis.jsp' marginheight='70px' marginwidth='60px' width='1250px' height='550px' scrolling='no' style='border: none;'></iframe>";
		}
	</script>
	<style>
		body{
				font-family: "微软雅黑";
				background: url(img/login.jpg) no-repeat;
				background-size: 100%;
			}
		#div3{
			width: 1517px;
			height: 150px;
			margin-bottom: 5px;
			color: darkblue;
			border-top-left-radius: 14px;
			border-top-right-radius: 14px;
			border-bottom-left-radius: 14px;
			border-bottom-right-radius: 14px;
			background:  rgba(255,240,245,0.5);
			
		}
		#div_navigation{
			width: 200px;
			height:570px;
			color: darkblue;
			border-top-left-radius: 14px;
			border-top-right-radius: 14px;
			border-bottom-left-radius: 14px;
			border-bottom-right-radius: 14px;
			background:  rgba(240,248,255,0.8);
			float: left;
		}
		#div_concent{
			width: 1297px;
			height: 570px;
			color: darkblue;
			border-top-left-radius: 14px;
			border-top-right-radius: 14px;
			border-bottom-left-radius: 14px;
			border-bottom-right-radius: 14px;
			background:  rgba(240,248,255,0.9);
			float: right;
			

		}
		#div_title{
			text-align:center;
			margin-left:auto; 
			margin-right:auto;
		}
		.text-reflect-base{
 		    text-shadow:#660066 0 0 10px;
    		color:white;
    		font-size:60px

   		}
   		.sub-navigation{
   			width: 100%;
   			height: 33.3%;
   			text-align: center;
   			/*line-height: 190px;*/
   		}
	</style>
	<body>
		<div id="div3">
			<div class="text-reflect-base" id="div_title">酒店管理系统</div>
			<marquee><span style="font-weight: bolder;font-size: 40px;color: white;">Welcome ${username} !</span></marquee>
		</div>
		<div id="div_navigation">
			<button id="btn_getInfo" onclick="freshDIVwithTable()" class="bttn-stretch" style="width:150px; height: 80px;  margin-top: 50px; margin-bottom: 50px; margin-left: 20px; color: #1D89FF;">客户信息</button>
			<button id="btn_getAnaly" onclick="freshDIVwithLogAnalysis()" class="bttn-stretch" style="width:150px; height: 80px; margin-top: 50px; margin-bottom: 50px; margin-left: 20px; color: #1D89FF;">日志分析</button>
			<button onclick="window.location.href='login.jsp'" class="bttn-stretch" style="width:150px; height: 80px; margin-top: 50px; margin-bottom: 50px; margin-left: 20px; color: #1D89FF;">退出登录</button>
		</div>
		<div id="div_concent">
			
		</div>
	</body>
</html>
