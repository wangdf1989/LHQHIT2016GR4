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
    		addActionError("�û������������!");
    		return INPUT;
    	}
    }
    
    public void validate() {
    	if(user==null){
    		addFieldError("login.info", "�û����������������!");
    	}else if(user.getUsername()==null || user.getUsername().length()<6){
    		addFieldError("login.username", "�û�������������λ��!"); 
    	}else if(user.getPassword()==null || user.getPassword().length()<4){
    		addFieldError("login.password", "���벻��������λ��!");
    	}
    	
    } 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
      
      
}
