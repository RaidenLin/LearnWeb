package com.Raiblue.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Raiblue.hoteldao.HotelDao;
import com.Raiblue.hoteldao.impl.HotelDaoImpl;
import com.Raiblue.pojo.Client;
import com.Raiblue.pojo.PageService;

public class ClientPageServlet extends HttpServlet {
	HotelDao hotelDao = new HotelDaoImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		String name = request.getParameter("uname");
		if(name==null||name == ""){
			name="%%";
		}else{
			name = "%"+name+"%";
		}
		int nowPage = request.getParameter("nowPage")==null||request.getParameter("nowPage")==""?1:Integer.parseInt(request.getParameter("nowPage"));
		PageService pageService = new PageService();
		// 设置当前页码
		pageService.setNowPage(nowPage);
		// 设置 总记录数  （求出共几页）
		pageService.setTotal(hotelDao.getCount(name));
		//**分页条件查询**/
		if(action.equals("getALL")){
			List<Client> list = hotelDao.getAllClients(name, pageService);
			request.setAttribute("list", list);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("total", pageService.getTotal());
			request.setAttribute("pageCount", pageService.getPageCount());
			request.getRequestDispatcher("InformationTable.jsp").forward(request, response);
		}else if (action.equals("findUser")) {
			/*修改用户信息*/
			String item = request.getParameter("items");
			String idString = item.replace(":", "");
			//System.out.println(id);
			int id = Integer.parseInt(idString);
			System.out.println(id);
			Client client = hotelDao.findUserById(id);
			request.setAttribute("user", client);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			
		}else if (action.equals("deleteUser")) {
			String items = request.getParameter("items");
			System.out.println("items:"+items);
			String[] ids = items.split(":");
			hotelDao.delsClients(ids);
			List<Client> list = hotelDao.getAllClients(name, pageService);
			request.setAttribute("list", list);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("total", pageService.getTotal());
			request.setAttribute("pageCount", pageService.getPageCount());
			request.getRequestDispatcher("InformationTable.jsp").forward(request, response);
		}else if(action.equals("updateUser")){
			String number = request.getParameter("cnumber");
			String cname = request.getParameter("cname");
			String sex = request.getParameter("sex");
			String grade = request.getParameter("cgrade");
			String phone = request.getParameter("cphone");
			String indate =request.getParameter("cindate");
			String outdate = request.getParameter("coutdate");
			int id = Integer.parseInt(request.getParameter("id"));
//			System.out.println(id+","+number+","+cname+","+sex+","+grade+","+phone+","+indate+","+outdate);
			Client client = new Client();
			client.setID(id);
			client.setNumberid(number);
			client.setName(cname);
			client.setSex(sex);
			client.setVipgrade(grade);
			client.setPhone(phone);
			client.setIndate(indate);
			client.setOutdate(outdate);
			hotelDao.updateClient(client);
			List<Client> list = hotelDao.getAllClients(name, pageService);
			System.out.println(list);
			request.setAttribute("list", list);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("total", pageService.getTotal());
			request.setAttribute("pageCount", pageService.getPageCount());
			request.getRequestDispatcher("InformationTable.jsp").forward(request, response);
			
		}
	}
	
}
