package stt37_tranVinhKha_20051271;

import java.time.LocalDate;

public class NhanVienLauNam extends NhanVien{
	private int sonamkinhnghiem;

	public int getSonamkinhnghiem() {
		return sonamkinhnghiem;
	}

	public void setSonamkinhnghiem(int sonamkinhnghiem) throws Exception {
		if (sonamkinhnghiem < 0) throw new Exception("Khong nhap so am");
		this.sonamkinhnghiem = sonamkinhnghiem;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" %20d", sonamkinhnghiem);
	}

	public NhanVienLauNam(String manhanvien, FullName hoten, LocalDate ngaysinh, String sdt, int sonamkinhnghiem) throws Exception {
		super(manhanvien, hoten, ngaysinh, sdt);
		setSonamkinhnghiem(sonamkinhnghiem);
	}

	public NhanVienLauNam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
