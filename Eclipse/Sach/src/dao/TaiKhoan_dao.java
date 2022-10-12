package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class TaiKhoan_dao {
	
	public ArrayList<TaiKhoan> getDSTK() {
		ArrayList<TaiKhoan> ds= new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			 String sql = "Select * from taiKhoan";
			 Statement statement = con.createStatement();
			 ResultSet rs = statement.executeQuery(sql);
			 while (rs.next()) {
				 String maTacGia = rs.getString(1);
				 String tenTacGia = rs.getString(2);
				 NhanVien nv = new NhanVien(rs.getString(3));
				 TaiKhoan tk = new TaiKhoan(maTacGia, tenTacGia, nv);
				 ds.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return ds;
	}
	private Connection con = null;
	private Statement stmt = null;
	
//	public List<TaiKhoan> getDSTK() {
//		List<TaiKhoan> ds = new ArrayList<TaiKhoan>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			String sql = "Select * from taiKhoan";
//			stmt = con.createStatement();
////			Statement statement = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				String maTacGia = rs.getString(1);
//				String tenTacGia = rs.getString(2);
//				NhanVien nv = new NhanVien(rs.getString(3));
//				TaiKhoan tk = new TaiKhoan(maTacGia, tenTacGia, nv);
//				ds.add(tk);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return ds;
//	}
	
//	public boolean suaTaiKhoan(TaiKhoan taiKhoan) {
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = con.prepareStatement("UPDATE taiKhoan SET MatKhau = ? WHERE TenTK = ?");
//			preparedStatement.setString(1, taiKhoan.getMatKhau());
//			preparedStatement.setString(2, taiKhoan.getTenTaiKhoan());
//			int resultExecute = preparedStatement.executeUpdate();
//			if (resultExecute > 0) {
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
}
