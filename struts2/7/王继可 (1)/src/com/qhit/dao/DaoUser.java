package com.qhit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qhit.DB.DBUtils;
import com.qhit.bean.User;

public class DaoUser {
public int addUser(User user){
	String sql = "insert into t_user values(?,?)";
	PreparedStatement ps = null;
	Connection con = DBUtils.getCon();
	int count = 0;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPic());
		
		count = ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		try {
			ps.close();
			DBUtils.closeCon(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return count;
}






}
