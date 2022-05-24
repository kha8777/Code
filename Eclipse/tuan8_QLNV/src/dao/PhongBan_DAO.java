package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;

public class PhongBan_DAO {
	public ArrayList<PhongBan> getAllTBPhongBan() {
		ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from PhongBan";
			Statement statement = con.createStatement();
			
			// Thực thi câu lệnh SQL trả về ResultSet
			ResultSet rs = statement.executeQuery(sql);

			// Duyệt trên kết quả trả về
			while (rs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
				String maPhong = rs.getString(1);
				String tenPhong = rs.getString(2);
				PhongBan pb = new PhongBan(maPhong, tenPhong);
				dsPhongBan.add(pb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhongBan;
	}
}
