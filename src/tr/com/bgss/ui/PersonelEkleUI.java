package tr.com.bgss.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.bgss.contract.PersonelContract;
import tr.com.bgss.dal.PersonelDAL;
import tr.com.bgss.interfaces.uiInterfaces;

public class PersonelEkleUI extends JDialog implements uiInterfaces {

	public PersonelEkleUI() {

		initPencere();
	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Personel Ekle"));
		add(panel);

		setTitle("Personel Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(3, 2));

		JLabel adisoyadiLabel = new JLabel("Adý Soyadý:", JLabel.RIGHT);
		panel.add(adisoyadiLabel);
		JTextField adisoyadiField = new JTextField(20);
		panel.add(adisoyadiField);
		JLabel emailLabel = new JLabel("Email:", JLabel.RIGHT);
		panel.add(emailLabel);
		JTextField emailField = new JTextField(20);
		panel.add(emailField);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				PersonelContract contract = new PersonelContract();
				contract.setAdiSoyadi(adisoyadiField.getText());
				contract.setEmail(emailField.getText());
				
				
				new PersonelDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdiSoyadi()+" adlý personel eklenmiþtir.");
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
