
package Main;

import java.awt.EventQueue;

import ui.GiaoDienDangNhap;

public class main {
public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienDangNhap frame = new GiaoDienDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
