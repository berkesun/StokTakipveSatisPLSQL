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

import tr.com.bgss.contract.Yetkiler;
import tr.com.bgss.dal.YetkilerDAL;
import tr.com.bgss.interfaces.uiInterfaces;

public class YetkiEkleUI extends JDialog implements uiInterfaces {

	public YetkiEkleUI() {
		
		initPencere();
	}

	@Override
	public void initPencere() {
		
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Yetki Ekle"));
		add(panel);
		setTitle("Yetki Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new GridLayout(2,2));
		JLabel adiLabel = new JLabel("Yetki Adý",JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(20);
		panel.add(adiField);
		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				Yetkiler contract = new Yetkiler();
				
				contract.setAdi(adiField.getText());
				new YetkilerDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi()+ " adlý yetki baþarýlý bir þekilde eklenmiþtir.");
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
