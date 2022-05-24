package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Entity.PhongBan;
import Entity.TKDuAn;
import Entity.TKDuAnDaHoanThanh;
import Entity.TKNhanSu;
import Entity.TKNhanSuChuaThamGia;
import Entity.TKNhanSuDaThamGia;
import Entity.TKPhongBan;
import connectDB.ConnectDB;
import dao.QuanLiPhongBan_DAO;
import dao.QuanLiThongKe_DAO;

public class GiaoDienSuaPhongBan extends JFrame implements ActionListener ,MouseListener{
	private JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item14;
	private JButton btnNewButton,btnSua;
	private JPanel contentPane;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtTenPhongBan;
	private JTextField txtTenTruongPhong;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtmaPP;
	QuanLiPhongBan_DAO qlpp= new QuanLiPhongBan_DAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				GiaoDienSuaPhongBan main = new GiaoDienSuaPhongBan();
				main.setVisible(true);
				main.setLocationRelativeTo(null);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GiaoDienSuaPhongBan() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar bar1 = new JMenuBar();
		bar1.setBounds(206, 80, 1150, 40);
		bar1.setForeground(new Color(51, 255, 51));
		bar1.setForeground(Color.blue);
		bar1.setLayout(null);
		contentPane.add(bar1);	
		
		JPanel panel = new JPanel();
		panel.setBounds(250, 0, 1084, 81);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ỨNG DỤNG QUẢN LÍ LAO ĐỘNG CÔNG TY HƯNG THỊNH");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
		lblNewLabel.setBounds(40, 11, 1034, 59);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("H2L2");
		lblNewLabel_1.setForeground(new Color(51, 0, 255));
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_1.setBounds(1140, 11, 187, 68);
		panel.add(lblNewLabel_1);
		
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
		item9.addActionListener(this);
		item10.addActionListener(this);
		item11.addActionListener(this);
		item14.addActionListener(this);
		item12.addActionListener(this);
		
		
		lblNewLabel_4 = new JLabel(new ImageIcon("Image/logo72.png"));
		lblNewLabel_4.setBounds(72, 5, 90, 110);
		contentPane.add(lblNewLabel_4);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(211, 211, 211));
		panel_3.setBounds(206, 118, 1144, 543);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		 btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("Image/exit.png"));
		btnNewButton.setBounds(666, 147, 124, 27);
		panel_3.add(btnNewButton);
		
		txtTenPhongBan = new JTextField();
		txtTenPhongBan.setEditable(false);
		txtTenPhongBan.setBounds(98, 105, 320, 20);
		panel_3.add(txtTenPhongBan);
		txtTenPhongBan.setColumns(10);
		
		txtTenTruongPhong = new JTextField();
		txtTenTruongPhong.setBounds(98, 154, 320, 20);
		panel_3.add(txtTenTruongPhong);
		txtTenTruongPhong.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Phòng Ban:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(98, 32, 166, 22);
		panel_3.add(lblNewLabel_2);
		String[]headers1 = {"Mã Phòng Ban","Tên Phòng Ban","Số nhân Sự","Tên Trưởng Phòng"};
		tableModel = new DefaultTableModel(headers1,0);
		JPanel pnTable= new JPanel();
		pnTable.setBounds(50, 226,1044,255);
		pnTable.setBackground(new Color(100, 149, 237));
	//	pnTable.setBackground(new Color(204, 204, 204));
		pnTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh Sách Phòng Ban", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
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
		scroll.setBackground(new Color(102, 0, 102));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(204, 204, 204));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		scroll.setViewportView(table);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên Phòng Ban:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(98, 82, 166, 22);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tên Trưởng Phòng:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_2.setBounds(98, 134, 166, 22);
		panel_3.add(lblNewLabel_2_2);
		
		 btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(479, 149, 138, 27);
		panel_3.add(btnSua);
		
		txtmaPP = new JTextField();
		txtmaPP.setEditable(false);
		txtmaPP.setColumns(10);
		txtmaPP.setBounds(98, 53, 320, 20);
		panel_3.add(txtmaPP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(0, 118, 205, 543);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(0, 0, 250, 39);
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("Thống Kê");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(51, 0, 111, 39);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(48, 144, 86, 20);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(48, 283, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(48, 214, 86, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(48, 356, 86, 20);
		panel_1.add(textField_3);
		
		JLabel label_1 = new JLabel("Tổng Số Nhân Sự");
		label_1.setBounds(48, 113, 131, 20);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Tổng số dự án");
		label_2.setBounds(48, 183, 131, 20);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("NS chưa tham gia DA");
		label_3.setBounds(48, 252, 147, 20);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Số phòng ban");
		label_4.setBounds(48, 325, 131, 20);
		panel_1.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(48, 423, 86, 20);
		panel_1.add(textField_4);
		
		JLabel lblNsThamGia = new JLabel("NS tham gia dự án");
		lblNsThamGia.setBounds(48, 392, 131, 20);
		panel_1.add(lblNsThamGia);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(48, 490, 86, 20);
		panel_1.add(textField_5);
		btnNewButton.addActionListener(this);
		btnSua.addActionListener(this);
		table.addMouseListener(this);
		JLabel label_6 = new JLabel("Dự án đã hoàn thành");
		label_6.setBounds(48, 459, 131, 20);
		panel_1.add(label_6);
		ConnectDB.getInstance().Connect();
		updatetk1();
		updatetk2();
		updatetk3();
		updatetk4();
		updatetk5();	
		updatetk6();
		updateDatabang() ;
		//updateDatacombobox();
		
		
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
			textField_4.setText(tk);
		
		}
	}
	public void updatetk5(){
		QuanLiThongKe_DAO qltk = new QuanLiThongKe_DAO();
		List<TKDuAnDaHoanThanh>list =  qltk.TKDuAnDaHoanThanh();
		for(TKDuAnDaHoanThanh bg : list)
		{		
			String tk = bg.getTK().toString();
			textField_5.setText(tk);
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
	public void updateDatabang() {
		QuanLiPhongBan_DAO qlpp = new QuanLiPhongBan_DAO();
		List<PhongBan>list =  qlpp.docpp();
		for(PhongBan bg : list)
		{
			String[] rowdata = {bg.getMaPhongBan(),bg.getTenPhongBan(),bg.getTruongPhong(),bg.getSoLuongNhanSu()+""};
			tableModel.addRow(rowdata);			
		}
		table.setModel(tableModel);
	}
	
	
	
//@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(item9)) {
			
				new GiaoDienPhanCong().setVisible(true);
				setVisible(false);
			
		}
		if(o.equals(btnSua)) {
			int  row = table.getSelectedRow();
					if(row >= 0) {
						if(qlpp.suaphongban(txtmaPP.getText(), txtTenTruongPhong.getText())) {
							tableModel = (DefaultTableModel)table.getModel();
							tableModel.setRowCount(0); 
							updateDatabang();	
							JOptionPane.showMessageDialog(this, "sửa tên trưởng phòng thành công");
						}
					}else {
						JOptionPane.showMessageDialog(this, "chưa chọn phòng ban cần sửa");
					}
						
		}
		if(o.equals(btnNewButton)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát ?","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION) {
				dispose();			
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

public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
  int row = table.getSelectedRow();
  if(row >= 0) {
	  txtmaPP.setText(table.getValueAt(row, 0).toString());
	  txtTenPhongBan.setText(table.getValueAt(row, 1).toString());
	  txtTenTruongPhong.setText(table.getValueAt(row, 3).toString());
  }
}

public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
