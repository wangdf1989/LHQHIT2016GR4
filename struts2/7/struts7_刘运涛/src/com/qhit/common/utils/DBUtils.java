package com.qhit.common.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接
 * @author Administrator
 *
 */
public class DBUtils {
	//创建连接
    public static Connection getCon(){
    	String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=xsgl";
        String user="sa";
        String password="sa";
    	Connection con=null;
    	try {
			  Class.forName(className);
			  con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return con;	
    } 
   //关闭连接
   public static void closeCon(Connection con){
	    if(con!=null){
	    	try {
				 con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
   } 
} 

