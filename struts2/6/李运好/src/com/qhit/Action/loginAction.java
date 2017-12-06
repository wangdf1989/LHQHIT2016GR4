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
		addActionError("用户密码错误，重新登录");
		return INPUT;
		
	}
	public void validate(){
		System.out.println(user);
		if(user==null){
			addFieldError("login.formInput","用户名密码不能为空");	
		}else if(user.getUsername()==null||user.getUsername().length()<5){
			addFieldError("login.username","用户名不能为空且长度不能小于五");
		}else if(user.getPassword()==null||user.getPassword().length()<5){
			addFieldError("login.possword", "用户名不能为空且长度不能小于5");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
