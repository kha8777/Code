package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.TKDuAn;
import Entity.TKDuAnDaHoanThanh;
import Entity.TKNhanSu;
import Entity.TKNhanSuChuaThamGia;
import Entity.TKNhanSuDaThamGia;
import Entity.TKPhongBan;
import connectDB.ConnectDB;

public class QuanLiThongKe_DAO {
	ArrayList<TKDuAn>tkduan;
	ArrayList<TKNhanSu>tknhansu;
	ArrayList<TKDuAnDaHoanThanh>TKDuAnDaHoanThanh;
	ArrayList<TKNhanSuChuaThamGia>TKNhanSuChuaThamGia;
	ArrayList<TKNhanSuDaThamGia>TKNhanSuDaThamGia;
	ArrayList<TKPhongBan>TKPhongBan;
	public QuanLiThongKe_DAO() {
		tkduan = new ArrayList<TKDuAn>();
		TKDuAn tkda = new TKDuAn();
		tknhansu = new ArrayList<TKNhanSu>();
		TKNhanSu tkns = new TKNhanSu();		
		TKDuAnDaHoanThanh = new ArrayList<TKDuAnDaHoanThanh>();
		TKDuAnDaHoanThanh tkdaht = new TKDuAnDaHoanThanh();
		TKNhanSuChuaThamGia = new ArrayList<TKNhanSuChuaThamGia>();
		TKNhanSuChuaThamGia tknsctg = new TKNhanSuChuaThamGia();
		TKNhanSuDaThamGia = new ArrayList<TKNhanSuDaThamGia>();
		TKNhanSuDaThamGia tknsdtg = new TKNhanSuDaThamGia();
		TKPhongBan = new ArrayList<TKPhongBan>();
		TKPhongBan tkpb = new TKPhongBan();		
	}
	public ArrayList<TKDuAn> tkduan() {
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(" select COUNT(maDuAn) from duAn");
			while(rs.next()) {
				String a = rs.getString(1);		
				TKDuAn tk = new TKDuAn(a); 
				tkduan.add(tk);
				//System.out.println("Doc bang cong Thanh Cong");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
		return tkduan;
	}
	public ArrayList<TKNhanSu> tknhansu() {
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select COUNT(maNhanSu) from [dbo].[nhanSu]");
			while(rs.next()) {
				String a = rs.getString(1);		
				TKNhanSu tk = new TKNhanSu(a); 
				tknhansu.add(tk);
				//System.out.println("Doc bang cong Thanh Cong");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return tknhansu;
	}
	public ArrayList<TKDuAnDaHoanThanh> TKDuAnDaHoanThanh() {
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select COUNT(maDuAn) from duAn where trangThai = 'Hoan Thanh'");
			while(rs.next()) {
				String a = rs.getString(1);		
				TKDuAnDaHoanThanh tk = new TKDuAnDaHoanThanh(a); 
				TKDuAnDaHoanThanh.add(tk);
				//System.out.println("Doc bang cong Thanh Cong");	
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return TKDuAnDaHoanThanh;
	}
	
	public ArrayList<TKNhanSuChuaThamGia> TKNhanSuChuaThamGia() {
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select COUNT(maNhanSu) from [dbo].[nhanSu] where trangThai = 0");
			while(rs.next()) {
				String a = rs.getString(1);		
				TKNhanSuChuaThamGia tk = new TKNhanSuChuaThamGia(a); 
				TKNhanSuChuaThamGia.add(tk);
				//System.out.println("Doc bang cong Thanh Cong");	
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	return TKNhanSuChuaThamGia;
	}
	public ArrayList<TKNhanSuDaThamGia>TKNhanSuDaThamGia(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(" select COUNT(maNhanSu) from [dbo].[nhanSu] where trangThai = 1");
			while(rs.next()) {
				String a = rs.getString(1);		
				TKNhanSuDaThamGia tk = new TKNhanSuDaThamGia(a); 
				TKNhanSuDaThamGia.add(tk);
			//	System.out.println("Doc bang cong Thanh Cong");	
		}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	
		return TKNhanSuDaThamGia;
	}
	
	public ArrayList<TKPhongBan>TKPhongBan() {
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select COUNT(maPhongBan) from phongBan");
			while(rs.next()) {
				String a = rs.getString(1);		
				TKPhongBan tk = new TKPhongBan(a); 
				TKPhongBan.add(tk);
			//	System.out.println("Doc bang cong Thanh Cong");	
		}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return TKPhongBan;
	}
	
}
