package com.qhit.Student.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.Student.bean.BenaStudent;
import com.qhit.Student.servcie.StudentService;

public class StudentAction extends ActionSupport{
	private StudentService ss = new StudentService();
	private List<BenaStudent> list;
	private String message;
	private int sid;
	private BenaStudent student;
	public String selAllStudent(){
		list = ss.selAllStudents();
		return SUCCESS;
	}
	public String del(){
		int count = ss.delStudent(sid);
		if(count == 0){
			message = "É¾³ıÊ§°Ü£¬ÇëÉÔºóÖØÊÔ£¡";
		}
		return "all";
	}
	public String upd(){
		int count = ss.updStudent(student);
		if(count==0){
			message = "¸üĞÂÊ§°Ü£¬ÇëÉÔºóÖØÊÔ£¡";
			return INPUT;
		}
		return "all";
	}
	public String add(){
		int count = ss.addStudent(student);
		if(count==0){
			message = "Ìí¼ÓÊ§°Ü£¬ÇëÉÔºóÖØÊÔ£¡";
			return INPUT;
		}
		return "all";
	}
	public String preUpd(){
		student = ss.preUpdStudent(sid);
		if(student == null){
			message = "ĞŞ¸ÄÊ§°Ü£¬ÇëÉÔºóÖØÊÔ£¡";
			return "all";
		}
		return INPUT;
	}
	public List<BenaStudent> getList() {
		return list;
	}
	public String getMessage() {
		return message;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setStudent(BenaStudent student) {
		this.student = student;
	}
	public BenaStudent getStudent() {
		return student;
	}
	
	
}

