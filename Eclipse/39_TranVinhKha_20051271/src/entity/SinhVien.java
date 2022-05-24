package entity;

import java.util.Objects;

public class SinhVien {
	private int ma;
	private String hoten;
	private String lop;
	private String noisinh;
	private String monhoc;
	
	public SinhVien() {
		super();
	}

	public SinhVien(int ma) {
		super();
		this.ma = ma;
	}

	public SinhVien(int ma, String hoten, String lop, String noisinh, String monhoc) {
		super();
		this.ma = ma;
		this.hoten = hoten;
		this.lop = lop;
		this.noisinh = noisinh;
		this.monhoc = monhoc;
	}

	@Override
	public String toString() {
		return "SinhVien [ma=" + ma + ", hoten=" + hoten + ", lop=" + lop + ", noisinh=" + noisinh + ", monhoc="
				+ monhoc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return ma == other.ma;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getNoisinh() {
		return noisinh;
	}

	public void setNoisinh(String noisinh) {
		this.noisinh = noisinh;
	}

	public String getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(String monhoc) {
		this.monhoc = monhoc;
	}
	
	
}
