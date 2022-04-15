package tuan6;

import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String ho;
	private String ten;
	private String phongBan;
	private String luong;
	
	public NhanVien() {
		super();
	}

	public NhanVien(String maNV, String ho, String ten, String phongBan, String luong) {
		super();
		this.maNV = maNV;
		this.ho = ho;
		this.ten = ten;
		this.phongBan = phongBan;
		this.luong = luong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
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

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getLuong() {
		return luong;
	}

	public void setLuong(String luong) {
		this.luong = luong;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", ho=" + ho + ", ten=" + ten + ", phongBan=" + phongBan + ", luong=" + luong
				+ "]";
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
		return Objects.equals(maNV, other.maNV);
	}
	
	
}
