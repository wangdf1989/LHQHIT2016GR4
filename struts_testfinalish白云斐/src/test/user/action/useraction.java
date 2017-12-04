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
public void validate(){
	if (user==null){
		addFieldError("login.fromInput", "未填写用户名！");
	}else if(user.getUsername()==null||user.getUsername().length()<5){
		addFieldError("login.fromInput", "用户名的长度要大于五！");
	} else if(user.getPassword()==null||user.getPassword().length()<5){
		addFieldError("login.fromInput", "密码不能为空！且长度要大于五！");
	}
	
	
}
/**public String exit(){
	ActionContext.getContext().getSession().remove(user);
	return NONE ;
	
}*/
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
