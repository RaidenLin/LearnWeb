package com.Raiblue.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Raiblue.pojo.User;
import com.Raiblue.service.UserService;
import com.Raiblue.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	UserService userService = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("pword");
		String code1 = request.getParameter("checkCode");
		System.out.println("页面验证码："+code1);
		String code2 = (String) request.getSession().getAttribute("piccode");
		System.out.println("图片中的验证码："+code2);
		User user = userService.login(name,pwd);
		if(code1.equalsIgnoreCase(code2)){
			if(user.getUsername()==null){
				request.setAttribute("error","用户名或密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}else{   
				request.getSession().setAttribute("username", user.getUsername());
				response.sendRedirect("hotelManage.jsp");
			}
		}
		else{
			request.setAttribute("error", "验证码输入错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
