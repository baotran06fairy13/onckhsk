package entity;

public class VDV {
	private String mavdv; 
	private String tenvdv;
	private int tuoi; 
	private CLB clb;
	public VDV(String mavdv, String tenvdv, int tuoi, CLB clb) {
		super();
		this.mavdv = mavdv;
		this.tenvdv = tenvdv;
		this.tuoi = tuoi;
		this.clb = clb;
	}
	public VDV(String mavdv) {
		this(mavdv, null, 0, null);
	}
	public VDV() {
		super();
	}
	public String getMavdv() {
		return mavdv;
	}
	public void setMavdv(String mavdv) {
		this.mavdv = mavdv;
	}
	public String getTenvdv() {
		return tenvdv;
	}
	public void setTenvdv(String tenvdv) {
		this.tenvdv = tenvdv;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public CLB getClb() {
		return clb;
	}
	public void setClb(CLB clb) {
		this.clb = clb;
	}
	@Override
	public String toString() {
		return "VDV [mavdv=" + mavdv + ", tenvdv=" + tenvdv + ", tuoi=" + tuoi + ", clb=" + clb + "]";
	} 
	
}
