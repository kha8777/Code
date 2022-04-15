package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import manage.SachTableModel;
import manage.ThuVien;
import db.Database;
import entity.Sach;


public class FrmDanhMucSach extends JFrame implements ActionListener{
	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtTacGia;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnLoc;
	private JComboBox<String> cboMaSach;
	private JTable table;
	private JTextField txtMess;
	private JPanel pnCenter,pnSouth,pnNorth;
	private DefaultTableModel model;
	private ThuVien thuvien;
	private SachTableModel tableModel;
	
	public FrmDanhMucSach() {
		setTitle("Quản lí sách");
		setSize(900,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initIUI();
	}
	private void initIUI() {	    
			add(pnNorth = new JPanel(), BorderLayout.NORTH);
			pnNorth.setPreferredSize(new Dimension(0, 180));
			pnNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
			pnNorth.setLayout(null); //Absolute layout

			pnNorth.add(lblMaSach = new JLabel("Mã sách: "));
			pnNorth.add(lblTuaSach = new JLabel("Tựa sách: "));
			pnNorth.add(lblTacGia = new JLabel("Tác giả: "));
			pnNorth.add(lblNamXB = new JLabel("Năm xuất bản: "));
			pnNorth.add(lblNhaXB = new JLabel("Nhà xuất bản: "));
			pnNorth.add(lblSoTrang = new JLabel("Số trang: "));
			pnNorth.add(lblDonGia = new JLabel("Đơn giá: "));
			pnNorth.add(lblISBN = new JLabel("International Standard Book Number: "));

			pnNorth.add(txtMaSach = new JTextField());
			pnNorth.add(txtTuaSach = new JTextField());
			pnNorth.add(txtTacGia = new JTextField());
			pnNorth.add(txtNamXB = new JTextField());
			pnNorth.add(txtNhaXB = new JTextField());
			pnNorth.add(txtSoTrang = new JTextField());
			pnNorth.add(txtDonGia = new JTextField());
			pnNorth.add(txtISBN = new JTextField());
			pnNorth.add(txtMess = new JTextField());
			txtMess.setEditable(false);
			txtMess.setBorder(null);
			txtMess.setForeground(Color.red);
			txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

			int w1 = 100, w2 = 300, h = 20;
			lblMaSach.setBounds(20, 20, w1, h); txtMaSach.setBounds(120, 20, 200, h);

			lblTuaSach.setBounds(20, 45, w1, h); txtTuaSach.setBounds(120, 45, w2, h);
			lblTacGia.setBounds(450, 45, w1, h); txtTacGia.setBounds(570, 45, w2, h);

			lblNamXB.setBounds(20, 70, w1, h); txtNamXB.setBounds(120, 70, w2, h);
			lblNhaXB.setBounds(450, 70, w1, h); txtNhaXB.setBounds(570, 70, w2, h);

			lblSoTrang.setBounds(20, 95, w1, h); txtSoTrang.setBounds(120, 95, w2, h);
			lblDonGia.setBounds(450, 95, w1, h); txtDonGia.setBounds(570, 95, w2, h);

			lblISBN.setBounds(20, 120, 220, h); txtISBN.setBounds(240, 120, 180, h);
			txtMess.setBounds(20, 145, 550, 20);

			//Phần Center
			add(pnCenter = new JPanel(), BorderLayout.CENTER);
			pnCenter.add(btnThem = new JButton("Thêm")); 
			pnCenter.add(btnXoaRong = new JButton("Xóa rỗng"));
			pnCenter.add(btnXoa = new JButton("Xóa"));
			pnCenter.add(btnSua = new JButton("Sửa"));
			pnCenter.add(btnLuu = new JButton("Lưu"));
			pnCenter.add(new JLabel("Tìm theo mã sách: "));
			pnCenter.add(cboMaSach = new JComboBox<String>());
			cboMaSach.setPreferredSize(new Dimension(100, 25));
			pnCenter.add(btnLoc = new JButton("Lọc theo tựa sách"));
  		    add(pnSouth = new JPanel(), BorderLayout.SOUTH);
		   taoBang();

		
	}
	    private void taoBang() {
		// TODO Auto-generated method stub
		JPanel pnTable = new JPanel();
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã Sách");
		model.addColumn("Tựa sách");
		model.addColumn("Tác giả");
		model.addColumn("Năm xuất bản");
		model.addColumn("Nhà xuất bản");
		model.addColumn("Số trang");
		model.addColumn("Đơn giá");
		model.addColumn("ISBN");
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderner = new DefaultTableCellRenderer();
		rightRenderner.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderner);
		table.getColumnModel().getColumn(6).setCellRenderer(rightRenderner);
		JScrollPane sp = new JScrollPane( table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(880,335));
		sp.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		pnSouth.add(sp);
		
		//Xử lý

				thuvien = new ThuVien();
				thuvien.napDuLieuTuFile();
				
				updateTableData();  //Cập nhật dữ liệu cho table
				updateComboboxData(); //Cập nhật dữ liệu cho Combobox

				table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						int row = table.getSelectedRow(); //Lấy dòng được chọn
						fillForm(row); //Hiển thị trên các components
					}
				});

				cboMaSach.addActionListener(this);
				btnThem.addActionListener(this);
				btnXoa.addActionListener(this);
				btnXoaRong.addActionListener(this);
				btnSua.addActionListener(this);
				btnLuu.addActionListener(this);
				btnLoc.addActionListener(this);
	}
	    private void fillForm(int row) {
			if(row != -1){
				String maSach = (String) table.getValueAt(row, 0);
				Sach s = new Sach(maSach);
				ArrayList<Sach> dsSach = thuvien.getDsSach();
				if(thuvien.getDsSach().contains(s)){
					s = dsSach.get(dsSach.indexOf(s));
					txtMaSach.setText(s.getMaSach());
					txtTuaSach.setText(s.getTuaSach());
					txtTacGia.setText(s.getTacGia());
					txtNhaXB.setText(s.getNhaXB());
					txtNamXB.setText(s.getNamXB() + "");
					txtSoTrang.setText(s.getSoTrang() + "");
					txtDonGia.setText(s.getDonGia() + "");
					txtISBN.setText(s.getIsbn());
					txtMaSach.setEditable(false);
				}
			}
		}

		private void updateComboboxData() {
			int n = thuvien.count(); //Tổng số các cuốn sách
			String []items = new String[n];
			int i = 0;
			for(Sach s : thuvien.getDsSach()){
				items[i] = s.getMaSach();
				i++;
			}
			cboMaSach.setModel(new DefaultComboBoxModel<String>(items));
		}

		private void updateTableData() {
			tableModel = new SachTableModel(thuvien.getDsSach());
			table.setModel(tableModel);
			//tableModel.addRow(thuvien.getDsSach());
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(o.equals(cboMaSach)){
				String maSach = (String) cboMaSach.getSelectedItem();
				Sach s = thuvien.timKiem(maSach);
				if(s != null){
					int index = thuvien.getDsSach().indexOf(s);
					fillForm(index);
					table.getSelectionModel().setSelectionInterval(index, index);
					table.scrollRectToVisible(table.getCellRect(index, index, true));
				}
			}else if (o.equals(btnXoa)){
				int row = table.getSelectedRow();
				if(row != -1){
					int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
					if(hoiNhac == JOptionPane.YES_OPTION){
						if(thuvien.xoa1CuonSach(row)){
							txtMess.setText("Đã xóa 1 cuốn sách.");
							updateTableData();
							updateComboboxData();
							clearTextfields();
						}
					}
				}else
					txtMess.setText("Bạn phải chọn cuốn sách cần xóa. ");
			}else if(o.equals(btnThem)){
				if(validData()){
					Sach s = revertSachFromTextfields();
					if(thuvien.themSach(s)){
						txtMess.setText("THêm thành công 1 cuốn sách.");
						updateTableData(); //Cập nhật dữ liệu xuống bảng
						updateComboboxData();//Cập nhật dữ liệu vào combobox
						clearTextfields();	
					}else{
						showMessage("Error: Trùng mã sách", txtMaSach);
					}
				}
			}else if(o.equals(btnXoaRong)){
				clearTextfields();
			}else if(o.equals(btnSua)){
				String maSachOld = txtMaSach.getText().trim();
				if(validData()){ //Cần phải kiểm tra tính hợp lệ khi sửa thông tin cuốn sách
					Sach sachNew = revertSachFromTextfields();
					if(thuvien.capNhatSach(maSachOld, sachNew)){
						txtMess.setText("Cập nhật thành công. ");
						updateTableData();//Cập nhật dữ liệu lại cho table
						int index = thuvien.getDsSach().indexOf(sachNew);
						table.setRowSelectionInterval(index, index);
					}else
						txtMess.setText("Cần chọn cuốn sách để cập nhật. ");
				}
			}else if(o.equals(btnLuu)){
			//	Database.ghiXuongFile(thuvien.getDsSach());
				txtMess.setText("Lưu thành công. ");
			}else if(o.equals(btnLoc)){
				String regex = JOptionPane.showInputDialog("Nhập tựa sách cần lọc: ");
				if(regex != null && !regex.trim().equals("")){
					ArrayList<Sach> temp = thuvien.filter(regex);
					table.setModel(new SachTableModel(temp));
				}else
					updateTableData();
			}
		}

		private void showMessage(String message, JTextField txt) {
			txt.requestFocus();
			txtMess.setText(message);
		}

		private boolean validData() {
			String maSach = txtMaSach.getText().trim();
			String tuaSach = txtTuaSach.getText().trim();
			String tacGia = txtTacGia.getText().trim();
			String nam = txtNamXB.getText().trim();
			String gia = txtDonGia.getText().trim();
			String isbn = txtISBN.getText().trim();
			String soTrang = txtSoTrang.getText().trim();
			
			// Có ký tự đầu là ký tự đầu của tựa sách, theo sau là 3 ký số
			if (!(maSach.length() > 0 && maSach.matches("[A-Z]\\d{3}"))) {
				showMessage("Error: Mã sách theo mẫu: [A-Z]\\d{3}", txtMaSach);
				return false;
			}
			// Tựa sách, và tác giả không được để trống,
			// có thể gồm nhiều từ ngăn cách bởi khoảng trắng.
			// Không chứa ký số hoặc các ký tự đặc biệt khác, ngoại trừ ký tự ‘
			if (!(tuaSach.length() > 0 && tuaSach.matches("[a-zA-Z' ]+"))) {
				showMessage("Error: Tựa sách theo mẫu: [a-zA-Z' ]+", txtTuaSach);
				return false;
			}
			if (!(tacGia.length() > 0 && tacGia.matches("[a-zA-Z' ]+"))) {
				showMessage("Error: Tác giả theo mẫu: [a-zA-Z' ]+", txtTacGia);
				return false;
			}
			if (nam.length() > 0) {
				try {
					int x = Integer.parseInt(nam);
					int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
					if (!(x >= 1900 && x < namHienTai)) {
						showMessage("Error: Năm xuất bản >= 1900 && <= " 
								+ namHienTai, txtNamXB);
						return false;
					}
				} catch (NumberFormatException ex) {
					showMessage("Error: Năm xuất bản phải nhập số.", txtNamXB);
					return false;
				}
			}

			if (soTrang.length() > 0) {
				try {
					int x = Integer.parseInt(soTrang);
					if (x <= 0) {
						showMessage("Error: Số trang phải nhập số nguyên dương.", txtSoTrang);
						return false;
					}
				} catch (NumberFormatException ex) {
					showMessage("Error: Số trang phải nhập số nguyên dương.", txtSoTrang);
					return false;
				}
			}

			if (gia.length() > 0) {
				try {
					double y = Double.parseDouble(gia);
					if (y < 0) {
						showMessage("Error: Đơn giá phải > 0.", txtDonGia);
						return false;
					}
				} catch (NumberFormatException ex) {
					showMessage("Error: Đơn giá phải nhập số.", txtDonGia);
					return false;
				}
			}
			// ISBN có mẫu dạng X-X-X-X (hoặc X-X-X-X-X).
			// Trong đó, X gồm các ký số, ít nhất là 1 ký số
			if (isbn.length() > 0)
				if (!isbn.matches("\\d+(-\\d+){3,4}")) {
					showMessage("Error: ISBN có mẫu dạng  X-X-X-X  (hoặc X-X-X-X-X).", txtISBN);
					return false;
				}
		

			return true;
		}

		private Sach revertSachFromTextfields() {
			String maSach = txtMaSach.getText().trim();
			String tuaSach = txtTuaSach.getText().trim();
			String tacGia = txtTacGia.getText().trim();
             
			String nam = txtNamXB.getText().trim();
			int namXB = nam.length() == 0 ? 0 : Integer.parseInt(nam); //Để trống thì coi như là 0

			String nhaXB = txtNhaXB.getText().trim();

			String trang = txtSoTrang.getText().trim();
			int soTrang = trang.length() == 0 ? 0 : Integer.parseInt(trang);

			String gia = txtDonGia.getText().trim();
			double donGia = gia.equals("") ? 0 : Double.parseDouble(gia);

			String isbn = txtISBN.getText().trim();
			return new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, isbn);
		}

		private void clearTextfields() {
			txtMaSach.setText("");
			txtTuaSach.setText("");
			txtTacGia.setText("");
			txtNamXB.setText("");
			txtNhaXB.setText("");
			txtSoTrang.setText("");
			txtDonGia.setText("");
			txtISBN.setText("");
			txtMaSach.setEditable(true);
			txtMaSach.requestFocus();
		}
	public static void main(String[] args) {
		new FrmDanhMucSach().setVisible(true);
	}
	
	

}
