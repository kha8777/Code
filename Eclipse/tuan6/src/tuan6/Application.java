package tuan6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Application extends JFrame implements ActionListener {
	
	private JPanel pnBorder;
	private JPanel pnCenter;
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
	
	private DanhSachNhanVien ds = new DanhSachNhanVien();
	private Database db = new Database();
	
	public Application() {
		setTitle("Quản lý nhân sự");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initUI();
	}
	
	public void initUI() {
		// border cha
		pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter,BoxLayout.Y_AXIS));
		
		// tạo các panel input chứa labels và textfields
		Box box = Box.createVerticalBox(); 
	    Box boxMa = Box.createHorizontalBox();
	    Box boxHo = Box.createHorizontalBox();
	    Box boxTen = Box.createHorizontalBox();
	    Box boxPBan = Box.createHorizontalBox();
	    Box boxLuong = Box.createHorizontalBox();
	    box.add(boxMa);
	    box.add(Box.createVerticalStrut(5));
	    box.add(boxHo);
	    box.add(Box.createVerticalStrut(5));
	    box.add(boxTen);
	    box.add(Box.createVerticalStrut(5));
	    box.add(boxPBan);
	    box.add(Box.createVerticalStrut(5));
	    box.add(boxLuong);
	    box.add(Box.createVerticalStrut(5));
	    
		// tạo lables và textfields
		JLabel lbMa = new JLabel("Mã nhân viên: ");
		tfMa = new JTextField();
		JLabel lbHo = new JLabel("Họ: ");
		tfHo = new JTextField();
		JLabel lbTen = new JLabel("Tên nhân viên: ");
		tfTen = new JTextField();
		JLabel lbPBan = new JLabel("Phòng ban: ");
		cbPBan = new JComboBox<String>();
		cbPBan.addItem("Phòng tổ chức");
		cbPBan.addItem("Phòng kỹ thuật");
		cbPBan.addItem("Phòng nhân sự");
		cbPBan.addItem("Phòng tài vụ");
		JLabel lbLuong = new JLabel("Tiền lương: ");
		tfLuong = new JTextField();
		
		//set label size
		lbMa.setPreferredSize(lbTen.getPreferredSize());
		lbHo.setPreferredSize(lbTen.getPreferredSize());
		lbPBan.setPreferredSize(lbTen.getPreferredSize());
		lbLuong.setPreferredSize(lbTen.getPreferredSize());
		
		// add lables và textfields vào input panels
		boxMa.add(lbMa);
		boxMa.add(tfMa);
		boxHo.add(lbHo);
		boxHo.add(tfHo);
		boxTen.add(lbTen);
		boxTen.add(tfTen);
		boxPBan.add(lbPBan);
		boxPBan.add(cbPBan);
		boxLuong.add(lbLuong);
		boxLuong.add(tfLuong);
		pnCenter.add(box);
		
		// chức năng
		JPanel pnChucNang = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xóa");
		btnXoaTrang = new JButton("Xóa trắng");
		btnLuu = new JButton("Lưu");
		pnChucNang.add(btnThem);
		pnChucNang.add(btnXoa);
		pnChucNang.add(btnXoaTrang);
		pnChucNang.add(btnLuu);
		pnCenter.add(pnChucNang);

		taoBang();
		
		// thêm vào border cha
		pnBorder.add(pnCenter, BorderLayout.CENTER);
//		ds.themNV(new NhanVien("D001", "Tran", "Kha", "Phòng tổ chức", "50000000"));
		updateTable();
		this.add(pnBorder);
		
		
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
	}
	
	public void taoBang() {
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã nhân viên");
		model.addColumn("Họ");
		model.addColumn("Tên nhân viên");
		model.addColumn("Phòng ban");
		model.addColumn("Tiền lương");
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(650, 450));
		pnCenter.add(sp);
	}
	
	public static void main(String[] args) {
		new Application().setVisible(true);
	}
	
	public void updateTable() {
		ds = null;
		try {
			ds = db.readNV("D:\\NhanVienTuan6.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		xoaDataTable();
		
		for (NhanVien nv : ds.getDs()) {
			model.addRow(new Object[] {
					nv.getMaNV(), 
					nv.getHo(), 
					nv.getTen(), 
					nv.getPhongBan(), 
					nv.getLuong()
			});
		}
		
	}
	
	public void xoaDataTable() {
		DefaultTableModel tb = (DefaultTableModel) table.getModel();
		tb.getDataVector().removeAllElements();
		tb.fireTableDataChanged();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnThem) {
			
		}
		
		if (e.getSource() == btnLuu) {
			if (tfHo.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên không được trống");
			}
			else {
				String ma = tfMa.getText();
				String ho = tfHo.getText();
				String ten = tfTen.getText();
				String pban = cbPBan.getSelectedItem().toString();
				String luong = tfMa.getText();
				ds.themNV(new NhanVien(ma, ho, ten, pban, luong));
				try {
					db.writeNV(ds, "D:\\NhanVienTuan6.txt");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				updateTable();
			}
		}
		
		if (e.getSource() == btnXoa) {
			int row = table.getSelectedRow();
			ds.xoaNV(table.getValueAt(row, 0).toString());
			try {
				db.writeNV(ds, "D:\\NhanVienTuan6.txt");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			updateTable();
		}
		
		if (e.getSource() == btnXoaTrang) {
			tfMa.setText("");
			tfHo.setText("");
			tfTen.setText("");
			tfLuong.setText("");
		}
		
	}
}
