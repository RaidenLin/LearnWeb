<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" href="css/bttn.css" />
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body {
	margin: 0;
	padding: 0;
	}
	</style>	
	<!-- 导入jQuery 的支持 -->
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script src="https://code.highcharts.com/highcharts.src.js"></script>
	<script type="text/javascript">
	function getData(){	
		//document.write("2333");
	 	/* var myDiv = document.getElementById("myContent");
		myDiv.innerHTML = "hello"; */		
		/* y轴数据 */
		var data1 = [];
		/* x轴数据 */
		var data2 = [];
				
		// 第一步，点击访问数据，需要从后台获取数据过来		
		var url = "HadoopLog";
		/* $.post(url,data(向后台传递的数据),
		dataFun(反馈的数据),type 返回来的类型); */
		 $.post(url,{},function(data){
		 // 拆解数据
		 var end = data.substring(1,data.length-1).split(",");
		 // 一个一个获取值 
		 for(var i=0;i<100;i++){
		 	var md = end[i].split("=");		 	
		 	//Y轴 数据 有了   
		 	data1.push(md[0]);
		 	/* 获取第二条数据 ------------------------ */
		 	 var sd = md[1].substring(md[1].length-3,md[1].length);
		 	data2.push(Number(sd));
		 	/*----------------------------------  */
		 }
		 	 /* alert(data);  */
		 	
		//第二步,需要展示后台的数据		
		/* 图表配置 */
		var options = {
			chart:{
				type:'column'   // 指定图表类型，默认是折线图（line）
			},
			title:{
				text:'基于hadoop的日志分析系统'
			},
			xAxis:{
				categories:data1 // X 轴分类
			},
			yAxis:{
				title:{
					text:'统计数据数量'
				}
			},
			series:[{        //数据列
				name:'',		// 数据列名
				data:data2   //  数据
			}]
		};
		
		// 图表初始化函数
		var chart = Highcharts.chart('container',options);
		 	
		 },"text");		
		var myDiv = document.getElementById("myContent");
		// 赋值
		myDiv.innerHTML = "";
	}	
	function clearData(){
		var myDiv = document.getElementById("myContent");
		// 赋值
		myDiv.innerHTML = "";
	}
	</script>
  </head>
  <body>
  	<button onclick="getData()" class="bttn-unite">访问数据</button>
  	
  <hr />
  <div id="container"></div>
  <div id="myContent"></div>
  
   
  </body>
</html>
