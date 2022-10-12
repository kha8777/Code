package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

//import com.toedter.calendar.JDateChooser;

import dao.Sach_dao;
import entity.Sach;


public class GD_QuanLiSach<JDateChooser> extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblSach;
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtKichThuoc;
	private JTextField txtLoaiBia;
	private JTextField txtSoTrang;
	private JTextField txtMoTa;
	private JTextField txtngonNgu;
	private JTextField txtNhaXuatBan;
	private JTextField txtNgayPhatHanh;
	private JTextField txtTacGia;
	
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnXoaTrang;
	private JButton btnSua;
	private JButton btnTimKiem;

	private DefaultTableModel dtm_Sach;
	private Sach_dao sach_dao ;
//	private Date dCngayPhatHanh;
	private JDateChooser dCngayPhatHanh;
	private JComboBox<String> cboNhaXuatBan;
	private JComboBox<String> cboTacGia;
	private JPanel pnCha;
	private int rowSelected;

	/**
	 * Giao diện các công trình
	 */
	public GD_QuanLiSach() {
		
	}

	/**
	 * Tab hiển thị danh sách công trình
	 * 
	 * @return tab hiển thị danh sách công trình
	 */
	@SuppressWarnings("deprecation")
	public Component tabSach() {
		// panel Cha
				pnCha = new JPanel();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pnCha.setBounds(0, 0, 979, 554);
				pnCha.setLayout(new BorderLayout(0, 0));
				
			// panel con phía trên
				JPanel pnNorth = new JPanel();
				pnNorth.setBackground(Color.CYAN);
				pnCha.add(pnNorth, BorderLayout.NORTH);

				JLabel lblQLSach = new JLabel("Quản lí sách");
				lblQLSach.setForeground(Color.BLUE);
				lblQLSach.setFont(new Font("Arial", Font.BOLD, 20));
				pnNorth.add(lblQLSach);
			
			// panel con ở giữa
				JPanel pnCenTer = new JPanel();
				pnCha.add(pnCenTer, BorderLayout.CENTER);
				pnCenTer.setLayout(null);
			
			// panel con ở trên thuộc phần giữa
				JPanel pnChinhSua = new JPanel();
				pnChinhSua.setBackground(new Color(238, 232, 170));
				pnChinhSua.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Chỉnh sửa sách"));
				pnChinhSua.setBounds(0, 0, 979, 152);
				pnChinhSua.setLayout(null);

				JLabel lblMaSach = new JLabel("Mã sách:");
				lblMaSach.setFont(new Font("Arial", Font.BOLD, 13));
				lblMaSach.setBounds(10, 22, 95, 20);
				pnChinhSua.add(lblMaSach);

				txtMaSach = new JTextField();
				txtMaSach.setFont(new Font("Arial", Font.PLAIN, 13));
				txtMaSach.setColumns(10);
				txtMaSach.setBounds(116, 22, 103, 20);
				pnChinhSua.add(txtMaSach);

				JLabel lblTenSach = new JLabel("Tên sách:");
				lblTenSach.setFont(new Font("Arial", Font.BOLD, 13));
				lblTenSach.setBounds(233, 22, 100, 20);
				pnChinhSua.add(lblTenSach);

				txtTenSach = new JTextField();
				txtTenSach.setFont(new Font("Arial", Font.PLAIN, 13));
				txtTenSach.setColumns(10);
				txtTenSach.setBounds(337, 22, 135, 20);
				pnChinhSua.add(txtTenSach);

				JLabel lblKichThuoc = new JLabel("Kích thước:");
				lblKichThuoc.setFont(new Font("Arial", Font.BOLD, 13));
				lblKichThuoc.setBounds(493, 22, 116, 20);
				pnChinhSua.add(lblKichThuoc);
				
				txtKichThuoc = new JTextField();
				txtKichThuoc.setFont(new Font("Arial", Font.PLAIN, 13));
				txtKichThuoc.setColumns(10);
				txtKichThuoc.setBounds(570, 22, 135, 20);
				pnChinhSua.add(txtKichThuoc);
				
				JLabel lblNgayPhatHanh = new JLabel("Ngày phát hành:");
				lblNgayPhatHanh.setFont(new Font("Arial", Font.BOLD, 13));
				lblNgayPhatHanh.setBounds(730, 22, 135, 20);
				pnChinhSua.add(lblNgayPhatHanh);
				
				txtNgayPhatHanh = new JTextField();
				txtNgayPhatHanh.setFont(new Font("Arial", Font.BOLD, 13));
				txtNgayPhatHanh.setColumns(10);;
				txtNgayPhatHanh.setBounds(849, 22, 110, 20);
				pnChinhSua.add(txtNgayPhatHanh);

				JLabel lblSoTrang = new JLabel("Số trang:");
				lblSoTrang.setFont(new Font("Arial", Font.BOLD, 13));
				lblSoTrang.setBounds(10, 50, 99, 20);
				pnChinhSua.add(lblSoTrang);
				
				txtSoTrang = new JTextField();
				txtSoTrang.setFont(new Font("Arial", Font.BOLD, 13));
				txtSoTrang.setColumns(10);;
				txtSoTrang.setBounds(116, 50, 103, 20);
				pnChinhSua.add(txtSoTrang);
				
				JLabel lblNhaXuatBan = new JLabel("Nhà xuất bản:");
				lblNhaXuatBan.setFont(new Font("Arial", Font.BOLD, 13));
				lblNhaXuatBan.setBounds(233, 50, 105, 20);
				pnChinhSua.add(lblNhaXuatBan);
				
				cboNhaXuatBan = new JComboBox<String>();
				cboNhaXuatBan.addItem("Giáo dục");
				cboNhaXuatBan.addItem("Bách Khoa");
				cboNhaXuatBan.addItem("Lao động");
				cboNhaXuatBan.addItem("Tuổi trẻ");
				cboNhaXuatBan.addItem("Kim Đồng");
				cboNhaXuatBan.setFont(new Font("Arial", Font.PLAIN, 13));
				cboNhaXuatBan.setBounds(337, 50, 135, 20);
				pnChinhSua.add(cboNhaXuatBan);
				
				JLabel lblMoTa = new JLabel("Mô tả:");
				lblMoTa.setFont(new Font("Arial", Font.BOLD, 13));
				lblMoTa.setBounds(493, 50, 169, 20);
				pnChinhSua.add(lblMoTa);
				
				txtMoTa = new JTextField();
				txtMoTa.setFont(new Font("Arial", Font.BOLD, 13));
				txtMoTa.setColumns(10);;
				txtMoTa.setBounds(570, 50, 135, 20);
				pnChinhSua.add(txtMoTa);
				
				JLabel lblNgonNgu = new JLabel("Ngôn ngữ:");
				lblNgonNgu.setFont(new Font("Arial", Font.BOLD, 13));
				lblNgonNgu.setBounds(730, 50, 123, 20);
				pnChinhSua.add(lblNgonNgu);
				
				txtngonNgu = new JTextField();
				txtngonNgu.setFont(new Font("Arial", Font.BOLD, 13));
				txtngonNgu.setColumns(10);;
				txtngonNgu.setBounds(849, 50, 110, 20);
				pnChinhSua.add(txtngonNgu);
				
				JLabel lblTacGia = new JLabel("Tác Giả:");
				lblTacGia.setFont(new Font("Arial", Font.BOLD, 13));
				lblTacGia.setBounds(10, 78, 74, 20);
				pnChinhSua.add(lblTacGia);
				
				cboTacGia = new JComboBox<String>();
				cboTacGia.addItem("Kim Lân");
				cboTacGia.addItem("Vũ Trọng Phụng");
				cboTacGia.addItem("Nam Cao");
				cboTacGia.addItem("Hồ Chí Minh");
				cboTacGia.setFont(new Font("Arial", Font.PLAIN, 13));
				cboTacGia.setBounds(116, 78, 103, 20);
				pnChinhSua.add(cboTacGia);
				
				JLabel lblLoaiBia = new JLabel("Loại bìa:");
				lblLoaiBia.setFont(new Font("Arial", Font.BOLD, 13));
				lblLoaiBia.setBounds(233, 78, 135, 20);
				pnChinhSua.add(lblLoaiBia);
				
				txtLoaiBia = new JTextField();
				txtLoaiBia.setFont(new Font("Arial", Font.BOLD, 13));
				txtLoaiBia.setColumns(10);;
				txtLoaiBia.setBounds(337, 78, 135, 20);
				pnChinhSua.add(txtLoaiBia);
				
			// panel con ở dưới thuộc phần giữa
				JPanel pnTacVu = new JPanel();
				pnTacVu.setBackground(new Color(208, 232, 170));
				pnTacVu.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Chọn tác vụ"));
				pnTacVu.setBounds(0, 150, 979, 80);
				pnTacVu.setLayout(null);
				

				btnThem = new JButton("Thêm sách");
				btnThem.setFont(new Font("Arial", Font.BOLD, 13));
				btnThem.setBounds(50, 30, 130, 30);
				pnTacVu.add(btnThem);

				btnXoa = new JButton("Xóa sách");
				btnXoa.setFont(new Font("Arial", Font.BOLD, 13));
				btnXoa.setBounds(220, 30, 130, 30);
				pnTacVu.add(btnXoa);

				btnLuu = new JButton("Lưu");
				btnLuu.setFont(new Font("Arial", Font.BOLD, 13));
				btnLuu.setBounds(390, 30, 120, 30);
				pnTacVu.add(btnLuu);

				btnXoaTrang = new JButton("Xóa Trắng");
				btnXoaTrang.setFont(new Font("Arial", Font.BOLD, 13));
				btnXoaTrang.setBounds(535, 30, 130, 30);
				pnTacVu.add(btnXoaTrang);
				
				btnSua = new JButton("Sửa");
				btnSua.setFont(new Font("Arial", Font.BOLD, 13));
				btnSua.setBounds(690, 30, 100, 30);
				pnTacVu.add(btnSua);
				
				btnTimKiem = new JButton("Tìm kiếm");
				btnTimKiem.setFont(new Font("Arial", Font.BOLD, 13));
				btnTimKiem.setBounds(810, 30, 130, 30);
				pnTacVu.add(btnTimKiem);
				
				pnCenTer.add(pnChinhSua);
				pnCenTer.add(pnTacVu);
				
				JPanel pnTableSach = new JPanel();
				pnTableSach.setBackground(SystemColor.info);
				pnTableSach.setBounds(0, 240, 976, 260);
				pnTableSach.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh sách sách"));
				pnCenTer.add(pnTableSach);
				pnTableSach.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 280, 956, 250);
				pnTableSach.add(scrollPane);

				String []colHeader = { "Mã sách", "Tên sách", "Ngày phát hành", "Kích thước", "Loại bìa",
						"Số trang", "Nhà xuất bản", "Mô tả", "Ngôn ngũ", "Tác giả"} ;
				dtm_Sach = new DefaultTableModel(colHeader, 0);
				tblSach= new JTable(dtm_Sach);
				tblSach.setRowHeight(25);
				pnCenTer.add(new JScrollPane(tblSach), BorderLayout.CENTER);
				
