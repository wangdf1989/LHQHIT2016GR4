package zk.com.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
  public static Connection getConnection(){
	   Connection con = null;
	   String url="jdbc:sqlserver://localhost:1433;DatabaseName=xsgl";
	   String user="sa";
	   String password="123456";
	  try {
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 con= DriverManager.getConnection(url, user, password);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return con;
  }
  public static void closeCon(Connection con){
        if(con!=null){
        	 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }	  
  }
}
