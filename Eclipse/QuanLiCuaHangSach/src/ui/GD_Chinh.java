package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import connectDB.ConnectDB;

public class GD_Chinh extends JFrame implements ActionListener{
	//Khai báo
	private JMenuBar mnBar;
	private JMenu mnSach, mnKhachHang, mnNhanVien, mnHoaDon, mnThongKe;
	private JMenuItem mnItemQuanLiSach, mnItemTimSach, mnItemQuanLiKH, mnItemTimKH,
			mnItemQuanLiNV, mnItemTimNV, mnItemQuanLiHD, mnItemTimHD, mnItemDoanhThu, mnItemSachChay;
	private JLabel lbAvatar;
    
    public GD_Chinh() {
    	
    	setTitle("Ứng dụng quản lí cửa hàng sách tư nhân TTK");
    	
    	//Kết nối cơ sở dữ liệu
    	
    	ConnectDB.getInstance().connect();
    	
    	//Khởi tạo
    	
        lbAvatar = new JLabel();
        mnBar = new JMenuBar();
        mnSach = new JMenu();
        mnItemQuanLiSach = new JMenuItem();
        mnItemTimSach = new JMenuItem();
        mnKhachHang = new JMenu();
        mnItemQuanLiKH = new JMenuItem();
        mnItemTimKH = new JMenuItem();
        mnNhanVien = new JMenu();
        mnItemQuanLiNV = new JMenuItem();
        mnItemTimNV = new JMenuItem();
        mnHoaDon = new JMenu();
        mnItemQuanLiHD = new JMenuItem();
        mnItemTimHD = new JMenuItem();
        mnThongKe = new JMenu();
        mnItemDoanhThu = new JMenuItem();
        mnItemSachChay = new JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbAvatar.setIcon(new javax.swing.ImageIcon("img\\DaiDien.jpg")); // NOI18N

        mnSach.setBackground(new java.awt.Color(51, 51, 255));
        mnSach.setText("Sách");
        mnSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnSach.setMinimumSize(new java.awt.Dimension(100, 40));
        mnSach.setPreferredSize(new java.awt.Dimension(100, 40));

        mnItemQuanLiSach.setText("Quản lí sách");
        mnSach.add(mnItemQuanLiSach);

        mnItemTimSach.setText("Tìm sách");
        mnSach.add(mnItemTimSach);

        mnBar.add(mnSach);

        mnKhachHang.setText("Khách hàng");
        mnKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnKhachHang.setPreferredSize(new java.awt.Dimension(150, 40));

        mnItemQuanLiKH.setText("Quản lí khách hàng");
        mnKhachHang.add(mnItemQuanLiKH);

        mnItemTimKH.setText("Tìm khách hàng");
        mnKhachHang.add(mnItemTimKH);

        mnBar.add(mnKhachHang);

        mnNhanVien.setText("Nhân Viên");
        mnNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnNhanVien.setPreferredSize(new java.awt.Dimension(150, 40));

        mnItemQuanLiNV.setText("Quản lí nhân viên");
        mnNhanVien.add(mnItemQuanLiNV);

        mnItemTimNV.setText("Tìm nhân viên");
        mnNhanVien.add(mnItemTimNV);

        mnBar.add(mnNhanVien);

        mnHoaDon.setText("Hóa đơn");
        mnHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnHoaDon.setPreferredSize(new java.awt.Dimension(140, 40));

        mnItemQuanLiHD.setText("Quản lí hóa đơn");
        mnHoaDon.add(mnItemQuanLiHD);

        mnItemTimHD.setText("Tìm hóa đơn");
        mnHoaDon.add(mnItemTimHD);

        mnBar.add(mnHoaDon);

        mnThongKe.setText("Thống kê");
        mnThongKe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnThongKe.setPreferredSize(new java.awt.Dimension(140, 40));

        mnItemDoanhThu.setText("Doanh thu");
        mnThongKe.add(mnItemDoanhThu);

        mnItemSachChay.setText("Sách bán chạy");
        mnThongKe.add(mnItemSachChay);

        mnBar.add(mnThongKe);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAvatar)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAvatar)
        );

        pack();
        
        mnItemQuanLiSach.addActionListener(this);
        mnItemTimSach.addActionListener(this);
        mnItemQuanLiKH.addActionListener(this);
        mnItemTimKH.addActionListener(this);
        mnItemQuanLiNV.addActionListener(this);
        mnItemTimNV.addActionListener(this);
        mnItemQuanLiHD.addActionListener(this);
        mnItemTimHD.addActionListener(this);
        mnItemDoanhThu.addActionListener(this);
        mnItemSachChay.addActionListener(this);
        
        
    }// </editor-fold>                          

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_Chinh().setVisible(true);
            }
        });
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o.equals(mnItemQuanLiSach)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GD_QuanLiSach main = new GD_QuanLiSach();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
					
				}
			});
			setVisible(false);
		}
		
		if(o.equals(mnItemQuanLiNV)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GD_QuanLiNhanVien main = new GD_QuanLiNhanVien();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
					
				}
			});
			setVisible(false);
		}
		
		if(o.equals(mnItemQuanLiKH)) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					GD_QuanLiKhachHang main = new GD_QuanLiKhachHang();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
					
				}
			});
			setVisible(false);
		}
	}
                 
}
