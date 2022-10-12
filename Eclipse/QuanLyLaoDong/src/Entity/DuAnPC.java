package Entity;

public class DuAnPC {
	private String  maDuAn    ;
	private String    tenDuAn  ;
	private String     ngayKhoiCong ;
	private String     soNhanSu ;
	private String      trangThai;
	
	public DuAnPC(String maDuAn, String tenDuAn, String ngayKhoiCong, String soNhanSu, String trangThai) {
		super();
		this.maDuAn = maDuAn;
		this.tenDuAn = tenDuAn;
		this.ngayKhoiCong = ngayKhoiCong;
		this.soNhanSu = soNhanSu;
		this.trangThai = trangThai;
	}
	public DuAnPC() {
		this("", "", "","", "");
		
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
	public String getNgayKhoiCong() {
		return ngayKhoiCong;
	}
	public void setNgayKhoiCong(String ngayKhoiCong) {
		this.ngayKhoiCong = ngayKhoiCong;
	}
	public String getSoNhanSu() {
		return soNhanSu;
	}
	public void setSoNhanSu(String soNhanSu) {
		this.soNhanSu = soNhanSu;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return  maDuAn + ";" + tenDuAn + ";" + ngayKhoiCong + ";" + soNhanSu
				+ ";"+ trangThai;
	}
	
	
}
