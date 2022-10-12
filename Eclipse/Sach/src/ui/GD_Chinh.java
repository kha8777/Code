 package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entity.TaiKhoan;



@SuppressWarnings("serial")
public class GD_Chinh extends JFrame implements MouseListener, ActionListener {
	// thống kê
	private static JTextField txtSoSachConLai;
	private static JTextField txtSoSachDaNhap;
	private static JTextField txtTongSoNhanVien;
	private static JTextField txtTongSoKhachHang;
	
	// thống kê
	private TaiKhoan tk;
	private JTabbedPane jTabQuanLy;
	private static JTextField txtTongNS;
	
	private JMenu mnHelp;
	private JMenuItem mntmClose, mntmDangXuat, mntmAbout;


	public GD_Chinh() {
		
	}
	public GD_Chinh( TaiKhoan taiKhoan) {
		tk= taiKhoan;
		setSize(1200, 720);
		setTitle("ỨNG DỤNG QUẢN LÝ CỬA HÀNG SÁCH TƯ NHÂN TTK");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		addControl();
	}

	public void addControl() {
		// NOURTH
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBackground(new Color(255, 204, 255));
		pnTieuDe.setPreferredSize(new Dimension(0, 90));
		pnTieuDe.setLayout(new BoxLayout(pnTieuDe, BoxLayout.X_AXIS));
		JLabel lblTieuDe = new JLabel("Ứng Dụng Quản Lý Cửa hàng sách tư nhân TTK");
		lblTieuDe.setFont(new Font(getName(), Font.BOLD | Font.ITALIC, 30));
		lblTieuDe.setForeground(new Color(0, 117, 253));
		ImageIcon img = new ImageIcon("img\\logod.jpg");
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(newimg);
		JLabel lblLogo = new JLabel(img);

		pnTieuDe.add(Box.createHorizontalStrut(50));
		pnTieuDe.add(lblLogo);
		pnTieuDe.add(Box.createRigidArea(new Dimension(200, 0)));
		pnTieuDe.add(lblTieuDe);
		getContentPane().add(pnTieuDe, BorderLayout.NORTH);

		// NOURTH
//		// WEST
//		JPanel pnWest = new JPanel();
//		pnWest.setLayout(new BorderLayout());
//		JLabel lblTDThongKe = new JLabel("Thống Kê");
//		lblTDThongKe.setFont(new Font(getName(), Font.BOLD, 20));
//		lblTDThongKe.setForeground(Color.WHITE);
//		lblTDThongKe.setHorizontalAlignment(SwingConstants.CENTER);
//		pnWest.add(lblTDThongKe, BorderLayout.NORTH);
//		pnWest.setBackground(Color.BLUE);
//		JPanel pnThongKe = new JPanel();
//		pnThongKe.setLayout(new GridLayout(6, 1));
//		pnWest.setPreferredSize(new Dimension(200, 0));
//		Font ft = new Font("arial", Font.BOLD, 12);
//
//		// tổng số sách đã nhập
//		JPanel pnSachNhap = new JPanel();
//		pnSachNhap.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));
//		pnSachNhap.setBackground(Color.LIGHT_GRAY);
//		JLabel lblSoSachDaNhap = new JLabel("Số sách đã nhập");
//		lblSoSachDaNhap.setFont(ft);
//		lblSoSachDaNhap.setHorizontalAlignment(SwingConstants.LEFT);
//		txtSoSachDaNhap = new JTextField(12);
//		txtSoSachDaNhap.setEditable(false);
//		pnSachNhap.add(lblSoSachDaNhap);
//		pnSachNhap.add(txtSoSachDaNhap);
//
//		// tổng số sách còn lại
//		JPanel pnSachConLai = new JPanel();
//		pnSachConLai.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));
//		pnSachConLai.setBackground(Color.LIGHT_GRAY);
//		JLabel lblSachConLai = new JLabel("Số sách còn lại");
//		lblSachConLai.setFont(ft);
//		lblSachConLai.setHorizontalAlignment(SwingConstants.LEFT);
//		txtSoSachConLai = new JTextField(12);
//		txtSoSachConLai.setEditable(false);
//		pnSachConLai.add(lblSachConLai);
//		pnSachConLai.add(txtSoSachConLai);
//
//		// Tổng số nhân viên
//		JPanel pnNhanVien = new JPanel();
//		pnNhanVien.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));
//		pnNhanVien.setBackground(Color.LIGHT_GRAY);
//		JLabel lblNhanVien = new JLabel("Tổng số nhân viên");
//		lblNhanVien.setFont(ft);
//		lblNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
//		txtTongSoNhanVien = new JTextField(12);
//		txtTongSoNhanVien.setEditable(false);
//		pnNhanVien.add(lblNhanVien);
//		pnNhanVien.add(txtTongSoNhanVien);
//
//		// Tổng số khách hàng
//		JPanel pnKhachHang = new JPanel();
//		pnKhachHang.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));
//		pnKhachHang.setBackground(Color.LIGHT_GRAY);
//		JLabel lblKhachHang = new JLabel("Tổng số khách hàng");
//		lblKhachHang.setFont(ft);
//		lblKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
//		txtTongSoKhachHang = new JTextField(12);
//		txtTongSoKhachHang.setEditable(false);
//		pnKhachHang.add(lblKhachHang);
//		pnKhachHang.add(txtTongSoKhachHang);
//
//		
//
//		pnThongKe.add(pnSachNhap);
//		pnThongKe.add(pnSachConLai);
//		pnThongKe.add(pnNhanVien);
//		pnThongKe.add(pnKhachHang);
//		pnThongKe.setBackground(Color.LIGHT_GRAY);
//		pnWest.add(pnThongKe, BorderLayout.CENTER);
//		getContentPane().add(pnWest, BorderLayout.WEST);
		// West
		// Center
		
//		loadDuLieuThongKe();
		jTabQuanLy = new JTabbedPane();
		jTabQuanLy.addTab("Sách", new ImageIcon("img\\icon\\sach.png"), new GD_QuanLiSach().tabSach());
		jTabQuanLy.addTab("Khách hàng", new ImageIcon("img\\icon\\khachHang.png"), new GD_QuanLiSach().tabSach());
		jTabQuanLy.addTab("Nhân viên",new ImageIcon("img\\icon\\nhanVien.png"),new GD_QuanLiSach().tabSach());
		jTabQuanLy.addTab("Báo cáo",new ImageIcon("img\\icon\\baoCao.jpg"),new GD_QuanLiSach().tabSach());
		jTabQuanLy.addTab("Tài Khoản", new ImageIcon("img\\icon\\taiKhoan.png") ,new GD_QuanLiSach().tabSach());
		jTabQuanLy.addTab("Trợ giúp", new ImageIcon("img\\icon\\troGiup.png"),new GD_QuanLiSach().tabSach());
		jTabQuanLy.setSelectedIndex(-1);
		getContentPane().add(jTabQuanLy, BorderLayout.CENTER);
		
		jTabQuanLy.addMouseListener(this);
		// Center
		
		controlMenu();
		
	}
	
	
	/**
	 * Add giao diện menu
	 */
	public void controlMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setMnemonic('F');
		menuBar.add(mnNewMenu);
		
		mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.setIcon(new ImageIcon("img\\icon\\logout.jpg"));
		mnNewMenu.add(mntmDangXuat);
		
		mntmClose = new JMenuItem("Đóng");
		mntmClose.setIcon(new ImageIcon("img\\icon\\close.jpg"));
		mnNewMenu.add(mntmClose);
		
		mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon("img\\icon\\about.jpg"));
		mnHelp.add(mntmAbout);
		mntmAbout.addActionListener(this);
		mntmDangXuat.addActionListener(this);
		mntmClose.addActionListener(this);
	}
	
	/**
	 * show thông tin app
	 */
	public void showAbout() {
		JPanel pnAbout = new JPanel();
		getContentPane().add(pnAbout, BorderLayout.CENTER);
		pnAbout.setLayout(new BorderLayout(0, 0));
		
		JPanel pnVersion = new JPanel();
		pnAbout.add(pnVersion, BorderLayout.WEST);
		pnVersion.setLayout(new BorderLayout(0, 0));
		
		JLabel lblVersion1 = new JLabel("Phiên bản:    ");
		pnVersion.add(lblVersion1, BorderLayout.NORTH);
		
		JLabel lblAuthor1 = new JLabel("Tác giả:");
		lblAuthor1.setVerticalAlignment(SwingConstants.TOP);
		pnVersion.add(lblAuthor1);
		
		JPanel pnAuthor = new JPanel();
		pnAbout.add(pnAuthor, BorderLayout.CENTER);
		pnAuthor.setLayout(new BorderLayout(0, 0));
		
		JLabel lblVersion2 = new JLabel("V1.0.0");
		pnAuthor.add(lblVersion2, BorderLayout.NORTH);
		
		JLabel lblAuthor2 = new JLabel("<html>\r\n• Trần Vĩnh Kha<br>\r\n• Trần Lâm Trung Thịnh <br>\r\n• Bùi Ngọc Thu<br>\r\n</html>");
		lblAuthor2.setVerticalAlignment(SwingConstants.TOP);
		pnAuthor.add(lblAuthor2);
		
		JOptionPane.showOptionDialog(this, pnAbout, "About", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[] {"Ok"}, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == mntmAbout) {
			showAbout();
		}
		if (action == mntmDangXuat) {
			setVisible(false);
			dispose();
			new GD_DangNhap().setVisible(true);
		}
		if (action == mntmClose) {
			System.exit(EXIT_ON_CLOSE);
		}
	}
	
//	public static void loadDuLieuThongKe() {
//		ThongKe thongKe = thongKe_dao.getThongKe();
//		txtTongNS.setText(String.valueOf(thongKe.getTongNhanSu()));
//		txtTongDA.setText(String.valueOf(thongKe.getTongDuAn()));
//		txtNSKhongTG.setText(String.valueOf(thongKe.getNsChuaThamGiaDA()));
//		txtPhongBan.setText(String.valueOf(thongKe.getTongPhongBan()));
//		txtNSDaTG.setText(String.valueOf(thongKe.getTongDAThiCong()));
//		txtDAHoanThanh.setText(String.valueOf(thongKe.getTongDAHoanThanh()));
//	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int index = jTabQuanLy.getSelectedIndex();
		jTabQuanLy.removeAll();
//		loadDuLieuThongKe();
		jTabQuanLy.addTab("Sách", new ImageIcon("img\\icon\\sach.png"), new GD_QuanLiSach().tabSach());
		jTabQuanLy.addTab("Khách hàng", new ImageIcon("img\\icon\\khachHang.png"), new GD_QuanLiSach().tabSach());
		jTabQuanLy.addTab("Nhân viên",new ImageIcon("img\\icon\\nhanVien.png"),new GD_QuanLiSach().tabSach());
		jTabQuanLy.addTab("Báo cáo",new ImageIcon("img\\icon\\baoCao.jpg"),new GD_QuanLiSach().tabSach());
		jTabQuanLy.addTab("Tài Khoản", new ImageIcon("img\\icon\\taiKhoan.png") ,new GD_QuanLiSach().tabSach());
		jTabQuanLy.addTab("Trợ giúp", new ImageIcon("img\\icon\\troGiup.png"),new GD_QuanLiSach().tabSach());
		jTabQuanLy.setSelectedIndex(index);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
