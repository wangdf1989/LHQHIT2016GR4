package zk.com.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import zk.com.user.bean.User;
import zk.com.user.service.UserService;

public class UserAction extends ActionSupport {
	private UserService us = new UserService();
	private User user;
   public String login(){
	   user = us.bylogin(user);
	   if(user!=null){
		   ActionContext.getContext().getSession().put("user", user);
		   return SUCCESS;
	   }else{
		 addActionError("�û����������벻����");
		   return INPUT;
	   }
   }
   @Override
   public void validate() {
     if(user==null){
    	 addFieldError("login.forminput", "Ϊ��д�û�����������");
     }else if(user.getUsername()==null||user.getUsername().length()<6){
    	 addFieldError("login.username", "�û���������д���ҳ��ȴ���6");
     }else if(user.getPassword()==null||user.getPassword().length()<8){
        addFieldError("login.password", "���������д���ҳ��ȴ���8");
     }
   
   }
   
   
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
  
}
