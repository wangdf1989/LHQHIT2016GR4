package com.shuaihui.wang.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shuaihui.wang.bean.User;

public class userAction  extends ActionSupport{
	private User user;
	public String login(){
		if(user.getUsername().equals("tt")&&user.getPassword().equals("123")){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		addActionError("�û���������������µ�½");
		return INPUT;
	}

	@Override
	public void validate() {
		if(user==null){
			addFieldError("login.forms", "δ��д�û�����������");
		}else if(user.getUsername()==null||user.getUsername().length()<2){
			addFieldError("login.username", "�û��������Ϲ��򣬳��ȱ������2");
		}else if(user.getPassword()==null||user.getPassword().length()<2){
			addFieldError("login.password", "���벻���Ϲ��� ���ȱ������2");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
