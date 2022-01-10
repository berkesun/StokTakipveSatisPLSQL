	package tr.com.bgss.ui;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import tr.com.bgss.complexcontract.SatisContractComplex;
import tr.com.bgss.complexcontract.StokContractComplex;
import tr.com.bgss.complexcontract.StokTotalContractComplex;
import tr.com.bgss.contract.MusteriContract;
import tr.com.bgss.contract.PersonelContract;
import tr.com.bgss.contract.SatisContract;
import tr.com.bgss.contract.StokContract;
import tr.com.bgss.contract.UrunlerContract;
import tr.com.bgss.dal.MusteriDAL;
import tr.com.bgss.dal.SatisDAL;
import tr.com.bgss.dal.StokDAL;
import tr.com.bgss.dal.UrunlerDAL;
import tr.com.bgss.dal.YoneticiDAL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import tr.com.bgss.interfaces.uiInterfaces;
import tr.com.bgss.utilities.UstEklentiUI;
import tr.com.bgss.utilities.menulerUI;


public class AnaPencereUI extends JFrame implements uiInterfaces {
	public static JComboBox musteriadiBox;

	public AnaPencereUI() {

		initPencere();
	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		JPanel panell = ustBar();
		
		add(panel,BorderLayout.CENTER);
		add(panell);
		
		setTitle("Stok ve Takip Otomasyonu");
		
		setSize(1200, 900);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	public JPanel ustBar() {
		JPanel panel =UstEklentiUI.UstEklentiUI();
		
		panel.setBounds(0,0,1200,900);
		return panel;
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBounds(250,100,700,650);
		panel.setBackground(null);
		JTabbedPane pane = initTabs();
		
		panel.add(pane,BorderLayout.CENTER);
		return panel;
	}

	@Override
	public JMenuBar initbar() {

		JMenuBar bar = menulerUI.initbar();

		return null;

	}

	@Override
	public JTabbedPane initTabs() {

JTabbedPane pane = new JTabbedPane();
		
		
		ImageIcon Icon = new ImageIcon("icons/home.png");
		ImageIcon Icon1 = new ImageIcon("icons/stock1.png");
		ImageIcon Icon2 = new ImageIcon("icons/shop.png");
		
		JPanel stokPanel = new JPanel(new BorderLayout());
		JPanel satisPanel = new JPanel(new BorderLayout());
		JPanel cikisPanel = new JPanel(new BorderLayout());
		
		
		/* Stok Ýtemleri */
		JPanel stokSolPanel = new JPanel(new BorderLayout());
		
		JPanel stokSolUstPanel = new JPanel(new GridLayout(5, 2));
		JPanel stokSolAltPanel = new JPanel();

		//stokSolPanel.setBorder(BorderFactory.createTitledBorder("Stok Ýþlemleri"));
		
		// Object[] stokKolonlar = { "Id", "Ürün Adý", "Personel Adý", "Adeti", "Tarihi","Toplam" };

		Object[] stokKolonlar = {"urunAdi", "Toplam"};
		DefaultTableModel model = new DefaultTableModel(stokKolonlar, 0);
		
		
		JTable table = new JTable(model);
		JScrollPane stokTablePane = new JScrollPane(table);
		
		
		for (StokContractComplex compContract : new StokDAL().GetAllStok()) {
			model.addRow(compContract.getVeriler());
	
		}

		
		JLabel stokUrunAdiLabel = new JLabel("Ürün Adi:", JLabel.RIGHT);
		stokSolUstPanel.add(stokUrunAdiLabel);
		
		JComboBox stokUrunAdiBox = new JComboBox(new UrunlerDAL().GetAll().toArray());
		stokSolUstPanel.add(stokUrunAdiBox);
		
		JLabel stokAdetLabel = new JLabel("Adet:", JLabel.RIGHT);
		stokSolUstPanel.add(stokAdetLabel);
		
		JTextField stokAdetField = new JTextField(10);
		stokSolUstPanel.add(stokAdetField);
		JLabel stokTarihiLabel = new JLabel("Stok Tarihi:", JLabel.RIGHT);
		stokSolUstPanel.add(stokTarihiLabel);
		JDateChooser stokTarihi = new JDateChooser();

		stokSolUstPanel.add(stokTarihi);
		


		JButton stokEkleButton = new JButton("Stok Ekle");
		stokSolUstPanel.add(stokEkleButton);
		JButton stokYenileButton = new JButton("Yenile");
		stokSolUstPanel.add(stokYenileButton);
		JButton stokTotalButton = new JButton("Stok Toplam Ürün");
		stokSolUstPanel.add(stokTotalButton);
		System.out.println(model.getColumnCount());
		stokTotalButton.addActionListener(new ActionListener() {
		
		

			@Override
			public void actionPerformed(ActionEvent e) {
				int satir = model.getRowCount();
				for (int i = 0; i < satir; i++) {
					model.removeRow(0);
				}
				for (StokContractComplex total : new StokDAL().GetAllStok()) {

					model.addRow(total.getVeriler());
				}
			}
		});
		
		stokYenileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int satir = model.getRowCount();
				for (int i = 0; i < satir; i++) {
					model.removeRow(0);
			 	}
				
				// addRow ve DefaultTableModel mantýðýný öðren
				for (StokContractComplex compContract : new StokDAL().GetAllStok()) {
					model.addRow(compContract.getVeriler());
	
				}

			}
		});
		
		
		stokEkleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StokContract contract = new StokContract();
				UrunlerContract uContract = (UrunlerContract) stokUrunAdiBox.getSelectedItem();
				PersonelContract pContract = (PersonelContract) LoginUI.emailBox.getSelectedItem();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(stokTarihi.getDate());

				contract.setPersonelId(pContract.getId());
				contract.setUrunId(uContract.getId());
				contract.setTarih(date.toString());
				contract.setAdet(Integer.parseInt(stokAdetField.getText()));
				new StokDAL().Insert(contract);

				JOptionPane.showMessageDialog(null, uContract.getAdi() + " adlý ürün eklenmiþtir");
				
				int satir = model.getRowCount();
				for (int i = 0; i < satir; i++) {
					model.removeRow(0);
				}
				for (StokContractComplex compContract : new StokDAL().GetAllStok()) {
					model.addRow(compContract.getVeriler());
				}
			}
		});
		System.out.println("19");
		/* Satýþ Ýtemleri */
		JPanel satisSagPanel = new JPanel(new BorderLayout());
		JPanel satisSagUstPanel = new JPanel(new GridLayout(5, 2));
		JPanel satisSagAltPanel = new JPanel();
		// Object[] satisKolonlar = { "Id", "Müþteri Adý", "Personel Adý", "Ürün Adý", "Adeti", "Tarihi" };
		Object[] satisKolonlar = { "urunAdi", "Toplam"};
		DefaultTableModel satisModel = new DefaultTableModel(satisKolonlar, 0);
		JTable satisTable = new JTable(satisModel);
		JScrollPane satisTablePane = new JScrollPane(satisTable);
		JLabel musteriLabel = new JLabel("Müþteri Adý", JLabel.RIGHT);
		satisSagUstPanel.add(musteriLabel);
		JComboBox musteriAdiBox = new JComboBox(new MusteriDAL().GetAll().toArray());
		satisSagUstPanel.add(musteriAdiBox);
		JLabel satisUrunAdiLabel = new JLabel("Ürün Adi:", JLabel.RIGHT);
		satisSagUstPanel.add(satisUrunAdiLabel);
		JComboBox satisUrunAdiBox = new JComboBox(new UrunlerDAL().GetAll().toArray());
		satisSagUstPanel.add(satisUrunAdiBox);
		JLabel satisAdetLabel = new JLabel("Adet:", JLabel.RIGHT);
		satisSagUstPanel.add(satisAdetLabel);
		JTextField satisAdetField = new JTextField(10);
		satisSagUstPanel.add(satisAdetField);
		JLabel satisTarihiLabel = new JLabel("Satýþ Tarihi:", JLabel.RIGHT);
		satisSagUstPanel.add(satisTarihiLabel);
		JDateChooser satisTarihi = new JDateChooser();

		satisSagUstPanel.add(satisTarihi);
		for (SatisContractComplex yenileContract : new SatisDAL().GetAllSatis()) {
			satisModel.addRow(yenileContract.getVeriler());
		}
		JButton satisEkleButton = new JButton("Satýþ Yap");
		satisSagUstPanel.add(satisEkleButton);
		for (SatisContractComplex yenileContract : new SatisDAL().GetAllSatis()) {
			satisModel.addRow(yenileContract.getVeriler());
		}
		satisEkleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PersonelContract pContract = (PersonelContract) LoginUI.emailBox.getSelectedItem();
				UrunlerContract uContract = (UrunlerContract) satisUrunAdiBox.getSelectedItem();
				MusteriContract mContract = (MusteriContract) musteriAdiBox.getSelectedItem();
				SatisContract contract = new SatisContract();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(satisTarihi.getDate());

				contract.setMusteriId(mContract.getId());
				contract.setPersonelId(pContract.getId());
				contract.setUrunId(uContract.getId());
				contract.setAdet(Integer.parseInt(satisAdetField.getText()));
				contract.setTarih(date);

				new SatisDAL().Insert(contract);
				StokContract stokContract = new StokContract();
				stokContract.setPersonelId(pContract.getId());
				stokContract.setUrunId(uContract.getId());
				stokContract.setAdet(-Integer.parseInt(satisAdetField.getText()));
				stokContract.setTarih(date);
				new StokDAL().Insert(stokContract);
				JOptionPane.showMessageDialog(null,
						mContract.getAdiSoyadi() + " adli kullanýcýya satýþ gerçekleþtirilmiþtir ve "
								+ uContract.getAdi() + " adlý ürün stokta " + contract.getAdet()
								+ " adet eksiltilmiþtir");
				int satir = satisModel.getRowCount();
				for (int i = 0; i < satir; i++) {
					satisModel.removeRow(0);
				}
				for (SatisContractComplex compContract : new SatisDAL().GetAllSatis()) {
					model.addRow(compContract.getVeriler());
			
				}
				
			}
		});

		JButton satisYenileButton = new JButton("Yenile");
		satisSagUstPanel.add(satisYenileButton);
		satisYenileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int satir = satisModel.getRowCount();
				for (int i = 0; i < satir; i++) {
					satisModel.removeRow(0);
				}/*
				for (SatisContractComplex compContract : new SatisDAL().GetAllSatis()) {
					model.addRow(compContract.getVeriler());
			
				}*/

			}
		});
		// Müþteri Menüsü
		
		JPanel musteriPanel = new JPanel(new GridLayout(6,2,1,2));
		JPanel musteriPanel2 = new JPanel(new GridLayout(1, 2));
		
		//musteriPanel.setBorder(BorderFactory.createTitledBorder("Müþteri Bölümü"));
		
		ImageIcon mekle = new ImageIcon("icons/iconfinder_add_user_309049.png");
		JButton MEkleItem = new JButton("Müþteri Ekle",mekle);
		musteriPanel2.add(MEkleItem);
		MEkleItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new MusteriEkleUI();
					}
				});

			}
		});
		ImageIcon mduzenle = new ImageIcon("icons/iconfinder_user_profile_edit_103781.png");
		JButton MDuzenleItem = new JButton("Müþteri Düzenle",mduzenle);
		musteriPanel2.add(MDuzenleItem);
		
		MDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MusteriDuzenleUI();

			}
		});
		
		
		/* Ürün Menüsü */
		JPanel urunPanel = new JPanel(new GridLayout(1, 2));

		//urunPanel.setBorder(BorderFactory.createTitledBorder("Ürün Bölümü"));
		
		ImageIcon uekle = new ImageIcon("icons/iconfinder_price-tag_1291777.png");
		JButton UEkleItem = new JButton("Ürün Ekle",uekle);
		urunPanel.add(UEkleItem);
		UEkleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new UrunEkleUI();
					}
				});

			}
		});
		
		ImageIcon uduzenle = new ImageIcon("icons/iconfinder_Simple_Business-06_5288410.png");
		JButton UDuzenleItem = new JButton("Ürün Düzenle",uduzenle);
		urunPanel.add(UDuzenleItem);
		UDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UrunDuzenleUI();

			}
		});
		
		
		
		/* Kategori Menüsü */
		JPanel kategoriPanel = new JPanel(new GridLayout(1, 2));
		//urunPanel.setBorder(BorderFactory.createTitledBorder("Ürün Bölümü"));
		
		ImageIcon kekle = new ImageIcon("icons/iconfinder_category_add_103433.png");
		JButton KEkleItem = new JButton("Kategori Ekle",kekle);
		kategoriPanel.add(KEkleItem);
		KEkleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new KategoriEkleUI();

			}
		});
		ImageIcon kduzenle = new ImageIcon("icons/iconfinder_category_add_103433.png");
		JButton KDuzenleItem = new JButton("Kategori Düzenle",kduzenle);
		kategoriPanel.add(KDuzenleItem);
		KDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new KategoriDuzenleUI();

			}
		});
		
		/* Çýkýþ Menüsü */
		JPanel cikissolPanel = new JPanel(new GridLayout(1,2));
		

		//cikissolPanel.setBorder(BorderFactory.createTitledBorder("Çýkýþ Bölümü"));
		
		ImageIcon exit = new ImageIcon("icons/iconfinder_icons_exit2_1564506.png");
		JButton cikisItem = new JButton("Çýkýþ",exit);
		cikissolPanel.add(cikisItem);
		cikisItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		

		
		/* Personeller Menüsü */
		JPanel personellerPanel1 = new JPanel(new GridLayout(1,2));
		
		ImageIcon pekle = new ImageIcon("icons/iconfinder_68_work_Efficiency_gear_human_personal_profile_user_4308167.png");
		JButton pEkleItem = new JButton("Personel Ekle",pekle);
		personellerPanel1.add(pEkleItem);
		pEkleItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new PersonelEkleUI();
					}
				});

			}
		});
		
		ImageIcon yetki = new ImageIcon("icons/iconfinder_person__rank__employee__ranking__user__man__comments_2528018.png");
		JButton yetkiEkleItem = new JButton("Yetki Ekle",yetki);
		personellerPanel1.add(yetkiEkleItem);
		yetkiEkleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new YetkiEkleUI();
					}
				});
			}
		});
		
		
		JPanel personellerPanel2 = new JPanel(new GridLayout(1,2));
		
		ImageIcon sifre = new ImageIcon("icons/iconfinder_Programming_Development_keywords_1743798.png");
		JButton sifreBelirleItem = new JButton("Þifre Belirleme",sifre);
		personellerPanel2.add(sifreBelirleItem);
		sifreBelirleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new SifreIslemleriUI();

			}
		});
		ImageIcon pduzenle = new ImageIcon("icons/iconfinder_manage-account-profile-personal-submit_3802014.png");
		JButton personelDuzenleItem = new JButton("Personel Düzenle",pduzenle);
		personellerPanel2.add(personelDuzenleItem);
		personelDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PersonelDuzenleUI();

			}
		});
		
		
		PersonelContract contract = (PersonelContract) LoginUI.emailBox.getSelectedItem();

		if (new YoneticiDAL().GetYetkiId(contract.getId()).getYetkiId() == 2) {
			personellerPanel2.hide();
		} else if (new YoneticiDAL().GetYetkiId(contract.getId()).getYetkiId() == 3) {
			musteriPanel2.hide();
			personellerPanel2.hide();
			urunPanel.hide();
			kategoriPanel.hide();
		}
		
		PersonelContract contract2 = (PersonelContract) LoginUI.emailBox.getSelectedItem();

		if (new YoneticiDAL().GetYetkiId(contract2.getId()).getYetkiId() == 2) {
			personellerPanel1.hide();
		} else if (new YoneticiDAL().GetYetkiId(contract2.getId()).getYetkiId() == 3) {
			musteriPanel2.hide();
			personellerPanel1.hide();
			urunPanel.hide();
			kategoriPanel.hide();
		}
		
		/*
		JPanel USTPANEL = new JPanel(new GridLayout(1,3));
		JLabel logoJLabel1= new JLabel();
		JLabel logoJLabel2= new JLabel();
		Image logo = new ImageIcon("").getImage();
		logoJLabel2.setIcon(new ImageIcon(logo));
		JLabel logoJLabel3= new JLabel();
		USTPANEL.add(logoJLabel1);
		USTPANEL.add(logoJLabel2);
		USTPANEL.add(logoJLabel3);
	
		musteriPanel.add(USTPANEL);
		*/
		musteriPanel.add(personellerPanel1);
		musteriPanel.add(personellerPanel2);
		musteriPanel.add(kategoriPanel);
		musteriPanel.add(musteriPanel2);
		musteriPanel.add(urunPanel);
		musteriPanel.add(cikissolPanel);
		
		stokPanel.add(stokSolPanel, BorderLayout.WEST);
		stokPanel.add(stokTablePane, BorderLayout.CENTER);
		satisPanel.add(satisSagPanel, BorderLayout.CENTER);
		//satisPanel.add(satisTablePane, BorderLayout.CENTER);
		satisSagPanel.add(satisSagUstPanel, BorderLayout.NORTH);
		satisSagPanel.add(satisSagAltPanel, BorderLayout.SOUTH);

		stokSolPanel.add(stokSolUstPanel, BorderLayout.NORTH);
		stokSolPanel.add(stokSolAltPanel, BorderLayout.SOUTH);
		
		pane.addTab(" Ana Bölüm ",Icon, musteriPanel, "Doesn't Nothing");
		pane.addTab(" Stok Ýþlemleri ", Icon1, stokPanel, "Doesn't Nothing");
		pane.addTab(" Satýþ Ýþlemleri", Icon2, satisPanel, "Doesn't Nothing");
		
		return pane;

	}

}