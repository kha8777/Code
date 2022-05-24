package UI;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import dao.PhongBan_DAO;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_GUI extends JFrame implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;

	private JTable tableNhanVien;
	private DefaultTableModel modelNhanVien;

	private JTextField txtMaNV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtTienLuong;
	private JTextField txtTim;
	private JButton bttTim;
	private JButton bttThem;
	private JButton bttXoa;
	private JButton bttCapNhat;
	private JButton bttXoaTrang;
	private JButton bttLuu;
	
	private JCheckBox chkNu;
	private JComboBox<String> cboPhongBan;

	private NhanVien_DAO nv_dao;
	private PhongBan_DAO pb_dao;
	
	private int flagTim = 0;
	private int flagThem = 0;

	public NhanVien_GUI() {

		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		nv_dao = new NhanVien_DAO();
		pb_dao = new PhongBan_DAO();

		setTitle("");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.blue);

		Box b = Box.createVerticalBox();

		Box b11, b1, b2, b3, b4;
		JLabel lblMaNV, lblHo, lblTuoi, lblPhai, lblTienLuong, lblTim = null;

		b.add(b11 = Box.createHorizontalBox());
		b11.add(lblTieuDe);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaNV = new JLabel("Mã nhân viên:   "));
		b1.add(txtMaNV = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblHo = new JLabel("Họ "));
		b2.add(txtHo = new JTextField());
		b2.add(new JLabel("Tên nhân viên: "));
		b2.add(txtTen = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblTuoi = new JLabel("Tuổi: "));
		b3.add(txtTuoi = new JTextField());
		b3.add(lblPhai = new JLabel("Phái: "));
		b3.add(chkNu = new JCheckBox("Nữ"));

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblTienLuong = new JLabel("Tiền lương: "));
		b4.add(txtTienLuong = new JTextField());
		b4.add(new JLabel("Phòng Ban: "));
		
		//Tạo và đổ dữ liệu vào comboBox
		b4.add(cboPhongBan = new JComboBox<String>());
		cboPhongBan.setEditable(true);		
		
		ArrayList<PhongBan> listPB = pb_dao.getAllTBPhongBan();
		for (PhongBan phongBan : listPB) {
			cboPhongBan.addItem(phongBan.getMaPhongBan());
		}

		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		lblPhai.setPreferredSize(lblMaNV.getPreferredSize());
		lblTienLuong.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		cboPhongBan.setPreferredSize(lblMaNV.getPreferredSize());
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);

		String[] colHeader = { "Mã NV", "Họ NV", "Tên NV", "Tuổi", "Phái", "Lương", "Phòng ban" };
		modelNhanVien = new DefaultTableModel(colHeader, 0);
		tableNhanVien = new JTable(modelNhanVien);
		add(new JScrollPane(tableNhanVien), BorderLayout.CENTER);

		// =================================
		// doc du lieu tu database SQL vao Jtable
		updateTable();
		
		// =================================

		JPanel p = new JPanel();
		add(p, BorderLayout.SOUTH);
		JPanel pnlLeft, pnlRight;
		p.add(pnlLeft = new JPanel());
		p.add(pnlRight = new JPanel());

		pnlLeft.add(lblTim = new JLabel("Nhập mã số cần tìm: "));
		pnlLeft.add(txtTim = new JTextField(10));
		pnlLeft.add(bttTim = new JButton("Tìm"));

		pnlRight.add(bttThem = new JButton("Thêm"));
		pnlRight.add(bttXoaTrang = new JButton("Xóa trắng"));
		pnlRight.add(bttXoa = new JButton("Xóa"));
		pnlRight.add(bttCapNhat = new JButton("Cập nhật"));
		pnlRight.add(bttLuu = new JButton("Lưu"));
		
		turnOffEdit();

		bttTim.addActionListener(this);
		bttThem.addActionListener(this);
		bttXoa.addActionListener(this);
		bttCapNhat.addActionListener(this);
		bttXoaTrang.addActionListener(this);
		bttLuu.addActionListener(this);
		tableNhanVien.addMouseListener(this);
	}
	
	public void docDuLieuDatabaseVaoTable() {
		ArrayList<NhanVien> dsnv = nv_dao.getAllTBNhanVien();
		for (NhanVien nv : dsnv) {
			modelNhanVien.addRow(new Object[] {nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), nv.getPhai() == false ? "Nam" : "Nữ", nv.getLuong(), nv.getPhong().getMaPhongBan()});
		}
	}
	
	public void xoaTrangTable() {
		while (tableNhanVien.getRowCount() != 0) {
			modelNhanVien.removeRow(0);
			
		}
	}
	
	public void updateTable() {
		xoaTrangTable();
		docDuLieuDatabaseVaoTable();
	}

	public void turnOffEdit() {
		txtMaNV.setEditable(false);
		txtHo.setEditable(false);
		txtTen.setEditable(false);
		txtTuoi.setEditable(false);
		txtTienLuong.setEditable(false);
		chkNu.setEnabled(false);
		cboPhongBan.setEnabled(false);
		bttThem.setEnabled(true);
		bttCapNhat.setEnabled(false);
		bttXoaTrang.setEnabled(false);
		bttXoa.setEnabled(false);
		bttLuu.setEnabled(false);
	}
	
	public void turnOnEdit() {
		txtMaNV.setEditable(true);
		txtHo.setEditable(true);
		txtTen.setEditable(true);
		txtTuoi.setEditable(true);
		txtTienLuong.setEditable(true);
		chkNu.setEnabled(true);
		cboPhongBan.setEnabled(true);
		bttThem.setEnabled(true);
		bttXoaTrang.setEnabled(true);
		bttLuu.setEnabled(true);
	}
	
	public static void main(String[] args) {
		new NhanVien_GUI().setVisible(true);
	}
	
	public boolean StringToIntParsable(String str) {
		if (str.compareToIgnoreCase("") == 0) {
			return true;       
		}
		try {
			Integer.parseInt(str);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean StringToDoubleParsable(String str) {
		if (str.compareToIgnoreCase("") == 0) {
			return true;
		}
		try {
			Double.parseDouble(str);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void clickBttTim() {
		int tim = 0;
		if (StringToIntParsable(txtTim.getText().trim())) {
			tim = Integer.parseInt(txtTim.getText().trim());
		} else {
			JOptionPane.showMessageDialog(this, "Mã không được chứa chữ");
		}
		ArrayList<NhanVien> foundationList = nv_dao.getNhanVienTheoMa(tim);
		xoaTrangTable();
		for (NhanVien nv : foundationList) {
			modelNhanVien.addRow(new Object[] {nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), nv.getPhai() == false ? "Nam" : "Nữ", nv.getLuong(), nv.getPhong().getMaPhongBan()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o.equals(bttThem)) {
			if (bttThem.getText() == "Thêm") {
				flagThem = 1;
				turnOnEdit();
				bttThem.setText("Hủy");
				
			}
			else {
				flagThem = 0;
				turnOffEdit();
				bttThem.setText("Thêm");
			}
		}
		
		if (o.equals(bttLuu)) {
			if (flagThem == 1) {
				if (txtMaNV.getText().compareTo("") == 0) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên không được trống");
					return;
				}
				
				String strMa = txtMaNV.getText();
				if (!StringToIntParsable(strMa)) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên không được chứa chữ");
					return;
				}
				int ma = Integer.parseInt(strMa);
				
				String ho = txtHo.getText();
				String ten = txtTen.getText();
				
				String strTuoi = txtTuoi.getText();
				if (!StringToIntParsable(strTuoi)) {
					JOptionPane.showMessageDialog(this, "Tuổi phải là số");
					return;
				}
				int tuoi = Integer.parseInt(strTuoi);
				if (tuoi < 0 || tuoi > 100) {
					JOptionPane.showMessageDialog(this, "Tuổi không hợp lệ!");
					return;
				}
				
				boolean phai = false;
				if (chkNu.isSelected()) {
					phai = true;
				}
				
				String strLuong = txtTienLuong.getText();
				if (!StringToDoubleParsable(strLuong)) {
					JOptionPane.showMessageDialog(this, "Lương phải là số");
					return;
				}
				double luong = Double.parseDouble(strLuong);
				if (luong < 0) {
					JOptionPane.showMessageDialog(this, "Lương không phải là số âm!?");
					return;
				}
				
				String phongBan = cboPhongBan.getSelectedItem().toString();
				
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong, new PhongBan(phongBan));
				
				ArrayList<NhanVien> ds = nv_dao.getAllTBNhanVien();
				if (ds.contains(nv)) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
					return;
				}
				
				nv_dao.create(nv);
				updateTable();
				turnOffEdit();
				bttThem.setText("Thêm");
				
			}
			
			else {
				int ma = Integer.parseInt(txtMaNV.getText());
				String ho = txtHo.getText();
				String ten = txtTen.getText();
				
				String strTuoi = txtTuoi.getText();
				if (!StringToIntParsable(strTuoi)) {
					JOptionPane.showMessageDialog(this, "Tuổi phải là số");
					return;
				}
				int tuoi = Integer.parseInt(strTuoi);
				if (tuoi < 0 || tuoi > 100) {
					JOptionPane.showMessageDialog(this, "Tuổi không có thật!?");
					return;
				}
				
				boolean phai = false;
				if (chkNu.isSelected()) {
					phai = true;
				}
				
				String strLuong = txtTienLuong.getText();
				if (!StringToDoubleParsable(strLuong)) {
					JOptionPane.showMessageDialog(this, "Lương phải là số");
					return;
				}
				double luong = Double.parseDouble(strLuong);
				if (luong < 0) {
					JOptionPane.showMessageDialog(this, "Lương không phải là số âm!?");
					return;
				}
				
				String phongBan = cboPhongBan.getSelectedItem().toString();
				
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong, new PhongBan(phongBan));
				
				nv_dao.update(nv);
				updateTable();
				turnOffEdit();
				bttThem.setText("Thêm");
			}
			
		}
		
		if (o.equals(bttXoa)) {
			int r = tableNhanVien.getSelectedRow();
			int maNV = (int) modelNhanVien.getValueAt(r, 0);
			if (r != -1) {
				int kq = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này?");
				if (kq == JOptionPane.YES_OPTION) {
					nv_dao.delete(maNV);
					if (flagTim == 1) {
						clickBttTim();
					}
					else updateTable();
					if (tableNhanVien.getRowCount() != 0) {
						if (r == tableNhanVien.getRowCount()) {
							tableNhanVien.setRowSelectionInterval(r - 1, r - 1);
							tableNhanVien.scrollRectToVisible(tableNhanVien.getCellRect(r - 1, r - 1, true));
						}
						else {
							tableNhanVien.setRowSelectionInterval(r, r);
							tableNhanVien.scrollRectToVisible(tableNhanVien.getCellRect(r, r, true));
						}
						
					}
				}
				
			}

		}
		
		if (o.equals(bttXoaTrang)) {
			txtHo.setText("");
			txtMaNV.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtTienLuong.setText("");
			txtMaNV.requestFocus();
		}
		
		if (o.equals(bttTim)) {
			if (bttTim.getText().compareTo("Tìm") == 0) {
				flagTim = 1;
				clickBttTim();
				bttTim.setText("Hủy");
			}
			else {
				flagTim = 0;
				updateTable();
				bttTim.setText("Tìm");
			}
			
		}
		
		if (o.equals(bttCapNhat)) {
			turnOnEdit();
			txtMaNV.setEditable(false);
		}

	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableNhanVien.getSelectedRow();
		txtMaNV.setText(modelNhanVien.getValueAt(row, 0).toString());
		txtHo.setText(modelNhanVien.getValueAt(row, 1).toString());
		txtTen.setText(modelNhanVien.getValueAt(row, 2).toString());
		txtTuoi.setText(modelNhanVien.getValueAt(row, 3).toString());
		chkNu.setSelected(modelNhanVien.getValueAt(row, 4).toString() == "Nữ" ? true : false);
		txtTienLuong.setText(modelNhanVien.getValueAt(row, 5).toString());
		cboPhongBan.setSelectedItem(modelNhanVien.getValueAt(row, 6).toString());
		
		turnOffEdit();
		bttThem.setText("Thêm");
		bttXoa.setEnabled(true);
		bttCapNhat.setEnabled(true);
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
}
