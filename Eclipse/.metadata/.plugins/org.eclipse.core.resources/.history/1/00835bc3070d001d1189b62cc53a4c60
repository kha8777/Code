package nhanVien;

import java.util.ArrayList;

public class DanhSachNhanVien {
	ArrayList<NhanVien> ls;
	
	public DanhSachNhanVien() {
		ls = new ArrayList<NhanVien>();
	}
	
	public ArrayList<NhanVien> getLs() {
		return ls;
	}
	
	public boolean themNv(NhanVien x) {
		if (ls.contains(x)) {
			return false;
		}
		ls.add(x);
		return true;
	}
	
	public boolean xoaNv(String ma) {
		for (NhanVien nhanVien : ls) {
			if (nhanVien.getMaNV().compareToIgnoreCase(ma) == 0) {
				ls.remove(new NhanVien(ma));
				return true;
			}
		}
		return false;
	}
	
	public boolean check(String ma) {
		if (ls.contains(new NhanVien(ma))) {
			return true;
		}
		return false;
	}
}
