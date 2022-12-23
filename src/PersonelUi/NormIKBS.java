package PersonelUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import PersonelDataBase.DataBaseConn;

import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Dimension;

public class NormIKBS extends JFrame {

	private JPanel contentPane;
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
	
	String[] unvanlar= {"Aşçı",
			"Aşçı Yardımcısı",
			"Bulaşıkçı",
			"Engelli(Ayrım)",
			"Engelli(Dağıtım)",
			"Engelli(Temizlik)",
			"Garson",
			"Güvenlik(Silahlı)",
			"Güvenlik(Silahsız)",
			"Hemşire (Kreş)",
			"Motosikletli Dağıtım",
			"Öğretmen(Kreş)",
			"Posta-Ayrım",
			"Ring Şoförü",
			"Temizlik",
			"Yardımcı Personel(Kreş)",
			"Yaya Dağıtım"};
	
	
	static DefaultTableModel model2;
	private JTable table;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NormIKBS frame = new NormIKBS();
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
	public NormIKBS() {
		setTitle("NORM IKBS SORGULA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 551);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(95, 158, 160), 2));
		scrollPane.setBackground(SystemColor.activeCaption);
		scrollPane.setBounds(10, 123, 931, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setSelectionBackground(Color.PINK);
		table.setForeground(Color.BLACK);
		
		table.setBackground(Color.WHITE);
		
		
		table.setGridColor(Color.BLACK);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		setLocationRelativeTo(null);
		
		JComboBox comboBoxMudurluk = new JComboBox(mudurlukler);
		comboBoxMudurluk.setForeground(new Color(128, 0, 0));
		comboBoxMudurluk.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxMudurluk.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String mudurluk=comboBoxMudurluk.getSelectedItem().toString();
				
				table.setModel(normMudurlukBul(mudurluk));
				
				
				
				
			}
			
			
		});
		comboBoxMudurluk.setBounds(210, 11, 500, 35);
		contentPane.add(comboBoxMudurluk);
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NormIKBS.this.dispose();
				AnaMenu amenu=new AnaMenu();
				amenu.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setBounds(10, 473, 89, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Mudurluge Gore Sirala");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 190, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblUnvanaGoreSirala = new JLabel("Unvana Gore Sirala");
		lblUnvanaGoreSirala.setForeground(Color.WHITE);
		lblUnvanaGoreSirala.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUnvanaGoreSirala.setBounds(10, 57, 190, 35);
		contentPane.add(lblUnvanaGoreSirala);
		
		JComboBox comboBoxUnvan = new JComboBox(unvanlar);
		comboBoxUnvan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String unvan=comboBoxUnvan.getSelectedItem().toString();
				
				table.setModel(normUnvanBul(unvan));
			}
		});
		comboBoxUnvan.setForeground(new Color(128, 0, 0));
		comboBoxUnvan.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxUnvan.setBounds(210, 57, 500, 35);
		contentPane.add(comboBoxUnvan);
		
	}
	
	
	public static DefaultTableModel normMudurlukBul(String mudurluk ) {
		 model2=new DefaultTableModel();
		 
		 
		 Object[] kolonlar= {"Unvan", "Yetki", "Asil","Bos_Yetki","Izin_Rapor","Yedek","Fiili_Calisan","Gecici"};  
		 
		 Object[] satirlar=new Object[20];
		 Connection baglantiAlNorm =DataBaseConn.baglantiAl();			 		 
		 model2.setColumnIdentifiers(kolonlar);					 		
		try {				
						
			PreparedStatement sorgu=baglantiAlNorm.prepareStatement("SELECT * FROM normikbs WHERE Merkez LIKE ?");
			
			sorgu.setString(1,mudurluk);
			ResultSet rs=sorgu.executeQuery();	
			
			
			while(rs.next()) {									
				
				
				satirlar[0]=rs.getString("Firma Görev Tipi");
				satirlar[1]=rs.getInt("Yetki");
				satirlar[2]=rs.getInt("Asil");
				satirlar[3]=rs.getInt("Boş Yetki");
				satirlar[4]=rs.getInt("İzinli/Raporlu Personel Sayısı");
				satirlar[5]=rs.getInt("Yedek");
				satirlar[6]=rs.getInt("Fiili Çalışan");
				satirlar[7]=rs.getInt("Gecici");
			
				
				
				model2.addRow(satirlar);				
			}
						
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model2;				
	}


	public static DefaultTableModel normUnvanBul(String unvan ) {
		 model2=new DefaultTableModel();
		 
		 
		 Object[] kolonlar= {"Mudurluk", "Yetki", "Asil","Bos_Yetki","Izin_Rapor","Yedek","Fiili_Calisan","Gecici"};  
		 
		 Object[] satirlar=new Object[20];
		 Connection baglantiAlNorm =DataBaseConn.baglantiAl();			 		 
		 model2.setColumnIdentifiers(kolonlar);					 		
		try {				
						
			PreparedStatement sorgu=baglantiAlNorm.prepareStatement("SELECT * FROM normikbs WHERE ([Firma Görev Tipi]) LIKE ?");
			
			sorgu.setString(1,unvan);
			ResultSet rs=sorgu.executeQuery();	
			
			
			while(rs.next()) {									
				
				
				satirlar[0]=rs.getString("Merkez");
				satirlar[1]=rs.getInt("Yetki");
				satirlar[2]=rs.getInt("Asil");
				satirlar[3]=rs.getInt("Boş Yetki");
				satirlar[4]=rs.getInt("İzinli/Raporlu Personel Sayısı");
				satirlar[5]=rs.getInt("Yedek");
				satirlar[6]=rs.getInt("Fiili Çalışan");
				satirlar[7]=rs.getInt("Gecici");
			
				
				
				model2.addRow(satirlar);				
			}
						
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model2;				
	}






}
