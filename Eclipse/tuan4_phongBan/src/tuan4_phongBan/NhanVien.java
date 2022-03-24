package tuan4_phongBan;

public class NhanVien {
	private String ma;
    private String ho;
    private String ten;
    private boolean phai;
    private int tuoi;
    private long tienLuong;
    private PhongBan phongBan;
    
	public NhanVien(String ma, String ho, String ten, boolean phai, int tuoi,
			long tienLuong, PhongBan phongBan) {
		super();
		this.ma = ma;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
		this.phongBan = phongBan;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public long getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(long tienLuong) {
		this.tienLuong = tienLuong;
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
	@Override
	public String toString() {
		return "NhanVien [ma=" + ma + ", ho=" + ho + ", ten=" + ten + ", phai="
				+ phai + ", tuoi=" + tuoi + ", tienLuong=" + tienLuong
				+ ", phongBan=" + phongBan + "]";
	}
	
     
     
}
