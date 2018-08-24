package com.Raiblue.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.junit.Before;
import org.junit.Test;

import com.Raiblue.hoteldao.HotelDao;
import com.Raiblue.hoteldao.impl.HotelDaoImpl;
import com.Raiblue.pojo.Client;
import com.Raiblue.pojo.PageService;
import com.Raiblue.pojo.User;
import com.Raiblue.service.UserService;
import com.Raiblue.service.impl.UserServiceImpl;

public class MethodTest {
	UserService userService = new UserServiceImpl();
	HotelDao hotelDao = new HotelDaoImpl();
//	@Test
//	public void testLogin(){//可用
//		User user = userService.login("admin", "admin");
//		System.out.println(user.getUsername()+":"+user.getPword());
////	}
//	@Test
//	public void testGetAllClients() throws SQLException{//可用
//		PageService pageService = new PageService();
//		pageService.setNowPage(1);
//		String name = "%%";
//		List<Client> list = hotelDao.getAllClients(name,pageService);
//		System.out.println(list);
//	}
//	@Test
//	public void testAddClient(){//可用
//		Client client = new Client();
//		client.setNumberid("A50");
//		client.setName("555");
//		client.setSex("男");
//		client.setVipgrade("A");
//		client.setPhone("1234567920");
//		client.setIndate("2017-11-11");
//		client.setOutdate("2017-12-12");
//		hotelDao.addClient(client);
//	}
	@Test
	public void testUpdateClient() throws SQLException{//可用
		Client client = new Client();
		client.setNumberid("B12");
		client.setName("五四六");
		client.setSex("男");
		client.setVipgrade("A");
		client.setPhone("1472583690");
		hotelDao.updateClient(client);
	}
//	@Test
//	public void testdelsClients(){//可用
//		String[] ids={"12","13"};
//		int x=hotelDao.delsClients(ids);
//		System.out.println(x);
//	}
	@Test
	public void testfindUserById(){//可行
		Client client = new Client();
		client = hotelDao.findUserById(4);
		System.out.println(client.getNumberid());
	}
	
}
