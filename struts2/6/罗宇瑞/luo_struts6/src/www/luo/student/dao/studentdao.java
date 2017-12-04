package www.luo.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import www.luo.common.util.DButils;
import www.luo.student.bean.student;


public class studentdao {
	//查询所有
	public List<student> getall(){
		String sql = "select * from t_student";
		Connection con = DButils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<student> list = new ArrayList<student>();
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
				String telephone = rs.getString("phone");
				student st = new student(sid, name, sex, birthday, major, classes, telephone);
				list.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				DButils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	//根据id
	public student getstudentid(int sid){
		String sql = "select * from t_student where sid = ?";
		Connection con = DButils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		student st = null;
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
				String telephone = rs.getString("phone");
				st = new student(sid, name, sex, birthday, major, classes, telephone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				DButils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return st;
	}
	//增
	public int addstudent(student st){
		String sql = "insert into t_student values(?,?,?,?,?,?)";
		Connection con = DButils.getConnection();
		PreparedStatement ps = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, st.getName());
			ps.setString(2, st.getSex());
			ps.setDate(3, new java.sql.Date(st.getBirthday().getTime()));
			ps.setString(4, st.getMajor());
			ps.setString(5, st.getClasses());
			ps.setString(6, st.getTelephone());
			count = ps.executeUpdate();
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
	//删
	public int delstudent(int sid){
		String sql = "delete from t_student where sid=?";
		Connection con = DButils.getConnection();
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
				DButils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	//改
	public int updstudent(student st){
		String sql = "update t_student set name=?,sex=?,birthday=?,major=?,class=?,phone=? where sid=?";
		Connection con = DButils.getConnection();
		PreparedStatement ps = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, st.getName());
			ps.setString(2, st.getSex());
			ps.setDate(3, new java.sql.Date(st.getBirthday().getTime()));
			ps.setString(4, st.getMajor());
			ps.setString(5, st.getClasses());
			ps.setString(6, st.getTelephone());
			ps.setInt(7, st.getSid());
			count = ps.executeUpdate();
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
