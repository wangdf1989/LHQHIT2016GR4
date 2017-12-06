package com.qhit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.bean.User;

public class LoginAction extends ActionSupport {
	  private User user;
    public String login(){
    	if(user.getUsername().equals("admin123") && user.getPassword().equals("123456")){
    		ActionContext.getContext().getSession().put("user", user);
    		return SUCCESS;
    	}else{
    		addActionError("用户名或密码错误!");
    		return INPUT;
    	}
    }
    
    public void validate() {
    	if(user==null){
    		addFieldError("login.info", "用户名或密码输入错误!");
    	}else if(user.getUsername()==null || user.getUsername().length()<6){
    		addFieldError("login.username", "用户名不得少于六位数!"); 
    	}else if(user.getPassword()==null || user.getPassword().length()<4){
    		addFieldError("login.password", "密码不得少于四位数!");
    	}
    	
    } 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
      
      
}
