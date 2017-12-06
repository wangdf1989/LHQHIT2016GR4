package www.luo.user.service;

import www.luo.user.bean.user;
import www.luo.user.dao.userdao;

public class userservice {
	private userdao ud = new userdao();
	public user  login(user us){
		return ud.getlogin(us);
	}
}
