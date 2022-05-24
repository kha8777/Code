package ui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.Icon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaoDienAbout extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnthoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienAbout frame = new GiaoDienAbout();
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
	public GiaoDienAbout() {
		setTitle("Thông tin về ứng dụng quản lí lao động");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 908, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		btnthoat = new JButton("Thoat");
		btnthoat.setBounds(790, 260, 100, 30);
		btnthoat.addActionListener(this);
		contentPane.add(btnthoat);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("Image/x1.png"));
		lblNewLabel.setBounds(10, 11, 243, 264);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("Image/rsz_2gioithieu.png"));
		lblNewLabel_1.setForeground(new Color(51, 204, 255));
		lblNewLabel_1.setBounds(263, 11, 635, 264);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon("Image/rsz_eclipse-icon.png"));
		lblNewLabel_2.setBounds(34, 365, 70, 70);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(new ImageIcon("Image/rsz_sql.png"));
		lblNewLabel_2_1.setBounds(34, 466, 70, 70);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel(new ImageIcon("Image/rsz_jdbc.png"));
		lblNewLabel_2_1_1.setBounds(34, 568, 70, 70);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel(new ImageIcon("Image/rsz_jcder_1.png"));
		lblNewLabel_2_1_1_1.setBounds(34, 664, 70, 70);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Các công nghệ được sử dụng:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 300, 232, 54);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("JAVA SE-14 (JDK-14.0.2) ");
		lblNewLabel_4.setBounds(144, 380, 342, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Phiên bản : Eclipse 2020-06(4.16.0) ");
		lblNewLabel_4_1.setBounds(144, 365, 342, 25);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Phiên bản : SQL SEVER 2012 ");
		lblNewLabel_4_1_1.setBounds(144, 466, 342, 25);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("Eclipse là một môi trường phát triển tích hợp dùng "
				+ "cho lập trình máy tính., Nó chứa một không gian làm việc cơ sở và một hệ thống plug-in để mở rộng để tùy chỉnh môi trường. ");
		lblNewLabel_5.setBounds(144, 388, 764, 34);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_2 = new JLabel("plug-in \u0111\u1EC3 m\u1EDF r\u1ED9ng \u0111\u1EC3 t\u00F9y ch\u1EC9nh m\u00F4i tr\u01B0\u1EDDng");
		lblNewLabel_4_2.setBounds(144, 410, 342, 25);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_6 = new JLabel("Microsoft SQL Server l\u00E0 m\u1ED9t h\u1EC7 qu\u1EA3n tr\u1ECB c\u01A1 s\u1EDF d\u1EEF li\u1EC7u quan h\u1EC7 \u0111\u01B0\u1EE3c ph\u00E1t tri\u1EC3n b\u1EDFi Microsoft L\u00E0 m\u1ED9t m\u00E1y ch\u1EE7 c\u01A1 s\u1EDF d\u1EEF li\u1EC7u, n\u00F3 l\u00E0");
		lblNewLabel_6.setBounds(144, 479, 754, 25);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("m\u1ED9t s\u1EA3n ph\u1EA9m ph\u1EA7n m\u1EC1m c\u00F3 ch\u1EE9c n\u0103ng ch\u00EDnh l\u00E0 l\u01B0u tr\u1EEF v\u00E0 truy xu\u1EA5t d\u1EEFli\u1EC7u theo y\u00EAu c\u1EA7u c\u1EE7a c\u00E1c \u1EE9ng d\u1EE5ng ph\u1EA7n m\u1EC1m kh\u00E1c.");
		lblNewLabel_4_1_1_1.setBounds(144, 495, 764, 25);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("Phi\u00EAn b\u1EA3n : JDBC 8.8.2.jre13");
		lblNewLabel_7.setBounds(144, 568, 631, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Java Database Connectivity l\u00E0 m\u1ED9t API \u0111\u01B0\u1EE3c thi\u1EBFt k\u1EBF d\u00E0nh cho ng\u00F4n ng\u1EEF l\u1EADp tr\u00ECnh Java h\u1ED7 tr\u1EE3 Java trong vi\u1EC7c truy c\u1EADp C\u01A1 S\u1EDF D\u1EEF Li\u1EC7u. \r\n ");
		lblNewLabel_8.setBounds(144, 578, 810, 25);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("N\u00F3 g\u1ED3m c\u00F3 nh\u1EEFng ph\u01B0\u01A1ng th\u1EE9c th\u1EF1c hi\u1EC7n truy v\u1EA5n v\u00E0 c\u1EADp nh\u1EADt CSDL gi\u00E1n ti\u1EBFp qua Java. ");
		lblNewLabel_9.setBounds(144, 593, 775, 25);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Phi\u00EAn b\u1EA3n : JCalendar 1.4");
		lblNewLabel_10.setBounds(144, 664, 330, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("JCalendar l\u00E0 m\u1ED9t bean ch\u1ECDn ng\u00E0y c\u1EE7a Java \u0111\u1EC3 ch\u1ECDn ng\u00E0y b\u1EB1ng \u0111\u1ED3 th\u1ECB. JCalendar bao g\u1ED3m m\u1ED9t s\u1ED1 \u0111\u1EADu Java kh\u00E1c, m\u1ED9t JDayChooser");
		lblNewLabel_11.setBounds(144, 677, 786, 25);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(", m\u1ED9t JMonthChooser v\u00E0 m\u1ED9t JYearChooser.");
		lblNewLabel_12.setBounds(144, 699, 640, 14);
		contentPane.add(lblNewLabel_12);
		
	
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnthoat)) {
			
			setVisible(false);

		}
	}
}
