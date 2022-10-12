package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.Sach_dao;
import entity.Sach;

public class GD_QuanLiSach extends JFrame implements ActionListener{
	//Khai báo
		private JMenuBar mnBar;
		private JMenu mnSach, mnKhachHang, mnNhanVien, mnHoaDon, mnThongKe;
		private JMenuItem mnItemQuanLiSach, mnItemTimSach, mnItemQuanLiKH, mnItemTimKH,
				mnItemQuanLiNV, mnItemTimNV, mnItemQuanLiHD, mnItemTimHD, mnItemDoanhThu, mnItemSachChay;
		private JPanel pnTacVu, pnTieuDe, pnThongTin; 
		private JLabel lbTieuDe, lbMaSach, lbTenSach, lbKichThuoc, lbNgayPhatHanh, lbLoaiBia, 
				lbSoTrang,lbNhaXuatBan, lbMoTa, lbNgonNgu, lbTacGia, lbThongTin;
		private JTextField txtMaSach, txtTenSach, txtNgayPhatHanh, txtKichThuoc, txtSoTrang, 
				txtLoaiBia, txtMoTa, txtNgonNgu;
		private JComboBox<String> cboNhaXuatBan, cboTacGia;
		private JTable table;
		private JScrollPane scrollPane;
		private JButton btnThem, btnXoa, btnLamMoi, btnLuu, btnSua, btnThoat;
		private DefaultTableModel dtmSach;
		private Sach_dao sach_dao;    
		
    public GD_QuanLiSach() {
    	
    	setTitle("Ứng dụng quản lí cửa hàng sách tư nhân TTK");
    	
    	//Khởi tạo
        pnTacVu = new JPanel();
        btnThem = new JButton();
        btnXoa = new JButton();
        btnLamMoi = new JButton();
        btnLuu = new JButton();
        btnSua = new JButton();
        btnThoat = new JButton();
        pnTieuDe = new JPanel();
        lbTieuDe = new JLabel();
        scrollPane = new JScrollPane();
        table = new JTable();
        pnThongTin = new JPanel();
        lbThongTin = new JLabel();
        lbMaSach = new JLabel();
        txtMaSach = new JTextField();
        lbTenSach = new JLabel();
        txtTenSach = new JTextField();
        lbNgayPhatHanh = new JLabel();
        txtNgayPhatHanh = new JTextField();
        lbKichThuoc = new JLabel();
        txtKichThuoc = new JTextField();
        lbLoaiBia = new JLabel();
        txtLoaiBia = new JTextField();
        lbSoTrang = new JLabel();
        txtSoTrang = new JTextField();
        lbNhaXuatBan = new JLabel();
        cboNhaXuatBan = new JComboBox<>();
        lbMoTa = new JLabel();
        lbNgonNgu = new JLabel();
        txtNgonNgu = new JTextField();
        lbTacGia = new JLabel();
        cboTacGia = new JComboBox<>();
        txtMoTa = new JTextField();
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
        setBackground(new java.awt.Color(255, 0, 51));
        setPreferredSize(new java.awt.Dimension(1300, 614));

        pnTacVu.setBackground(new java.awt.Color(204, 204, 255));

        btnThem.setBackground(new java.awt.Color(204, 255, 255));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThem.setText("Thêm");

        btnXoa.setBackground(new java.awt.Color(204, 255, 255));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoa.setText("Lưu");

        btnLamMoi.setBackground(new java.awt.Color(204, 255, 255));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLamMoi.setText("Làm mới");

        btnLuu.setBackground(new java.awt.Color(204, 255, 255));
        btnLuu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLuu.setText("Thoát");

        btnSua.setBackground(new java.awt.Color(204, 255, 255));
        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSua.setText("Xóa");

        btnThoat.setBackground(new java.awt.Color(204, 255, 255));
        btnThoat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThoat.setText("Sửa");

        javax.swing.GroupLayout pnTacVuLayout = new javax.swing.GroupLayout(pnTacVu);
        pnTacVu.setLayout(pnTacVuLayout);
        pnTacVuLayout.setHorizontalGroup(
            pnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTacVuLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnSua)
                .addGap(85, 85, 85)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(btnThoat)
                .addGap(70, 70, 70)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        pnTacVuLayout.setVerticalGroup(
            pnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTacVuLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(pnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi)
                    .addComponent(btnLuu)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnTieuDe.setBackground(new java.awt.Color(204, 255, 204));

        lbTieuDe.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbTieuDe.setForeground(new java.awt.Color(51, 51, 255));
        lbTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieuDe.setText("QUẢN LÍ SÁCH");

        javax.swing.GroupLayout pnTieuDeLayout = new javax.swing.GroupLayout(pnTieuDe);
        pnTieuDe.setLayout(pnTieuDeLayout);
        pnTieuDeLayout.setHorizontalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTieuDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnTieuDeLayout.setVerticalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTieuDeLayout.createSequentialGroup()
                .addComponent(lbTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Ngày phát hành", "Kích thuoc", "Loai bìa", "Só trang", "Nhà xuat ban", "Mô ta", "Ngon ngu", "Tac gia"
            }
        ));
        scrollPane.setViewportView(table);

