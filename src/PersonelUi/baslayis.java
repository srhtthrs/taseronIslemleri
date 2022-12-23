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
import PersonelDomain.BaslayisDomain;
import PersonelDomain.NotDomain;
import PersonelDomain.PersDomain;

import java.awt.Color;
import java.awt.Dimension;
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
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class baslayis extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldtckn;
	private JTextField textFieldisim;
	private JTextField textFieldtarih;
	private JTextField textFieldmerkez;
	private JTextField textFieldunvan;
	String chckbxYasakliString;
	String chckbxEhliyetString;
	String chckbxAdliSicilString;
	String chckbxSrcString;
	String chckbxSaglikRaporuString;
	String chckbxPsikoString;
	String chckbxDiplomaString;
	String chckbxIkametgahString;
	String chckbxSozlesmeString;
	String chckbxKimlikString;
	String chckbxBildirgeString;
	String chckBoxTakipCikarString;
	
	
	private JTextField textFieldAra;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					baslayis frame = new baslayis();
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
	public baslayis() {
		setResizable(false);
		setTitle("BASLAYIS");
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
		
		JLabel lblNewLabel = new JLabel("TCKN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 50, 127, 42);
		panel.add(lblNewLabel);
		
		textFieldtckn = new JTextField();
		textFieldtckn.setForeground(new Color(165, 42, 42));
		textFieldtckn.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldtckn.setBackground(SystemColor.info);
		textFieldtckn.setBounds(147, 50, 306, 42);
		panel.add(textFieldtckn);
		textFieldtckn.setColumns(10);
		
		textFieldisim = new JTextField();
		textFieldisim.setForeground(new Color(165, 42, 42));
		textFieldisim.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldisim.setColumns(10);
		textFieldisim.setBackground(SystemColor.info);
		textFieldisim.setBounds(147, 103, 306, 42);
		panel.add(textFieldisim);
		
		JLabel lblAdSoyad = new JLabel("AD SOYAD");
		lblAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdSoyad.setBounds(10, 103, 127, 42);
		panel.add(lblAdSoyad);
		
		textFieldtarih = new JTextField();
		textFieldtarih.setForeground(new Color(165, 42, 42));
		textFieldtarih.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldtarih.setColumns(10);
		textFieldtarih.setBackground(SystemColor.info);
		textFieldtarih.setBounds(147, 156, 306, 42);
		panel.add(textFieldtarih);
		
		JLabel lblTarh = new JLabel("TARIH");
		lblTarh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTarh.setBounds(10, 156, 127, 42);
		panel.add(lblTarh);
		
		textFieldmerkez = new JTextField();
		textFieldmerkez.setForeground(new Color(165, 42, 42));
		textFieldmerkez.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldmerkez.setColumns(10);
		textFieldmerkez.setBackground(SystemColor.info);
		textFieldmerkez.setBounds(147, 209, 306, 42);
		panel.add(textFieldmerkez);
		
		JLabel lblMerkez = new JLabel("MERKEZ");
		lblMerkez.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMerkez.setBounds(10, 209, 127, 42);
		panel.add(lblMerkez);
		
		textFieldunvan = new JTextField();
		textFieldunvan.setForeground(new Color(165, 42, 42));
		textFieldunvan.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldunvan.setColumns(10);
		textFieldunvan.setBackground(SystemColor.info);
		textFieldunvan.setBounds(147, 262, 306, 42);
		panel.add(textFieldunvan);
		
		JLabel lblUnvan = new JLabel("UNVAN");
		lblUnvan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnvan.setBounds(10, 262, 127, 42);
		panel.add(lblUnvan);
		
		JLabel lblAcklama = new JLabel("ACIKLAMALAR");
		lblAcklama.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcklama.setForeground(Color.BLACK);
		lblAcklama.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAcklama.setBounds(10, 312, 443, 16);
		panel.add(lblAcklama);
		
		
		
		
		
		
		
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
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(list);
		list.setForeground(Color.WHITE);
		list.setBackground(new Color(95, 158, 160));
		
		
		list.setListData(kisiListele().toArray());
		
	
		
		setLocationRelativeTo(null); 
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 406, 443, 229);
		panel.add(panel_2);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setLayout(null);
		
		JCheckBox chckbxKimlik = new JCheckBox("Kimlik");
		chckbxKimlik.setForeground(Color.BLACK);
		chckbxKimlik.setBounds(6, 153, 201, 25);
		panel_2.add(chckbxKimlik);
		chckbxKimlik.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxKimlik.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxIkametgah = new JCheckBox("Ikametgah");
		chckbxIkametgah.setForeground(Color.BLACK);
		chckbxIkametgah.setBounds(228, 129, 201, 25);
		panel_2.add(chckbxIkametgah);
		chckbxIkametgah.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxIkametgah.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxPsiko = new JCheckBox("Psiko-Teknik");
		chckbxPsiko.setForeground(SystemColor.controlDkShadow);
		chckbxPsiko.setBounds(228, 101, 201, 25);
		panel_2.add(chckbxPsiko);
		chckbxPsiko.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxPsiko.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxSrc = new JCheckBox("SRC");
		chckbxSrc.setForeground(SystemColor.controlDkShadow);
		chckbxSrc.setBounds(228, 74, 201, 25);
		panel_2.add(chckbxSrc);
		chckbxSrc.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxSrc.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxEhliyet = new JCheckBox("Ehliyet");
		chckbxEhliyet.setForeground(SystemColor.controlDkShadow);
		chckbxEhliyet.setBounds(228, 46, 201, 25);
		panel_2.add(chckbxEhliyet);
		chckbxEhliyet.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxEhliyet.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxBildirge = new JCheckBox("Bildirge");
		chckbxBildirge.setForeground(Color.BLACK);
		chckbxBildirge.setBounds(6, 13, 201, 25);
		panel_2.add(chckbxBildirge);
		chckbxBildirge.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxBildirge.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxSozlesme = new JCheckBox("Sozlesme");
		chckbxSozlesme.setForeground(Color.BLACK);
		chckbxSozlesme.setBounds(6, 97, 201, 25);
		panel_2.add(chckbxSozlesme);
		chckbxSozlesme.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxSozlesme.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxDiploma = new JCheckBox("Diploma");
		chckbxDiploma.setForeground(Color.BLACK);
		chckbxDiploma.setBounds(6, 69, 201, 25);
		panel_2.add(chckbxDiploma);
		chckbxDiploma.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxDiploma.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxSaglikRaporu = new JCheckBox("Saglik Raporu");
		chckbxSaglikRaporu.setForeground(Color.BLACK);
		chckbxSaglikRaporu.setBounds(6, 125, 201, 25);
		panel_2.add(chckbxSaglikRaporu);
		chckbxSaglikRaporu.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxSaglikRaporu.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxAdliSicil = new JCheckBox("Adli Sicil");
		chckbxAdliSicil.setForeground(Color.BLACK);
		chckbxAdliSicil.setBounds(6, 41, 201, 25);
		panel_2.add(chckbxAdliSicil);
		chckbxAdliSicil.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxAdliSicil.setBackground(SystemColor.activeCaption);
		
		JCheckBox chckbxYasakli = new JCheckBox("Yasakli Kontrol");
		chckbxYasakli.setForeground(new Color(0, 0, 0));
		chckbxYasakli.setBounds(228, 13, 201, 25);
		panel_2.add(chckbxYasakli);
		chckbxYasakli.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxYasakli.setBackground(SystemColor.activeCaption);
		
		JLabel lblEvrakTamam = new JLabel("Onemli Evraklari Tamamlanmis");
		lblEvrakTamam.setVisible(false);
		lblEvrakTamam.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvrakTamam.setForeground(new Color(0, 128, 0));
		lblEvrakTamam.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblEvrakTamam.setBounds(6, 185, 423, 37);
		panel_2.add(lblEvrakTamam);
		
		JLabel lblEvrakEksik = new JLabel("Eksik Evraklari Var");
		lblEvrakEksik.setVisible(false);
		lblEvrakEksik.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvrakEksik.setForeground(new Color(165, 42, 42));
		lblEvrakEksik.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblEvrakEksik.setBounds(6, 185, 423, 37);
		panel_2.add(lblEvrakEksik);
		
		JCheckBox chckBoxTakipCikar = new JCheckBox("Takipten Cikar");
		chckBoxTakipCikar.setForeground(Color.BLUE);
		chckBoxTakipCikar.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckBoxTakipCikar.setBackground(SystemColor.activeCaption);
		chckBoxTakipCikar.setBounds(228, 156, 201, 25);
		panel_2.add(chckBoxTakipCikar);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 330, 443, 65);
		panel.add(scrollPane_2);
		
		JTextArea textAreaAciklama = new JTextArea();
		scrollPane_2.setViewportView(textAreaAciklama);
		textAreaAciklama.setFont(new Font("Monospaced", Font.BOLD, 14));
		textAreaAciklama.setForeground(new Color(165, 42, 42));
		textAreaAciklama.setBackground(SystemColor.info);
		
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				BaslayisDomain silinecekKisiDomain =(BaslayisDomain)list.getSelectedValue();
				if(silinecekKisiDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Kişiyi Silmek istedigine Emin Misin?","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						
						kisiSil(silinecekKisiDomain);
						
						list.setListData(kisiListele().toArray());	
						
						JOptionPane.showMessageDialog(null," Kayit Silindi");
						//System.out.println(silinecekKisiDomain.toString());
						textFieldtckn.setText("");
						textFieldisim.setText("");
						textFieldmerkez.setText("");
						textFieldunvan.setText("");
						textFieldtarih.setText("");
						//textFieldaciklama.setText("");
						textAreaAciklama.setText("");
						
						
						chckbxYasakli.setSelected(false);
						chckbxKimlik.setSelected(false);
						chckbxEhliyet.setSelected(false);
						chckbxSrc.setSelected(false);
						chckbxPsiko.setSelected(false);
						chckbxAdliSicil.setSelected(false);
						chckbxSaglikRaporu.setSelected(false);
						chckbxIkametgah.setSelected(false);
						chckbxDiploma.setSelected(false);
						chckbxSozlesme.setSelected(false);
						chckbxBildirge.setSelected(false);
						chckBoxTakipCikar.setSelected(false);
						
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
				
			
				
				

				if(textFieldtckn.getText().equals("")||textFieldisim.getText().equals("")||textFieldtarih.getText().equals("")||textFieldunvan.getText().equals("")||textFieldmerkez.getText().equals("")) { 
						JOptionPane.showMessageDialog(null,"Gerekli Alanlari Doldurunuz (TCKN, ISIM, TARIH, MERKEZ, UNVAN)");
				}					
				else {
				      try {					
				    	  
				    	  BaslayisDomain addBaslayis=new BaslayisDomain();	
				    	  
				    	 
				    	  addBaslayis.setTckn(textFieldtckn.getText());
				    	  addBaslayis.setAdiSoyadi(textFieldisim.getText());
				    	  addBaslayis.setTarih(textFieldtarih.getText());
				    	  addBaslayis.setMerkez(textFieldmerkez.getText());
				    	  addBaslayis.setUnvan(textFieldunvan.getText());
				    	 // addBaslayis.setAciklama(textFieldaciklama.getText());
				    	  addBaslayis.setAciklama(textAreaAciklama.getText());
				    	  
				    	  
				    	  if(chckbxYasakli.isSelected()==true) {
				    		 chckbxYasakliString="KONTROL_EDILDI";				    	
				    	  }
				    	  else {
				    		  chckbxYasakliString="KONTROL_EDILMEDI";				    		 
				    	  }
				    	  
				    	
				    	  
				    	  if(chckbxEhliyet.isSelected()==true) {
				    		  chckbxEhliyetString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxEhliyetString="YOK";				    		 
					    	  }
				    	  
				    	  if(chckbxAdliSicil.isSelected()==true) {
				    		  chckbxAdliSicilString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxAdliSicilString="YOK";				    		 
					    	  }
				    	  
				    	  if(chckbxSrc.isSelected()==true) {
				    		  chckbxSrcString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxSrcString="YOK";				    		 
					    	  }
				    	  
				    	  if(chckbxSaglikRaporu.isSelected()==true) {
				    		  chckbxSaglikRaporuString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxSaglikRaporuString="YOK";				    		 
					    	  }
				    	  

				    	  if(chckbxPsiko.isSelected()==true) {
				    		  chckbxPsikoString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxPsikoString="YOK";				    		 
					    	  }
				    	  
				    	  if(chckbxDiploma.isSelected()==true) {
				    		  chckbxDiplomaString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxDiplomaString="YOK";				    		 
					    	  }
				    	  
				    	  if(chckbxIkametgah.isSelected()==true) {
				    		  chckbxIkametgahString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxIkametgahString="YOK";				    		 
					    	  }
				    	  
				    	  if(chckbxSozlesme.isSelected()==true) {
				    		  chckbxSozlesmeString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxSozlesmeString="YOK";				    		 
					    	  }
				    		
				    	  if(chckbxKimlik.isSelected()==true) {
				    		  chckbxKimlikString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxKimlikString="YOK";				    		 
					    	  }
				    		
				    	  if(chckbxBildirge.isSelected()==true) {
				    		  chckbxBildirgeString="GELDI";				    	
					    	  }
					    	  else {
					    		  chckbxBildirgeString="YOK";				    		 
					    	  }
				    		
				    	  
				    	 
				    	  
				    	  if(chckBoxTakipCikar.isSelected()==true) {
				    		  chckBoxTakipCikarString="AAATAKIPCIKAR";				    	
					    	  }
					    	  else {
					    		  chckBoxTakipCikarString="YOK";				    		 
					    	  }
				    	  
				 				    	  
				    	  			    	  
				    	  //*********
				   	    addBaslayis.setYasakliKontrol(chckbxYasakliString);
				    	addBaslayis.setKimlik(chckbxKimlikString);
				    	
				    	
				    	  addBaslayis.setEhliyet(chckbxEhliyetString);
				    	  addBaslayis.setSrc(chckbxSrcString);
				    	  addBaslayis.setPsikoTeknik(chckbxPsikoString);
				    	  addBaslayis.setAdliSicil(chckbxAdliSicilString);
				    	  addBaslayis.setSaglikRaporu(chckbxSaglikRaporuString);
				    	  addBaslayis.setIkametgah(chckbxIkametgahString);
				    	  addBaslayis.setDiploma(chckbxDiplomaString);
				    	  addBaslayis.setSozlesme(chckbxSozlesmeString);
				    	  addBaslayis.setBildirge(chckbxBildirgeString);
				    	  
				    	  addBaslayis.setTakipCikar(chckBoxTakipCikarString);
				    	  
				    	  
				    	  
				    	  
				    	  //*********
				    	  
				    	 					    	  
				    	   baslayisEkle(addBaslayis);	
				    	  
							JOptionPane.showMessageDialog(null,"Kayit Basarili");									
							textFieldtckn.setText("");
							textFieldisim.setText("");
							textFieldmerkez.setText("");
							textFieldunvan.setText("");
							textFieldtarih.setText("");
						//	textFieldaciklama.setText("");
							textAreaAciklama.setText("");
							
							chckbxYasakli.setSelected(false);
							chckbxKimlik.setSelected(false);
							chckbxEhliyet.setSelected(false);
							chckbxSrc.setSelected(false);
							chckbxPsiko.setSelected(false);
							chckbxAdliSicil.setSelected(false);
							chckbxSaglikRaporu.setSelected(false);
							chckbxIkametgah.setSelected(false);
							chckbxDiploma.setSelected(false);
							chckbxSozlesme.setSelected(false);
							chckbxBildirge.setSelected(false);
							chckBoxTakipCikar.setSelected(false);
							
														    																			
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
		textFieldAra.setBorder(new LineBorder(new Color(171, 173, 179)));
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
		textFieldAra.setBounds(102, 11, 341, 42);
		panel_1.add(textFieldAra);
		
		Icon search=new ImageIcon("ikonlar/search.jpg");
		JLabel lblTcknara = new JLabel(search);
		lblTcknara.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTcknara.setHorizontalAlignment(SwingConstants.CENTER);
		lblTcknara.setForeground(new Color(255, 255, 255));
		lblTcknara.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcknara.setBounds(10, 11, 82, 42);
		panel_1.add(lblTcknara);
		
	
		
		
		JButton btnGuncelle = new JButton("Guncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
								
				if(textFieldtckn.getText().equals("") || textFieldisim.getText().equals("")|| textFieldtarih.getText().equals("")|| textFieldmerkez.getText().equals("")|| textFieldunvan.getText().equals(""))										
				{
					JOptionPane.showMessageDialog(null," Yandaki Listeden ilgilinin Bulundugu Satiri Seciniz...");
				}		
				else {
				   			    	  
				    	  BaslayisDomain addUser=(BaslayisDomain) list.getSelectedValue();
				    	  
				    	  if(addUser!=null) {
				    		  
				    	  addUser.setTckn(textFieldtckn.getText());
				    	  addUser.setAdiSoyadi(textFieldisim.getText());				    	  
				    	  addUser.setTarih(textFieldtarih.getText());
				    	  addUser.setMerkez(textFieldmerkez.getText());	
				    	  addUser.setUnvan(textFieldunvan.getText());
				    	  //addUser.setAciklama(textFieldaciklama.getText());
				    	  addUser.setAciklama(textAreaAciklama.getText());
				    	  
				    	  if(chckbxYasakli.isSelected()==true) {
					    		 chckbxYasakliString="KONTROL_EDILDI";				    	
					    	  }
					    	  else {
					    		  chckbxYasakliString="KONTROL_EDILMEDI";				    		 
					    	  }
					    	  
					    	
					    	  
					    	  if(chckbxEhliyet.isSelected()==true) {
					    		  chckbxEhliyetString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxEhliyetString="YOK";				    		 
						    	  }
					    	  
					    	  if(chckbxAdliSicil.isSelected()==true) {
					    		  chckbxAdliSicilString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxAdliSicilString="YOK";				    		 
						    	  }
					    	  
					    	  if(chckbxSrc.isSelected()==true) {
					    		  chckbxSrcString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxSrcString="YOK";				    		 
						    	  }
					    	  
					    	  if(chckbxSaglikRaporu.isSelected()==true) {
					    		  chckbxSaglikRaporuString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxSaglikRaporuString="YOK";				    		 
						    	  }
					    	  

					    	  if(chckbxPsiko.isSelected()==true) {
					    		  chckbxPsikoString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxPsikoString="YOK";				    		 
						    	  }
					    	  
					    	  if(chckbxDiploma.isSelected()==true) {
					    		  chckbxDiplomaString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxDiplomaString="YOK";				    		 
						    	  }
					    	  
					    	  if(chckbxIkametgah.isSelected()==true) {
					    		  chckbxIkametgahString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxIkametgahString="YOK";				    		 
						    	  }
					    	  
					    	  if(chckbxSozlesme.isSelected()==true) {
					    		  chckbxSozlesmeString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxSozlesmeString="YOK";				    		 
						    	  }
					    		
					    	  if(chckbxKimlik.isSelected()==true) {
					    		  chckbxKimlikString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxKimlikString="YOK";				    		 
						    	  }
					    		
					    	  
					    	  if(chckbxBildirge.isSelected()==true) {
					    		  chckbxBildirgeString="GELDI";				    	
						    	  }
						    	  else {
						    		  chckbxBildirgeString="YOK";				    		 
						    	  }
					    	  
					    	  
					    	  
					    	  if(chckBoxTakipCikar.isSelected()==true) {
					    		  chckBoxTakipCikarString="AAATAKIPCIKAR";				    	
						    	  }
						    	  else {
						    		  chckBoxTakipCikarString="YOK";				    		 
						    	  }
					    	  
					    	  
					    		
					 				    	  
					    	  			    	  
					    	  //*********
					    	  addUser.setYasakliKontrol(chckbxYasakliString);
					    	  addUser.setKimlik(chckbxKimlikString);
					    	
					    	
					    	  addUser.setEhliyet(chckbxEhliyetString);
					    	  addUser.setSrc(chckbxSrcString);
					    	  addUser.setPsikoTeknik(chckbxPsikoString);
					    	  addUser.setAdliSicil(chckbxAdliSicilString);
					    	  addUser.setSaglikRaporu(chckbxSaglikRaporuString);
					    	  addUser.setIkametgah(chckbxIkametgahString);
					    	  addUser.setDiploma(chckbxDiplomaString);
					    	  addUser.setSozlesme(chckbxSozlesmeString);
					    	  addUser.setBildirge(chckbxBildirgeString);
					    	  addUser.setTakipCikar(chckBoxTakipCikarString);
				    	  
				    	  
				    	  
				    	  
				    	  
				    	  
				    	  			    	  				    				    	  
				    	  
				    	 
				    	  kisiGuncelle(addUser);	
				    	  
							JOptionPane.showMessageDialog(null,"Guncelleme Basarili");	
							
							
							list.setListData(kisiListele().toArray());
							
							textFieldtckn.setText("");
							textFieldisim.setText("");
							textFieldtarih.setText("");
							textFieldmerkez.setText("");
							textFieldunvan.setText("");
							//textFieldaciklama.setText("");
							textAreaAciklama.setText("");
							
							
							chckbxYasakli.setSelected(false);
							chckbxKimlik.setSelected(false);
							chckbxEhliyet.setSelected(false);
							chckbxSrc.setSelected(false);
							chckbxPsiko.setSelected(false);
							chckbxAdliSicil.setSelected(false);
							chckbxSaglikRaporu.setSelected(false);
							chckbxIkametgah.setSelected(false);
							chckbxDiploma.setSelected(false);
							chckbxSozlesme.setSelected(false);
							chckbxBildirge.setSelected(false);
							chckBoxTakipCikar.setSelected(false);
							
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
				textFieldmerkez.setText("");
				textFieldunvan.setText("");
				//textFieldaciklama.setText("");
				textAreaAciklama.setText("");
				
				
				
				chckbxYasakli.setSelected(false);
				chckbxKimlik.setSelected(false);
				chckbxEhliyet.setSelected(false);
				chckbxSrc.setSelected(false);
				chckbxPsiko.setSelected(false);
				chckbxAdliSicil.setSelected(false);
				chckbxSaglikRaporu.setSelected(false);
				chckbxIkametgah.setSelected(false);
				chckbxDiploma.setSelected(false);
				chckbxSozlesme.setSelected(false);
				chckbxBildirge.setSelected(false);
				chckBoxTakipCikar.setSelected(false);
				
			}
		});
		btnTemizle.setBackground(UIManager.getColor("Button.light"));
		btnTemizle.setBounds(278, 646, 87, 32);
		panel.add(btnTemizle);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				baslayis.this.dispose();
				AnaMenu mPane2sl=new AnaMenu();
				mPane2sl.setVisible(true);
				
			}
		});
		btnGeri.setBackground(UIManager.getColor("Button.light"));
		btnGeri.setBounds(375, 646, 78, 32);
		panel.add(btnGeri);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(210, 312, 155, -34);
		panel.add(scrollPane_1);
		
		JButton btnNewButton_1 = new JButton("Yasakli_Listesini_Kontrol_Ediniz...");
		btnNewButton_1.setBounds(10, 11, 443, 25);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(UIManager.getColor("Button.light"));
		btnNewButton_1.setForeground(new Color(165, 42, 42));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				baslayis.this.dispose();
				Yasakli mPane2l=new Yasakli();
				mPane2l.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				
				
				BaslayisDomain seciliKisiDomain=(BaslayisDomain)list.getSelectedValue();
				if(seciliKisiDomain!=null) {
					
					textFieldtckn.setText(seciliKisiDomain.getTckn());
					textFieldisim.setText(seciliKisiDomain.getAdiSoyadi());
					textFieldtarih.setText(seciliKisiDomain.getTarih());
					textFieldmerkez.setText(seciliKisiDomain.getMerkez());
					textFieldunvan.setText(seciliKisiDomain.getUnvan());
					//textFieldaciklama.setText(seciliKisiDomain.getAciklama());
					textAreaAciklama.setText(seciliKisiDomain.getAciklama());
					
					
					if(seciliKisiDomain.getYasakliKontrol().equals("KONTROL_EDILDI"))
					{chckbxYasakli.setSelected(true);
					chckbxYasakli.setBackground(SystemColor.activeCaption);}
					else if (seciliKisiDomain.getYasakliKontrol().equals("KONTROL_EDILMEDI")) {
						chckbxYasakli.setSelected(false);
						chckbxYasakli.setBackground(new Color(165, 42, 42));
						}
					
					if(seciliKisiDomain.getKimlik().equals("GELDI"))
					{chckbxKimlik.setSelected(true);
					chckbxKimlik.setBackground(SystemColor.activeCaption);}
					else if (seciliKisiDomain.getKimlik().equals("YOK")) {chckbxKimlik.setSelected(false);
					chckbxKimlik.setBackground(new Color(165, 42, 42));}
					
					if(seciliKisiDomain.getEhliyet().equals("GELDI"))
					{chckbxEhliyet.setSelected(true);
					}
					else if (seciliKisiDomain.getEhliyet().equals("YOK")) {chckbxEhliyet.setSelected(false);
					}
					
					if(seciliKisiDomain.getSrc().equals("GELDI"))
					{chckbxSrc.setSelected(true);
					}
					else if (seciliKisiDomain.getSrc().equals("YOK")) {chckbxSrc.setSelected(false);
					}
					
					if(seciliKisiDomain.getPsikoTeknik().equals("GELDI"))
					{chckbxPsiko.setSelected(true);
					}
					else if (seciliKisiDomain.getPsikoTeknik().equals("YOK")) {chckbxPsiko.setSelected(false);
					}
					
					if(seciliKisiDomain.getAdliSicil().equals("GELDI"))
					{chckbxAdliSicil.setSelected(true);
					chckbxAdliSicil.setBackground(SystemColor.activeCaption);}
					else if (seciliKisiDomain.getAdliSicil().equals("YOK")) {chckbxAdliSicil.setSelected(false);
					chckbxAdliSicil.setBackground(new Color(165, 42, 42));}
					
					if(seciliKisiDomain.getSaglikRaporu().equals("GELDI"))
					{chckbxSaglikRaporu.setSelected(true);
					chckbxSaglikRaporu.setBackground(SystemColor.activeCaption);}
					else if (seciliKisiDomain.getSaglikRaporu().equals("YOK")) {chckbxSaglikRaporu.setSelected(false);
					chckbxSaglikRaporu.setBackground(new Color(165, 42, 42));}
					
					if(seciliKisiDomain.getIkametgah().equals("GELDI"))
					{chckbxIkametgah.setSelected(true);
					chckbxIkametgah.setBackground(SystemColor.activeCaption);}
					else if (seciliKisiDomain.getIkametgah().equals("YOK")) {chckbxIkametgah.setSelected(false);
					chckbxIkametgah.setBackground(new Color(165, 42, 42));}
					
					if(seciliKisiDomain.getDiploma().equals("GELDI"))
					{chckbxDiploma.setSelected(true);
					chckbxDiploma.setBackground(SystemColor.activeCaption);}
					else if (seciliKisiDomain.getDiploma().equals("YOK")) {chckbxDiploma.setSelected(false);
					chckbxDiploma.setBackground(new Color(165, 42, 42));}
					
					if(seciliKisiDomain.getSozlesme().equals("GELDI"))
					{chckbxSozlesme.setSelected(true);
					chckbxSozlesme.setBackground(SystemColor.activeCaption);}
					else if (seciliKisiDomain.getSozlesme().equals("YOK")) {chckbxSozlesme.setSelected(false);
					chckbxSozlesme.setBackground(new Color(165, 42, 42));}
					
					if(seciliKisiDomain.getBildirge().equals("GELDI"))
					{chckbxBildirge.setSelected(true);
					chckbxBildirge.setBackground(SystemColor.activeCaption);}
					else if (seciliKisiDomain.getBildirge().equals("YOK")) {chckbxBildirge.setSelected(false);
					chckbxBildirge.setBackground(new Color(165, 42, 42));}
					
					
					if(seciliKisiDomain.getTakipCikar().equals("AAATAKIPCIKAR"))
					{chckBoxTakipCikar.setSelected(true);}
					else
					{chckBoxTakipCikar.setSelected(false);}
					
			
					
				
				} 
				
				
				if(		   chckbxBildirge.isSelected()==true && chckbxSozlesme.isSelected()==true
						&& chckbxDiploma.isSelected()==true && chckbxIkametgah.isSelected()==true
						&& chckbxAdliSicil.isSelected()==true && chckbxKimlik.isSelected()==true
						&& chckbxYasakli.isSelected()==true && chckbxSaglikRaporu.isSelected()==true) { 
					
						lblEvrakTamam.setVisible(true);
						lblEvrakEksik.setVisible(false);
					
						
						
						
						
						
					
						
						
				}
				
				else{ 
						lblEvrakTamam.setVisible(false);
						lblEvrakEksik.setVisible(true);
					
						
						
						
						
					
						
				}
				
				
				
			}});
		
		
		
		
		
	}
	
	
	
	public void baslayisEkle(BaslayisDomain baslayanKisi) 
	{
		
		Connection baglanti=DataBaseConn.baglantiAl();
		//tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
			
			//sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO baslayis (tckn,adisoyadi,tarih,merkez,unvan,aciklama,yasaklikontrol,kimlik,ehliyet,src,psikoteknik,adlisicil,saglikraporu,ikametgah,diploma,sozlesme,bildirge) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO baslayis (tckn, adisoyadi, tarih, merkez, unvan, aciklama, yasakli, ncuzdan, ehliyet, src, psikoteknik, adlisicil, saglikrap, ikametgah, diploma, sozlesme, bildirge, takipcikar) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


		
			sorguPreparedStatement.setString(1, baslayanKisi.getTckn().toUpperCase());
			sorguPreparedStatement.setString(2, baslayanKisi.getAdiSoyadi().toUpperCase());
			sorguPreparedStatement.setString(3, baslayanKisi.getTarih().toUpperCase());
			sorguPreparedStatement.setString(4, baslayanKisi.getMerkez().toUpperCase());
			sorguPreparedStatement.setString(5, baslayanKisi.getUnvan().toUpperCase());
			sorguPreparedStatement.setString(6, baslayanKisi.getAciklama().toUpperCase());
			
	     	sorguPreparedStatement.setString(7, baslayanKisi.getYasakliKontrol().toUpperCase());
			sorguPreparedStatement.setString(8, baslayanKisi.getKimlik().toUpperCase());
			
			sorguPreparedStatement.setString(9, baslayanKisi.getEhliyet().toUpperCase());
			
			
			sorguPreparedStatement.setString(10, baslayanKisi.getSrc().toUpperCase());
			sorguPreparedStatement.setString(11, baslayanKisi.getPsikoTeknik().toUpperCase());
			sorguPreparedStatement.setString(12, baslayanKisi.getAdliSicil().toUpperCase());
			sorguPreparedStatement.setString(13, baslayanKisi.getSaglikRaporu().toUpperCase());
			sorguPreparedStatement.setString(14, baslayanKisi.getIkametgah().toUpperCase());
			sorguPreparedStatement.setString(15, baslayanKisi.getDiploma().toUpperCase());
			sorguPreparedStatement.setString(16, baslayanKisi.getSozlesme().toUpperCase());
			sorguPreparedStatement.setString(17, baslayanKisi.getBildirge().toUpperCase());
			sorguPreparedStatement.setString(18, baslayanKisi.getTakipCikar().toUpperCase());
			
			
		
			
			
			
								
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}	
		
		
		
		
		
		
	}

	
	
	public static ArrayList<BaslayisDomain> kisiListele(){	
		ArrayList<BaslayisDomain> kisi= new ArrayList<BaslayisDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		
		
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM baslayis ORDER BY takipcikar DESC, bildirge DESC, sozlesme DESC, diploma DESC, ikametgah DESC, saglikrap DESC, adlisicil DESC, ncuzdan DESC, yasakli DESC, id DESC");	
			
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				BaslayisDomain siradakiDomain2=new BaslayisDomain();					
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setTckn(rs2.getString("tckn"));
				siradakiDomain2.setAdiSoyadi(rs2.getString("adisoyadi"));
				siradakiDomain2.setTarih(rs2.getString("tarih"));
				siradakiDomain2.setMerkez(rs2.getString("merkez"));
				siradakiDomain2.setUnvan(rs2.getString("unvan"));
				siradakiDomain2.setAciklama(rs2.getString("aciklama"));
				siradakiDomain2.setYasakliKontrol(rs2.getString("yasakli"));
				
				siradakiDomain2.setKimlik(rs2.getString("ncuzdan"));
				siradakiDomain2.setEhliyet(rs2.getString("ehliyet"));
				siradakiDomain2.setSrc(rs2.getString("src"));
				siradakiDomain2.setPsikoTeknik(rs2.getString("psikoteknik"));
				siradakiDomain2.setAdliSicil(rs2.getString("adlisicil"));
				siradakiDomain2.setSaglikRaporu(rs2.getString("saglikrap"));
				siradakiDomain2.setIkametgah(rs2.getString("ikametgah"));
				siradakiDomain2.setDiploma(rs2.getString("diploma"));
				siradakiDomain2.setSozlesme(rs2.getString("sozlesme"));
				siradakiDomain2.setBildirge(rs2.getString("bildirge"));
				siradakiDomain2.setTakipCikar(rs2.getString("takipcikar"));
				
				
											
				kisi.add(siradakiDomain2);	
				
				
				
			}
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}	
		
		
		
		return kisi;	
	}

	
	
	public static void kisiSil(BaslayisDomain silinecekKisiDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM baslayis WHERE id=?");
			sorgu.setInt(1, silinecekKisiDomain.getId());
			sorgu.executeUpdate();	
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	
	
	
	
	
	
	public static ArrayList<BaslayisDomain> kisiAra(String tcknString){	
		ArrayList<BaslayisDomain> kisi= new ArrayList<BaslayisDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM baslayis WHERE (tckn + adisoyadi) LIKE ? ORDER BY takipcikar DESC, bildirge DESC, sozlesme DESC, diploma DESC, ikametgah DESC, saglikrap DESC, adlisicil DESC, ncuzdan DESC, yasakli DESC, id DESC");	
			
			
			sorgu2.setString(1,"%"+ tcknString+"%");
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				BaslayisDomain siradakiDomain2=new BaslayisDomain();					
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setTckn(rs2.getString("tckn"));
				siradakiDomain2.setAdiSoyadi(rs2.getString("adisoyadi"));
				siradakiDomain2.setTarih(rs2.getString("tarih"));							
				siradakiDomain2.setMerkez(rs2.getString("merkez"));
				siradakiDomain2.setUnvan(rs2.getString("unvan"));
				siradakiDomain2.setAciklama(rs2.getString("aciklama"));
				siradakiDomain2.setYasakliKontrol(rs2.getString("yasakli"));
				
				siradakiDomain2.setKimlik(rs2.getString("ncuzdan"));
				siradakiDomain2.setEhliyet(rs2.getString("ehliyet"));
				siradakiDomain2.setSrc(rs2.getString("src"));
				siradakiDomain2.setPsikoTeknik(rs2.getString("psikoteknik"));
				siradakiDomain2.setAdliSicil(rs2.getString("adlisicil"));
				siradakiDomain2.setSaglikRaporu(rs2.getString("saglikrap"));
				siradakiDomain2.setIkametgah(rs2.getString("ikametgah"));
				siradakiDomain2.setDiploma(rs2.getString("diploma"));
				siradakiDomain2.setSozlesme(rs2.getString("sozlesme"));
				siradakiDomain2.setBildirge(rs2.getString("bildirge"));
				siradakiDomain2.setTakipCikar(rs2.getString("takipcikar"));
				
											
				kisi.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		
		return kisi;	
	}

	
	
	public static void kisiGuncelle(BaslayisDomain guncellenecekKisiDomain) {
		
		Connection baglanti=DataBaseConn.baglantiAl();
		try {                                                        
			PreparedStatement sorgu =baglanti.prepareStatement("UPDATE baslayis SET tckn=?, adisoyadi=?, tarih=?, merkez=?, unvan=?, aciklama=?, yasakli=?, ncuzdan=?, ehliyet=?, src=?, psikoteknik=?, adlisicil=?, saglikrap=?, ikametgah=?, diploma=?, sozlesme=?, bildirge=?, takipcikar=? WHERE id=?");
		sorgu.setString(1, guncellenecekKisiDomain.getTckn().toUpperCase());	
		sorgu.setString(2, guncellenecekKisiDomain.getAdiSoyadi().toUpperCase());	
		sorgu.setString(3, guncellenecekKisiDomain.getTarih().toUpperCase());	
		sorgu.setString(4, guncellenecekKisiDomain.getMerkez().toUpperCase());	
		sorgu.setString(5, guncellenecekKisiDomain.getUnvan().toUpperCase());
		sorgu.setString(6, guncellenecekKisiDomain.getAciklama().toUpperCase());
		
		sorgu.setString(7, guncellenecekKisiDomain.getYasakliKontrol().toUpperCase());
		sorgu.setString(8, guncellenecekKisiDomain.getKimlik().toUpperCase());
		sorgu.setString(9, guncellenecekKisiDomain.getEhliyet().toUpperCase());
		sorgu.setString(10, guncellenecekKisiDomain.getSrc().toUpperCase());
		sorgu.setString(11, guncellenecekKisiDomain.getPsikoTeknik().toUpperCase());
		sorgu.setString(12, guncellenecekKisiDomain.getAdliSicil().toUpperCase());
		sorgu.setString(13, guncellenecekKisiDomain.getSaglikRaporu().toUpperCase());
		sorgu.setString(14, guncellenecekKisiDomain.getIkametgah().toUpperCase());
		sorgu.setString(15, guncellenecekKisiDomain.getDiploma().toUpperCase());
		sorgu.setString(16, guncellenecekKisiDomain.getSozlesme().toUpperCase());
		sorgu.setString(17, guncellenecekKisiDomain.getBildirge().toUpperCase());
		sorgu.setString(18, guncellenecekKisiDomain.getTakipCikar().toUpperCase());
		
		
		
		sorgu.setInt(19, guncellenecekKisiDomain.getId());
		
		
		sorgu.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}


}




  
  
 
 









