package entity;

import java.util.Objects;

public class NhanVien {
	private int ma;
	private String ho;
	private String ten;
	private int tuoi;
	private boolean phai;
	private double luong;
	
	private PhongBan phongBan;
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(int ma) {
		super();
		this.ma = ma;
	}

	public NhanVien(int ma, String ho, String ten, int tuoi, boolean phai, double luong) {
		super();
		this.ma = ma;
		this.ho = ho;
		this.ten = ten;
		this.tuoi = tuoi;
		this.phai = phai;
		this.luong = luong;
	}
	
	public NhanVien(int ma, String ho, String ten, int tuoi, boolean phai, double luong, PhongBan phongBan) {
		super();
		this.ma = ma;
		this.ho = ho;
		this.ten = ten;
		this.tuoi = tuoi;
		this.phai = phai;
		this.luong = luong;
		this.phongBan = phongBan;
	}

	@Override
	public String toString() {
		return "NhanVien [ma=" + ma + ", ho=" + ho + ", ten=" + ten + ", tuoi=" + tuoi + ", phai=" + phai + ", luong="
				+ luong + "]";
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
		NhanVien other = (NhanVien) obj;
		return ma == other.ma;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
	
	
}
