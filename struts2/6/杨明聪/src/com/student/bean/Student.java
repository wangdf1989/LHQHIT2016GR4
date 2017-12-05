package com.student.bean;

import java.util.Date;

public class Student {
	private int sid;
	private String name;
	private String sex;
	private Date birthday;
	private String major;
	private String classes;
	private String telephone;
	
	public Student(String name, String sex, Date birthday, String major,
			String classes, String telephone) {
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.major = major;
		this.classes = classes;
		this.telephone = telephone;
	}
	public Student() {
	}
	public Student(int sid, String name, String sex, Date birthday,
			String major, String classes, String telephone) {
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.major = major;
		this.classes = classes;
		this.telephone = telephone;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
