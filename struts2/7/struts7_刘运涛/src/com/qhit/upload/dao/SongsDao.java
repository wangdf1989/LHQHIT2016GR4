package com.qhit.upload.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.common.utils.DBUtils;
import com.qhit.upload.bean.Song;

public class SongsDao {
	  /**
	   * 添加方法
	   * @param song
	   * @return
	   */
      public int addSong(Song song){
    	  String sql="insert into t_songs values(?,?)";
   	      Connection con=DBUtils.getCon();
   	      PreparedStatement ps=null;
   	      int i=0;
   	      try {
			   ps=con.prepareStatement(sql);
			   ps.setString(1,song.getName());
			   ps.setString(2,song.getPath());
			   i=ps.executeUpdate();
		  } catch (SQLException e) {
			e.printStackTrace();
		  }finally{
			   try {
				     ps.close();
				     DBUtils.closeCon(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
   	    return i;
     }
     /**
      * 更新方法 
      */
     public int updSongs(Song song){
    	  String sql="update t_songs set name=?,path=? where sid=?";
  	      Connection con=DBUtils.getCon();
  	      PreparedStatement ps=null;
  	      int i=0;
  	      try {
			   ps=con.prepareStatement(sql);
			   ps.setString(1,song.getName());
			   ps.setString(2,song.getPath());
			   ps.setInt(3,song.getSid());
			   i=ps.executeUpdate();
		  } catch (SQLException e) {
			e.printStackTrace();
		  }finally{
			   try {
				     ps.close();
				     DBUtils.closeCon(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
  	    return i;
     }
     /**
      * 根据歌曲名字查询路径 
      */
     public Song selPathForName(String name){
       	  String sql="select * from t_songs where name=?";
     	  Connection con=DBUtils.getCon();
     	  PreparedStatement ps=null;
     	  ResultSet rs=null;
     	  Song song=null;
     	  try {
			   ps=con.prepareStatement(sql);
			   ps.setString(1,name);
			   rs=ps.executeQuery();
			   while(rs!=null && rs.next()){
				    int sid=rs.getInt("sid");
				    String path=rs.getString("path");
				    song=new Song(sid, name, path);
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			   try {
				     rs.close();
				     ps.close();
				     DBUtils.closeCon(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
           return song;
     }
     /**
      * 根据iD查
      * @param name
      * @return
      */
     public Song selPathForId(int sid){
      	  String sql="select * from t_songs where sid=?";
    	  Connection con=DBUtils.getCon();
    	  PreparedStatement ps=null;
    	  ResultSet rs=null;
    	  Song song=null;
    	  try {
			   ps=con.prepareStatement(sql);
			   ps.setInt(1,sid);
			   rs=ps.executeQuery();
			   while(rs!=null && rs.next()){
				    String name=rs.getString("sid");
				    String path=rs.getString("path");
				    song=new Song(sid, name, path);
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			   try {
				     rs.close();
				     ps.close();
				     DBUtils.closeCon(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
          return song;
    }
     /**
      * 查询所有
      * 
      */
     public List<Song> selAllSong(){
    	  String sql="select * from t_songs";
    	  Connection con=DBUtils.getCon();
    	  PreparedStatement ps=null;
    	  ResultSet rs=null;
    	  List<Song> list=new ArrayList<Song>();
    	  Song song=null;
    	  try {
			   ps=con.prepareStatement(sql);
			   rs=ps.executeQuery();
			   while(rs!=null && rs.next()){
				    int sid=rs.getInt("sid");
				    String name=rs.getString("name");
				    String path=rs.getString("path");
				    song=new Song(sid, name, path);
				    list.add(song);
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			   try {
				     rs.close();
				     ps.close();
				     DBUtils.closeCon(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
          return list;
     }
}
