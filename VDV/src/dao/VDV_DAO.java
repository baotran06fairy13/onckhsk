package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import connectDB.Database;
import entity.CLB;
import entity.VDV;

public class VDV_DAO {
	ArrayList<VDV> list = null;
	public VDV_DAO() {
		list = new ArrayList<VDV>();
	}
	public ArrayList<VDV> doclentubang(){
		Connection con = Database.getIntance().getConnection();
		String sql = "select * from VanDongVien";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				int tuoi = rs.getInt(3);
				String maclb = rs.getString(4);
				VDV s = new VDV(ma, ten, tuoi, new CLB(maclb));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean create(VDV vdv) {
		Connection con = Database.getIntance().getConnection();
		PreparedStatement pst = null; 
		int n = 0;
		try {
			pst = con.prepareStatement("insert into VanDongVien values (?,?,?,?)");
			pst.setString(1, vdv.getMavdv());
			pst.setString(2, vdv.getTenvdv());
			pst.setInt(3, vdv.getTuoi());
			pst.setString(4, vdv.getClb().getMaclb());
			
			n = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean update(VDV vdv) {
		Connection con = Database.getIntance().getConnection();
		PreparedStatement pst = null; 
		int n = 0;
		try {
			pst = con.prepareStatement("update VanDongVien set TenVDV = ?,Tuoi = ?, MaCLB=? where MaVDV = ?");
			
			pst.setString(1, vdv.getTenvdv());
			pst.setInt(2, vdv.getTuoi());
			pst.setString(3, vdv.getClb().getMaclb());
			pst.setString(4, vdv.getMavdv());
			
			n = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean delete(String ma){
		Connection con = Database.getIntance().getConnection();
		PreparedStatement pst = null;
		String sql = "delete from VanDongVien where MaVDV = ?";
		int n = 0;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, ma);
			n = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	public ArrayList<VDV> timtheoma(String ma) {
		Connection con = Database.getIntance().getConnection();
		PreparedStatement pst = null; 
		String sql = "select * from VanDongVien where MaVDV = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, ma);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ma = rs.getString(1);
				String ten = rs.getString(2);
				int tuoi = rs.getInt(3);
				String maclb = rs.getString(4);
				VDV s = new VDV(ma, ten, tuoi, new CLB(maclb));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<VDV> locMaCLB(String ma) {
		Connection con = Database.getIntance().getConnection();
		PreparedStatement pst = null; 
		String sql = "select * from VanDongVien where MaCLB = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, ma);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ma = rs.getString(1);
				String ten = rs.getString(2);
				int tuoi = rs.getInt(3);
				String maclb = rs.getString(4);
				VDV s = new VDV(ma, ten, tuoi, new CLB(maclb));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
