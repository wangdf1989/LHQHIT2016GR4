package zk.com.bean;

public class Music {
	 private int id;
	 private String name;
	 private String upload;
	public Music(int id, String name, String upload) {
		this.id = id;
		this.name = name;
		this.upload = upload;
	}
	public Music() {
	}
	
	public Music(String name, String upload) {
		this.name = name;
		this.upload = upload;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	 
}
