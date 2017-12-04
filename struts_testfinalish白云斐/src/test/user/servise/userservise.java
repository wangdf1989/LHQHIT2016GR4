package test.user.servise;

import test.user.bean.user;
import test.user.dao.userdao;

public class userservise {
userdao u = new userdao();
public  user login(user user){
	return u.getuserforlogin(user);
	
}
}
