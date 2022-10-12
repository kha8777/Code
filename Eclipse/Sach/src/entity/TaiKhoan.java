package entity;

public class TaiKhoan {
	private String tenTaiKhoan, matKhau;
	private NhanVien nhanVien;
	public TaiKhoan(String tenTaiKhoan, String matKhau, NhanVien nhanVien) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.nhanVien = nhanVien;
	}
	public TaiKhoan(String tenTaiKhoan, String matKhau) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", nhanVien=" + nhanVien + "]";
	}

	

}
