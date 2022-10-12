package ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//import com.toedter.calendar.JDateChooser;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import Entity.TKDuAn;
import Entity.TKDuAnDaHoanThanh;
import Entity.TKNhanSu;
import Entity.TKNhanSuChuaThamGia;
import Entity.TKNhanSuDaThamGia;
import Entity.TKPhongBan;
import Entity.ThemDuAn;
import connectDB.ConnectDB;
import dao.QuanLiThemDuAn_DAO;
import dao.QuanLiThongKe_DAO;


public class GiaoDienThemDuAn1 extends JFrame implements ActionListener, MouseListener{

	private JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item14;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3,txtMaNhanSu;
	private JLabel lblNewLabel_3;
	private JLabel lblLogo;
	private JPanel Khung;
	private JTable table;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel1,tableModel2,tableModel3;
	private JButton btnLuu,btnThemCongViec, btnThoat, btnXoaTrong;
//	private JDateChooser dateChooser1, dateChooser2 ;
	private JTextField txtMaBangCong;
	private static JTextField txtMaCongViec;
	private JComboBox cmbTrangThaiDuAn;
	private JTextField textField_6;
	private JTextField textField_7;
	private static String LoaiCongViec;
	private static JComboBox comboBoxLoaiCongViec,comboBoxLoaiBangCong;
	private JButton btnLocPhanCong,btnLocCongViec; 
	private static JTextField txtMaDuAn;
	private JTextField txtTimKiem;
	private JTextField txtTimDuAn;
	private JTextField txtTimBangCong;
	private JPanel contentPane;
	private JTextField textMaDuAn;
	private JTextField textTenDuAn;
	private JTextField textField_4;
	private JTextField txtChuDauTu;
	private JTextField txtNoiThiCong;
	private JTextField txtSoLuongNhanSuTrongDuAn;
	private JTextField txtTimKiemDuAn;
	private JTextField txtGhiChu;
	private JDateChooser dateNgayKhoiCong, dateNgayCapPhep, dateNgayHoanThanhDuKien ;
	QuanLiThemDuAn_DAO qltda = new QuanLiThemDuAn_DAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienThemDuAn1 frame = new GiaoDienThemDuAn1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public GiaoDienThemDuAn1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 700);
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

		JLabel lblNewLabel = new JLabel("ỨNG DỤNG QUẢN LÍ LAO ĐỘNG CÔNG TY HƯNG THỊNH");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));

		JLabel lblNewLabel_1 = new JLabel("H2L2");
		lblNewLabel_1.setForeground(new Color(51, 0, 255));
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 45));





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
		textField.setBounds(48, 110, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(48, 267, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(48, 188, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(48, 335, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Tổng Số Nhân Sự");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(48, 79, 131, 20);
		panel_1.add(lblNewLabel_7);

		JLabel lblTngSD = new JLabel("Tổng số dự án");
		lblTngSD.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTngSD.setBounds(48, 159, 131, 20);
		panel_1.add(lblTngSD);

		JLabel lblSNhnS = new JLabel("NS chưa tham gia DA");
		lblSNhnS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSNhnS.setBounds(32, 239, 147, 20);
		panel_1.add(lblSNhnS);

		JLabel lblSPhongBan = new JLabel("Số phòng ban");
		lblSPhongBan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSPhongBan.setBounds(48, 311, 131, 20);
		panel_1.add(lblSPhongBan);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(48, 399, 86, 20);
		panel_1.add(textField_6);

		JLabel lblTrngPhong = new JLabel("NS tham gia dự án");
		lblTrngPhong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrngPhong.setBounds(48, 374, 131, 20);
		panel_1.add(lblTrngPhong);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(48, 468, 86, 20);
		panel_1.add(textField_7);

		JLabel lblDuAn = new JLabel("Dự án đã hoàn thành");
		lblDuAn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDuAn.setBounds(32, 437, 131, 20);
		panel_1.add(lblDuAn);
		item1= new JMenuItem();

		JComboBox comboBox_1 = new JComboBox();
		bar1.add(comboBox_1);
		
		JLabel label = new JLabel("New label");
		bar1.add(label);
		
		textField_4 = new JTextField();
		bar1.add(textField_4);
		textField_4.setColumns(10);
		
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
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,ActionEvent.ALT_MASK));
		item2= new JMenuItem();
		item2.setText("Sửa Thông Tin Dự Án");
		item2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item2.setIcon(new javax.swing.ImageIcon("Image/30e9d39543d14e5821889fda236fad5d.png"));		
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,ActionEvent.ALT_MASK));
		item3= new JMenuItem();
		item3.setText("Xóa Dự Án");
		item3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item3.setIcon(new javax.swing.ImageIcon("Image/logout.png"));	
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,ActionEvent.ALT_MASK));
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


		lblLogo = new JLabel(new ImageIcon("Image/logo72.png"));

		Khung = new JPanel();
		Khung.setBackground(new Color(211, 211, 211));
		
		String[]headers1 = {"Mã Dự Án", "Tên Dự Án", "Chủ Đầu Tư", "Trạng Thái", "Ngày Cấp Phép", "Ngày Khởi Công", "Ngày Hoàn Thành", "Địa Điểm Thi Công", "Số Lượng Nhân Sự" , "Ghi Chú"};
		tableModel = new DefaultTableModel(headers1,0);
		JPanel pnTable= new JPanel();
		pnTable.setBackground(new Color(100, 149, 237));

		pnTable.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách dự án", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
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
		
		JLabel lblMaDuAn = new JLabel("Mã dự án:");
		lblMaDuAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTitleThemDuAn = new JLabel("THÊM DỰ ÁN");
		lblTitleThemDuAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleThemDuAn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		textMaDuAn = new JTextField();
		textMaDuAn.setEditable(false);
		textMaDuAn.setColumns(10);
		
		JLabel lblTenDuAn = new JLabel("Tên dự án:");
		lblTenDuAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textTenDuAn = new JTextField();
		textTenDuAn.setColumns(10);
		
		JLabel lblChuDauTu = new JLabel("Chủ đầu tư:");
		lblChuDauTu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblDiaDiemThiCong = new JLabel("Nơi thi công:");
		lblDiaDiemThiCong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTrangThaiDuAn = new JLabel("Trạng thái:");
		lblTrangThaiDuAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNgayCapPhep = new JLabel("Ngày cấp phép:");
		lblNgayCapPhep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		dateNgayCapPhep = new JDateChooser();
		dateNgayCapPhep.setDateFormatString("yyyy-MM-dd");
		
		
		
		
		
		JLabel lblTimDuAn = new JLabel("Tìm kiếm dự án:");
		lblTimDuAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scroll.setBackground(new Color(139, 0, 139));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(204, 204, 204));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		scroll.setViewportView(table);
		
		btnThoat = new JButton("THOÁT");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		 btnLuu = new JButton("LƯU");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnXoaTrong = new JButton("XÓA TRỐNG");
		btnXoaTrong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTrong.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		txtChuDauTu = new JTextField();
		txtChuDauTu.setColumns(10);
		
		txtNoiThiCong = new JTextField();
		txtNoiThiCong.setColumns(10);
		
		JLabel lblNgayKhoiCong = new JLabel("Ngày khởi công:");
		lblNgayKhoiCong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		dateNgayKhoiCong = new JDateChooser();
		
		 dateNgayHoanThanhDuKien = new JDateChooser();
		
		JLabel lblNgayHoanThanhDuAn = new JLabel("Ngày hoàn thành dự kiến:");
		lblNgayHoanThanhDuAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtSoLuongNhanSuTrongDuAn = new JTextField();
		txtSoLuongNhanSuTrongDuAn.setEditable(false);
		txtSoLuongNhanSuTrongDuAn.setColumns(10);
		
		JLabel lblSoLuongNhanSuTrongDuAn = new JLabel("Số lượng nhân sự trong dự án:");
		lblSoLuongNhanSuTrongDuAn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTimKiemDuAn = new JTextField();
		txtTimKiemDuAn.setColumns(10);
		
		txtTimKiemDuAn.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyReleased(java.awt.event.KeyEvent evt) {
	            TimKiemKeyRelease(evt);
	        }
	        
			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				String search = txtTimKiemDuAn.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
	    });
		
		cmbTrangThaiDuAn = new JComboBox();
		cmbTrangThaiDuAn.setModel(new DefaultComboBoxModel(new String[] {"Dang Thi Cong"}));
		cmbTrangThaiDuAn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		JLabel lblGhiChu = new JLabel("Ghi chú cho công trình:");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtGhiChu = new JTextField();
		txtGhiChu.setColumns(10);
		
		btnThemCongViec = new JButton("THÊM CÔNG VIỆC");
		btnThemCongViec.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1084, Short.MAX_VALUE)
							.addGap(22))
						.addComponent(bar1, GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
						.addComponent(Khung, GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(Khung, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(bar1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 1034, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_Khung = new GroupLayout(Khung);
		gl_Khung.setHorizontalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(463)
					.addComponent(lblTitleThemDuAn, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMaDuAn, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(79)
							.addComponent(textMaDuAn, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(79)
							.addComponent(textTenDuAn, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenDuAn, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblChuDauTu, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(88)
									.addComponent(txtChuDauTu, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblDiaDiemThiCong, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(89)
							.addComponent(txtNoiThiCong, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSoLuongNhanSuTrongDuAn, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(51)
							.addComponent(lblGhiChu, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addComponent(txtSoLuongNhanSuTrongDuAn, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGhiChu, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(lblTrangThaiDuAn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(cmbTrangThaiDuAn, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNgayCapPhep, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(dateNgayCapPhep, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addComponent(lblNgayKhoiCong, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(dateNgayKhoiCong, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(183)
							.addComponent(dateNgayHoanThanhDuKien, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNgayHoanThanhDuAn, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(50)
					.addComponent(btnThemCongViec, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(129)
					.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(165)
					.addComponent(btnXoaTrong, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(197)
					.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTimDuAn, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(116)
							.addComponent(txtTimKiemDuAn, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(10)
					.addComponent(pnTable, GroupLayout.PREFERRED_SIZE, 1109, GroupLayout.PREFERRED_SIZE))
		);
		gl_Khung.setVerticalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addComponent(lblTitleThemDuAn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaDuAn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(8)
									.addComponent(textMaDuAn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(textTenDuAn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenDuAn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblChuDauTu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(7)
									.addComponent(txtChuDauTu, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
							.addGap(15)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDiaDiemThiCong, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(7)
									.addComponent(txtNoiThiCong, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblSoLuongNhanSuTrongDuAn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblGhiChu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(11)
							.addComponent(txtSoLuongNhanSuTrongDuAn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(txtGhiChu, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(29)
							.addComponent(lblTrangThaiDuAn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(35)
							.addComponent(cmbTrangThaiDuAn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNgayCapPhep, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(7)
							.addComponent(dateNgayCapPhep, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNgayKhoiCong, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(7)
							.addComponent(dateNgayKhoiCong, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(7)
							.addComponent(dateNgayHoanThanhDuKien, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNgayHoanThanhDuAn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(1)
							.addComponent(btnThemCongViec, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(1)
							.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnXoaTrong, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(1)
							.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTimDuAn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(2)
							.addComponent(txtTimKiemDuAn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addComponent(pnTable, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
		);
		Khung.setLayout(gl_Khung);
		contentPane.setLayout(gl_contentPane);
		ConnectDB.getInstance().Connect();
		updateDataBangDuAn();
		btnLuu.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoaTrong.addActionListener(this);
		table.addMouseListener(this);
		btnThemCongViec.addActionListener(this);
		updatetk1();
		updatetk2();
		updatetk3();
		updatetk4();
		updatetk5();	
		//updateDatabang4();
		updatetk6();
	}

	
	public void updateDataBangDuAn() {
		QuanLiThemDuAn_DAO qltda = new QuanLiThemDuAn_DAO();
		List<ThemDuAn> list =  qltda.bangDuAnThem();
		for(ThemDuAn bg : list)
		{
			String[] rowdata = {bg.getMaDuAn(),bg.getTenDuAn(), bg.getChuDauTu(), bg.getTrangThai(), bg.getNgayCapPhep(), bg.getNgayKhoiCong(), bg.getNgayHoanThanh(), bg.getDiaDiemThiCong(), bg.getSoLuongNhanSu(), bg.getGhiChu()+""};
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
	private void themDuAn() {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
		if(kiemloi())
		{
		String a = "0" ;
			if(qltda.themDuAn(textTenDuAn.getText(), txtChuDauTu.getText(),cmbTrangThaiDuAn.getSelectedItem().toString() , 
				df.format(dateNgayCapPhep.getDate()),df.format(dateNgayKhoiCong.getDate()) ,df.format(dateNgayHoanThanhDuKien.getDate()),
				txtNoiThiCong.getText(), a, txtGhiChu.getText()));
				{

				
					JOptionPane.showMessageDialog(this, "Thêm dự án thành công");
				
					

					tableModel = (DefaultTableModel)table.getModel();
					tableModel.setRowCount(0);
					updateDataBangDuAn();
					XoaRong();

			}
				
		}
	}
	
	
	private boolean kiemloi() {
        // TODO Auto-generated method stub
        String tenda = textTenDuAn.getText().trim();
        String chudautu = txtChuDauTu.getText().trim();
        String noithicong = txtNoiThiCong.getText().trim();
        String ghichu = txtGhiChu.getText().trim();

        if(!(tenda.length()>0 ))
        {
            JOptionPane.showMessageDialog(this, "Tên dự án không được bỏ trống");
            textTenDuAn.requestFocus();
            return false;
        }
        if(!(chudautu.length()>0 ))
        {
            JOptionPane.showMessageDialog(this, "Chủ đầu tư không được bỏ trống");
            txtChuDauTu.requestFocus();
            return false;
        }
        
        if(!(noithicong.length()>0 ))
        {
            JOptionPane.showMessageDialog(this, "Nơi thi công không được bỏ trống");
            txtNoiThiCong.requestFocus();
            return false;
        }
        if(!(ghichu.length()>0 ))
        {
            JOptionPane.showMessageDialog(this, "Ghi chú không được bỏ trống");
            txtGhiChu.requestFocus();
            return false;
        }
      

        return true;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnLuu)) {
			
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm dự án ?","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac==JOptionPane.YES_OPTION ) {
				System.out.println("bamnut");
				themDuAn();
				
			}
			
		}
		
		if(o.equals(btnThemCongViec)) {
			
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GiaoDienThemCongViec main = new GiaoDienThemCongViec();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
				}
			});
			
			
		}
		if(o.equals(btnThoat)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm dự án ?","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac==JOptionPane.YES_OPTION ) {
				dispose();	
			}
		}
		if(o.equals(btnXoaTrong)) {
			txtChuDauTu.setText("");
			textMaDuAn.setText("");
			txtGhiChu.setText("");
			cmbTrangThaiDuAn.setSelectedItem("Chọn");
			
			dateNgayCapPhep.setDate(null);
			dateNgayHoanThanhDuKien.setDate(null);
			dateNgayKhoiCong.setDate(null);
			txtSoLuongNhanSuTrongDuAn.setText("");
			txtNoiThiCong.setText("");
			textTenDuAn.setText("");
		}
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		textMaDuAn.setText(table.getValueAt(row,0).toString());
		textTenDuAn.setText(table.getValueAt(row,1).toString());
		txtChuDauTu.setText(table.getValueAt(row,2).toString());
		cmbTrangThaiDuAn.setSelectedItem(table.getValueAt(row, 3).toString());
		try {
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row,4));
			dateNgayCapPhep.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row,5));
			dateNgayKhoiCong.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		try {
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row,6));
			dateNgayHoanThanhDuKien.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		txtNoiThiCong.setText(table.getValueAt(row,7).toString());
		txtGhiChu.setText(table.getValueAt(row,9).toString());
		txtSoLuongNhanSuTrongDuAn.setText(table.getValueAt(row,8).toString());

		
	}
	
	public void XoaRong() {
		txtChuDauTu.setText("");
		textMaDuAn.setText("");
		txtGhiChu.setText("");
		cmbTrangThaiDuAn.setSelectedItem("Chọn");
		
		dateNgayCapPhep.setDate(null);
		dateNgayHoanThanhDuKien.setDate(null);
		dateNgayKhoiCong.setDate(null);
		txtSoLuongNhanSuTrongDuAn.setText("");
		txtNoiThiCong.setText("");
		textTenDuAn.setText("");
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
}
