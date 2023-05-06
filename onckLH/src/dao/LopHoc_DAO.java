package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Database;
import entity.GiaoVien;
import entity.LopHoc;

public class LopHoc_DAO {
	ArrayList<LopHoc> dslop;

	public LopHoc_DAO() {
		dslop = new ArrayList<LopHoc>();
	}
	public ArrayList<LopHoc> docTuBang() {
		
		try {
			//getInstance để tạo đối trượng database
			//getConnection() kết nối đến cơ sở dữ liệu
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from lophoc";
			//Statement câu lệnh truy vấn
			//createStatement() tạo đối tượng để truy vấn
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gv = rs.getString(3);
				int siso = rs.getInt(4);
				LopHoc s = new LopHoc(ma, ten, new GiaoVien(gv), siso);
				dslop.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dslop;
	}
	public ArrayList<LopHoc> getLopTheoMaLop(String malop) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null; //PreparedStatement câu lệnh truy vấn được sử dụng khi có tham số
		try {
			String sql = "Select * from lophoc where malop = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, malop);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				System.out.println(ma);
				
				String ten = rs.getString(2);
				String gv = rs.getString(3);
				int siso = rs.getInt(4);
				LopHoc s = new LopHoc(malop, ten,new GiaoVien(gv), siso);
				
				dslop.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dslop;
	}
	public ArrayList<LopHoc> getLopTheoMaGV(String magv) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null; //PreparedStatement câu lệnh truy vấn được sử dụng khi có tham số
		try {
			String sql = "Select * from lophoc where maGiaoVien = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, magv);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				System.out.println(ma);
				
				String ten = rs.getString(2);
				String gv = rs.getString(3);
				int siso = rs.getInt(4);
				LopHoc s = new LopHoc(ma, ten,new GiaoVien(magv), siso);
				
				dslop.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dslop;
	}
	public boolean create(LopHoc p) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into LopHoc values(?,?,?,?)");
			stmt.setString(1, p.getMalop());
			stmt.setString(2, p.getTenlop());
			stmt.setString(3, p.getGiaovien().getMagv());
			stmt.setInt(4, p.getSiso());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n > 0;
	}
	public boolean update(LopHoc p) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update LopHoc set tenLop = ?, maGiaoVien = ?, siSo = ? where maLop = ?");
			stmt.setString(1, p.getTenlop());
			stmt.setString(2, p.getGiaovien().getMagv());
			stmt.setInt(3, p.getSiso());
			stmt.setString(4, p.getMalop());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean delete(String malop) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from LopHoc where maLop = ?");
			stmt.setString(1, malop);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
}
