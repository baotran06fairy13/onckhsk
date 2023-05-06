package dao;

import java.sql.Connection;

import connectDB.Database;
import entity.CLB;
import entity.VDV;

public class text {
	public static void main(String[] args) {
		Database.getIntance().connect();
		VDV_DAO ds = new VDV_DAO();
		for(VDV s : ds.doclentubang()) {
			System.out.println(s.toString());
		}
//		CLB_DAO ds = new CLB_DAO();
//		for(CLB s : ds.doctubang()) {
//			System.out.println(s.toString());
//		}
	}
}
