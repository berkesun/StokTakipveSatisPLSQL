package tr.com.bgss.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import tr.com.bgss.complexcontract.KategoriContractComplex;
import tr.com.bgss.complexcontract.PersonelContractComplex;
import tr.com.bgss.complexcontract.UrunlerContractComplex;
import tr.com.bgss.contract.PersonelContract;
import tr.com.bgss.contract.UrunlerContract;
import tr.com.bgss.dal.PersonelDAL;
import tr.com.bgss.dal.UrunlerDAL;
import tr.com.bgss.interfaces.uiInterfaces;

public class PersonelDuzenleUI extends JDialog implements uiInterfaces {
	
	public static JComboBox personelListBox;

	public PersonelDuzenleUI() {

		initPencere();
	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		add(panel);
		setTitle("Personel Düzenle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Personel Düzenleme Sayfasý"));
		JPanel ustPanel = new JPanel(new GridLayout(6, 3));
		ustPanel.setBorder(BorderFactory.createTitledBorder("Personel Düzenle"));

		JLabel personelList = new JLabel("Personel Listesi:", JLabel.RIGHT);
		ustPanel.add(personelList);
		 personelListBox = new JComboBox(new PersonelDAL().GetAll2().toArray());
		ustPanel.add(personelListBox);
		JLabel idLabel = new JLabel("Personel Id:", JLabel.RIGHT);
		ustPanel.add(idLabel);
		JTextField idField = new JTextField();
		ustPanel.add(idField);
		JLabel adiLabel = new JLabel("Adý Soyadý:", JLabel.RIGHT);
		ustPanel.add(adiLabel);
		JTextField adiField = new JTextField();
		ustPanel.add(adiField);
		JLabel emaiLabel = new JLabel("Email:", JLabel.RIGHT);
		ustPanel.add(emaiLabel);
		JTextField emailField = new JTextField();
		ustPanel.add(emailField);
		JButton duzenleButton = new JButton("Düzenle");
		ustPanel.add(duzenleButton);
		JButton silButton = new JButton("Sil");
		ustPanel.add(silButton);
		
		duzenleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PersonelContract contract = new PersonelContract();
				contract.setAdiSoyadi(adiField.getText());

				contract.setId(Integer.parseInt(idField.getText()));
				// System.out.println(urunAdiBox.getSelectedItem().toString());
				contract.setEmail(emailField.getText());
				// System.out.println(Float.parseFloat(urunFiyatField.getText()));
				
				new PersonelDAL().Update(contract);
				JOptionPane.showMessageDialog(null, "Baþarýlý bir þekilde ürün güncellendi.");
				int satir = personelListBox.getItemCount();
				for (int i = 0; i < satir; i++) {
					personelListBox.removeAllItems();
					}
				
				for (PersonelContractComplex compContract : new PersonelDAL().GetAll2()){
					personelListBox.addItem(compContract.getId() +" "+  compContract.getAdiSoyadi());
					personelListBox.getSelectedIndex();
				}
			}
		});
		
		silButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PersonelContract contract = new PersonelContract();
				contract.setId(Integer.parseInt(idField.getText()));
				new PersonelDAL().Delete(contract);
				JOptionPane.showMessageDialog(null, "Baþarýlý bir þekilde ürün silindi.");
				int satir = personelListBox.getItemCount();
				for (int i = 0; i < satir; i++) {
					personelListBox.removeAllItems();
					}
				
				for (PersonelContractComplex compContract : new PersonelDAL().GetAll2()){
					personelListBox.addItem(compContract.getId() +" "+  compContract.getAdiSoyadi());
					personelListBox.getSelectedIndex();
				}
			}
		});

		panel.add(ustPanel);
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
