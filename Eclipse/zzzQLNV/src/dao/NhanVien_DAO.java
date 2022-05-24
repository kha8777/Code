package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_DAO {
	public NhanVien_DAO() {
		
	}
	
	public ArrayList<NhanVien> getAll() {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from NhanVien";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int ma = rs.getInt(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				
				PhongBan pb = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong, pb);
				ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ds;
	}
	
	public ArrayList<NhanVien> getNhanVienTheoMa(int id) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from NhanVien where maNV = ?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int ma = rs.getInt(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				
				PhongBan pb = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong, pb);
				ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ds;
	}
	
	public ArrayList<NhanVien> getNhanVienTheoMaPhongBan(String id) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from NhanVien where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int ma = rs.getInt(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				
				PhongBan pb = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong, pb);
				ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ds;
	}
	
	public boolean create(NhanVien nv) {
		int n = 0;
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "insert into NhanVien values (?, ?, ?, ?, ?, ?, ?)";
			statement = con.prepareStatement(sql);
			statement.setInt(1, nv.getMa());
			statement.setString(2, nv.getHo());
			statement.setString(3, nv.getTen());
			statement.setInt(4, nv.getTuoi());
			statement.setBoolean(5, nv.isPhai());
			statement.setDouble(6, nv.getLuong());
			statement.setString(7, nv.getPhongBan().getMaPhongBan());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return n > 0;
	}
	
	public boolean delete(int maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		
		try {
			statement = con.prepareStatement("delete from NhanVien where maNV = ?");
			statement.setInt(1, maNV);
		
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public boolean update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		
		try {
			statement = con.prepareStatement("update NhanVien set ho = ?, ten = ?, tuoi = ?, phai = ?, tienLuong = ?, maPhong = ? where maNV = ?");
			statement.setString(1, nv.getHo());
			statement.setString(2, nv.getTen());
			statement.setInt(3, nv.getTuoi());
			statement.setBoolean(4, nv.isPhai());
			statement.setDouble(5, nv.getLuong());
			statement.setString(6, nv.getPhongBan().getMaPhongBan());
			statement.setInt(7, nv.getMa());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	
}
