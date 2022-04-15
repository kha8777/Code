package Bai1_IO_QLSach;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class FrmDanhMucSach extends JFrame implements ActionListener  {

	
	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtTacGia;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JComboBox<String> cboMaSach;
	private JTable table;
	private JTextField txtMess;
	private JButton btnXoaRong;
	private ThuVien thuvien;
	//private SachTableModel tableModel;
	SachTableModel tableModel;
	private JButton btnLoc;

	public FrmDanhMucSach() {
		setTitle("Quáº£n lĂ½ sĂ¡ch");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}

	private void buildUI() {

		//Pháº§n North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pnlNorth.setLayout(null); //Absolute layout

		JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
		pnlNorth.add(lblMaSach = new JLabel("MĂ£ sĂ¡ch: "));
		pnlNorth.add(lblTuaSach = new JLabel("Tá»±a sĂ¡ch: "));
		pnlNorth.add(lblTacGia = new JLabel("TĂ¡c giáº£: "));
		pnlNorth.add(lblNamXB = new JLabel("NÄƒm xuáº¥t báº£n: "));
		pnlNorth.add(lblNhaXB = new JLabel("NhĂ  xuáº¥t báº£n: "));
		pnlNorth.add(lblSoTrang = new JLabel("Sá»‘ trang: "));
		pnlNorth.add(lblDonGia = new JLabel("Ä�Æ¡n giĂ¡: "));
		pnlNorth.add(lblISBN = new JLabel("International Standard Book Number: "));

		pnlNorth.add(txtMaSach = new JTextField());
		pnlNorth.add(txtTuaSach = new JTextField());
		pnlNorth.add(txtTacGia = new JTextField());
		pnlNorth.add(txtNamXB = new JTextField());
		pnlNorth.add(txtNhaXB = new JTextField());
		pnlNorth.add(txtSoTrang = new JTextField());
		pnlNorth.add(txtDonGia = new JTextField());
		pnlNorth.add(txtISBN = new JTextField());
		pnlNorth.add(txtMess = new JTextField());
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

		//Pháº§n Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("ThĂªm")); 
		pnlCenter.add(btnXoaRong = new JButton("XĂ³a rá»—ng"));
		pnlCenter.add(btnXoa = new JButton("XĂ³a"));
		pnlCenter.add(btnSua = new JButton("Sá»­a"));
		pnlCenter.add(btnLuu = new JButton("LÆ°u"));
		pnlCenter.add(new JLabel("TĂ¬m theo mĂ£ sĂ¡ch: "));
		pnlCenter.add(cboMaSach = new JComboBox<String>());
		cboMaSach.setPreferredSize(new Dimension(100, 25));
		pnlCenter.add(btnLoc = new JButton("Lá»�c theo tá»±a sĂ¡ch"));

		//Pháº§n South
		JScrollPane scroll;
		String [] headers = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");
	  	
	  	//tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sĂ¡ch cĂ¡c cuá»‘n sĂ¡ch"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));

		//Xá»­ lĂ½

		thuvien = new ThuVien();
		thuvien.napDuLieuTuFile();
		
		updateTableData();  //Cáº­p nháº­t dá»¯ liá»‡u cho table
		updateComboboxData(); //Cáº­p nháº­t dá»¯ liá»‡u cho Combobox

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow(); //Láº¥y dĂ²ng Ä‘Æ°á»£c chá»�n
				fillForm(row); //Hiá»ƒn thá»‹ trĂªn cĂ¡c components
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
		int n = thuvien.count(); //Tá»•ng sá»‘ cĂ¡c cuá»‘n sĂ¡ch
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
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Cháº¯c cháº¯n xĂ³a khĂ´ng? ", "ChĂº Ă½", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION){
					if(thuvien.xoa1CuonSach(row)){
						txtMess.setText("Ä�Ă£ xĂ³a 1 cuá»‘n sĂ¡ch.");
						updateTableData();
						updateComboboxData();
						clearTextfields();
					}
				}
			}else
				txtMess.setText("Báº¡n pháº£i chá»�n cuá»‘n sĂ¡ch cáº§n xĂ³a. ");
			
			
