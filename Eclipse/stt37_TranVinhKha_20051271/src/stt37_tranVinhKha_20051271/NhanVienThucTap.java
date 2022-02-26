package stt37_tranVinhKha_20051271;

import java.time.LocalDate;

public class NhanVienThucTap extends NhanVien {
	private String chuyennganh;
	private int hocki;
	public String getChuyennganh() {
		return chuyennganh;
	}
	public void setChuyennganh(String chuyennganh) throws Exception {
		if (chuyennganh.isEmpty()) throw new Exception("Chuoi khong duoc rong");
		this.chuyennganh = chuyennganh;
	}
	public int getHocki() {
		return hocki;
	}
	public void setHocki(int hocki) throws Exception {
		if (hocki < 6 || hocki > 10) throw new Exception("Hoc ki dang hoc phai nam trong khoang 6 - 10");
		this.hocki = hocki;
	}
	@Override
	public String toString() {
		return super.toString() + String.format(" %20s %20d", chuyennganh, hocki);
	}
	
	public NhanVienThucTap(String manhanvien, FullName hoten, LocalDate ngaysinh, String sdt, String chuyennganh,
			int hocki) throws Exception {
		super(manhanvien, hoten, ngaysinh, sdt);
		setChuyennganh(chuyennganh);
		setHocki(hocki);
	}
	public NhanVienThucTap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
