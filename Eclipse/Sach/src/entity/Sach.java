package entity;

import java.util.Date;
import java.util.Objects;

public class Sach {
	private String maSach, tenSach, kichThuoc, loaiBia, moTa, ngonNgu;
	private Date ngayPhatHanh;
	private int soTrang;
	
	private NhaXuatBan nhaXuatBan;
	private TacGia tacGia;

//-------------------------
	public Sach(String maSach, String tenSach, java.sql.Date ngayPhatHanh, String kichThuoc, String loaiBia, int soTrang2,
			NhaXuatBan nxb, String moTa, String ngonNgu, TacGia tacGia) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.ngayPhatHanh = ngayPhatHanh;
		this.kichThuoc = kichThuoc;
		this.loaiBia = loaiBia;
		this.soTrang = soTrang;
		this.nhaXuatBan = nxb;
		this.moTa = moTa;
		this.ngonNgu = ngonNgu;
		this.tacGia = tacGia;
	}

	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
//-------------------------
	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public String getLoaiBia() {
		return loaiBia;
	}

	public void setLoaiBia(String loaiBia) {
		this.loaiBia = loaiBia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public Date getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(Date ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}
//-------------------------
	
//-------------------------
	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", kichThuoc=" + kichThuoc + ", loaiBia=" + loaiBia
				+ ", moTa=" + moTa + ", ngonNgu=" + ngonNgu + ", ngayPhatHanh=" + ngayPhatHanh + ", soTrang=" + soTrang
				+ ", nhaXuatBan=" + nhaXuatBan + ", tacGia=" + tacGia + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}
}
