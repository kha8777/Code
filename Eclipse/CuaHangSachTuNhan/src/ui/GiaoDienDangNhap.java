package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import uiTP.GiaoDienChinhTP;

public class GiaoDienDangNhap extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblNewLabel_4;
	public static JTextField txtTaiKhoan;
	public static JPasswordField passwordField;
	private JCheckBox showPassword;
	public static String tk = null;
	private JButton btnDangNhap;
	private JButton btnExit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienDangNhap frame = new GiaoDienDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GiaoDienDangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 402);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(230, 230, 250));
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel_4 = new JLabel(new ImageIcon("Image/logo72.png"));
		lblNewLabel_4.setBounds(50, 15, 100, 80);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Chào Mừng Các Bạn Đến Với Ứng Dụng Quản Lí ");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(202, 11, 544, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuanLiLao = new JLabel("Lao Động Công Ty Cổ Phần Hưng Thịnh Icons");
		lblQuanLiLao.setForeground(new Color(30, 144, 255));
		lblQuanLiLao.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuanLiLao.setBounds(226, 45, 452, 33);
		contentPane.add(lblQuanLiLao);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(10, 91, 668, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(372, 78, 205, 20);
		panel.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(372, 52, 172, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblTaiKhoan = new JLabel("Mật Khẩu :");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTaiKhoan.setBounds(372, 100, 172, 25);
		panel.add(lblTaiKhoan);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon("Image/logod.png"));
		lblNewLabel_2.setBounds(42, 11, 275, 250);
		panel.add(lblNewLabel_2);
		
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setBackground(new Color(100, 149, 237));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnDangNhap.setBounds(374, 189, 97, 23);
		panel.add(btnDangNhap);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(372, 125, 205, 20);
		panel.add(passwordField);
		
		showPassword = new JCheckBox("Hiển Thị Mật Khẩu");
		showPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
		showPassword.setBounds(460, 146, 117, 23);
		panel.add(showPassword);
		
		btnExit = new JButton();
		btnExit.setBackground(new Color(100, 149, 237));
		btnExit.setIcon(new ImageIcon("Image/exit.png"));
		btnExit.setBounds(481, 189, 92, 23);
		panel.add(btnExit);
		btnExit.addActionListener(this);
		showPassword.addActionListener(this);
		btnDangNhap.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnDangNhap)) {
			KiemTraDN();
		}
		if(o.equals(showPassword)) {
			 if (showPassword.isSelected()) {
	                passwordField.setEchoChar((char) 0);
	            } else {
	                passwordField.setEchoChar('*');
	            }
		}
		if(o.equals(btnExit)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát ?","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION) {
				dispose();			
			}
		}
	}
	public void KiemTraDN()
	{
		
		try {			
			String url = "jdbc:sqlserver://localhost:1433;databasename=quanlilaodong";
			String user = "sa";
			String pass = "123456";
			Connection con = DriverManager.getConnection(url,user,pass);
			String sql = "Select * from TAIKHOAN \n"+"where TaiKhoan=? and MatKhau=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, txtTaiKhoan.getText());
			ps.setString(2, passwordField.getText());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				 tk= rs.getString(2);
				if(tk.equals("qlns"))
				{
					JOptionPane.showMessageDialog(this, "Đăng Nhập Thành Công\nChào Mừng Quản Lí Nhân Sự");
				
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							GiaoDienChinh main = new GiaoDienChinh();
							main.setVisible(true);
							main.setLocationRelativeTo(null);
						}
					});
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(this, "Đăng Nhập Thành Công\nChào Mừng Trưởng Phòng");
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							GiaoDienChinhTP main = new GiaoDienChinhTP();
							main.setVisible(true);
							main.setLocationRelativeTo(null);
						}
					});
					setVisible(false);
				}
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Đăng Nhập Không Thành Công Vui Lòng kiểm Tra lại Mật khẩu Hoặc Tên Tài Khoản");
			}
		}
		catch(Exception ex)
		{
			//JOptionPane.showMessageDialog(this, "Không thể đăng ký");
			ex.printStackTrace();
			
		}
	}

	public static JTextField getTxtTaiKhoan() {
		return txtTaiKhoan;
	}

	public static JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public static String getTk() {
		return tk;
	}

	public static void setTk(String tk) {
		GiaoDienDangNhap.tk = tk;
	}

	

	
}
