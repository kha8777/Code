package stt37_tranVinhKha_20051271;

import java.time.LocalDate;
import java.util.Objects;

public abstract class NhanVien {
	private String manhanvien;
	private FullName hoten;
	private LocalDate ngaysinh;
	private String sdt;
	
	public String getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(String manhanvien) throws Exception {
		if (manhanvien.isEmpty()) throw new Exception("Chuoi khong duoc rong");
		this.manhanvien = manhanvien;
	}
	
	public int getTuoi() {
		return LocalDate.now().getYear() - ngaysinh.getYear();
	}
	
	public String getHoten() {
		return hoten.getFirstname() + " " + hoten.getLastname();
	}
	
	public void setHoten(FullName hoten) {
		this.hoten = hoten;
	} 
	
	public LocalDate getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(LocalDate ngaysinh) throws Exception {
//		int tuoi = getTuoi();
//		if (tuoi < 20) throw new Exception("Tuoi nhan vien phai tu 20 tuoi");
		this.ngaysinh = ngaysinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) throws Exception {
		if (sdt.length() != 10 || !sdt.startsWith("0")) throw new Exception("Dinh dang so dien thoai khong chinh xac");
		this.sdt = sdt;
	}
	@Override
	public String toString() {
		return String.format("%-20s %-20s %20s %20s", manhanvien, hoten, ngaysinh, sdt);
	}
	
	public NhanVien(String manhanvien, FullName hoten, LocalDate ngaysinh, String sdt) throws Exception {
		super();
		setManhanvien(manhanvien);
		setHoten(hoten);
		setNgaysinh(ngaysinh);
		setSdt(sdt);
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(manhanvien);
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
		return Objects.equals(manhanvien, other.manhanvien);
	}
	
	
}
