package com.Raiblue.hoteldao.impl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Raiblue.hoteldao.HotelDao;
import com.Raiblue.pojo.Client;
import com.Raiblue.pojo.PageService;
import com.Raiblue.pojo.User;
import com.Raiblue.util.DBConnection;
public class HotelDaoImpl implements HotelDao {
	DBConnection dbConnection = new DBConnection();
	Connection conn = dbConnection.getConnection();
	private Statement st;
	private ResultSet rSet;
	private PreparedStatement ps;
	public User login(String name,String pwd){
		String sql = "select username, pword from adminoruser where username = ? and pword = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rSet = ps.executeQuery();
			User user = new User();
			while(rSet.next()){
				user.setUsername(rSet.getString(1));
				user.setPword(rSet.getString(2));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Client> getAllClients(String name, PageService pageService) {
		String sql = "select ID, number,name,sex,vipGrade,phone,inDate,outDate from member where name like ? limit ?,?";
		List<Client> list = new ArrayList<Client>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, pageService.getOffSet());
			ps.setInt(3, pageService.getPageSize());
			rSet = ps.executeQuery();
			while(rSet.next()){
				Client client = new Client();
				client.setID(rSet.getInt(1));
				client.setNumberid(rSet.getString(2));
				client.setName(rSet.getString(3));
				client.setSex(rSet.getString(4));
				client.setVipgrade(rSet.getString(5));
				client.setPhone(rSet.getString(6));
				client.setIndate(rSet.getString(7));
				client.setOutdate(rSet.getString(8));
				list.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void addClient(Client client){
		String sql = "insert into member (number,name,sex,vipGrade,phone,inDate,outDate) values(?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, client.getNumberid());
			ps.setString(2, client.getName());
			ps.setString(3, client.getSex());
			ps.setString(4, client.getVipgrade());
			ps.setString(5, client.getPhone());
			ps.setString(6, client.getIndate());
			ps.setString(7, client.getOutdate());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateClient(Client client) {
		String sql = "update member set name = ?, sex = ?, vipGrade = ?, phone = ?, inDate = ?, outDate = ? where number = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, client.getName());
			ps.setString(2, client.getSex());
			ps.setString(3, client.getVipgrade());
			ps.setString(4, client.getPhone());
			ps.setString(5, client.getIndate());
			ps.setString(6, client.getOutdate());
			ps.setString(7, client.getNumberid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getCount(String name){
		int count = 0;
		String sql = "select COUNT(*) from member where name like ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rSet = ps.executeQuery();
			while(rSet.next()){
				count = rSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int delsClients(String[] ids){
		String sql = "delete from member where ID = ?";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
				ps.setInt(1, Integer.parseInt(ids[i]));
				ps.addBatch();
			}
			int[] result = ps.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
			return result.length;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	public Client findUserById(int id){
		String sqlString = "select ID,number,name,sex,vipGrade,phone,inDate,outDate from member where ID = ?";
		try {
			ps = conn.prepareStatement(sqlString);
			ps.setInt(1, id);
			rSet = ps.executeQuery();
			Client client = new Client();
			while(rSet.next()){
				client.setID(rSet.getInt(1));
				client.setNumberid(rSet.getString(2));
				client.setName(rSet.getString(3));
				client.setSex(rSet.getString(4));
				client.setVipgrade(rSet.getString(5));
				client.setPhone(rSet.getString(6));
				client.setIndate(rSet.getString(7));
				client.setOutdate(rSet.getString(8));
			}
			return client;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