        pnThongTin.setBackground(new java.awt.Color(255, 204, 255));

        lbThongTin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbThongTin.setText("Thông tin sách");

        lbMaSach.setText("Mã sách: ");

        lbTenSach.setText("Tên sách:");

        lbNgayPhatHanh.setText("Ngày phát hành:");

        lbKichThuoc.setText("Kích thước:");

        lbLoaiBia.setText("Loại bìa:");

        lbSoTrang.setText("Số trang:");

        lbNhaXuatBan.setText("Nhà xuất bản:");

        cboNhaXuatBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kim Đồng", "Bách Khoa", "Hoa Hồng", "Tuổi Trẻ"}));

        lbMoTa.setText("Mô tả:");

        lbNgonNgu.setText("Ngôn ngữ:");

        lbTacGia.setText("Tác giả:");

        cboTacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hồ Chí Minh", "Vũ Trọng Phụng", "Kim Lân", "Nam Cao"}));

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnThongTinLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(lbThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnThongTinLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbMaSach)
                                .addComponent(lbTenSach)
                                .addComponent(lbNgayPhatHanh)
                                .addComponent(lbKichThuoc)
                                .addComponent(lbLoaiBia)
                                .addComponent(lbSoTrang))
                            .addGap(2, 2, 2)
                            .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaSach)
                                .addComponent(txtTenSach)
                                .addComponent(txtNgayPhatHanh)
                                .addComponent(txtKichThuoc)
                                .addComponent(txtLoaiBia)
                                .addComponent(txtSoTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                        .addGroup(pnThongTinLayout.createSequentialGroup()
                            .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnThongTinLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbNhaXuatBan)
                                        .addComponent(lbMoTa)))
                                .addComponent(lbTacGia))
                            .addGap(18, 18, 18)
                            .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboNhaXuatBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgonNgu)
                                .addComponent(cboTacGia, 0, 139, Short.MAX_VALUE)
                                .addComponent(txtMoTa))))
                    .addComponent(lbNgonNgu))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbThongTin)
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaSach)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenSach)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNgayPhatHanh)
                    .addComponent(txtNgayPhatHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbKichThuoc)
                    .addComponent(txtKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLoaiBia)
                    .addComponent(txtLoaiBia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoTrang)
                    .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNhaXuatBan)
                    .addComponent(cboNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMoTa))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNgonNgu)
                    .addComponent(txtNgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTacGia)
                    .addComponent(cboTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        mnSach.setBackground(new java.awt.Color(102, 102, 255));
        mnSach.setText("Sách");
        mnSach.setAlignmentX(1.0F);
        mnSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnSach.setPreferredSize(new java.awt.Dimension(100, 40));

        mnItemQuanLiSach.setText("Quản lí sách");
        mnSach.add(mnItemQuanLiSach);

        mnItemTimSach.setText("Tìm sách");
        mnSach.add(mnItemTimSach);

        mnBar.add(mnSach);

        mnKhachHang.setText("Khách hàng");
        mnKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnKhachHang.setPreferredSize(new java.awt.Dimension(150, 40));

        mnItemQuanLiKH.setText("Quản li khách hàng");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTieuDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTacVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTacVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        btnThoat.addActionListener(this);
        
    }
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_QuanLiSach().setVisible(true);
            }
        });
    }
	
	public void addRow(Sach s) {
		String[] a = { s.getMaSach(), s.getTenSach(), s.getNgayPhatHanh() + "", s.getKichThuoc(), s.getLoaiBia() ,
				String.valueOf(s.getSoTrang()), s.getNhaXuatBan().getTenNhaXuatBan(), s.getMoTa(), s.getNgonNgu(),
				s.getTacGia().getTenTacGia() };
		dtmSach.addRow(a);
	}

	public void loadDB() {
		List<Sach> danhSachSach;
		danhSachSach = sach_dao.getDSSach();
		for (Sach s : danhSachSach) {
			addRow(s);
		}
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
		
		if(o.equals(btnThoat)) {
			this.setVisible(false);
		}
	}
                
}
