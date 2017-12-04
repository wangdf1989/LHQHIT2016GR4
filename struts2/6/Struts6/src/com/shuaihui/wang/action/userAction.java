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
		addActionError("用户名密码错误，请重新登陆");
		return INPUT;
	}

	@Override
	public void validate() {
		if(user==null){
			addFieldError("login.forms", "未填写用户名或者密码");
		}else if(user.getUsername()==null||user.getUsername().length()<2){
			addFieldError("login.username", "用户名不符合规则，长度必须大于2");
		}else if(user.getPassword()==null||user.getPassword().length()<2){
			addFieldError("login.password", "密码不符合规则， 长度必须大于2");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
