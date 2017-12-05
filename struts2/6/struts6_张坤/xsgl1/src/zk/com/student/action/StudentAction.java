package zk.com.student.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import zk.com.student.bean.Student;
import zk.com.student.service.StudentService;

public class StudentAction extends ActionSupport{
private Student student;
private List<Student> list ;
private String message;
private int sid;
private StudentService ss = new StudentService();

public String add(){
	int count =ss.add(student);
	if(count==0){
		message="添加失败";
		return INPUT;
	}
	return "all";
}
public String del(){
	int count = ss.del(sid);
	if(count==0){
		message="删除失败，请重试";
	}
	return "all";
}
public String preupd(){
	student = ss.pre(sid);
	if(student==null){
		return "all";
	}
	 return INPUT;
}
public String upd(){
	int count =ss.upd(student);
	if(count==0){
		message="修改失败";
		return INPUT;
	}
	return "all";
}
public String selall(){
	list = ss.all();
	 return SUCCESS;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}
public List<Student> getList() {
	return list;
}
public String getMessage() {
	return message;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}

}
