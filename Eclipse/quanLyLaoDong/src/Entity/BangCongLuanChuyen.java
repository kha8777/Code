package Entity;

public class BangCongLuanChuyen {
private String  maBangCong    ;
private String     maNhanSu ;
private String      hoTen;
private String  soNgayCong;
private String      ngayThamGia;
private String      trangThaiNs;
private String      chucVu;
private String      maDuAn;
private String      soLuongNs;
private String      trangThaiDa;





public BangCongLuanChuyen(String maBangCong, String maNhanSu, String hoTen, String soNgayCong, String ngayThamGia,
		String trangThaiNs, String chucVu, String maDuAn, String soLuongNs, String trangThaiDa) {
	super();
	this.maBangCong = maBangCong;
	this.maNhanSu = maNhanSu;
	this.hoTen = hoTen;
	this.soNgayCong = soNgayCong;
	this.ngayThamGia = ngayThamGia;
	this.trangThaiNs = trangThaiNs;
	this.chucVu = chucVu;
	this.maDuAn = maDuAn;
	this.soLuongNs = soLuongNs;
	this.trangThaiDa = trangThaiDa;
}

public BangCongLuanChuyen() {
	this("","","","","","","","","","");
}

public String getMaBangCong() {
	return maBangCong;
}



public void setMaBangCong(String maBangCong) {
	this.maBangCong = maBangCong;
}



public String getMaNhanSu() {
	return maNhanSu;
}



public void setMaNhanSu(String maNhanSu) {
	this.maNhanSu = maNhanSu;
}



public String getHoTen() {
	return hoTen;
}



public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}



public String getSoNgayCong() {
	return soNgayCong;
}



public void setSoNgayCong(String soNgayCong) {
	this.soNgayCong = soNgayCong;
}



public String getNgayThamGia() {
	return ngayThamGia;
}



public void setNgayThamGia(String ngayThamGia) {
	this.ngayThamGia = ngayThamGia;
}



public String getTrangThaiNs() {
	return trangThaiNs;
}



public void setTrangThaiNs(String trangThaiNs) {
	this.trangThaiNs = trangThaiNs;
}



public String getChucVu() {
	return chucVu;
}



public String getSoLuongNs() {
	return soLuongNs;
}

public void setSoLuongNs(String soLuongNs) {
	this.soLuongNs = soLuongNs;
}

public void setChucVu(String chucVu) {
	this.chucVu = chucVu;
}



public String getMaDuAn() {
	return maDuAn;
}



public void setMaDuAn(String maDuAn) {
	this.maDuAn = maDuAn;
}



public String getTrangThaiDa() {
	return trangThaiDa;
}



public void setTrangThaiDa(String trangThaiDa) {
	this.trangThaiDa = trangThaiDa;
}



@Override
public String toString() {
	return  maBangCong + ";" + maNhanSu + ";"+ hoTen+";"+soNgayCong+";"+ngayThamGia
			+ ";" + trangThaiNs + ";" + chucVu + ";" + maDuAn + ";"+soLuongNs+";" + trangThaiDa;
}

}
