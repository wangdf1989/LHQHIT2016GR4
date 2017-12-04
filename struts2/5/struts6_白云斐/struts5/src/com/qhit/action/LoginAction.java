package com.qhit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.bean.User;

public class LoginAction  extends ActionSupport{
	private User user;
	public String login(){
		if(user.getUsername().equals("admin")&&user.getPassword().equals("123456")){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		addActionError("用户名密码错误，请重新登陆");
		return INPUT;
	}

	@Override
	public void validate() {
		System.out.println(user);
		if(user==null){
			addFieldError("login.formInput", "未填写用户名或者密码");
		}else if(user.getUsername()==null||user.getUsername().length()<5){
			addFieldError("login.username", "用户名必须填写，长度大于5");
		}else if(user.getPassword()==null||user.getPassword().length()<8){
			addFieldError("login.password", "密码必须填写， 长度大于8");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
