package com.hibernate.web.jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
 

public class JdbcConnect {

	    public static void main(String[] args)
	    throws ClassNotFoundException, SQLException
	{
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  //
	  // or
	  // DriverManager.registerDriver
	  //        (new oracle.jdbc.driver.OracleDriver());
	 
	      String url = "jdbc:oracle:thin:@mydb:1521:oracledb";
	       
	       
	  Connection conn =
	       DriverManager.getConnection(url,"username","password");
	 
	  conn.setAutoCommit(false);
	  Statement stmt = conn.createStatement();
	  ResultSet rset =
	       stmt.executeQuery("select * from emp");
	  while (rset.next()) {
	       System.out.println (rset.getString(1));
	  }
	  stmt.close();
	  System.out.println ("Ok.");
	}
	
}
