package tr.com.bgss.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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

import tr.com.bgss.complexcontract.MusteriContractComplex;
import tr.com.bgss.complexcontract.PersonelContractComplex;
import tr.com.bgss.contract.MusteriContract;
import tr.com.bgss.contract.PersonelContract;
import tr.com.bgss.dal.MusteriDAL;
import tr.com.bgss.dal.PersonelDAL;
import tr.com.bgss.interfaces.uiInterfaces;


public class MusteriDuzenleUI extends JDialog implements uiInterfaces {
	public static JComboBox musterilistBox;
	
	public MusteriDuzenleUI()
	{
		initPencere();
	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		add(panel);
		setTitle("Müþteri Düzenle");
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
		panel.setBorder(BorderFactory.createTitledBorder("Müþteri Düzenleme Sayfasý"));
		JPanel ustPanel = new JPanel(new GridLayout(6, 3));
		ustPanel.setBorder(BorderFactory.createTitledBorder("Müþteri Düzenle"));
		
		JLabel musterilistLabel = new JLabel("Müþteri Listesi",JLabel.RIGHT);
		fieldPanel.add(musterilistLabel);
		musterilistBox = new JComboBox(new MusteriDAL().GetAll2().toArray());
		fieldPanel.add(musterilistBox);
		JLabel idLabel = new JLabel("Müþteri Id:",JLabel.RIGHT);
		fieldPanel.add(idLabel);
		JTextField idField = new JTextField();
		fieldPanel.add(idField);
		JLabel adisoyadiLabel = new JLabel("Adý Soyadý:", JLabel.RIGHT);
		fieldPanel.add(adisoyadiLabel);
		JTextField adisoyadiField = new JTextField(20);
		fieldPanel.add(adisoyadiField);
		JLabel telefonLabel = new JLabel("Telefon:", JLabel.RIGHT);
		fieldPanel.add(telefonLabel);
		JTextField telefonField = new JTextField(20);
		fieldPanel.add(telefonField);
		JLabel adresLabel = new JLabel("");
		fieldPanel.add(adresLabel);

		JTextArea adresArea = new JTextArea(7,1);
		JScrollPane pane = new JScrollPane(adresArea);
		pane.setBorder(BorderFactory.createTitledBorder("Adres Bilgisi"));
		
		JButton duzenleButton = new JButton("Düzenle");
		buttonPanel.add(duzenleButton);
		JButton silButton = new JButton("Sil");
		buttonPanel.add(silButton);
		
		panel.add(fieldPanel, BorderLayout.NORTH);
		panel.add(pane, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		
		duzenleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MusteriContract contract = new MusteriContract();
				contract.setAdiSoyadi(adisoyadiField.getText());

				contract.setId(Integer.parseInt(idField.getText()));
				// System.out.println(urunAdiBox.getSelectedItem().toString());
				contract.setAdiSoyadi(adisoyadiField.getText());
				contract.setTelefon(telefonField.getText());
				// System.out.println(Float.parseFloat(urunFiyatField.getText()));
				contract.setAdres(adresArea.getText());
				
				new MusteriDAL().Update(contract);
				JOptionPane.showMessageDialog(null, "Baþarýlý bir þekilde ürün güncellendi.");
				int satir = musterilistBox.getItemCount();
				for (int i = 0; i < satir; i++) {
					musterilistBox.removeAllItems();
					}
				
				for (MusteriContractComplex compContract : new MusteriDAL().GetAll2()){
					musterilistBox.addItem(compContract.getId() +" "+  compContract.getAdiSoyadi());
					musterilistBox.getSelectedIndex();
				}
			}
		});
		
		silButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				MusteriContract contract = new MusteriContract();
				contract.setId(Integer.parseInt(idField.getText()));
				new MusteriDAL().Delete(contract);
				JOptionPane.showMessageDialog(null, "Baþarýlý bir þekilde ürün silindi.");
				int satir = musterilistBox.getItemCount();
				for (int i = 0; i < satir; i++) {
					musterilistBox.removeAllItems();
					}
				
				for (MusteriContractComplex compContract : new MusteriDAL().GetAll2()){
					musterilistBox.addItem(compContract.getId() +" "+  compContract.getAdiSoyadi());
					musterilistBox.getSelectedIndex();
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
