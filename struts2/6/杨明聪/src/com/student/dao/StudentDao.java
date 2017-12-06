package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.common.util.DBUtils;
import com.student.bean.Student;

public class StudentDao {
	public List<Student> getAllStudents(){
		String sql = "select * from t_student";
		Connection con = DBUtils.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs!=null&&rs.next()){
				int sid = rs.getInt("sid");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String major = rs.getString("major");
				String classes = rs.getString("class");
				String telephone = rs.getString("telephone");
				Student student = new Student(sid, name, sex, birthday, major, classes, telephone);
				list.add(student);
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
		return list;
	}
	public Student getStudentById(int sid){
		String sql = "select * from t_student where sid = ?";
		Connection con = DBUtils.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sid);
			rs = ps.executeQuery();
			while(rs!=null&&rs.next()){
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String major = rs.getString("major");
				String classes = rs.getString("class");
				String telephone = rs.getString("telephone");
				student = new Student(sid, name, sex, birthday, major, classes, telephone);
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
		return student;
	}
	public int addStudent(Student student){
		String sql = "insert into t_student values(?,?,?,?,?,?)";
		Connection con = DBUtils.getCon();
		PreparedStatement ps = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getSex());
			ps.setDate(3, new java.sql.Date(student.getBirthday().getTime()));
			ps.setString(4, student.getMajor());
			ps.setString(5, student.getClasses());
			ps.setString(6, student.getTelephone());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	public int delStudent(int sid){
		String sql = "delete from t_student where sid=?";
		Connection con = DBUtils.getCon();
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
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public int updStudent(Student student){
		String sql = "update t_student set name=?,sex=?,birthday=?,major=?,class=?,telephone=? where sid=?";
		Connection con = DBUtils.getCon();
		PreparedStatement ps = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getSex());
			ps.setDate(3, new java.sql.Date(student.getBirthday().getTime()));
			ps.setString(4, student.getMajor());
			ps.setString(5, student.getClasses());
			ps.setString(6, student.getTelephone());
			ps.setInt(7, student.getSid());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
