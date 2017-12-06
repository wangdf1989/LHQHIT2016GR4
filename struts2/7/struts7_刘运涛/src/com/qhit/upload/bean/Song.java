package com.qhit.upload.bean;

public class Song {
      private int sid;
      private String name;
      private String path;
	public Song() {
		
	}
	public Song(String name, String path) {
		this.name = name;
		this.path = path;
	}
	public Song(int sid, String name, String path) {
		this.sid = sid;
		this.name = name;
		this.path = path;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Song [sid=" + sid + ", name=" + name + ", path=" + path + "]";
	}
	
}
