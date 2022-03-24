package tuan4_phongBan;

import java.util.ArrayList;

public class PhongBan {
	private String maPhong;
	private String tenPhong;
	private ArrayList<NhanVien> dsnv;
	
	public PhongBan(String maPhong, String tenPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		dsnv = new ArrayList<NhanVien>();
	}
	
	public void themMoiNhanVien(String ma, String ho,String ten, boolean phai, int tuoi, long tienLuong){
		NhanVien nv= new NhanVien(ma, ho, ten, phai, tuoi, tienLuong,this);
		dsnv.add(nv);
	}
	
	public ArrayList<NhanVien> getDsnv() {
		return dsnv;
	}
	
  	@Override
	public String toString() {
		return tenPhong;
	}
  
}
