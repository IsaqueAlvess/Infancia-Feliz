package br.ucb.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con=null;
	  
	  public static Connection getConnection() throws SQLException {
	    if (con == null) {
	      try {
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        String sql = "jdbc:mysql://127.0.0.1/infanciafeliz_web";
	        
	        con = DriverManager.getConnection(sql, "root", "");
	      }
	      catch (ClassNotFoundException e) {
	        throw new SQLException("Driver n�o localizado");
	      }
	    }
	    return con;
	  }

}
