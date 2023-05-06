package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Database intance = new Database();
	public static Connection  con = null;
	
	public static Connection getConnection() {
		return con;
	}
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QLyVDV";
		String user = "sa";
		String password = "sapassword";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Database getIntance() {
		return intance;
	}
	public static void disconect() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
