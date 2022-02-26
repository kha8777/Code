package test;

public class Motorcycle extends Vehicle {
	protected int dungTichXiLanh;

	public Motorcycle() {
		super();
		this.dungTichXiLanh = 0;
	}

	public Motorcycle(String tenGoi, String xuatSu, Float donGia, int dungTichXiLanh) {
		super(tenGoi, xuatSu, donGia);
		this.dungTichXiLanh = dungTichXiLanh;
	}
	
	
}