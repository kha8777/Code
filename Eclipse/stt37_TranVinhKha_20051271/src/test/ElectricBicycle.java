package test;

public class ElectricBicycle extends Bicycle {
	protected int nacThayDoiTocDo;
	protected float kmChayBoTro;

	public ElectricBicycle() {
		super();
		this.nacThayDoiTocDo = 0;
		this.kmChayBoTro = 0;
	}

	public ElectricBicycle(String tenGoi, String xuatSu, Float donGia, float trongLuong, int nacThayDoiTocDo,
			float kmChayBoTro) {
		super(tenGoi, xuatSu, donGia, trongLuong);
		this.nacThayDoiTocDo = nacThayDoiTocDo;
		this.kmChayBoTro = kmChayBoTro;
	}

	
	
	
}