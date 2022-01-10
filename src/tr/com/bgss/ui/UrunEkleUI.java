package tr.com.bgss.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;


import tr.com.bgss.contract.KategoriContract;
import tr.com.bgss.contract.UrunlerContract;
import tr.com.bgss.dal.KategoriDAL;
import tr.com.bgss.dal.UrunlerDAL;
import tr.com.bgss.interfaces.uiInterfaces;

public class UrunEkleUI extends JDialog implements uiInterfaces {

	public UrunEkleUI() {

		initPencere();

	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();

		panel.setBorder(BorderFactory.createTitledBorder("Ürün Kayýt Alaný"));
		add(panel);
		setTitle("Ürün Ekleyin");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel()  {

		JPanel panel = new JPanel(new GridLayout(5, 2));
		JLabel adiLabel = new JLabel("Ürünün Adý:", JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		panel.add(adiField);
		JLabel kategoriLabel = new JLabel("Kategori:", JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox = new JComboBox(new KategoriDAL().GetAll().toArray());
		panel.add(kategoriBox);
		JLabel tarihLabel = new JLabel("Tarih:", JLabel.RIGHT);
		panel.add(tarihLabel);
		JDateChooser tarihDate = new JDateChooser();
		panel.add(tarihDate);
		JLabel fiyatLabel = new JLabel("Fiyat:", JLabel.RIGHT);
		panel.add(fiyatLabel);
		JTextField fiyatField = new JTextField(10);
		panel.add(fiyatField);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UrunlerContract contract = new UrunlerContract();
				KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				String date = format.format(tarihDate.getDate());
				contract.setAdi(adiField.getText());
				contract.setKategoriId(casContract.getId());
				contract.setTarih(date); 
				contract.setFiyat(Float.parseFloat(fiyatField.getText()));
				
				new UrunlerDAL().Insert(contract);
				JOptionPane.showMessageDialog(null,
						contract.getAdi() + " " + "adlý ürün baþarýlý bir þekilde eklenmiþtir");
				

			}
		});

		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);

		return panel;
	}

	@Override
	public JMenuBar initbar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
