package com.qhit.nhx.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.nhx.user.bean.User;
import com.qhit.nhx.user.service.UserService;

public class UserAction extends ActionSupport {
	private UserService us = new UserService();
	private User user;
	private String message;
	public String login(){
		user = us.login(user);
		if(user!=null){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}else{
			addActionError("�û����������д��������µ�¼��");
			return INPUT;
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	@Override
	public void validate() {
		if(user==null){
			addFieldError("login.formInput","δ��д�û����������룡");
		}else if(user.getUsername()==null||user.getUsername().length()<5){
			addFieldError("login.username","�û������ȱ�������壡");
		}else if(user.getPassword()==null||user.getPassword().length()<5){
			addFieldError("login.password","�û����볤�ȱ�������壡");
		}
	}
	

}
