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
		
		String[] yaka= {"YAKA SE????N??Z","AVRUPA","ANADOLU"};
		
		String [] unvanlar = {"UNVAN SE????N??Z","YAYA DA??ITICI","POSTA-AYRIM","MOTOS??KLETL?? DA??ITICI","TEM??ZL??K","G??VENL??K","ENGELL??","D????ER"};
		
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

				if(comboBoxUnvan.getSelectedItem().toString().equals("UNVAN SE????N??Z")||comboBoxMerkez.getSelectedItem().toString().equals("M??D??RL?????? SE????N??Z")||comboBoxYaka.getSelectedItem().toString().equals("YAKA SE????N??Z")
						||textFieldAdet.getText().equals("")) { 
						JOptionPane.showMessageDialog(null,"Gerekli Alanlari Doldurunuz (A??IKLAMA ??STE??E BA??LI)");
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
							
							
							
							

							comboBoxMerkez.setSelectedItem("M??D??RL?????? SE????N??Z");
							textFieldAdet.setText("");							
							comboBoxUnvan.setSelectedItem("UNVAN SE????N??Z");
													
							comboBoxYaka.setSelectedItem("YAKA SE????N??Z");
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
				
				if(comboBoxUnvan.getSelectedItem().toString().equals("UNVAN SE????N??Z")||comboBoxMerkez.getSelectedItem().toString().equals("M??D??RL?????? SE????N??Z")||comboBoxYaka.getSelectedItem().toString().equals("YAKA SE????N??Z")
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
							
							
							
							comboBoxMerkez.setSelectedItem("M??D??RL?????? SE????N??Z");
							textFieldAdet.setText("");							
							comboBoxUnvan.setSelectedItem("UNVAN SE????N??Z");
													
							comboBoxYaka.setSelectedItem("YAKA SE????N??Z");
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
