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
			addActionError("�û���������������µ�½");
			return INPUT;
		}
	}
	@Override
	public void validate() {
		if(user==null){
			addFieldError("login.formInput", "δ��д�û���������");
		}else if(user.getUsername()==null||user.getUsername().length()<8){
			addFieldError("login.username", "�û����������8λ");
		}else if(user.getPassword()==null||user.getPassword().length()<6){
			addFieldError("login.password", "����������6λ");
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
