package test;

public class Car extends Vehicle {
	protected String loaiNhienLieu;

	public Car() {
		super();
		this.loaiNhienLieu = "";
	}

	public Car(String tenGoi, String xuatSu, Float donGia, String loaiNhienLieu) {
		super(tenGoi, xuatSu, donGia);
		this.loaiNhienLieu = loaiNhienLieu;
	}
	
	
}