//				tblSach = new JTable();
//				tblSach.setModel(
//						dtm_Sach = new DefaultTableModel(
//								new String[] {"Mã sách", "Tên sách", "Ngày phát hành", "Kích thước", "Loại bìa",
//										"Số trang", "Nhà xuất bản", "Mô tả", "Ngôn ngũ", "Tác giả"
//										},0)
//							{
//								/**
//								 * 
//								 */
//								private static final long serialVersionUID = 1L;
//
//								public boolean isCellEditable(int row, int column) {
//									return false;
//								};
//							}
//						);
				scrollPane.setViewportView(tblSach);
				tblSach.getTableHeader().setBackground(Color.CYAN);
				tblSach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tblSach.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						rowSelected = tblSach.getSelectedRow();
						if (rowSelected >= 0) {
//							reviewRowSelected(rowSelected);
							if (btnThem.getText().equals("Thêm"))
								btnSua.setEnabled(true);
						}
					}
				});
				
//				// themData
				load();
		//
				// settext
				txtMaSach.setText("");
				txtTenSach.setText("");
//				dCngayPhatHanh.setDate(new Date(""));
				txtKichThuoc.setText("");
				txtLoaiBia.setText("");
				txtSoTrang.setText("");
				cboNhaXuatBan.setToolTipText("");
				txtMoTa.setText("");
				txtngonNgu.setText("");
				cboTacGia.setToolTipText("");
				
				btnSua.setFocusable(false);
				moKhoaThaoTac(false);
				btnSua.setEnabled(false);
				
				
				// event
				
				
				btnThem.addActionListener(this);
				btnXoa.addActionListener(this);
				btnLuu.addActionListener(this);
				btnXoaTrang.addActionListener(this);
				btnSua.addActionListener(this);
				
				btnThem.setMnemonic(KeyEvent.VK_T);
				btnXoa.setMnemonic(KeyEvent.VK_D);
				btnLuu.setMnemonic(KeyEvent.VK_L);
				btnSua.setMnemonic(KeyEvent.VK_S);
				btnXoaTrang.setMnemonic(KeyEvent.VK_X);
				
				
				//set ToolTipText
				btnThem.setToolTipText("Alt+T Thêm sách mới vào danh sách");
				btnThem.setToolTipText("Alt+D Xóa sách ra khỏi danh sách");
				btnLuu.setToolTipText("Alt+L Lưu lại dữ liệu thực hiện việc thêm hoặc sửa sách");
				btnSua.setToolTipText("Alt+S Sửa thông tin sách trong danh sách");
				btnXoaTrang.setToolTipText("Alt+X Xóa tất cả dữ liệu nhập");
		//
