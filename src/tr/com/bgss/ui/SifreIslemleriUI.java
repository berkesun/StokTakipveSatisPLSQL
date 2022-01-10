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
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import tr.com.bgss.contract.PersonelContract;
import tr.com.bgss.contract.Yetkiler;
import tr.com.bgss.contract.YoneticiContract;
import tr.com.bgss.dal.PersonelDAL;
import tr.com.bgss.dal.YetkilerDAL;
import tr.com.bgss.dal.YoneticiDAL;
import tr.com.bgss.interfaces.uiInterfaces;

public class SifreIslemleriUI extends JDialog implements uiInterfaces {

	public SifreIslemleriUI() {
		initPencere();

	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Þifre Belirleme Ýþlemleri"));

		add(panel);
		setTitle("Þifre Belirleme Ýþlemleri");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(5, 2));
		JLabel personelLabel = new JLabel("Personel Seç:", JLabel.RIGHT);
		panel.add(personelLabel);
		JComboBox personelBox = new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(personelBox);
		JLabel yetkiLabel = new JLabel("Yetki Seç:", JLabel.RIGHT);
		panel.add(yetkiLabel);
		JComboBox yetkiBox = new JComboBox(new YetkilerDAL().GetAll().toArray());
		panel.add(yetkiBox);
		JLabel passLabel = new JLabel("Þifre Belirleme:", JLabel.RIGHT);
		panel.add(passLabel);
		JPasswordField passField = new JPasswordField(10);
		panel.add(passField);
		JLabel passtekrarLabel = new JLabel("Þifre Tekrar:", JLabel.RIGHT);
		panel.add(passtekrarLabel);
		JPasswordField passTekrar = new JPasswordField(10);
		panel.add(passTekrar);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);

		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				YoneticiContract contract = new YoneticiContract();
				PersonelContract pContract = (PersonelContract) personelBox.getSelectedItem();
				Yetkiler yContract = (Yetkiler) yetkiBox.getSelectedItem();

				if (passField.getText().equals(passTekrar.getText())) {

					contract.setPersonelId(pContract.getId());
					contract.setYetkiId(yContract.getId());
					contract.setSifre(passField.getText());

					new YoneticiDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, pContract.getAdiSoyadi() + " adlý kiþiye " + yContract.getAdi()
							+ " yetkisi baþarýlý bir þekilde eklenmiþtir.");

				} else {

					JOptionPane.showMessageDialog(null, "Þifreler uyuþmuyor.Tekrar deneyiniz.");
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
