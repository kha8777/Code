package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import Entity.CongViecChoDuAn;
import connectDB.ConnectDB;
import dao.QuanLiCongViec_DAO;

public class GiaoDienSuaCongViec extends JFrame implements ActionListener, MouseListener {

	private JTextField txtMaNhanSu;
	private JLabel lblNewLabel_3;
	private JPanel Khung;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTable table1,table2,table3;
	
	private JDateChooser dateNgayThamGia, dateNgayHoanThanh ;
	
	private JComboBox cmbCongViec, cmbTrangThaiDuAn;
	private static String LoaiCongViec;
	//private static JComboBox comboBoxLoaiCongViec,comboBoxLoaiBangCong, ;
	private JButton btnLuu,btnXoaTrong, btnThoat;
	private static JTextField txtMaDuAn;
	private JTextField txtTimKiem;
	private JTextField txtTimDuAn;
	private JTextField txtTimBangCong;
	private JPanel contentPane;
	private JTextField textMaDuAn;
	private JTextField textMaCongViec;
	
	private JTextField txtSoLuongNhanSu;
	private JTextField textSoLuongNhanSuHienCo;
	private JTextField txtTimKiemDuAn;
	
	QuanLiCongViec_DAO qltcv = new QuanLiCongViec_DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienSuaCongViec window = new GiaoDienSuaCongViec();
					window.setLocationRelativeTo(null);
					window.setVisible(true);
//					window.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GiaoDienSuaCongViec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 564);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Khung = new JPanel();
		Khung.setBackground(new Color(211, 211, 211));
		
		String[]headers1 = {"Mã Công Việc", "Mã Dự Án", "SL Nhân Sự", "Công Việc", "SL Nhân Sự Hiện Có", "Ngày Tham Gia", "Ngày Hoàn Thành", "Trạng Thái"};
		tableModel = new DefaultTableModel(headers1,0);
		JPanel pnTable= new JPanel();
		pnTable.setBackground(new Color(100, 149, 237));

		pnTable.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách Công Việc", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable.setLayout(new GridLayout(1, 0, 0, 0));

		
		JScrollPane scroll;
		pnTable.add( scroll = new JScrollPane(table = new JTable(tableModel)
		{
			//k cho sua tren bang
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		}));
		
		JLabel lblMaDuAn = new JLabel("Mã dự án:");
		lblMaDuAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTitleThemCongViec = new JLabel("SỬA CÔNG VIỆC");
		lblTitleThemCongViec.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleThemCongViec.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		textMaDuAn = new JTextField();
		textMaDuAn.setEditable(false);
		textMaDuAn.setColumns(10);
		
		JLabel lblMaCongViec = new JLabel("Mã công việc:");
		lblMaCongViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textMaCongViec = new JTextField();
		textMaCongViec.setEditable(false);
		textMaCongViec.setColumns(10);
		
		JLabel lblSoLuongNhanSuCongViec = new JLabel("Số lượng nhân sự:");
		lblSoLuongNhanSuCongViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTrangThaiCongViec = new JLabel("Trạng thái:");
		lblTrangThaiCongViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNgayThamGia = new JLabel("Ngày tham gia:");
		lblNgayThamGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		 dateNgayThamGia = new JDateChooser();
		dateNgayThamGia.setDateFormatString("yyyy-MM-dd");
		
		
		
		
		
		txtTimKiemDuAn = new JTextField();
		txtTimKiemDuAn.setColumns(10);
		
