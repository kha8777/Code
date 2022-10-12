package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.BangCong;
import Entity.BangCongLuanChuyen;
import Entity.CongViec;
import Entity.CongViecCC;
import Entity.DuAnPC;
import Entity.NgayCongNhanSu;
import Entity.NhanSuPC;
import connectDB.ConnectDB;
import ui.GiaoDienChamCong;
import ui.GiaoDienLuanChuyen;
import ui.GiaoDienPhanCong;

public class QuanLiPhanCong_DAO {
	ArrayList<NgayCongNhanSu>dsNgayCong;
	ArrayList<BangCong>dsBangCong;
	ArrayList<DuAnPC>dsDuAn;
	ArrayList<NhanSuPC>dsNhanSu;
	ArrayList<BangCongLuanChuyen>dsBangCongLc;
	ArrayList<CongViec>dscongviec;
	ArrayList<CongViecCC>dscongviecCC;
	public QuanLiPhanCong_DAO() {
		dsBangCong = new ArrayList<BangCong>();
		BangCong da = new BangCong();
		dsNgayCong = new ArrayList<NgayCongNhanSu>();
		NgayCongNhanSu NC = new NgayCongNhanSu();
		dsDuAn = new ArrayList<DuAnPC>();
		DuAnPC bc = new DuAnPC();		
		dsNhanSu = new ArrayList<NhanSuPC>();
		NhanSuPC ns = new NhanSuPC();
		dsBangCongLc = new ArrayList<BangCongLuanChuyen>();
		BangCongLuanChuyen bclc = new BangCongLuanChuyen();
		dscongviec = new ArrayList<CongViec>();
		CongViec cv = new CongViec();
		dscongviecCC = new ArrayList<CongViecCC>();
		CongViecCC cvCC = new CongViecCC();
	}
	public ArrayList<BangCong> docBangCongTheoMaCongViec(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM bangCong where maCongViec = '"+GiaoDienPhanCong.getTxtMaCongViec().getText()+"'");
			while(rs.next()) {
				String mabangcong = rs.getString(1);
				String manhansu = rs.getString(2);
				String maduan = rs.getString(3);
				String ngaythamgia = rs.getString(4);
				String ngayhoanthanh = rs.getString(5);
				String songaycong = rs.getString(6);
				
				BangCong bc = new BangCong(mabangcong,manhansu,maduan,ngaythamgia,ngayhoanthanh,songaycong); 
				dsBangCong.add(bc);
				System.out.println("Doc bang cong Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc khong bangcong ko Thanh Cong");
			e.printStackTrace();
		}
		return dsBangCong;
	}
	public ArrayList<NgayCongNhanSu> docNgayCongNhanSuDA(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select maNgayCong,nc.[maNhanSu],ns.hoTen,da.tenduan,congViec ,nc.[ngayThamGiaCongViec],nc.[ngayHoanThanhCongViec] ,nc.[SoNgayCong] from\r\n" + 
					" NgayCongNhanSu nc join congViec vc on vc.maCongViec = nc.maCongViec join nhansu ns on ns.maNhanSu = nc.maNhanSu join\r\n" + 
					" duAn da on da.maDuAn = vc.maduan where da.maduan ='"+GiaoDienChamCong.getTxtMaDuAn().getText()+"'");
			// where cv.maduan = '"+GiaoDienChamCong.getTxtMaDuAn().getText()+"'
			while(rs.next()) {
				String mangaycong = rs.getString(1);
				String manhansu = rs.getString(2);
				String hoten = rs.getString(3);
				String tenduan = rs.getString(4);
				String macongviec = rs.getString(5);			
				String ngaythamgia = rs.getString(6);
				String ngayhoanthanh = rs.getString(7);
				String songaycong = rs.getString(8);				
				NgayCongNhanSu bc = new NgayCongNhanSu(mangaycong,manhansu,hoten,tenduan,macongviec,ngaythamgia,ngayhoanthanh,songaycong); 
				dsNgayCong.add(bc);
				System.out.println("Doc bang ngay cong Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc khong bang ngay cong ko Thanh Cong");
			e.printStackTrace();
		}
		return dsNgayCong;
	}
	public ArrayList<NgayCongNhanSu> docNgayCongNhanSuCV(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select maNgayCong,nc.[maNhanSu],ns.hoTen,da.tenduan,congViec ,nc.[ngayThamGiaCongViec],nc.[ngayHoanThanhCongViec] ,nc.[SoNgayCong] from\r\n" + 
					" NgayCongNhanSu nc join congViec vc on vc.maCongViec = nc.maCongViec join nhansu ns on ns.maNhanSu = nc.maNhanSu join\r\n" + 
					" duAn da on da.maDuAn = vc.maduan where vc.macongviec ='"+GiaoDienChamCong.getTxtMaCongViec().getText()+"'");
			// where cv.maduan = '"+GiaoDienChamCong.getTxtMaDuAn().getText()+"'
			while(rs.next()) {
				String mangaycong = rs.getString(1);
				String manhansu = rs.getString(2);
				String hoten = rs.getString(3);
				String tenduan = rs.getString(4);
				String macongviec = rs.getString(5);			
				String ngaythamgia = rs.getString(6);
				String ngayhoanthanh = rs.getString(7);
				String songaycong = rs.getString(8);				
				NgayCongNhanSu bc = new NgayCongNhanSu(mangaycong,manhansu,hoten,tenduan,macongviec,ngaythamgia,ngayhoanthanh,songaycong); 
				dsNgayCong.add(bc);
				System.out.println("Doc bang ngay cong Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc khong bang ngay cong ko Thanh Cong");
			e.printStackTrace();
		}
		return dsNgayCong;
	}
	public ArrayList<BangCong> doctatcabangcong(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM bangCong ");
			while(rs.next()) {
				String mabangcong = rs.getString(1);
				String manhansu = rs.getString(2);
				String maduan = rs.getString(3);
				String ngaythamgia = rs.getString(4);
				String ngayhoanthanh = rs.getString(5);
				String songaycong = rs.getString(6);
				
				BangCong bc = new BangCong(mabangcong,manhansu,maduan,ngaythamgia,ngayhoanthanh,songaycong); 
				dsBangCong.add(bc);
				System.out.println("Doc bang cong Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc khong bangcong ko Thanh Cong");
			e.printStackTrace();
		}
		return dsBangCong;
	}
	public ArrayList<BangCongLuanChuyen> docbangcongtheomaduanLC(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select [maBangCong],ns.[maNhanSu],[hoTen],[SoNgayCong],[ngayThamGiaCongTrinh],ns.[trangThai],c.[vaiTro],cv.[maDuAn],cv.maCongViec,da.soLuongNhanSu\r\n" + 
					"					from [dbo].[bangCong] bc join [dbo].[congViec] cv on cv.maCongViec = bc.maCongViec join [dbo].[nhanSu] ns on bc.maNhanSu = ns.maNhanSu join [dbo].[chucVu] c\r\n" + 
					"					on ns.maChucVu = c.maChucVu join [dbo].[duAn] da on cv.maDuAn = da.maDuAn where ns.[trangThai] = 1 and cv.maduan ='"+GiaoDienLuanChuyen.getTxtMaDuAn().getText()+"'");
			while(rs.next()) {
				String mabangcong = rs.getString(1);
				String manhansu = rs.getString(2);
				String hoten = rs.getString(3);
				String songaycong = rs.getString(4);
				String ngaythamgia = rs.getString(5);
				String trangthains = rs.getString(6);
				String chucvu = rs.getString(7);
				String maduan = rs.getString(8);
				String sonhansu = rs.getString(9);
				String trangthaida = rs.getString(10);
				BangCongLuanChuyen bclc = new BangCongLuanChuyen(mabangcong,manhansu,hoten,songaycong,ngaythamgia,trangthains,chucvu  ,maduan,sonhansu,trangthaida); 
				dsBangCongLc.add(bclc);
				System.out.println("Doc bang cong lC Thanh Cong");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Doc khong bangcong lc ko Thanh Cong");
			e.printStackTrace();
		}
		return dsBangCongLc;
	}
	
	public ArrayList<BangCongLuanChuyen> doctatcabangcongLC(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select [maBangCong],ns.[maNhanSu],[hoTen],[SoNgayCong],[ngayThamGiaCongTrinh],ns.[trangThai],c.[vaiTro],cv.[maDuAn],cv.maCongViec,da.soLuongNhanSu\r\n" + 
					"					from [dbo].[bangCong] bc join [dbo].[congViec] cv on cv.maCongViec = bc.maCongViec join [dbo].[nhanSu] ns on bc.maNhanSu = ns.maNhanSu join [dbo].[chucVu] c\r\n" + 
					"					on ns.maChucVu = c.maChucVu join [dbo].[duAn] da on cv.maDuAn = da.maDuAn where ns.[trangThai] = 1");
			while(rs.next()) {
				String mabangcong = rs.getString(1);
				String manhansu = rs.getString(2);
				String hoten = rs.getString(3);
				String songaycong = rs.getString(4);
				String ngaythamgia = rs.getString(5);
				String trangthains = rs.getString(6);
				String chucvu = rs.getString(7);
				String maduan = rs.getString(8);
				String sonhansu = rs.getString(9);
				String trangthaida = rs.getString(10);
				BangCongLuanChuyen bclc = new BangCongLuanChuyen(mabangcong,manhansu,hoten,songaycong,ngaythamgia,trangthains,chucvu  ,maduan,sonhansu,trangthaida); 
				dsBangCongLc.add(bclc);
				System.out.println("Doc bang cong lC Thanh Cong");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Doc khong bangcong lc ko Thanh Cong");
			e.printStackTrace();
		}
		return dsBangCongLc;
	}
	public ArrayList<BangCong> docbangcongtheomaduan(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM bangCong bc join congviec vc on bc.macongviec = vc.macongviec where maduan ='"+GiaoDienPhanCong.getTxtMaDuAn().getText()+"'");
			while(rs.next()) {
				String mabangcong = rs.getString(1);
				String manhansu = rs.getString(2);
				String maduan = rs.getString(3);
				String ngaythamgia = rs.getString(4);
				String ngayhoanthanh = rs.getString(5);
				String songaycong = rs.getString(6);
				
				BangCong bc = new BangCong(mabangcong,manhansu,maduan,ngaythamgia,ngayhoanthanh,songaycong); 
				dsBangCong.add(bc);
				System.out.println("Doc bang cong Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc khong bangcong ko Thanh Cong");
			e.printStackTrace();
		}
		return dsBangCong;
	}
	public ArrayList<CongViec> docCongViec(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select  [maCongViec],[maDuAn],[soLuongNhanSuCV],[CongViec],"
					+ "[soLuongNhanSuHienCo],[ngayThamGiaCongviec]  from congViec where maDuAn = "+"'"+GiaoDienPhanCong.getTxtMaDuAn().getText()+"'");
			
			while(rs.next()) {
				String macongviec = rs.getString(1);
				String maduan = rs.getString(2);
				String slcv = rs.getString(3);
				String congviec = rs.getString(4);
				String slht = rs.getString(5);		
				String ngaythamgia = rs.getString(6);	
				CongViec bc = new CongViec(macongviec, maduan ,slcv,congviec,slht,ngaythamgia); 
				dscongviec.add(bc);
				System.out.println("Doc bang cong viec Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc khong cong viec ko Thanh Cong");
			e.printStackTrace();
		}
		return dscongviec;
	}
	public ArrayList<CongViecCC> docCongViecCC(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select  * from congViec where trangthaicv = 'Dang Thi Cong' and maDuAn = "+"'"+GiaoDienChamCong.getTxtMaDuAn().getText()+"'");
			//ResultSet rs = statement.executeQuery("select * from congViec where maDuAn = 'DA1'");
			while(rs.next()) {
				String macongviec = rs.getString(1);
				String maduan = rs.getString(2);
				String slcv = rs.getString(3);
				String congviec = rs.getString(4);
				String slht = rs.getString(5);		
				String ngaythamgia = rs.getString(6);
				String ngayhoanthanh = rs.getString(7);
				String trangthai = rs.getString(8);
				CongViecCC bc = new CongViecCC(macongviec, maduan ,slcv,congviec,slht,ngaythamgia,ngayhoanthanh,trangthai); 
				dscongviecCC.add(bc);
				System.out.println("Doc bang cong viec Thanh Cong");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Doc khong cong viec ko Thanh Cong");
			e.printStackTrace();
		}
		return dscongviecCC;
	}
	public ArrayList<CongViecCC> docCongViecTrangThaiCC(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select  * from congViec where trangthaicv = 'Hoan Thanh' and maDuAn = "+"'"+GiaoDienChamCong.getTxtMaDuAn().getText()+"'");
			//ResultSet rs = statement.executeQuery("select * from congViec where maDuAn = 'DA1'");
			while(rs.next()) {
				String macongviec = rs.getString(1);
				String maduan = rs.getString(2);
				String slcv = rs.getString(3);
				String congviec = rs.getString(4);
				String slht = rs.getString(5);		
				String ngaythamgia = rs.getString(6);
				String ngayhoanthanh = rs.getString(7);
				String trangthai = rs.getString(8);
				CongViecCC bc = new CongViecCC(macongviec, maduan ,slcv,congviec,slht,ngaythamgia,ngayhoanthanh,trangthai); 
				dscongviecCC.add(bc);
				System.out.println("Doc bang cong viec Thanh Cong");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Doc khong cong viec ko Thanh Cong");
			e.printStackTrace();
		}
		return dscongviecCC;
	}
	public ArrayList<CongViec> docCongViecLC(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select  [maCongViec],[maDuAn],[soLuongNhanSuCV],[CongViec],"
					+ "[soLuongNhanSuHienCo],[ngayThamGiaCongviec]  from congViec where maDuAn = "+"'"+GiaoDienLuanChuyen.getTxtMaDuAn().getText()+"'");
			//ResultSet rs = statement.executeQuery("select * from congViec where maDuAn = 'DA1'");
			while(rs.next()) {
				String macongviec = rs.getString(1);
				String maduan = rs.getString(2);
				String slcv = rs.getString(3);
				String congviec = rs.getString(4);
				String slht = rs.getString(5);		
				String ngaythamgia = rs.getString(6);	
				CongViec bc = new CongViec(macongviec, maduan ,slcv,congviec,slht,ngaythamgia); 
				dscongviec.add(bc);
				System.out.println("Doc bang cong viec Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc khong cong viec ko Thanh Cong");
			e.printStackTrace();
		}
		return dscongviec;
	}
	public ArrayList<CongViec> docCongViectheovaitro(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select  [maCongViec],[maDuAn],[soLuongNhanSuCV],[CongViec],[soLuongNhanSuHienCo]"
					+ ",[ngayThamGiaCongviec]  from congViec where maDuAn = "+"'"+GiaoDienPhanCong.getTxtMaDuAn().getText()+"' "
							+ "and congviec = N'"+GiaoDienPhanCong.getComboBoxLoaiCongViec().getSelectedItem().toString()+"'");
			//ResultSet rs = statement.executeQuery("select * from congViec where maDuAn = 'DA1'");
			while(rs.next()) {
				String macongviec = rs.getString(1);
				String maduan = rs.getString(2);
				String slcv = rs.getString(3);
				String congviec = rs.getString(4);
				String slht = rs.getString(5);		
				String ngaythamgia = rs.getString(6);	
				CongViec bc = new CongViec(macongviec, maduan ,slcv,congviec,slht,ngaythamgia); 
				dscongviec.add(bc);
				System.out.println("Doc bang cong viec Thanh Cong");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Doc khong cong viec ko Thanh Cong");
			e.printStackTrace();
		}
		return dscongviec;
	}
	public ArrayList<CongViec> docCongViectheovaitro1(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select  [maCongViec],[maDuAn],[soLuongNhanSuCV],[CongViec],[soLuongNhanSuHienCo]"
					+ ",[ngayThamGiaCongviec]  from congViec where maDuAn = "+"'"+GiaoDienLuanChuyen.getTxtMaDuAn().getText()+"' "
							+ "and congviec = N'"+GiaoDienLuanChuyen.getComboBoxLoaiCongViec().getSelectedItem().toString()+"'");
			//ResultSet rs = statement.executeQuery("select * from congViec where maDuAn = 'D comboBoxLoaiCongViec;A1'");
			while(rs.next()) {
				String macongviec = rs.getString(1);
				String maduan = rs.getString(2);
				String slcv = rs.getString(3);
				String congviec = rs.getString(4);
				String slht = rs.getString(5);		
				String ngaythamgia = rs.getString(6);	
				CongViec bc = new CongViec(macongviec, maduan ,slcv,congviec,slht,ngaythamgia); 
				dscongviec.add(bc);
				System.out.println("Doc bang cong viec Thanh Cong");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Doc khong cong viec ko Thanh Cong");
			e.printStackTrace();
		}
		return dscongviec;
	}
	public ArrayList<CongViec> docCongViec1(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from congViec where maDuAn = "+"'"+GiaoDienLuanChuyen.getTxtMaDuAn().getText()+"'");
			//ResultSet rs = statement.executeQuery("select * from congViec where maDuAn = 'DA1'");
			while(rs.next()) {
				String macongviec = rs.getString(1);
				String maduan = rs.getString(2);
				String slcv = rs.getString(3);
				String congviec = rs.getString(4);
				String slht = rs.getString(5);							
				String ngaythamgia = rs.getString(6);	
				CongViec bc = new CongViec(macongviec, maduan ,slcv,congviec,slht,ngaythamgia); 
				dscongviec.add(bc);
				System.out.println("Doc bang cong viec Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc khong cong viec ko Thanh Cong");
			e.printStackTrace();
		}
		return dscongviec;
	}
	public ArrayList<BangCongLuanChuyen> docBangCongLuanChuyentheocongviec(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("\r\n" + 
					"select [maBangCong],ns.[maNhanSu],[hoTen],[SoNgayCong],[ngayThamGiaCongTrinh],ns.[trangThai],c.[vaiTro],cv.[maDuAn],cv.maCongViec,da.soLuongNhanSu\r\n" + 
					"					from [dbo].[bangCong] bc join [dbo].[congViec] cv on cv.maCongViec = bc.maCongViec join [dbo].[nhanSu] ns on bc.maNhanSu = ns.maNhanSu join [dbo].[chucVu] c\r\n" + 
					"					on ns.maChucVu = c.maChucVu join [dbo].[duAn] da on cv.maDuAn = da.maDuAn where ns.[trangThai] = 1 and vaitro = N'"+GiaoDienLuanChuyen.getCongviec().toString()+"' and cv.maduan != '"+GiaoDienLuanChuyen.getTxtMaDuAn().getText()+"'");
			while(rs.next()) {
				String mabangcong = rs.getString(1);
				String manhansu = rs.getString(2);
				String hoten = rs.getString(3);
				String songaycong = rs.getString(4);
				String ngaythamgia = rs.getString(5);
				String trangthains = rs.getString(6);
				String chucvu = rs.getString(7);
				String maduan = rs.getString(8);
				String sonhansu = rs.getString(9);
				String trangthaida = rs.getString(10);
				BangCongLuanChuyen bclc = new BangCongLuanChuyen(mabangcong,manhansu,hoten,songaycong,ngaythamgia,trangthains,chucvu  ,maduan,sonhansu,trangthaida); 
				dsBangCongLc.add(bclc);
				System.out.println("Doc bang cong lC Thanh Cong");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Doc khong bangcong lc ko Thanh Cong");
			e.printStackTrace();
		}
		return dsBangCongLc;
	}
	public ArrayList<DuAnPC> docBangDuAn(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("\r\n" + 
					" select [maDuAn],[tenDuAn],[ngayCapPhep],[soLuongNhanSu],[trangThai] from [dbo].[duAn] where trangthai = 'Dang Thi Cong'");
			while(rs.next()) {
				String maDuAn = rs.getString(1);
				String tenDuAn = rs.getString(2);
				String ngaycapphep = rs.getString(3);
				String soNhanSu = rs.getString(4);
				String trangThai = rs.getString(5);
			
				
				DuAnPC da = new DuAnPC(maDuAn,tenDuAn,ngaycapphep, soNhanSu ,trangThai); 
				dsDuAn.add(da);
				System.out.println("Doc bang cong Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc da ko Thanh Cong");
			e.printStackTrace();
		}
		return dsDuAn;
	}
	public ArrayList<NhanSuPC> docNhanSu(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select [maNhanSu],[hoTen],[trangThai],[chucVu],vaitro from [dbo].[nhanSu] n join [dbo].[chucVu] c on n.maChucVu = c.maChucVu where trangThai = 0 and vaiTro = N'"+GiaoDienPhanCong.getLoaiCongViec()+"'");
			while(rs.next()) {
				String manhansu = rs.getString(1);
				String tennhansu = rs.getString(2);
				String trangthai = rs.getString(3);
				String chucvu = rs.getString(4);
				String vaitro = rs.getString(5);
				NhanSuPC ns = new NhanSuPC(manhansu,tennhansu,trangthai,chucvu,vaitro); 
				dsNhanSu.add(ns);
				System.out.println("Doc bang ns Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc  ns ko Thanh Cong");
			e.printStackTrace();
		}
		return dsNhanSu;
	}
	public ArrayList<NhanSuPC> docNhanSuCC(){
		try {
			Connection con = ConnectDB.getInstance().getconnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select bc.[maNhanSu],[hoTen],[vaiTro],trangThai,gioiTinh from [dbo].[nhanSu] ns join [chucVu] cv \r\n" + 
					"on cv.maChucVu = ns.maChucVu join bangCong bc on bc.maNhanSu = ns.maNhanSu\r\n" + 
					"join congViec vv on vv.maCongViec = bc.maCongViec where bc.maCongViec = '"+GiaoDienChamCong.getTxtMaCongViec().getText() +"'");
			while(rs.next()) {
				String manhansu = rs.getString(1);
				String tennhansu = rs.getString(2);
				String trangthai = rs.getString(3);
				String chucvu = rs.getString(4);
				String vaitro = rs.getString(5);
				NhanSuPC ns = new NhanSuPC(manhansu,tennhansu,trangthai,chucvu,vaitro); 
				dsNhanSu.add(ns);
				System.out.println("Doc bang ns Thanh Cong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Doc  ns ko Thanh Cong");
			e.printStackTrace();
		}
		return dsNhanSu;
	}
	public boolean PhanCong(String manhansu ,String maduan,String ngaythamgia ,String ngayhoanthanh ,String songaycong,String maCongViec ){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		// ngayhoanthanh = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement("exec phancong ?,?,?,?,?,?");
			
			stmt.setString(1, manhansu);
			stmt.setString(2, maduan);
			stmt.setString(3, ngaythamgia );
			stmt.setString(4, ngayhoanthanh);
			stmt.setString(5, songaycong);
			stmt.setString(6, maCongViec);
			n = stmt.executeUpdate();

		}catch (SQLException e){
			System.out.println("phan cong khong thanh cong");
			e.printStackTrace();
			return false;
			
		}
			return n>0;
	}
	public boolean PhanCongMany(String maduan,String ngaythamgia ,String ngayhoanthanh ,String songaycong,String maCongViec ,String Congviec){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		// ngayhoanthanh = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement("exec phancongMany ?,?,?,?,?,?");
			
			stmt.setString(1, maduan);
			stmt.setString(2, ngaythamgia );
			stmt.setString(3, ngayhoanthanh);
			stmt.setString(4, songaycong);
			stmt.setString(5, maCongViec);
			stmt.setString(6, Congviec);
			n = stmt.executeUpdate();

		}catch (SQLException e){
			System.out.println("phan cong many khong thanh cong");
			e.printStackTrace();
			return false;
			
		}
			return n>0;
	}
	public boolean LuanChuyen(String mabangcong ,String maduan ,String macongviec ,String manhansu ,String ngayhoanthanh){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement("exec luanchuyen ?,?,?,?,?");
			stmt.setString(1, mabangcong);			
			stmt.setString(2, maduan);
			stmt.setString(3,macongviec);
			stmt.setString(4, manhansu);
			stmt.setString(5,  ngayhoanthanh);
			
			n = stmt.executeUpdate();

		}catch (SQLException e){
			System.out.println("luan chuyen khong thanh cong");
			e.printStackTrace();
			return false;
			
		}
			return n>0;
	}
	public boolean ChamCongNhanSu(String maduan ,String congviec ,String ngayhoanthanh,int NgayCong){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement("exec chamcongnhansu ?,?,?,?");
				
			stmt.setString(1, maduan);		
			stmt.setString(2,congviec);
			stmt.setString(3,  ngayhoanthanh);
			stmt.setInt(4,  NgayCong);
			n = stmt.executeUpdate();

		}catch (SQLException e){
			System.out.println("chamcongnhansu khong thanh cong");
			e.printStackTrace();
			return false;
			
		}
			return n>0;
	}
	public boolean congnc(String mangaycong){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement("exec  congngaycong ?");
					
			stmt.setString(1, mangaycong);			
			n = stmt.executeUpdate();

		}catch (SQLException e){
			System.out.println("+ khong thanh cong");
			e.printStackTrace();
			return false;
			
		}
			return n>0;
	}
	public boolean congncCV(String mangaycong){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement("exec  congngaycongtheocongviec ?");
					
			stmt.setString(1, mangaycong);			
			n = stmt.executeUpdate();

		}catch (SQLException e){
			System.out.println("+ khong thanh cong");
			e.printStackTrace();
			return false;
			
		}
			return n>0;
	}
	public boolean truncCV(String mangaycong){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement("exec  trungaycongtheocongviec ?");
					
			stmt.setString(1, mangaycong);			
			n = stmt.executeUpdate();

		}catch (SQLException e){
			System.out.println("+ khong thanh cong");
			e.printStackTrace();
			return false;
			
		}
			return n>0;
	}
	public boolean trunc(String mangaycong){
		Connection con = ConnectDB.getInstance().getconnection();
		PreparedStatement stmt = null;
		int n = 0;
		try{
			
			stmt = con.prepareStatement("exec  trungaycong ?");
					
			stmt.setString(1, mangaycong);
			
			n = stmt.executeUpdate();

		}catch (SQLException e){
			System.out.println("- khong thanh cong");
			e.printStackTrace();
			return false;
			
		}
			return n>0;
	}

