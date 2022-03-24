package tuan4_phongBan;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class UI extends JFrame{
	private DefaultMutableTreeNode root;
	private JTree tree;
	private ArrayList<PhongBan> dspb;
	
	public UI(ArrayList<PhongBan> dspb)
	{
		setTitle("3===D");
//		setExtendedState(MAXIMIZED_BOTH);
		setSize(800,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.dspb=dspb;
		root = new DefaultMutableTreeNode("Danh sách phòng ban");
		tree= new JTree(root);
		tree.setShowsRootHandles(true);
		int soPhongBan = dspb.size();
		for(int i = 0; i< soPhongBan; i++)
		{
			PhongBan pb = dspb.get(i);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(pb);
			root.add(node);
		}
		add(new JScrollPane(tree), BorderLayout.CENTER);
		tree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					DefaultMutableTreeNode x = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					if(x != null)
					{
						Object gt = x.getUserObject();
						if (gt instanceof PhongBan){
							PhongBan pb = (PhongBan) x.getUserObject();
							ArrayList<NhanVien> dsnv = pb.getDsnv();
							
							TableNhanVienGUI gd = new TableNhanVienGUI(dsnv, pb.toString());
							gd.show();
							
						}
					}
				}
				
			}
		});
		
	}
	public static void main(String[] args) {
		CongTy ct = new CongTy();
		PhongBan tc, kt;
		ct.themMoiPhongBan(tc = new PhongBan("TC", "Phòng tổ chức"));
		ct.themMoiPhongBan(kt = new PhongBan("KT", "Phòng kỹ thuật")); 
		
		tc.themMoiNhanVien("0111","Bùi","Văn Tiến",false, 21,3000);
		tc.themMoiNhanVien("0112","Nguyễn","Ngọc Hân",true, 19,30000);
		
		kt.themMoiNhanVien("0111","Nguyễn","Thị Hiền",true, 21,3000);
		kt.themMoiNhanVien("0112","Nguyễn","Ngọc Tùng",false, 19,30000);
		kt.themMoiNhanVien("0113","Nguyễn","Ngọc Hiền",false, 19,30000);
		ArrayList<PhongBan> dspb = ct.getDspb();
		new UI(dspb).setVisible(true);
	}
}
