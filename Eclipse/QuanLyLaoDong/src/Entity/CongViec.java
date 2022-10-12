package Entity;

public class CongViec {
private String maCongViec;
private String maDuAn;
private String soLuongNhanSuCV;
private String congViec;
private String soLuongNhanSuHienCo;
private String ngaythamgia;
public CongViec(String maCongViec, String maDuAn, String soLuongNhanSuCV, String congViec, String soLuongNhanSuHienCo,String ngaythamgia) {
	super();
	this.maCongViec = maCongViec;
	this.maDuAn = maDuAn;
	this.soLuongNhanSuCV = soLuongNhanSuCV;
	this.congViec = congViec;
	this.soLuongNhanSuHienCo = soLuongNhanSuHienCo;
	this.ngaythamgia = ngaythamgia;
}
public CongViec() {
	this("","","","","","");
}
public String getMaCongViec() {
	return maCongViec;
}
public void setMaCongViec(String maCongViec) {
	this.maCongViec = maCongViec;
}
public String getMaDuAn() {
	return maDuAn;
}
public void setMaDuAn(String maDuAn) {
	this.maDuAn = maDuAn;
}
public String getSoLuongNhanSuCV() {
	return soLuongNhanSuCV;
}
public void setSoLuongNhanSuCV(String soLuongNhanSuCV) {
	this.soLuongNhanSuCV = soLuongNhanSuCV;
}
public String getCongViec() {
	return congViec;
}
public void setCongViec(String congViec) {
	this.congViec = congViec;
}
public String getSoLuongNhanSuHienCo() {
	return soLuongNhanSuHienCo;
}
public void setSoLuongNhanSuHienCo(String soLuongNhanSuHienCo) {
	this.soLuongNhanSuHienCo = soLuongNhanSuHienCo;
}

public String getNgaythamgia() {
	return ngaythamgia;
}
public void setNgaythamgia(String ngaythamgia) {
	this.ngaythamgia = ngaythamgia;
}
@Override
public String toString() {
	return  maCongViec + ";" + maDuAn + ";" + soLuongNhanSuCV
			+ ";" + congViec + ";" + soLuongNhanSuHienCo+";"+ngaythamgia ;
}

}
