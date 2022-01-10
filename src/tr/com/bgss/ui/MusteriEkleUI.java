package tr.com.bgss.ui;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



import tr.com.bgss.contract.MusteriContract;
import tr.com.bgss.contract.PersonelContract;
import tr.com.bgss.dal.MusteriDAL;
import tr.com.bgss.interfaces.uiInterfaces;

public class MusteriEkleUI extends JDialog implements uiInterfaces {

	public MusteriEkleUI() {

		initPencere();
	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Müþteri Ekle"));
		add(panel);
		setTitle("Müþteri Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new BorderLayout());
		JPanel fieldPanel = new JPanel(new GridLayout(5, 2));
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		JLabel adisoyadiLabel = new JLabel("Adý Soyadý:", JLabel.LEFT);
		fieldPanel.add(adisoyadiLabel);
		JTextField adisoyadiField = new JTextField(20);
		fieldPanel.add(adisoyadiField);
		JLabel telefonLabel = new JLabel("Telefon:", JLabel.LEFT);
		fieldPanel.add(telefonLabel);
		JTextField telefonField = new JTextField(20);
		fieldPanel.add(telefonField);
		JLabel adresLabel = new JLabel("");
		fieldPanel.add(adresLabel);

		JTextArea adresArea = new JTextArea(7,1);
		JScrollPane pane = new JScrollPane(adresArea);
		pane.setBorder(BorderFactory.createTitledBorder("Adres Bilgisi"));
		
		JButton kaydetButton = new JButton("Kaydet");
		buttonPanel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal");
		buttonPanel.add(iptalButton);

		panel.add(fieldPanel, BorderLayout.NORTH);
		panel.add(pane, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MusteriContract contract = new MusteriContract();
				contract.setAdiSoyadi(adisoyadiField.getText());
				contract.setTelefon(telefonField.getText());
				contract.setAdres(adresArea.getText());
				
				new MusteriDAL().Insert(contract);
				JOptionPane.showMessageDialog(null,contract.getAdiSoyadi()+" adlý müþteri baþarýyla eklenmiþtir.");
				
				
				int satir = AnaPencereUI.musteriadiBox.getItemCount();
				for (int i = 0; i < satir; i++) {
					AnaPencereUI.musteriadiBox.removeAllItems();
					}
				
				for (MusteriContract compContract : new MusteriDAL().GetAll()){
					AnaPencereUI.musteriadiBox.getSelectedItem();
					AnaPencereUI.musteriadiBox.addItem(compContract.getAdiSoyadi());
					
				}
				
				
					
				
				
				
			}
		});

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
