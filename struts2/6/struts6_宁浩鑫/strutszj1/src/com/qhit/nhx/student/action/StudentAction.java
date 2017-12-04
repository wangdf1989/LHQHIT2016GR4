package com.qhit.nhx.student.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.nhx.student.bean.Student;
import com.qhit.nhx.student.service.StudentService;

public class StudentAction extends ActionSupport {
	private StudentService ss = new StudentService();
	private List<Student> list;
	private String message;
	private int sid;
	private Student student;
	public String selAllStudents(){
		list = ss.selAllStudent();
		return SUCCESS;
	}
	public String del(){
		int count = ss.delStudent(sid);
		if(count==1){
			message="É¾³ıÊ§°Ü£¬ÇëÉÔºóÖØÊÔ£¡";
		}
		return "all";
	}
	public String upd(){
		int count = ss.updStudent(student);
		if(count==0){
			message="¸üĞÂÊ§°Ü£¬ÇëÉÔºóÖØÊÔ£¡";
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
		if(student==null){
			message = "ĞŞ¸ÄÊ§°Ü£¬ÇëÉÔºóÖØÊÔ£¡";
			return "all";
		}
		return INPUT;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getMessage() {
		return message;
	}
	public List<Student> getList() {
		return list;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

}
