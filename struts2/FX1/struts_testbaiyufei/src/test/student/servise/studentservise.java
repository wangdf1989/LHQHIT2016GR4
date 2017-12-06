package test.student.servise;

import java.util.List;

import test.student.bean.student;
import test.student.dao.studentdao;

public class studentservise {
	private studentdao sd = new studentdao();
	
	public List<student> selAllStudents(){
		return sd.getAllStudents();
	}
	public student preUpdStudent(int sid){
		return sd.getStudentById(sid);
	}
	public int addStudent(student student){
		return sd.addStudent(student);
	}
	public int delStudent(int sid){
		return sd.delStudent(sid);
	}
	public int updStudent(student student){
		return sd.updStudent(student);
	}
}
