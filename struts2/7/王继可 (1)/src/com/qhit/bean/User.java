package com.qhit.bean;

public class User {
private int uid;
private String name;
private String pic;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
public User(int uid, String name, String pic) {

	this.uid = uid;
	this.name = name;
	this.pic = pic;
}
@Override
public String toString() {
	return "User [uid=" + uid + ", name=" + name + ", pic=" + pic + "]";
}
public User() {

}
public User(String name, String pic) {

	this.name = name;
	this.pic = pic;
}

}
