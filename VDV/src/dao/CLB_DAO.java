package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Database;
import entity.CLB;

public class CLB_DAO {
	ArrayList<CLB> list = null;
	public CLB_DAO() {
		list = new ArrayList<CLB>();
	}
	public ArrayList<CLB> doctubang() {
		Connection con = Database.getIntance().getConnection();
		String sql = "select * from CauLacBo";
		try {
			Statement st = con.createStatement();
			ResultSet  rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				CLB s = new CLB(ma, ten);
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
