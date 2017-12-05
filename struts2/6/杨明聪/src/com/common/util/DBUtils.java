package com.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库工具类
 * @author 贾洪一
 *
 */
public class DBUtils {
	/**
	 * 创建链接
	 * @return
	 */
	public static Connection getCon(){
		String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=xsgl";
		String username = "sa";
		String password = "123456";
		Connection con = null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		
	}
	/**
	 * 关闭连接
	 * @param con
	 */
	public static void closeCon(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	public static void main(String[] args) {
		System.out.println(DBUtils.getCon());
	}
}
