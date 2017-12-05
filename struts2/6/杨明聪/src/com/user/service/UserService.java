package com.user.service;

import com.user.bean.User;
import com.user.dao.UserDao;

public class UserService {
	private UserDao ud = new UserDao();
	public User  login(User user){
		return ud.getUserForLogin(user);
	}
}
