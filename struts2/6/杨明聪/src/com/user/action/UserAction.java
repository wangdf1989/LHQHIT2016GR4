package com.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.user.bean.User;
import com.user.service.UserService;

public class UserAction extends ActionSupport {
	private UserService us = new UserService();
	private User user;
	public String login(){
		user = us.login(user);
		if(user!=null){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}else{
			addActionError("用户名密码错误，请重新登陆");
			return INPUT;
		}
	}
	@Override
	public void validate() {
		if(user==null){
			addFieldError("login.formInput", "未填写用户名或密码");
		}else if(user.getUsername()==null||user.getUsername().length()<8){
			addFieldError("login.username", "用户名必须大于8位");
		}else if(user.getPassword()==null||user.getPassword().length()<6){
			addFieldError("login.password", "密码必须大于6位");
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
