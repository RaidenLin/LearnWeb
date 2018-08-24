package com.Raiblue.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Raiblue.hoteldao.HotelDao;
import com.Raiblue.hoteldao.impl.HotelDaoImpl;
import com.Raiblue.pojo.User;
import com.Raiblue.service.UserService;
import com.Raiblue.util.DBConnection;

public class UserServiceImpl implements UserService {
	HotelDao hotelDao = new HotelDaoImpl();
	public User login(String name,String pwd){
		
		return hotelDao.login(name, pwd);
	}
}
