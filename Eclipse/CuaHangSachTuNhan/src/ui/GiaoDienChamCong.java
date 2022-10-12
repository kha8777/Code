package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

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

//import com.sun.org.apache.bcel.internal.generic.NEW;
import com.toedter.calendar.JDateChooser;

import Entity.BangCong;
import Entity.CongViec;
import Entity.CongViecCC;
import Entity.DuAnPC;
import Entity.NgayCongNhanSu;
import Entity.NhanSuPC;
import Entity.TKDuAn;
import Entity.TKDuAnDaHoanThanh;
import Entity.TKNhanSu;
import Entity.TKNhanSuChuaThamGia;
import Entity.TKNhanSuDaThamGia;
import Entity.TKPhongBan;
import connectDB.ConnectDB;
import dao.QuanLiPhanCong_DAO;
import dao.QuanLiThongKe_DAO;

import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GiaoDienChamCong extends JFrame implements ActionListener,MouseListener {
	private JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item14;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3,txtMaNhanSu;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel_3;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTable table1,table2,table3;
	private DefaultTableModel tableModel1,tableModel2,tableModel3;
	private JButton btnNewButton_1, btnChamCong,btnNewButton;
	private JDateChooser dateChooser1, dateChooser2;
	private static JTextField txtMaCongViec;
	private JComboBox comboBox1, comboBoxLoaiNC,comboBoxLoaiCongTru;
	private JTextField textField_6;
	private JTextField textField_7;
	private static String LoaiCongViec;
	private static JComboBox comboBoxLoaiCongViec;
	private JButton btnLocCongViec,btnLocNC,btnCong,btnTru;
	QuanLiPhanCong_DAO qlpc= new QuanLiPhanCong_DAO(); 
	private static JTextField txtMaDuAn;
	private JTextField txtTimKiem;
	private JTextField txtTimDuAn;
	private JTextField txtTimBangCong;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				GiaoDienChamCong window = new GiaoDienChamCong();		
					window.setLocationRelativeTo(null);
					window.setVisible(true);
				
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GiaoDienChamCong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1368, 700);
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

		JLabel lblNewLabel_1 = new JLabel("Icons");
		lblNewLabel_1.setForeground(new Color(51, 0, 255));
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_1.setBounds(1140, 11, 187, 68);
		panel.add(lblNewLabel_1);





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

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(211, 211, 211));
		panel_3.setLayout(null);

		String[]headers1 = {"Mã dự án","Tên Dự Án","Ngày Cấp Phép","Số nhân Sự","Trạng thái"};
		tableModel = new DefaultTableModel(headers1,0);
		JPanel pnTable= new JPanel();
		pnTable.setBounds(25, 112,451,180);
		pnTable.setBackground(new Color(100, 149, 237));
		//	pnTable.setBackground(new Color(204, 204, 204));
		pnTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh Sách Dự Án", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable.setLayout(new GridLayout(1, 0, 0, 0));
		panel_3.add(pnTable);

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
		scroll.setBackground(new Color(139, 0, 139));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(204, 204, 204));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		scroll.setViewportView(table);

		String[]headers3 = {"Mã công việc","Công việc","Số nhân sự","Ngày Bắt đầu"," Ngày Kết Thúc","Trạng Thái"};
		tableModel3 = new DefaultTableModel(headers3,0);
		JPanel pnTable3= new JPanel();
		pnTable3.setBounds(486, 112,618,180);
		pnTable3.setBackground(new Color(100, 149, 237));
		//pnTable3.setBackground(new Color(204, 204, 204));
		pnTable3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Công Việc Trong Dự Án", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable3.setLayout(new GridLayout(1, 0, 0, 0));
		panel_3.add(pnTable3);
		JScrollPane scroll3;
		pnTable3.add( scroll3 = new JScrollPane(table3 = new JTable(tableModel3) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		}));
		scroll3.setBackground(new Color(102, 0, 102));
		table3.setForeground(new Color(0, 0, 0));
		table3.setBackground(new Color(204, 204, 204));
		table3.setRowHeight(25);
		table3.setAutoCreateRowSorter(true);
		scroll3.setViewportView(table3);


		String[]headers2 = {"Mã nhân sự","Họ tên","Vai Trò"};
		tableModel1 = new DefaultTableModel(headers2,0);
		JPanel pnTable1= new JPanel();
		pnTable1.setBounds(788, 350,316,180);
		pnTable1.setBackground(new Color(100, 149, 237));
		//pnTable1.setBackground(new Color(204, 204, 204));
		pnTable1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh Sách Nhân Sự Của Công Việc", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable1.setLayout(new GridLayout(1, 0, 0, 0));
		panel_3.add(pnTable1);
		JScrollPane scroll1;
		pnTable1.add( scroll1 = new JScrollPane(table1 = new JTable(tableModel1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		}));
		scroll1.setBackground(new Color(102, 0, 102));
		table1.setForeground(new Color(0, 0, 0));
		table1.setBackground(new Color(204, 204, 204));
		table1.setRowHeight(25);
		table1.setAutoCreateRowSorter(true);
		scroll1.setViewportView(table1);

		String[] headers4 = {"Mã Ngày Công","Mã nhân sự","Họ Tên","Tên Dự Án","Công Việc","Ngày Bắt đầu","Ngày kết "
				+ "Thúc","Số Ngày Công"};
		tableModel2 = new DefaultTableModel(headers4,0);
		JPanel pnTable2 = new JPanel();
		pnTable2.setBackground(new Color(100, 149, 237));
		pnTable2.setBounds(25, 350,749,180);
		//pnTable2.setBackground(new Color(204, 204, 204));
		//pnTable2.setBackground(new Color(204, 204, 204));

		pnTable2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh Sách Ngày Công Của Nhân Sự", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable2.setLayout(new GridLayout(1, 0, 0, 0));
		panel_3.add(pnTable2);
		JScrollPane scroll2;
		pnTable2.add( scroll2 = new JScrollPane(table2 = new JTable(tableModel2) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		}));

		txtMaNhanSu = new JTextField();
		txtMaNhanSu.setEditable(false);
		txtMaNhanSu.setBounds(25, 35,130, 22);
		panel_3.add(txtMaNhanSu);


		scroll2.setBackground(new Color(102, 0, 102));
		table2.setForeground(new Color(0, 0, 0));
		table2.setBackground(new Color(204, 204, 204));
		table2.setRowHeight(25);
		table2.setAutoCreateRowSorter(true);
		scroll2.setViewportView(table2);

		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(509, 35, 130, 22);
		dateChooser1.setDateFormatString("yyyy-MM-dd");
		panel_3.add(dateChooser1);

		JLabel lblNgayThamGia = new JLabel("Ngày Kết Thúc Công Việc :");
		lblNgayThamGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgayThamGia.setBounds(509, 11, 186, 27);
		panel_3.add(lblNgayThamGia);

		JLabel lblMaDAn = new JLabel("Mã Dự Án :");
		lblMaDAn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaDAn.setBounds(346, 11, 130, 27);
		panel_3.add(lblMaDAn);

		JLabel lblMaNhnS = new JLabel("Mã Nhân Sự:");
		lblMaNhnS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaNhnS.setBounds(25, 11, 130, 27);
		panel_3.add(lblMaNhnS);

		JLabel lblmacongviec = new JLabel("Mã Công Việc:");
		lblmacongviec.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmacongviec.setBounds(186, 11, 130, 27);
		panel_3.add(lblmacongviec);

		txtMaCongViec = new JTextField();
		//txtMaCongViec.setText("0");
		txtMaCongViec.setEditable(false);
		txtMaCongViec.setColumns(10);
		txtMaCongViec.setBounds(186, 35, 130, 22);
		panel_3.add(txtMaCongViec);

		txtMaDuAn = new JTextField();
		txtMaDuAn.setEditable(false);//25, 47, 155, 28

		txtMaDuAn.setBounds(346, 35,130, 22);
		panel_3.add(txtMaDuAn);
		txtMaDuAn.setColumns(10);


		comboBoxLoaiCongViec = new JComboBox();
		comboBoxLoaiCongViec.setBounds(486, 84, 130, 22);
		comboBoxLoaiCongViec.addItem("Chọn");
		comboBoxLoaiCongViec.addItem("Đang Thi Công");
		comboBoxLoaiCongViec.addItem("Hoàn Thành");
		panel_3.add(comboBoxLoaiCongViec);
		/*comboBoxLoaiBangCong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row1 = table3.getSelectedRow();
				int row2 = table.getSelectedRow();

				// TODO Auto-generated method stub
				if(comboBoxLoaiBangCong.getSelectedItem().toString().equals("Tất Cả Bảng Công")) {							
						tableModel2 = (DefaultTableModel)table2.getModel();
						tableModel2.setRowCount(0); 
						updateDatabang3();				
				}
				if(comboBoxLoaiBangCong.getSelectedItem().toString().equals("Theo Công Việc")) {
					if(row1 >= 0) {

						tableModel3 = (DefaultTableModel)table3.getModel();
						tableModel3.setRowCount(0); 
						updateDatabang5();
					}else
					{
						JOptionPane.showMessageDialog(comboBoxLoaiBangCong, this, "Bạn Chưa Chọn Công Việc", row1);
					}
				}
				if(comboBoxLoaiBangCong.getSelectedItem().toString().equals("Theo Dự Án")) {
					if(row2 >= 0) {

						tableModel = (DefaultTableModel)table.getModel();
						tableModel.setRowCount(0); 
						updateDatabang6();
					}else
					{
						JOptionPane.showMessageDialog(comboBoxLoaiBangCong, this, "Bạn Chưa Chọn Dự Án", row2);
					}
				}

			}
		});*/

		JLabel lblLoaiCngVic = new JLabel("Loại Công Việc :");
		lblLoaiCngVic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoaiCngVic.setBounds(486, 59, 130, 27);
		panel_3.add(lblLoaiCngVic);

		JLabel lblLoai = new JLabel("Tìm Kiếm Dự Án:");
		lblLoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoai.setBounds(25, 59, 130, 27);
		panel_3.add(lblLoai);

		JLabel lblTimKimNhn = new JLabel("Tìm Kiếm Nhân Sự:");
		lblTimKimNhn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTimKimNhn.setBounds(788, 299, 130, 27);
		panel_3.add(lblTimKimNhn);

		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(788, 322, 179, 22);
		panel_3.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				TimKiemKeyRelease(evt);
			}

			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel1 = (DefaultTableModel)table1.getModel();
				String search = txtTimKiem.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel1);
				table1.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});

		btnLocCongViec = new JButton("Lọc");
		btnLocCongViec.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLocCongViec.setBounds(626, 84, 61, 22);
		panel_3.add(btnLocCongViec);

		txtTimDuAn = new JTextField();
		txtTimDuAn.setColumns(10);
		txtTimDuAn.setBounds(25, 85, 180, 22);
		panel_3.add(txtTimDuAn);
		txtTimDuAn.setColumns(10);
		txtTimDuAn.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				TimKiemKeyRelease(evt);
			}

			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				String search = txtTimDuAn.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});




		txtTimBangCong = new JTextField();
		txtTimBangCong.setColumns(10);
		txtTimBangCong.setBounds(25, 322, 180, 22);
		panel_3.add(txtTimBangCong);
		txtTimBangCong.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				TimKiemKeyRelease(evt);
			}

			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel2 = (DefaultTableModel)table2.getModel();
				String search = txtTimBangCong.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel2);
				table2.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});

		JLabel lblTimKimBang = new JLabel("Tìm Kiếm Ngày Công Của Nhân Sự:");
		lblTimKimBang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTimKimBang.setBounds(25, 299, 195, 27);
		panel_3.add(lblTimKimBang);
		
		 comboBoxLoaiNC = new JComboBox();
		 comboBoxLoaiNC.addItem("Chọn");
		comboBoxLoaiNC.addItem("Hiển Thị Theo Dự Án");
		comboBoxLoaiNC.addItem("Hiển Thị Theo Công Việc Đã Hoàn Thành");
		comboBoxLoaiNC.setBounds(240, 322, 288, 22);
		panel_3.add(comboBoxLoaiNC);
		
		JLabel lblHinThiTheo = new JLabel("Hiển Thị Theo:");
		lblHinThiTheo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHinThiTheo.setBounds(240, 299, 195, 27);
		panel_3.add(lblHinThiTheo);
		
		btnLocNC = new JButton("Lọc");
		btnLocNC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLocNC.setBounds(538, 322, 61, 22);
		panel_3.add(btnLocNC);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(230, 230, 250));
		panel_4.setBounds(710, 11, 390, 95);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		btnTru = new JButton("- Ngày Công");
		btnTru.setBounds(10, 11, 180, 22);
		panel_4.add(btnTru);
		btnTru.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		 btnCong = new JButton("+ Ngày Công");
		btnCong.setBounds(10, 35, 180, 22);
		panel_4.add(btnCong);
		btnCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCong.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				btnNewButton = new JButton();
				btnNewButton.setBounds(200, 35, 180, 22);
				panel_4.add(btnNewButton);
				btnNewButton.setIcon(new ImageIcon("Image/exit.png"));
				
						btnChamCong = new JButton("Chấm Công");
						btnChamCong.setBounds(200, 11, 180, 22);
						panel_4.add(btnChamCong);
						btnChamCong.setFont(new Font("Tahoma", Font.BOLD, 11));
						
						comboBoxLoaiCongTru = new JComboBox();
						comboBoxLoaiCongTru.setBounds(10, 60, 370, 22);
						comboBoxLoaiCongTru.addItem("Cộng Trừ Ngày Công Theo....");
						comboBoxLoaiCongTru.addItem("Công Việc");
						comboBoxLoaiCongTru.addItem("Cá Nhân");
						panel_4.add(comboBoxLoaiCongTru);
						GroupLayout gl_contentPane = new GroupLayout(contentPane);
						gl_contentPane.setHorizontalGroup(
							gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(72)
											.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(45)
											.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
											.addGap(8))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(1)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
												.addComponent(bar1, GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)))))
						);
						gl_contentPane.setVerticalGroup(
							gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(37)
									.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(80)
									.addComponent(bar1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						);
						contentPane.setLayout(gl_contentPane);
						btnChamCong.addActionListener(this);
				
						btnNewButton.addActionListener(this);		
		btnLocNC.addActionListener(this);
		txtTimDuAn.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				TimKiemKeyRelease(evt);
			}

			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				String search = txtTimDuAn.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		btnLocCongViec.addActionListener(this);
		table1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row  = table1.getSelectedRow();		
				txtMaNhanSu.setText(table1.getValueAt(row,0).toString());
			}
		});
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row1  = table.getSelectedRow();
				//comboBox.setSelectedItem(table.getValueAt(row1,0).toString());
				txtMaDuAn.setText(table.getValueAt(row1,0).toString());

				if(row1 >= 0) {
					tableModel3 = (DefaultTableModel)table3.getModel();
					tableModel3.setRowCount(0); 
					updateDatabang4();
					tableModel2 = (DefaultTableModel)table2.getModel();
					tableModel2.setRowCount(0); 				
					updateDatabangNC();

				}
			}
		});
		table3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row3 = table3.getSelectedRow();		
				txtMaCongViec.setText(table3.getValueAt(row3,0).toString());
				LoaiCongViec = null;

				if(row3 >= 0) {
					LoaiCongViec = table3.getValueAt(row3,1).toString();				
					tableModel1 = (DefaultTableModel)table1.getModel();
					tableModel1.setRowCount(0); 
					updateDatabang2();

				}
				// TODO Auto-generated method stub
				Object o = e.getSource();
				if(o.equals(item4)) {

					new GiaoDienThemNhanSu().setVisible(true);
					setVisible(false);

				}
				if(o.equals(item6)) {

					new GiaoDienXoaNhanSu().setVisible(true);
					setVisible(false);

				}
				if(o.equals(item7)) {

				//	new GiaoDienChinh().setVisible(true);
					new GiaoDienAbout().setVisible(true);
			//(false);

				}
				if(o.equals(item5)) {

					new GiaoDienSuaNhanSu().setVisible(true);
					setVisible(false);

				}		
				if(o.equals(item9)) {

					new GiaoDienPhanCong().setVisible(true);
					setVisible(false);

				}
				if(o.equals(item10)) {

					new GiaoDienLuanChuyen().setVisible(true);
					setVisible(false);

				}
				if(o.equals(item11)) {

					new GiaoDienChamCong().setVisible(true);
					setVisible(false);

				}
				if(o.equals(item14)) {

					new GiaoDienChinh().setVisible(true);
					setVisible(false);

				}
			}
		});
		btnCong.addActionListener(this);
		btnTru.addActionListener(this);
		ConnectDB.getInstance().Connect();
		updateDatabang1();
		updateDatabang2();
		updatetk1();
		updatetk2();
		updatetk3();
		updatetk4();
		updatetk5();			
		updatetk6();
		//	updateComboBoxmaDuAn();
		//updateDatabangNC();


	}

	public void updateDatabang3() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<BangCong>list =  qlpc.doctatcabangcong();
		for(BangCong bg : list)
		{
			String[] rowdata = {bg.getMaBangCong(),bg.getMaNhanSu(),bg.getMaDuAn(),bg.getNgayThamGia()+""};
			tableModel2.addRow(rowdata);			
		}
		table2.setModel(tableModel2);
	}
	public void updateDatabang6() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<BangCong>list =  qlpc.docbangcongtheomaduan();
		for(BangCong bg : list)
		{
			String[] rowdata = {bg.getMaBangCong(),bg.getMaNhanSu(),bg.getMaDuAn(),bg.getNgayThamGia()+""};
			tableModel2.addRow(rowdata);			
		}
		table2.setModel(tableModel2);
	}
	public void updateDatabang5() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<BangCong>list =  qlpc.docBangCongTheoMaCongViec();
		for(BangCong bg : list)
		{
			String[] rowdata = {bg.getMaBangCong(),bg.getMaNhanSu(),bg.getMaDuAn(),bg.getNgayThamGia()+""};
			tableModel2.addRow(rowdata);			
		}
		table2.setModel(tableModel2);
	}
	public void updateDatabang4() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<CongViecCC>list =  qlpc.docCongViecCC();
		for(CongViecCC bg : list)
		{
			//,bg.getNgayhoanthanh(),bg.getTrangThai()
			String[] rowdata = {bg.getMaCongViec(),bg.getCongViec(),bg.getSoLuongNhanSuHienCo(),bg.getNgaythamgia(),bg.getNgayhoanthanh(),bg.getTrangThai()+""};
			tableModel3.addRow(rowdata);			
		}
		table3.setModel(tableModel3);

	}
	public void updateDatabangTT() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<CongViecCC>list =  qlpc.docCongViecTrangThaiCC();
		for(CongViecCC bg : list)
		{
			//,bg.getNgayhoanthanh(),bg.getTrangThai()
			String[] rowdata = {bg.getMaCongViec(),bg.getCongViec(),bg.getSoLuongNhanSuHienCo(),bg.getNgaythamgia(),bg.getNgayhoanthanh(),bg.getTrangThai()+""};
			tableModel3.addRow(rowdata);			
		}
		table3.setModel(tableModel3);

	}
	public void updateDatabang7() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<CongViec>list =  qlpc.docCongViectheovaitro();
		for(CongViec bg : list)
		{
			String[] rowdata = {bg.getMaCongViec(),bg.getSoLuongNhanSuCV(),bg.getCongViec(),bg.getSoLuongNhanSuHienCo(),bg.getNgaythamgia()+""};
			tableModel3.addRow(rowdata);			
		}
		table3.setModel(tableModel3);

	}
	public void updateDatabangNC() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<NgayCongNhanSu>list =  qlpc.docNgayCongNhanSuDA();
		for(NgayCongNhanSu bg : list)
		{
			String[] rowdata = {bg.getMaNgayCong(),bg.getMaNhanSu(),bg.getTenNhanSu(),bg.getTenduan(),bg.getMaCongViec(),bg.getNgayThamGia(),bg.getNgayHoanThanh(),bg.getSongaycong()+""};
			tableModel2.addRow(rowdata);			
		}
		table2.setModel(tableModel2);

	}
	public void updateDatabangNCCV() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<NgayCongNhanSu>list =  qlpc.docNgayCongNhanSuCV();
		for(NgayCongNhanSu bg : list)
		{
			String[] rowdata = {bg.getMaNgayCong(),bg.getMaNhanSu(),bg.getTenNhanSu(),bg.getTenduan(),bg.getMaCongViec(),bg.getNgayThamGia(),bg.getNgayHoanThanh(),bg.getSongaycong()+""};
			tableModel2.addRow(rowdata);			
		}
		table2.setModel(tableModel2);

	}
	public void updateDatabang2() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<NhanSuPC>list =  qlpc.docNhanSuCC();
		for(NhanSuPC bg : list)
		{
			String[] rowdata = {bg.getMaNhanSu(),bg.getTenNhanSu(),bg.getTrangThai()+""};
			tableModel1.addRow(rowdata);			
		}
		table1.setModel(tableModel1);
	}
	public void updateDatabang1() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<DuAnPC>list =  qlpc.docBangDuAn();
		for(DuAnPC bg : list)
		{
			String[] rowdata = {bg.getMaDuAn(),bg.getTenDuAn(),bg.getNgayKhoiCong(),bg.getSoNhanSu(),bg.getTrangThai()+""};
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
			//	txtMaBangCong.setText("BC"+CongID);
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

	/*private void updateComboBoxmaDuAn() {
		QuanLiPhanCong qlpc = new QuanLiPhanCong();
		List<DuAnPC>list =  qlpc.docBangDuAn();

		for( DuAnPC s : list)
		// comboBoxTenDuAn.addItem(s.getMaDuAn());	


	}*/
	private void updateComboBoxCongViec() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<CongViec>list =  qlpc.docCongViec();
		for(CongViec s : list)
			comboBoxLoaiCongViec.addItem(s.getCongViec());	

	}
	public void ChamCong() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");						
		int row = table.getSelectedRow();
		if(row>=0){
			String date = ((JTextField)dateChooser1.getDateEditor().getUiComponent()).getText();
			if(date.equals("")) {
				JOptionPane.showMessageDialog(this,"Bạn chưa chọn ngày Hoàn Thành công Việc");	
			}
			else {
				int row2 = table3.getSelectedRow();
				if(row2>=0){		
					LocalDate d1 = LocalDate.parse(table3.getValueAt(row2, 3).toString(), DateTimeFormatter.ISO_LOCAL_DATE);
					LocalDate d2 = LocalDate.parse(df.format(dateChooser1.getDate()), DateTimeFormatter.ISO_LOCAL_DATE);
					Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());	
					
					LocalDate startDate = d1;
					LocalDate endDate = d2;
					Set<DayOfWeek> weekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
					final int weekDaysBetween = (int) startDate.datesUntil(endDate)
					        .filter(d -> !weekend.contains(d.getDayOfWeek()))
					        .count();
					String Ngaycong = String.valueOf(weekDaysBetween).toString();
					long diffDays = diff.toDays();		
					if(diffDays > 0) {
						String CV = table3.getValueAt(row2, 1).toString();				
						String TDA = table.getValueAt(row, 1).toString();
						String ntt = table3.getValueAt(row2, 3).toString();
						String sl = table3.getValueAt(row, 2).toString();
					
						//JOptionPane.showMessageDialog(this,date);
						//JOptionPane.showMessageDialog(this,date);						
						
							
							int hoiNhac1 = JOptionPane.showConfirmDialog(this,  "Bạn có Chắc muốn chấm công: \n Nhân Sự Mã:"+txtMaNhanSu.getText()+" Tham Gia Dự Án: "+TDA+" Có Mã: "+getTxtMaDuAn().getText()+ 
									" Trong Công Việc: "+CV+" Có Mã: "+txtMaCongViec.getText()+" ? ","Chú ý",JOptionPane.YES_NO_OPTION);
							if(hoiNhac1 == JOptionPane.YES_OPTION) {
								//JOptionPane.showMessageDialog(this,df.format(dateChooser1.getDate()));
								try {	

									String songaycong = "0";
									String ngayhoanthanh = null;
									if(qlpc.ChamCongNhanSu(txtMaDuAn.getText(),txtMaCongViec.getText(),df.format(dateChooser1.getDate()),weekDaysBetween)){	

										//Object[]rowdata = { txtMaNhanSu.getText(),txtMaCongViec.getText(), df.format(dateChooser1.getDate()),ngayhoanthanh, songaycong};
										//tableModel2.addRow(rowdata);	
										tableModel2 = (DefaultTableModel)table2.getModel();
										tableModel2.setRowCount(0); 
										updateDatabangNC();	
										tableModel = (DefaultTableModel)table.getModel();
										tableModel.setRowCount(0); 
										updateDatabang1();											
										tableModel1 = (DefaultTableModel)table1.getModel();
										tableModel1.setRowCount(0);
										updateDatabang2();	
										tableModel3 = (DefaultTableModel)table3.getModel();
										tableModel3.setRowCount(0); 
										updateDatabang4();					
										JOptionPane.showMessageDialog(this, "Chấm Công Dự Án: "+TDA+" Mã: "+getTxtMaDuAn().getText()+ 
												"\nTrong Công Việc: "+CV+" Mã: "+txtMaCongViec.getText()+"\nNgày Bắt Đầu Công Việc: "+ntt+"\nNgày Hoàn Thành Công Việc"+
												df.format(dateChooser1.getDate())+"\nSố Lượng Nhân Sự Trong Công Việc: "+sl+" Thành Công!!");
										XoaRong();
										updatetk1();
										updatetk2();
										updatetk3();
										updatetk4();
										updatetk5();	
										updatetk6();
									}
									else {
										JOptionPane.showMessageDialog(this,"Chấm Công Thất Bại");
									}
								} catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}		
							}													
						
					}
					else {
						JOptionPane.showMessageDialog(this,"Vui Lòng Chọn Ngày kết thúc công việc Không bé hơn ngày bắt đầu công việc");
					}

				}					
				else
					JOptionPane.showMessageDialog(this, "Chọn Công Việc Cần Chấm Công");	
			}
			
			
		}			
		else
			JOptionPane.showMessageDialog(this, "Chọn Dự Án Cần Chấm Công");	
	}	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnChamCong)) {
			ChamCong();
		}
		if(o.equals(btnNewButton)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát ?","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION) {			
				dispose();			
			}
		}	
		if(o.equals(btnLocCongViec)) {
			int row1 = table3.getSelectedRow();
			int row2 = table.getSelectedRow();
			if(row2 >= 0)
			{
				// TODO Auto-generated method stub
				if(comboBoxLoaiCongViec.getSelectedItem().toString().equals("Đang Thi Công")) {							
					tableModel3 = (DefaultTableModel)table3.getModel();
					tableModel3.setRowCount(0); 
					updateDatabang4();				
				}
			
				if(comboBoxLoaiCongViec.getSelectedItem().toString().equals("Hoàn Thành")) {

				
						tableModel3 = (DefaultTableModel)table3.getModel();
						tableModel3.setRowCount(0); 
						updateDatabangTT();
				
				
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dự Án");
			}
			
			}
		if(o.equals(btnLocNC)) {
			int row1 = table3.getSelectedRow();
			int row2 = table.getSelectedRow();
			if(row2 >= 0)
			{
				// TODO Auto-generated method stub
				if(comboBoxLoaiNC.getSelectedItem().toString().equals("Hiển Thị Theo Dự Án")) {							
					tableModel2 = (DefaultTableModel)table2.getModel();
					tableModel2.setRowCount(0); 
					updateDatabangNC();				
				}
				if(comboBoxLoaiNC.getSelectedItem().toString().equals("Hiển Thị Theo Công Việc Đã Hoàn Thành")) {

					if(row1 >= 0)
					{
					tableModel2 = (DefaultTableModel)table2.getModel();
					tableModel2.setRowCount(0); 
					updateDatabangNCCV();
					}
					else {
						JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Công Việc");
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dự Án");
			}
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
	
		if(o.equals(btnCong)) {
			if(comboBoxLoaiCongTru.getSelectedItem().toString().equals("Công Việc")) {
				congNgayCV();
			}
			else {
				congNgay();
			}
			

		}
		if(o.equals(btnTru)) {

			if(comboBoxLoaiCongTru.getSelectedItem().toString().equals("Công Việc")) {
				truNgayCV();
			}
			else {
				truNgay();
			}

		}
	}
	public void congNgay() {
		int row = table2.getSelectedRow();
		if(row >= 0) {
			if(qlpc.congnc(table2.getValueAt(row, 0).toString())) {
				tableModel2 = (DefaultTableModel)table2.getModel();
				tableModel2.setRowCount(0); 
				updateDatabangNC();	
			}
			else {
				JOptionPane.showMessageDialog(this, "Cộng Ngày Công Thất Bại");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Vui Lòng Chọn Nhân Sự Muốn Cộng Ngày Công");
		}
	}
	public void congNgayCV() {
		int row = table3.getSelectedRow();
		if(row >= 0) {
			if(qlpc.congncCV(table3.getValueAt(row, 0).toString())) {
				tableModel2 = (DefaultTableModel)table2.getModel();
				tableModel2.setRowCount(0); 
				updateDatabangNC();	
			}
			else {
				JOptionPane.showMessageDialog(this, "Cộng Ngày Công Thất Bại");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Vui Lòng Chọn Công Việc Muốn Cộng Ngày Công");
		}
	}
	public void truNgay() {
		int row = table2.getSelectedRow();
		if(row >= 0) {
			if(qlpc.trunc(table2.getValueAt(row, 0).toString())) {
				tableModel2 = (DefaultTableModel)table2.getModel();
				tableModel2.setRowCount(0); 
				updateDatabangNC();	
			}
			else {
				JOptionPane.showMessageDialog(this, "Trừ Ngày Công Thất Bại");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Vui Lòng Chọn Nhân Sự Muốn Trừ Ngày Công");
		}
	}
	public void truNgayCV() {
		int row = table3.getSelectedRow();
		if(row >= 0) {
			if(qlpc.truncCV(table3.getValueAt(row, 0).toString())) {
				tableModel2 = (DefaultTableModel)table2.getModel();
				tableModel2.setRowCount(0); 
				updateDatabangNC();	
			}
			else {
				JOptionPane.showMessageDialog(this, "Trừ Ngày Công Thất Bại");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Vui Lòng Chọn Công Việc Muốn Trừ Ngày Công");
		}
	}
	public void XoaRong() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_6.setText("");
		textField_7.setText("");
		txtMaCongViec.setText("");
		txtMaDuAn.setText("");
		//txtMaBangCong.setText("BC");
		txtMaNhanSu.setText("");
		((JTextField)dateChooser1.getDateEditor().getUiComponent()).setText("");
		//dateChooser1.setDate(new Date());
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void mousePressed(MouseEvent e) {



	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public JTextField getTxtMaNhanSu() {
		return txtMaNhanSu;
	}

	public void setTxtMaNhanSu(JTextField txtMaNhanSu) {
		this.txtMaNhanSu = txtMaNhanSu;
	}

	public static JTextField getTxtMaDuAn() {
		return txtMaDuAn;
	}

	public void setTxtMaDuAn(JTextField txtMaDuAn) {
		this.txtMaDuAn = txtMaDuAn;
	}

	public static JTextField getTxtMaCongViec() {
		return txtMaCongViec;
	}

	public void setTxtMaCongViec(JTextField txtMaCongViec) {
		this.txtMaCongViec = txtMaCongViec;
	}

	public static String getLoaiCongViec() {
		return LoaiCongViec;
	}

	public void setLoaiCongViec(String loaiCongViec) {
		LoaiCongViec = loaiCongViec;
	}

	public static JComboBox getComboBoxLoaiCongViec() {
		return comboBoxLoaiCongViec;
	}

	public void setComboBoxLoaiCongViec(JComboBox comboBoxLoaiCongViec) {
		this.comboBoxLoaiCongViec = comboBoxLoaiCongViec;
	}
}
