package layout_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class DemoJList extends JFrame {
	private JTextField txtA;
	
	public DemoJList() {
		setTitle("Demo JList");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		
		createGUI();
	}
	
	private void createGUI() {
		JPanel pnBorderCha = new JPanel();
		pnBorderCha.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JLabel lblTitle = new JLabel("Thao Tac tren JList-CheckBox");
		lblTitle.setForeground(Color.BLUE);
		Font ft = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(ft);
		pnNorth.add(lblTitle);
		pnBorderCha.add(pnNorth, BorderLayout.NORTH);
		
		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		Border WestBorder = BorderFactory.createLineBorder(Color.RED);
		TitledBorder WestTitleBorder = new TitledBorder(WestBorder, "Chon tac vu");
		pnWest.setBorder(WestTitleBorder);
		
		JPanel pnA = new JPanel();
		JButton btnA = new JButton("To den so chan");
		pnA.add(btnA);
		pnWest.add(pnA);
		
		JPanel pnB = new JPanel();
		JButton btnB = new JButton("To den so le");
		pnB.add(btnB);
		pnWest.add(pnB);
		
		JPanel pnC = new JPanel();
		JButton btnC = new JButton("To den so nguyen to");
		pnC.add(btnC);
		pnWest.add(pnC);
		
		JPanel pnD = new JPanel();
		JButton btnD = new JButton("Bo to den");
		pnD.add(btnD);
		pnWest.add(pnD);
		
		JPanel pnE = new JPanel();
		JButton btnE = new JButton("Xoa cac gia tri dang to den");
		pnE.add(btnE);
		pnWest.add(pnE);
		
		JPanel pnF = new JPanel();
		JButton btnF = new JButton("Tong cac gia tri trong JList");
		pnF.add(btnF);
		pnWest.add(pnF);
		
		pnBorderCha.add(pnWest, BorderLayout.WEST);
		
		JPanel pnEast = new JPanel();
		pnEast.setLayout(new BoxLayout(pnEast, BoxLayout.Y_AXIS));
		Border EastBorder = BorderFactory.createLineBorder(Color.RED);
		TitledBorder EastTitleBorder = new TitledBorder(EastBorder, "Nhap chuong trinh");
		pnEast.setBorder(EastTitleBorder);

		JPanel pn1 = new JPanel();
		txtA = new JTextField(15);
		pn1.add(txtA);
		JButton btn1 = new JButton("Nhap");
		pn1.add(btn1);
		pnEast.add(pn1);
		
		JPanel pn2 = new JPanel();
		JCheckBox ckb1 = new JCheckBox("cho phep nhap so am");
		pn2.add(ckb1);
		pnEast.add(pn2);

		pnBorderCha.add(pnEast, BorderLayout.CENTER);
		
		JPanel pnSouth = new JPanel();
		JButton SouthBtn1 = new JButton("Exit");
		pnSouth.add(SouthBtn1);
		pnSouth.setBackground(Color.LIGHT_GRAY);
		pnBorderCha.add(pnSouth, BorderLayout.SOUTH);
		
		add(pnBorderCha);
	}
	
	public static void main(String[] args) {
		new DemoJList().setVisible(true);
	}
}
