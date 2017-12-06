package com.qhit.nhx.student.service;

import java.util.List;

import com.qhit.nhx.student.bean.Student;
import com.qhit.nhx.student.dao.StudentDao;

public class StudentService {
	private StudentDao sd = new StudentDao();
	public List<Student> selAllStudent(){
		return sd.getAllStudent();
	}
	public Student preUpdStudent(int sid){
		return sd.getStudentById(sid);
	}
	public int addStudent(Student student){
		return sd.addStudent(student);
	}
	public int delStudent(int sid){
		return sd.delStudent(sid);
	}
	public int updStudent(Student student){
		return sd.updStudent(student);
	}

}
