package test.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import test.common.util.DButils;
import test.user.bean.user;

public class userdao {
public user  getuserforlogin(user user){
	String sql = "select * from t_user where username=? and password=?";
	Connection con = DButils.getCon();
	PreparedStatement ps = null;
	ResultSet rs = null;
	user u = null;
	 try {
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2,user.getPassword());
		rs=ps.executeQuery();
		while(rs!=null&&rs.next()){
			int uid=rs.getInt("uid");
			String username =rs.getString("username");
			String password= rs.getString("password");
			u=new user(uid, username, password);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}DButils.closeCon(con);
	}
	 
	return u;
	
} 
	
}
