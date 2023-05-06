package entity;

public class LopHoc {
	private String malop;
	private String tenlop;
	private GiaoVien giaovien; 
	private int siso;
	public LopHoc(String malop, String tenlop, GiaoVien giaovien, int siso) {
		super();
		this.malop = malop;
		this.tenlop = tenlop;
		this.giaovien = giaovien;
		this.siso = siso;
	}
	public LopHoc(String malop) {
		super();
		this.malop = malop;
	}
	public LopHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	public GiaoVien getGiaovien() {
		return giaovien;
	}
	public void setGiaovien(GiaoVien giaovien) {
		this.giaovien = giaovien;
	}
	public int getSiso() {
		return siso;
	}
	public void setSiso(int siso) {
		this.siso = siso;
	}
	@Override
	public String toString() {
		return "LopHoc [malop=" + malop + ", tenlop=" + tenlop + ", giaovien=" + giaovien + ", siso=" + siso + "]";
	}
	
}
