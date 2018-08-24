package com.Raiblue.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReadLog {

	public static Map<String,String> readFile01(String path) throws IOException{
		// 使用一个字符串集合来存储 文本中的路径，也可以用String[] 数组
		Map<String,String> map = new HashMap<String,String>();
		//  创建一个  文件 管道流 
		FileInputStream fis = new FileInputStream(path);
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
	public static void main(String[] args) throws IOException {
//		String path = "E:/MyEclipse_WorkPlace/HotelManagementSystem/source/access_2013_05_30.log";
//		readFile01(path);
		Map<String,String> map =  readFile01("E:/MyEclipse_WorkPlace/HotelManagementSystem/source/access_2013_05_30.log");
		Set<String> set = map.keySet();
		/*for(String key:set){
			System.out.println(key);
		}*/	
		for(String val:map.values()){
			System.out.println(val);
		}
	}
	
//	public static void main(String[] args) throws Exception {
//		File file = new File("E:/MyEclipse_WorkPlace/HotelManagementSystem/source/part-r-00000.log");
//		FileInputStream fis = new FileInputStream(file);
//		byte[] b = new byte[2048];
//		System.out.println(fis.read(b));
//		System.out.println(b);
//		 
//	}

}
