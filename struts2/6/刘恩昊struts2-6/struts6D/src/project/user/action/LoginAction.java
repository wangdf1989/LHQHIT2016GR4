package project.user.action;

import project.user.bean.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private User user;
	public String login(){
		if(user.getUsername().equals("赵云")&&user.getPassword().equals("123456")){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		addActionError("用户或密码不正确！");
		return INPUT;
	}
	@Override
	public void validate() {
		System.out.println(user);
		if(user==null){
			addFieldError("login.formInput", "未填写用户名或者密码");
		}else if(user.getUsername()==null||user.getUsername().length()<2){
			addFieldError("login.username", "用户名必须填写，长度大于2");
		}else if(user.getPassword()==null||user.getPassword().length()<6){
			addFieldError("login.password", "密码必须填写， 长度大于6");
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
