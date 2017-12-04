package zk.com.user.service;

import zk.com.user.bean.User;
import zk.com.user.dao.UserDao;

public class UserService {
	private UserDao ud = new UserDao();
  public User bylogin(User user){
	  return ud.getlogin(user);
  }
}
