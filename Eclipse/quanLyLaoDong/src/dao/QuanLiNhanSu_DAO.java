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

public class QuanLiNhanSu_DAO {
	ArrayList<NhanSu>dsNhanSu;
	public QuanLiNhanSu_DAO(){
		dsNhanSu= new ArrayList<NhanSu>();
		NhanSu ns= new NhanSu();
	}
	public ArrayList<NhanSu> bangNhanSu(){
		try {
			Connection con= ConnectDB.getInstance().getconnection();
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery("select [maNhanSu],[hoTen],[gioiTinh],[ngaySinh],[tenPhongBan],[maPhongBan],[queQuan],[diaChiLienHe],[trangThai],[sdt],[loaiNhanSu],[soCmnd],[vaiTro]from nhanSu ns \r\n" + 
					"join chucVu cv on cv.maChucVu= ns.maChucVu");
			while(rs.next()) {
				String maNhanSu= rs.getString(1);
				String hoTen= rs.getString(2);
				String gioiTinh= rs.getString(3);
				String ngaySinh=rs.getString(4);
				String tenPhongBan=rs.getString(5);
				String maPhongBan= rs.getString(6);
				String queQuan=rs.getString(7);
				String diaChiLienHe=rs.getString(8);
				String trangThai=rs.getString(9);
				String sdt= rs.getString(10);
				String loaiNhanSu=rs.getString(11);
				String soCmnd=rs.getString(12);
				
				String vaiTro= rs.getString(13);
				NhanSu ds= new NhanSu(maNhanSu,hoTen,gioiTinh, ngaySinh,tenPhongBan, maPhongBan,queQuan,diaChiLienHe,trangThai,sdt, loaiNhanSu,soCmnd,vaiTro);
				dsNhanSu.add(ds);
			}
					
		}catch(Exception e) {
			System.out.println("Doc thanh cong");
			e.printStackTrace();
		}
		return dsNhanSu;
				
	}
	public ArrayList<NhanSu> bangNhanSu1(){
		try {
			Connection con= ConnectDB.getInstance().getconnection();
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery("select [maNhanSu],[hoTen],[gioiTinh],[ngaySinh],[tenPhongBan],[maPhongBan],[queQuan],[diaChiLienHe],[trangThai],[sdt],[loaiNhanSu],[soCmnd],[vaiTro]\r\n" + 
					"					from nhanSu ns join chucVu cv on cv.maChucVu= ns.maChucVu where trangThai=0");
			while(rs.next()) {
				String maNhanSu= rs.getString(1);
				String hoTen= rs.getString(2);
				String gioiTinh= rs.getString(3);
				String ngaySinh=rs.getString(4);
				String tenPhongBan=rs.getString(5);
				String maPhongBan= rs.getString(6);
				String queQuan=rs.getString(7);
				String diaChiLienHe=rs.getString(8);
				String trangThai=rs.getString(9);
				String sdt= rs.getString(10);
				String loaiNhanSu=rs.getString(11);
				String soCmnd=rs.getString(12);
		
				String vaiTro= rs.getString(13);
				NhanSu ds= new NhanSu(maNhanSu,hoTen,gioiTinh, ngaySinh,tenPhongBan, maPhongBan,queQuan,diaChiLienHe,trangThai,sdt, loaiNhanSu,soCmnd,vaiTro);
				dsNhanSu.add(ds);
			}
					
		}catch(Exception e) {
			System.out.println("Doc thanh cong");
			e.printStackTrace();
		}
		return dsNhanSu;
				
	}
	public ArrayList<NhanSu> bangNhanSu2(){
		try {
			Connection con= ConnectDB.getInstance().getconnection();
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery("select [maNhanSu],[hoTen],[gioiTinh],[ngaySinh],[tenPhongBan],[maPhongBan],[queQuan],[diaChiLienHe],[trangThai],[sdt],[loaiNhanSu],[soCmnd],[vaiTro]\r\n" + 
					"					from nhanSu ns join chucVu cv on cv.maChucVu= ns.maChucVu where trangThai=1");
			while(rs.next()) {
				String maNhanSu= rs.getString(1);
				String hoTen= rs.getString(2);
				String gioiTinh= rs.getString(3);
				String ngaySinh=rs.getString(4);
				String tenPhongBan=rs.getString(5);
				String maPhongBan= rs.getString(6);
				String queQuan=rs.getString(7);
				String diaChiLienHe=rs.getString(8);
				String trangThai=rs.getString(9);
				String sdt= rs.getString(10);
				String loaiNhanSu=rs.getString(11);
				String soCmnd=rs.getString(12);
				
				String vaiTro= rs.getString(13);
				NhanSu ds= new NhanSu(maNhanSu,hoTen,gioiTinh, ngaySinh,tenPhongBan, maPhongBan,queQuan,diaChiLienHe,trangThai,sdt, loaiNhanSu,soCmnd,vaiTro);
				dsNhanSu.add(ds);
			}
					
		}catch(Exception e) {
			System.out.println("Doc thanh cong");
			e.printStackTrace();
		}
		return dsNhanSu;
				
	}
	public boolean xoa(String maNS, String hoTen, String maPB){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			stmt = con.prepareStatement("exec xoanhansu ?,?,?");
			stmt.setString(1,maNS);
			stmt.setString(2,hoTen);
			stmt.setString(3,maPB);
			n = stmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("Không xóa được đâu");
			e.printStackTrace();
		
		}
		return n>0;
	}
	public boolean capNhat(String maNhanSu,String hoTen,String gioiTinh,String ngaySinh,String queQuan,String diaChiLienHe,String trangThai, String sdt, String soCmnd) {
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			stmt = con.prepareStatement("exec capnhatnhansu ?,?,?,?,?,?,?,?,?");
			stmt.setString(1, maNhanSu);
			stmt.setString(2,hoTen);
			stmt.setString(3, gioiTinh);
			stmt.setString(4, ngaySinh);
			stmt.setString(5, queQuan);
			stmt.setString(6, diaChiLienHe);
			stmt.setString(7, trangThai);		
			stmt.setString(8, sdt);
			stmt.setString(9, soCmnd);
			n = stmt.executeUpdate();

		}catch (SQLException e){
			System.out.println("Lỗi");
			e.printStackTrace();
		
		}
			return n>0;
	}
}
