package com.qhit.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.bean.User;

public class loginAction extends ActionSupport{
	private User user;
	public String login(){
		if(user.getUsername().equals("admin")&&user.getPassword().equals(123456)){
			ActionContext.getContext().getSession().put("user",user);
			return SUCCESS;
		}
		addActionError("�û�����������µ�¼");
		return INPUT;
		
	}
	public void validate(){
		System.out.println(user);
		if(user==null){
			addFieldError("login.formInput","�û������벻��Ϊ��");	
		}else if(user.getUsername()==null||user.getUsername().length()<5){
			addFieldError("login.username","�û�������Ϊ���ҳ��Ȳ���С����");
		}else if(user.getPassword()==null||user.getPassword().length()<5){
			addFieldError("login.possword", "�û�������Ϊ���ҳ��Ȳ���С��5");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
