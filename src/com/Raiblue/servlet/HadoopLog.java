package com.Raiblue.servlet;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HadoopLog extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response. getWriter();
		// 输出内容  
		out.print(readFile01());
		// 关闭流  
		out.close();
	}
	public static Map<String,String> readFile01() throws IOException{
		// 使用一个字符串集合来存储 文本中的路径，也可以用String[] 数组
		Map<String,String> map = new HashMap<String,String>();
		//  创建一个  文件 管道流 
		FileInputStream fis = new FileInputStream("E:/MyEclipse_WorkPlace/HotelManagementSystem/source/access_2013_05_30.log");
		// 防止路径乱码   如果utf-8 乱码      改GBK  
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		//  放置 缓冲流 中 
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while((line=br.readLine())!=null){
			//  如果txt 文件里的路径  不包含--- 字符串  
			String[] contents = line.split(" - - ");
			map.put(contents[0], contents[1]);
			
		}
		br.close();
		isr.close();
		fis.close();
		return map;
	}
}
