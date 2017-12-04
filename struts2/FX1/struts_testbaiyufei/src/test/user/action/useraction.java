package test.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import test.user.servise.userservise;
import test.user.bean.user;
public class useraction extends ActionSupport{
userservise u = new userservise(); 
user user = new user();	
private String message;
public String login(){
	user = u.login(user);
	if(user!=null){
		ActionContext.getContext().getSession().put("user", user);
		return SUCCESS;
	}else{
		message = "用户名或密码有误，请重新登陆";
		return INPUT;
	}
}
public user getUser() {
	return user;
}
public void setUser(user user) {
	this.user = user;
}
public String getMessage() {
	return message;
}
}
