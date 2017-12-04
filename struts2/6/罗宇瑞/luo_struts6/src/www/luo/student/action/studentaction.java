package www.luo.student.action;

import java.util.List;

import org.omg.PortableInterceptor.SUCCESSFUL;

import com.opensymphony.xwork2.ActionSupport;

import www.luo.student.bean.student;
import www.luo.student.service.studentservice;

public class studentaction extends ActionSupport{
	private studentservice ss = new studentservice();
	private List<student> list;
	private String message;
	private int sid;
	private student student;
	
	public String heheall(){
		list = ss.selall();
		return SUCCESS;
	}
	public String del(){
		int count = ss.delstudent(sid);
		if(count == 0){
			super.addActionMessage("删除失败");
		}
		return "all";
	}
	public String upd(){
		int count = ss.updstudent(student);
		if(count==0){
			super.addActionMessage("更新失败");
			return INPUT;
		}
		return "all";
	}
	public String add(){
		int count = ss.addstudent(student);
		if(count==0){
			super.addActionMessage("添加失败");
			return INPUT;
		}
		return "all";
	}
	public String preupd(){
		student = ss.preupd(sid);
		if(student == null){
			super.addActionMessage("修改失败");
			return "all";
		}
		return INPUT;
	}
	public List<student> getList() {
		return list;
	}
	public void setList(List<student> list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public student getStudent() {
		return student;
	}
	public void setStudent(student student) {
		this.student = student;
	}
	
}
