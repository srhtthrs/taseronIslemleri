package PersonelUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import PersonelDataBase.DataBaseConn;
import PersonelDomain.AyrilisDomain;
import PersonelDomain.BaslayisDomain;
import PersonelDomain.DisiplinDomain;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import java.awt.Rectangle;
import java.awt.Component;

public class disiplin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAdSoyad;
	private JTextField textFieldTarih;
	private JTextField textFieldSayi;
	private JTextField textFieldAraIsim;
	static DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					disiplin frame = new disiplin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public disiplin() {
		
		
		
		setTitle("Disiplin Islemleri");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 718);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 418, 658);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel labelMudurluk = new JLabel("");
		labelMudurluk.setForeground(new Color(255, 255, 255));
		labelMudurluk.setBounds(10, 264, 396, 21);
		panel.add(labelMudurluk);
		
		textFieldAdSoyad = new JTextField();
		textFieldAdSoyad.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldAdSoyad.setForeground(new Color(128, 0, 0));
		textFieldAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldAdSoyad.setBackground(SystemColor.info);
		textFieldAdSoyad.setBounds(10, 43, 396, 43);
		panel.add(textFieldAdSoyad);
		textFieldAdSoyad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ad Soyad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 396, 21);
		panel.add(lblNewLabel);
		
		textFieldTarih = new JTextField();
		textFieldTarih.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldTarih.setForeground(new Color(128, 0, 0));
		textFieldTarih.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTarih.setColumns(10);
		textFieldTarih.setBackground(SystemColor.info);
		textFieldTarih.setBounds(10, 124, 192, 43);
		panel.add(textFieldTarih);
		
		JLabel lblTarih = new JLabel("Yazi Tarih:");
		lblTarih.setForeground(Color.WHITE);
		lblTarih.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTarih.setBounds(10, 92, 182, 21);
		panel.add(lblTarih);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(438, 11, 634, 658);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 614, 219);
		panel_1.add(scrollPane);
		
		

		
		
		

		
		
		
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setForeground(new Color(128, 0, 0));
		list.setFont(new Font("Tahoma", Font.BOLD, 14));
		list.setBackground(SystemColor.info);
		
		
		
	
		
		
		
		
		list.setListData(disiplinListele().toArray());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		textFieldAraIsim = new JTextField();
		textFieldAraIsim.setBounds(192, 12, 432, 41);
		textFieldAraIsim.setForeground(new Color(128, 0, 0));
		textFieldAraIsim.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldAraIsim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					
					textFieldAraIsim.setText("");
				
			}
			else {
				
				list.setListData(disiplinAra(textFieldAraIsim.getText().toString().toUpperCase()).toArray());
				
			
				table.setModel(disiplinBulDefaultTableModel(textFieldAraIsim.getText().toString()));
				
			}
				
				
			}
		});
		textFieldAraIsim.setBackground(SystemColor.info);
		panel_1.add(textFieldAraIsim);
		textFieldAraIsim.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" Isim:");
		lblNewLabel_1.setBounds(102, 17, 69, 32);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(lblNewLabel_1);
		
		
		Icon search=new ImageIcon("ikonlar/search.jpg");
		JLabel lblNewLabel_2 = new JLabel(search);
		lblNewLabel_2.setBounds(10, 11, 78, 41);
		panel_1.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane_1.setBounds(10, 293, 614, 354);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setGridColor(SystemColor.activeCaption);
		table.setBackground(SystemColor.info);
		scrollPane_1.setViewportView(table);
		
		
		setLocationRelativeTo(null); 
		
		JLabel lblSayi = new JLabel("EBYS Sayi:");
		lblSayi.setForeground(Color.WHITE);
		lblSayi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSayi.setBounds(224, 92, 182, 21);
		panel.add(lblSayi);
		
		String [] mudurluk = {"DİĞER",
				"15 TEMMUZ ŞEHİTLER PTT MÜDÜRLÜĞÜ",
				"150.YIL ANADOLU YAKASI POSTA İŞLEME MÜDÜRLÜĞÜ",
				"50.YIL PTT MÜDÜRLÜĞÜ",
				"ACIBADEM KARGO DAĞITIM MÜDÜRLÜĞÜ",
				"ACIBADEM PTT MÜDÜRLÜĞÜ",
				"AKSARAY PTT MÜDÜRLÜĞÜ",
				"ALİBEYKÖY PTT MÜDÜRLÜĞÜ",
				"ANADOLU YAKASI KARGO İŞLEME MÜDÜRLÜĞÜ",
				"ARNAVUTKÖY POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"ARNAVUTKÖY PTT MÜDÜRLÜĞÜ",
				"ATAŞEHİR POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"ATAŞEHİR PTT MÜDÜRLÜĞÜ",
				"AVCILAR POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"AVCILAR PTT MÜDÜRLÜĞÜ",
				"AVRUPA YAKASI KARGO İŞLEME MÜDÜRLÜĞÜ",
				"AVRUPA YAKASI POSTA İŞLEME MÜDÜRLÜĞÜ",
				"AYDINLI PTT MÜDÜRLÜĞÜ",
				"BAĞCILAR POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"BAĞCILAR PTT MÜDÜRLÜĞÜ",
				"BAHÇELİEVLER KARGO DAĞITIM MÜDÜRLÜĞÜ",
				"BAHÇELİEVLER POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"BAHÇELİEVLER PTT MÜDÜRLÜĞÜ",
				"BAHÇEŞEHİR PTT MÜDÜRLÜĞÜ",
				"BAKIRKÖY ADLİYE PTT MÜDÜRLÜĞÜ",
				"BAKIRKÖY POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"BAKIRKÖY PTT MÜDÜRLÜĞÜ",
				"BAŞAKŞEHİR KARGO DAĞITIM MÜDÜRLÜĞÜ",
				"BAŞAKŞEHİR POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"BAŞAKŞEHİR PTT MÜDÜRLÜĞÜ",
				"BAŞMÜDÜRLÜK",
				"BAYRAMPAŞA POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"BAYRAMPAŞA PTT MÜDÜRLÜĞÜ",
				"BEŞİKTAŞ POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"BEŞİKTAŞ PTT MÜDÜRLÜĞÜ",
				"BEYAZIT PTT MÜDÜRLÜĞÜ",
				"BEYKENT PTT MÜDÜRLÜĞÜ",
				"BEYKOZ POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"BEYKOZ PTT MÜDÜRLÜĞÜ",
				"BEYLİKDÜZÜ POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"BEYLİKDÜZÜ PTT MÜDÜRLÜĞÜ",
				"BEYOĞLU POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"BEYOĞLU PTT MÜDÜRLÜĞÜ",
				"BOĞAZ KARGO DAĞITIM MÜDÜRLÜĞÜ",
				"BOSTANCI PTT MÜDÜRLÜĞÜ",
				"BÜYÜKADA PTT MÜDÜRLÜĞÜ",
				"BÜYÜKÇEKMECE PTT MÜDÜRLÜĞÜ",
				"ÇAĞLAYAN KARGO DAĞITIM MÜDÜRLÜĞÜ",
				"ÇATALCA PTT MÜDÜRLÜĞÜ",
				"ÇEKMEKÖY POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"ÇEKMEKÖY PTT MÜDÜRLÜĞÜ",
				"DEĞERLİ KAĞITLAR MÜDÜRLÜĞÜ",
				"DESTEK HİZMETLERİ VE ULAŞIM MÜDÜRLÜĞÜ",
				"DUDULLU PTT MÜDÜRLÜĞÜ",
				"EĞİTİM MÜDÜRLÜĞÜ",
				"ESENLER PTT MÜDÜRLÜĞÜ",
				"ESENYURT POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"ESENYURT PTT MÜDÜRLÜĞÜ",
				"E-TİCARET MÜDÜRLÜĞÜ",
				"EYS MÜDÜRLÜĞÜ",
				"EYÜP POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"EYÜP SULTAN PTT MÜDÜRLÜĞÜ",
				"FATİH POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"FATİH PTT MÜDÜRLÜĞÜ",
				"FERHATPAŞA PTT MÜDÜRLÜĞÜ",
				"FERİKÖY PTT MÜDÜRLÜĞÜ",
				"FINDIKZADE PTT MÜDÜRLÜĞÜ",
				"GAYRETTEPE PTT MÜDÜRLÜĞÜ",
				"GAZİ MAHALLESİ PTT MÜDÜRLÜĞÜ",
				"GAZİOSMANPAŞA PTT MÜDÜRLÜĞÜ",
				"GÖZTEPE PTT MÜDÜRLÜĞÜ",
				"GÜLTEPE ŞEHİT MEHMET ALİ KILIÇ PTT MÜDÜRLÜĞÜ",
				"GÜNEŞLİ PTT MÜDÜRLÜĞÜ",
				"HADIMKÖY PTT MÜDÜRLÜĞÜ",
				"HALKALI PTT MÜDÜRLÜĞÜ",
				"HUKUK MÜDÜRLÜĞÜ",
				"İKİTELLİ PTT MÜDÜRLÜĞÜ",
				"İNSAN KAYNAKLARI MÜDÜRLÜĞÜ",
				"İSTANBUL ADALET SARAYI PTT MÜDÜRLÜĞÜ",
				"İSTANBUL ANADOLU ADALET SARAYI PTT MÜDÜRLÜĞÜ",
				"İSTANBUL BÖLGE İSTİNAF MAHKEMELERİ PTT MÜDÜRLÜĞÜ",
				"İSTİNYE PTT MÜDÜRLÜĞÜ",
				"İSTOÇ PTT MÜDÜRLÜĞÜ",
				"KADIKÖY POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"KADIKÖY PTT MÜDÜRLÜĞÜ",
				"KAĞITHANE POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"KAĞITHANE PTT MÜDÜRLÜĞÜ",
				"KARAKÖY PTT MÜDÜRLÜĞÜ",
				"KARTAL KARGO DAĞITIM MÜDÜRLÜĞÜ",
				"KARTAL POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"KARTAL PTT MÜDÜRLÜĞÜ",
				"KASIMPAŞA PTT MÜDÜRLÜĞÜ",
				"KAVACIK PTT MÜDÜRLÜĞÜ",
				"KAYAŞEHİR PTT MÜDÜRLÜĞÜ",
				"KAYNARCA PTT MÜDÜRLÜĞÜ",
				"KEMERBURGAZ PTT MÜDÜRLÜĞÜ",
				"KIRAÇ KARGO DAĞITIM MÜDÜRLÜĞÜ",
				"KIRAÇ PTT MÜDÜRLÜĞÜ",
				"KONTROLÖRLÜK",
				"KURTKÖY POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"KURTKÖY PTT MÜDÜRLÜĞÜ",
				"KÜÇÜKÇEKMECE POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"KÜÇÜKÇEKMECE PTT MÜDÜRLÜĞÜ",
				"KÜÇÜKYALI PTT MÜDÜRLÜĞÜ",
				"LEVENT PTT MÜDÜRLÜĞÜ",
				"LOJİSTİK HİZMETLERİ MÜDÜRLÜĞÜ",
				"MALTEPE POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"MALTEPE PTT MÜDÜRLÜĞÜ",
				"MECİDİYEKÖY PTT MÜDÜRLÜĞÜ",
				"MERTER KERESTECİLER SİTESİ PTT MÜDÜRLÜĞÜ",
				"MUHASEBE VE FİNANS MÜDÜRLÜĞÜ",
				"PAZARLAMA VE SATIŞ MÜDÜRLÜĞÜ",
				"PENDİK POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"PENDİK PTT MÜDÜRLÜĞÜ",
				"POSTA-KARGO HİZMETLERİ MÜDÜRLÜĞÜ",
				"PTTBANK MÜDÜRLÜĞÜ",
				"SAHRAYICEDİT PTT MÜDÜRLÜĞÜ",
				"SAMANDIRA PTT MÜDÜRLÜĞÜ",
				"SANCAKTEPE KARGO DAĞITIM MÜDÜRLÜĞÜ",
				"SANCAKTEPE POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"SANCAKTEPE PTT MÜDÜRLÜĞÜ",
				"SARIYER POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"SARIYER PTT MÜDÜRLÜĞÜ",
				"SATINALMA MÜDÜRLÜĞÜ",
				"SEFAKÖY PTT MÜDÜRLÜĞÜ",
				"SEYRANTEPE PTT MÜDÜRLÜĞÜ",
				"SİLİVRİ POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"SİLİVRİ PTT MÜDÜRLÜĞÜ",
				"SİRKECİ PTT MÜDÜRLÜĞÜ",
				"SOĞANLIK PTT MÜDÜRLÜĞÜ",
				"SULTANBEYLİ POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"SULTANBEYLİ PTT MÜDÜRLÜĞÜ",
				"SULTANGAZİ POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"SULTANGAZİ PTT MÜDÜRLÜĞÜ",
				"ŞİLE PTT MÜDÜRLÜĞÜ",
				"ŞİRİNEVLER PTT MÜDÜRLÜĞÜ",
				"ŞİŞLİ POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"ŞİŞLİ PTT MÜDÜRLÜĞÜ",
				"TAKSİM PTT MÜDÜRLÜĞÜ",
				"TEKNOLOJİ MÜDÜRLÜĞÜ",
				"TEŞVİKİYE PTT MÜDÜRLÜĞÜ",
				"TOPKAPI KARGO DAĞITIM MÜDÜRLÜĞÜ",
				"TUZLA POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"TUZLA PTT MÜDÜRLÜĞÜ",
				"ULUSLARARASI POSTA KARGO İŞLEME MÜDÜRLÜĞÜ",
				"ÜMRANİYE POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"ÜMRANİYE PTT MÜDÜRLÜĞÜ",
				"ÜSKÜDAR POSTA DAĞITIM MÜDÜRLÜĞÜ",
				"ÜSKÜDAR PTT MÜDÜRLÜĞÜ",
				"YAPI İŞLERİ MÜDÜRLÜĞÜ",
				"YENİ BOSNA PTT MÜDÜRLÜĞÜ",
				"YEŞİLKÖY PTT MÜDÜRLÜĞÜ",
				"YILDIRIM PTT MÜDÜRLÜĞÜ",
				"ZEYTİNBURNU PTT MÜDÜRLÜĞÜ",
				"ZÜMRÜTEVLER PTT MÜDÜRLÜĞÜ"};
		
		textFieldSayi = new JTextField();
		textFieldSayi.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldSayi.setForeground(new Color(128, 0, 0));
		textFieldSayi.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSayi.setColumns(10);
		textFieldSayi.setBackground(SystemColor.info);
		textFieldSayi.setBounds(212, 124, 194, 43);
		panel.add(textFieldSayi);
		
		JComboBox comboBoxMudurluk = new JComboBox(mudurluk);
		comboBoxMudurluk.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxMudurluk.setBackground(SystemColor.info);
		comboBoxMudurluk.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxMudurluk.setBounds(10, 210, 396, 43);
		panel.add(comboBoxMudurluk);
		
		JLabel lblMudurluk = new JLabel("Mudurluk:");
		lblMudurluk.setForeground(Color.WHITE);
		lblMudurluk.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMudurluk.setBounds(10, 178, 396, 21);
		panel.add(lblMudurluk);
		
		
		
		JTextArea textAreaAciklama = new JTextArea();
		textAreaAciklama.setForeground(new Color(128, 0, 0));
		textAreaAciklama.setFont(new Font("Monospaced", Font.BOLD, 16));
		textAreaAciklama.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaAciklama.setBackground(SystemColor.info);
		textAreaAciklama.setBounds(10, 324, 396, 258);
		panel.add(textAreaAciklama);
		
		JLabel lblAciklama = new JLabel("Aciklama:");
		lblAciklama.setForeground(Color.WHITE);
		lblAciklama.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAciklama.setBounds(10, 296, 396, 21);
		panel.add(lblAciklama);
		
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(textFieldAdSoyad.getText().equals("")||textAreaAciklama.getText().equals("")||textFieldSayi.getText().equals("")||textFieldTarih.getText().equals("")) { 
						JOptionPane.showMessageDialog(null,"Gerekli Alanlari Doldurunuz");
				}					
				else {
				      try {					
				    	  
				    	  DisiplinDomain addDisiplinDomain=new DisiplinDomain();	
				    	  
				    	 
				    	  addDisiplinDomain.setAdiSoyadi(textFieldAdSoyad.getText());
				    	  addDisiplinDomain.setTarih(textFieldTarih.getText());
				    	  addDisiplinDomain.setSayi(textFieldSayi.getText());
				    	  addDisiplinDomain.setMudurluk(comboBoxMudurluk.getSelectedItem().toString());
				    	  addDisiplinDomain.setAciklama(textAreaAciklama.getText());
				    	  
				    	  //*********
				    	  
				    	 					    	  
				    	   disiplinEkle(addDisiplinDomain);	
				    	  
							JOptionPane.showMessageDialog(null,"Kayit Basarili");
							
							textFieldAdSoyad.setText("");
							textFieldTarih.setText("");
							textFieldSayi.setText("");
							comboBoxMudurluk.setSelectedItem("DİĞER");
							textAreaAciklama.setText("");
						
							
														    																			
				      }						
					 catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Baglanti Hatasi");								
					}													
				}
				
				
				list.setListData(disiplinListele().toArray());
				
				
			}
		});
		btnKaydet.setBackground(UIManager.getColor("Button.light"));
		btnKaydet.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnKaydet.setBounds(10, 593, 71, 30);
		panel.add(btnKaydet);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {			
				DisiplinDomain seciliKisiDomain=(DisiplinDomain)list.getSelectedValue();
				if(seciliKisiDomain!=null) {					
					textFieldTarih.setText(seciliKisiDomain.getTarih());
					textFieldSayi.setText(seciliKisiDomain.getSayi());					
					comboBoxMudurluk.setSelectedItem(seciliKisiDomain.getMudurluk());					
					textFieldAdSoyad.setText(seciliKisiDomain.getAdiSoyadi());
					textAreaAciklama.setText(seciliKisiDomain.getAciklama());																				   					    					    
					    boolean durum = Arrays.asList(mudurluk).contains(seciliKisiDomain.getMudurluk());					  		    
					    if(durum==true) {comboBoxMudurluk.setSelectedItem(seciliKisiDomain.getMudurluk());
					    labelMudurluk.setText("");}
					    else {comboBoxMudurluk.setSelectedItem("DİĞER");
					    labelMudurluk.setText(seciliKisiDomain.getMudurluk());}			
				} 
			}
			
			
			private int linearSearch(String[] mudurlukler, String mudurlukSonuc) {
				// TODO Auto-generated method stub
				return 0;
			}});
		
		
		JButton btnGuncelle = new JButton("Guncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if(textFieldAdSoyad.getText().equals("")||textAreaAciklama.getText().equals("")||textFieldSayi.getText().equals("")||textFieldTarih.getText().equals(""))										
				{
					JOptionPane.showMessageDialog(null," Yandaki Listeden ilgilinin Bulundugu Satiri Seciniz...");
				}		
				else {
				   			    	  
				    	  DisiplinDomain addUser=(DisiplinDomain) list.getSelectedValue();
				    	  
				    	  if(addUser!=null) {
				    		  
				    	  addUser.setTarih(textFieldTarih.getText());
				    	  addUser.setAdiSoyadi(textFieldAdSoyad.getText());				    	  
				    	  addUser.setSayi(textFieldSayi.getText());
				    	  
				    	  addUser.setMudurluk(comboBoxMudurluk.getSelectedItem().toString());
				    	  	
				    	  addUser.setAciklama(textAreaAciklama.getText());
				    	
				    	  
				    	  
				    	
			  
				    	 
				    	  	disiplinGuncelle(addUser);	
				    	  
							JOptionPane.showMessageDialog(null,"Guncelleme Basarili");	
							
							
							list.setListData(disiplinListele().toArray());
													
							textFieldAdSoyad.setText("");
							textFieldTarih.setText("");
							textFieldSayi.setText("");
							comboBoxMudurluk.setSelectedItem("DİĞER");
							textAreaAciklama.setText("");								
				    	  }
				    	  else {
				    		  JOptionPane.showMessageDialog(null," Yandaki Listeden Kaydin Bulundugu Satiri Seciniz...");			    		  
				    	  }								
				}				
			}
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnGuncelle.setBackground(UIManager.getColor("Button.light"));
		btnGuncelle.setBounds(91, 593, 83, 30);
		panel.add(btnGuncelle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				DisiplinDomain silinecekDisiplinDomain =(DisiplinDomain)list.getSelectedValue();
				if(silinecekDisiplinDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Kaydi Silmek istedigine Emin Misin?","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						
						disiplinSil(silinecekDisiplinDomain);
						
						list.setListData(disiplinListele().toArray());	
						
						JOptionPane.showMessageDialog(null," Kayit Silindi");
						
						
						
						textFieldAdSoyad.setText("");
						textFieldTarih.setText("");
						textFieldSayi.setText("");
						comboBoxMudurluk.setSelectedItem("DİĞER");
						textAreaAciklama.setText("");
						labelMudurluk.setText("");
						
				
						
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek Kayit secilmedi");}
				
				
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSil.setBackground(UIManager.getColor("Button.light"));
		btnSil.setBounds(184, 593, 59, 30);
		panel.add(btnSil);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldAdSoyad.setText("");
				textFieldTarih.setText("");
				textFieldSayi.setText("");
				comboBoxMudurluk.setSelectedItem("DİĞER");
				textAreaAciklama.setText("");
				labelMudurluk.setText("");
			}
		});
		btnTemizle.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTemizle.setBackground(UIManager.getColor("Button.light"));
		btnTemizle.setBounds(253, 593, 82, 30);
		panel.add(btnTemizle);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				disiplin.this.dispose();
				AnaMenu mPane2sl=new AnaMenu();
				mPane2sl.setVisible(true);
			}
		});
		btnGeri.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGeri.setBackground(UIManager.getColor("Button.light"));
		btnGeri.setBounds(345, 593, 61, 30);
		panel.add(btnGeri);
			
	}	
	
	public void disiplinEkle (DisiplinDomain disiplinEklenecekKisi) 
	{
		
		Connection baglanti=DataBaseConn.baglantiAl();
		//tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
							
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO disiplin (tarih, sayi, mudurluk, adisoyadi, aciklama) VALUES (?,?,?,?,?)");
		
			sorguPreparedStatement.setString(1, disiplinEklenecekKisi.getTarih().toUpperCase());
			sorguPreparedStatement.setString(2, disiplinEklenecekKisi.getSayi().toUpperCase());
			sorguPreparedStatement.setString(3, disiplinEklenecekKisi.getMudurluk().toUpperCase());
			sorguPreparedStatement.setString(4, disiplinEklenecekKisi.getAdiSoyadi().toUpperCase());
			sorguPreparedStatement.setString(5, disiplinEklenecekKisi.getAciklama().toUpperCase());
										
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}	
							
	}

	public static void disiplinSil(DisiplinDomain silinecekDisiplinDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM disiplin WHERE id=?");
			sorgu.setInt(1, silinecekDisiplinDomain.getId());
			sorgu.executeUpdate();									
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<DisiplinDomain> disiplinListele(){	
		ArrayList<DisiplinDomain> disiplin= new ArrayList<DisiplinDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM disiplin ORDER BY (id) DESC");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				DisiplinDomain siradakiDomain2=new DisiplinDomain();	
				
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setTarih(rs2.getString("tarih"));
				siradakiDomain2.setSayi(rs2.getString("sayi"));
				siradakiDomain2.setMudurluk(rs2.getString("mudurluk"));
				siradakiDomain2.setAdiSoyadi(rs2.getString("adisoyadi"));
				siradakiDomain2.setAciklama(rs2.getString("aciklama"));	
				
											
				disiplin.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return disiplin;	
	}

	public static void disiplinGuncelle(DisiplinDomain guncellenecekDisiplinDomain) {
		
		Connection baglanti=DataBaseConn.baglantiAl();
		try {                                                        
			PreparedStatement sorgu =baglanti.prepareStatement("UPDATE disiplin SET tarih=? , sayi=? , mudurluk=? , adisoyadi=? , aciklama=? WHERE id=?");
		sorgu.setString(1, guncellenecekDisiplinDomain.getTarih().toUpperCase());	
		sorgu.setString(2, guncellenecekDisiplinDomain.getSayi().toUpperCase());	
		sorgu.setString(3, guncellenecekDisiplinDomain.getMudurluk().toUpperCase());	
		sorgu.setString(4, guncellenecekDisiplinDomain.getAdiSoyadi().toUpperCase());	
		sorgu.setString(5, guncellenecekDisiplinDomain.getAciklama().toUpperCase());				
		sorgu.setInt(6, guncellenecekDisiplinDomain.getId());
			
		sorgu.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}							
	}

	public static ArrayList<DisiplinDomain> disiplinAra(String adisoyadi){	
		
		ArrayList<DisiplinDomain> disiplin= new ArrayList<DisiplinDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM disiplin WHERE (adisoyadi) LIKE ? ORDER BY (id) DESC");	
			sorgu2.setString(1,"%"+ adisoyadi+"%");
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				
				DisiplinDomain siradakiDomain2=new DisiplinDomain();	
				
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setTarih(rs2.getString("tarih"));
				siradakiDomain2.setSayi(rs2.getString("sayi"));
				siradakiDomain2.setMudurluk(rs2.getString("mudurluk"));							
				siradakiDomain2.setAdiSoyadi(rs2.getString("adisoyadi"));
				siradakiDomain2.setAciklama(rs2.getString("aciklama"));															
				disiplin.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return disiplin;	
	}

	public static DefaultTableModel disiplinBulDefaultTableModel(String disiplin) {
		 model=new DefaultTableModel();		 	 
		 Object[] kolonlar= {"Aciklama"}; 		 		 
		 Object[] satirlar=new Object[20];
		 Connection baglanti =DataBaseConn.baglantiAl();			 		 
		 model.setColumnIdentifiers(kolonlar);					 		
		try {						
			PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM disiplin WHERE adisoyadi LIKE ?");			
			sorgu.setString(1,"%"+disiplin.toUpperCase()+"%");			
			ResultSet rs=sorgu.executeQuery();							
			while(rs.next()) {													
				//satirlar[0]=rs.getString("tarih");
				//satirlar[1]=rs.getString("sayi");
				//satirlar[2]=rs.getString("mudurluk");				
				satirlar[0]=rs.getString("aciklama").toLowerCase();			
				model.addRow(satirlar);				
			}												
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;				
	}
}









