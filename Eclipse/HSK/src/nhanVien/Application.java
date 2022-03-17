package nhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


@SuppressWarnings("serial")
public class Application extends JFrame implements ActionListener, MouseListener, KeyListener {
	private JLabel lbManv, lbHo, lbTen, lbTuoi, lbPhai, lbTienLuong, lbTimKiem;
	private JTextField txtManv, txtHo, txtTen, txtTuoi, txtTienLuong, txtTimKiem;
	private JRadioButton radNam, radNu;
	private DefaultTableModel model ;
	private JTable table;
	private JPanel pnCenter;
	private JButton btnTim, btnThem, btnXoa, btnSua, btnXoaTrang, btnLuu;
	private int flag = 0, flagTim = 0;
	private DanhSachNhanVien ls = new DanhSachNhanVien();
	private Database db = new Database();

	public Application() {
		setTitle("Thông tin nhân viên");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
		initUI();
	}

	private void initUI() {
	    JPanel pnBorder = new JPanel();
	    pnBorder.setLayout(new BorderLayout());
	    JPanel pnNorth = new JPanel();
	    JLabel lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
	    Font fTitle = new Font("Arial",Font.BOLD, 40);
		lblTitle.setFont(fTitle);
		lblTitle.setForeground(Color.BLUE);
	    pnNorth.add(lblTitle);
	    pnBorder.add(pnNorth,BorderLayout.NORTH);
	    
	    pnCenter = new JPanel();
	    pnCenter.setLayout(new BoxLayout(pnCenter,BoxLayout.Y_AXIS));
	    Box b = Box.createVerticalBox();
	    Box b1 = Box.createHorizontalBox();
	    Box b2 = Box.createHorizontalBox();
	    Box b3 = Box.createHorizontalBox();
	    Box b4 = Box.createHorizontalBox();
	    b.add(b1);
	    b.add(Box.createVerticalStrut(5));
	    b.add(b2);
	    b.add(Box.createVerticalStrut(5));
	    b.add(b3);
	    b.add(Box.createVerticalStrut(5));
	    b.add(b4);
	    b.add(Box.createVerticalStrut(5));
	    pnCenter.add(b);
	    pnCenter.add(Box.createVerticalStrut(10));
	    
	    lbManv = new JLabel("Mã nhân viên: ");
	    lbHo = new JLabel("Họ: ");
	    lbTen = new JLabel("Tên nhân viên: ");
	    lbTuoi = new JLabel("Tuổi: ");
	    lbPhai = new JLabel("Phái: ");
	    lbTienLuong = new JLabel("Tiền lương: ");
	    
	    txtManv = new JTextField();
	    b1.add(lbManv);
	    b1.add(txtManv);
	    
	    txtHo = new JTextField();
	    txtTen = new JTextField();
	    b2.add(lbHo);
	    b2.add(txtHo);
	    b2.add(lbTen);
	    b2.add(txtTen);
	    lbHo.setPreferredSize(lbManv.getPreferredSize());
	    
	    txtTuoi = new JTextField();
	    radNam = new JRadioButton("Nam", true);
	    radNu = new JRadioButton("Nữ");
	    ButtonGroup group = new ButtonGroup();
	    group.add(radNam);
	    group.add(radNu);
	    b3.add(lbTuoi);
	    b3.add(txtTuoi);
	    b3.add(lbPhai);
	    b3.add(radNam);
	    b3.add(radNu);
	    
	    txtTienLuong = new JTextField();
	    b4.add(lbTienLuong);
	    b4.add(txtTienLuong);
	  
	    lbTuoi.setPreferredSize(lbManv.getPreferredSize());
	    lbPhai.setPreferredSize(lbManv.getPreferredSize());
	    lbTienLuong.setPreferredSize(lbManv.getPreferredSize());
	    
	    taoBang();
	    
	    pnBorder.add(pnCenter,BorderLayout.CENTER);
	    
	    updateTable();
	    
	    JSplitPane splist;
	    pnBorder.add(splist = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT),BorderLayout.SOUTH);
	    splist.setResizeWeight(0.5);
	    
	    JPanel pnTimKiem = new JPanel();
	    lbTimKiem = new JLabel("Nhập mã hoặc tên: ");
	    txtTimKiem = new JTextField(10);
	    btnTim = new JButton("Tìm");
	    pnTimKiem.add(lbTimKiem);
	    pnTimKiem.add(txtTimKiem);
	    pnTimKiem.add(btnTim);
	    splist.add(pnTimKiem);
	    
