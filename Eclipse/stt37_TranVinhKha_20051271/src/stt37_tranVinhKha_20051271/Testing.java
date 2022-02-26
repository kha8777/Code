package stt37_tranVinhKha_20051271;

import java.time.LocalDate;

public class Testing {
	public static void main(String[] args) {
		DanhSachNhanVien ds = new DanhSachNhanVien();
		try {
			ds.themnhanvien(new NhanVienLauNam("a1", new FullName("Khang", "Lê Huy"), LocalDate.of(1977, 12, 2), "0528095873", 30));
			ds.themnhanvien(new NhanVienLauNam("b2", new FullName("Trọng", "Hồ Đức"), LocalDate.of(1987, 3, 8), "0548083074", 25));
			ds.themnhanvien(new NhanVienLauNam("c3", new FullName("Huy", "Lê Nhật"), LocalDate.of(1990, 6, 24), "0979830648", 10));
			ds.themnhanvien(new NhanVienMoiRaTruong("d1", new FullName("Khang", "Tống Gia"), LocalDate.of(1989, 12, 6), "0678493665", 2000, "A"));
			ds.themnhanvien(new NhanVienMoiRaTruong("e2", new FullName("Bắc", "Lê Hữu"), LocalDate.of(1999, 1, 6), "0674583195", 1999, "B"));
			ds.themnhanvien(new NhanVienMoiRaTruong("f3", new FullName("Khang", "Đinh Hữu"), LocalDate.of(1989, 6, 19), "0378493593", 1999, "C"));
			ds.themnhanvien(new NhanVienThucTap("g1", new FullName("Vĩ", "Lưu Đức"), LocalDate.of(1989, 5, 4), "0528583895", "CNTT", 7));
			ds.themnhanvien(new NhanVienThucTap("h1", new FullName("Hạo", "Nguyễn Lưu"), LocalDate.of(1979, 11, 4), "0528583308", "CNTT", 8));
			ds.themnhanvien(new NhanVienThucTap("j1", new FullName("An", "Hoàng Trường"), LocalDate.of(1989, 4, 4), "0528583957", "CNTT", 9));
			System.out.println(ds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
