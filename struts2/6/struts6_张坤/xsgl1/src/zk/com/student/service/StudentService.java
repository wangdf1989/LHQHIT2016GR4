package zk.com.student.service;

import java.util.List;

import zk.com.student.bean.Student;
import zk.com.student.dao.StudentDao;

public class StudentService {
 private StudentDao sd = new StudentDao();
 public List<Student> all(){
	 return sd.selall();
 }
 public int add(Student student){
	 return sd.add(student);
 }
 public int del(int sid){
	 return sd.del(sid);
 }
 public Student pre(int sid){
	 return sd.preupd(sid);
 }
 public int upd(Student student){
	 return sd.upd(student);
 }
}