	    JPanel pnChucNang = new JPanel();
	    btnThem = new JButton("Thêm");
	    btnXoa = new JButton("Xóa");
	    btnSua = new JButton("Sửa");
	    btnXoaTrang = new JButton("Xóa trắng");
	    btnLuu = new JButton("Lưu");
	    pnChucNang.add(btnThem);
	    pnChucNang.add(btnXoa);
	    pnChucNang.add(btnSua);
	    pnChucNang.add(btnXoaTrang);
	    pnChucNang.add(btnLuu);
	    splist.add(pnChucNang);
	    
	    Border cnBorder = BorderFactory.createLineBorder(Color.GRAY);
	    pnChucNang.setBorder(cnBorder);
	    pnTimKiem.setBorder(cnBorder);
	   
	    this.add(pnBorder);
	    
	    btnXoa.setEnabled(false);
	    btnSua.setEnabled(false);
	    btnXoaTrang.setEnabled(false);
	    btnLuu.setEnabled(false);
	    txtManv.setEditable(false);
	    txtHo.setEditable(false);
	    txtTen.setEditable(false);
	    txtTuoi.setEditable(false);
	    txtTienLuong.setEditable(false);
	    radNam.setEnabled(false);
	    radNu.setEnabled(false);
	    
	    
	    btnThem.addActionListener(this);
	    btnXoa.addActionListener(this);
	    btnSua.addActionListener(this);
	    btnXoaTrang.addActionListener(this);
	    btnLuu.addActionListener(this);
	    btnTim.addActionListener(this);
	    txtManv.addMouseListener(this);
	    txtHo.addMouseListener(this);
	    txtTen.addMouseListener(this);
	    txtTuoi.addMouseListener(this);
	    txtTienLuong.addMouseListener(this);
	    txtTimKiem.addMouseListener(this);
	    txtManv.addKeyListener(this);
	    txtHo.addKeyListener(this);
	    txtTen.addKeyListener(this);
	    txtTuoi.addKeyListener(this);
	    txtTienLuong.addKeyListener(this);
	    txtTimKiem.addKeyListener(this);
	    
