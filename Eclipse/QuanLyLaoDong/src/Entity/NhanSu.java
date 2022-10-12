package Entity;

public class NhanSu {
	private String maNhanSu;
	private String hoTen;
	private String gioiTinh;
	private String ngaySinh;
	private String tenPhongBan;
	private String maPhongBan;
	private String queQuan;
	private String diaChiLienHe;
	private String trangThai;
	private String sdt;
	private String loaiNhanSu;
	private String soCmnd;
	
	private String vaiTro;
	public String getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
	public NhanSu() {
		this("","","","","","","","","","","","","");
	}
	@Override
	public String toString() {
		return "NhanSu [maNhanSu=" + maNhanSu + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh
				+ ", tenPhongBan=" + tenPhongBan + ", maPhongBan=" + maPhongBan + ", queQuan=" + queQuan
				+ ", diaChiLienHe=" + diaChiLienHe + ", trangThai=" + trangThai + ", sdt=" + sdt + ", loaiNhanSu="
				+ loaiNhanSu + ", soCmnd=" + soCmnd + ", chucVu="  + ", vaiTro=" + vaiTro + "]";
	}
	public NhanSu(String maNhanSu, String hoTen, String gioiTinh, String ngaySinh, String tenPhongBan,
			String maPhongBan, String queQuan, String diaChiLienHe, String trangThai, String sdt, String loaiNhanSu,
			String soCmnd, String vaiTro) {
		super();
		this.maNhanSu = maNhanSu;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.tenPhongBan = tenPhongBan;
		this.maPhongBan = maPhongBan;
		this.queQuan = queQuan;
		this.diaChiLienHe = diaChiLienHe;
		this.trangThai = trangThai;
		this.sdt = sdt;
		this.loaiNhanSu = loaiNhanSu;
		this.soCmnd = soCmnd;
		this.vaiTro = vaiTro;
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
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getDiaChiLienHe() {
		return diaChiLienHe;
	}
	public void setDiaChiLienHe(String diaChiLienHe) {
		this.diaChiLienHe = diaChiLienHe;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getLoaiNhanSu() {
		return loaiNhanSu;
	}
	public void setLoaiNhanSu(String loaiNhanSu) {
		this.loaiNhanSu = loaiNhanSu;
	}
	public String getSoCmnd() {
		return soCmnd;
	}
	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}
	
}
