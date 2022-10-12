package Entity;

public class PhongBan {
	private String maPhongBan;
	private String tenPhongBan;
	private String soLuongNhanSu;
	private String truongPhong;

	public PhongBan(String maPhongBan, String tenPhongBan, String soLuongNhanSu, String truongPhong) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.soLuongNhanSu = soLuongNhanSu;
		this.truongPhong = truongPhong;
	}

	public PhongBan() {
		this("", "", "", "");
	}

	@Override
	public String toString() {
		return maPhongBan + ";" + tenPhongBan + ";" + soLuongNhanSu + ";" + truongPhong;
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

	public String getSoLuongNhanSu() {
		return soLuongNhanSu;
	}

	public void setSoLuongNhanSu(String soLuongNhanSu) {
		this.soLuongNhanSu = soLuongNhanSu;
	}

	public String getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(String truongPhong) {
		this.truongPhong = truongPhong;
	}

}

