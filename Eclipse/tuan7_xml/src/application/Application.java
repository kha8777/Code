package application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.Product;
import manage.ManageProduct;

@SuppressWarnings("serial")
public class Application extends JFrame {
	private JPanel pnBorder;
	private JPanel pnCenter;
	private JTable table;
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
		
		taoBang();
		emptyTable();
		updateTable();
		
		pnBorder.add(pnCenter);
		this.add(pnBorder);
	}
	
	public void taoBang() {
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("ProductID");
		model.addColumn("ProductName");
		model.addColumn("Manufacture");
		model.addColumn("Description");
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
		ArrayList<Product> ds = ls.getAllProducts();
		for (Product product : ds) {
			model.addRow(new Object[] {product.getProductID(), product.getProductName(), product.getManufacture(), product.getDescription(), product.getPrice() + ""});
		}
	}
	
	public static void main(String[] args) {
		new Application().setVisible(true);
	}
	
}
