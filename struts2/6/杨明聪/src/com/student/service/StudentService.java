package com.student.service;

import java.util.List;

import com.student.bean.Student;
import com.student.dao.StudentDao;

public class StudentService {
	private StudentDao sd = new StudentDao();
	
	public List<Student> selAllStudents(){
		return sd.getAllStudents();
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
