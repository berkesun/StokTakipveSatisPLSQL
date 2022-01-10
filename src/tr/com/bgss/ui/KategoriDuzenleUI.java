package tr.com.bgss.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.bgss.complexcontract.KategoriContractComplex;
import tr.com.bgss.complexcontract.UrunlerContractComplex;
import tr.com.bgss.contract.KategoriContract;
import tr.com.bgss.contract.UrunlerContract;
import tr.com.bgss.dal.KategoriDAL;
import tr.com.bgss.dal.UrunlerDAL;
import tr.com.bgss.interfaces.uiInterfaces;

public class KategoriDuzenleUI extends JDialog implements uiInterfaces {
	public static JComboBox ustkategoriBox;
	public static JList kategoriList;
	
	
    public KategoriDuzenleUI() {
		
		initPencere();
		
	}

	@Override
	public void initPencere() {
		
		JPanel panel = initPanel();
		add(panel);
		setTitle("Kategori Düzenle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Düzenleme Ýþlemleri"));
		JPanel ustPanel = new JPanel(new GridLayout(5,2));
		ustPanel.setBorder(BorderFactory.createTitledBorder("Kategoriyi Düzenle"));
		JLabel kategoriadiLabel = new JLabel("Kategori Arama:",JLabel.RIGHT);
		ustPanel.add(kategoriadiLabel);
		JTextField kategoriadiField = new JTextField(10);
		ustPanel.add(kategoriadiField);
		JLabel ustkategoriLabel = new JLabel("Üst Kategorisi:",JLabel.RIGHT);
		ustPanel.add(ustkategoriLabel);
		 ustkategoriBox = new JComboBox(new KategoriDAL().GetAll2().toArray());
		ustPanel.add(ustkategoriBox);
		JLabel urunIdLabel = new JLabel("Ürün Id:",JLabel.RIGHT);
		ustPanel.add(urunIdLabel);
		JTextField urunIdField = new JTextField();
		ustPanel.add(urunIdField);
		
		JLabel yeniAdLabel = new JLabel("Yeni Kategori Adý:",JLabel.RIGHT);
		ustPanel.add(yeniAdLabel);
		JTextField yeniAdField = new JTextField();
		ustPanel.add(yeniAdField);
		JButton duzenleButton = new JButton("Düzenle");
		ustPanel.add(duzenleButton);
		JButton silButton = new JButton("Sil");
		ustPanel.add(silButton);
		
		
		
		
		 kategoriList = new JList();
		kategoriList.setListData(new KategoriDAL().GetAll().toArray());
		JScrollPane pane = new JScrollPane(kategoriList);
		ustPanel.setBorder(BorderFactory.createTitledBorder("Düzenlenecek Liste"));
		kategoriList.setSelectedIndex(0);
		panel.add(ustPanel,BorderLayout.NORTH);
		panel.add(pane,BorderLayout.CENTER);
		
		duzenleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				KategoriContract contract = new KategoriContract();
				contract.setAdi(yeniAdField.getText());
				contract.setId(Integer.parseInt(urunIdField.getText()));
				new KategoriDAL().Update(contract);
				JOptionPane.showMessageDialog(null, "Baþarýlý bir þekilde kategori güncellendi.");
				int satir = ustkategoriBox.getItemCount();
				for (int i = 0; i < satir; i++) {
					ustkategoriBox.removeAllItems();
					}
				
				for (KategoriContractComplex compContract : new KategoriDAL().GetAll2()){
					ustkategoriBox.addItem(compContract.getId() +" "+  compContract.getAdi());
					ustkategoriBox.getSelectedIndex();
					
				}
				int satir2 = kategoriList.getVisibleRowCount();
				for (int i = 0; i < satir; i++) {
					kategoriList.removeAll();
					}
				
				kategoriList.setListData(new KategoriDAL().GetAll().toArray());

			}
		});
		
		silButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				KategoriContract contract = new KategoriContract();
				contract.setId(Integer.parseInt(urunIdField.getText()));
				new KategoriDAL().Delete(contract);
				JOptionPane.showMessageDialog(null, "Baþarýlý bir þekilde ürün Silindi.");
				int satir = ustkategoriBox.getItemCount();
				for (int i = 0; i < satir; i++) {
					ustkategoriBox.removeAllItems();
					}
				
				for (KategoriContractComplex compContract : new KategoriDAL().GetAll2()){
					ustkategoriBox.addItem(compContract.getId() +" "+  compContract.getAdi());
					ustkategoriBox.getSelectedIndex();
				}
				int satir2 = kategoriList.getVisibleRowCount();
				for (int i = 0; i < satir; i++) {
					kategoriList.removeAll();
					}
				
				kategoriList.setListData(new KategoriDAL().GetAll().toArray());
				
			}
		});
		
		kategoriadiField.addKeyListener(new KeyListener() {
			 
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				kategoriList.setListData(new KategoriDAL().GetSearchKategori(kategoriadiField.getText()).toArray());
				kategoriList.setSelectedIndex(0);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
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
