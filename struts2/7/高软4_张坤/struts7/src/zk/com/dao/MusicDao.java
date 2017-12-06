package zk.com.dao;

import zk.com.bean.Music;
import zk.com.common.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MusicDao {
 public int addmusic(Music music){
	 String sql="insert into t_music values(?,?)";
	 Connection con = DButils.getConnection();
	 PreparedStatement ps = null;
	 int count=0;
	 try {
		ps=con.prepareStatement(sql);
		ps.setString(1, music.getName());
		ps.setString(2, music.getUpload());
		count=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			ps.close();
			DButils.closeCon(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 return count;
 }
}
