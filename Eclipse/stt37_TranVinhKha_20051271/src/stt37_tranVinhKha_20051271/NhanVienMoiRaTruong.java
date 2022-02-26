package stt37_tranVinhKha_20051271;

import java.time.LocalDate;

public class NhanVienMoiRaTruong extends NhanVien{
	private int namtotnghiep;
	private String xeploai;
	public int getNamtotnghiep() {
		return namtotnghiep;
	}
	public void setNamtotnghiep(int namtotnghiep) throws Exception {
		if (namtotnghiep < 0) throw new Exception("Khong nhap so am");
		if (namtotnghiep > LocalDate.now().getYear()) throw new Exception("Nam nhap vao phai truoc nam hien tai");
		this.namtotnghiep = namtotnghiep;
	}
	public String getXeploai() {
		return xeploai;
	}
	public void setXeploai(String xeploai) throws Exception {
		if (xeploai.isEmpty()) throw new Exception("Chuoi khong duoc rong");
		if (xeploai.compareToIgnoreCase("A") != 0 && xeploai.compareToIgnoreCase("B") != 0 && xeploai.compareToIgnoreCase("C") != 0) throw new Exception("Xep loai phai la A, B hoac C");
		this.xeploai = xeploai;
	}
	@Override
	public String toString() {
		return super.toString() + String.format(" %20d %20s", namtotnghiep, xeploai);
	}
	
	public NhanVienMoiRaTruong(String manhanvien, FullName hoten, LocalDate ngaysinh, String sdt, int namtotnghiep,
			String xeploai) throws Exception {
		super(manhanvien, hoten, ngaysinh, sdt);
		setNamtotnghiep(namtotnghiep);
		setXeploai(xeploai);
	}
	public NhanVienMoiRaTruong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
