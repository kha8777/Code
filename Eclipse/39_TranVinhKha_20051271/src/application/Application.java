package application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.SinhVien;
import manage.DanhSachSinhVien;

@SuppressWarnings("serial")
public class Application extends JFrame implements ActionListener {
	private JPanel pnBorder;
	private JPanel pnCenter;
	private JPanel pnSouth;
	private JTable table;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnSave;
	private JButton btnFilter;
	private DefaultTableModel model;
	private DanhSachSinhVien ls = new DanhSachSinhVien();
	
	public Application() {
		setTitle("Thông tin sinh viên");
		setSize(800, 500);
		UI();
	}
	
	public void UI() {
		pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		
		pnSouth = new JPanel();
		btnAdd = new JButton("Thêm");
		btnDelete = new JButton("Xóa");
		btnUpdate = new JButton("Cập nhật");
		btnSave = new JButton("Lưu file XML");
		btnFilter = new JButton("Tìm kiếm");
		pnSouth.add(btnAdd);
		pnSouth.add(btnDelete);
		pnSouth.add(btnUpdate);
		pnSouth.add(btnSave);
		pnSouth.add(btnFilter);
		
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnSave.addActionListener(this);
		btnFilter.addActionListener(this);
		
		taoBang();
		updateTable();
		
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);
		this.add(pnBorder);
	}
	
	public void taoBang() {
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã sinh viên");
		model.addColumn("Tên sinh viên");
		model.addColumn("Lớp");
		model.addColumn("Nơi sinh");
		model.addColumn("Môn học");
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(650, 450));
		pnCenter.add(sp);
	}
	
	public void emptyTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
		dtm.fireTableDataChanged();
	}
	
	public void updateTable() {
		emptyTable();
		ArrayList<SinhVien> ds = ls.getDS();
		for (SinhVien sv : ds) {
			model.addRow(new Object[] {sv.getMa() + "", sv.getHoten(), sv.getLop(), sv.getNoisinh(), sv.getMonhoc()});
		}
	}
	
	public static void main(String[] args) {
		new Application().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAdd)) {
			String ma = JOptionPane.showInputDialog("Nhập vào mã sinh viên");
			String hoten = JOptionPane.showInputDialog("Nhập vào tên sinh viên");
			String lop = JOptionPane.showInputDialog("Nhập vào lớp");
			String noisinh = JOptionPane.showInputDialog("Nhập vào nơi sinh");
			String monhoc = JOptionPane.showInputDialog("Nhập vào môn học");
			
			if (ma == "") {
				JOptionPane.showMessageDialog(this, "Mã nhân viên không để trống");
				return;
			}
			
			if (!ma.matches("^[0-9]+$")) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên chỉ chứa số");
				return;
			}
			
			ArrayList<SinhVien> ds = ls.getDS();
			if (ds.contains(new SinhVien(Integer.parseInt(ma)))) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
				return;
			}
			
			SinhVien sv = new SinhVien(Integer.parseInt(ma), hoten, lop, noisinh, monhoc);
			ls.themSinhVien(sv);
			updateTable();
			
		}
		
		if (e.getSource().equals(btnDelete)) {
			int row = table.getSelectedRow();
			ls.xoaSinhVien(table.getValueAt(row, 0) + "");
			updateTable();
		}
		
		if (e.getSource().equals(btnUpdate)) {
			String lop = JOptionPane.showInputDialog("Nhập vào lớp");
			int row = table.getSelectedRow();
			ls.capNhatLop((int) table.getValueAt(row, 0), lop);
			updateTable();
		}
		
		if (e.getSource().equals(btnFilter)) {
			String masv = JOptionPane.showInputDialog("Nhập vào mã sinh viên cần tìm");
			ArrayList<SinhVien> ds = ls.getDS();
			for (SinhVien sv : ds) {
				if (sv.getMa() == Integer.parseInt(masv)) {
					emptyTable();
					model.addRow(new Object[] {sv.getMa() + "", sv.getHoten(), sv.getLop(), sv.getNoisinh(), sv.getMonhoc()});
					
				}
			}
			
		}
		
		if (e.getSource().equals(btnSave)) {
			ls.writeXMLFile();
		}
	}
	
}
