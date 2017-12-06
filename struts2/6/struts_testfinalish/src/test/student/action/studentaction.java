package test.student.action;

import java.util.List;

import test.student.servise.studentservise;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import test.student.bean.student;
public class studentaction extends ActionSupport {

	private studentservise ss = new studentservise();
	private List<student> list;
	private String message;
	private int sid;
	private student student;
	
	public String selAllStudent(){
		list = ss.selAllStudents();
		return SUCCESS;
	}
	public String del(){
		int count = ss.delStudent(sid);
		if(count == 0){
			message = "删除失败，请稍后重试！";
		}
		return "all";
	}
	public String upd(){
		int count = ss.updStudent(student);
		if(count==0){
			message = "更新失败，请稍后重试！";
			return INPUT;
		}
		return "all";
	}
	public String add(){
		int count = ss.addStudent(student);
		if(count==0){
			message = "添加失败，请稍后重试！";
			return INPUT;
		}
		return "all";
	}
	public String preUpd(){
		student = ss.preUpdStudent(sid);
		if(student == null){
			message = "修改失败，请稍后重试！";
			return "all";
		}
		return INPUT;
	}
	
	public studentservise getSs() {
		return ss;
	}
	public void setSs(studentservise ss) {
		this.ss = ss;
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
