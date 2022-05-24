package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.CongViecChoDuAn;
import connectDB.ConnectDB;

public class QuanLiCongViec_DAO {
	ArrayList<CongViecChoDuAn> congViecs;
	public QuanLiCongViec_DAO() {
		// TODO Auto-generated constructor stub
		congViecs = new ArrayList<CongViecChoDuAn>();
		CongViecChoDuAn cv = new CongViecChoDuAn();
	}
	
	//select  cv.[maCongViec],da.[maDuAn],[soLuongNhanSuCV],[CongViec],[soLuongNhanSuHienCo],[ngayThamGiaCongviec] from [dbo].[congViec] cv join [dbo].[duAn] da on cv.maDuAn= da.maDuAn
	
	public ArrayList<CongViecChoDuAn> bangCongViec(){
		try {
			Connection con= ConnectDB.getInstance().getconnection();
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery("select  cv.[maCongViec],da.[maDuAn],[soLuongNhanSuCV],[CongViec],[soLuongNhanSuHienCo],[ngayThamGiaCongviec], [ngayHoanThanhCongviec],[trangthaicv] from [dbo].[congViec] cv join [dbo].[duAn] da on cv.maDuAn= da.maDuAn");
			while(rs.next()) {
							
				String maCongViec= rs.getString(1);
				String maDuAn= rs.getString(2);
				String soLuongNhanSuCV= rs.getString(3);
				String congViec= rs.getString(4);
				String soLuongNhanSuHienCo= rs.getString(5);
				String ngayThamGiaCongViec= rs.getString(6);
				String ngayHoanThanhCongViec = rs.getString(7);
				String trangThaiCV = rs.getString(8);
				System.out.println("Doc bang cong Thanh Cong");
				
				CongViecChoDuAn cv = new CongViecChoDuAn(maCongViec, maDuAn, soLuongNhanSuCV, congViec, soLuongNhanSuHienCo, ngayThamGiaCongViec, ngayHoanThanhCongViec, trangThaiCV);
				congViecs.add(cv);

			}
					
		}catch(Exception e) {
			System.out.println("Doc khong thanh cong");
			e.printStackTrace();
		}
		return congViecs;
				
	}
	public ArrayList<CongViecChoDuAn> bangCongViec1(){
		try {
			Connection con= ConnectDB.getInstance().getconnection();
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery("select  cv.[maCongViec],da.[maDuAn],[soLuongNhanSuCV],[CongViec],[soLuongNhanSuHienCo],[ngayThamGiaCongviec], [ngayHoanThanhCongviec],[trangthaicv] from [dbo].[congViec] cv join [dbo].[duAn] da on cv.maDuAn= da.maDuAn  where trangthaicv != 'Hoan Thanh'");
			while(rs.next()) {
							
				String maCongViec= rs.getString(1);
				String maDuAn= rs.getString(2);
				String soLuongNhanSuCV= rs.getString(3);
				String congViec= rs.getString(4);
				String soLuongNhanSuHienCo= rs.getString(5);
				String ngayThamGiaCongViec= rs.getString(6);
				String ngayHoanThanhCongViec = rs.getString(7);
				String trangThaiCV = rs.getString(8);
				System.out.println("Doc bang cong Thanh Cong");
				
				CongViecChoDuAn cv = new CongViecChoDuAn(maCongViec, maDuAn, soLuongNhanSuCV, congViec, soLuongNhanSuHienCo, ngayThamGiaCongViec, ngayHoanThanhCongViec, trangThaiCV);
				congViecs.add(cv);

			}
					
		}catch(Exception e) {
			System.out.println("Doc khong thanh cong");
			e.printStackTrace();
		}
		return congViecs;
				
	}
	public boolean themCongViec( String maDuAn, String soLuongNhanSuCV, String congViec,
			String soLuongNhanSuHienCo, String ngayThamGiaCongViec, String ngayHoanThanhCongViec, String trangThaiCV){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			//stmt = con.prepareStatement(" SET IDENTITY_INSERT congViec ON");
		stmt = 	con.prepareStatement("insert into congViec values(?,?,?,?,?,?,?)");
		//	con.prepareStatement(" SET IDENTITY_INSERT congViec OFF");
			stmt.setString(1, maDuAn);
			stmt.setString(2, soLuongNhanSuCV);
			stmt.setString(3, congViec);
			stmt.setString(4, soLuongNhanSuHienCo);
			stmt.setString(5, ngayThamGiaCongViec);
			stmt.setString(6,ngayHoanThanhCongViec );
			stmt.setString(7,trangThaiCV);

			
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
	
	
	
	public boolean XoaCongViec(String maCongViec){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			stmt = con.prepareStatement("  delete from congViec where macongViec = ?");
			stmt.setString(1, maCongViec);
			

			
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

	
	
	public boolean capNhat( String maDuAn, String soLuongNhanSuCV, String congViec,
			String soLuongNhanSuHienCo, String ngayThamGiaCongViec, String ngayHoanThanhCongViec, String trangThaiCV, String maCongViec) {
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement("update congViec set maDuAn = ?,soLuongNhanSuCV = ?,congViec = ?,soLuongNhanSuHienCo = ?,ngayThamGiaCongViec = ?,ngayHoanThanhCongViec = ?"
					+ ",trangThaiCV = ? where maCongViec = ?");
			
		
			stmt.setString(1, maDuAn);
			stmt.setString(2, soLuongNhanSuCV);
			stmt.setString(3, congViec);
			stmt.setString(4, soLuongNhanSuHienCo);
			stmt.setString(5, ngayThamGiaCongViec);
			stmt.setString(6,ngayHoanThanhCongViec );
			stmt.setString(7,trangThaiCV);	
			stmt.setString(8, maCongViec);
			n = stmt.executeUpdate();
		}catch (SQLException e){
			System.out.println("Lỗi");
			e.printStackTrace();
		
		}
			return n>0;
	}
	
	

	
	
	
}
