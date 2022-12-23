package PersonelUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


import PersonelDataBase.ArsivSQL;
import PersonelDataBase.DataBaseConn;
import PersonelDomain.AyrilisDomain;
import PersonelDomain.DisiplinDomain;
import PersonelDomain.EksiklerDomain;

import PersonelDomain.JTableToExcel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;

public class Eksikler extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	static DefaultTableModel model;
	private JTextField textFieldAdet;
	int silinecekRowID;
	String aciklama,merkez,unvan,yakalar,adet;
	int seciliKayit;
	String seciliString;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Eksikler frame = new Eksikler();
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
	public Eksikler() {
		
		setResizable(false);
		setTitle("Eksikler");
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 583);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(260, 11, 698, 523);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.WHITE, 2));
		scrollPane.setBounds(10, 11, 679, 478);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
	
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 243, 523);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textAreaAciklama = new JTextArea();
		textAreaAciklama.setBackground(SystemColor.info);
		textAreaAciklama.setForeground(new Color(128, 0, 0));
		textAreaAciklama.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaAciklama.setBounds(10, 310, 223, 80);
		panel_1.add(textAreaAciklama);
		
		
		
		String [] mudurlukler = {"MÜDÜRLÜĞÜ SEÇİNİZ","DİĞER",
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
		
		String[] yaka= {"YAKA SEÇİNİZ","AVRUPA","ANADOLU"};
		
		String [] unvanlar = {"UNVAN SEÇİNİZ","YAYA DAĞITICI","POSTA-AYRIM","MOTOSİKLETLİ DAĞITICI","TEMİZLİK","GÜVENLİK","ENGELLİ","DİĞER"};
		
		JComboBox comboBoxYaka = new JComboBox(yaka);
		comboBoxYaka.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxYaka.setForeground(new Color(128, 0, 0));
		comboBoxYaka.setBounds(10, 146, 223, 22);
		panel_1.add(comboBoxYaka);
		
		JComboBox comboBoxMerkez = new JComboBox(mudurlukler);
		comboBoxMerkez.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBoxMerkez.setForeground(new Color(128, 0, 0));
		comboBoxMerkez.setBounds(10, 179, 223, 22);
		panel_1.add(comboBoxMerkez);
		
		JComboBox comboBoxUnvan = new JComboBox(unvanlar);
		comboBoxUnvan.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxUnvan.setForeground(new Color(128, 0, 0));
		comboBoxUnvan.setBounds(10, 212, 223, 22);
		panel_1.add(comboBoxUnvan);
		
		textFieldAdet = new JTextField();
		textFieldAdet.setBackground(SystemColor.info);
		textFieldAdet.setForeground(new Color(128, 0, 0));
		textFieldAdet.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldAdet.setBounds(54, 245, 179, 24);
		panel_1.add(textFieldAdet);
		textFieldAdet.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Adet :");
		lblNewLabel.setBounds(13, 245, 34, 24);
		panel_1.add(lblNewLabel);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				if(Integer.parseInt(textFieldAdet.getText())%1!=0) {JOptionPane.showMessageDialog(null,"Adedi sayi olarak giriniz, tum alanlari doldurunuz.");}
				else {

				if(comboBoxUnvan.getSelectedItem().toString().equals("UNVAN SEÇİNİZ")||comboBoxMerkez.getSelectedItem().toString().equals("MÜDÜRLÜĞÜ SEÇİNİZ")||comboBoxYaka.getSelectedItem().toString().equals("YAKA SEÇİNİZ")
						||textFieldAdet.getText().equals("")) { 
						JOptionPane.showMessageDialog(null,"Gerekli Alanlari Doldurunuz (AÇIKLAMA İSTEĞE BAĞLI)");
				}					
				else {
				      try {					
				    	  
				    	  EksiklerDomain addEksik=new EksiklerDomain();	
				    	  
				    	 
				    	  
				    	  
				    	  addEksik.setMerkez(comboBoxMerkez.getSelectedItem().toString());
				    	  addEksik.setYaka(comboBoxYaka.getSelectedItem().toString());
				    	  addEksik.setUnvan(comboBoxUnvan.getSelectedItem().toString());
				    	  addEksik.setAdet(textFieldAdet.getText());				    	  
				    	  addEksik.setAciklama(textAreaAciklama.getText());
				    	  
				   
				    	  				    	  				    	 					    	  
				    	  eksikEkle(addEksik);	
				    	  
							JOptionPane.showMessageDialog(null,"Kayit Basarili");
							
							
							
							

							comboBoxMerkez.setSelectedItem("MÜDÜRLÜĞÜ SEÇİNİZ");
							textFieldAdet.setText("");							
							comboBoxUnvan.setSelectedItem("UNVAN SEÇİNİZ");
													
							comboBoxYaka.setSelectedItem("YAKA SEÇİNİZ");
							textAreaAciklama.setText("");
							
														    																			
				      }						
					 catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Baglanti Hatasi");								
					}													
				}
				
				//list.setListData(kisiListele().toArray());
				
				table.setModel(eksikBulDefaultTableModel());
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    
			    TableColumn col0 = table.getColumnModel().getColumn(0);
			    TableColumn col1 = table.getColumnModel().getColumn(1);
			    TableColumn col2 = table.getColumnModel().getColumn(2);
			    TableColumn col3 = table.getColumnModel().getColumn(3);
			    TableColumn col4 = table.getColumnModel().getColumn(4);
			    TableColumn col5 = table.getColumnModel().getColumn(5);
			    
			    col0.setPreferredWidth(20);
			    col1.setPreferredWidth(80);
			    col2.setPreferredWidth(350);
			    col3.setPreferredWidth(140);
			    col4.setPreferredWidth(40);
			    col5.setPreferredWidth(400);
			}
				
			}catch(Exception e10) {JOptionPane.showMessageDialog(null,"Adedi sayi olarak giriniz.");}}
		});
		
		
		
		btnEkle.setBackground(UIManager.getColor("Button.light"));
		btnEkle.setBounds(10, 401, 60, 23);
		panel_1.add(btnEkle);
		
		JButton btnGuncelle = new JButton("Guncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBoxUnvan.getSelectedItem().toString().equals("UNVAN SEÇİNİZ")||comboBoxMerkez.getSelectedItem().toString().equals("MÜDÜRLÜĞÜ SEÇİNİZ")||comboBoxYaka.getSelectedItem().toString().equals("YAKA SEÇİNİZ")
						||textFieldAdet.getText().equals("")) { 
						JOptionPane.showMessageDialog(null," Yandaki Listeden ilgilinin Bulundugu Satiri Seciniz...");
				}
			
				else {
				   			    	
					
				/*	TableModel tableModel=table.getModel();
	        		Object secili=tableModel.getValueAt(seciliKayit, 0);
	        		String seciliString=String.valueOf(secili);*/
	        		
	        		EksiklerDomain updateUser=veriBul(seciliString);
					
					
				    	  
				    	  if(updateUser!=null) {
				    		  
				    		 				    		  
				    		  
				    		  updateUser.setMerkez(comboBoxMerkez.getSelectedItem().toString());
				    		  updateUser.setYaka(comboBoxYaka.getSelectedItem().toString());
				    		  updateUser.setUnvan(comboBoxUnvan.getSelectedItem().toString());
				    		  updateUser.setAdet(textFieldAdet.getText());				    	  
				    		  updateUser.setAciklama(textAreaAciklama.getText());
				    	
				    		  
				    	 
				    		  eksikGuncelle(updateUser);
				    		  table.setModel(eksikBulDefaultTableModel());	
				    	  
							JOptionPane.showMessageDialog(null,"Guncelleme Basarili");
							
							table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    
						    TableColumn col0 = table.getColumnModel().getColumn(0);
						    TableColumn col1 = table.getColumnModel().getColumn(1);
						    TableColumn col2 = table.getColumnModel().getColumn(2);
						    TableColumn col3 = table.getColumnModel().getColumn(3);
						    TableColumn col4 = table.getColumnModel().getColumn(4);
						    TableColumn col5 = table.getColumnModel().getColumn(5);
						    
						    col0.setPreferredWidth(20);
						    col1.setPreferredWidth(80);
						    col2.setPreferredWidth(350);
						    col3.setPreferredWidth(140);
						    col4.setPreferredWidth(40);
						    col5.setPreferredWidth(400);
							
							
							
							comboBoxMerkez.setSelectedItem("MÜDÜRLÜĞÜ SEÇİNİZ");
							textFieldAdet.setText("");							
							comboBoxUnvan.setSelectedItem("UNVAN SEÇİNİZ");
													
							comboBoxYaka.setSelectedItem("YAKA SEÇİNİZ");
							textAreaAciklama.setText("");								
				    	  }
				    	  else {
				    		  JOptionPane.showMessageDialog(null," Yandaki Listeden Kaydin Bulundugu Satiri Seciniz...");			    		  
				    	  }								
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnGuncelle.setBackground(UIManager.getColor("Button.light"));
		btnGuncelle.setBounds(80, 401, 83, 23);
		panel_1.add(btnGuncelle);
		
		
		
		
		JLabel lblAciklama = new JLabel("Aciklamalar :");
		lblAciklama.setHorizontalAlignment(SwingConstants.LEFT);
		lblAciklama.setBounds(13, 280, 220, 24);
		panel_1.add(lblAciklama);
		
	
		
		
		
		
		table.setModel(eksikBulDefaultTableModel());
		setLocationRelativeTo(null); 
	
	
	
	
	
	    JButton btnSil = new JButton("Sil");
	    btnSil.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		if(table.getSelectedRow()>=0) {
	    		
	    		int n=JOptionPane.showConfirmDialog(null, "Kaydi Silmek istedigine Emin Misin?","UYARI !!", JOptionPane.YES_NO_OPTION);
				if(n==0) {	    		
	    		eksikSil(silinecekRowID);
	    		table.setModel(eksikBulDefaultTableModel());
	    		
	    		
	    		JOptionPane.showMessageDialog(null, "kayit silindi");
	    		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    
			    TableColumn col0 = table.getColumnModel().getColumn(0);
			    TableColumn col1 = table.getColumnModel().getColumn(1);
			    TableColumn col2 = table.getColumnModel().getColumn(2);
			    TableColumn col3 = table.getColumnModel().getColumn(3);
			    TableColumn col4 = table.getColumnModel().getColumn(4);
			    TableColumn col5 = table.getColumnModel().getColumn(5);
			    
			    col0.setPreferredWidth(20);
			    col1.setPreferredWidth(80);
			    col2.setPreferredWidth(350);
			    col3.setPreferredWidth(140);
			    col4.setPreferredWidth(40);
			    col5.setPreferredWidth(400);
				
				
				
				}
				else {
					
				}
	    		}
	    		else {
	    			
	    			JOptionPane.showMessageDialog(null, "kayit secilmedi");
	    		}
	    	}
	    });
	    
	    
	    //
	   
	//
	 	
	
	
		btnSil.setBackground(UIManager.getColor("Button.light"));
		btnSil.setBounds(173, 401, 60, 23);
		panel_1.add(btnSil);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Eksikler.this.dispose();
				AnaMenu eksikler=new AnaMenu();
				eksikler.setVisible(true);
				
			}
		});
		btnGeri.setBackground(UIManager.getColor("Button.light"));
		btnGeri.setBounds(10, 489, 60, 23);
		panel_1.add(btnGeri);
		
		Icon bayrakp=new ImageIcon("ikonlar/pttkus.png");
		JLabel lblNewLabel_1 = new JLabel(bayrakp);
		lblNewLabel_1.setBounds(10, 11, 223, 124);
		panel_1.add(lblNewLabel_1);
	
		
		
		
		 table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		        public void valueChanged(ListSelectionEvent event) {
		        	
		        	seciliKayit=table.getSelectedRow();
		        	
		        	if(seciliKayit>=0) {
		        		TableModel tableModel=table.getModel();
		        		Object secili=tableModel.getValueAt(seciliKayit, 0);
		        		seciliString=String.valueOf(secili);
		        		
		        		EksiklerDomain eksiklerDomain=veriBul(seciliString);
		        		silinecekRowID=eksiklerDomain.getId();
		        		aciklama= eksiklerDomain.getAciklama();
		        		adet=eksiklerDomain.getAdet();
		        		merkez=eksiklerDomain.getMerkez();
		        		unvan=eksiklerDomain.getUnvan();
		        		yakalar=eksiklerDomain.getYaka();
		        		
		        		
		        		comboBoxYaka.setSelectedItem(yakalar);
		        		comboBoxUnvan.setSelectedItem(unvan);
		        		comboBoxMerkez.setSelectedItem(merkez);
		        		textFieldAdet.setText(adet);
		        		textAreaAciklama.setText(aciklama);
		        		
		        		
		        	}
		        	
		        	
		        	
		        }
		    });
		
	
	  
		
		
		
		
		
		
		
		
		
		 	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    
		    TableColumn col0 = table.getColumnModel().getColumn(0);
		    TableColumn col1 = table.getColumnModel().getColumn(1);
		    TableColumn col2 = table.getColumnModel().getColumn(2);
		    TableColumn col3 = table.getColumnModel().getColumn(3);
		    TableColumn col4 = table.getColumnModel().getColumn(4);
		    TableColumn col5 = table.getColumnModel().getColumn(5);
		    
		    col0.setPreferredWidth(20);
		    col1.setPreferredWidth(80);
		    col2.setPreferredWidth(350);
		    col3.setPreferredWidth(140);
		    col4.setPreferredWidth(40);
		    col5.setPreferredWidth(400);
		    
		
		
		
		
		    
	   
		    JTableToExcel.MudurlukveSicilGetir(table);
		    
		    JButton btn = new JButton("Excele Aktar");
		    btn.setBounds(10, 495, 106, 23);
		    panel.add(btn);
		    btn.setBackground(UIManager.getColor("Button.light"));
		    btn.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		
		    		
		    		JTableToExcel eksiklerliste=new JTableToExcel();
		    		eksiklerliste.setVisible(true);
		    		
		    	
		    		
		    		
		    		
		    	}	
		    });
	
	
	}
	
	
	
	
	public void eksikEkle (EksiklerDomain eksikEklenecekMerkez) 
	{
		
		Connection baglanti=DataBaseConn.baglantiAl();
		//tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
							
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO eksikler (yaka, merkez, unvan, adet, aciklama) VALUES (?,?,?,?,?)");
		
			sorguPreparedStatement.setString(1, eksikEklenecekMerkez.getYaka().toUpperCase());
			sorguPreparedStatement.setString(2, eksikEklenecekMerkez.getMerkez().toUpperCase());
			sorguPreparedStatement.setString(3, eksikEklenecekMerkez.getUnvan().toUpperCase());
			sorguPreparedStatement.setString(4, eksikEklenecekMerkez.getAdet().toUpperCase());
			sorguPreparedStatement.setString(5, eksikEklenecekMerkez.getAciklama().toUpperCase());
										
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}	
							
	}

	public static void eksikSil(int eksikSilinecekMerkez) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM eksikler WHERE id=?");
			sorgu.setInt(1, eksikSilinecekMerkez);
			sorgu.executeUpdate();									
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eksikGuncelle(EksiklerDomain guncellenecekEksiknDomain) {
		
		Connection baglanti=DataBaseConn.baglantiAl();
		try {                                                        
			PreparedStatement sorgu =baglanti.prepareStatement("UPDATE eksikler SET yaka=? , merkez=? , unvan=? , adet=? , aciklama=? WHERE id=?");
		sorgu.setString(1, guncellenecekEksiknDomain.getYaka().toUpperCase());	
		sorgu.setString(2, guncellenecekEksiknDomain.getMerkez().toUpperCase());	
		sorgu.setString(3, guncellenecekEksiknDomain.getUnvan().toUpperCase());	
		sorgu.setString(4, guncellenecekEksiknDomain.getAdet().toUpperCase());	
		sorgu.setString(5, guncellenecekEksiknDomain.getAciklama().toUpperCase());				
		sorgu.setInt(6, guncellenecekEksiknDomain.getId());
			
		sorgu.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}							
	}

	public static DefaultTableModel eksikBulDefaultTableModel() {
		 model=new DefaultTableModel();		 	 
		 Object[] kolonlar= {"id","YAKA","MUDURLUK","UNVAN","ADET","ACIKLAMA"}; 		 		 
		 Object[] satirlar=new Object[50];
		 Connection baglanti =DataBaseConn.baglantiAl();			 		 
		 model.setColumnIdentifiers(kolonlar);					 		
		try {						
			//PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM eksikler WHERE merkez LIKE ?");			
			//sorgu.setString(1,"%"+disiplin.toUpperCase()+"%");			
			
			PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM eksikler ORDER BY yaka ASC, merkez ASC, unvan ASC");			
			
			ResultSet rs=sorgu.executeQuery();							
			while(rs.next()) {	
				
				satirlar[0]=rs.getString("id");
				satirlar[1]=rs.getString("yaka");
				satirlar[2]=rs.getString("merkez");
				satirlar[3]=rs.getString("unvan");
				satirlar[4]=rs.getString("adet");
				satirlar[5]=rs.getString("aciklama");
				
				model.addRow(satirlar);				
			}												
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;				
	}
	
	
	public static EksiklerDomain veriBul(String id) {
		
		EksiklerDomain bulunanVeri= new EksiklerDomain();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {									
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM eksikler WHERE id=?");
			sorgu2.setString(1, id);			
			ResultSet rs2=sorgu2.executeQuery();			
		while(rs2.next()) {	
				
			bulunanVeri.setId(rs2.getInt("id"));
			bulunanVeri.setYaka(rs2.getString("yaka"));
			bulunanVeri.setMerkez(rs2.getString("merkez"));
			bulunanVeri.setUnvan(rs2.getString("unvan"));
			bulunanVeri.setAdet(rs2.getString("adet"));
			bulunanVeri.setAciklama(rs2.getString("aciklama"));
										
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bulunanVeri;
	}


	

	






}
