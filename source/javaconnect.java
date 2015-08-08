

import java.sql.*;

import javax.swing.*;


public class javaconnect {
	
	Connection conn = null;
	
	public static Connection ConnectrDB() {
		
		// 1- Get a connection to Database
		try {
		
			//Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:c:\\users\\user\\downloads\\db sqlite\\bankdb_final.db");
			//Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Downloads\\DB SQLITE\\BankDB_Final.db");
			
			JOptionPane.showMessageDialog(null, "Connection Established");
			
			return conn;
			
		} catch(Exception e) {
			
	     JOptionPane.showMessageDialog(null, e);
	   return null;
		
		}
		
	}
	
}
