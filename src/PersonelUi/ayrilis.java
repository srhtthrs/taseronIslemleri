package PersonelUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import PersonelDataBase.ArsivSQL;
import PersonelDataBase.DataBaseConn;
import PersonelDomain.AyrilisDomain;
import PersonelDomain.BaslayisDomain;
import PersonelDomain.NotDomain;
import PersonelDomain.PersDomain;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
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
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ayrilis extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldtckn;
	private JTextField textFieldisim;
	private JTextField textFieldtarih;
	
	
	String chckbxDilekceBelgeString;
	String chckbxBildirgeString;
	
	private JTextField textFieldAra;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ayrilis frame = new ayrilis();
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
	public ayrilis() {
		setResizable(false);
		setTitle("AYRILIS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 749);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Icon pttlogo=new ImageIcon("ikonlar/pttkus.png");
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 463, 689);
		contentPane.add(panel);
		panel.setLayout(null);
		
		String [] mudurlukler = {"M??D??RL?????? SE????N??Z","D????ER",
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
		
		String [] unvanlar = {"UNVAN SE????N??Z","YAYA DA??ITICI","POSTA-AYRIM","MOTOS??KLETL?? DA??ITICI","TEM??ZL??K","G??VENL??K","ENGELL?? DA??ITICI","ENGELL?? AYRIM","D????ER"};
		
		String [] ayrilisNedeni = {"AYRILIS NEDEN?? SE????N??Z","??ST??FA","FES??H","ASKERL??K","EMEKL??L??K","EVL??L??K","D????ER"};
		
		JLabel lblNewLabel = new JLabel("TCKN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 157, 42);
		panel.add(lblNewLabel);
		
		textFieldtckn = new JTextField();
		textFieldtckn.setForeground(new Color(165, 42, 42));
		textFieldtckn.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldtckn.setBackground(SystemColor.info);
		textFieldtckn.setBounds(177, 11, 276, 42);
		panel.add(textFieldtckn);
		textFieldtckn.setColumns(10);
		
		textFieldisim = new JTextField();
		textFieldisim.setForeground(new Color(165, 42, 42));
		textFieldisim.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldisim.setColumns(10);
		textFieldisim.setBackground(SystemColor.info);
		textFieldisim.setBounds(177, 64, 276, 42);
		panel.add(textFieldisim);
		
		JLabel lblAdSoyad = new JLabel("AD SOYAD");
		lblAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdSoyad.setBounds(10, 64, 157, 42);
		panel.add(lblAdSoyad);
		
		textFieldtarih = new JTextField();
		textFieldtarih.setForeground(new Color(165, 42, 42));
		textFieldtarih.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldtarih.setColumns(10);
		textFieldtarih.setBackground(SystemColor.info);
		textFieldtarih.setBounds(177, 117, 276, 42);
		panel.add(textFieldtarih);
		
		JLabel lblTarh = new JLabel("TARIH");
		lblTarh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTarh.setBounds(10, 117, 157, 42);
		panel.add(lblTarh);
		
		JComboBox comboBoxMudurluk = new JComboBox(mudurlukler);
		comboBoxMudurluk.setForeground(new Color(128, 0, 0));
		comboBoxMudurluk.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxMudurluk.setBackground(SystemColor.info);
		comboBoxMudurluk.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxMudurluk.setBounds(10, 170, 443, 42);
		panel.add(comboBoxMudurluk);
		
		JComboBox comboBoxAyrilisNedeni = new JComboBox(ayrilisNedeni);
		comboBoxAyrilisNedeni.setForeground(new Color(128, 0, 0));
		comboBoxAyrilisNedeni.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxAyrilisNedeni.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxAyrilisNedeni.setBackground(SystemColor.info);
		comboBoxAyrilisNedeni.setBounds(10, 276, 443, 42);
		panel.add(comboBoxAyrilisNedeni);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(483, 11, 453, 689);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 433, 613);
		panel_1.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setForeground(Color.WHITE);
		list.setBackground(new Color(95, 158, 160));
		
		
		list.setListData(kisiListele().toArray());
		
	
		
		setLocationRelativeTo(null); 
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 329, 443, 162);
		panel.add(panel_2);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setLayout(null);
		
		JCheckBox chckbxBildirge = new JCheckBox("Bildirge");
		chckbxBildirge.setForeground(new Color(165, 42, 42));
		chckbxBildirge.setBounds(6, 82, 201, 25);
		panel_2.add(chckbxBildirge);
		chckbxBildirge.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxBildirge.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxDilekceBelge = new JCheckBox("Dilek??e veya Belge");
		chckbxDilekceBelge.setForeground(new Color(165, 42, 42));
		chckbxDilekceBelge.setBounds(6, 110, 201, 25);
		panel_2.add(chckbxDilekceBelge);
		chckbxDilekceBelge.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxDilekceBelge.setBackground(SystemColor.activeCaption);
		
		JLabel labelMudurluk = new JLabel("");
		labelMudurluk.setHorizontalAlignment(SwingConstants.LEFT);
		labelMudurluk.setBounds(6, 11, 150, 14);
		panel_2.add(labelMudurluk);
		labelMudurluk.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelMudurluk.setForeground(new Color(255, 255, 255));
		
		JLabel labelUnvan = new JLabel("");
		labelUnvan.setHorizontalAlignment(SwingConstants.LEFT);
		labelUnvan.setBounds(6, 36, 150, 14);
		panel_2.add(labelUnvan);
		labelUnvan.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelUnvan.setForeground(new Color(255, 255, 255));
		
		JLabel labelAyrilis = new JLabel("");
		labelAyrilis.setBounds(6, 61, 150, 14);
		panel_2.add(labelAyrilis);
		labelAyrilis.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelAyrilis.setForeground(new Color(255, 255, 255));
		
		
		JComboBox comboBoxUnvan = new JComboBox(unvanlar);
		comboBoxUnvan.setForeground(new Color(128, 0, 0));
		comboBoxUnvan.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxUnvan.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxUnvan.setBackground(SystemColor.info);
		comboBoxUnvan.setBounds(10, 223, 443, 42);
		panel.add(comboBoxUnvan);
		
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AyrilisDomain silinecekKisiDomain =(AyrilisDomain)list.getSelectedValue();
				if(silinecekKisiDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Ki??iyi Silmek istedigine Emin Misin?","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						
						kisiSil(silinecekKisiDomain);
						
						list.setListData(kisiListele().toArray());	
						
						JOptionPane.showMessageDialog(null," Kayit Silindi");
						//System.out.println(silinecekKisiDomain.toString());
						textFieldtckn.setText("");
						textFieldisim.setText("");
						
						labelAyrilis.setText("");
						labelMudurluk.setText("");
						labelUnvan.setText("");
						
						
						comboBoxMudurluk.setSelectedItem("M??D??RL?????? SE????N??Z");
						
						comboBoxUnvan.setSelectedItem("UNVAN SE????N??Z");
						
						textFieldtarih.setText("");
						comboBoxAyrilisNedeni.setSelectedItem("AYRILIS NEDEN?? SE????N??Z");
						
						chckbxDilekceBelge.setSelected(false);
						chckbxBildirge.setSelected(false);
						
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek Kisi secilmedi");}
				
				
			}
		});
		btnSil.setBackground(UIManager.getColor("Button.light"));
		btnSil.setBounds(204, 646, 64, 32);
		panel.add(btnSil);
		
		
		
		
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				

				if(textFieldtckn.getText().equals("")||textFieldisim.getText().equals("")||textFieldtarih.getText().equals("")||comboBoxUnvan.getSelectedItem().toString().equals("UNVAN SE????N??Z")||comboBoxMudurluk.getSelectedItem().toString().equals("M??D??RL?????? SE????N??Z")||comboBoxAyrilisNedeni.getSelectedItem().toString().equals("AYRILIS NEDEN?? SE????N??Z")) { 
						JOptionPane.showMessageDialog(null,"Gerekli Alanlari Doldurunuz (TCKN, ISIM, TARIH, MERKEZ, UNVAN, AYRILIS NEDENI)");
				}					
				else {
				      try {					
				    	  
				    	  AyrilisDomain addAyrilis=new AyrilisDomain();	
				    	  
				    	 
				    	  addAyrilis.setTckn(textFieldtckn.getText());
				    	  addAyrilis.setAdiSoyadi(textFieldisim.getText());
				    	  addAyrilis.setTarih(textFieldtarih.getText());
				    	  addAyrilis.setMerkez(comboBoxMudurluk.getSelectedItem().toString());
				    	  
				    	  
				    	  addAyrilis.setUnvan(comboBoxUnvan.getSelectedItem().toString());
				    	  addAyrilis.setNeden(comboBoxAyrilisNedeni.getSelectedItem().toString());
				    	  
				    	  
				    	 
				    		
				    	  if(chckbxDilekceBelge.isSelected()==true) {
				    		  chckbxDilekceBelgeString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxDilekceBelgeString="YOK";				    		 
					    	  }
				    		
				    	  if(chckbxBildirge.isSelected()==true) {
				    		  chckbxBildirgeString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxBildirgeString="YOK";				    		 
					    	  }
				    		
				 				    	  
				    	  			    	  
				    	  //*********
				   	   
				   	    
				    	  addAyrilis.setDilekcebelge(chckbxDilekceBelgeString);
				    	
				    	
				    	  addAyrilis.setBildirge(chckbxBildirgeString);
				    	  
				    	  
				    	  
				    	  
				    	  //*********
				    	  
				    	 					    	  
				    	   ayrilisEkle(addAyrilis);	
				    	  
							JOptionPane.showMessageDialog(null,"Kayit Basarili");									
							textFieldtckn.setText("");
							textFieldisim.setText("");
							comboBoxMudurluk.setSelectedItem("M??D??RL?????? SE????N??Z");
							
							
							comboBoxUnvan.setSelectedItem("UNVAN SE????N??Z");
							
							textFieldtarih.setText("");
							
							labelAyrilis.setText("");
							labelMudurluk.setText("");
							labelUnvan.setText("");
							
							comboBoxAyrilisNedeni.setSelectedItem("AYRILIS NEDEN?? SE????N??Z");
							
							
							chckbxDilekceBelge.setSelected(false);
							chckbxBildirge.setSelected(false);
							
														    																			
				      }						
					 catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Baglanti Hatasi");								
					}													
				}
				
				list.setListData(kisiListele().toArray());
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setBounds(10, 646, 86, 32);
		panel.add(btnNewButton);
		
		textFieldAra = new JTextField();
		textFieldAra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
					if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					
						textFieldAra.setText("");
					
				}
				else {
					
					list.setListData(kisiAra(textFieldAra.getText().toString().toUpperCase()).toArray());
					
				
				}
				
				
			}
		});
		textFieldAra.setForeground(new Color(165, 42, 42));
		textFieldAra.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldAra.setColumns(10);
		textFieldAra.setBackground(SystemColor.info);
		textFieldAra.setBounds(107, 11, 336, 42);
		panel_1.add(textFieldAra);
		
		Icon search=new ImageIcon("ikonlar/search.jpg");
		JLabel lblTcknara = new JLabel(search);
		lblTcknara.setHorizontalAlignment(SwingConstants.CENTER);
		lblTcknara.setForeground(new Color(255, 255, 255));
		lblTcknara.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcknara.setBounds(10, 11, 87, 42);
		panel_1.add(lblTcknara);
		
		
		JButton btnGuncelle = new JButton("Guncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

				
				if(textFieldtckn.getText().equals("")| textFieldisim.getText().equals("")| textFieldtarih.getText().equals("")| comboBoxMudurluk.getSelectedItem().toString().equals("M??D??RL?????? SE????N??Z")| comboBoxUnvan.getSelectedItem().toString().equals("UNVAN SE????N??Z")| comboBoxAyrilisNedeni.getSelectedItem().toString().equals("AYRILIS NEDEN?? SE????N??Z"))										
				{
					JOptionPane.showMessageDialog(null," Yandaki Listeden ilgilinin Bulundugu Satiri Seciniz...");
				}		
				else {
				   			    	  
				    	  AyrilisDomain addUser=(AyrilisDomain) list.getSelectedValue();
				    	  
				    	  if(addUser!=null) {
				    		  
				    	  addUser.setTckn(textFieldtckn.getText());
				    	  addUser.setAdiSoyadi(textFieldisim.getText());				    	  
				    	  addUser.setTarih(textFieldtarih.getText());
				    	  addUser.setMerkez(comboBoxMudurluk.getSelectedItem().toString());
				    	  	
				    	  addUser.setUnvan(comboBoxUnvan.getSelectedItem().toString());
				    	  addUser.setNeden(comboBoxAyrilisNedeni.getSelectedItem().toString());
				    	  
				    	  
				    	
					    		
					    	  if(chckbxDilekceBelge.isSelected()==true) {
					    		  chckbxDilekceBelgeString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxDilekceBelgeString="YOK";				    		 
						    	  }
					    		
					    	  if(chckbxBildirge.isSelected()==true) {
					    		  chckbxBildirgeString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxBildirgeString="YOK";				    		 
						    	  }
					    		
					 				    	  
					    	  			    	  
					    	  //*********
					    	  
					    	
					    	  addUser.setDilekcebelge(chckbxDilekceBelgeString);
					    	  addUser.setBildirge(chckbxBildirgeString);
				    	  
				    	  
				    	  
				    	  
				    	  
				    	  
				    	  			    	  				    				    	  
				    	  
				    	 
				    	  kisiGuncelle(addUser);	
				    	  
							JOptionPane.showMessageDialog(null,"Guncelleme Basarili");	
							
							
							list.setListData(kisiListele().toArray());
							
							textFieldtckn.setText("");
							textFieldisim.setText("");
							textFieldtarih.setText("");
							comboBoxMudurluk.setSelectedItem("M??D??RL?????? SE????N??Z");
							
							labelAyrilis.setText("");
							labelMudurluk.setText("");
							labelUnvan.setText("");
							
							comboBoxUnvan.setSelectedItem("UNVAN SE????N??Z");
							
							
							
							
							
							
							comboBoxAyrilisNedeni.setSelectedItem("AYRILIS NEDEN?? SE????N??Z");
							
							
							
							chckbxDilekceBelge.setSelected(false);
							chckbxBildirge.setSelected(false);
							
				    	  }
				    	  else {
				    		  JOptionPane.showMessageDialog(null," Yandaki Listeden ilgilinin Bulundugu Satiri Seciniz...");
				    		  
				    	  }
							
				      					
					
									
				}
					
				
				
				
				
				
				
			}
		});
		btnGuncelle.setBackground(UIManager.getColor("Button.light"));
		btnGuncelle.setBounds(106, 646, 88, 32);
		panel.add(btnGuncelle);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldtckn.setText("");
				textFieldisim.setText("");
				textFieldtarih.setText("");
				
				
				labelAyrilis.setText("");
				labelMudurluk.setText("");
				labelUnvan.setText("");
				
				comboBoxMudurluk.setSelectedItem("M??D??RL?????? SE????N??Z");
			
				
				comboBoxUnvan.setSelectedItem("UNVAN SE????N??Z");
				
				
				comboBoxAyrilisNedeni.setSelectedItem("AYRILIS NEDEN?? SE????N??Z");
				
				
				chckbxDilekceBelge.setSelected(false);
				chckbxBildirge.setSelected(false);
				
			}
		});
		btnTemizle.setBackground(UIManager.getColor("Button.light"));
		btnTemizle.setBounds(278, 646, 87, 32);
		panel.add(btnTemizle);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ayrilis.this.dispose();
				AnaMenu mPane2sl=new AnaMenu();
				mPane2sl.setVisible(true);
				
			}
		});
		btnGeri.setBackground(UIManager.getColor("Button.light"));
		btnGeri.setBounds(375, 646, 78, 32);
		panel.add(btnGeri);
		
	
		
		
		
	
		
	
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				AyrilisDomain seciliKisiDomain=(AyrilisDomain)list.getSelectedValue();
				if(seciliKisiDomain!=null) {
					textFieldtckn.setText(seciliKisiDomain.getTckn());
					textFieldisim.setText(seciliKisiDomain.getAdiSoyadi());
					textFieldtarih.setText(seciliKisiDomain.getTarih());
																   					    					    
					    boolean durum = Arrays.asList(mudurlukler).contains(seciliKisiDomain.getMerkez());					  		    
					    if(durum==true) {comboBoxMudurluk.setSelectedItem(seciliKisiDomain.getMerkez());
					    labelMudurluk.setText("");}
					    else {comboBoxMudurluk.setSelectedItem("D????ER");
					    labelMudurluk.setText(seciliKisiDomain.getMerkez());}
					    
					    
					    boolean durum2 = Arrays.asList(unvanlar).contains(seciliKisiDomain.getUnvan());					  		    
					    if(durum2==true) {comboBoxUnvan.setSelectedItem(seciliKisiDomain.getUnvan());
					    labelUnvan.setText("");}
					    else {comboBoxUnvan.setSelectedItem("D????ER");
					    labelUnvan.setText(seciliKisiDomain.getUnvan());}
					
					    
					
				
					    boolean durum3 = Arrays.asList(ayrilisNedeni).contains(seciliKisiDomain.getNeden());					  		    
					    if(durum3==true) {comboBoxAyrilisNedeni.setSelectedItem(seciliKisiDomain.getNeden());
					    labelAyrilis.setText("");}
					    else {comboBoxAyrilisNedeni.setSelectedItem("D????ER");
					    labelAyrilis.setText(seciliKisiDomain.getNeden());}
					
										
					
					if(seciliKisiDomain.getDilekcebelge().equals("GELDI"))
					{chckbxDilekceBelge.setSelected(true);}
					else if (seciliKisiDomain.getDilekcebelge().equals("YOK")) {chckbxDilekceBelge.setSelected(false);}
					
					if(seciliKisiDomain.getBildirge().equals("GELDI"))
					{chckbxBildirge.setSelected(true);}
					else if (seciliKisiDomain.getBildirge().equals("YOK")) {chckbxBildirge.setSelected(false);}
					
					
					
			
					
					
					
					
					
				
				} 
			}

			private int linearSearch(String[] mudurlukler, String mudurlukSonuc) {
				// TODO Auto-generated method stub
				return 0;
			}});
		
		
	}
	
	
	public void ayrilisEkle(AyrilisDomain ayrilanKisi) 
	{		
		Connection baglanti=DataBaseConn.baglantiAl();		
		PreparedStatement sorguPreparedStatement;
		try {												
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO ayrilis (tarih, tckn, adisoyadi, merkez, unvan, neden, bildirge, dilekcebelge) VALUES (?,?,?,?,?,?,?,?)");
		
			sorguPreparedStatement.setString(1, ayrilanKisi.getTarih().toUpperCase());
			sorguPreparedStatement.setString(2, ayrilanKisi.getTckn().toUpperCase());
			sorguPreparedStatement.setString(3, ayrilanKisi.getAdiSoyadi().toUpperCase());			
			sorguPreparedStatement.setString(4, ayrilanKisi.getMerkez().toUpperCase());
			sorguPreparedStatement.setString(5, ayrilanKisi.getUnvan().toUpperCase());
			sorguPreparedStatement.setString(6, ayrilanKisi.getNeden().toUpperCase());			
	     	sorguPreparedStatement.setString(7, ayrilanKisi.getBildirge().toUpperCase());
			sorguPreparedStatement.setString(8, ayrilanKisi.getDilekcebelge().toUpperCase());
													
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}	
		
	}

	
	public static ArrayList<AyrilisDomain> kisiListele(){	
		ArrayList<AyrilisDomain> kisi= new ArrayList<AyrilisDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM ayrilis ORDER BY (id) DESC");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				AyrilisDomain siradakiDomain2=new AyrilisDomain();	
				
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setTckn(rs2.getString("tckn"));
				siradakiDomain2.setAdiSoyadi(rs2.getString("adisoyadi"));
				siradakiDomain2.setTarih(rs2.getString("tarih"));
				siradakiDomain2.setMerkez(rs2.getString("merkez"));
				siradakiDomain2.setUnvan(rs2.getString("unvan"));
				siradakiDomain2.setNeden(rs2.getString("neden"));
				siradakiDomain2.setDilekcebelge(rs2.getString("dilekcebelge"));
				siradakiDomain2.setBildirge(rs2.getString("bildirge"));
				
											
				kisi.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return kisi;	
	}

	
	public static void kisiSil(AyrilisDomain silinecekKisiDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM ayrilis WHERE id=?");
			sorgu.setInt(1, silinecekKisiDomain.getId());
			sorgu.executeUpdate();	
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public static ArrayList<AyrilisDomain> kisiAra(String tcknString){	
		ArrayList<AyrilisDomain> kisi= new ArrayList<AyrilisDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM ayrilis WHERE (tckn + adisoyadi) LIKE ? ORDER BY (id) DESC");	
			sorgu2.setString(1,"%"+ tcknString+"%");
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				AyrilisDomain siradakiDomain2=new AyrilisDomain();					
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setTckn(rs2.getString("tckn"));
				siradakiDomain2.setAdiSoyadi(rs2.getString("adisoyadi"));
				siradakiDomain2.setTarih(rs2.getString("tarih"));							
				siradakiDomain2.setMerkez(rs2.getString("merkez"));
				siradakiDomain2.setUnvan(rs2.getString("unvan"));
				siradakiDomain2.setNeden(rs2.getString("neden"));
				siradakiDomain2.setDilekcebelge(rs2.getString("dilekcebelge"));
				siradakiDomain2.setBildirge(rs2.getString("bildirge"));
															
				kisi.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return kisi;	
	}

	
	public static void kisiGuncelle(AyrilisDomain guncellenecekKisiDomain) {
		
		Connection baglanti=DataBaseConn.baglantiAl();
		try {                                                        
			PreparedStatement sorgu =baglanti.prepareStatement("UPDATE ayrilis SET tckn=? , adisoyadi=? , tarih=? , merkez=? , unvan=? , neden=?, dilekcebelge=?, bildirge=? WHERE id=?");
		sorgu.setString(1, guncellenecekKisiDomain.getTckn().toUpperCase());	
		sorgu.setString(2, guncellenecekKisiDomain.getAdiSoyadi().toUpperCase());	
		sorgu.setString(3, guncellenecekKisiDomain.getTarih().toUpperCase());	
		sorgu.setString(4, guncellenecekKisiDomain.getMerkez().toUpperCase());	
		sorgu.setString(5, guncellenecekKisiDomain.getUnvan().toUpperCase());
		sorgu.setString(6, guncellenecekKisiDomain.getNeden().toUpperCase());
		sorgu.setString(7, guncellenecekKisiDomain.getDilekcebelge().toUpperCase());
		sorgu.setString(8, guncellenecekKisiDomain.getBildirge().toUpperCase());
		
		
		
		sorgu.setInt(9, guncellenecekKisiDomain.getId());
		
		
		sorgu.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}
}
