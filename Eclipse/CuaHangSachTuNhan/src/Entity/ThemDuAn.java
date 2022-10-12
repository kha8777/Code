package Entity;

public class ThemDuAn {

	private String maDuAn;
	private String tenDuAn;
	private String chuDauTu;
	
	private String trangThai;
	private String ngayCapPhep;
	private  String ngayKhoiCong;
	private String ngayHoanThanh;
	private String diaDiemThiCong;
	private String soLuongNhanSu;
	private String   ghiChu;
	
	
	
	public ThemDuAn(String maDuAn,String tenDuAn, String chuDauTu, String trangThai, String ngayCapPhep, String ngayKhoiCong,
			String ngayHoanThanh, String diaDiemThiCong, String soLuongNhanSu, String ghiChu) {
		super();
		this.maDuAn  = maDuAn;
		this.tenDuAn = tenDuAn;
		this.chuDauTu = chuDauTu;
		this.trangThai = trangThai;
		this.ngayCapPhep = ngayCapPhep;
		this.ngayKhoiCong = ngayKhoiCong;
		this.ngayHoanThanh = ngayHoanThanh;
		this.diaDiemThiCong = diaDiemThiCong;
		this.soLuongNhanSu = soLuongNhanSu;
		this.ghiChu = ghiChu;
	}



	public ThemDuAn() {
		// TODO Auto-generated constructor stub
	
		this("", "", "", "", "", "", "", "", "" , "");
	}



	
	
	public String getMaDuAn() {
		return maDuAn;
	}



	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}



	public String getTenDuAn() {
		return tenDuAn;
	}



	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}



	public String getChuDauTu() {
		return chuDauTu;
	}



	public void setChuDauTu(String chuDauTu) {
		this.chuDauTu = chuDauTu;
	}



	public String getTrangThai() {
		return trangThai;
	}



	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}



	public String getNgayCapPhep() {
		return ngayCapPhep;
	}



	public void setNgayCapPhep(String ngayCapPhep) {
		this.ngayCapPhep = ngayCapPhep;
	}



	public String getNgayKhoiCong() {
		return ngayKhoiCong;
	}



	public void setNgayKhoiCong(String ngayKhoiCong) {
		this.ngayKhoiCong = ngayKhoiCong;
	}



	public String getNgayHoanThanh() {
		return ngayHoanThanh;
	}



	public void setNgayHoanThanh(String ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	}



	public String getDiaDiemThiCong() {
		return diaDiemThiCong;
	}



	public void setDiaDiemThiCong(String diaDiemThiCong) {
		this.diaDiemThiCong = diaDiemThiCong;
	}



	public String getSoLuongNhanSu() {
		return soLuongNhanSu;
	}



	public void setSoLuongNhanSu(String soLuongNhanSu) {
		this.soLuongNhanSu = soLuongNhanSu;
	}



	public String getGhiChu() {
		return ghiChu;
	}



	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}



	@Override
	public String toString() {
		return  maDuAn + ";" + tenDuAn + ";" + chuDauTu + ","
				+ trangThai + "," + ngayCapPhep + "," + ngayKhoiCong + ","
				+ ngayHoanThanh + "," + diaDiemThiCong + "," + soLuongNhanSu
				+ "," + ghiChu ;
	}

	
	


	
	
}
