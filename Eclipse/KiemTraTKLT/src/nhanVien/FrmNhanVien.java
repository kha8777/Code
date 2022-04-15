package nhanVien;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;



public class FrmNhanVien extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtTuoi;
	private JTextField txtEmail;
	
	private JButton btnThem;
	private JTable table;
	private JButton btnXoaRong;

	private DefaultTableModel tableModel;
	
	private DanhSachNhanVien ls = new DanhSachNhanVien();

	public FrmNhanVien() {
		setTitle("Kiểm tra biểu thức chính quy");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}

	private void buildUI() {

		// Phần North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Thông tin"));
		pnlNorth.setLayout(null); // Absolute layout

		JLabel lblMaNV, lblHoTen, lblDiaChi, lblTuoi, lblEmail;
		pnlNorth.add(lblMaNV = new JLabel("Mã nhân viên: "));
		pnlNorth.add(lblHoTen = new JLabel("Họ tên: "));
		pnlNorth.add(lblDiaChi = new JLabel("Địa chỉ: "));
		pnlNorth.add(lblTuoi = new JLabel("Tuổi: "));
		pnlNorth.add(lblEmail = new JLabel("Email: "));
		
		pnlNorth.add(txtMa = new JTextField());
		pnlNorth.add(txtTen = new JTextField());
		pnlNorth.add(txtDiaChi = new JTextField());
		pnlNorth.add(txtTuoi = new JTextField());
		pnlNorth.add(txtEmail = new JTextField());
		

		int w1 = 100, w2 = 300, h = 20;
		lblMaNV.setBounds(20, 20, w1, h);
		txtMa.setBounds(120, 20, 200, h);

		lblHoTen.setBounds(20, 45, w1, h);
		txtTen.setBounds(120, 45, w2, h);
		lblDiaChi.setBounds(450, 45, w1, h);
		txtDiaChi.setBounds(570, 45, w2, h);

		lblTuoi.setBounds(20, 70, w1, h);
		txtTuoi.setBounds(120, 70, w2, h);
		lblEmail.setBounds(450, 70, w1, h);
		txtEmail.setBounds(570, 70, w2, h);

		// PHần Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("Thêm - Kiểm tra dữ liệu"));
		pnlCenter.add(btnXoaRong = new JButton("Xóa trắng"));

		// Phần South
		JScrollPane scroll;
		String[] headers = "Mã nhân viên;Họ tên;Tuổi;Địa chỉ;Email".split(";");

		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
	
		btnThem.addActionListener(this);		
		btnXoaRong.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(btnXoaRong))
			clearTextfields();
		
		if(o.equals(btnThem)) {
			if (validData()) {
				them();
				updateTable();
			}
		}
			
			
	}

	

	private void clearTextfields() {
		txtMa.setText("");
		txtTen.setText("");
		txtDiaChi.setText("");
		txtTuoi.setText("");
		txtEmail.setText("");
	
		txtMa.setEditable(true);
		txtMa.requestFocus();
	}
	
	private boolean validData() {
		String manv = txtMa.getText().trim();
		String tennv = txtTen.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String tuoi = txtTuoi.getText().trim();
		String email = txtEmail.getText().trim();
		if (manv.length() > 0) {
			if (!manv.matches("NV\\d{8}")) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên phải theo định dạng: NV99999999");
				return false;
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống");
			return false;
		}
		if (ls.check(manv)) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
			return false;
		}
		
		if (tennv.length() > 0) {
			if (!tennv.matches("[a-zA-Z\\sÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐáàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]+")) {
				JOptionPane.showMessageDialog(this, "Tên nhân viên không được chứa ký tự đặc biệt");
				return false;
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống");
			return false;
		}
		
		if (diachi.length() > 0) {
			if (!diachi.matches("[(?=[,/.])\\w+\\sÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐáàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]+")) {
				JOptionPane.showMessageDialog(this, "Địa chỉ không được chứa ký tự đặc biệt");
				return false;
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống");
			return false;
		}
		
		if (tuoi.length() > 0) {
			try {
				int x = Integer.parseInt(tuoi);
				if (!(x >= 18 && x <= 65)) {
					JOptionPane.showMessageDialog(this, "Tuổi phải từ 18 đến 65");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Tuổi phải là kiểu số");
				return false;
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Tuổi không được để trống");
			return false;
		}
		
		if (email.length() > 0) {
			if (!email.matches("\\w+@\\w+\\.\\w+{2,6}")) {
				JOptionPane.showMessageDialog(this, "Email phải theo định dạng ten@tencongty.tenmien");
				return false;
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Email không được để trống");
			return false;
		}
		
		return true;
	}
	
	private void them() {
		ls.themNv(new NhanVien(txtMa.getText().trim(), txtTen.getText().trim(), txtDiaChi.getText().trim(), Integer.parseInt(txtTuoi.getText()), txtEmail.getText().trim()));
	}
	
	private void updateTable() {
		xoaTrangTable();
		ArrayList<NhanVien> ds = ls.getLs();
		for (NhanVien nv : ds) {
			tableModel.addRow(new Object[] {
				nv.getMaNV(),
				nv.getHoTen(),
				nv.getDiaChi(),
				nv.getTuoi(),
				nv.getEmail()
			});
		}
	}
	
	private void xoaTrangTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
		dtm.fireTableDataChanged();
	}
	
}
