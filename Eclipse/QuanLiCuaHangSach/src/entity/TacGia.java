package entity;

import java.util.Date;
import java.util.Objects;

public class TacGia {
	private String maTacGia, tenTacGia, tieuSu;
	private Date ngaySinh, ngayMat;
	public TacGia(String maTacGia, String tenTacGia, String tieuSu, Date ngaySinh, Date ngayMat) {
		super();
		this.maTacGia = maTacGia;
		this.tenTacGia = tenTacGia;
		this.tieuSu = tieuSu;
		this.ngaySinh = ngaySinh;
		this.ngayMat = ngayMat;
	}
	public TacGia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public String getTieuSu() {
		return tieuSu;
	}
	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Date getNgayMat() {
		return ngayMat;
	}
	public void setNgayMat(Date ngayMat) {
		this.ngayMat = ngayMat;
	}
	@Override
	public String toString() {
		return "TacGia [maTacGia=" + maTacGia + ", tenTacGia=" + tenTacGia + ", tieuSu=" + tieuSu + ", ngaySinh="
				+ ngaySinh + ", ngayMat=" + ngayMat + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTacGia);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TacGia other = (TacGia) obj;
		return Objects.equals(maTacGia, other.maTacGia);
	}
	public TacGia(String tenTacGia) {
		super();
		this.tenTacGia = tenTacGia;
	}
	
}
