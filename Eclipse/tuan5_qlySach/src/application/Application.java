package application;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Application extends JFrame {
	JPanel pnBorder = new JPanel();
	JPanel pnCenter = new JPanel();
	
	
	public Application() {
		setTitle("Thu vien");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initUI();
	}
	
	public void initUI() {
		pnBorder = new JPanel();
		pnCenter = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titleBorder = new TitledBorder(border);
		titleBorder.setTitle("Records Editor");
		JLabel lbMa = new JLabel("Ma sach");
		JLabel lbTua = new JLabel("Tua sach");
		JLabel lbTacGia = new JLabel("Tac gia");
		JLabel lbNamXuatBan = new JLabel("Nam xuat ban");
		JLabel lbNhaXuatBan = new JLabel("Nha xuat ban");
		JLabel lbSoTrang = new JLabel("So trang");
		JLabel lbDonGia = new JLabel("Don gia");
		JLabel lbisbn = new JLabel("International Standard Book Number (ISBN)");
	}
	
	public static void main(String[] args) {
		new Application().setVisible(true);
	}
	
}
