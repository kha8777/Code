package Entity;

public class NhanSuPC {
	private String maNhanSu;
	private String tenNhanSu;
	private String trangThai;
	private String chucVu;
	private String vaiTro;
	
	public NhanSuPC(String maNhanSu, String tenNhanSu, String trangThai, String chucVu,String vaiTro) {
		super();
		this.maNhanSu = maNhanSu;
		this.tenNhanSu = tenNhanSu;
		this.trangThai = trangThai;
		this.chucVu = chucVu;
		this.vaiTro = vaiTro;
	}
	public NhanSuPC() {
		this("", "", "","","");
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
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	
		public String getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
		@Override
	public String toString() {
		return  maNhanSu + ";" + tenNhanSu +  ";"  + trangThai + ";" + chucVu+ ";" +vaiTro;
	}
	
}
