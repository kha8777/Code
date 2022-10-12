package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.ThemDuAn;
import connectDB.ConnectDB;

public class QuanLiThemDuAn_DAO {
	ArrayList<ThemDuAn> dsThemDuAns;
	public QuanLiThemDuAn_DAO() {
		dsThemDuAns = new ArrayList<ThemDuAn>();
		ThemDuAn da = new ThemDuAn();
	}
	
	public ArrayList<ThemDuAn> bangDuAnThem(){
		try {
			Connection con= ConnectDB.getInstance().getconnection();
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery("select * from duAn");
			while(rs.next()) {
							
				String maDuAn= rs.getString(1);
				String tenDuAn= rs.getString(2);
				String chuDauTu= rs.getString(3);
				String trangThai= rs.getString(4);
				String ngayCapPhep= rs.getString(5);
				String ngayKhoiCong= rs.getString(6);
				String ngayHoanThanh= rs.getString(7);
				String diaDiemThiCong= rs.getString(8);
				String soLuongNhanSu= rs.getString(9);
				String ghiChu= rs.getString(10);
				System.out.println("Doc bang cong Thanh Cong");
				
				
				
				
				
				ThemDuAn ds= new ThemDuAn(maDuAn, tenDuAn, chuDauTu, trangThai, ngayCapPhep, ngayKhoiCong, ngayHoanThanh, diaDiemThiCong, soLuongNhanSu, ghiChu);
				dsThemDuAns.add(ds);
			}
					
		}catch(Exception e) {
			System.out.println("Doc khong thanh cong");
			e.printStackTrace();
		}
		return dsThemDuAns;
				
	}
	
	
	
	public boolean themDuAn(String tenDuAn,String chuDauTu,String trangThai, String ngayCapPhep,String ngayKhoiCong,String ngayHoanThanh,String diaDiemThiCong, String soLuongNhanSu,String ghiChu){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			stmt = con.prepareStatement("insert into duAn values(?,?,?,?,?,?,?,?,?)");
			
			stmt.setString(1, tenDuAn);
			stmt.setString(2, chuDauTu);
			stmt.setString(3, trangThai);
			stmt.setString(4, ngayCapPhep);
			stmt.setString(5, ngayKhoiCong);
			stmt.setString(6, ngayHoanThanh);
			stmt.setString(7, diaDiemThiCong);		
			stmt.setString(8, soLuongNhanSu);
			stmt.setString(9, ghiChu);

			
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

	public boolean XoaDuAn(String maDuAn){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			stmt = con.prepareStatement("  delete from duAn where maDuAn = ?");
			stmt.setString(1, maDuAn);
			

			
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
	
	public boolean capNhat(String tenDuAn,String chuDauTu,String trangThai, String ngayCapPhep,String ngayKhoiCong,String ngayHoanThanh,String diaDiemThiCong, String soLuongNhanSu,String ghiChu, String maDuAn) {
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement("update duAn set tenDuAn = ?,chuDauTu = ?,trangThai = ?,ngayCapPhep = ?,ngayKhoiCong = ?,ngayHoanThanh = ?"
					+ ",diaDiemThiCong = ?, "
					+ "soLuongNhanSu = ?, ghiChu = ? where maDuAn = ?");
			
		
			stmt.setString(1, tenDuAn);
			stmt.setString(2, chuDauTu);
			stmt.setString(3, trangThai);
			stmt.setString(4, ngayCapPhep);
			stmt.setString(5, ngayKhoiCong);
			stmt.setString(6, ngayHoanThanh);
			stmt.setString(7, diaDiemThiCong);		
			stmt.setString(8, soLuongNhanSu);
			stmt.setString(9, ghiChu);			
			stmt.setString(10, maDuAn);
			n = stmt.executeUpdate();
		}catch (SQLException e){
			System.out.println("Lỗi");
			e.printStackTrace();
		
		}
			return n>0;
	}
	
	
	
	
}