//				txtMaCT.setToolTipText("Mã công trình bắt đầu bằng CT theo sau là 3 số");
//				((JTextField)dCNgayCapPhep.getDateEditor().getUiComponent()).setToolTipText("Ngày cấp phép phải trước ngày hiện tại!");
//				((JTextField)dCNgayKhoiCong.getDateEditor().getUiComponent()).setToolTipText("Ngày khởi công phải sau ngày cấp phép!");
//				((JTextField)dcNgayHoanThanh.getDateEditor().getUiComponent()).setToolTipText("Ngày hoàn thành dự kiến phải sau ngày khởi công!");
//				txtSoLuongNhanSuCT.setToolTipText("Số lượng nhân sự trong công trình");
//				cboTrangThai.setToolTipText("Trạng thái công trình");
//				cboHienThiCT.setToolTipText("Hiển thị danh sách công trình theo trạng thái");
//				txtTimKiemCT.setToolTipText("Mã công trình bắt đầu bằng CT theo sau là 3 số");
//				
				return pnCha;

			}

//	}

	/**
	 * Load dữ liệu từ database lên table chính
	 */
	
	public void load() {
		ArrayList<Sach> danhsach;
		danhsach = Sach_dao.getDSSach();
		for (Sach sach : danhsach) {
			addRow(sach);
		}
	}

	/**
	 * Thêm 1 dòng vào table chính
	 * 
	 * @param ct công trình cần thêm vào table
	 */
	public void addRow(Sach s) {
		String[] row = { s.getMaSach(), s.getTenSach(), s.getNgayPhatHanh() + "",
				s.getKichThuoc(), s.getLoaiBia(), s.getSoTrang() + "", s.getNhaXuatBan().getTenNhaXuatBan(),
				s.getMoTa(), s.getNgonNgu() , s.getTacGia().getTenTacGia()};
		dtm_Sach.addRow(row);
	}

	/**
	 * Mở khóa các button và textField thực hiện việc thêm hoặc sửa dữ liệu,
	 * 
	 * 
	 * @param b true=mở, false=tắt
	 */
	public void moKhoaThaoTac(boolean b) {
		btnLuu.setEnabled(b);
		btnXoaTrang.setEnabled(b);
		btnThem.setEnabled(!b);
		btnSua.setEnabled(!b);
//		txtMaSach.setEditable(b);
//		txtTenSach.setEditable(b);
//		txtNgayPhatHanh.setEditable(b);
//		txtKichThuoc.setEditable(b);
//		txtLoaiBia.setEnabled(b);
//		txtSoTrang.setEnabled(b);
//		cboNhaXuatBan.setEnabled(!b);
//		txtMoTa.setEnabled(b);
//		txtngonNgu.setEnabled(b);
//		cboTacGia.setEnabled(!b);
	}
	/**
	 * Đưa dữ liệu từ table chính lên các textField và chọn dòng(bôi đen) trên table
	 * từ vị trí truyền vào
	 * 
	 * @param rowselected vị trí truyền vào
	 */
