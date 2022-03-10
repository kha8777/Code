package nhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
public class ThongTinNhanVien extends JFrame implements ActionListener, MouseListener {
	JLabel lbManv, lbHo, lbTen, lbTuoi, lbPhai, lbTienLuong;
	JTextField txtManv, txtHo, txtTen, txtTuoi, txtTienLuong;
	JRadioButton radNam, radNu;
	DefaultTableModel model ;
	JTable table;
	JPanel pnCenter;
	JButton btnTim, btnThem, btnXoa, btnXoaTrang, btnLuu;

	public ThongTinNhanVien() {
		setTitle("Thong tin nhan vien");
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
	    JSplitPane splist;
	    pnBorder.add(splist = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT),BorderLayout.SOUTH);
	    splist.setResizeWeight(0.5);
	    
	    JPanel pnTimKiem = new JPanel();
	    JLabel lbTimKiem = new JLabel("Nhập mã cần tìm: ");
	    JTextField txtTimKiem = new JTextField(10);
	    btnTim = new JButton("Tìm");
	    pnTimKiem.add(lbTimKiem);
	    pnTimKiem.add(txtTimKiem);
	    pnTimKiem.add(btnTim);
	    splist.add(pnTimKiem);
	    
	    JPanel pnChucNang = new JPanel();
	    btnThem = new JButton("Thêm");
	    btnXoa = new JButton("Xóa");
	    btnXoaTrang = new JButton("Xóa trắng");
	    btnLuu = new JButton("Lưu");
	    pnChucNang.add(btnThem);
	    pnChucNang.add(btnXoa);
	    pnChucNang.add(btnXoaTrang);
	    pnChucNang.add(btnLuu);
	    splist.add(pnChucNang);
	    
	    Border cnBorder = BorderFactory.createLineBorder(Color.GRAY);
	    pnChucNang.setBorder(cnBorder);
	    pnTimKiem.setBorder(cnBorder);
	   
	    this.add(pnBorder);
	    
	    btnTim.addActionListener(this);
	    btnThem.addActionListener(this);
	    btnXoa.addActionListener(this);
	    btnXoaTrang.addActionListener(this);
	    btnLuu.addActionListener(this);
	    
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
		new ThongTinNhanVien().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnThem)) {
			if (btnThem.getText().equals("Thêm")) {
				txtManv.setEnabled(true);
				txtHo.setEnabled(true);
				txtTen.setEnabled(true);
				txtTuoi.setEnabled(true);
				txtTienLuong.setEnabled(true);
				radNam.setSelected(false);
				radNu.setSelected(false);
				txtManv.requestFocus();
				btnXoa.setEnabled(false);
				btnThem.setText("Hủy");
			}
			else {
				btnXoa.setEnabled(true);
				btnThem.setText("Thêm");
			}
		}
		
		if (e.getSource().equals(btnLuu)) {
			if(txtManv.getText().equals("") || txtHo.getText().equals("") || txtTen.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Bạn chưa nhập thông tin nhân viên!");
			}
			else {
				try {
					luu();	
					xoaTrang();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
		}
		
		if (e.getSource().equals(btnXoaTrang)) {
			xoaTrang();
		}
		
		if (e.getSource().equals(btnXoa)) {
			
		}
		
	}

	private void luu() throws Exception {
		String gt = "";
		String ma = txtManv.getText();
		String ho = txtHo.getText();
		String ten = txtTen.getText();
		if(radNam.isSelected())
			gt = radNam.getText();
		if(radNu.isSelected())
			gt = radNu.getText();
		String tuoi = txtTuoi.getText();
		String luong = txtTienLuong.getText();
		String[] row = {ma, ho, ten, gt, tuoi, luong};
		model.addRow(row);
		
	}
	
	private void xoaTrang() {
		txtManv.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtTienLuong.setText("");
		radNam.setSelected(false);
		radNu.setSelected(false);
		txtManv.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
