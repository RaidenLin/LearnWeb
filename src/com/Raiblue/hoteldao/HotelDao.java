package com.Raiblue.hoteldao;

import java.sql.SQLException;
import java.util.List;

import com.Raiblue.pojo.Client;
import com.Raiblue.pojo.PageService;
import com.Raiblue.pojo.User;

public interface HotelDao {
	public User login(String name,String pwd);//登录
	public List<Client> getAllClients(String name, PageService pageService);//根据用户名字分页查询所有客户信息
	public Client findUserById(int id);//根据ID查询用户信息
	public void addClient(Client client);//添加用户信息
	public void updateClient(Client client);//根据ID修改用户信息
	public int getCount(String name);//查询此类名字的总记录数
	public int delsClients(String[] ids);//通过id批量删除用户信息
}
