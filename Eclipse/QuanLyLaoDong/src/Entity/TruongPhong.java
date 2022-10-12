package Entity;

public class TruongPhong {
private String tenPhong;
private String phongban;

public TruongPhong(String tenPhong, String phongban) {
	
	this.tenPhong = tenPhong;
	this.phongban = phongban;
}
public TruongPhong() {
	this("","");
}
public String getTenPhong() {
	return tenPhong;
}
public void setTenPhong(String tenPhong) {
	this.tenPhong = tenPhong;
}
public String getPhongban() {
	return phongban;
}
public void setPhongban(String phongban) {
	this.phongban = phongban;
}
@Override
public String toString() {
	return  tenPhong + ";" + phongban;
}



}
