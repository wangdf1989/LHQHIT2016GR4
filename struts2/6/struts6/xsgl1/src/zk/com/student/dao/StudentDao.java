package zk.com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zk.com.common.util.DButil;
import zk.com.student.bean.Student;
import zk.com.user.bean.User;

public class StudentDao {
	 public int add(Student student){
		 String sql="insert into t_student values(?,?,?,?,?,?)";
		 Connection con = DButil.getConnection();
		 PreparedStatement ps = null;
		 int count = 0;
		 try {
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getSex());	
			ps.setString(3, student.getBirthdate());
			ps.setString(4, student.getMajor());
			ps.setString(5, student.getClasss());
			ps.setString(6, student.getTelephone());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DButil.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 return count;
	 }
	 public int upd(Student student){
		 String sql="update t_student set name=? ,sex=?,birthdate=?,major=?,classs=?,telephone=? where sid=?";
		 Connection con = DButil.getConnection();
		 PreparedStatement ps = null;
		 int count = 0;
		 try {
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getSex());	
			ps.setString(3, student.getBirthdate());
			ps.setString(4, student.getMajor());
			ps.setString(5, student.getClasss());
			ps.setString(6, student.getTelephone());
			ps.setInt(7, student.getSid());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DButil.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 return count;
	 }
	 public int del(int sid){
		 String sql="delete from t_student where sid=?";
		 Connection con = DButil.getConnection();
		 PreparedStatement ps = null;
		 int count = 0;
		 try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sid);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DButil.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 return count;
	 }
	 public Student preupd(int sid){
		 String sql="select * from t_student where sid=?";
		 Connection con = DButil.getConnection();
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Student student = null;
		 try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sid);
			rs = ps.executeQuery();
			while(rs!=null&rs.next()){
				String name  = rs.getString("name");
				String sex = rs.getString("sex");
				String birthdate = rs.getString("birthdate");
				String major=rs.getString("major");
				String classs=rs.getString("classs");
				String telephone=rs.getString("telephone");
				student = new Student(sid, name, sex, birthdate, major, classs, telephone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				DButil.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 return student;
	 }
	 public List<Student> selall(){
		 String sql="select * from t_student ";
		 Connection con =DButil.getConnection();
		 PreparedStatement ps = null;
		 ResultSet rs = null;
	     List<Student> list = new ArrayList<Student>();
		 try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs!=null&rs.next()){
				int sid = rs.getInt("sid");
				String name  = rs.getString("name");
				String sex = rs.getString("sex");
				String birthdate = rs.getString("birthdate");
				String major=rs.getString("major");
				String classs=rs.getString("classs");
				String telephone=rs.getString("telephone");
			   Student student = new Student(sid, name, sex, birthdate, major, classs, telephone);
			   list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				DButil.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 return list;
	 }
}
