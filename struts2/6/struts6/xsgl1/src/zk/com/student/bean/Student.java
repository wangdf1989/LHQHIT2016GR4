package zk.com.student.bean;

public class Student {
private int sid;
private String name;
private String sex;
private String birthdate;
private String major;
private String classs;
private String telephone;
public Student(int sid, String name, String sex, String birthdate, String major, String classs, String telephone) {
	super();
	this.sid = sid;
	this.name = name;
	this.sex = sex;
	this.birthdate = birthdate;
	this.major = major;
	this.classs = classs;
	this.telephone = telephone;
}
public Student() {
}
public Student(String name, String sex, String birthdate, String major, String classs, String telephone) {
	this.name = name;
	this.sex = sex;
	this.birthdate = birthdate;
	this.major = major;
	this.classs = classs;
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
public String getBirthdate() {
	return birthdate;
}
public void setBirthdate(String birthdate) {
	this.birthdate = birthdate;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public String getClasss() {
	return classs;
}
public void setClasss(String classs) {
	this.classs = classs;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", name=" + name + ", sex=" + sex + ", birthdate=" + birthdate + ", major=" + major
			+ ", classs=" + classs + ", telephone=" + telephone + "]";
}

}
