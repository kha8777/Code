package Entity;

public class PhongBan1 {
	private String maPhongBan;
	private String tenPhongBan;
	private String soLuongNguoi;

	public String getSoLuongNguoi() {
		return soLuongNguoi;
	}
	public void setSoLuongNguoi(String soLuongNguoi) {
		this.soLuongNguoi = soLuongNguoi;
	}
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	@Override
	public String toString() {
		return "PhongBan [maPhongBan=" + maPhongBan + ", tenPhongBan=" + tenPhongBan + ", soLuongNguoi=" + soLuongNguoi
				+ "]";
	}

	public PhongBan1(String maPhongBan, String tenPhongBan, String soLuongNguoi) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.soLuongNguoi = soLuongNguoi;
	}
	public PhongBan1() {
		this("","","");
	}
	
}
