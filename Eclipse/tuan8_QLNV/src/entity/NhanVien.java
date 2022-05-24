package entity;

import java.util.Objects;

public class NhanVien {
	private int maNV;
	private String hoNV;
	private String tenNV;
	private int tuoi;
	private boolean phai;
	private double luong;
	
	private PhongBan phong;

	public NhanVien() {
		super();
	}

	public NhanVien(int maNV) {
		super();
		this.maNV = maNV;
	}

	public NhanVien(int maNV, String hoNV, String tenNV, int tuoi, boolean phai, double luong, PhongBan phong) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.tuoi = tuoi;
		this.phai = phai;
		this.luong = luong;
		this.phong = phong;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoNV=" + hoNV + ", tenNV=" + tenNV + ", tuoi=" + tuoi + ", phai=" + phai
				+ ", luong=" + luong + ", phong=" + phong + "]";
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
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
	
	public boolean getPhai() {
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

	public PhongBan getPhong() {
		return phong;
	}

	public void setPhong(PhongBan phong) {
		this.phong = phong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
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
		return maNV == other.maNV;
	}
	
	
	
}
