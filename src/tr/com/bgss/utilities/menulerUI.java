package tr.com.bgss.utilities;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import tr.com.bgss.contract.PersonelContract;
import tr.com.bgss.dal.YoneticiDAL;
import tr.com.bgss.ui.KategoriDuzenleUI;
import tr.com.bgss.ui.KategoriEkleUI;
import tr.com.bgss.ui.LoginUI;
import tr.com.bgss.ui.MusteriEkleUI;
import tr.com.bgss.ui.PersonelDuzenleUI;
import tr.com.bgss.ui.PersonelEkleUI;
import tr.com.bgss.ui.SifreIslemleriUI;
import tr.com.bgss.ui.UrunDuzenleUI;
import tr.com.bgss.ui.UrunEkleUI;
import tr.com.bgss.ui.YetkiEkleUI;

public class menulerUI {
	
public	static JMenuBar initbar() {
		
	
		JMenuBar bar = new JMenuBar();
		
		
		JMenu dosyaMenu = new JMenu("Dosya");
		bar.add(dosyaMenu);
		JMenuItem cikisItem = new JMenuItem("Çýkýþ");
		dosyaMenu.add(cikisItem);
		cikisItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		/*Urunler Menusu*/
		JMenu urunlerMenu = new JMenu("Ürünler");
		bar.add(urunlerMenu);
		JMenuItem urunEkleItem = new JMenuItem("Ürün Ekle");
		urunlerMenu.add(urunEkleItem);
		JMenuItem kategoriEkleItem = new JMenuItem("Kategori Ekle");
		urunlerMenu.add(kategoriEkleItem);
		urunlerMenu.addSeparator();
		JMenuItem urunDuzenleItem = new JMenuItem("Ürünü Düzenle");
		urunlerMenu.add(urunDuzenleItem);
		JMenuItem kategoriDuzenleItem = new JMenuItem("Kategori Düzenle");
		urunlerMenu.add(kategoriDuzenleItem);
		
		/*Personel Menusu*/
		JMenu personellerMenu = new JMenu("Personel Ýþlemleri");
		bar.add(personellerMenu);
		JMenuItem personelEkleItem = new JMenuItem("Personel Ekle");
		personellerMenu.add(personelEkleItem);
		JMenuItem yetkiEkleItem = new JMenuItem("Yetki Ekle");
		personellerMenu.add(yetkiEkleItem);
		JMenuItem sifreBelirleItem = new JMenuItem("Þifre Belirleme");
		personellerMenu.add(sifreBelirleItem);
		personellerMenu.addSeparator();
		JMenuItem personelDuzenItem = new JMenuItem("Personel Düzenle");
		personellerMenu.add(personelDuzenItem);
		JMenuItem yetkiDuzenlItem = new JMenuItem("Yetki Düzenle");
		personellerMenu.add(yetkiDuzenlItem);
		JMenuItem sifreDuzenleItem = new JMenuItem("Þifre Düzenle");
		personellerMenu.add(sifreDuzenleItem);
		
		/*Müþteri Menüsü*/
		JMenu musterilerMenu = new JMenu("Müþteriler");
		bar.add(musterilerMenu);
		JMenuItem musteriEkleItem = new JMenuItem("Müþteri Ekle");
		musterilerMenu.add(musteriEkleItem);
		musterilerMenu.addSeparator();
		JMenuItem musteriDuzenleItem = new JMenuItem("Müþteri Düzenle");
		musterilerMenu.add(musteriDuzenleItem);
		
		PersonelContract contract = (PersonelContract) LoginUI.emailBox.getSelectedItem();
		if(new YoneticiDAL().GetYetkiId(contract.getId()).getYetkiId()==2) {
			
			personellerMenu.hide();
			urunlerMenu.hide();
		}
		
		
		
		
		
		
		urunEkleItem.addActionListener(new ActionListener() {
			
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
		
		urunDuzenleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {	
						
						new UrunDuzenleUI();
					}
				});
			}
		});
		
		kategoriEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new KategoriEkleUI();
						
						
					
						
					}
				});
				
			}
		});
		
		kategoriDuzenleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new KategoriDuzenleUI();
					}
				});
			}
		});
		
		personelEkleItem.addActionListener(new ActionListener() {
			
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
		
		personelDuzenItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PersonelDuzenleUI();
				
			}
		});
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
		
		sifreBelirleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new SifreIslemleriUI();
			}
		});
		
		musteriEkleItem.addActionListener(new ActionListener() {
			
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
		
		
		return bar;
	}

}
