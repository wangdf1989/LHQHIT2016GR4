package www.luo.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import www.luo.user.bean.user;
import www.luo.user.service.userservice;

public class useraction extends ActionSupport{
	private userservice us = new userservice();
	private user u;
	private String message;
	
	public String login(){
		u = us.login(u);
		System.out.println(u);
		if(u!=null){
			ActionContext.getContext().getSession().put("u", u);
			return SUCCESS;
		}else{
			 addActionError("账号或密码错误！");
			return INPUT;
		}
	}
	/*public void validate() {
		if(u==null){
			addFieldError("login.formInput", "鏈～鍐欑敤鎴峰悕鎴栬�呭瘑鐮�");
		}else if(u.getUsername()==null||u.getUsername().length()<1){
			addFieldError("login.username", "鐢ㄦ埛鍚嶅繀椤诲～鍐欙紝闀垮害澶т簬3");
		}else if(u.getPassword()==null||u.getPassword().length()<9){
			addFieldError("login.password", "瀵嗙爜蹇呴』濉啓锛� 闀垮害澶т簬9");
		}
	}*/
	public user getU() {
		return u;
	}
	public void setU(user u) {
		this.u = u;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
