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
		addActionError("�û���������������µ�½");
		return INPUT;
	}

	@Override
	public void validate() {
		System.out.println(user);
		if(user==null){
			addFieldError("login.formInput", "δ��д�û�����������");
		}else if(user.getUsername()==null||user.getUsername().length()<5){
			addFieldError("login.username", "�û���������д�����ȴ���4");
		}else if(user.getPassword()==null||user.getPassword().length()<8){
			addFieldError("login.password", "���������д�� ���ȴ���9");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
