package tr.com.bgss.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


import tr.com.bgss.contract.KategoriContract;
import tr.com.bgss.dal.KategoriDAL;
import tr.com.bgss.interfaces.uiInterfaces;

public class KategoriEkleUI extends JDialog implements uiInterfaces {

	public KategoriEkleUI() {
		initPencere();

	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Kategori Ekle"));

		add(panel);
		setTitle("Kategori Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(3, 2));

		JLabel adiLabel = new JLabel("Kategori Adý:", JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(20);
		panel.add(adiField);
		JLabel kategoriLabel = new JLabel("Kategori Seç:", JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox = new JComboBox(new KategoriDAL().GetAllParentId().toArray());
		panel.add(kategoriBox);
		kategoriBox.insertItemAt("--Kategori Seçiniz--", 0);
		kategoriBox.setSelectedIndex(0);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KategoriContract contract = new KategoriContract();
				
				if(kategoriBox.getSelectedIndex() != 0) {
					
					KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();
					contract.setAdi(adiField.getText());
					contract.setParentId(casContract.getId());
					
					new KategoriDAL().Insert(contract);
					JOptionPane.showMessageDialog(null,contract.getAdi()+" "+"adlý kategori baþarýlý bir þekilde eklendi!");
				}else {
					contract.setAdi(adiField.getText());
					contract.setParentId(kategoriBox.getSelectedIndex());
					
					new KategoriDAL().Insert(contract);
					JOptionPane.showMessageDialog(null,contract.getAdi()+" "+"adlý kategori baþarýlý bir þekilde eklendi!");
					//kategoriBox.addItem(new KategoriDAL().GetAllParentId());
					
				}
				
				
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
