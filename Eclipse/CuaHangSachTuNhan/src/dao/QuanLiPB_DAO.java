package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.NhanSu;
import Entity.PhongBan1;
import connectDB.ConnectDB;

public class QuanLiPB_DAO {
	ArrayList<PhongBan1>dsPhongBan;
	public QuanLiPB_DAO(){
		dsPhongBan= new ArrayList<PhongBan1>();
		PhongBan1 ns= new PhongBan1();
	}
	public ArrayList<PhongBan1> bangPB(){
		try {
			Connection con= ConnectDB.getInstance().getconnection();
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery("Select [maPhongBan],[tenPhongBan],[soLuongNhanSu] from phongBan");
			while(rs.next()) {
				String maPhongBan= rs.getString(1);
				String tenPhongBan=rs.getString(2);
				String soLuongNguoi= rs.getString(3);
				
	
				PhongBan1 ds= new PhongBan1(maPhongBan,tenPhongBan,soLuongNguoi );
				dsPhongBan.add(ds);
			}
					
		}catch(Exception e) {
			System.out.println("Doc thanh cong");
			e.printStackTrace();
		}
		return dsPhongBan;
				
	}
}
