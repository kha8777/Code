package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextHitInfo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import Entity.NhanSu;
import Entity.NhanSuThem;
import Entity.PhongBan;
import Entity.TKDuAn;
import Entity.TKDuAnDaHoanThanh;
import Entity.TKNhanSu;
import Entity.TKNhanSuChuaThamGia;
import Entity.TKNhanSuDaThamGia;
import Entity.TKPhongBan;
import connectDB.ConnectDB;
import dao.QuanLiNhanSu_DAO;
import dao.QuanLiPB_DAO;
import dao.QuanLiThongKe_DAO;
import dao.QuanLyNhanSuThem_DAO;

import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GiaoDienSuaNhanSu extends JFrame implements ActionListener, MouseListener {
	private JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item14;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3,txtMaNhanSu;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel Khung;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTable table1,table2,table3;
	private DefaultTableModel tableModel1,tableModel2,tableModel3;
	private JButton btnLuu, btnThoat,btnXoaTrong,btnLoc;
	private JDateChooser dateChooser1 ;


	private JComboBox comboBox1, cmbChucVu;
	private JTextField textField_6;
	private JTextField textField_7;
	private static String LoaiCongViec;
	private static JComboBox comboboxQQ,cmbVaiTro, cmbLoaiNS, cmbGioiTinh;


	private static JTextField txtMaDuAn;
	private JTextField txtTimKiem;
	private JTextField txtTimDuAn;
	private JTextField txtTimBangCong;
	private JPanel contentPane;
	private JTextField textMaNhanSu;
	private JTextField textTenNhanSu;
	private JTextField textSDT;
	private JTextField textTrangThai;
	private JTextField textDCLH;
	private JTextField textTimKiem;
	private JTextField textCmnd;
	private JTextField textTenPB;
	private JTextField textMaPB;
	QuanLyNhanSuThem_DAO qltnv= new QuanLyNhanSuThem_DAO();
	QuanLiNhanSu_DAO qlnv= new QuanLiNhanSu_DAO();

	private JLabel lblMaPhngBan;

	private JLabel lblCmnd;

	private JLabel lblVaiTr;
	/**
	 * Launch the application.
	 */
	/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienThemNhanSu frame = new GiaoDienThemNhanSu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	private JComboBox cmbHienThi;

	private JLabel lblHinThTheo;

	private JLabel lblTmNhnS;
	private JLabel lblDiaChiLH_1;

	/**
	 * Create the frame.
	 */
	public GiaoDienSuaNhanSu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1372, 769);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JMenuBar bar1 = new JMenuBar();
		bar1.setForeground(new Color(51, 255, 51));
		bar1.setForeground(Color.blue);
		bar1.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ỨNG DỤNG QUẢN LÍ LAO ĐỘNG CÔNG TY HƯNG THỊNH");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
		lblNewLabel.setBounds(40, 11, 1034, 59);
		panel.add(lblNewLabel);





		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 255));
		panel_2.setBounds(0, 0, 250, 39);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Thống Kê");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(51, 0, 111, 39);
		panel_2.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(48, 144, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(48, 283, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(48, 214, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(48, 356, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Tổng Số Nhân Sự");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(48, 113, 131, 20);
		panel_1.add(lblNewLabel_7);

		JLabel lblTngSD = new JLabel("Tổng số dự án");
		lblTngSD.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTngSD.setBounds(48, 183, 131, 20);
		panel_1.add(lblTngSD);

		JLabel lblSNhnS = new JLabel("NS chưa tham gia DA");
		lblSNhnS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSNhnS.setBounds(48, 252, 147, 20);
		panel_1.add(lblSNhnS);

		JLabel lblSPhongBan = new JLabel("Số phòng ban");
		lblSPhongBan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSPhongBan.setBounds(48, 325, 131, 20);
		panel_1.add(lblSPhongBan);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(48, 423, 86, 20);
		panel_1.add(textField_6);

		JLabel lblTrngPhong = new JLabel("NS tham gia dự án");
		lblTrngPhong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrngPhong.setBounds(48, 392, 131, 20);
		panel_1.add(lblTrngPhong);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(48, 490, 86, 20);
		panel_1.add(textField_7);

		JLabel lblDAna = new JLabel("Dự án đã hoàn thành");
		lblDAna.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDAna.setBounds(48, 459, 131, 20);
		panel_1.add(lblDAna);

		JMenu menu1 = new JMenu();
		menu1.setBounds(0, 0, 184, 40);
		menu1.setText("  Dự Án");
		menu1.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu1.setIcon(new javax.swing.ImageIcon("Image/home_1.png"));
		item1= new JMenuItem();
		bar1.add(menu1);		
		item1= new JMenuItem();
		item1.setText("Thêm Dự Án");
		item1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item1.setIcon(new javax.swing.ImageIcon("Image/home.png"));
		item2= new JMenuItem();
		item2.setText("Sửa Thông Tin Dự Án");
		item2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item2.setIcon(new javax.swing.ImageIcon("Image/30e9d39543d14e5821889fda236fad5d.png"));		
		item3= new JMenuItem();
		item3.setText("Xóa Dự Án");
		item3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item3.setIcon(new javax.swing.ImageIcon("Image/logout.png"));	
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);


		JMenu menu2 = new JMenu();
		bar1.add(menu2);
		menu2.setBounds(184, 0, 183, 40);
		menu2.setText("  Nhân Sự");
		menu2.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu2.setIcon(new javax.swing.ImageIcon("Image/dichvu.png"));
		item4= new JMenuItem();
		item4.setText("Thêm Nhân Sự");
		item4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item4.setIcon(new javax.swing.ImageIcon("Image/contract.png"));
		item5= new JMenuItem();
		item5.setText("Sửa Thông Tin Nhân Sự");
		item5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item5.setIcon(new javax.swing.ImageIcon("Image/30e9d39543d14e5821889fda236fad5d.png"));	
		item6= new JMenuItem();
		item6.setText("Xóa Nhân Sự");
		item6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item6.setIcon(new javax.swing.ImageIcon("Image/logout.png"));


		menu2.add(item4);
		menu2.add(item5);
		menu2.add(item6);
		//	menu2.add(item7);

		JMenu menu3 = new JMenu();
		menu3.setBounds(367, 0, 183, 40);
		menu3.setText("  Phòng Ban");
		menu3.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu3.setIcon(new javax.swing.ImageIcon("Image/user-group-icon.png"));
		bar1.add(menu3);
		item8= new JMenuItem();
		item8.setText("Sửa Thông Tin Phòng Ban");
		item8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item8.setIcon(new javax.swing.ImageIcon("Image/30e9d39543d14e5821889fda236fad5d.png"));	
		menu3.add(item8);


		JMenu menu4 = new JMenu();
		menu4.setBounds(550, 0, 183, 40);
		menu4.setText("   Phân Công");
		menu4.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu4.setIcon(new javax.swing.ImageIcon("Image/order-1.png"));	
		bar1.add(menu4);
		item9= new JMenuItem();
		item9.setText("Phân Công Nhân Sự");
		item9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item9.setIcon(new javax.swing.ImageIcon("Image/information.png"));
		item10= new JMenuItem();
		item10.setText("Luân Chuyển Nhân Sự");
		item10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item10.setIcon(new javax.swing.ImageIcon("Image/system.png"));
		menu4.add(item9);
		menu4.add(item10);



		JMenu menu5 = new JMenu();
		menu5.setBounds(733, 0, 183, 40);
		menu5.setText("  Chấm Công");
		menu5.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu5.setIcon(new javax.swing.ImageIcon("Image/e24f1be346a.png"));
		bar1.add(menu5);
		item11= new JMenuItem();
		item11.setText("Chấm Công Nhân Sự");
		item11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item11.setIcon(new javax.swing.ImageIcon("Image/1368245115_total_plan_cost.png"));
		menu5.add(item11);

		JMenu menu6 = new JMenu();
		menu6.setBounds(916, 0, 184, 40);
		menu6.setText("   Người Dùng");
		menu6.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu6.setIcon(new javax.swing.ImageIcon("Image/Login.png"));
		bar1.add(menu6);
		item12= new JMenuItem();
		item12.setText("Đổi Mật Khẩu");
		item12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item12.setIcon(new javax.swing.ImageIcon("Image/icon-ols.png"));
		item7= new JMenuItem();
		item7.setText("Thông Tin Về Ứng Dụng");
		item7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item7.setIcon(new javax.swing.ImageIcon("Image/tt1.png"));
		item14= new JMenuItem();
		item14.setText("Màn Hình Chính");
		item14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item14.setIcon(new javax.swing.ImageIcon("Image/home.png"));
		//menu6.add(item12);
		menu6.add(item7);
		menu6.add(item14);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);
		item8.addActionListener(this);
		item8.addActionListener(this);
		item9.addActionListener(this);
		item10.addActionListener(this);
		item11.addActionListener(this);
		item14.addActionListener(this);
		item12.addActionListener(this);


		lblNewLabel_4 = new JLabel(new ImageIcon("Image/logo72.png"));

		Khung = new JPanel();
		Khung.setBackground(new Color(211, 211, 211));







		String[]headers1 = {"Mã nhân sự","Họ tên","Giới tính","Ngày sinh","Tên Phòng ban", "Mã Phòng Ban","Quê quán","Địa chỉ liên hệ","Trạng thái","SDT","Loại Nhân sự","CMND","Vai Trò"};
		tableModel = new DefaultTableModel(headers1,0);
		JPanel pnTable= new JPanel();
		pnTable.setBackground(new Color(100, 149, 237));

		pnTable.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh Sa\u0301ch nh\u00E2n s\u1EF1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable.setLayout(new GridLayout(1, 0, 0, 0));


		JScrollPane scroll;
		pnTable.add( scroll = new JScrollPane(table = new JTable(tableModel)
		{
			//k cho sua tren bang
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		}));
//		JLabel lblDiaChiLH = new JLabel("Địa chỉ liên hệ:");
//		lblDiaChiLH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel lblManhansu = new JLabel("Mã nhân sự:");
		lblManhansu.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_5 = new JLabel("SỬA NHÂN SỰ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 24));

		textMaNhanSu = new JTextField();
		textMaNhanSu.setColumns(10);

		JLabel lblTnNhnS = new JLabel("Tên nhân sự:");
		lblTnNhnS.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textTenNhanSu = new JTextField();
		textTenNhanSu.setColumns(10);

		JLabel lblMaChucVu = new JLabel("Chức vụ:");
		lblMaChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblTenPhongBan = new JLabel("Tên phòng ban:");
		lblTenPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblQuQun = new JLabel("Quê quán:");
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblDiaChiLH;
		lblDiaChiLH_1 = new JLabel("Địa chỉ liên hệ:");
		lblDiaChiLH_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblLoiNhnS = new JLabel("Loại nhân sự:");
		lblLoiNhnS.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cmbGioiTinh = new JComboBox();
		cmbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		cmbGioiTinh.addItem("Nam");
		cmbGioiTinh.addItem("Nữ");

		textSDT = new JTextField();
		textSDT.setColumns(10);

		textTrangThai = new JTextField();
		textTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTrangThai.setText("0");
		textTrangThai.setColumns(10);

		textDCLH = new JTextField();
		textDCLH.setColumns(10);



		lblTmNhnS = new JLabel("Tìm kiếm nhân sự:");
		lblTmNhnS.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textTimKiem = new JTextField();
		textTimKiem.setColumns(10);

		lblHinThTheo = new JLabel("Hiển thị theo:");
		lblHinThTheo.setFont(new Font("Tahoma", Font.PLAIN, 15));


		cmbHienThi = new JComboBox();
		cmbHienThi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbHienThi.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));

		cmbHienThi.addItem("Tất cả");
		cmbHienThi.addItem("Chưa tham gia dự án");
		cmbHienThi.addItem("Đã tham gia dự án");


		btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scroll.setBackground(new Color(139, 0, 139));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(204, 204, 204));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		scroll.setViewportView(table);

		dateChooser1 = new JDateChooser();
		dateChooser1.setDateFormatString("yyyy-MM-dd");

		lblVaiTr = new JLabel("Vai trò:");
		lblVaiTr.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cmbChucVu = new JComboBox();
		cmbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Không có"}));


		cmbLoaiNS = new JComboBox();
		cmbLoaiNS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbLoaiNS.setModel(new DefaultComboBoxModel(new String[] {"Chọn","Công nhân","Nhân viên"}));

		cmbVaiTro = new JComboBox();
		cmbVaiTro.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		cmbVaiTro.setFont(new Font("Tahoma", Font.PLAIN, 13));

		comboboxQQ = new JComboBox();
		comboboxQQ.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		comboboxQQ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboboxQQ.addItem("An Giang");
		comboboxQQ.addItem("Bà Rịa - Vũng Tàu");
		comboboxQQ.addItem("Bắc Giang");
		comboboxQQ.addItem("Bắc Kạn");
		comboboxQQ.addItem("Bạc Liêu");
		comboboxQQ.addItem("Bắc Ninh");
		comboboxQQ.addItem("Bến Tre");
		comboboxQQ.addItem("Bình Định");
		comboboxQQ.addItem("Bình Dương");
		comboboxQQ.addItem("Bình Phước");
		comboboxQQ.addItem("Bình Thuận");
		comboboxQQ.addItem("Cà Mau");
		comboboxQQ.addItem("Cần Thơ");
		comboboxQQ.addItem("Cao Bằng");
		comboboxQQ.addItem("Đà Nẵng");
		comboboxQQ.addItem("Đắk Lắk");
		comboboxQQ.addItem("Đắk Nông");
		comboboxQQ.addItem("Điện Biên");
		comboboxQQ.addItem("Đồng Nai");
		comboboxQQ.addItem("Đồng Tháp");
		comboboxQQ.addItem("Gia Lai");
		comboboxQQ.addItem("Hà Giang");
		comboboxQQ.addItem("Hà Nam");
		comboboxQQ.addItem("Hà Nội");
		comboboxQQ.addItem("Hà Tĩnh");
		comboboxQQ.addItem("Hải Dương");
		comboboxQQ.addItem("Hải Phòng");
		comboboxQQ.addItem("Hậu Giang");
		comboboxQQ.addItem("Hòa Bình");
		comboboxQQ.addItem("Hưng Yên");
		comboboxQQ.addItem("Khánh Hòa");
		comboboxQQ.addItem("Kiên Giang");
		comboboxQQ.addItem("Kon Tum");
		comboboxQQ.addItem("Lai Châu");
		comboboxQQ.addItem("Lâm Đồng");
		comboboxQQ.addItem("Lạng Sơn");
		comboboxQQ.addItem("Lào Cai");
		comboboxQQ.addItem("Long An");
		comboboxQQ.addItem("Nam Định");
		comboboxQQ.addItem("Nghệ An");
		comboboxQQ.addItem("Ninh Bình");
		comboboxQQ.addItem("Ninh Thuận");
		comboboxQQ.addItem("Phú Thọ");
		comboboxQQ.addItem("Phú Yên");
		comboboxQQ.addItem("Quảng Bình");
		comboboxQQ.addItem("Quảng Nam");
		comboboxQQ.addItem("Quảng Ngãi");
		comboboxQQ.addItem("Quảng Ninh");
		comboboxQQ.addItem("Quảng Trị");
		comboboxQQ.addItem("Sóc Trăng");
		comboboxQQ.addItem("Sơn La");
		comboboxQQ.addItem("Tây Ninh");
		comboboxQQ.addItem("Thái Bình");
		comboboxQQ.addItem("Thái Nguyên");
		comboboxQQ.addItem("Thanh Hóa");
		comboboxQQ.addItem("Thừa Thiên Huế");
		comboboxQQ.addItem("Tiền Giang");
		comboboxQQ.addItem("Thành phố Hồ Chí Minh");
		comboboxQQ.addItem("Trà Vinh");
		comboboxQQ.addItem("Tuyên Quang");
		comboboxQQ.addItem("Vĩnh Long");
		comboboxQQ.addItem("Vĩnh Phúc");
		comboboxQQ.addItem("Yên Bái");




		lblCmnd = new JLabel("CMND:");
		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textCmnd = new JTextField();
		textCmnd.setColumns(10);

		btnThoat = new JButton("THOÁT");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 25));

		btnLuu = new JButton("LƯU");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 25));

		btnXoaTrong = new JButton("XÓA TRỐNG");
		btnXoaTrong.setFont(new Font("Tahoma", Font.PLAIN, 25));

		lblMaPhngBan = new JLabel("Mã phòng ban:");
		lblMaPhngBan.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textTenPB = new JTextField();
		textTenPB.setColumns(10);

		textMaPB = new JTextField();
		textMaPB.setColumns(10);

		textTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				TimKiemKeyRelease(evt);
			}

			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				String search = textTimKiem.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		ConnectDB.getInstance().Connect();


		textMaNhanSu.setEditable(false);
		textMaPB.setEditable(false);
		textTenPB.setEditable(false);
		textTrangThai.setEditable(false);
		cmbVaiTro.setEnabled(false);
		cmbLoaiNS.setEnabled(false);
		cmbChucVu.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Khung, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bar1, GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(5)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(87)
								.addComponent(bar1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Khung, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
					.addGap(0))
		);
		GroupLayout gl_Khung = new GroupLayout(Khung);
		gl_Khung.setHorizontalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblManhansu, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textTenNhanSu, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblMaChucVu, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblTnNhnS, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 455, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(106)
							.addComponent(textMaNhanSu, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 245, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(384)
							.addComponent(cmbGioiTinh, 0, 167, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(384)
							.addComponent(cmbChucVu, 0, 167, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
							.addComponent(textMaPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(106)
							.addComponent(textTenPB, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(lblMaPhngBan, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTenPhongBan, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiaChiLH_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textDCLH, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)))
					.addGap(32)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblQuQun, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(comboboxQQ, 0, 177, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(90)
							.addComponent(cmbLoaiNS, 0, 175, Short.MAX_VALUE)
							.addGap(2))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(90)
							.addComponent(dateChooser1, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
							.addGap(2))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblLoiNhnS, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(90)
							.addComponent(textSDT, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblSDT, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)))
					.addGap(8)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(75)
							.addComponent(textCmnd, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblCmnd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(75)
							.addComponent(cmbVaiTro, 0, 176, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(75)
							.addComponent(textTrangThai, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblVaiTr, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblTrangThai, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE)))
					.addGap(21))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(153)
					.addComponent(btnXoaTrong, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(162)
					.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(220)
					.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(10)
					.addComponent(lblTmNhnS, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addComponent(textTimKiem, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addGap(215)
					.addComponent(lblHinThTheo, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(cmbHienThi, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(474)
					.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
				.addGroup(gl_Khung.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnTable, GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Khung.setVerticalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(29)
							.addComponent(lblTnNhnS, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(83)
							.addComponent(lblMaPhngBan, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(36)
							.addComponent(cmbGioiTinh, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(10)
							.addComponent(cmbChucVu, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(57)
							.addGroup(gl_Khung.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDiaChiLH_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDCLH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(88)
							.addComponent(textMaPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(50)
											.addComponent(lblQuQun, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(56)
											.addComponent(comboboxQQ, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(2)
											.addComponent(cmbLoaiNS, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(21)
											.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(29)
											.addComponent(dateChooser1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblLoiNhnS, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
									.addGap(2)
									.addComponent(textSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(72)
									.addComponent(lblSDT, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(58)
									.addComponent(textCmnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(51)
									.addComponent(lblCmnd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(3)
									.addComponent(cmbVaiTro, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(30)
									.addComponent(textTrangThai, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblVaiTr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(22)
									.addComponent(lblTrangThai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblManhansu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(37)
									.addComponent(textTenNhanSu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(4)
									.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMaChucVu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(25)
											.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(12)
									.addComponent(textMaNhanSu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(21)
									.addComponent(lblTenPhongBan, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(32)
									.addComponent(textTenPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(13)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addComponent(btnXoaTrong, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(1)
							.addComponent(lblTmNhnS))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(3)
							.addComponent(textTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblHinThTheo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(1)
							.addComponent(cmbHienThi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addComponent(pnTable, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
					.addContainerGap())
		);
		Khung.setLayout(gl_Khung);
		contentPane.setLayout(gl_contentPane);
		btnXoaTrong.addActionListener(this);
		btnLoc.addActionListener(this);
		btnThoat.addActionListener(this);
		btnLuu.addActionListener(this);

		cmbChucVu.addActionListener(this);
		cmbLoaiNS.addActionListener(this);
		cmbGioiTinh.addActionListener(this);
		comboboxQQ.addActionListener(this);
		cmbHienThi.addActionListener(this);
		updatetk1();
		updatetk2();
		updatetk3();
		updatetk4();
		updatetk5();	
		updatetk6();

		table.addMouseListener(this);

	}

	private void updateDataBang1() {
		QuanLiNhanSu_DAO qlns  = new QuanLiNhanSu_DAO();
		List<NhanSu>list = qlns.bangNhanSu();
		for(NhanSu s : list) {
			String[] rowdata = {s.getMaNhanSu(),s.getHoTen(),s.getGioiTinh(),s.getNgaySinh(),s.getTenPhongBan(),s.getMaPhongBan(),s.getQueQuan(),s.getDiaChiLienHe(),s.getTrangThai(),s.getSdt(),s.getLoaiNhanSu(),s.getSoCmnd(),s.getVaiTro()+""};
			tableModel.addRow(rowdata);
		}
		table.setModel(tableModel);
	}



	private void updateDataBang5() {
		QuanLiNhanSu_DAO qlns  = new QuanLiNhanSu_DAO();
		List<NhanSu>list = qlns.bangNhanSu1();
		for(NhanSu s : list) {
			String[] rowdata = {s.getMaNhanSu(),s.getHoTen(),s.getGioiTinh(),s.getNgaySinh(),s.getTenPhongBan(),s.getMaPhongBan(),s.getQueQuan(),s.getDiaChiLienHe(),s.getTrangThai(),s.getSdt(),s.getLoaiNhanSu(),s.getSoCmnd(),s.getVaiTro()+""};
			tableModel.addRow(rowdata);
		}
		table.setModel(tableModel);
	}
	private void updateDataBang6() {
		QuanLiNhanSu_DAO qlns  = new QuanLiNhanSu_DAO();
		List<NhanSu>list = qlns.bangNhanSu2();
		for(NhanSu s : list) {
			String[] rowdata = {s.getMaNhanSu(),s.getHoTen(),s.getGioiTinh(),s.getNgaySinh(),s.getTenPhongBan(),s.getMaPhongBan(),s.getQueQuan(),s.getDiaChiLienHe(),s.getTrangThai(),s.getSdt(),s.getLoaiNhanSu(),s.getSoCmnd(),s.getVaiTro()+""};
			tableModel.addRow(rowdata);
		}
		table.setModel(tableModel);
	}
	public void updatetk1(){
		QuanLiThongKe_DAO qltk = new QuanLiThongKe_DAO();
		List<TKDuAn>list =  qltk.tkduan();
		for(TKDuAn bg : list)
		{		
			String tk = bg.getTK().toString();
			textField_2.setText(tk);
		}
	}
	public void updatetk2(){
		QuanLiThongKe_DAO qltk = new QuanLiThongKe_DAO();
		List<TKNhanSu>list =  qltk.tknhansu();
		for(TKNhanSu bg : list)
		{		
			String tk = bg.getTK().toString();
			textField.setText(tk);
		}
	}
	public void updatetk3(){
		QuanLiThongKe_DAO qltk = new QuanLiThongKe_DAO();
		List<TKNhanSuChuaThamGia>list =  qltk.TKNhanSuChuaThamGia();
		for(TKNhanSuChuaThamGia bg : list)
		{		
			String tk = bg.getTK().toString();
			textField_1.setText(tk);
		}
	}
	public void updatetk4(){
		QuanLiThongKe_DAO qltk = new QuanLiThongKe_DAO();
		List<TKNhanSuDaThamGia>list =  qltk.TKNhanSuDaThamGia();
		for(TKNhanSuDaThamGia bg : list)
		{		
			String tk = bg.getTK().toString();
			int idbangcong = Integer.parseInt(tk.trim());
			int CongID = 0;
			CongID = idbangcong+1;
			textField_6.setText(tk);
			//txtMaBangCong.setText("BC"+CongID);
		}
	}
	public void updatetk5(){
		QuanLiThongKe_DAO qltk = new QuanLiThongKe_DAO();
		List<TKDuAnDaHoanThanh>list =  qltk.TKDuAnDaHoanThanh();
		for(TKDuAnDaHoanThanh bg : list)
		{		
			String tk = bg.getTK().toString();
			textField_7.setText(tk);
		}
	}
	public void updatetk6(){
		QuanLiThongKe_DAO qltk = new QuanLiThongKe_DAO();
		List<TKPhongBan>list =  qltk.TKPhongBan();
		for(TKPhongBan bg : list)
		{		
			String tk = bg.getTK().toString();
			textField_3.setText(tk);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(item4)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienThemNhanSu main = new GiaoDienThemNhanSu();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			setVisible(false);

		}
		if(o.equals(item8)) {

			new GiaoDienSuaPhongBan().setVisible(true);
			setLocationRelativeTo(null);
			setVisible(false);

		}
		if(o.equals(item6)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienXoaNhanSu main = new GiaoDienXoaNhanSu();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			setVisible(false);
			

		}
		if(o.equals(item7)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienAbout main = new GiaoDienAbout();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
		}
		if(o.equals(item5)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienSuaNhanSu main = new GiaoDienSuaNhanSu();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			setVisible(false);
		

		}		
		if(o.equals(item9)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienPhanCong main = new GiaoDienPhanCong();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			setVisible(false);
			

		}
		if(o.equals(item10)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienLuanChuyen main = new GiaoDienLuanChuyen();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			setVisible(false);
			

		}
		if(o.equals(item11)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienChamCong main = new GiaoDienChamCong();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			setVisible(false);

		}
		if(o.equals(item14)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienChinh main = new GiaoDienChinh();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			setVisible(false);
			

		}
		if(o.equals(item1)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienThemDuAn1 main = new GiaoDienThemDuAn1();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			setVisible(false);

		}
		if(o.equals(item2)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienSuaDuAn main = new GiaoDienSuaDuAn();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			setVisible(false);
			

		}
		if(o.equals(item3)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienXoaDuAn main = new GiaoDienXoaDuAn();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			setVisible(false);

		}
		if(o.equals(cmbLoaiNS)) {

			if(cmbLoaiNS.getSelectedItem().toString()=="Công nhân") {
				cmbVaiTro.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
				cmbVaiTro.addItem("Thợ điện");	
				cmbVaiTro.addItem("Thợ hàn");
				cmbVaiTro.addItem("Thợ xây");
				cmbVaiTro.addItem("Thợ bê tông");
				cmbVaiTro.addItem("Thợ phụ hồ");
				cmbVaiTro.addItem("Lái máy múc");
				cmbVaiTro.addItem("Lái ben");
				cmbVaiTro.addItem("Lái xe trộn bê tông");

			}
			if(cmbLoaiNS.getSelectedItem().toString()=="Nhân viên") {
				cmbVaiTro.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
				cmbVaiTro.addItem("Giám sát công trình");
				cmbVaiTro.addItem("Giám sát dự án");
				cmbVaiTro.addItem("Tư vấn viên");
				cmbVaiTro.addItem("Kiến trúc sư");
				cmbVaiTro.addItem("Kỹ sư xây dựng");
				cmbVaiTro.addItem("Kế toán");


			}
		}
		if(o.equals(btnXoaTrong))
		{
			XoaTrong();
		}

		if(o.equals(btnThoat))
		{
			dispose();
		}	
		if(o.equals(btnLuu))
		{
			suaNhanSu();
			tableModel = (DefaultTableModel)table.getModel();
			tableModel.setRowCount(0); 
			ConnectDB.getInstance().Connect();
			
			updateDataBang1();
			updateDataBang5();
			updateDataBang6();
		}
		if(o.equals(btnLoc)) {
			if(cmbHienThi.getSelectedItem().toString().equals("Tất cả")) {	
				ConnectDB.getInstance().Connect();
				tableModel = (DefaultTableModel)table.getModel();
				tableModel.setRowCount(0); 

				updateDataBang1();	

			}
			if(cmbHienThi.getSelectedItem().toString().equals("Chưa tham gia dự án")) {							
				tableModel = (DefaultTableModel)table.getModel();
				tableModel.setRowCount(0); 
				ConnectDB.getInstance().Connect();
				updateDataBang5();
			}
			if(cmbHienThi.getSelectedItem().toString().equals("Đã tham gia dự án")) {							
				ConnectDB.getInstance().Connect();
				tableModel = (DefaultTableModel)table.getModel();
				tableModel.setRowCount(0); 
				ConnectDB.getInstance().Connect();
				updateDataBang6();
			}
		}
	}
	private void suaNhanSu() {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
		int row = table.getSelectedRow();

		if(row>=0){
			if(kiemloi())
			{		

				LocalDate d= LocalDate.parse(df.format(dateChooser1.getDate()), DateTimeFormatter.ISO_LOCAL_DATE);
				Duration dd= Duration.between(d.atStartOfDay(), LocalDate.now().atStartOfDay());
				long ddd= dd.toDays();
				if(ddd>6600) {

					if(qlnv.capNhat(textMaNhanSu.getText(), textTenNhanSu.getText(), cmbGioiTinh.getSelectedItem().toString(),
							df.format(dateChooser1.getDate()).toString(),comboboxQQ.getSelectedItem().toString(), 
							textDCLH.getText(), textTrangThai.getText(), textSDT.getText(),textCmnd.getText())) {
						
						table.setValueAt(textTenNhanSu.getText(), row, 1);
						cmbGioiTinh.setSelectedItem(table.getValueAt(row,2).toString());
						try {
							Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row,3));
							dateChooser1.setDate(date);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						comboboxQQ.setSelectedItem(table.getValueAt(row,6).toString());
						table.setValueAt(textDCLH.getText(), row, 7);
						table.setValueAt(textTrangThai.getText(), row, 8);
						table.setValueAt(textSDT.getText(), row, 9);
						table.setValueAt(textCmnd.getText(), row, 11);
						

					
						JOptionPane.showMessageDialog(this, "Sửa Nhân Sự Thành Công");
						XoaTrong();
						
					}else {
						JOptionPane.showMessageDialog(this, "Sửa Nhân Sự Thất Bại");
						
					}
				}else {
					JOptionPane.showMessageDialog(this, "Chọn ngày sinh phù hợp( >18 tuổi)");
					
				}



			}
		}else {
			JOptionPane.showMessageDialog(this, "Chọn Nhân Sự Cần Sửa");
		}
	}

	private boolean kiemloi() {
		// TODO Auto-generated method stub
		String tensv = textTenNhanSu.getText().trim();
		String mpb= textMaPB.getText().trim();
		String tpb= textTenPB.getText().trim();
		String dclh = textDCLH.getText().trim();
		String Cmnd = textCmnd.getText().trim();
		String SoDienThoai = textSDT.getText().trim();
		String gt=cmbGioiTinh.getSelectedItem().toString().trim();
		String lns=cmbLoaiNS.getSelectedItem().toString().trim();
		String qq=comboboxQQ.getSelectedItem().toString().trim();
		String vt=cmbVaiTro.getSelectedItem().toString().trim();

		if(!(gt!="Chọn"))
		{
			JOptionPane.showMessageDialog(this, "Chọn giới tính");
			return false;
		}

		if(!(lns!="Chọn"))
		{
			JOptionPane.showMessageDialog(this, "Chọn loại nhân sự");
			return false;
		}
//		if(!(vt!="Chọn"))
//		{
//			JOptionPane.showMessageDialog(this, "Chọn vai trò");
//			return false;
//		}
		if(!(qq!="Chọn"))
		{
			JOptionPane.showMessageDialog(this, "Chọn quê quán");
			return false;
		}

		if(!(tensv.length()>0 ))
		{
			JOptionPane.showMessageDialog(this, "Tên không được bỏ trống");
			textTenNhanSu.requestFocus();
			return false;
		}
		if(!(tpb.length()>0 && mpb.length()>0))
		{
			JOptionPane.showMessageDialog(this, "Chọn phòng ban");
			return false;
		}
		if(!(dclh.length()>0))
		{
			JOptionPane.showMessageDialog(this, "Địa chỉ liên hệ không được bỏ trống");
			textDCLH.requestFocus();
			return false;
		}

		if(!(Cmnd.length()>0 && Cmnd.matches("\\d{9}"))){
			JOptionPane.showMessageDialog(this, "Số Chứng Minh Nhân dân gồm 9 số từ 0-9");
			textCmnd.requestFocus();
			return false;
		}

		if(!(SoDienThoai.length()>0 && SoDienThoai.matches("^0[0-9]{9}$")))
		{
			JOptionPane.showMessageDialog(this, "Số Điện thoại theo mẫu ^0[0-9]{8}$");
			textSDT.requestFocus();
			return false;


		}
		return true;
	}


	private void XoaTrong() {
		// TODO Auto-generated method stub
		textMaNhanSu.setText("");
		textTenNhanSu.setText("");		
		textCmnd.setText("");
		textDCLH.setText("");
		textSDT.setText("");
		textMaPB.setText("");
		textTenPB.setText("");
		cmbVaiTro.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		cmbLoaiNS.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		comboboxQQ.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		cmbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		int row  = table.getSelectedRow();
		textMaNhanSu.setText(table.getValueAt(row, 0).toString());
		textTenNhanSu.setText(table.getValueAt(row, 1).toString());
		cmbGioiTinh.setSelectedItem(table.getValueAt(row,2).toString());
		try {
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row,3));
			dateChooser1.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textTenPB.setText(table.getValueAt(row, 4).toString());
		textMaPB.setText(table.getValueAt(row, 5).toString());
		comboboxQQ.setSelectedItem(table.getValueAt(row,6).toString());
		textDCLH.setText(table.getValueAt(row, 7).toString());
		textTrangThai.setText(table.getValueAt(row, 8).toString());
		textSDT.setText(table.getValueAt(row, 9).toString());
		cmbLoaiNS.setSelectedItem(table.getValueAt(row,10).toString());
		textCmnd.setText(table.getValueAt(row, 11).toString());

		cmbVaiTro.setSelectedItem(table.getValueAt(row,12).toString());	

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		/////////////Phải Theo mẫu///////////////////////
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					GiaoDienSuaNhanSu window = new GiaoDienSuaNhanSu();
					window.setLocationRelativeTo(null);
					window.setVisible(true);
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}


}
