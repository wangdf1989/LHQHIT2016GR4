package com.qhit.service;

import com.qhit.bean.User;
import com.qhit.dao.DaoUser;

public class UserService {
	private DaoUser dao=new DaoUser();
	public int add(User user){
		return  dao.addUser(user);
	}
	

}