		txtTimKiemDuAn.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyReleased(java.awt.event.KeyEvent evt) {
	            TimKiemKeyRelease(evt);
	        }
	        
			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				String search = txtTimKiemDuAn.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
	    });
		
		
		
		JLabel lblTimDuAn = new JLabel("Tìm kiếm công việc:");
		lblTimDuAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scroll.setBackground(new Color(139, 0, 139));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(204, 204, 204));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		scroll.setViewportView(table);
		
		btnThoat = new JButton("THOÁT");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnLuu = new JButton("SỬA");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnXoaTrong = new JButton("XÓA TRỐNG");
		btnXoaTrong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTrong.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		txtSoLuongNhanSu = new JTextField();
		txtSoLuongNhanSu.setColumns(10);
		
		JLabel lblNgayHoanThanh = new JLabel("Ngày hoàn thành:");
		lblNgayHoanThanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		dateNgayHoanThanh = new JDateChooser();
		dateNgayHoanThanh.setEnabled(false);
		textSoLuongNhanSuHienCo = new JTextField();
		textSoLuongNhanSuHienCo.setEditable(false);
		textSoLuongNhanSuHienCo.setColumns(10);
		
		JLabel lblSoLuongNhanSuHienCo = new JLabel("Số lượng nhân sự hiện có:");
		lblSoLuongNhanSuHienCo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbTrangThaiDuAn = new JComboBox();
		cmbTrangThaiDuAn.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		cmbTrangThaiDuAn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbTrangThaiDuAn.addItem("Đang thi công");
	
		
		JLabel lblCongViec = new JLabel("Công việc:");
		lblCongViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbCongViec = new JComboBox();
		cmbCongViec.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		cmbCongViec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbCongViec.addItem("Thợ điện");	
		cmbCongViec.addItem("Thợ hàn");
		cmbCongViec.addItem("Thợ xây");
		cmbCongViec.addItem("Thợ bê tông");
		cmbCongViec.addItem("Thợ phụ hồ");
		cmbCongViec.addItem("Lái máy múc");
		cmbCongViec.addItem("Lái ben");
		cmbCongViec.addItem("Lái xe trộn bê tông");
		cmbCongViec.addItem("Giám sát công trình");
		cmbCongViec.addItem("Giám sát dự án");
		cmbCongViec.addItem("Tư vấn viên");
		cmbCongViec.addItem("Kiến trúc sư");
		cmbCongViec.addItem("Kỹ sư xây dựng");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(Khung, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(Khung, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
		);
		GroupLayout gl_Khung = new GroupLayout(Khung);
		gl_Khung.setHorizontalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(38)
					.addComponent(lblMaDuAn)
					.addGap(19)
					.addComponent(textMaDuAn, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(152)
							.addComponent(lblTitleThemCongViec, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblSoLuongNhanSuHienCo, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textSoLuongNhanSuHienCo, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblTrangThaiCongViec, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addComponent(cmbTrangThaiDuAn, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addComponent(btnXoaTrong, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(13)
							.addComponent(lblMaCongViec, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textMaCongViec, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(lblSoLuongNhanSuCongViec, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblNgayThamGia, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(dateNgayThamGia, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(lblNgayHoanThanh, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTimDuAn, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtTimKiemDuAn, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)))
					.addGap(19)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(txtSoLuongNhanSu, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblCongViec, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateNgayHoanThanh, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(cmbCongViec, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(10)
					.addComponent(pnTable, GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
					.addGap(4))
		);
		gl_Khung.setVerticalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(30)
							.addComponent(lblMaDuAn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(41)
							.addComponent(textMaDuAn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(lblTitleThemCongViec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSoLuongNhanSuHienCo, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(11)
									.addComponent(textSoLuongNhanSuHienCo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(11)
									.addComponent(lblTrangThaiCongViec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(47)
							.addComponent(cmbTrangThaiDuAn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(15)
							.addComponent(btnXoaTrong, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaCongViec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(7)
									.addComponent(textMaCongViec, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSoLuongNhanSuCongViec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNgayThamGia, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(11)
									.addComponent(dateNgayThamGia, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(11)
									.addComponent(lblNgayHoanThanh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(15)
							.addGroup(gl_Khung.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTimDuAn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTimKiemDuAn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(txtSoLuongNhanSu, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(10)
									.addComponent(lblCongViec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(4)
							.addComponent(dateNgayHoanThanh, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(26)
							.addComponent(cmbCongViec, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addComponent(pnTable, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
					.addGap(1))
		);
		Khung.setLayout(gl_Khung);
		contentPane.setLayout(gl_contentPane);
		ConnectDB.getInstance().Connect();
		updateDataBangCongViec();
		
		btnLuu.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoaTrong.addActionListener(this);
		table.addMouseListener(this);
		
	}

	

	public void updateDataBangCongViec() {
		QuanLiCongViec_DAO qltcv = new QuanLiCongViec_DAO();
		List<CongViecChoDuAn> list =  qltcv.bangCongViec1();
		for(CongViecChoDuAn cv : list)
		{
			String[] rowdata = {cv.getMaCongViec(),cv.getMaDuAn(), cv.getSoLuongNhanSuCV(), cv.getCongViec(),cv.getSoLuongNhanSuHienCo(),cv.getNgayThamGiaCongViec(), cv.getNgayHoanThanhCongViec(), cv.getTrangThaiCV()+""};
			tableModel.addRow(rowdata);			
		}
		table.setModel(tableModel);
	}
	
	
	
	
	
	
	
	private void suaCongViec() {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
		
		int row = table.getSelectedRow();
		//if(kiemloi()) how 
		//	{
		String a = "0";

		if(qltcv.capNhat(textMaDuAn.getText(), txtSoLuongNhanSu.getText(), cmbCongViec.getSelectedItem().toString(), a, df.format(dateNgayThamGia.getDate()), null, cmbTrangThaiDuAn.getSelectedItem().toString(),textMaCongViec.getText()) );
				
		{

			table.setValueAt(textMaCongViec.getText(), row, 1);
			

			JOptionPane.showMessageDialog(this, "Công việc đã được sửa");
			
			tableModel = (DefaultTableModel)table.getModel();
			tableModel.setRowCount(0);
			ConnectDB.getInstance().Connect();
			updateDataBangCongViec();

		}
		
		
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		textMaCongViec.setText(table.getValueAt(row,0).toString());
		textMaDuAn.setText(table.getValueAt(row,1).toString());
		txtSoLuongNhanSu.setText(table.getValueAt(row,2).toString());
		cmbCongViec.setSelectedItem(table.getValueAt(row, 3).toString());
		textSoLuongNhanSuHienCo.setText(table.getValueAt(row, 4).toString());
		try {
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row,5));
			dateNgayThamGia.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cmbTrangThaiDuAn.setSelectedItem(table.getValueAt(row, 7).toString());
		
//		try {
//			Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row,6));
//			dateNgayHoanThanh.setDate(date);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//			
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnLuu)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa công việc ? ","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac==JOptionPane.YES_OPTION ) {
				suaCongViec();
				System.out.println("bamnut");
					
			}
			
			
			
	}
		if(o.equals(btnThoat)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, " Thoát khỏi sửa công việc ","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac==JOptionPane.YES_OPTION ) {
				dispose();
			}
			
		}
		if(o.equals(btnXoaTrong)) {
			textMaCongViec.setText("");
			textMaDuAn.setText("");
			txtSoLuongNhanSu.setText("");
			cmbTrangThaiDuAn.setSelectedItem("Chọn");
			cmbCongViec.setSelectedItem("Chọn");
			dateNgayHoanThanh.setDate(null);
			dateNgayThamGia.setDate(null);
		}
	}
}