	    table.addMouseListener(this);
	}
	
	private void taoBang() {
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã NV");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Phái");
		model.addColumn("Tuổi");
		model.addColumn("Tiền lương");
		TableColumn phaicolumn = table.getColumnModel().getColumn(3);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		phaicolumn.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderner = new DefaultTableCellRenderer();
		rightRenderner.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderner);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderner);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderner);
		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(650, 450));
		pnCenter.add(sp);
		
	}

	public static void main(String[] args) {
		new Application().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Khi nhấn nút thêm
		if (e.getSource().equals(btnThem)) {
			if (btnThem.getText().equalsIgnoreCase("Thêm")) {
				txtManv.setEditable(true);
				txtHo.setEditable(true);
				txtTen.setEditable(true);
				txtTuoi.setEditable(true);
				txtTienLuong.setEditable(true);
				txtManv.requestFocus();
				btnThem.setText("Hủy");
				btnLuu.setEnabled(true);
				btnXoaTrang.setEnabled(true);
				btnSua.setText("Sửa");
//				btnSua.setEnabled(false);
				radNam.setEnabled(true);
			    radNu.setEnabled(true);
				flag = 0;
			}
			else {
				txtManv.setEditable(false);
			    txtHo.setEditable(false);
			    txtTen.setEditable(false);
			    txtTuoi.setEditable(false);
			    radNam.setEnabled(false);
			    radNu.setEnabled(false);
			    txtTienLuong.setEditable(false);
				btnThem.setText("Thêm");
				btnLuu.setEnabled(false);
				btnXoaTrang.setEnabled(false);
			}
		}
		
		// Khi nhấn nút lưu
		if (e.getSource().equals(btnLuu)) {
			if (flag == 1) { // Sửa
				suaNV();
			}
			else { // Thêm
				themNV();
			}
			
			
		}
		
		// Khi nhấn nút xóa trắng
		if (e.getSource().equals(btnXoaTrang)) {
			if (flag == 1) {
				txtHo.setText("");
				txtTen.setText("");
				txtTuoi.setText("");
				txtTienLuong.setText("");
				
			}
			else {
				xoaTrang();
				
			}
		}
		
		
		// Khi nhấn nút xóa
		if (e.getSource().equals(btnXoa)) {
			if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xóa nhân viên này?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					int row = table.getSelectedRow();
					ls.remove(table.getValueAt(row, 0).toString());
					db.writeNV("D:\\NhanVien.txt", ls);
					if (flagTim == 1) {
						clickFindButton();
					}
					else {
						updateTable();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
				btnXoa.setEnabled(false);
				btnSua.setEnabled(false);
			}
				
		}
		
		
		// Khi nhấn nút sửa
		if (e.getSource().equals(btnSua)) {
			if (btnSua.getText().equalsIgnoreCase("Sửa")) {
				txtManv.setEditable(false);
				txtHo.setEditable(true);
				txtTen.setEditable(true);
				txtTuoi.setEditable(true);
				txtTienLuong.setEditable(true);
				btnSua.setText("Hủy");
				btnLuu.setEnabled(true);
				radNam.setEnabled(true);
			    radNu.setEnabled(true);
				btnXoa.setEnabled(false);
				btnXoaTrang.setEnabled(true);
				btnThem.setText("Thêm");
				forcus(txtHo);
				flag = 1;
			}
			
			else {
				txtManv.setEditable(false);
				txtHo.setEditable(false);
				txtTen.setEditable(false);
				txtTuoi.setEditable(false);
				txtTienLuong.setEditable(false);
				btnSua.setText("Sửa");
				btnXoaTrang.setEnabled(false);
				btnLuu.setEnabled(false);
				btnXoa.setEnabled(true);
				radNam.setEnabled(false);
			    radNu.setEnabled(false);
				flag = 0;
			}
			
		}
		
		
		// Khi nhấn nút tìm
		if (e.getSource().equals(btnTim)) {
			if (btnTim.getText().equalsIgnoreCase("Tìm")) {
				clickFindButton();
			}
			
			else {
				txtManv.setEditable(false);
				txtHo.setEditable(false);
				txtTen.setEditable(false);
				txtTuoi.setEditable(false);
				radNam.setEnabled(false);
				radNu.setEnabled(false);
				txtTienLuong.setEditable(false);
				btnXoa.setEnabled(false);
				btnThem.setText("Thêm");
				btnSua.setText("Sửa");
				btnSua.setEnabled(false);
				btnXoaTrang.setEnabled(false);
				btnLuu.setEnabled(false);
				updateTable();
				btnTim.setText("Tìm");
				flagTim = 0;
			}
		}
		
	}
	
	// Functions

	private void luu() throws Exception {
		String gt = "Nam";
		String ma = txtManv.getText();
		String ho = txtHo.getText();
		String ten = txtTen.getText();
		if(radNu.isSelected())
			gt = "Nữ";
		String tuoi = txtTuoi.getText();
		String luong = txtTienLuong.getText();
		ls.add(new NhanVien(ma, ho, ten, gt, tuoi, luong));
		db.writeNV("D:\\NhanVien.txt", ls);
	}
	
	private boolean StringToIntParsable(String str) {
		if (str.equals("")) return true;
		try {
			Integer.parseInt(str);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	private boolean StringToDoubleParsable(String str) {
		if (str.equals("")) return true;
		try {
			Double.parseDouble(str);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	private void xoaTrang() {
		txtManv.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtTienLuong.setText("");
		txtManv.requestFocus();
	}
	
	private void updateTable() {
		try {
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		xoaTrangTable();
		for (int i = 0; i < ls.getSize(); i++) {
			NhanVien nv = ls.getElement(i);
			model.addRow(new Object[] {
					nv.getMaNV(),
					nv.getHo(), 
					nv.getTen(), 
					nv.getPhai(),
					nv.getTuoi(), 
					nv.getTienLuong()
			});

		}
	}
	
	private void loadData() throws Exception {
		ls = null;
		// cách 1
		ls = db.readNV("D:\\NhanVien.txt");
		// cách 2
//		ls = (DanhSachNhanVien) db.readFile("NhanVien.dat");
	}
	
	private void xoaTrangTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
		dtm.fireTableDataChanged();
	}
	
	private void numberFormatForcusTuoi() {
		JOptionPane.showMessageDialog(null, "Tuổi phải là kiểu số!");
		paintAll(txtTuoi);
		forcus(txtTuoi);
	}
	
	private void numberFormatForcusLuong() {
		JOptionPane.showMessageDialog(null, "Lương phải là kiểu số!");
		paintAll(txtTienLuong);
		forcus(txtTienLuong);
	}
	
	private void forcus(JTextField x) {
		x.requestFocus();
	}
	
	private void paintAll(JTextField x) {
		x.selectAll();
	}
	
	private void clickFindButton() {
		String tim = txtTimKiem.getText();
		ArrayList<NhanVien> foundList = ls.find(tim);
		xoaTrangTable();
		for (NhanVien nv : foundList) {
			model.addRow(new Object[] {
					nv.getMaNV(), 
					nv.getHo(), 
					nv.getTen(), 
					nv.getPhai(), 
					nv.getTuoi(), 
					nv.getTienLuong()
			});
		}
		
		txtManv.setEditable(false);
		txtHo.setEditable(false);
		txtTen.setEditable(false);
		txtTuoi.setEditable(false);
		radNam.setEnabled(false);
		radNu.setEnabled(false);
		txtTienLuong.setEditable(false);
		btnXoa.setEnabled(false);
		btnThem.setText("Thêm");
		btnSua.setText("Sửa");
		btnSua.setEnabled(false);
		btnXoaTrang.setEnabled(false);
		btnLuu.setEnabled(false);
		btnTim.setText("Hủy");
		flagTim = 1;
	}
	
	private void suaNV() {
		int row = table.getSelectedRow();
		String gt = "Nam";
		if (radNu.isSelected()) {
			gt = "Nữ";
		}
		
		if (txtHo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Họ nhân viên không được trống!");
			forcus(txtHo);
		}
		else if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên nhân viên không được trống!");
			forcus(txtTen);
		}
		else {
			if (!StringToIntParsable(txtTuoi.getText())) {
				numberFormatForcusTuoi();
			}
			else if (!StringToDoubleParsable(txtTienLuong.getText())) {
				numberFormatForcusLuong();
			}
			else {
				try {
					String maNV = table.getValueAt(row, 0).toString();
					ls.modify(maNV, txtHo.getText(), txtTen.getText(), gt, txtTuoi.getText(), txtTienLuong.getText());
					db.writeNV("D:\\NhanVien.txt", ls);
					if (flagTim == 1) {
						clickFindButton();
					}
					else {
						updateTable();
					}
					table.setRowSelectionInterval(row, row);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.toString());
				}
				
			}
			
		}
		
	}

	private void themNV() {
		if (ls.check(txtManv.getText())) {
			JOptionPane.showMessageDialog(null, "Mã nhân viên này đã tồn tại!");
			paintAll(txtManv);
			forcus(txtManv);
			return;
		}
		if(txtManv.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã nhân viên không được trống!");
			forcus(txtManv);
		}
		else if (txtHo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Họ nhân viên không được trống!");
			forcus(txtHo);
		}
		else if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên nhân viên không được trống!");
			forcus(txtTen);
		}
		else {
			if (!StringToIntParsable(txtTuoi.getText())) {
				numberFormatForcusTuoi();
			}
			else if (!StringToDoubleParsable(txtTienLuong.getText())) {
				numberFormatForcusLuong();
			}
			else {
				try {
					luu();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				updateTable();
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(table)) {
			btnXoa.setEnabled(true);
			btnSua.setEnabled(true);
			btnXoaTrang.setEnabled(false);
			btnLuu.setEnabled(false);
			btnThem.setText("Thêm");
			btnSua.setText("Sửa");
			int row = table.getSelectedRow();
			txtManv.setText(model.getValueAt(row, 0).toString());
			txtHo.setText(model.getValueAt(row, 1).toString());
			txtTen.setText(model.getValueAt(row, 2).toString());
			txtTuoi.setText(model.getValueAt(row, 4).toString());
			txtTienLuong.setText(model.getValueAt(row, 5).toString());
			if (model.getValueAt(row, 3).toString().equalsIgnoreCase("Nam")) {
				radNam.setSelected(true);
				radNu.setSelected(false);
			}
			else {
				radNam.setSelected(false);
				radNu.setSelected(true);
			}
			txtManv.setEditable(false);
			txtHo.setEditable(false);
			txtTen.setEditable(false);
			txtTuoi.setEditable(false);
			txtTienLuong.setEditable(false);

			
		}
		
		if (e.getSource().equals(txtTimKiem)) {
			btnTim.setText("Tìm");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource().equals(txtTimKiem)) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				clickFindButton();
			}
		}
		
		if (e.getSource().equals(txtManv) || e.getSource().equals(txtHo) || e.getSource().equals(txtTen) || e.getSource().equals(txtTuoi) || e.getSource().equals(txtTienLuong) || e.getSource().equals(radNam) || e.getSource().equals(radNu)) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (flag == 1) { // Sửa
					suaNV();
				}
				else { // Thêm
					themNV();
					
				}
				
			}
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