//	public void reviewRowSelected(int rowSelected) {
//		txtMaCT.setText(tblCT.getValueAt(rowSelected, 0) + "");
//		txtTenCT.setText(tblCT.getValueAt(rowSelected, 1) + "");
//		txtDiaDiemCT.setText(tblCT.getValueAt(rowSelected, 2) + "");
//		try {
//			if (tblCT.getModel().getValueAt(rowSelected, 3).equals("null"))
//				dCNgayCapPhep.setDate(null);
//			else
//				dCNgayCapPhep.setDate(new SimpleDateFormat("yyyy-MM-dd")
//						.parse(tblCT.getModel().getValueAt(rowSelected, 3).toString()));
//			if (tblCT.getModel().getValueAt(rowSelected, 4).equals("null"))
//				dCNgayKhoiCong.setDate(null);
//			else
//				dCNgayKhoiCong.setDate(new SimpleDateFormat("yyyy-MM-dd")
//						.parse(tblCT.getModel().getValueAt(rowSelected, 4).toString()));
//			if (tblCT.getModel().getValueAt(rowSelected, 5).equals("null"))
//				dcNgayHoanThanh.setDate(null);
//			else
//				dcNgayHoanThanh.setDate(new SimpleDateFormat("yyyy-MM-dd")
//						.parse(tblCT.getModel().getValueAt(rowSelected, 5).toString()));
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		cboTrangThai.setSelectedItem(tblCT.getValueAt(rowSelected, 6) + "");
//		txtSoLuongNhanSuCT.setText(tblCT.getValueAt(rowSelected, 7) + "");
//		txtGhiChuCT.setText(tblCT.getValueAt(rowSelected, 8) + "");
//		tblCT.setRowSelectionInterval(rowSelected, rowSelected);
//	}
//
//	/**
//	 * Kiểm tra ràng buộc dữ liệu trên các textField
//	 * 
//	 * @return true=đúng, false=sai
//	 */
//	public boolean regexCongTrinh() {
//		if (txtMaCT.getText().trim().isEmpty()) {
//			showMess("Mã công trình không được để trống");
//			txtMaCT.requestFocus();
//			return false;
//		}
//		if (txtTenCT.getText().trim().isEmpty()) {
//			showMess("Tên công trình không được để trống");
//			txtTenCT.requestFocus();
//			return false;
//		}
//		if (txtDiaDiemCT.getText().trim().isEmpty()) {
//			showMess("Địa điểm thi công không được để trống");
//			txtDiaDiemCT.requestFocus();
//			return false;
//		}
//		if ((dCNgayCapPhep.getDate() + "").equals("null")) {
//			showMess("Ngày cấp phép không được để trống");
//			return false;
//		}
//		if (!txtMaCT.getText().toUpperCase().matches("(CT)[0-9]{3}")) {//mã công trình phải bắt đầu bằng Ct và theo sau là 3 số
//			showMess("Mã công trình không hợp lệ");
//			txtMaCT.requestFocus();
//			return false;
//		}
//		if (dCNgayCapPhep.getDate().after(new Date())) {
//			showMess("Ngày cấp phép phải trước ngày hiện tại!");
//			return false;
//		}
//		if (!(dCNgayKhoiCong.getDate()+"").equals("null")
//				&& dCNgayKhoiCong.getDate().before(dCNgayCapPhep.getDate())) {
//			showMess("Ngày khởi công phải sau ngày cấp phép!");
//			return false;
//		}
//		if (!(dcNgayHoanThanh.getDate()+"").equals("null")
//				&& dcNgayHoanThanh.getDate().before(dCNgayKhoiCong.getDate())) {
//			showMess("Ngày hoàn thành phải sau ngày khởi công!");
//			return false;
//		}
//		return true;
//	}
//
//	/**
//	 * Hiển thị thông báo dạng Joption.showMessageDialog
//	 * 
//	 * @param thongBao thông báo cần hiển thị
//	 */
//	public void showMess(String thongBao) {
//		JOptionPane.showMessageDialog(null, thongBao);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource().equals(btnXemCV)) {
//			Component pnCV;// tạo component để hiển thị trên Joption
//			rowSelected = tblCT.getSelectedRow();
//			Object[] r = { "Thoát" };
//			if (rowSelected >= 0)
//				pnCV = new GUI_CongViec(dtmCongTrinh.getValueAt(rowSelected, 0).toString()).xemCongViec();
//			else
//				pnCV = new GUI_CongViec("Tất cả").xemCongViec();
//			JOptionPane.showOptionDialog(null, pnCV, "", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
//					r, null);// hiển thị option với combonent chứa dánh sách công việc truyền vào
//		} else if (e.getSource().equals(btnThem)) {
//			if (btnThem.getText().equals("Thêm")) {
//				moKhoaThaoTac(true);
//				btnThem.setText("Hủy");
//				btnThem.setEnabled(true);
//			} else {
//				moKhoaThaoTac(false);
//				btnThem.setText("Thêm");
//				if (tblCT.getSelectedRow() < 0)// nếu dòng trên table chưa được chọn thì button sửa sẽ không được thực
//												// hiện
//					btnSua.setEnabled(false);
//			}
//
//		} else if (e.getSource().equals(btnXoaTrang)) {
//			txtTenCT.setText("");
//			txtDiaDiemCT.setText("");
//			cboTrangThai.setSelectedItem("Chờ khởi công");
//			dCNgayCapPhep.setDate(null);
//			dCNgayKhoiCong.setDate(null);
//			dcNgayHoanThanh.setDate(null);
//			txtSoLuongNhanSuCT.setText("0");
//			txtGhiChuCT.setText("");
//			if (btnSua.getText().equals("Sửa"))// chức năng sửa đang không được thực hiện
//				txtMaCT.setText("");
//		} else if (e.getSource().equals(btnSua)) {
//			if (btnSua.getText().equals("Sửa")) {
//				moKhoaThaoTac(true);
//				txtMaCT.setEditable(false);
//				btnSua.setText("Hủy");
//				btnSua.setEnabled(true);
//			} else {
//				moKhoaThaoTac(false);
//				btnSua.setText("Sửa");
//			}
//
//		} else if (e.getSource().equals(btnLuu)) {
//			if (regexCongTrinh()) {// kiểm tra ràng buộc dữ liệu đúng
//				if (btnThem.getText().equals("Hủy")) {// Chức năng thêm đang được thực hiện
//					SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
//					String[] r = { txtMaCT.getText().trim(), txtTenCT.getText().trim(), txtDiaDiemCT.getText().trim(),
//							sdt.format(dCNgayCapPhep.getDate()), "", "", cboTrangThai.getSelectedItem() + "", "0",
//							txtGhiChuCT.getText().trim() };
//					if (!(dCNgayKhoiCong.getDate() + "").equals("null"))// ngày khởi công khác null
//						r[4] = sdt.format(dCNgayKhoiCong.getDate());
//					if (!(dcNgayHoanThanh.getDate() + "").equals("null"))// ngày hoàn thành khác null
//						r[5] = sdt.format(dCNgayKhoiCong.getDate());
//					CongTrinh ct = new CongTrinh(r[0], r[1], r[2], dCNgayCapPhep.getDate(), dCNgayKhoiCong.getDate(),
//							dcNgayHoanThanh.getDate(), r[6], Integer.parseInt(r[7]), r[8]);
//					if (congTrinh_DAO.getDSCT().contains(ct)) {
//						showMess("Mã công trình đã tồn tại!");
//					} else {
//						if (congTrinh_DAO.addCongTrinh(ct)) {
//							dtmCongTrinh.addRow(r);
//							tblCT.setRowSelectionInterval(tblCT.getRowCount() - 1, tblCT.getRowCount() - 1);
//							showMess("Thêm công trình thành công!");
//							GUI_UNGDUNG.loadDuLieuThongKe();
//						} else
//							showMess("Không thể thêm công trình!");
//					}
//				} else {// Chức năng sửa đang được thực hiện
//					rowSelected = tblCT.getSelectedRow();
//					SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
//					String[] r = { txtMaCT.getText().trim(), txtTenCT.getText().trim(), txtDiaDiemCT.getText().trim(),
//							sdt.format(dCNgayCapPhep.getDate()), "", "", cboTrangThai.getSelectedItem() + "", "0",
//							txtGhiChuCT.getText().trim() };
//					if (!(dCNgayKhoiCong.getDate() + "").equals("null"))// ngày khởi công khác null sẽ thực hiện việc ép
//																		// kiểu date
//						r[4] = sdt.format(dCNgayKhoiCong.getDate());
//					if (!(dcNgayHoanThanh.getDate() + "").equals("null"))// ngày hoàn thành khác null sẽ thực hiện việc
//																			// ép kiểu date
//						r[5] = sdt.format(dCNgayKhoiCong.getDate());
//					CongTrinh ct = new CongTrinh(r[0], r[1], r[2], dCNgayCapPhep.getDate(), dCNgayKhoiCong.getDate(), dcNgayHoanThanh.getDate(), r[6],Integer.parseInt(r[7]),r[8]);
//					if (congTrinh_DAO.setCongTrinh(ct)) {
//						dtmCongTrinh.setValueAt(r[1], rowSelected, 1);
//						dtmCongTrinh.setValueAt(r[2], rowSelected, 2);
//						dtmCongTrinh.setValueAt(r[3], rowSelected, 3);
//						dtmCongTrinh.setValueAt(r[4], rowSelected, 4);
//						dtmCongTrinh.setValueAt(r[5], rowSelected, 5);
//						dtmCongTrinh.setValueAt(r[6], rowSelected, 6);
//						dtmCongTrinh.setValueAt(r[8], rowSelected, 8);
//						showMess("Sửa công trình thành công!");
//						GUI_UNGDUNG.loadDuLieuThongKe();
//					} else
//						showMess("Không thể sửa công trình!");
//				}
//			}
//		} else if (e.getSource().equals(btnTimCT)) {
//			String maCTTim = txtTimKiemCT.getText();
//			cboHienThiCT.setSelectedItem("Tất cả");
//				if (!maCTTim.isEmpty()) {
//					if (!(txtTimKiemCT.getText().toUpperCase() + "").matches("^CT[0-9]{3}"))// mã công trình bắt đầu bằng CT vào theo sau là 3 số
//						showMess("Mã công trình không hợp lệ!");
//					else {
//					dtmCongTrinh.setRowCount(0);
//					cboHienThiCT.setEnabled(false);
//					for (CongTrinh congTrinh : congTrinh_DAO.getDSCT()) {
//						if (congTrinh.getMaCT().equalsIgnoreCase(maCTTim))
//							addRow(congTrinh);
//						if (tblCT.getRowCount() > 0)
//							reviewRowSelected(0);
//					}
//					}
//				} else {
//					cboHienThiCT.setEnabled(true);
//					dtmCongTrinh.setRowCount(0);
//					load();
//				}
//		} else// combobox Hiển thị
//		{
//			String valueSelected = (String) cboHienThiCT.getSelectedItem();
//			dtmCongTrinh.setRowCount(0);
//			if (valueSelected.equals("Tất cả"))
//				load();
//			else {
//				String trangThaiSelected = valueSelected.substring(11, valueSelected.length());
//				for (CongTrinh congTrinh : congTrinh_DAO.getDSCT()) {
//					if (congTrinh.getTrangThai().equalsIgnoreCase(trangThaiSelected))
//						addRow(congTrinh);
//				}
//			}
//		}
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

