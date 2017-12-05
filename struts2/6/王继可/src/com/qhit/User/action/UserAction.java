package com.qhit.User.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.User.bean.User;
import com.qhit.User.service.Userservice;

public class UserAction extends ActionSupport {
	/**
	 * 
	 */

	private Userservice us = new Userservice();
	private User user;

		public String login(){
			user=us.login(user);
			System.out.print(user);
			if(us!=null){
				ActionContext.getContext().getSession().put("user", user);
				return SUCCESS;
			}else{
			
				return INPUT;
			}
		}
		
		
		public void validate() {
			System.out.println(user);
			if(user==null){
				addFieldError("login.formInput", "未填写用户名或者密码");
			}else if(user.getUsername()==null||user.getUsername().length()<1){
				addFieldError("login.username", "用户名必须填写，长度大于5");
			}else if(user.getPassword()==null||user.getPassword().length()<2){
				addFieldError("login.password", "密码必须填写， 长度大于8");
			}
		}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
