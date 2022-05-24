package ui;

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
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import dao.PhongBan_DAO;
import entity.NhanVien;
import entity.PhongBan;

@SuppressWarnings("serial")
public class GUI extends JFrame implements MouseListener, ActionListener {
	private NhanVien_DAO nv_dao;
	private PhongBan_DAO pb_dao;
	
	private JTable table;
	private DefaultTableModel model;
	
	private JTextField txtMa;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtLuong;
	private JTextField txtTim;
	
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JButton btnXoaTrang;
	private JButton btnLuu;
	
	private JCheckBox chkNu;
	private JComboBox<String> cboPB;
	
	private int flagTim = 0;
	private int flagThem = 0;
	
	@SuppressWarnings("unused")
	public GUI() {
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
		
		JLabel lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.BLUE);
		
		Box b = Box.createVerticalBox();
		
		Box b11, b1, b2, b3, b4;
		JLabel lblMa, lblHo, lblTen, lblTuoi, lblPhai, lblTienLuong, lblTim;
		
		b.add(b11 = Box.createHorizontalBox());
		b11.add(lblTieuDe);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMa = new JLabel("Mã nhân viên: "));
		b1.add(txtMa = new JTextField());
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblHo = new JLabel("Họ"));
		b2.add(txtHo = new JTextField());
		b2.add(lblTen = new JLabel("Tên nhân viên: "));
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
		b4.add(txtLuong = new JTextField());
		b4.add(lblTienLuong = new JLabel("Phòng ban: "));
		b4.add(cboPB = new JComboBox<String>());
		
		ArrayList<PhongBan> listPB = pb_dao.getAll();
		for (PhongBan phongBan : listPB) {
			cboPB.addItem(phongBan.getMaPhongBan());
		}
		
		lblHo.setPreferredSize(lblMa.getPreferredSize());
		lblPhai.setPreferredSize(lblMa.getPreferredSize());
		lblTienLuong.setPreferredSize(lblMa.getPreferredSize());
		lblTuoi.setPreferredSize(lblMa.getPreferredSize());
		cboPB.setPreferredSize(lblMa.getPreferredSize());
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);	
		
		String[] colHeader = {"Mã nhân viên", "Họ", "Tên nhân viên", "Tuổi", "Phái", "Lương", "Phòng Ban"};
		model = new DefaultTableModel(colHeader, 0);
		table = new JTable(model);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		updateTable();
		
		JSplitPane sp;
		add(sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT), BorderLayout.SOUTH);
		sp.setResizeWeight(0.5);
		
		JPanel pnLeft, pnRight;
		sp.add(pnLeft = new JPanel());
		sp.add(pnRight = new JPanel());
		
		pnLeft.add(lblTim = new JLabel("Nhập mã số cần tìm: "));
		pnLeft.add(txtTim = new JTextField(15));
		pnLeft.add(btnTim = new JButton("Tìm"));
		
		pnRight.add(btnThem = new JButton("Thêm"));
		pnRight.add(btnXoaTrang = new JButton("Xóa Trắng"));
		pnRight.add(btnXoa = new JButton("Xóa"));
		pnRight.add(btnCapNhat = new JButton("Cập nhật"));
		pnRight.add(btnLuu = new JButton("Lưu"));
		
		turnOffEdit();
		
		table.addMouseListener(this);
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnLuu.addActionListener(this);
		
	}
	
	public void docDuLieuDBVaoTable() {
		ArrayList<NhanVien> dsnv = nv_dao.getAll();
		for (NhanVien nv : dsnv) {
			model.addRow(new Object[] {nv.getMa(), nv.getHo(), nv.getTen(), nv.getTuoi(), nv.isPhai() == false ? "Nam" : "Nữ", nv.getLuong(), nv.getPhongBan().getMaPhongBan()});
		}
	}
	
	public void xoaTrangTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
		dtm.fireTableDataChanged();
	}
	
	public void updateTable() {
		xoaTrangTable();
		docDuLieuDBVaoTable();
	}
	
	public void turnOffEdit() {
		txtMa.setEditable(false);
		txtHo.setEditable(false);
		txtTen.setEditable(false);
		txtTuoi.setEditable(false);
		txtLuong.setEditable(false);
		chkNu.setEnabled(false);
		cboPB.setEnabled(false);
		btnThem.setEnabled(true);
		btnThem.setText("Thêm");
		btnCapNhat.setEnabled(false);
		btnXoaTrang.setEnabled(false);
		btnXoa.setEnabled(false);
		btnLuu.setEnabled(false);
	}
	
	public void turnOnEdit() {
		txtMa.setEditable(true);
		txtHo.setEditable(true);
		txtTen.setEditable(true);
		txtTuoi.setEditable(true);
		txtLuong.setEditable(true);
		chkNu.setEnabled(true);
		cboPB.setEnabled(true);
		btnThem.setEnabled(true);
		btnXoaTrang.setEnabled(true);
		btnLuu.setEnabled(true);
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
	
	public void clickBtnTim() {
		int tim = 0;
		if (txtTim.getText().trim().compareTo("") == 0) {
			return;
		}
		if (StringToIntParsable(txtTim.getText().trim())) {
			tim = Integer.parseInt(txtTim.getText().trim());
		} else {
			JOptionPane.showMessageDialog(this, "Mã không được chứa chữ");
			return;
		}
		ArrayList<NhanVien> foundationList = nv_dao.getNhanVienTheoMa(tim);
		xoaTrangTable();
		for (NhanVien nv : foundationList) {
			model.addRow(new Object[] {nv.getMa(), nv.getHo(), nv.getTen(), nv.getTuoi(), nv.isPhai() == false ? "Nam" : "Nữ", nv.getLuong(), nv.getPhongBan().getMaPhongBan()});
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o.equals(btnThem)) {
			if (btnThem.getText() == "Thêm") {
				flagThem = 1;
				turnOnEdit();
				btnThem.setText("Hủy");
			}
			else {
				flagThem = 0;
				turnOffEdit();
				btnThem.setText("Thêm");
			}
		}
		
		if (o.equals(btnLuu)) {
			if (flagThem == 1) {
				if (txtMa.getText().trim().compareTo("") == 0) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên không được trống");
					return;
				}
				
				String strMa = txtMa.getText().trim();
				if (!StringToIntParsable(strMa)) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên không được chứa chữ");
					return;
				}
				
				int ma = Integer.parseInt(strMa);
				
				String ho = txtHo.getText().trim();
				String ten = txtTen.getText().trim();
				
				String strTuoi = txtTuoi.getText().trim();
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
				
				String strLuong = txtLuong.getText().trim();
				if (!StringToDoubleParsable(strLuong)) {
					JOptionPane.showMessageDialog(this, "Lương phải là số");
					return;
				}
				
				double luong = Double.parseDouble(strLuong);
				
				if (luong < 0) {
					JOptionPane.showMessageDialog(this, "Lương không phải là số âm!?");
					return;
				}
				
				String pb = cboPB.getSelectedItem().toString();
				
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong, new PhongBan(pb));
				
				ArrayList<NhanVien> ds = nv_dao.getAll();
				if (ds.contains(nv)) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
					return;
				}
				
				nv_dao.create(nv);
				updateTable();
				turnOffEdit();
			}
			
			else {
				int ma = Integer.parseInt(txtMa.getText().trim());
				
				String ho = txtHo.getText().trim();
				String ten = txtTen.getText().trim();
				
				String strTuoi = txtTuoi.getText().trim();
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
				
				String strLuong = txtLuong.getText().trim();
				if (!StringToDoubleParsable(strLuong)) {
					JOptionPane.showMessageDialog(this, "Lương phải là số");
					return;
				}
				
				double luong = Double.parseDouble(strLuong);
				
				if (luong < 0) {
					JOptionPane.showMessageDialog(this, "Lương không phải là số âm!?");
					return;
				}
				
				String pb = cboPB.getSelectedItem().toString();
				
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong, new PhongBan(pb));
				
				nv_dao.update(nv);
				updateTable();
				turnOffEdit();
			}
		}
		
		if (o.equals(btnXoaTrang)) {
			txtMa.setText("");
			txtHo.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtLuong.setText("");
			txtMa.requestFocus();
		}
		
		if (o.equals(btnXoa)) {
			int r = table.getSelectedRow();
			int ma = (int) model.getValueAt(r, 0);
			
			int kq = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này?");
			if (kq == JOptionPane.YES_OPTION) {
				nv_dao.delete(ma);
			}
			if (flagTim == 1) {
				clickBtnTim();
			}
			else {
				updateTable();
			}
			if (table.getRowCount() != 0) {
				if (r == table.getRowCount()) {
					table.setRowSelectionInterval(r - 1, r - 1);
				}
				else {
					table.setRowSelectionInterval(r, r);
				}
			}
		}
		
		if (o.equals(btnTim)) {
			if (btnTim.getText().compareTo("Tìm") == 0) {
				flagTim = 1;
				clickBtnTim();
				btnTim.setText("Hủy");
			}
			else {
				flagTim = 0;
				updateTable();
				btnTim.setText("Tìm");
			}
			
		}
		
		if (o.equals(btnCapNhat)) {
			turnOnEdit();
			txtMa.setEditable(false);
		}
		
	}
	
	public static void main(String[] args) {
		new GUI().setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMa.setText(model.getValueAt(row, 0).toString());
		txtHo.setText(model.getValueAt(row, 1).toString());
		txtTen.setText(model.getValueAt(row, 2).toString());
		txtTuoi.setText(model.getValueAt(row, 3).toString());
		chkNu.setSelected(model.getValueAt(row, 4).toString() == "Nữ" ? true : false);
		txtLuong.setText(model.getValueAt(row, 5).toString());
		cboPB.setSelectedItem(model.getValueAt(row, 6).toString());
		
		turnOffEdit();
		btnXoa.setEnabled(true);
		btnCapNhat.setEnabled(true);		
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
