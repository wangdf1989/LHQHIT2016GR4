package com.qhit.User.bean;

public class User {
private  int sid;
private String username;
private String password;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User(int sid, String username, String password) {
	
	this.sid = sid;
	this.username = username;
	this.password = password;
}
@Override
public String toString() {
	return "User [sid=" + sid + ", username=" + username + ", password="
			+ password + "]";
}
public User() {
	
}


}
