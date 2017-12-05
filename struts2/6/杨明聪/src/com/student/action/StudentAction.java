package com.student.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.student.bean.Student;
import com.student.service.StudentService;

public class StudentAction extends ActionSupport {
	private StudentService ss = new StudentService();
	private List<Student> list;
	private String message;
	private int sid;
	private Student student;
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
	public List<Student> getList() {
		return list;
	}
	public String getMessage() {
		return message;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Student getStudent() {
		return student;
	}
	
}
