package com.qhit.User.service;

import com.qhit.User.bean.User;
import com.qhit.User.dao.UserDao;

public class Userservice {
	UserDao dd=new UserDao();
public User login(User user){
	return dd.getUserForLogin(user);
}
}
