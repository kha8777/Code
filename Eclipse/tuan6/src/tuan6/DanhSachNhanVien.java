package tuan6;

import java.util.ArrayList;

public class DanhSachNhanVien {
	private ArrayList<NhanVien> ds;

	public DanhSachNhanVien() {
		ds = new ArrayList<NhanVien>();
	}

	public ArrayList<NhanVien> getDs() {
		return ds;
	}
	
	public boolean themNV(NhanVien x) {
		if (ds.contains(x)) return false;
		ds.add(x);
		return true;
	}
	
	public boolean xoaNV(String maNV) {
		for (NhanVien nhanVien : ds) {
			if (nhanVien.getMaNV().compareToIgnoreCase(maNV) == 0) {
				ds.remove(nhanVien);
				return true;
			}
		}
		return false;
	}
	
}
