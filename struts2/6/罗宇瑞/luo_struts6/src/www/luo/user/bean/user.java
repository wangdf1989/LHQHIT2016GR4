package www.luo.user.bean;

public class user {
	private int uid ;
	private String username;
	private String password;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public user(int uid, String username, String password) {
		this.uid = uid;
		this.username = username;
		this.password = password;
	}
	public user() {
	}
	@Override
	public String toString() {
		return "user [uid=" + uid + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
