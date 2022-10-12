package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.PhongBan;
import Entity.PhongBan1;
import connectDB.ConnectDB;


public class QuanLiPhongBan_DAO {
	ArrayList<PhongBan>dsPhongban;
	public QuanLiPhongBan_DAO() {
		dsPhongban = new ArrayList<PhongBan>();
		PhongBan pb = new PhongBan();

		
	}
	public ArrayList<PhongBan> docpp() {
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from phongban");
			while(rs.next()) {
				String maphongban = rs.getString(1);	
				String tenphongban = rs.getString(2);	
				String truongphong = rs.getString(3);	
				String sonnhansu = rs.getString(4);	
				PhongBan tk = new PhongBan(maphongban,tenphongban,sonnhansu,truongphong);
				dsPhongban.add(tk);
				//System.out.println("Doc bang cong Thanh Cong");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return dsPhongban;
	}
	public boolean suaphongban(String mapp,String tentp){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		// ngayhoanthanh = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement(" update PhongBan set truongphong = ? where maphongban = ? ");
			stmt.setString(1, tentp);			
			stmt.setString(2, mapp);
			
			n = stmt.executeUpdate();

		}catch (SQLException e){
			System.out.println("phan cong khong thanh cong");
			e.printStackTrace();
			return false;
			
		}
			return n>0;
	}
}
