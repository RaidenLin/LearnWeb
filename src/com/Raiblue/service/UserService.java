package com.Raiblue.service;

import java.util.List;

import com.Raiblue.pojo.Client;
import com.Raiblue.pojo.PageService;
import com.Raiblue.pojo.User;

public interface UserService {
	public User login(String name,String pwd);//用户登录
}
