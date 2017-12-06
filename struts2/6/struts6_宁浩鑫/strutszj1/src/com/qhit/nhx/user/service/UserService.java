package com.qhit.nhx.user.service;

import com.qhit.nhx.user.bean.User;
import com.qhit.nhx.user.dao.UserDao;

public class UserService {
	private UserDao ud = new UserDao();
	public User login(User user){
		return ud.getUserForLogin(user);
	}

}
