package entity;

import java.util.Objects;

public class CLB {
	private String maclb; 
	private String tenclb;
	public CLB(String maclb, String tenclb) {
		super();
		this.maclb = maclb;
		this.tenclb = tenclb;
	}
	public CLB(String maclb) {
		super();
		this.maclb = maclb;
	}
	public CLB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaclb() {
		return maclb;
	}
	public void setMaclb(String maclb) {
		this.maclb = maclb;
	}
	public String getTenclb() {
		return tenclb;
	}
	public void setTenclb(String tenclb) {
		this.tenclb = tenclb;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maclb);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CLB other = (CLB) obj;
		return Objects.equals(maclb, other.maclb);
	}
	@Override
	public String toString() {
		return "CLB [maclb=" + maclb + ", tenclb=" + tenclb + "]";
	}
	
	
}
