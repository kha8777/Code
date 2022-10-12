package Entity;

public class CongViecChoDuAn {
	private String maCongViec;
	private String maDuAn;
	private String soLuongNhanSuCV;
	private String congViec;
	private String soLuongNhanSuHienCo;
	private String ngayThamGiaCongViec;
	private String ngayHoanThanhCongViec;
	private String trangThaiCV;
	
	public CongViecChoDuAn() {
		// TODO Auto-generated constructor stub
		this("", "", "", "", "", "", "", "");
	}

	public CongViecChoDuAn(String maCongViec, String maDuAn, String soLuongNhanSuCV, String congViec,
			String soLuongNhanSuHienCo, String ngayThamGiaCongViec, String ngayHoanThanhCongViec, String trangThaiCV) {
		super();
		this.maCongViec = maCongViec;
		this.maDuAn = maDuAn;
		this.soLuongNhanSuCV = soLuongNhanSuCV;
		this.congViec = congViec;
		this.soLuongNhanSuHienCo = soLuongNhanSuHienCo;
		this.ngayThamGiaCongViec = ngayThamGiaCongViec;
		this.ngayHoanThanhCongViec = ngayHoanThanhCongViec;
		this.trangThaiCV = trangThaiCV;
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

	public String getNgayThamGiaCongViec() {
		return ngayThamGiaCongViec;
	}

	public void setNgayThamGiaCongViec(String ngayThamGiaCongViec) {
		this.ngayThamGiaCongViec = ngayThamGiaCongViec;
	}

	public String getNgayHoanThanhCongViec() {
		return ngayHoanThanhCongViec;
	}

	public void setNgayHoanThanhCongViec(String ngayHoanThanhCongViec) {
		this.ngayHoanThanhCongViec = ngayHoanThanhCongViec;
	}

	public String getTrangThaiCV() {
		return trangThaiCV;
	}

	public void setTrangThaiCV(String trangThaiCV) {
		this.trangThaiCV = trangThaiCV;
	}

	@Override
	public String toString() {
		return  maCongViec + "," + maDuAn + ","
				+ soLuongNhanSuCV + "," + congViec + "," + soLuongNhanSuHienCo
				+ "," + ngayThamGiaCongViec + "," + ngayHoanThanhCongViec
				+ "," + trangThaiCV;
	}
	
	
	
	
}
