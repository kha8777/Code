package Entity;

public class BangCong {
	private String  maBangCong;
	private String 	maNhanSu;
	private String maDuAn;
	private String ngayThamGia;
	private String ngayHoanThanh;
	private String soNgayCong;
	
	public BangCong(String maBangCong, String maNhanSu, String maDuAn, String ngayThamGia, String ngayHoanThanh,
			String soNgayCong) {
		super();
		this.maBangCong = maBangCong;
		this.maNhanSu = maNhanSu;
		this.maDuAn = maDuAn;
		this.ngayThamGia = ngayThamGia;
		this.ngayHoanThanh = ngayHoanThanh;
		this.soNgayCong = soNgayCong;
	}

	public BangCong() {
		this("","","","","","");
	}

	public String getMaBangCong() {
		return maBangCong;
	}

	public void setMaBangCong(String maBangCong) {
		this.maBangCong = maBangCong;
	}

	public String getMaNhanSu() {
		return maNhanSu;
	}

	public void setMaNhanSu(String maNhanSu) {
		this.maNhanSu = maNhanSu;
	}

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public String getNgayThamGia() {
		return ngayThamGia;
	}

	public void setNgayThamGia(String ngayThamGia) {
		this.ngayThamGia = ngayThamGia;
	}

	public String getNgayHoanThanh() {
		return ngayHoanThanh;
	}

	public void setNgayHoanThanh(String ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	}

	public String getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(String soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	@Override
	public String toString() {
		return "BangCong [maBangCong=" + maBangCong + ", maNhanSu=" + maNhanSu + ", maDuAn=" + maDuAn + ", ngayThamGia="
				+ ngayThamGia + ", ngayHoanThanh=" + ngayHoanThanh + ", soNgayCong=" + soNgayCong + "]";
	}
	
}
