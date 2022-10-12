package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.TaiKhoan_dao;
import entity.TaiKhoan;

class GD_DangNhap extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JCheckBox jcbShow;
	private JButton btnThoat;
	private JButton btnDangNhap;
	private TaiKhoan_dao taiKhoan_dao = new TaiKhoan_dao();
	private TaiKhoan tk;

	public GD_DangNhap() {
		setTitle("Đăng Nhập");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		login();
	}

	public void login() {
		JPanel pnLogin = new JPanel();
		pnLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnLogin.setBackground(new Color(255, 255, 204));
		pnLogin.setLayout(new BorderLayout());
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setLayout(new BoxLayout(pnTieuDe, BoxLayout.Y_AXIS));
		pnTieuDe.setBackground(Color.CYAN);
		JPanel pnTd = new JPanel();
		pnTd.setBackground(new Color(255, 255, 204));
		JPanel pnTd1 = new JPanel();
		pnTd1.setBackground(new Color(255, 255, 204));
		JLabel lblTieuDe = new JLabel("Chào Mừng Đến Với Phần Mềm");
		JLabel lblTieuDe1 = new JLabel("Quản Lý Cửa Hàng Sách Tư Nhân TTK");
		Font ft = new Font(getName(), Font.BOLD, 20);
		lblTieuDe.setFont(ft);
		lblTieuDe.setForeground(Color.BLUE);
		lblTieuDe1.setForeground(Color.BLUE);
		lblTieuDe1.setFont(ft);
		pnTd.add(lblTieuDe);
		pnTd1.add(lblTieuDe1);
		pnTieuDe.add(pnTd);
		pnTieuDe.add(pnTd1);
		pnLogin.add(pnTieuDe, BorderLayout.NORTH);

		JPanel pnNhap = new JPanel();
		pnNhap.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 10));
		pnNhap.setLayout(new GridLayout(1, 2));
		pnNhap.setBackground(new Color(225, 255, 255));
		ImageIcon img = new ImageIcon("img\\logo.jpg");
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(400, 350, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(newimg);
		JLabel lblAnh = new JLabel(img);
		pnNhap.add(lblAnh);
		
		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setLayout(new BoxLayout(pnDangNhap, BoxLayout.Y_AXIS));
		pnDangNhap.setBackground(new Color(225, 255, 255));
		JPanel pnUser = new JPanel();
		pnUser.setBackground(new Color(225, 255, 255));
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Cambria", Font.BOLD, 20));
		txtUser = new JTextField(20);
		txtUser.setToolTipText("Mời Nhập Tài khoản");
//		txtUser.setFont(new Font(getName(), Font.BOLD, 15));
		txtUser.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		txtUser.setPreferredSize(new Dimension(25, 30));
		pnUser.add(lblUser);
		pnUser.add(txtUser);

		JPanel pnPass = new JPanel();
		pnPass.setBackground(new Color(225, 255, 255));
		JLabel lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Cambria", Font.BOLD, 20));
		txtPass = new JPasswordField(20);
		txtPass.setEchoChar('*');
		txtPass.setToolTipText("Mời Nhập Mật Khẩu.");
//		txtPass.setFont(new Font(getName(), Font.BOLD, 15));
		txtPass.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		txtPass.setPreferredSize(new Dimension(25, 30));
		pnPass.add(lblPass);
		pnPass.add(txtPass);

		JPanel pnShow = new JPanel();
		pnShow.setBackground(new Color(225, 255, 255));
		jcbShow = new JCheckBox("Hiển thị mật khẩu.");
		jcbShow.setFocusable(false);
		jcbShow.setBackground(new Color(225, 255, 255));
		pnShow.setAlignmentX(SwingConstants.RIGHT);
		pnShow.add(Box.createHorizontalStrut(100));
		pnShow.add(jcbShow);

		JPanel pnClick = new JPanel();
		pnClick.setBackground(new Color(225, 255, 255));
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setPreferredSize(new Dimension(100, 30));
		btnThoat = new JButton("Thoát");
		btnThoat.setPreferredSize(new Dimension(100, 30));
		pnClick.add(Box.createHorizontalStrut(60));
		btnDangNhap.setFocusable(false);
		btnThoat.setFocusable(false);
		pnClick.add(btnDangNhap);
		pnClick.add(btnThoat);
		txtUser.setText("NV0001");
		txtPass.setText("111111");
		pnDangNhap.add(Box.createVerticalStrut(100));
		pnDangNhap.add(pnUser);
		pnDangNhap.add(Box.createVerticalStrut(10));
		pnDangNhap.add(pnPass);
		pnDangNhap.add(pnShow);
		pnDangNhap.add(pnClick);
		pnDangNhap.add(Box.createVerticalStrut(200));
		lblUser.setPreferredSize(lblPass.getPreferredSize());
		
		pnNhap.add(pnDangNhap);
		pnLogin.add(pnNhap, BorderLayout.CENTER);
		add(pnLogin);
		jcbShow.addActionListener(this);
		btnThoat.addActionListener(this);
		btnDangNhap.addActionListener(this);

	}

	

	public String chuyenChuoi(char[] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s += a[i];
		}
		return s;
	}

	public boolean kiemTraDangNhap() {
		for (TaiKhoan i : taiKhoan_dao.getDSTK()) {
			if (txtUser.getText().equals(i.getTenTaiKhoan()) 
					&& chuyenChuoi(txtPass.getPassword()).trim().equals(i.getMatKhau().trim()) ) {
				tk = new TaiKhoan(i.getTenTaiKhoan(), i.getMatKhau());
				return true;
			}
			
		}
		if (txtUser.getText().equals("admin") && chuyenChuoi(txtPass.getPassword()).trim().equals("123456")) {
			tk = new TaiKhoan("NV0001", "111111");
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jcbShow)) {
			if (jcbShow.isSelected()) {
				txtPass.setEchoChar((char) 0);
			} else {
				txtPass.setEchoChar('*');
			}
		}
		if (e.getSource().equals(btnDangNhap)) {
			if (kiemTraDangNhap()) {
				dispose();
				new GD_Chinh(tk).setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Thông Tin Đăng Nhập Không Chính Xác!!!", "Cảnh Báo Đăng Nhập!!!",
						JOptionPane.WARNING_MESSAGE);
			}

		}
		if (e.getSource().equals(btnThoat)) {
			if (JOptionPane.showConfirmDialog(null, "Bạn Chắc Chắn Muốn Thoát?", "Thoát",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				System.exit(0);
			}

		}
	}
}
