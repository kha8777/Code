package tuan4_phongBan;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableNhanVienGUI extends JFrame {
	
	private ArrayList<NhanVien> dsnv;
	private JTable table;
	private DefaultTableModel tableModel;

	public TableNhanVienGUI(ArrayList<NhanVien> dsnv, String title){
		setTitle(title);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.dsnv = dsnv;
		String column[] = {"Mã", "Họ", "Tên", "Phòng ban", "Tuổi", "Tiền lương"};
		table = new JTable(tableModel = new DefaultTableModel(column, 0));
		
		for (int i = 0; i < dsnv.size(); i++) {
			NhanVien nv = dsnv.get(i);
			String[] row = {nv.getMa(), nv.getHo(), nv.getTen(), nv.getPhongBan().toString(), nv.getTuoi() + "", nv.getTienLuong() + ""};
			tableModel.addRow(row);
			
		}
		
		table.setRowHeight(20);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
	}

}
