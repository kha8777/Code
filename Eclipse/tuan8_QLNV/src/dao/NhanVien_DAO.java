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
	
	public ArrayList<NhanVien> getAllTBNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from NhanVien";
			Statement statement = con.createStatement();
			
			// Thực thi câu lệnh SQL trả về ResultSet
			ResultSet rs = statement.executeQuery(sql);

			// Duyệt trên kết quả trả về
			while (rs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
				int maNV = rs.getInt(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				
				PhongBan pb = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(maNV, ho, ten, tuoi, phai, luong, pb);
				dsNhanVien.add(nv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}
	
	public ArrayList<NhanVien> getNhanVienTheoMa(int id) {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from NhanVien where maNV = ?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			
			// Thực thi câu lệnh SQL trả về ResultSet
			ResultSet rs = statement.executeQuery();
			
			// Duyệt trên kết quả trả về
			while (rs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
				int maNV = rs.getInt(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				
				PhongBan pb = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(maNV, ho, ten, tuoi, phai, luong, pb);
				dsNhanVien.add(nv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return dsNhanVien;
	}
	
	public ArrayList<NhanVien> getNhanVienTheoPhongBan(String idpb) {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from NhanVien where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, idpb); 
			
			// Thực thi câu lệnh SQL trả về ResultSet
			ResultSet rs = statement.executeQuery();
			
			// Duyệt trên kết quả trả về
			while (rs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
				int maNV = rs.getInt(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				
				PhongBan pb = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(maNV, ho, ten, tuoi, phai, luong, pb);
				dsNhanVien.add(nv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return dsNhanVien;
	}

	public boolean create(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		
		try {
			statement = con.prepareStatement("insert into NhanVien values(?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, nv.getMaNV());
			statement.setString(2, nv.getHoNV());
			statement.setString(3, nv.getTenNV());
			statement.setInt(4, nv.getTuoi());
			statement.setBoolean(5, nv.getPhai());
			statement.setDouble(6, nv.getLuong());
			statement.setString(7, nv.getPhong().getMaPhongBan());
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
			statement.setString(1, nv.getHoNV());
			statement.setString(2, nv.getTenNV());
			statement.setInt(3, nv.getTuoi());
			statement.setBoolean(4, nv.getPhai());
			statement.setDouble(5, nv.getLuong());
			statement.setString(6, nv.getPhong().getMaPhongBan());
			statement.setInt(7, nv.getMaNV());
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
