package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import connectDB.Database;
import entity.GiaoVien;

public class GiaoVien_DAO {
	List<GiaoVien> dsgv;

	public GiaoVien_DAO() {
		dsgv = new ArrayList<GiaoVien>();
	}
	public List<GiaoVien> docTuBang(){
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "Select*from giaovien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maGiaoVien");
				String ten = rs.getString(2);
				
				GiaoVien s = new GiaoVien(ma, ten);
				
				dsgv.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsgv;
	}
	
}
