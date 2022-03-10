package nhanVien;

import java.util.ArrayList;

public class DanhSachNhanVien {

	private ArrayList<NhanVien> ls;
	
	public DanhSachNhanVien() {
		ls = new ArrayList<NhanVien>();
	}
	
	// lấy danh sách nhân viên
	public ArrayList<NhanVien> getLs() {
		return ls;
	}
	
	// lấy số lượng nhân viên
	public int soNV() {
		return ls.size();
	}
	
	public boolean themNhanVien(NhanVien x) {
		if (ls.contains(x)) return false;
		ls.add(x);
		return true;
	}
	
	// xóa nhân viên theo vị trí
	public boolean xoaNhanVien(int index) {
		if (index >= 0 && index <= ls.size() - 1) {
			ls.remove(index);
			return true;
		}
		return false;
	}
	
	// sửa nhân viên
	public boolean suaNhanVien(String maNV, String ho, String ten, String phai, int tuoi, double tienLuong) {
		NhanVien nv = new NhanVien(maNV, ho, ten, phai, tuoi, tienLuong);
		if (ls.contains(nv)) {
			nv.setMaNV(maNV);
			nv.setHo(ho);
			nv.setTen(ten);
			nv.setPhai(phai);
			nv.setTuoi(tuoi);
			nv.setTienLuong(tienLuong);
			return true;
		}
		return false;
	}
	
	// kiểm tra nhân viên có mã nhập vào có trong danh sách không
	public boolean kiemTra(String maNV) {
		if (ls.contains(maNV)) {
			return true;
		}
		return false;
	}
	
}
