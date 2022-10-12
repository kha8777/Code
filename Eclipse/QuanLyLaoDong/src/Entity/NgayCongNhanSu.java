package Entity;

public class NgayCongNhanSu {
private String maNgayCong;
private String maNhanSu;
private String tenNhanSu;
private String tenduan;
private String maCongViec;
private String NgayThamGia;
private String NgayHoanThanh;
private String Songaycong;


public NgayCongNhanSu(String maNgayCong, String maNhanSu, String tenNhanSu, String tenduan, String maCongViec,
		String ngayThamGia, String ngayHoanThanh, String songaycong) {
	super();
	this.maNgayCong = maNgayCong;
	this.maNhanSu = maNhanSu;
	this.tenNhanSu = tenNhanSu;
	this.tenduan = tenduan;
	this.maCongViec = maCongViec;
	NgayThamGia = ngayThamGia;
	NgayHoanThanh = ngayHoanThanh;
	Songaycong = songaycong;
}


public NgayCongNhanSu() {
	this("","","","","","","","");
}


public String getMaNgayCong() {
	return maNgayCong;
}


public void setMaNgayCong(String maNgayCong) {
	this.maNgayCong = maNgayCong;
}


public String getMaNhanSu() {
	return maNhanSu;
}


public void setMaNhanSu(String maNhanSu) {
	this.maNhanSu = maNhanSu;
}


public String getTenNhanSu() {
	return tenNhanSu;
}


public void setTenNhanSu(String tenNhanSu) {
	this.tenNhanSu = tenNhanSu;
}


public String getTenduan() {
	return tenduan;
}


public void setTenduan(String tenduan) {
	this.tenduan = tenduan;
}


public String getMaCongViec() {
	return maCongViec;
}


public void setMaCongViec(String maCongViec) {
	this.maCongViec = maCongViec;
}


public String getNgayThamGia() {
	return NgayThamGia;
}


public void setNgayThamGia(String ngayThamGia) {
	NgayThamGia = ngayThamGia;
}


public String getNgayHoanThanh() {
	return NgayHoanThanh;
}


public void setNgayHoanThanh(String ngayHoanThanh) {
	NgayHoanThanh = ngayHoanThanh;
}


public String getSongaycong() {
	return Songaycong;
}


public void setSongaycong(String songaycong) {
	Songaycong = songaycong;
}


@Override
public String toString() {
	return  maNgayCong + ";" + maNhanSu + ";" + tenNhanSu
			+ ";" + tenduan + ";" + maCongViec + ";" + NgayThamGia
			+ ";" + NgayHoanThanh + ";" + Songaycong;
}


}
