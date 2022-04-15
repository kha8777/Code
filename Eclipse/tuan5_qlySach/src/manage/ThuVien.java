package manage;

import java.util.ArrayList;

import entity.Sach;

public class ThuVien {
	private ArrayList<Sach> ds;
	
	public ThuVien() {
		ds = new ArrayList<Sach>();
	}
	
	public ArrayList<Sach> getDs() {
		return ds;
	}
	
	public boolean themSach(Sach sach) {
		if (ds.contains(sach)) {
			return false;
		}
		ds.add(sach);
		return true;
	}
	
	public boolean xoaSach(String maSach) {
		for (Sach sach : ds) {
			if (sach.getMaSach().compareToIgnoreCase(maSach) == 0) {
				ds.remove(new Sach(maSach));
				return true;
			}
		}
		return false;
	}
	
	public boolean suaSach(String ma, String tuaSach, String tacGia, int namXB, String nhaXB, int soTrang, double donGia, String isbn) {
		for (Sach sach : ds) {
			if (sach.getMaSach().compareToIgnoreCase(ma) == 0) {
				sach.setTuaSach(tuaSach);
				sach.setTacGia(tacGia);
				sach.setNamXB(namXB);
				sach.setNhaXB(nhaXB);
				sach.setSoTrang(soTrang);
				sach.setDonGia(donGia);
				sach.setIsbn(isbn);
				return true;
			}
		}
		return false;
	}
	
}
