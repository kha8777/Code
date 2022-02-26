package test;

public class Bicycle extends Vehicle {
	protected float trongLuong;

	public Bicycle() {
		super();
		this.trongLuong = 0;
	}

	public Bicycle(String tenGoi, String xuatSu, Float donGia, float trongLuong) {
		super(tenGoi, xuatSu, donGia);
		this.trongLuong = trongLuong;
	}
	
	
	
}
