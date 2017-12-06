package project.user.action;

import project.user.bean.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private User user;
	public String login(){
		if(user.getUsername().equals("����")&&user.getPassword().equals("123456")){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		addActionError("�û������벻��ȷ��");
		return INPUT;
	}
	@Override
	public void validate() {
		System.out.println(user);
		if(user==null){
			addFieldError("login.formInput", "δ��д�û�����������");
		}else if(user.getUsername()==null||user.getUsername().length()<2){
			addFieldError("login.username", "�û���������д�����ȴ���2");
		}else if(user.getPassword()==null||user.getPassword().length()<6){
			addFieldError("login.password", "���������д�� ���ȴ���6");
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