/*public ArrayList<BangCongLuanChuyen> docBangCongDiemDanh(){
	try {
		Connection con = KetNoiDatabase.getInstance().getconnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery("select [maBangCong],ns.[maNhanSu],[hoTen],[SoNgayCong],[ngayThamGiaCongTrinh],ns.[trangThai],[chucVu],da.[maDuAn],da.soLuongNhanSu,da.[trangThai] \r\n" + 
				"from [dbo].[bangCong] bc join [dbo].[duAn] da on bc.maDuAn = da.maDuAn join [dbo].[nhanSu] ns on bc.maNhanSu = ns.maNhanSu join [dbo].[chucVu] cv \r\n" + 
				"on ns.maChucVu = cv.maChucVu where ns.[trangThai] = 1 and da.maDuAn ="+ "'"+GiaoDienDiemDanhNhanSu.getTxtMaDuAn().getText()+"'");
		while(rs.next()) {
			String mabangcong = rs.getString(1);
			String manhansu = rs.getString(2);
			String hoten = rs.getString(3);
			String songaycong = rs.getString(4);
			String ngaythamgia = rs.getString(5);
			String trangthains = rs.getString(6);
			String chucvu = rs.getString(7);
			String maduan = rs.getString(8);
			String sonhansu = rs.getString(9);
			String trangthaida = rs.getString(10);
			BangCongLuanChuyen bclc = new BangCongLuanChuyen(mabangcong,manhansu,hoten,songaycong,ngaythamgia,trangthains,chucvu  ,maduan,sonhansu,trangthaida); 
			dsBangCongLc.add(bclc);
			System.out.println("Doc bang cong lC Thanh Cong");
		}
	}catch (SQLException e) {
		// TODO: handle exception
		System.out.println("Doc khong bangcong lc ko Thanh Cong");
		e.printStackTrace();
	}
	return dsBangCongLc;
}*/
}