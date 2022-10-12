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


public class GiaoDienXoaCongViec extends JFrame implements ActionListener, MouseListener{

	private JPanel Khung;
	private JTable table;
	private DefaultTableModel tableModel;
	private JDateChooser dateNgayThamGia, dateNgayHoanThanh ;
	private JComboBox cmbCongViec, cmbTrangThaiDuAn;
	private JButton btnLuu,btnXoaTrong, btnThoat;
	private JPanel contentPane;
	private JTextField textMaDuAn;
	private JTextField textMaCongViec;
	private JTextField txtSoLuongNhanSu;
	private JTextField textSoLuongNhanSuHienCo;
	private JTextField txtTimKiemDuAn;
	
	QuanLiCongViec_DAO qltcv = new QuanLiCongViec_DAO();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienXoaCongViec frame = new GiaoDienXoaCongViec();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GiaoDienXoaCongViec() {
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
		
		JLabel lblTitleXoaCongViec = new JLabel("XÓA CÔNG VIỆC");
		lblTitleXoaCongViec.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleXoaCongViec.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		textMaDuAn = new JTextField();
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
		btnThoat.setMnemonic('T');
		
		
		btnLuu = new JButton("XÓA");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setMnemonic('X');
		
		btnXoaTrong = new JButton("XÓA TRỐNG");
		btnXoaTrong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTrong.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnXoaTrong.setMnemonic('R');
		
		txtSoLuongNhanSu = new JTextField();
		txtSoLuongNhanSu.setColumns(10);
		
		JLabel lblNgayHoanThanh = new JLabel("Ngày hoàn thành:");
		lblNgayHoanThanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		dateNgayHoanThanh = new JDateChooser();
		
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
		cmbTrangThaiDuAn.addItem("Đang thi công");
	
		
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
		GroupLayout gl_Khung = new GroupLayout(Khung);
		gl_Khung.setHorizontalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(38)
							.addComponent(lblMaDuAn)
							.addGap(18)
							.addComponent(textMaDuAn, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(153)
									.addComponent(lblTitleXoaCongViec, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addComponent(lblSoLuongNhanSuHienCo, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textSoLuongNhanSuHienCo, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
									.addComponent(lblTrangThaiCongViec, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbTrangThaiDuAn, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(btnXoaTrong, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(18)
							.addComponent(lblMaCongViec, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textMaCongViec, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(lblSoLuongNhanSuCongViec, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtSoLuongNhanSu, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
							.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addComponent(lblNgayThamGia, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(dateNgayThamGia, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
									.addComponent(lblNgayHoanThanh, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(5)
									.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblTimDuAn, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_Khung.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
											.addComponent(txtTimKiemDuAn, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)))
									.addGap(91)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateNgayHoanThanh, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblCongViec, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cmbCongViec, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(10)
							.addComponent(pnTable, GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)))
					.addGap(14))
		);
		gl_Khung.setVerticalGroup(
			gl_Khung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Khung.createSequentialGroup()
					.addGroup(gl_Khung.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_Khung.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(30)
									.addComponent(lblMaDuAn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addComponent(lblTitleXoaCongViec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Khung.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblSoLuongNhanSuHienCo, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
											.addComponent(textMaDuAn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(4)
											.addGroup(gl_Khung.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTrangThaiCongViec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
												.addComponent(cmbTrangThaiDuAn, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
										.addGroup(gl_Khung.createSequentialGroup()
											.addGap(11)
											.addComponent(textSoLuongNhanSuHienCo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addGap(8))
						.addGroup(gl_Khung.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnXoaTrong, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_Khung.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(10)
							.addComponent(textMaCongViec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_Khung.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSoLuongNhanSuCongViec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSoLuongNhanSu, GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE))
							.addGap(7))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLuu, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
								.addComponent(lblMaCongViec, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
					.addGap(7)
					.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Khung.createSequentialGroup()
							.addGroup(gl_Khung.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNgayHoanThanh, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
								.addGroup(gl_Khung.createSequentialGroup()
									.addComponent(dateNgayHoanThanh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(9))
								.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_Khung.createSequentialGroup()
										.addGap(11)
										.addComponent(dateNgayThamGia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(lblNgayThamGia, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(23)
							.addGroup(gl_Khung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTimDuAn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Khung.createSequentialGroup()
									.addGap(2)
									.addComponent(txtTimKiemDuAn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
							.addGap(13))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(23)
							.addComponent(btnThoat, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
							.addGap(32))
						.addGroup(gl_Khung.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_Khung.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbCongViec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCongViec, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))))
					.addGap(11)
					.addComponent(pnTable, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_dateNgayThamGia = new GroupLayout(dateNgayThamGia);
		gl_dateNgayThamGia.setHorizontalGroup(
			gl_dateNgayThamGia.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dateNgayThamGia.createSequentialGroup()
					.addGap(129)
					.addComponent(dateNgayThamGia.getCalendarButton()))
		);
		gl_dateNgayThamGia.setVerticalGroup(
			gl_dateNgayThamGia.createParallelGroup(Alignment.LEADING)
				.addComponent(dateNgayThamGia.getCalendarButton(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
		);
		dateNgayThamGia.setLayout(gl_dateNgayThamGia);
		Khung.setLayout(gl_Khung);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(Khung, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(Khung, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
		);
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
		List<CongViecChoDuAn> list =  qltcv.bangCongViec();
		for(CongViecChoDuAn cv : list)
		{
			String[] rowdata = {cv.getMaCongViec(),cv.getMaDuAn(), cv.getSoLuongNhanSuCV(), cv.getCongViec(),cv.getSoLuongNhanSuHienCo(),cv.getNgayThamGiaCongViec(), cv.getNgayHoanThanhCongViec(), cv.getTrangThaiCV()+""};
			tableModel.addRow(rowdata);			
		}
		table.setModel(tableModel);
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
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		if(o.equals(btnLuu)) {
			
//		HÀM ĐEMO	tableModel = (DefaultTableModel)table.getModel();
//			 for (int i=0;i<tableModel.getRowCount();i++) {
//		          Boolean checked=(Boolean)tableModel.getValueAt(i,9);
//		          if (checked!=null && checked) {
//		               tableModel.removeRow(i);
//		               i--;
//		          }
//		    }
			
//			Xóa nhiều nhiều
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa công việc? ","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac==JOptionPane.YES_OPTION ) {
				tableModel = (DefaultTableModel)table.getModel();
				int row = table.getSelectedRow();
				
				while (row != -1) {
					int maCongViec1 = table.convertRowIndexToModel(row);
					String maCongViec = (String)table.getValueAt(row,0);
					tableModel.removeRow(maCongViec1);
					row = table.getSelectedRow();
					qltcv.XoaCongViec(maCongViec); 
					
					XoaTrong();
				
			}
				JOptionPane.showMessageDialog(this, "Xóa công việc thành công");
			}
			
			
			
			
//			 Hàm gốc
//				int row = table.getSelectedRow();
//				String maCongViec = (String)table.getValueAt(row,0);
//				qltcv.XoaCongViec(maCongViec); 
//				System.out.println("ĐÃ Xóa");
//				tableModel = (DefaultTableModel)table.getModel();
//				tableModel.setRowCount(0);
//				updateDataBangCongViec();
			
	}
		
		if(o.equals(btnThoat)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Thoát khỏi xóa dự án","Chú ý",JOptionPane.YES_NO_OPTION);
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
	private void XoaTrong() {
		textMaCongViec.setText("");
		textMaDuAn.setText("");
		txtSoLuongNhanSu.setText("");
		cmbTrangThaiDuAn.setSelectedItem("Chọn");
		cmbCongViec.setSelectedItem("Chọn");
		dateNgayHoanThanh.setDate(null);
		dateNgayThamGia.setDate(null);
	}
}
