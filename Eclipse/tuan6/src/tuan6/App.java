package tuan6;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class App extends JFrame {
	private JTextField tfMa;
	private JTextField tfHo;
	private JTextField tfTen;
	private JTextField tfLuong;
	private JComboBox<String> cbPBan;
	
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnLuu;
	
	private DefaultTableModel model;
	private JTable table;
	
	public App() {
		setTitle("");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		UI();
	}
	
	public void UI() {
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		b.add(b5);
		b.add(Box.createVerticalStrut(5));
		pnCenter.add(b);
		
		JLabel lbMa = new JLabel("Ma nhan vien");
		JLabel lbHo = new JLabel("Ho");
		JLabel lbTen = new JLabel("Ten nhan vien");
		JLabel lbPBan = new JLabel("Phong ban");
		JLabel lbLuong = new JLabel("Tien luong");
		
		tfMa = new JTextField();
		tfHo = new JTextField();
		tfTen = new JTextField();
		cbPBan = new JComboBox<String>();
		cbPBan.addItem("1. Phong to chuc");
		cbPBan.addItem("2. Phong ky thuat");
		cbPBan.addItem("3. Phong nhan su");
		cbPBan.addItem("4. Phong tai vu");
		tfLuong = new JTextField();
		
		b1.add(lbMa);
		b1.add(tfMa);
		b2.add(lbHo);
		b2.add(tfHo);
		b3.add(lbTen);
		b3.add(tfTen);
		b4.add(lbPBan);
		b4.add(cbPBan);
		b5.add(lbLuong);
		b5.add(tfLuong);
		
		lbMa.setPreferredSize(lbTen.getPreferredSize());
		lbHo.setPreferredSize(lbTen.getPreferredSize());
		lbPBan.setPreferredSize(lbTen.getPreferredSize());
		lbLuong.setPreferredSize(lbTen.getPreferredSize());
		
		JPanel pnChucNang = new JPanel();
		btnThem = new JButton("Them");
		btnXoa = new JButton("Xoa");
		btnXoaTrang = new JButton("Xoa trang");
		btnLuu = new JButton("Luu");
		pnChucNang.add(btnThem);
		pnChucNang.add(btnXoa);
		pnChucNang.add(btnXoaTrang);
		pnChucNang.add(btnLuu);
		pnCenter.add(pnChucNang);
		
		pnBorder.add(pnCenter);
		this.add(pnBorder);
		taoBang(pnCenter);
	}
	
	public void taoBang(JPanel pnCenter) {
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Ma nhan vien");
		model.addColumn("Ho");
		model.addColumn("Ten nhan vien");
		model.addColumn("Phong ban");
		model.addColumn("Tien luong");
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnCenter.add(sp);
	}
	
	public static void main(String[] args) {
		new App().setVisible(true);
	}
	
}
