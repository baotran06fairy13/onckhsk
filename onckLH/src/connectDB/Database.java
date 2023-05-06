package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private static Database instance = new Database();
	public static Connection con = null; 
	
	public static Connection getConnection() {
		return con;
	}
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QLLop";
		String user = "sa";
		String password = "sapassword";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Database getInstance() {
		return instance;
	}
	public static void disconnect() {
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
