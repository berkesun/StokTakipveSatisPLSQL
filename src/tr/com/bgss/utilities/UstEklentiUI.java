package tr.com.bgss.utilities;


import java.awt.Image;

import tr.com.bgss.sunAWT.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tr.com.bgss.utilities.UstEklentiUI;

public class UstEklentiUI {
		

		private static JFrame f;
		private static JPanel p;
		private JLabel lab;
		
		
		
		public UstEklentiUI() {
			
			gui();
			
		}
		
		
		public void gui() {
			
			//f = new JFrame("Creativity tuts");
			//f.setVisible(true);
			//f.setSize(600,300);
			//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			p = new JPanel();
			//p.setBackground(Color.PINK);
			
			//lab = new JLabel("Stok ve Takip Otomasyonuna Hoþgeldiniz.");
			
			
			JLabel ekranresmi = new JLabel();
			Image img2 = new ImageIcon(UstEklentiUI.class.getResource("/arkaplannn.jpg")).getImage();
			ekranresmi.setIcon(new ImageIcon(img2));
			
			p.add(ekranresmi);
			//p.add(lab);
			
			//f.add(p);
			
		}
		
		public static JPanel UstEklentiUI() {
			
			new UstEklentiUI();
			return p;
		}


}
