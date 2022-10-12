package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.NhanSu;
import Entity.NhanSuThem;
import connectDB.ConnectDB;

public class QuanLyNhanSuThem_DAO {
	ArrayList<NhanSuThem>dsNhanSuThems;
	public QuanLyNhanSuThem_DAO(){
		dsNhanSuThems= new ArrayList<NhanSuThem>();
		NhanSuThem ns= new NhanSuThem();
	}
	public ArrayList<NhanSuThem> bangNhanSuThem(){
		try {
			Connection con= ConnectDB.getInstance().getconnection();
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery("select [hoTen],[gioiTinh],[ngaySinh],[tenPhongBan],[maPhongBan],[queQuan],[diaChiLienHe],[trangThai],[sdt],[loaiNhanSu],[soCmnd],[chucVu],[vaiTro]\r\n" + 
					"from nhanSu ns join chucVu cv on cv.tenNhanVien= ns.hoTen");
			while(rs.next()) {
				
				String hoTen= rs.getString(1);
				String gioiTinh= rs.getString(2);
				String ngaySinh=rs.getString(3);
				String tenPhongBan=rs.getString(4);
				String maPhongBan= rs.getString(5);
				String queQuan=rs.getString(6);
				String diaChiLienHe=rs.getString(7);
				String trangThai=rs.getString(8);
				String sdt= rs.getString(9);
				String loaiNhanSu=rs.getString(10);
				String soCmnd=rs.getString(11);
				String chucVu= rs.getString(12);
				String vaiTro= rs.getString(13);
				NhanSuThem ds= new NhanSuThem(hoTen,gioiTinh, ngaySinh,tenPhongBan, maPhongBan,queQuan,diaChiLienHe,trangThai,sdt, loaiNhanSu,soCmnd, chucVu,vaiTro);
				dsNhanSuThems.add(ds);
			}
					
		}catch(SQLException e) {
			System.out.println("Doc khong thanh cong");
			e.printStackTrace();
		}
		return dsNhanSuThems;
				
	}
	public boolean themNS(String hoTen,String gioiTinh,String ngaySinh,String tenPhongBan, String maPhongBan,String queQuan,String diaChiLienHe,String trangThai, String sdt,String loaiNhanSu, String soCmnd, String chucVu, String vaiTro){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			stmt = con.prepareStatement("exec themnhansu ?,?,?,?,?,?,?,?,?,?,?,?,?");
			stmt.setString(1,hoTen);
			stmt.setString(2, gioiTinh);
			stmt.setString(3, ngaySinh);
			stmt.setString(4, tenPhongBan);
			stmt.setString(5, maPhongBan);
			stmt.setString(6, queQuan);
			stmt.setString(7, diaChiLienHe);
			stmt.setString(8, trangThai);		
			stmt.setString(9, sdt);
			stmt.setString(10, loaiNhanSu);
			stmt.setString(11, soCmnd);
			stmt.setString(12, chucVu);
			stmt.setString(13, vaiTro);
			
			n = stmt.executeUpdate();
			System.out.println("San sang");

		}catch (SQLException e){
			System.out.println("Lỗi");
			e.printStackTrace();
		
		}
		finally {
			
		}
			return n>0;
	}

	
}

