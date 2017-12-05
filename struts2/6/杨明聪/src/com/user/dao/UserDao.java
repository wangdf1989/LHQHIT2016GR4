package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.common.util.DBUtils;
import com.user.bean.User;

public class UserDao {
	/**
	 * 根据用户名和密码查询
	 * @param user
	 * @return
	 */
	public User getUserForLogin(User user){
		String sql = "select * from t_user where username=? and password=?";
		Connection con = DBUtils.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			while(rs!=null&&rs.next()){
				int uid = rs.getInt("uid");
				String username = rs.getString("username");
				String password = rs.getString("password");
				u = new User(uid, username, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}
}
