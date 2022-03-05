package layout_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Tuan1_1_Gptb2 extends JFrame implements ActionListener {
	
	private JButton btnSolve;
	private JButton btnDel;
	private JButton btnExit;
	private JTextField tfA;
	private JTextField tfB;
	private JTextField tfC;
	private JTextField tfAns;
	
	public Tuan1_1_Gptb2() {
		setTitle("Giải phương trình bậc 2");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		createGUI();
	}
	
	private void createGUI() {
		// North panel
		JPanel northPanel;
		add(northPanel = new JPanel(), BorderLayout.NORTH);
		northPanel.setBackground(Color.lightGray);
		JLabel lblTitle;
		northPanel.add(lblTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI"));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		
		// Center panel
		JPanel centerPanel;
		add(centerPanel = new JPanel(), BorderLayout.CENTER);
		centerPanel.setLayout(null); // position: absolute;
		JLabel lbla, lblb, lblc, lblans;
		
		// Label
		centerPanel.add(lbla = new JLabel("Nhập a: "));
		int x = 20, y = 40, width = 100, height = 30;
		lbla.setBounds(x, y, width, height);
		
		centerPanel.add(lblb = new JLabel("Nhập b: "));
		y += 50;
		lblb.setBounds(x, y, width, height);
		
		centerPanel.add(lblc = new JLabel("Nhập c: "));
		y += 50;
		lblc.setBounds(x, y, width, height);
		
		centerPanel.add(lblans = new JLabel("Kết quả: "));
		y += 50;
		lblans.setBounds(x, y, width, height);
		
		// Text field
		centerPanel.add(tfA = new JTextField());
		x += 100; y = 40; width = 300;
		tfA.setBounds(x, y, width, height);
		
		centerPanel.add(tfB = new JTextField());
		y += 50;
		tfB.setBounds(x, y, width, height);
		
		centerPanel.add(tfC = new JTextField());
		y += 50;
		tfC.setBounds(x, y, width, height);
		
		centerPanel.add(tfAns = new JTextField());
		y += 50;
		tfAns.setBounds(x, y, width, height);
		tfAns.setEditable(false);
		
		// South panel
		JPanel southPanel;
		add(southPanel = new JPanel(), BorderLayout.SOUTH);
		southPanel.setBorder(BorderFactory.createTitledBorder("Chọn chức năng"));
		southPanel.add(btnSolve = new JButton("Giải"));
		southPanel.add(btnDel = new JButton("Xóa"));
		southPanel.add(btnExit = new JButton("Thoát"));
		
		// Action listener
		btnSolve.addActionListener(this);
		btnDel.addActionListener(this);
		btnExit.addActionListener(this);
		// Default of JFrame: Border layout, JPanel = Flow layout
		
	}
	
	public static void main(String[] args) {
		new Tuan1_1_Gptb2().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o.equals(btnExit)) {
			System.exit(0);
		}
		else if (o.equals(btnDel)) {
			tfA.setText("");
			tfB.setText("");
			tfC.setText("");
			tfAns.setText("");
			tfA.requestFocus();
		}
		else if (o.equals(btnSolve)) {
			if (!isInt(tfA)) focus(tfA);
			else if (!isInt(tfB)) focus(tfB);
			else if (!isInt(tfC)) focus(tfC);
			else {
				int a = Integer.parseInt(tfA.getText());
				int b = Integer.parseInt(tfB.getText());
				int c = Integer.parseInt(tfC.getText());
				if (a == 0) giaiPhuongTrinhBac1(b, c);
				else {
					double delta = b*b - 4*a*c;
					if (delta < 0) tfAns.setText("Phương trình vô nghiệm");
					else if (delta == 0) tfAns.setText("Phương trình có nghiệm kép: x₁ = x₂ = " + (-b / 2 * (float) a));
					else tfAns.setText("Phương trình có 2 nghiệm phân biệt: x₁ = " + (-b + Math.sqrt(delta) / 2 * (float) a) + ", x₂ = " + (-b - Math.sqrt(delta) / 2 * (float) a));
				}
			}
		}
	}
	
	private void giaiPhuongTrinhBac1(int a, int b) {
		if (a == 0) tfAns.setText("Phương trình vô nghiệm");
		else if (b == 0) tfAns.setText("Phương trình có vô số nghiệm");
		else tfAns.setText("Phương trình có nghiệm x = " + (-b / (float) a));
	}
	
	private boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		}
		catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}
	
	private void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "Lỗi nhập liệu !");
		text.selectAll();
		text.requestFocus();
	}
}
