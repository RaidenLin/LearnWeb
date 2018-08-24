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
		<title>用户登录</title>
		<style>
			body{
				font-family: "微软雅黑";
				background: url(img/login.jpg) no-repeat;
				background-size: 100%;
			}
			#div1{
				width: 400px;
				height: 250px;
				margin:0 auto;
				margin-top: 18%;
				font-size: 25px;
				color: darkblue;
				border-top-left-radius: 14px;
				border-top-right-radius: 14px;
				border-bottom-left-radius: 14px;
				border-bottom-right-radius: 14px;
				background:  rgba(200,200,200,0.8);
				display: flex;
				justify-content: center;
				align-items: center;
				}
			
			.login-button { /* 按钮美化 */
				width:100px; /* 宽度 */
				height: 30px; /* 高度 */
				border-width: 0px; /* 边框宽度 */
				border-radius: 3px; /* 边框半径 */
				background: #1E90FF; /* 背景颜色 */
				cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
				outline: none; /* 不显示轮廓线 */
				font-family: Microsoft YaHei; /* 设置字体 */
				color: white; /* 字体颜色 */
				font-size: 17px; /* 字体大小 */
				}

			.login-button:hover { /* 鼠标移入按钮范围时改变颜色 */
				background: #5599FF;
				}
				.inputDIY{
				outline: 0;
    			border: 1px solid #f95d5d;
    			box-shadow: 0px 0px 10px 0px #f95d5d;
    			/*display: flex;*/
				}
			#div2{
				width: auto;
				height: auto;
			}
			span{
				font-size:15px;
				align-self: flex-start;
			}
		</style>
		<script type="text/javascript">
     		function reloadCode(){
	     	 var time=new Date().getTime();
	      	 document.getElementById("imagecode").src="ImageServlet?d="+time;
	     	}
		</script>
	</head>
	<body>
		<div id="div1">
				<div id="div2">
					<center><span style="color: #FF1424; font-size: 15px;">${error }</span></center>
					<form action="UserServlet" method="post">
					<center>
						用户名：
						<input type="text" name="username"  class="inputDIY"/><br />
						<br />
						密码：&nbsp <input type="password" name="pword" class="inputDIY"/><br />
						<span>验证码：</span>&nbsp<input size="2" name="checkCode" /><img alt="验证码" id="imagecode" src="ImageServlet" />
						<span><a href="javascript:reloadCode();">看不清楚</a></span>
						<br />
						<input type="submit" name="sub" value="登录" class="login-button" />&nbsp&nbsp
						<input type="reset" name="res" value="重置" class="login-button" />
					</center>
					</form>
				</div>
		</div>
	</body>
</html>

