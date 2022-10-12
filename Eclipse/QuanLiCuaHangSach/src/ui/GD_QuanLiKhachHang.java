package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class GD_QuanLiKhachHang extends JFrame implements ActionListener{

    public GD_QuanLiKhachHang() {
    	setTitle("Ứng dụng quản lí cửa hàng sách tư nhân TTK");

        pnThongTin = new javax.swing.JPanel();
        lbMaNhanVien = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        lbHoTen = new javax.swing.JLabel();
        lbNgaySinh = new javax.swing.JLabel();
        lbDiaChi = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        lbSoDienThoai = new javax.swing.JLabel();
        lbCaLamViec = new javax.swing.JLabel();
        lbSoCMND = new javax.swing.JLabel();
        lbTrinhDo = new javax.swing.JLabel();
        lbNgayVaoLam = new javax.swing.JLabel();
        lbChucVu = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        txtDiaChi = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtSoDienThoai = new javax.swing.JTextField();
        txtCaLamViec = new javax.swing.JTextField();
        txtSoCMND = new javax.swing.JTextField();
        txtTrinhDo = new javax.swing.JTextField();
        txtNgayVaoLam = new javax.swing.JTextField();
        txtChucVu = new javax.swing.JTextField();
        lbThongTin = new javax.swing.JLabel();
        pnTieuDe = new javax.swing.JPanel();
        lbTieuDe = new javax.swing.JLabel();
        pnTacVu = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mnBar = new javax.swing.JMenuBar();
        mnSach = new javax.swing.JMenu();
        mnItemQuanLiSach = new javax.swing.JMenuItem();
        mnItemTimSach = new javax.swing.JMenuItem();
        mnKhachHang = new javax.swing.JMenu();
        mnItemQuanLiKH = new javax.swing.JMenuItem();
        mnItemTimKH = new javax.swing.JMenuItem();
        mnNhanVien = new javax.swing.JMenu();
        mnItemQuanLiNhanVien = new javax.swing.JMenuItem();
        mnItemTimNV = new javax.swing.JMenuItem();
        mnHoaDon = new javax.swing.JMenu();
        mnItemQuanLiHD = new javax.swing.JMenuItem();
        mnItemTimHD = new javax.swing.JMenuItem();
        mnThongKe = new javax.swing.JMenu();
        mnItemDoanhThu = new javax.swing.JMenuItem();
        mnItemSachChay = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnThongTin.setBackground(new java.awt.Color(255, 204, 255));

        lbMaNhanVien.setText("Mã nhân viên:");

        lbHoTen.setText("Họ tên:");

        lbNgaySinh.setText("Ngày sinh:");

        lbDiaChi.setText("Địa chỉ:");

        lbGioiTinh.setText("Giới tính:");

        lbSoDienThoai.setText("Số điện thoại:");

        lbCaLamViec.setText("Ca làm việc:");

        lbSoCMND.setText("Số CMND:");

        lbTrinhDo.setText("Trình độ:");

        lbNgayVaoLam.setText("Ngày vào làm: ");

        lbChucVu.setText("Chức vụ:");

        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                rdoNamActionPerformed(evt);
            }
        });

        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                rdoNuActionPerformed(evt);
            }
        });

        lbThongTin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbThongTin.setText("Thông tin nhân viên");

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addComponent(lbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addComponent(lbNgayVaoLam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addComponent(lbTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addComponent(lbCaLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCaLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbGioiTinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinLayout.createSequentialGroup()
                                        .addComponent(rdoNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoNu)
                                        .addGap(31, 31, 31))
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addComponent(lbSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addComponent(lbSoCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSoCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addComponent(lbMaNhanVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lbThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaNhanVien)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCaLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCaLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSoCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNgayVaoLam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );

        pnTieuDe.setBackground(new java.awt.Color(204, 255, 204));

        lbTieuDe.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbTieuDe.setForeground(new java.awt.Color(51, 51, 255));
        lbTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieuDe.setText("QUẢN LÍ NHÂN VIÊN");

        javax.swing.GroupLayout pnTieuDeLayout = new javax.swing.GroupLayout(pnTieuDe);
        pnTieuDe.setLayout(pnTieuDeLayout);
        pnTieuDeLayout.setHorizontalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        pnTieuDeLayout.setVerticalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnTacVu.setBackground(new java.awt.Color(204, 204, 255));

        btnThem.setBackground(new java.awt.Color(204, 255, 255));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThem.setText("Thêm");

        btnXoa.setBackground(new java.awt.Color(204, 255, 255));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoa.setText("Xóa");

        btnLamMoi.setBackground(new java.awt.Color(204, 255, 255));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLamMoi.setText("Làm moi");

        btnLuu.setBackground(new java.awt.Color(204, 255, 255));
        btnLuu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLuu.setText("Lưu");

        btnSua.setBackground(new java.awt.Color(204, 255, 255));
        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSua.setText("Sửa");

        btnThoat.setBackground(new java.awt.Color(204, 255, 255));
        btnThoat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThoat.setText("Thoát");

        javax.swing.GroupLayout pnTacVuLayout = new javax.swing.GroupLayout(pnTacVu);
        pnTacVu.setLayout(pnTacVuLayout);
        pnTacVuLayout.setHorizontalGroup(
            pnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTacVuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa)
                .addGap(80, 80, 80)
                .addComponent(btnLamMoi)
                .addGap(85, 85, 85)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnThoat)
                .addGap(79, 79, 79))
        );
        pnTacVuLayout.setVerticalGroup(
            pnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTacVuLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Ngày sinh ", "Địa chỉ", "Giới tinh", "Số điện thoại", "Ca làm việc", "Số CMND", "Trình độ", "Ngày vào làm", "Chức vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        mnSach.setText("Sách");
        mnSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnSach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        mnNhanVien.setText("Nhân viên");
        mnNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnNhanVien.setMinimumSize(new java.awt.Dimension(150, 40));
        mnNhanVien.setPreferredSize(new java.awt.Dimension(150, 40));

        mnItemQuanLiNhanVien.setText("Quản lí nhân viên");
        mnNhanVien.add(mnItemQuanLiNhanVien);

        mnItemTimNV.setText("Tìm nhân viên");
        mnNhanVien.add(mnItemTimNV);

        mnBar.add(mnNhanVien);

        mnHoaDon.setText("Hóa đơn");
        mnHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnHoaDon.setPreferredSize(new java.awt.Dimension(120, 40));

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
                    .addComponent(pnTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTacVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTacVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        
        mnItemQuanLiSach.addActionListener(this);
        mnItemTimSach.addActionListener(this);
        mnItemQuanLiKH.addActionListener(this);
        mnItemTimKH.addActionListener(this);
        mnItemQuanLiNhanVien.addActionListener(this);
        mnItemTimNV.addActionListener(this);
        mnItemQuanLiHD.addActionListener(this);
        mnItemDoanhThu.addActionListener(this);
        mnItemSachChay.addActionListener(this);
        btnThoat.addActionListener(this);
        
    }
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_QuanLiKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JMenuItem mnItemTimHD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbCaLamViec;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbMaNhanVien;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbNgayVaoLam;
    private javax.swing.JLabel lbSoCMND;
    private javax.swing.JLabel lbSoDienThoai;
    private javax.swing.JLabel lbThongTin;
    private javax.swing.JLabel lbTieuDe;
    private javax.swing.JLabel lbTrinhDo;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnHoaDon;
    private javax.swing.JMenuItem mnItemDoanhThu;
    private javax.swing.JMenuItem mnItemQuanLiKH;
//    private javax.swing.JMenuItem mnItemQuanLiNhanVien;
    private javax.swing.JMenuItem mnItemQuanLiSach;
    private javax.swing.JMenuItem mnItemSachChay;
    private javax.swing.JMenuItem mnItemQuanLiHD;
    private javax.swing.JMenuItem mnItemTimKH;
    private javax.swing.JMenuItem mnItemTimNV;
    private javax.swing.JMenuItem mnItemTimSach;
    private javax.swing.JMenu mnKhachHang;
    private javax.swing.JMenu mnNhanVien;
    private javax.swing.JMenuItem mnItemQuanLiNhanVien;
    private javax.swing.JMenu mnSach;
    private javax.swing.JMenu mnThongKe;
    private javax.swing.JPanel pnTacVu;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JPanel pnTieuDe;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextField txtCaLamViec;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgayVaoLam;
    private javax.swing.JTextField txtSoCMND;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTrinhDo;
    // End of variables declaration                   
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
		if(o.equals(mnItemQuanLiNhanVien)) {
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
