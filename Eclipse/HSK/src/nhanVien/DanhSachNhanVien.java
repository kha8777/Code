package nhanVien;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DanhSachNhanVien implements Serializable {

	private ArrayList<NhanVien> ls;
	
	public DanhSachNhanVien() {
		ls = new ArrayList<NhanVien>();
	}
	
	// lấy danh sách nhân viên
	public ArrayList<NhanVien> getList() {
		return ls;
	}
	
	// lấy số lượng nhân viên
	public int getSize() {
		return ls.size();
	}
	
	public boolean add(NhanVien x) {
		if (ls.contains(x)) return false;
		ls.add(x);
		return true;
	}
	
	// xóa nhân viên theo vị trí
	public boolean remove(int index) {
		if (index >= 0 && index <= ls.size() - 1) {
			ls.remove(index);
			return true;
		}
		return false;
	}
	// xóa nhân viên theo mã
	public boolean remove(String maNV) {
		for (NhanVien nhanVien : ls) {
			if (nhanVien.getMaNV().compareToIgnoreCase(maNV) == 0) {
				ls.remove(nhanVien);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param str - Mã nhân viên hoặc họ, tên nhân viên cần tìm
	 * @return Danh sách nhân viên ArrayList<NhanVien>
	 */
	public ArrayList<NhanVien> find(String str) {
		ArrayList<NhanVien> foundationList = new ArrayList<NhanVien>();
		for (NhanVien nv : ls)
			if (nv.getMaNV().toLowerCase().contains(str.toLowerCase()) || nv.getTen().toLowerCase().contains(str.toLowerCase()) || nv.getHo().toLowerCase().contains(str.toLowerCase())) {
				foundationList.add(nv);
			}
		return foundationList;
	}
	
	public NhanVien getElement(int index) {
		return ls.get(index);
	}
	
	// sửa nhân viên theo mã
	public boolean modify(String maNV, String ho, String ten, String phai, String tuoi, String tienLuong) {
		for (NhanVien nhanVien : ls) {
			if (nhanVien.getMaNV().compareToIgnoreCase(maNV) == 0) {
				nhanVien.setHo(ho);
				nhanVien.setTen(ten);
				nhanVien.setPhai(phai);
				nhanVien.setTuoi(tuoi);
				nhanVien.setTienLuong(tienLuong);
				return true;
			}
		}
		return false;
	}
	// sửa nhân viên theo vị trí
	public void modify(int index, String ho, String ten, String gt, String tuoi, String luong) {
		ls.get(index).setHo(ho);
		ls.get(index).setTen(ten);
		ls.get(index).setPhai(gt);
		ls.get(index).setTuoi(tuoi);
		ls.get(index).setTienLuong(luong);
		
	}
	
	// kiểm tra nhân viên có mã nhập vào có trong danh sách không
	public boolean check(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if (ls.contains(nv)) {
			return true;
		}
		return false;
	}
	
}
