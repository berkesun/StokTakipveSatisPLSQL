package tr.com.bgss.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import tr.com.bgss.contract.PersonelContract;
import tr.com.bgss.dal.PersonelDAL;
import tr.com.bgss.dal.YoneticiDAL;
import tr.com.bgss.interfaces.uiInterfaces;
import tr.com.bgss.utilities.UstEklentiUI;

public class LoginUI extends JDialog implements uiInterfaces {

	public static JComboBox emailBox;

	public LoginUI() {
		initPencere();
	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		JPanel panell = ustBar();

		add(panel, java.awt.BorderLayout.CENTER);
		add(panell);

		setTitle("Stok ve Takip Otomasyonu");
		pack();
		setSize(1200, 900);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	public JPanel ustBar() {
		JPanel panel = UstEklentiUI.UstEklentiUI();

		panel.setBounds(0, 0, 1200, 900);

		return panel;
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBounds(225, 225, 715, 400);
		panel.setBackground(null);
		JTabbedPane pane = initTabs();

		panel.add(pane, BorderLayout.CENTER);

		return panel;
	}

	@Override
	public JMenuBar initbar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {

		JTabbedPane pane = new JTabbedPane();
		ImageIcon Icon = new ImageIcon("icons/home.png");
		ImageIcon Icon1 = new ImageIcon("icons/bilgilendirme.png");

		JPanel AnaPanel = new JPanel(new BorderLayout(3, 3));
		JPanel LogoPanel = new JPanel(new GridLayout(1, 3));

		/* ANAPANEL = LOGOPANEL + GÝRÝÞPANEL */

		JLabel logoJLabel10 = new JLabel();
		LogoPanel.add(logoJLabel10);
		JLabel logoJLabel11 = new JLabel();
		// LogoPanel.add(logoJLabel11);

		JLabel logoJLabel2 = new JLabel();
		Image logo2 = new ImageIcon("icons/logo2.png").getImage();
		logoJLabel2.setIcon(new ImageIcon(logo2));
		LogoPanel.add(logoJLabel2);
		

		JLabel logoJLabel12 = new JLabel();
		LogoPanel.add(logoJLabel12);
		
		
	
		AnaPanel.add(LogoPanel, BorderLayout.NORTH);

		JPanel girisPanel = new JPanel(new GridLayout(3, 2, 10, 10));

		JLabel emailLabel = new JLabel("Personel Adý", JLabel.CENTER);
		girisPanel.add(emailLabel);

		emailBox = new JComboBox(new PersonelDAL().GetAll().toArray());
		girisPanel.add(emailBox);

		JLabel passwordLabel = new JLabel("Þifreniz", JLabel.CENTER);
		girisPanel.add(passwordLabel);

		JPasswordField passwordField = new JPasswordField(15);
		girisPanel.add(passwordField);

		JButton loginButton = new JButton("Otomasyona Giriþ");
		girisPanel.add(loginButton);

		ImageIcon exit = new ImageIcon("icons/iconfinder_icons_exit2_1564506.png");
		JButton iptalButton = new JButton("Çýkýþ", exit);

		iptalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		girisPanel.add(iptalButton);

		AnaPanel.add(girisPanel, BorderLayout.CENTER);

		JPanel AltPanel = new JPanel(new GridLayout(1, 1));

		JLabel AltText1 = new JLabel("");
		AltPanel.add(AltText1);

		JLabel AltText2 = new JLabel("@2022 Tüm haklarý saklýdýr.", JLabel.CENTER);
		AltPanel.add(AltText2);

		JLabel AltText3 = new JLabel("");
		AltPanel.add(AltText3);

		AnaPanel.add(AltPanel, BorderLayout.SOUTH);

		/* Lisans Paneli */

		JPanel LisansPanel = new JPanel(new GridLayout(4, 4, 0, 0));

		JLabel Lisans1 = new JLabel("        Sürüm Bilgisi:         1.03 ");
		LisansPanel.add(Lisans1);
		JLabel Lisans11 = new JLabel("");
		LisansPanel.add(Lisans11);

		JLabel Lisans2 = new JLabel("        Sürüm Tarihi:          09.01.2022");
		LisansPanel.add(Lisans2);
		JLabel Lisans22 = new JLabel("");
		LisansPanel.add(Lisans22);

		JLabel Lisans3 = new JLabel("        Geliþtiriciler:          Berke Güneþ - Selim Savaþ");
		LisansPanel.add(Lisans3);
		JLabel Lisans33 = new JLabel("");
		LisansPanel.add(Lisans33);

		JLabel Lisans4 = new JLabel("        Lisans Sahibi:         SB Yazýlým");
		LisansPanel.add(Lisans4);
		JLabel Lisans44 = new JLabel("");
		LisansPanel.add(Lisans44);
		
		

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonelContract contract = (PersonelContract) emailBox.getSelectedItem();
				String sifre = passwordField.getText();
				if (new YoneticiDAL().GetPersonelIdveSifre(contract.getId(), sifre).getId() != 0) {
					new AnaPencereUI();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Giriþ Baþarýsýz");
				}
				


			}
		});

		pane.addTab(" Ana Sayfa ", Icon, AnaPanel, "Doesn't Nothing");
		pane.addTab(" Lisans ", Icon1, LisansPanel, "Doesn't Nothing");
		
		
		return pane;
	}

}
