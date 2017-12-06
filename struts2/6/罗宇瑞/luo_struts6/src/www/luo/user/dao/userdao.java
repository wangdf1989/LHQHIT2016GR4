package www.luo.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import www.luo.common.util.DButils;
import www.luo.user.bean.user;

public class userdao {
	public user getlogin(user us){
		String sql = "select * from t_user where username=? and password=?";
		Connection con = DButils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		user u = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, us.getUsername());
			ps.setString(2, us.getPassword());
			rs = ps.executeQuery();
			while(rs!=null&&rs.next()){
				int uid = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				u = new user(uid, username, password);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			rs.close();
			ps.close();
			DButils.closeCon(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
}
