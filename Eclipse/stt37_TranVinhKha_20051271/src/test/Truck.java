package test;

public class Truck extends Car{
	protected int taiTrong;

	public Truck() {
		super();
		this.taiTrong = 0;
	}
	
	public Truck(String tenGoi, String xuatSu, Float donGia, String loaiNhienLieu, int taiTrong) {
		super(tenGoi, xuatSu, donGia, loaiNhienLieu);
		this.taiTrong = taiTrong;
	}
	
}
