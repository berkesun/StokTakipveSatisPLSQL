package tr.com.bgss.test;

import java.awt.Color;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import tr.com.bgss.ui.AnaPencereUI;
import tr.com.bgss.ui.LoginUI;

public class run {
	
	public static void main(String[] args) {
		
		//UIManager.put("control", new Color(65, 128, 128));
		UIManager.put("info", new Color(128, 128, 128));
		//UIManager.put("nimbusBase", new Color(18, 30, 49));
		//UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
		//UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
		UIManager.put("nimbusFocus", new Color(115, 164, 209));
		//UIManager.put("nimbusGreen", new Color(176, 179, 50));
		//UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
		//UIManager.put("nimbusLightBackground", new Color(127, 182, 183));
		//UIManager.put("nimbusOrange", new Color(191, 98, 4));
		//UIManager.put("nimbusRed", new Color(169, 46, 34));
		//UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
		//UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
		
		UIManager.put("text", new Color(0,0,0));

		          try {

		                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {

		                     if ("Nimbus".equals(info.getName())) {

		                          javax.swing.UIManager.setLookAndFeel(info.getClassName());

		                          break;

		                     }

		                }

		          } catch (ClassNotFoundException e) {

		                e.printStackTrace();

		          } catch (InstantiationException e) {

		                e.printStackTrace();

		          } catch (IllegalAccessException e) {

		                e.printStackTrace();

		          } catch (javax.swing.UnsupportedLookAndFeelException e) {

		                e.printStackTrace();

		          } catch (Exception e) {

		                e.printStackTrace();

		          }
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				//new AnaPencereUI();
				new LoginUI();
				
				
			}
		});
		
	}

}
