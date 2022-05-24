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

import entity.Product;
import entity.Supplier;
import manage.ManageProduct;

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
	private ManageProduct ls = new ManageProduct();
	
	public Application() {
		setTitle("");
		setSize(800, 500);
		UI();
	}
	
	public void UI() {
		pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		
		pnSouth = new JPanel();
		btnAdd = new JButton("Add");
		btnDelete = new JButton("Delete");
		btnUpdate = new JButton("Update");
		btnSave = new JButton("Save");
		btnFilter = new JButton("Filter");
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
		model.addColumn("ProductID");
		model.addColumn("ProductName");
		model.addColumn("Manufacture");
		model.addColumn("Description");
		model.addColumn("SupplierName");
		model.addColumn("Country");
		model.addColumn("Website");
		model.addColumn("Price");
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
		ArrayList<Product> ds = ls.getAllProducts();
		for (Product product : ds) {
			model.addRow(new Object[] {product.getProductID(), product.getProductName(), product.getManufacture(), product.getDescription(), product.getSupplier().getName(), product.getSupplier().getCountry(), product.getSupplier().getWebsite(), product.getPrice() + ""});
		}
	}
	
	public static void main(String[] args) {
		new Application().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAdd)) {
			String id = JOptionPane.showInputDialog("Nhập vào mã sản phẩm");
			String name = JOptionPane.showInputDialog("Nhập vào tên sản phẩm");
			
			Supplier supplier = new Supplier("Hòa phát", "Việt Nam", "www.HoaPhatComputer.com");
			Product product = new Product(id, name, "Samsung", "May tinh samsung doi moi voi cong nghe hien dai", supplier, 500.0);
			ls.addProduct(product);
			updateTable();
			
		}
		if (e.getSource().equals(btnSave)) {
			ls.writeXMLFile();
		}
	}
	
}
