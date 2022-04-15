package tuan6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Database {
	public Database() {
		
	}
	
	public DanhSachNhanVien readNV(String part) throws Exception {
		DanhSachNhanVien ds = new DanhSachNhanVien();
		File f = new File(part);
		if (f.exists()) {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] data = line.split(",");
				NhanVien nv = new NhanVien(data[0], data[1], data[2], data[3], data[4]);
				ds.themNV(nv);
			}
			sc.close();
		}
		else {
			f.createNewFile();
		}
		return ds;
	}
	
	public void writeNV(DanhSachNhanVien ds, String part) throws Exception {
		try (PrintWriter pw = new PrintWriter(new FileOutputStream(part), true)) {
			for (NhanVien nv : ds.getDs()) {
				String data = nv.getMaNV() + "," + nv.getHo() + "," + nv.getTen() + "," + nv.getPhongBan() + "," + nv.getLuong() + "\n";
				pw.print(data);
			}
		}
	}
		
}
