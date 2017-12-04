package www.luo.student.service;

import java.util.List;

import www.luo.student.bean.student;
import www.luo.student.dao.studentdao;

public class studentservice {
	private studentdao sd = new studentdao();
	public List<student> selall(){
		return sd.getall();
	}
	public student preupd(int sid){
		return sd.getstudentid(sid);
	}
	public int addstudent(student st){
		return sd.addstudent(st);
	}
	public int delstudent(int sid){
		return sd.delstudent(sid);
	}
	public int updstudent(student st){
		return sd.updstudent(st);
	}
}
