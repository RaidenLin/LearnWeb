package com.Raiblue.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import com.Raiblue.hoteldao.HotelDao;
import com.Raiblue.hoteldao.impl.HotelDaoImpl;
import com.Raiblue.pojo.Client;

public class AddClients extends HttpServlet {
	HotelDao hotelDao = new HotelDaoImpl();
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//System.out.println("coming...");
		String number = request.getParameter("cnumber");
		String name = request.getParameter("cname");
		String sex = request.getParameter("sex");
		String grade = request.getParameter("cgrade");
		String phone = request.getParameter("cphone");
		String indate = request.getParameter("cindate");
		String outdate = request.getParameter("coutdate");
		//System.out.println(number+":"+name+":"+sex+":"+grade+":"+phone+":"+indate+":"+outdate);
		Client client = new Client();
		client.setNumberid(number);
		client.setName(name);
		client.setSex(sex);
		client.setVipgrade(grade);
		client.setPhone(phone);
		client.setIndate(indate);
		client.setOutdate(outdate);
		hotelDao.addClient(client);
		System.out.println("success");
		request.getRequestDispatcher("InformationTable.jsp").forward(request, response);
	}
	
	
}
