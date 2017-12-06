package com.qhit.Student.servcie;

import java.util.List;

import com.qhit.Student.bean.BenaStudent;
import com.qhit.Student.dao.StudentDao;

public class StudentService {
private StudentDao sd = new StudentDao();
	
	public List<BenaStudent> selAllStudents(){
		return sd.getAllStudents();
	}
	public BenaStudent preUpdStudent(int sid){
		return sd.getStudentById(sid);
	}
	public int addStudent(BenaStudent student){
		return sd.addStudent(student);
	}
	public int delStudent(int sid){
		return sd.delStudent(sid);
	}
	public int updStudent(BenaStudent student){
		return sd.updStudent(student);
	}
}
