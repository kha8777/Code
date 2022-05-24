package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;

public class PhongBan_DAO {
	public ArrayList<PhongBan> getAll() {
		ArrayList<PhongBan> ds = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from PhongBan";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String maPhong = rs.getString(1);
				String tenPhong = rs.getString(2);
				PhongBan pb = new PhongBan(maPhong, tenPhong);
				ds.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ds;
	}
}
