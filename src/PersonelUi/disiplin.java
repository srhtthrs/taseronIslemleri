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
		
		String [] mudurluk = {"D????ER",
				"15 TEMMUZ ??EH??TLER PTT M??D??RL??????",
				"150.YIL ANADOLU YAKASI POSTA ????LEME M??D??RL??????",
				"50.YIL PTT M??D??RL??????",
				"ACIBADEM KARGO DA??ITIM M??D??RL??????",
				"ACIBADEM PTT M??D??RL??????",
				"AKSARAY PTT M??D??RL??????",
				"AL??BEYK??Y PTT M??D??RL??????",
				"ANADOLU YAKASI KARGO ????LEME M??D??RL??????",
				"ARNAVUTK??Y POSTA DA??ITIM M??D??RL??????",
				"ARNAVUTK??Y PTT M??D??RL??????",
				"ATA??EH??R POSTA DA??ITIM M??D??RL??????",
				"ATA??EH??R PTT M??D??RL??????",
				"AVCILAR POSTA DA??ITIM M??D??RL??????",
				"AVCILAR PTT M??D??RL??????",
				"AVRUPA YAKASI KARGO ????LEME M??D??RL??????",
				"AVRUPA YAKASI POSTA ????LEME M??D??RL??????",
				"AYDINLI PTT M??D??RL??????",
				"BA??CILAR POSTA DA??ITIM M??D??RL??????",
				"BA??CILAR PTT M??D??RL??????",
				"BAH??EL??EVLER KARGO DA??ITIM M??D??RL??????",
				"BAH??EL??EVLER POSTA DA??ITIM M??D??RL??????",
				"BAH??EL??EVLER PTT M??D??RL??????",
				"BAH??E??EH??R PTT M??D??RL??????",
				"BAKIRK??Y ADL??YE PTT M??D??RL??????",
				"BAKIRK??Y POSTA DA??ITIM M??D??RL??????",
				"BAKIRK??Y PTT M??D??RL??????",
				"BA??AK??EH??R KARGO DA??ITIM M??D??RL??????",
				"BA??AK??EH??R POSTA DA??ITIM M??D??RL??????",
				"BA??AK??EH??R PTT M??D??RL??????",
				"BA??M??D??RL??K",
				"BAYRAMPA??A POSTA DA??ITIM M??D??RL??????",
				"BAYRAMPA??A PTT M??D??RL??????",
				"BE????KTA?? POSTA DA??ITIM M??D??RL??????",
				"BE????KTA?? PTT M??D??RL??????",
				"BEYAZIT PTT M??D??RL??????",
				"BEYKENT PTT M??D??RL??????",
				"BEYKOZ POSTA DA??ITIM M??D??RL??????",
				"BEYKOZ PTT M??D??RL??????",
				"BEYL??KD??Z?? POSTA DA??ITIM M??D??RL??????",
				"BEYL??KD??Z?? PTT M??D??RL??????",
				"BEYO??LU POSTA DA??ITIM M??D??RL??????",
				"BEYO??LU PTT M??D??RL??????",
				"BO??AZ KARGO DA??ITIM M??D??RL??????",
				"BOSTANCI PTT M??D??RL??????",
				"B??Y??KADA PTT M??D??RL??????",
				"B??Y??K??EKMECE PTT M??D??RL??????",
				"??A??LAYAN KARGO DA??ITIM M??D??RL??????",
				"??ATALCA PTT M??D??RL??????",
				"??EKMEK??Y POSTA DA??ITIM M??D??RL??????",
				"??EKMEK??Y PTT M??D??RL??????",
				"DE??ERL?? KA??ITLAR M??D??RL??????",
				"DESTEK H??ZMETLER?? VE ULA??IM M??D??RL??????",
				"DUDULLU PTT M??D??RL??????",
				"E????T??M M??D??RL??????",
				"ESENLER PTT M??D??RL??????",
				"ESENYURT POSTA DA??ITIM M??D??RL??????",
				"ESENYURT PTT M??D??RL??????",
				"E-T??CARET M??D??RL??????",
				"EYS M??D??RL??????",
				"EY??P POSTA DA??ITIM M??D??RL??????",
				"EY??P SULTAN PTT M??D??RL??????",
				"FAT??H POSTA DA??ITIM M??D??RL??????",
				"FAT??H PTT M??D??RL??????",
				"FERHATPA??A PTT M??D??RL??????",
				"FER??K??Y PTT M??D??RL??????",
				"FINDIKZADE PTT M??D??RL??????",
				"GAYRETTEPE PTT M??D??RL??????",
				"GAZ?? MAHALLES?? PTT M??D??RL??????",
				"GAZ??OSMANPA??A PTT M??D??RL??????",
				"G??ZTEPE PTT M??D??RL??????",
				"G??LTEPE ??EH??T MEHMET AL?? KILI?? PTT M??D??RL??????",
				"G??NE??L?? PTT M??D??RL??????",
				"HADIMK??Y PTT M??D??RL??????",
				"HALKALI PTT M??D??RL??????",
				"HUKUK M??D??RL??????",
				"??K??TELL?? PTT M??D??RL??????",
				"??NSAN KAYNAKLARI M??D??RL??????",
				"??STANBUL ADALET SARAYI PTT M??D??RL??????",
				"??STANBUL ANADOLU ADALET SARAYI PTT M??D??RL??????",
				"??STANBUL B??LGE ??ST??NAF MAHKEMELER?? PTT M??D??RL??????",
				"??ST??NYE PTT M??D??RL??????",
				"??STO?? PTT M??D??RL??????",
				"KADIK??Y POSTA DA??ITIM M??D??RL??????",
				"KADIK??Y PTT M??D??RL??????",
				"KA??ITHANE POSTA DA??ITIM M??D??RL??????",
				"KA??ITHANE PTT M??D??RL??????",
				"KARAK??Y PTT M??D??RL??????",
				"KARTAL KARGO DA??ITIM M??D??RL??????",
				"KARTAL POSTA DA??ITIM M??D??RL??????",
				"KARTAL PTT M??D??RL??????",
				"KASIMPA??A PTT M??D??RL??????",
				"KAVACIK PTT M??D??RL??????",
				"KAYA??EH??R PTT M??D??RL??????",
				"KAYNARCA PTT M??D??RL??????",
				"KEMERBURGAZ PTT M??D??RL??????",
				"KIRA?? KARGO DA??ITIM M??D??RL??????",
				"KIRA?? PTT M??D??RL??????",
				"KONTROL??RL??K",
				"KURTK??Y POSTA DA??ITIM M??D??RL??????",
				"KURTK??Y PTT M??D??RL??????",
				"K??????K??EKMECE POSTA DA??ITIM M??D??RL??????",
				"K??????K??EKMECE PTT M??D??RL??????",
				"K??????KYALI PTT M??D??RL??????",
				"LEVENT PTT M??D??RL??????",
				"LOJ??ST??K H??ZMETLER?? M??D??RL??????",
				"MALTEPE POSTA DA??ITIM M??D??RL??????",
				"MALTEPE PTT M??D??RL??????",
				"MEC??D??YEK??Y PTT M??D??RL??????",
				"MERTER KERESTEC??LER S??TES?? PTT M??D??RL??????",
				"MUHASEBE VE F??NANS M??D??RL??????",
				"PAZARLAMA VE SATI?? M??D??RL??????",
				"PEND??K POSTA DA??ITIM M??D??RL??????",
				"PEND??K PTT M??D??RL??????",
				"POSTA-KARGO H??ZMETLER?? M??D??RL??????",
				"PTTBANK M??D??RL??????",
				"SAHRAYICED??T PTT M??D??RL??????",
				"SAMANDIRA PTT M??D??RL??????",
				"SANCAKTEPE KARGO DA??ITIM M??D??RL??????",
				"SANCAKTEPE POSTA DA??ITIM M??D??RL??????",
				"SANCAKTEPE PTT M??D??RL??????",
				"SARIYER POSTA DA??ITIM M??D??RL??????",
				"SARIYER PTT M??D??RL??????",
				"SATINALMA M??D??RL??????",
				"SEFAK??Y PTT M??D??RL??????",
				"SEYRANTEPE PTT M??D??RL??????",
				"S??L??VR?? POSTA DA??ITIM M??D??RL??????",
				"S??L??VR?? PTT M??D??RL??????",
				"S??RKEC?? PTT M??D??RL??????",
				"SO??ANLIK PTT M??D??RL??????",
				"SULTANBEYL?? POSTA DA??ITIM M??D??RL??????",
				"SULTANBEYL?? PTT M??D??RL??????",
				"SULTANGAZ?? POSTA DA??ITIM M??D??RL??????",
				"SULTANGAZ?? PTT M??D??RL??????",
				"????LE PTT M??D??RL??????",
				"????R??NEVLER PTT M??D??RL??????",
				"??????L?? POSTA DA??ITIM M??D??RL??????",
				"??????L?? PTT M??D??RL??????",
				"TAKS??M PTT M??D??RL??????",
				"TEKNOLOJ?? M??D??RL??????",
				"TE??V??K??YE PTT M??D??RL??????",
				"TOPKAPI KARGO DA??ITIM M??D??RL??????",
				"TUZLA POSTA DA??ITIM M??D??RL??????",
				"TUZLA PTT M??D??RL??????",
				"ULUSLARARASI POSTA KARGO ????LEME M??D??RL??????",
				"??MRAN??YE POSTA DA??ITIM M??D??RL??????",
				"??MRAN??YE PTT M??D??RL??????",
				"??SK??DAR POSTA DA??ITIM M??D??RL??????",
				"??SK??DAR PTT M??D??RL??????",
				"YAPI ????LER?? M??D??RL??????",
				"YEN?? BOSNA PTT M??D??RL??????",
				"YE????LK??Y PTT M??D??RL??????",
				"YILDIRIM PTT M??D??RL??????",
				"ZEYT??NBURNU PTT M??D??RL??????",
				"Z??MR??TEVLER PTT M??D??RL??????"};
		
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
							comboBoxMudurluk.setSelectedItem("D????ER");
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
					    else {comboBoxMudurluk.setSelectedItem("D????ER");
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
							comboBoxMudurluk.setSelectedItem("D????ER");
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
						comboBoxMudurluk.setSelectedItem("D????ER");
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
				comboBoxMudurluk.setSelectedItem("D????ER");
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