//			-------------------------------------------------------------------------------
		}else if(o.equals(btnThem)){
			if(validData()){
				Sach s = revertSachFromTextfields();
				if(thuvien.themSach(s)){
					txtMess.setText("THĂªm thĂ nh cĂ´ng 1 cuá»‘n sĂ¡ch.");
					updateTableData(); //Cáº­p nháº­t dá»¯ liá»‡u xuá»‘ng báº£ng
					updateComboboxData();//Cáº­p nháº­t dá»¯ liá»‡u vĂ o combobox
				}else{
					showMessage("Error: TrĂ¹ng mĂ£ sĂ¡ch", txtMaSach);
				}
			}
//			--------------------------------------------------------------------------
		}else if(o.equals(btnXoaRong)){
			clearTextfields();
		}else if(o.equals(btnSua)){
			String maSachOld = txtMaSach.getText().trim();
			if(validData()){ //Cáº§n pháº£i kiá»ƒm tra tĂ­nh há»£p lá»‡ khi sá»­a thĂ´ng tin cuá»‘n sĂ¡ch
				Sach sachNew = revertSachFromTextfields();
				if(thuvien.capNhatSach(maSachOld, sachNew)){
					txtMess.setText("Cáº­p nháº­t thĂ nh cĂ´ng. ");
					updateTableData();//Cáº­p nháº­t dá»¯ liá»‡u láº¡i cho table
					int index = thuvien.getDsSach().indexOf(sachNew);
					table.setRowSelectionInterval(index, index);
				}else
					txtMess.setText("Cáº§n chá»�n cuá»‘n sĂ¡ch Ä‘á»ƒ cáº­p nháº­t. ");
			}
		}else if(o.equals(btnLuu)){
			//Database.ghiXuongFile(thuvien.getDsSach());;;
			txtMess.setText("LÆ°u thĂ nh cĂ´ng. ");
		}else if(o.equals(btnLoc)){
			String regex = JOptionPane.showInputDialog("Nháº­p tá»±a sĂ¡ch cáº§n lá»�c: ");
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
		
		// CĂ³ kĂ½ tá»± Ä‘áº§u lĂ  kĂ½ tá»± Ä‘áº§u cá»§a tá»±a sĂ¡ch, theo sau lĂ  3 kĂ½ sá»‘
		if (!(maSach.length() > 0 && maSach.matches("[A-Z]\\d{3}"))) {
			showMessage("Error: MĂ£ sĂ¡ch theo máº«u: [A-Z]\\d{3}", txtMaSach);
			return false;
		}
		// Tá»±a sĂ¡ch, vĂ  tĂ¡c giáº£ khĂ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng,
		// cĂ³ thá»ƒ gá»“m nhiá»�u tá»« ngÄƒn cĂ¡ch bá»Ÿi khoáº£ng tráº¯ng.
		// KhĂ´ng chá»©a kĂ½ sá»‘ hoáº·c cĂ¡c kĂ½ tá»± Ä‘áº·c biá»‡t khĂ¡c, ngoáº¡i trá»« kĂ½ tá»± â€˜
		if (!(tuaSach.length() > 0 && tuaSach.matches("[a-zA-Z' ]+"))) {
			showMessage("Error: Tá»±a sĂ¡ch theo máº«u: [a-zA-Z' ]+", txtTuaSach);
			return false;
		}
		if (!(tacGia.length() > 0 && tacGia.matches("[a-zA-Z' ]+"))) {
			showMessage("Error: TĂ¡c giáº£ theo máº«u: [a-zA-Z' ]+", txtTacGia);
			return false;
		}
		if (nam.length() > 0) {
			try {
				int x = Integer.parseInt(nam);
				int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
				if (!(x >= 1900 && x < namHienTai)) {
					showMessage("Error: NÄƒm xuáº¥t báº£n >= 1900 && <= " 
							+ namHienTai, txtNamXB);
					return false;
				}
			} catch (NumberFormatException ex) {
				showMessage("Error: NÄƒm xuáº¥t báº£n pháº£i nháº­p sá»‘.", txtNamXB);
				return false;
			}
		}

		if (soTrang.length() > 0) {
			try {
				int x = Integer.parseInt(soTrang);
				if (x <= 0) {
					showMessage("Error: Sá»‘ trang pháº£i nháº­p sá»‘ nguyĂªn dÆ°Æ¡ng.", txtSoTrang);
					return false;
				}
			} catch (NumberFormatException ex) {
				showMessage("Error: Sá»‘ trang pháº£i nháº­p sá»‘ nguyĂªn dÆ°Æ¡ng.", txtSoTrang);
				return false;
			}
		}

		if (gia.length() > 0) {
			try {
				double y = Double.parseDouble(gia);
				if (y < 0) {
					showMessage("Error: Ä�Æ¡n giĂ¡ pháº£i > 0.", txtDonGia);
					return false;
				}
			} catch (NumberFormatException ex) {
				showMessage("Error: Ä�Æ¡n giĂ¡ pháº£i nháº­p sá»‘.", txtDonGia);
				return false;
			}
		}
		// ISBN cĂ³ máº«u dáº¡ng X-X-X-X (hoáº·c X-X-X-X-X).
		// Trong Ä‘Ă³, X gá»“m cĂ¡c kĂ½ sá»‘, Ă­t nháº¥t lĂ  1 kĂ½ sá»‘
		if (isbn.length() > 0)
			if (!isbn.matches("\\d+(-\\d+){3,4}")) {
				showMessage("Error: ISBN cĂ³ máº«u dáº¡ng  X-X-X-X  (hoáº·c X-X-X-X-X).", txtISBN);
				return false;
			}
	

		return true;
	}

	private Sach revertSachFromTextfields() {
		String maSach = txtMaSach.getText().trim();
		String tuaSach = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();

		String nam = txtNamXB.getText().trim();
		int namXB = nam.length() == 0 ? 0 : Integer.parseInt(nam); //Ä�á»ƒ trá»‘ng thĂ¬ coi nhÆ° lĂ  0

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
