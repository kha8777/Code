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

public class GiaoDienXoaNhanSu extends JFrame implements ActionListener, MouseListener {
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
	private JButton btnXoa, btnThoat,btnLoc;
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

	/**
	 * Create the frame.
	 */
	public GiaoDienXoaNhanSu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1429, 732);
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

		JLabel lblNewLabel = new JLabel("????NG DU??NG QUA??N LI?? LAO ??????NG C??NG TY H??NG TH???NH");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
		lblNewLabel.setBounds(79, 10, 982, 40);
		panel.add(lblNewLabel);





		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 255));
		panel_2.setBounds(0, 0, 250, 39);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Th????ng K??");
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

		JLabel lblNewLabel_7 = new JLabel("T????ng S???? Nh??n S????");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(48, 113, 131, 20);
		panel_1.add(lblNewLabel_7);

		JLabel lblTngSD = new JLabel("T????ng s???? d???? a??n");
		lblTngSD.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTngSD.setBounds(48, 183, 131, 20);
		panel_1.add(lblTngSD);

		JLabel lblSNhnS = new JLabel("NS ch??a tham gia DA");
		lblSNhnS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSNhnS.setBounds(48, 252, 147, 20);
		panel_1.add(lblSNhnS);

		JLabel lblSPhongBan = new JLabel("S???? pho??ng ban");
		lblSPhongBan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSPhongBan.setBounds(48, 325, 131, 20);
		panel_1.add(lblSPhongBan);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(48, 423, 86, 20);
		panel_1.add(textField_6);

		JLabel lblTrngPhong = new JLabel("NS tham gia d???? a??n");
		lblTrngPhong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrngPhong.setBounds(48, 392, 131, 20);
		panel_1.add(lblTrngPhong);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(48, 490, 86, 20);
		panel_1.add(textField_7);

		JLabel lblDAna = new JLabel("D???? a??n ??a?? hoa??n tha??nh");
		lblDAna.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDAna.setBounds(48, 459, 131, 20);
		panel_1.add(lblDAna);

		JMenu menu1 = new JMenu();
		menu1.setBounds(0, 0, 184, 40);
		menu1.setText("  D???? A??n");
		menu1.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu1.setIcon(new javax.swing.ImageIcon("Image/home_1.png"));
		item1= new JMenuItem();
		bar1.add(menu1);		
		item1= new JMenuItem();
		item1.setText("Th??m D???? A??n");
		item1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item1.setIcon(new javax.swing.ImageIcon("Image/home.png"));
		item2= new JMenuItem();
		item2.setText("S????a Th??ng Tin D???? A??n");
		item2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item2.setIcon(new javax.swing.ImageIcon("Image/30e9d39543d14e5821889fda236fad5d.png"));		
		item3= new JMenuItem();
		item3.setText("Xo??a D???? A??n");
		item3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item3.setIcon(new javax.swing.ImageIcon("Image/logout.png"));	
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);


		JMenu menu2 = new JMenu();
		bar1.add(menu2);
		menu2.setBounds(184, 0, 183, 40);
		menu2.setText("  Nh??n S????");
		menu2.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu2.setIcon(new javax.swing.ImageIcon("Image/dichvu.png"));
		item4= new JMenuItem();
		item4.setText("Th??m Nh??n S????");
		item4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item4.setIcon(new javax.swing.ImageIcon("Image/contract.png"));
		item5= new JMenuItem();
		item5.setText("S????a Th??ng Tin Nh??n S????");
		item5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item5.setIcon(new javax.swing.ImageIcon("Image/30e9d39543d14e5821889fda236fad5d.png"));	
		item6= new JMenuItem();
		item6.setText("Xo??a Nh??n S????");
		item6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item6.setIcon(new javax.swing.ImageIcon("Image/logout.png"));


		menu2.add(item4);
		menu2.add(item5);
		menu2.add(item6);
		//	menu2.add(item7);

		JMenu menu3 = new JMenu();
		menu3.setBounds(367, 0, 183, 40);
		menu3.setText("  Pho??ng Ban");
		menu3.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu3.setIcon(new javax.swing.ImageIcon("Image/user-group-icon.png"));
		bar1.add(menu3);
		item8= new JMenuItem();
		item8.setText("S????a Th??ng Tin Pho??ng Ban");
		item8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item8.setIcon(new javax.swing.ImageIcon("Image/30e9d39543d14e5821889fda236fad5d.png"));	
		menu3.add(item8);


		JMenu menu4 = new JMenu();
		menu4.setBounds(550, 0, 183, 40);
		menu4.setText("   Ph??n C??ng");
		menu4.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu4.setIcon(new javax.swing.ImageIcon("Image/order-1.png"));	
		bar1.add(menu4);
		item9= new JMenuItem();
		item9.setText("Ph??n C??ng Nh??n S????");
		item9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item9.setIcon(new javax.swing.ImageIcon("Image/information.png"));
		item10= new JMenuItem();
		item10.setText("Lu??n Chuy????n Nh??n S????");
		item10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item10.setIcon(new javax.swing.ImageIcon("Image/system.png"));
		menu4.add(item9);
		menu4.add(item10);



		JMenu menu5 = new JMenu();
		menu5.setBounds(733, 0, 183, 40);
		menu5.setText("  Ch????m C??ng");
		menu5.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu5.setIcon(new javax.swing.ImageIcon("Image/e24f1be346a.png"));
		bar1.add(menu5);
		item11= new JMenuItem();
		item11.setText("Ch????m C??ng Nh??n S????");
		item11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item11.setIcon(new javax.swing.ImageIcon("Image/1368245115_total_plan_cost.png"));
		menu5.add(item11);

		JMenu menu6 = new JMenu();
		menu6.setBounds(916, 0, 184, 40);
		menu6.setText("   Ng??????i Du??ng");
		menu6.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu6.setIcon(new javax.swing.ImageIcon("Image/Login.png"));
		bar1.add(menu6);
		item12= new JMenuItem();
		item12.setText("??????i M????t Kh????u");
		item12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item12.setIcon(new javax.swing.ImageIcon("Image/icon-ols.png"));
		item7= new JMenuItem();
		item7.setText("Th??ng Tin V???? ????ng Du??ng");
		item7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		item7.setIcon(new javax.swing.ImageIcon("Image/tt1.png"));
		item14= new JMenuItem();
		item14.setText("Ma??n Hi??nh Chi??nh");
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



		String[]headers1 = {"Ma?? nh??n s???","H??? t??n","Gi???i t??nh","Ng??y sinh","T??n Ph??ng ban", "M?? Ph??ng Ban","Qu?? qu??n","?????a ch??? li??n h???","Tr???ng th??i","SDT","Lo???i Nh??n s???","CMND","Vai Tr??"};
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

		JLabel lblManhansu = new JLabel("M?? nh??n s???:");
		lblManhansu.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_5 = new JLabel("X??A NH??N S???");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 24));

		textMaNhanSu = new JTextField();
		textMaNhanSu.setColumns(10);

		JLabel lblTnNhnS = new JLabel("T??n nh??n s???:");
		lblTnNhnS.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textTenNhanSu = new JTextField();
		textTenNhanSu.setColumns(10);

		JLabel lblMaChucVu = new JLabel("Ch???c v???:");
		lblMaChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblGioiTinh = new JLabel("Gi???i t??nh:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNgaySinh = new JLabel("Ng??y sinh:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblTenPhongBan = new JLabel("T??n ph??ng ban:");
		lblTenPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblQuQun = new JLabel("Qu?? qu??n:");
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblSDT = new JLabel("S??? ??i???n tho???i:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblTrangThai = new JLabel("Tr???ng th??i:");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblDiaChiLH = new JLabel("?????a ch??? li??n h???:");
		lblDiaChiLH.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblLoiNhnS = new JLabel("Lo???i nh??n s???:");
		lblLoiNhnS.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cmbGioiTinh = new JComboBox();
		cmbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Ch???n"}));
		cmbGioiTinh.addItem("Nam");
		cmbGioiTinh.addItem("N???");

		textSDT = new JTextField();
		textSDT.setColumns(10);

		textTrangThai = new JTextField();
		textTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTrangThai.setText("0");
		textTrangThai.setColumns(10);

		textDCLH = new JTextField();
		textDCLH.setColumns(10);



		lblTmNhnS = new JLabel("T??m ki???m nh??n s???:");
		lblTmNhnS.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textTimKiem = new JTextField();
		textTimKiem.setColumns(10);

		lblHinThTheo = new JLabel("Hi???n th??? theo:");
		lblHinThTheo.setFont(new Font("Tahoma", Font.PLAIN, 15));


		cmbHienThi = new JComboBox();
		cmbHienThi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbHienThi.setModel(new DefaultComboBoxModel(new String[] {"Ch??a tham gia d??? ??n"}));




		btnLoc = new JButton("L???c");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scroll.setBackground(new Color(139, 0, 139));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(204, 204, 204));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		scroll.setViewportView(table);

		dateChooser1 = new JDateChooser();
		dateChooser1.setDateFormatString("yyyy-MM-dd");

		lblVaiTr = new JLabel("Vai tr??:");
		lblVaiTr.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cmbChucVu = new JComboBox();
		cmbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Kh??ng c??"}));


		cmbLoaiNS = new JComboBox();
		cmbLoaiNS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbLoaiNS.setModel(new DefaultComboBoxModel(new String[] {"Ch???n"}));

		cmbVaiTro = new JComboBox();
		cmbVaiTro.setModel(new DefaultComboBoxModel(new String[] {"Ch???n"}));
		cmbVaiTro.setFont(new Font("Tahoma", Font.PLAIN, 13));

		comboboxQQ = new JComboBox();
		comboboxQQ.setModel(new DefaultComboBoxModel(new String[] {"Ch???n"}));
		comboboxQQ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboboxQQ.addItem("An Giang");
		comboboxQQ.addItem("B?? R???a - V??ng T??u");
		comboboxQQ.addItem("B???c Giang");
		comboboxQQ.addItem("B???c K???n");
		comboboxQQ.addItem("B???c Li??u");
		comboboxQQ.addItem("B???c Ninh");
		comboboxQQ.addItem("B???n Tre");
		comboboxQQ.addItem("B??nh ?????nh");
		comboboxQQ.addItem("B??nh D????ng");
		comboboxQQ.addItem("B??nh Ph?????c");
		comboboxQQ.addItem("B??nh Thu???n");
		comboboxQQ.addItem("C?? Mau");
		comboboxQQ.addItem("C???n Th??");
		comboboxQQ.addItem("Cao B???ng");
		comboboxQQ.addItem("???? N???ng");
		comboboxQQ.addItem("?????k L???k");
		comboboxQQ.addItem("?????k N??ng");
		comboboxQQ.addItem("??i???n Bi??n");
		comboboxQQ.addItem("?????ng Nai");
		comboboxQQ.addItem("?????ng Th??p");
		comboboxQQ.addItem("Gia Lai");
		comboboxQQ.addItem("H?? Giang");
		comboboxQQ.addItem("H?? Nam");
		comboboxQQ.addItem("H?? N???i");
		comboboxQQ.addItem("H?? T??nh");
		comboboxQQ.addItem("H???i D????ng");
		comboboxQQ.addItem("H???i Ph??ng");
		comboboxQQ.addItem("H???u Giang");
		comboboxQQ.addItem("H??a B??nh");
		comboboxQQ.addItem("H??ng Y??n");
		comboboxQQ.addItem("Kh??nh H??a");
		comboboxQQ.addItem("Ki??n Giang");
		comboboxQQ.addItem("Kon Tum");
		comboboxQQ.addItem("Lai Ch??u");
		comboboxQQ.addItem("L??m ?????ng");
		comboboxQQ.addItem("L???ng S??n");
		comboboxQQ.addItem("L??o Cai");
		comboboxQQ.addItem("Long An");
		comboboxQQ.addItem("Nam ?????nh");
		comboboxQQ.addItem("Ngh??? An");
		comboboxQQ.addItem("Ninh B??nh");
		comboboxQQ.addItem("Ninh Thu???n");
		comboboxQQ.addItem("Ph?? Th???");
		comboboxQQ.addItem("Ph?? Y??n");
		comboboxQQ.addItem("Qu???ng B??nh");
		comboboxQQ.addItem("Qu???ng Nam");
		comboboxQQ.addItem("Qu???ng Ng??i");
		comboboxQQ.addItem("Qu???ng Ninh");
		comboboxQQ.addItem("Qu???ng Tr???");
		comboboxQQ.addItem("S??c Tr??ng");
		comboboxQQ.addItem("S??n La");
		comboboxQQ.addItem("T??y Ninh");
		comboboxQQ.addItem("Th??i B??nh");
		comboboxQQ.addItem("Th??i Nguy??n");
		comboboxQQ.addItem("Thanh H??a");
		comboboxQQ.addItem("Th???a Thi??n Hu???");
		comboboxQQ.addItem("Ti???n Giang");
		comboboxQQ.addItem("Th??nh ph??? H??? Ch?? Minh");
		comboboxQQ.addItem("Tr?? Vinh");
		comboboxQQ.addItem("Tuy??n Quang");
		comboboxQQ.addItem("V??nh Long");
		comboboxQQ.addItem("V??nh Ph??c");
		comboboxQQ.addItem("Y??n B??i");

		cmbLoaiNS.addItem("C??ng nh??n");
		cmbLoaiNS.addItem("Nh??n vi??n");
		cmbVaiTro.addItem("Th??? ??i???n");	
		cmbVaiTro.addItem("Th??? h??n");
		cmbVaiTro.addItem("Th??? x??y");
		cmbVaiTro.addItem("Th??? b?? t??ng");
		cmbVaiTro.addItem("Th??? ph??? h???");
		cmbVaiTro.addItem("L??i m??y m??c");
		cmbVaiTro.addItem("L??i ben");
		cmbVaiTro.addItem("L??i xe tr???n b?? t??ng");
		cmbVaiTro.addItem("Gi??m s??t c??ng tr??nh");
		cmbVaiTro.addItem("Gi??m s??t d??? ??n");
		cmbVaiTro.addItem("T?? v???n vi??n");
		cmbVaiTro.addItem("Ki???n tr??c s??");
		cmbVaiTro.addItem("K??? s?? x??y d???ng");


		lblCmnd = new JLabel("CMND:");
		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textCmnd = new JTextField();
		textCmnd.setColumns(10);

		btnThoat = new JButton("THO??T");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 25));

		btnXoa = new JButton("X??A");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 25));

		lblMaPhngBan = new JLabel("M?? ph??ng ban:");
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

		updateDataBang5();


		textMaNhanSu.setEditable(false);
		textTenNhanSu.setEditable(false);
		textCmnd.setEditable(false);
		textDCLH.setEditable(false);
		textSDT.setEditable(false);
		textMaPB.setEditable(false);
		textTenPB.setEditable(false);
		textTrangThai.setEditable(false);
		comboboxQQ.setEnabled(false);
		cmbChucVu.setEnabled(false);
		cmbLoaiNS.setEnabled(false);
		cmbVaiTro.setEnabled(false);
		cmbGioiTinh.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(bar1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
							.addGap(21))
						.addComponent(Khung, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(Khung, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(bar1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_Khung = new GroupLayout(Khung);
		gl_Khung.setHorizontalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(430)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblTnNhnS, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textTenNhanSu, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaChucVu, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(68)
									.addComponent(cmbChucVu, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(68)
									.addComponent(cmbGioiTinh, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(106)
							.addComponent(textTenPB, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblMaPhngBan, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblManhansu, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(106)
							.addComponent(textDCLH, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenPhongBan, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(316)
							.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(106)
							.addComponent(textMaNhanSu, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(433)
							.addComponent(textMaPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDiaChiLH, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(90)
							.addComponent(dateChooser1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLoiNhnS, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(90)
							.addComponent(comboboxQQ, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(90)
							.addComponent(textSDT, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSDT, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(90)
							.addComponent(cmbLoaiNS, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblQuQun, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(75)
							.addComponent(textTrangThai, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(75)
							.addComponent(cmbVaiTro, 0, 187, Short.MAX_VALUE))
						.addComponent(lblTrangThai, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(75)
							.addComponent(textCmnd, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
						.addComponent(lblVaiTr, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCmnd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addGap(80))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(205)
					.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(432)
					.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(252, Short.MAX_VALUE))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(130)
							.addComponent(textTimKiem, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
						.addComponent(lblTmNhnS, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addGap(248)
					.addComponent(lblHinThTheo, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(cmbHienThi, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(240))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(33)
					.addComponent(pnTable, GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
					.addGap(37))
		);
		gl_Khung.setVerticalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(25)
									.addComponent(lblTnNhnS, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(33)
									.addComponent(textTenNhanSu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMaChucVu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(6)
											.addComponent(cmbChucVu, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
									.addGap(2)
									.addComponent(cmbGioiTinh, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
							.addGap(24)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(5)
									.addComponent(textTenPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblMaPhngBan, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblManhansu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(66)
							.addComponent(textDCLH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(80)
							.addComponent(lblTenPhongBan, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(29)
							.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(12)
							.addComponent(textMaNhanSu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(88)
							.addComponent(textMaPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(57)
							.addComponent(lblDiaChiLH, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(29)
											.addComponent(dateChooser1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(21)
											.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblLoiNhnS, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
									.addGap(5)
									.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
										.addComponent(comboboxQQ, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(24)
											.addComponent(textSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(16)
											.addComponent(lblSDT, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(2)
									.addComponent(cmbLoaiNS, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(50)
									.addComponent(lblQuQun, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(3)
									.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(27)
											.addComponent(textTrangThai, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
										.addComponent(cmbVaiTro, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(19)
											.addComponent(lblTrangThai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
									.addGap(6)
									.addComponent(textCmnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblVaiTr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(51)
									.addComponent(lblCmnd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))))
					.addGap(7)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThoat))
					.addGap(7)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(2)
							.addComponent(textTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTmNhnS, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHinThTheo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(1)
							.addComponent(cmbHienThi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(pnTable, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
					.addGap(10))
		);
		Khung.setLayout(gl_Khung);
		contentPane.setLayout(gl_contentPane);
		btnLoc.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoa.addActionListener(this);

		cmbChucVu.addActionListener(this);
		cmbLoaiNS.addActionListener(this);
		cmbGioiTinh.addActionListener(this);
		comboboxQQ.addActionListener(this);
		cmbHienThi.addActionListener(this);

		table.addMouseListener(this);
		updatetk1();
		updatetk2();
		updatetk3();
		updatetk4();
		updatetk5();	
		updatetk6();
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

		if(o.equals(btnXoa)) {

			tableModel = (DefaultTableModel) table.getModel();
			int row= table.getSelectedColumn();
			if(row>=0) {
				int hoiNhac = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n mu???n x??a? ?","Ch?? ??",JOptionPane.YES_NO_OPTION);
				if(hoiNhac==JOptionPane.YES_OPTION ) {
					while(row!=-1) {
						int nhanSu= table.convertColumnIndexToModel(row);
						String maNhanSu= (String) table.getValueAt(row, 0);
						String ten = (String)table.getValueAt(row,1);
						String mapb = (String)table.getValueAt(row,5);
						tableModel.removeRow(nhanSu);
						row= table.getSelectedRow();
						QuanLiNhanSu_DAO qlns  = new QuanLiNhanSu_DAO();
						qlns.xoa(maNhanSu, ten, mapb);
						XoaTrong();
					}
					JOptionPane.showMessageDialog(this, "X??a th??nh c??ng");
				}

			}else
				JOptionPane.showMessageDialog(this, "Ch???n Sinh Vi??n c???n x??a");
		}





		if(o.equals(btnThoat))
		{
			dispose();
		}	

		if(o.equals(btnLoc)) {

			if(cmbHienThi.getSelectedItem().toString().equals("Ch??a tham gia d??? ??n")) {							
				tableModel = (DefaultTableModel)table.getModel();
				tableModel.setRowCount(0); 
				updateDataBang5();
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

	}
	
 
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row  = table.getSelectedRow();
		if(row >=0) {
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
		/////////////Ph???i Theo m???u///////////////////////
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienXoaNhanSu window = new GiaoDienXoaNhanSu();
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
