package test;

public class PrivateCar extends Car{
	protected int soGhe;

	public PrivateCar() {
		super();
		this.soGhe = 0;
	}

	public PrivateCar(String tenGoi, String xuatSu, Float donGia, String loaiNhienLieu, int soGhe) {
		super(tenGoi, xuatSu, donGia, loaiNhienLieu);
		this.soGhe = soGhe;
	}
	
	
	
}
