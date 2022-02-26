package test;

public class Vehicle {
	protected String tenGoi;
	protected String xuatSu;
	protected Float donGia;
	
	public Vehicle() {
		this("", "", (float)0);
	}

	public Vehicle(String tenGoi, String xuatSu, Float donGia) {
		super();
		this.tenGoi = tenGoi;
		this.xuatSu = xuatSu;
		this.donGia = donGia;
	}
	
	
}
