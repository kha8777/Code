package nhanVien;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class NhanVien implements Serializable {
	private String maNV;
	private String ho;
	private String ten;
	private String phai;
	private String tuoi;
	private String tienLuong;
	
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
	
	public String getPhai() {
		return phai;
	}
	
	public void setPhai(String phai) {
		this.phai = phai;
	}
	
	public String getTuoi() {
		return tuoi;
	}
	
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	
	public String getTienLuong() {
		return tienLuong;
	}
	
	public void setTienLuong(String tienLuong) {
		this.tienLuong = tienLuong;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", ho=" + ho + ", ten=" + ten + ", phai=" + phai + ", tuoi=" + tuoi
				+ ", tienLuong=" + tienLuong + "]";
	}
	
	public NhanVien() {
		super();
	}

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	
	public NhanVien(String maNV, String ho, String ten, String phai, String tuoi, String tienLuong) {
		super();
		this.maNV = maNV;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
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
