package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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


//import com.sun.org.apache.bcel.internal.generic.NEW;
import com.toedter.calendar.JDateChooser;

import Entity.BangCong;
import Entity.CongViec;
import Entity.DuAnPC;
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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GiaoDienPhanCong extends JFrame implements ActionListener,MouseListener {
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
	private JButton btnNewButton_1, btnPhanCong,btnNewButton;
	private JDateChooser dateChooser1,dateChooser2;
	private static JTextField txtMaCongViec;
	private JComboBox comboBox1;
	private JTextField textField_6;
	private JTextField textField_7;
	private static String LoaiCongViec;
	private static JComboBox comboBoxLoaiCongViec,comboBoxLoaiBangCong;
	private JButton btnLocPhanCong,btnLocCongViec;
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
				GiaoDienPhanCong main = new GiaoDienPhanCong();
				main.setVisible(true);
				main.setLocationRelativeTo(null);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GiaoDienPhanCong() {
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
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ỨNG DỤNG QUẢN LÍ LAO ĐỘNG CÔNG TY HƯNG THỊNH");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
		lblNewLabel.setBounds(37, 11, 1034, 59);
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
		pnTable.setBounds(25, 112,530,180);
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

		String[]headers3 = {"Mã công việc","Số nhân sự Tối đa","Công việc","Số nhân sự","Ngày Bắt đầu"};
		tableModel3 = new DefaultTableModel(headers3,0);
		JPanel pnTable3= new JPanel();
		pnTable3.setBounds(570, 112,530,180);
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


		String[]headers2 = {"Mã nhân sự","Họ tên","Trạng thái","Chức vụ","Vai Trò"};
		tableModel1 = new DefaultTableModel(headers2,0);
		JPanel pnTable1= new JPanel();
		pnTable1.setBounds(570, 350,530,180);
		pnTable1.setBackground(new Color(100, 149, 237));
		//pnTable1.setBackground(new Color(204, 204, 204));
		pnTable1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh Sách Nhân Sự Chưa Được Phân Công", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
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

		String[] headers4 = {"Mã bảng công","Mã nhân sự","Mã Công Việc","Ngày tham gia"};
		tableModel2 = new DefaultTableModel(headers4,0);
		JPanel pnTable2 = new JPanel();
		pnTable2.setBackground(new Color(100, 149, 237));
		pnTable2.setBounds(25, 350,530,180);
		//pnTable2.setBackground(new Color(204, 204, 204));
		//pnTable2.setBackground(new Color(204, 204, 204));

		pnTable2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh Sách Phân Công Nhân Sự", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
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
		txtMaNhanSu.setBounds(25, 35,116, 22);
		panel_3.add(txtMaNhanSu);


		scroll2.setBackground(new Color(102, 0, 102));
		table2.setForeground(new Color(0, 0, 0));
		table2.setBackground(new Color(204, 204, 204));
		table2.setRowHeight(25);
		table2.setAutoCreateRowSorter(true);
		scroll2.setViewportView(table2);

		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(492, 35, 150, 22);
		dateChooser1.setDateFormatString("yyyy-MM-dd");
		panel_3.add(dateChooser1);

		JLabel lblNgayThamGia = new JLabel("Ngày tham gia:");
		lblNgayThamGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgayThamGia.setBounds(492, 11, 186, 27);
		panel_3.add(lblNgayThamGia);

		JLabel lblMaDAn = new JLabel("Mã Dự Án :");
		lblMaDAn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaDAn.setBounds(333, 11, 130, 27);
		panel_3.add(lblMaDAn);

		JLabel lblMaNhnS = new JLabel("Mã Nhân Sự:");
		lblMaNhnS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaNhnS.setBounds(25, 11, 130, 27);
		panel_3.add(lblMaNhnS);

		JLabel lblmacongviec = new JLabel("Mã Công Việc:");
		lblmacongviec.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmacongviec.setBounds(179, 11, 130, 27);
		panel_3.add(lblmacongviec);

		txtMaCongViec = new JTextField();
		//txtMaCongViec.setText("0");
		txtMaCongViec.setEditable(false);
		txtMaCongViec.setColumns(10);
		txtMaCongViec.setBounds(179, 35, 116, 22);
		panel_3.add(txtMaCongViec);

		txtMaDuAn = new JTextField();
		txtMaDuAn.setEditable(false);//25, 47, 155, 28

		txtMaDuAn.setBounds(334, 35,116, 22);
		panel_3.add(txtMaDuAn);
		txtMaDuAn.setColumns(10);


		comboBoxLoaiCongViec = new JComboBox();
		comboBoxLoaiCongViec.setBounds(570, 84, 238, 22);
		comboBoxLoaiCongViec.addItem("Chọn");
		panel_3.add(comboBoxLoaiCongViec);

		comboBoxLoaiBangCong = new JComboBox();
		comboBoxLoaiBangCong.setBounds(230, 322, 180, 22);
		comboBoxLoaiBangCong.addItem("Chọn");
		comboBoxLoaiBangCong.addItem("Tất Cả Bảng Công");
		comboBoxLoaiBangCong.addItem("Theo Dự Án");
		comboBoxLoaiBangCong.addItem("Theo Công Việc");
		panel_3.add(comboBoxLoaiBangCong);
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
		lblLoaiCngVic.setBounds(570, 59, 130, 27);
		panel_3.add(lblLoaiCngVic);

		JLabel lblLoai = new JLabel("Tìm Kiếm Dự Án:");
		lblLoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoai.setBounds(25, 59, 130, 27);
		panel_3.add(lblLoai);

		JLabel lblLoaiBangCng = new JLabel("Hiển Thị Theo:");
		lblLoaiBangCng.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoaiBangCng.setBounds(230, 299, 130, 27);
		panel_3.add(lblLoaiBangCng);

		JLabel lblTimKimNhn = new JLabel("Tìm Kiếm Nhân Sự:");
		lblTimKimNhn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTimKimNhn.setBounds(570, 299, 130, 27);
		panel_3.add(lblTimKimNhn);

		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(570, 322, 180, 22);
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

		btnLocPhanCong = new JButton("Lọc");
		btnLocPhanCong.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLocPhanCong.setBounds(420, 322, 89, 22);
		panel_3.add(btnLocPhanCong);

		btnLocCongViec = new JButton("Lọc");
		btnLocCongViec.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLocCongViec.setBounds(826, 84, 130, 22);
		panel_3.add(btnLocCongViec);

		txtTimDuAn = new JTextField();
		txtTimDuAn.setColumns(10);
		txtTimDuAn.setBounds(25, 85, 180, 22);
		panel_3.add(txtTimDuAn);
		txtTimDuAn.setColumns(10);

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

		JLabel lblTimKimBang = new JLabel("Tìm Kiếm Bảng Phân Công:");
		lblTimKimBang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTimKimBang.setBounds(25, 299, 172, 27);
		panel_3.add(lblTimKimBang);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(230, 230, 250));
		panel_4.setBounds(675, 11, 425, 61);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
				btnPhanCong = new JButton("Phân Công ");
				btnPhanCong.setBounds(10, 8, 259, 50);
				panel_4.add(btnPhanCong);
				btnPhanCong.setFont(new Font("Tahoma", Font.BOLD, 11));
				
				
				 
				 		btnNewButton = new JButton();
				 		btnNewButton.setBounds(279, 10, 136,40);
				 		panel_4.add(btnNewButton);
				 		btnNewButton.setIcon(new ImageIcon("Image/exit.png"));
				 		//-------------------------------------FULL SIZE GROUP LAYOUT---------------------------------/
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
						//-------------------------------------END----------------------------------------------------/
				 				btnNewButton.addActionListener(this);		
				
				btnPhanCong.addActionListener(this);
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
		btnLocPhanCong.addActionListener(this);
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
					updateComboBoxCongViec();

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
					LoaiCongViec = table3.getValueAt(row3,2).toString();				
					tableModel1 = (DefaultTableModel)table1.getModel();
					tableModel1.setRowCount(0); 
					updateDatabang2();
//					tableModel2 = (DefaultTableModel)table2.getModel();
//					tableModel2.setRowCount(0); 
//					updateDatabang3();
				}
			}
		});
		ConnectDB.getInstance().Connect();
		updateDatabang1();
		updateDatabang2();
		updatetk1();
		updatetk2();
		updatetk3();
		updatetk4();
		updatetk5();	
		updateDatabang4();
		updatetk6();
		//	updateComboBoxmaDuAn();



	}
	////////////////////////////////////////////////////////Update data///////////////////////////////////////////////////////////////////////////
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
		List<CongViec>list =  qlpc.docCongViec();
		for(CongViec bg : list)
		{
			String[] rowdata = {bg.getMaCongViec(),bg.getSoLuongNhanSuCV(),bg.getCongViec(),bg.getSoLuongNhanSuHienCo(),bg.getNgaythamgia()+""};
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
	public void updateDatabang2() {
		QuanLiPhanCong_DAO qlpc = new QuanLiPhanCong_DAO();
		List<NhanSuPC>list =  qlpc.docNhanSu();
		for(NhanSuPC bg : list)
		{
			String[] rowdata = {bg.getMaNhanSu(),bg.getTenNhanSu(),bg.getTrangThai(),bg.getChucVu(),bg.getVaiTro()+""};
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
	//////////////////////////////////////////////Phân công////////////////////////////////////////////////////////////////////////////
	public void PhanCong() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");						
		int row = table.getSelectedRow();
		if(row>=0){
			int row2 = table3.getSelectedRow();
			if(row2>=0){
				int row1 = table1.getSelectedRow();
				if(row1>=0) {

					String sl1 = table3.getValueAt(row2, 1).toString();
					int  soNhanSutoida = Integer.parseInt(sl1.trim());
					String sl2 = table3.getValueAt(row2, 3).toString();
					int  soNhanSuhientai = Integer.parseInt(sl2.trim());
					if(soNhanSuhientai < soNhanSutoida) {
						String date = ((JTextField)dateChooser1.getDateEditor().getUiComponent()).getText();
						//JOptionPane.showMessageDialog(this,date);	

						if(date.equals("")) {
							JOptionPane.showMessageDialog(this,"Bạn chưa chọn ngày tham gia công trình");	
						}
						else {
							String ns = table.getValueAt(row, 3).toString();
							int  soNhanSu = Integer.parseInt(ns.trim());
							if(!(soNhanSu >= 200)) {
								String t = table1.getValueAt(row1, 2).toString();
								int i = Integer.parseInt(t.trim());
								if(i == 0 ) {	
									LocalDate d1 = LocalDate.parse(table3.getValueAt(row2, 4).toString(), DateTimeFormatter.ISO_LOCAL_DATE);
									LocalDate d2 = LocalDate.parse(df.format(dateChooser1.getDate()), DateTimeFormatter.ISO_LOCAL_DATE);	
									Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());		
									long diffDays = diff.toDays();		
									if(diffDays >= 0)
									{
										int hoiNhac1 = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn Phân Công Nhân Sự Vào Dự Án: "+txtMaDuAn.getText()+" ?","Chú ý",JOptionPane.YES_NO_OPTION);
										if(hoiNhac1 == JOptionPane.YES_OPTION) {
											//JOptionPane.showMessageDialog(this,df.format(dateChooser1.getDate()));
											try {		
												String songaycong = "0";
												String ngayhoanthanh = null;
												if(qlpc.PhanCong( txtMaNhanSu.getText(),txtMaDuAn.getText(), df.format(dateChooser1.getDate()),ngayhoanthanh, songaycong,txtMaCongViec.getText())){	

													//Object[]rowdata = { txtMaNhanSu.getText(),txtMaCongViec.getText(), df.format(dateChooser1.getDate()),ngayhoanthanh, songaycong};
													//tableModel2.addRow(rowdata);		
													tableModel2 = (DefaultTableModel)table2.getModel();
													tableModel2.setRowCount(0); 
													updateDatabang5();	
													tableModel = (DefaultTableModel)table.getModel();
													tableModel.setRowCount(0); 
													updateDatabang1();											
													tableModel1 = (DefaultTableModel)table1.getModel();
													tableModel1.setRowCount(0);
													updateDatabang2();	
													tableModel3 = (DefaultTableModel)table3.getModel();
													tableModel3.setRowCount(0); 
													updateDatabang4();
													JOptionPane.showMessageDialog(this, "Phân Công Nhân sự Thành Công");
													XoaRong();
													updatetk1();
													updatetk2();
													
													updatetk3();
													updatetk4();
													updatetk5();	
													updatetk6();
												}
												else {
													JOptionPane.showMessageDialog(this,"Trùng mã bảng công");
												}
											} catch (Exception e) {
												// TODO: handle exception
												e.printStackTrace();
											}		
										}
									}
									else
									{
										JOptionPane.showMessageDialog(this, "Ngày Tham Gia Công Việc Của Nhân Sự Không Được Bé Hơn Ngày Bắt Đầu Công Việc ");
									}


								}
								else {
									JOptionPane.showMessageDialog(this, "Nhân Sự Đã Tham gia 1 Dự Án Không Thể phân công vào dự án khác vui lòng chọn nhân sự khác !!!");
								}	
							}
							else {
								JOptionPane.showMessageDialog(this,"số nhân sự trong dự án: "+txtMaDuAn.getText()+" đã đạt tối đa >= 200 nhân sự ");
							}								
						}
					}
					else {
						JOptionPane.showMessageDialog(this,"Số nhân sự trong công việc đã đạt tối đa: "+ soNhanSutoida +" nhân sự ");
					}
				}
				else {
					JOptionPane.showMessageDialog(this,"Chọn Nhân Sự Cần Phân Công");
				}

			}					
			else
				JOptionPane.showMessageDialog(this, "Chọn Công Việc Cần Phân Công");
		}			
		else
			JOptionPane.showMessageDialog(this, "Chọn Dự Án Cần Phân Công");	
	}	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();	
		if(o.equals(btnPhanCong)) {
			PhanCong();
		}
		if(o.equals(btnNewButton)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát ?","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION) {

				dispose();			
			}
		}
		if(o.equals(btnLocPhanCong)) {
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

					tableModel2 = (DefaultTableModel)table2.getModel();
					tableModel2.setRowCount(0); 
					updateDatabang5();
				}else
				{
					JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Công Việc");
				}
			}
			if(comboBoxLoaiBangCong.getSelectedItem().toString().equals("Theo Dự Án")) {
				if(row2 >= 0) {

					tableModel2 = (DefaultTableModel)table2.getModel();
					tableModel2.setRowCount(0); 
					updateDatabang6();
				}else
				{
					JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dự Án");
				}
			}
		}
		if(o.equals(btnLocCongViec)) {
			int row2 = table.getSelectedRow();
			if(row2 >= 0) {

				tableModel3 = (DefaultTableModel)table3.getModel();
				tableModel3.setRowCount(0); 
				updateDatabang7();
			}else
			{
				JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dự Án");
			}
		}
		// TODO Auto-generated method stub
		
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


	public static JComboBox getComboBoxLoaiBangCong() {
		return comboBoxLoaiBangCong;
	}

	public void setComboBoxLoaiBangCong(JComboBox comboBoxLoaiBangCong) {
		this.comboBoxLoaiBangCong = comboBoxLoaiBangCong;
	}
}
