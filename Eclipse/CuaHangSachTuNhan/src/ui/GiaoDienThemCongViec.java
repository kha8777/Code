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
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import Entity.CongViecChoDuAn;
import Entity.ThemDuAn;
import connectDB.ConnectDB;
import dao.QuanLiCongViec_DAO;
import dao.QuanLiThemDuAn_DAO;

public class GiaoDienThemCongViec extends JFrame implements ActionListener, MouseListener {

	private JPanel Khung;
	private JPanel contentPane;
	private JTable table;
	private JButton btnLuu,btnXoaTrong, btnThoat;
	private JComboBox cmbCongViec, cmbTrangThaiDuAn;
	private JComboBox cboduAn;	
	private JTextField textMaCongViec;
	private JTextField txtSoLuongNhanSu;
	private JTextField textSoLuongNhanSuHienCo;
	private JTextField txtTimKiemDuAn;
	private JDateChooser dateNgayThamGia, dateNgayHoanThanh ;
	private DefaultTableModel tableModel;

	QuanLiCongViec_DAO qltcv = new QuanLiCongViec_DAO();
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienThemCongViec frame = new GiaoDienThemCongViec();
					frame.setVisible(true);
					
					//Set Auto Center Monitor
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public GiaoDienThemCongViec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 565);
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
				return false;
			}
		}));
		
		JLabel lblMaDuAn = new JLabel("Mã dự án:");
		lblMaDuAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTitleThemCongViec = new JLabel("THÊM CÔNG VIỆC");
		lblTitleThemCongViec.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleThemCongViec.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblMaCongViec = new JLabel("Mã công việc:");
		lblMaCongViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textMaCongViec = new JTextField();
		textMaCongViec.setEditable(false);
		textMaCongViec.setColumns(10);
		
		JLabel lblSoLuongNhanSuCongViec = new JLabel("Số lượng nhân sự:");
		lblSoLuongNhanSuCongViec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTrangThaiCongViec = new JLabel("Trạng thái:");
		lblTrangThaiCongViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNgayThamGia = new JLabel("Ngày tham gia:");
		lblNgayThamGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		 dateNgayThamGia = new JDateChooser();
		dateNgayThamGia.setDateFormatString("yyyy-MM-dd");
		
		
		
		
		
		JLabel lblTimDuAn = new JLabel("Tìm kiếm dự án:");
		lblTimDuAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scroll.setBackground(new Color(139, 0, 139));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(204, 204, 204));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		scroll.setViewportView(table);
		
		btnThoat = new JButton("THOÁT");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnLuu = new JButton("LƯU");
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
		lblNgayHoanThanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		dateNgayHoanThanh = new JDateChooser();
		dateNgayHoanThanh.setEnabled(false);
		textSoLuongNhanSuHienCo = new JTextField();
		textSoLuongNhanSuHienCo.setEditable(false);
		textSoLuongNhanSuHienCo.setColumns(10);
		
		JLabel lblSoLuongNhanSuHienCo = new JLabel("Số lượng nhân sự hiện có:");
		lblSoLuongNhanSuHienCo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
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
		
		cmbTrangThaiDuAn = new JComboBox();
		cmbTrangThaiDuAn.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		cmbTrangThaiDuAn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbTrangThaiDuAn.addItem("Dang Thi Cong");
	
		
		JLabel lblCongViec = new JLabel("Công việc:");
		lblCongViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbCongViec = new JComboBox();
		cmbCongViec.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		cmbCongViec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbCongViec.addItem("Kĩ Sư Thiết Kế");
		cmbCongViec.addItem("Thợ Xây");
		cmbCongViec.addItem("Thợ Hàn");
		cmbCongViec.addItem("Tài Xế Máy Xúc");
		cmbCongViec.addItem("Kĩ Thuật Viên");
		cmbCongViec.addItem("Lắp Điện");
		cmbCongViec.addItem("Lắp Ống Nước");
		cboduAn = new JComboBox<String>();
		cboduAn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboduAn.setEditable(false);
		GroupLayout gl_Khung = new GroupLayout(Khung);
		gl_Khung.setHorizontalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addGap(38)
					.addComponent(lblMaDuAn)
					.addGap(19)
					.addComponent(cboduAn, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
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
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTimDuAn, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(115)
									.addComponent(txtTimKiemDuAn, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)))))
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
					.addGap(14))
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
							.addGap(40)
							.addComponent(cboduAn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
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
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTimDuAn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(2)
									.addComponent(txtTimKiemDuAn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
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
					.addComponent(pnTable, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addGap(36))
		);
		Khung.setLayout(gl_Khung);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(Khung, GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(Khung, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
					.addGap(0))
		);
		contentPane.setLayout(gl_contentPane);
		ConnectDB.getInstance().Connect();
		updateDataBangCongViec();
		
		btnLuu.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoaTrong.addActionListener(this);
		table.addMouseListener(this);
		updateComboBox();
	}

	

	private void updateComboBox() {
		// TODO Auto-generated method stub
		QuanLiThemDuAn_DAO da = new QuanLiThemDuAn_DAO();
			List<ThemDuAn> list = da.bangDuAnThem();
			
			for(ThemDuAn s : list)
				cboduAn.addItem(s.getMaDuAn());
	}


	public void updateDataBangCongViec() {
		QuanLiCongViec_DAO qltcv = new QuanLiCongViec_DAO();
		List<CongViecChoDuAn> list =  qltcv.bangCongViec();
		for(CongViecChoDuAn cv : list)
		{
			String[] rowdata = {cv.getMaCongViec(),cv.getMaDuAn(), cv.getSoLuongNhanSuCV(), cv.getCongViec(),cv.getSoLuongNhanSuHienCo(),cv.getNgayThamGiaCongViec(), cv.getNgayHoanThanhCongViec(), cv.getTrangThaiCV()+""};
			tableModel.addRow(rowdata);			
		}
		table.setModel(tableModel);
	}
	
	
	
	private void themCongViec() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
		if(kiemloi())
			
		{
				String a = "0";
				if(qltcv.themCongViec(cboduAn.getSelectedItem().toString(), txtSoLuongNhanSu.getText(), cmbCongViec.getSelectedItem().toString(), a, df.format(dateNgayThamGia.getDate()), null, cmbTrangThaiDuAn.getSelectedItem().toString()));
				
						
					{
	
						
						JOptionPane.showMessageDialog(this, "ĐÃ THÊM CÔNG VIỆC VÀO HỆ THỐNG");
					
						tableModel = (DefaultTableModel)table.getModel();
						tableModel.setRowCount(0);
						updateDataBangCongViec();
	
				}
					
			}
		}
	
	
	private boolean kiemloi() {
        String tpb = txtSoLuongNhanSu.getText().trim();
  
        if(!(tpb.length()>0 ))
        {
            JOptionPane.showMessageDialog(this, "Số lượng nhân sự không được để trống");
            txtSoLuongNhanSu.requestFocus();
            return false;
        }
        return true;
    }
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row >= 0)
		{
			textMaCongViec.setText(table.getValueAt(row,0).toString());
//			textMaDuAn.setText(table.getValueAt(row,1).toString());
			cboduAn.setSelectedItem(table.getValueAt(row,1).toString());
			txtSoLuongNhanSu.setText(table.getValueAt(row,2).toString());
			cmbCongViec.setSelectedItem(table.getValueAt(row,3).toString());
			textSoLuongNhanSuHienCo.setText(table.getValueAt(row,4).toString());
			try {
				Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row,5));
				dateNgayThamGia.setDate(date);
			} catch (ParseException e1) {
				
				e1.printStackTrace();
			}
			cmbTrangThaiDuAn.setSelectedItem(table.getValueAt(row,3).toString());
		}
	
		
//		try {
//			Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row,6));
//			dateNgayHoanThanh.setDate(date);
//		} catch (ParseException e1) {
//			
//			e1.printStackTrace();
//		}
//			
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
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
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc thêm công việc ?","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac==JOptionPane.YES_OPTION ) {
			
				System.out.println("bamnut");
				themCongViec();
			}
		}
			
		if(o.equals(btnThoat)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Thoát khỏi thêm công việc","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac==JOptionPane.YES_OPTION ) {

				dispose();

			}
			
		}
		if(o.equals(btnXoaTrong)) {
			textMaCongViec.setText("");
			txtSoLuongNhanSu.setText("");
			cmbTrangThaiDuAn.setSelectedItem("Chọn");
			cmbCongViec.setSelectedItem("Chọn");
			dateNgayHoanThanh.setDate(null);
			dateNgayThamGia.setDate(null);
		}
		
	}
}
