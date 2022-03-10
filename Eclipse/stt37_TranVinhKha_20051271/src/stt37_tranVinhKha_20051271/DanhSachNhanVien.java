package stt37_tranVinhKha_20051271;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachNhanVien {
	private List<NhanVien> ds;
	
	public DanhSachNhanVien() {
		ds = new ArrayList<NhanVien>();
	}
	
	public boolean themnhanvien(NhanVien x) {
		if (ds.contains(x)) return false;
		ds.add(x);
		return true;
	}
	
	public int demsoluongnhanvientotnghiep(int nam) {
		int count = 0;
		for (NhanVien nhanVien : ds) {
			if (nhanVien instanceof NhanVienMoiRaTruong) {
				if (((NhanVienMoiRaTruong) nhanVien).getNamtotnghiep() == nam) count++;
			}
		}
		return count;
	}
	
	public boolean suangaysinhcuamotnhanvien(String ma, LocalDate date) throws Exception {
		for (NhanVien nhanVien : ds) {
			if (nhanVien.getManhanvien().compareToIgnoreCase(ma) == 0) {
				nhanVien.setNgaysinh(date);
				return true;
			}
		}
		return false;
	}
	
	public DanhSachNhanVien laydanhnhanviencokinhnghiemtren5nam() {
		DanhSachNhanVien ds = new DanhSachNhanVien();
		for (NhanVien nhanVien : this.ds) {
			if (nhanVien instanceof NhanVienLauNam) {
				if (((NhanVienLauNam) nhanVien).getSonamkinhnghiem() > 5) ds.themnhanvien(nhanVien);
			}
		}
		return ds;
	}
	
	public void sapxeptheotennhanvientangdan() {
		Collections.sort(ds, new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				// TODO Auto-generated method stub
				return o1.getHoten().compareToIgnoreCase(o2.getHoten());
			}
		});
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "Nhan vien lau nam\n";
		for (NhanVien nhanVien : ds) {
			if (nhanVien instanceof NhanVienLauNam) {
				s += nhanVien + "\n";
			}
		}
		s += "Nhan vien moi ra truong\n";
		for (NhanVien nhanVien : ds) {
			if (nhanVien instanceof NhanVienMoiRaTruong) {
				s += nhanVien + "\n";
			}
		}
		s += "Nhan vien thuc tap\n";
		for (NhanVien nhanVien : ds) {
			if (nhanVien instanceof NhanVienThucTap) {
				s += nhanVien + "\n";
			}
		}
		return s;
	}
}
