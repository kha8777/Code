package layout_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ThongTinNhanVien extends JFrame{
	
	private DefaultTableModel model;
	private JTable table;
	
	public ThongTinNhanVien() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Thông Tin Nhân Viên");
		createGUI();
	}
	
	private void createGUI() {
			JPanel pnBorder = new JPanel();
			pnBorder.setLayout(new BorderLayout());
			
			/* Tiêu đề */
			JPanel pnNorth = new JPanel();
			JLabel lblNorth = new JLabel("THÔNG TIN NHÂN VIÊN");
			lblNorth.setForeground(Color.BLUE);
			Font ft = new Font("Arial", Font.BOLD, 20);
			lblNorth.setFont(ft);
			pnNorth.add(lblNorth);
			
			pnBorder.add(pnNorth, BorderLayout.NORTH);
			
			JPanel pnCenter = new JPanel(); // Panel center chứa 2 panel form và table
			JPanel pnForm = new JPanel(); // Panel form này nằm ở trên
			pnForm.setLayout(new BoxLayout(pnForm, BoxLayout.Y_AXIS));
			
			// Các textfields
			JPanel pnTf1 = new JPanel();
			JLabel lblMnv = new JLabel("Mã nhân viên: ");
			JTextField txtMnv = new JTextField(34);
			pnTf1.add(lblMnv);
			pnTf1.add(txtMnv);
			pnForm.add(pnTf1); // Textfield 1
			
			JPanel pnTf2 = new JPanel();
			JLabel lblHo = new JLabel("Họ: ");
			JTextField txtHo = new JTextField(15);
			JLabel lblTen = new JLabel("Tên nhân viên: ");
			JTextField txtTen = new JTextField(15);
			pnTf2.add(lblHo);
			pnTf2.add(txtHo);
			pnTf2.add(lblTen);
			pnTf2.add(txtTen);
			pnForm.add(pnTf2); // Textfield 2
			
			JPanel pnTf3 = new JPanel();
			JLabel lblTuoi = new JLabel("Tuổi: ");
			JTextField txtTuoi = new JTextField(23);
			JLabel lblPhai = new JLabel("Phái: ");
			ButtonGroup btnGPhai = new ButtonGroup();
			JRadioButtonMenuItem rdbNam = new JRadioButtonMenuItem("Nam");
			JRadioButtonMenuItem rdNu = new JRadioButtonMenuItem("Nữ");
			btnGPhai.add(rdbNam);
			btnGPhai.add(rdNu);
			pnTf3.add(lblTuoi);
			pnTf3.add(txtTuoi);
			pnTf3.add(lblPhai);
			pnTf3.add(rdbNam);
			pnTf3.add(rdNu);
			pnForm.add(pnTf3); // Textfield 3
			
			JPanel pnTf4 = new JPanel();
			JLabel lblLuong = new JLabel("Lương: ");
			JTextField txtLuong = new JTextField(37);
			pnTf4.add(lblLuong);
			pnTf4.add(txtLuong);
			pnForm.add(pnTf4); // Textfield 4
			
			// Table layout
			JPanel pnTable = new JPanel(); // Panel table này nằm ở dưới
			pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.Y_AXIS));
			model = new DefaultTableModel();
			table = new JTable(model);
			model.addColumn("Mã nhân viên");
			model.addColumn("Họ");
			model.addColumn("Tên");
			model.addColumn("Phái");
			model.addColumn("Tuổi");
			model.addColumn("Tiền Lương");
			TableColumn phaiColumn = table.getColumnModel().getColumn(3);
			JComboBox comboBox = new JComboBox();
			comboBox.addItem("Nam");
			comboBox.addItem("Nữ");
			phaiColumn.setCellEditor(new DefaultCellEditor(comboBox));
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
			JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sp.setPreferredSize(new Dimension(450, 200));
			pnTable.add(sp);
			
			pnTable.add(table);
			pnCenter.add(pnForm);
			pnCenter.add(pnTable);
			pnBorder.add(pnCenter, BorderLayout.CENTER);
		    JSplitPane splist;
		    pnBorder.add(splist = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT),BorderLayout.SOUTH);
		    splist.setResizeWeight(0.5);
		    
		    JPanel pnTimKiem = new JPanel();
		    JLabel lbTimKiem = new JLabel("Nhập mã số cần tìm");
		    JTextField txtTimKiem = new JTextField(10);
		    JButton btnTim = new JButton("Tìm");
		    pnTimKiem.add(lbTimKiem);
		    pnTimKiem.add(txtTimKiem);
		    pnTimKiem.add(btnTim);
		    splist.add(pnTimKiem);
		    
		    JPanel pnChucNang = new JPanel();
		    JButton btnThem = new JButton("Thêm");
		    JButton btnXoa = new JButton("Xóa");
		    JButton btnSua = new JButton("Sửa");
		    JButton btnXoaTrang = new JButton("Xóa Trắng");
		    JButton btnLuu = new JButton("Lưu");
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
			
			add(pnBorder);
	}
	
	public static void main(String[] args) {
		new ThongTinNhanVien().setVisible(true);
	}
}
