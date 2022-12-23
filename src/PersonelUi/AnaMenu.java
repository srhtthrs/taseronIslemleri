package PersonelUi;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import PersonelDataBase.ArsivSQL;
import PersonelDataBase.DataBaseConn;
import PersonelDomain.NotDomain;
import PersonelDomain.PersDomain;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AnaMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNot;

	
	
	 
   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaMenu frame = new AnaMenu();
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
	
	
	public AnaMenu() {
		
		LocalDateTime tarih = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String tarih2= dtf.format(tarih);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\sunay\\Desktop\\pttlogo1.jpg"));
		setResizable(false);
		setTitle("TAŞERON FİRMA ELEMANI İŞLEMLERİ     "+tarih2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1291, 643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Icon bayrakk=new ImageIcon("ikonlar/bayrakgif.gif");
		Icon bayrakp=new ImageIcon("ikonlar/pttkus.png");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(10, 11, 179, 583);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnDbBalan = new JButton("ACCESS_DB Bağlan");
		btnDbBalan.setBounds(10, 501, 159, 23);
		panel_3.add(btnDbBalan);
		btnDbBalan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDbBalan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pass= JOptionPane.showInputDialog(null,"Sifre Giriniz.","ACCESS_DB GIRIS",JOptionPane.QUESTION_MESSAGE);	
				
				
				if(pass.equals("tas.ik")) {
				
				
					String path ="database/arsiv.accdb";
					File file = new File(path);
					Desktop desktop = Desktop.getDesktop();
					try {
					desktop.open(file);
					} catch (IOException e1){
					e1.printStackTrace();}
				
				}
				
				else {														
				JOptionPane.showInputDialog("Sifre Hatali... Tekrar Giriniz.");
			
		}
			
				
				
				
				
			}
		});
		
		btnDbBalan.setForeground(SystemColor.desktop);
		
		JButton btnReferans = new JButton("Referans");
		btnReferans.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReferans.setBounds(10, 161, 159, 23);
		panel_3.add(btnReferans);
		btnReferans.setForeground(Color.BLUE);
		
		JButton btnNormhakedi = new JButton("Norm-Hakediş");
		btnNormhakedi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNormhakedi.setBounds(10, 195, 159, 23);
		panel_3.add(btnNormhakedi);
		btnNormhakedi.setForeground(Color.BLUE);
		
		JButton btnNormikbs = new JButton("Norm-İKBS");
		btnNormikbs.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNormikbs.setBounds(10, 229, 159, 23);
		panel_3.add(btnNormikbs);
		btnNormikbs.setForeground(new Color(178, 34, 34));
		
		JButton btnBaslayis = new JButton("Baslayis ACCESS_DB");
		btnBaslayis.setBounds(10, 297, 159, 23);
		panel_3.add(btnBaslayis);
		btnBaslayis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AnaMenu.this.dispose();
				baslayis mPane2l=new baslayis();
				mPane2l.setVisible(true);
				
			}
			
			
		});
		btnBaslayis.setForeground(new Color(178, 34, 34));
		btnBaslayis.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBaslayis.setBackground(UIManager.getColor("Button.light"));
		
		JButton btnAyrilisAccessdb = new JButton("Ayrilis ACCESS_DB");
		btnAyrilisAccessdb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AnaMenu.this.dispose();
				ayrilis mPane2dl=new ayrilis();
				mPane2dl.setVisible(true);
			}
		});
		btnAyrilisAccessdb.setBounds(10, 331, 159, 23);
		panel_3.add(btnAyrilisAccessdb);
		btnAyrilisAccessdb.setForeground(new Color(178, 34, 34));
		btnAyrilisAccessdb.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAyrilisAccessdb.setBackground(UIManager.getColor("Button.light"));
		
		JButton btnAriv = new JButton("Arşiv ACCESS_DB");
		btnAriv.setBounds(10, 365, 159, 23);
		panel_3.add(btnAriv);
		btnAriv.setForeground(new Color(178, 34, 34));
		btnAriv.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnYasakllar = new JButton("Yasaklilar ACCESS_DB");
		btnYasakllar.setBounds(10, 399, 159, 23);
		panel_3.add(btnYasakllar);
		btnYasakllar.setBackground(UIManager.getColor("Button.shadow"));
		btnYasakllar.setForeground(new Color(178, 34, 34));
		btnYasakllar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnDisiplin = new JButton("Disiplin");
		btnDisiplin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin.setBounds(10, 263, 159, 23);
		panel_3.add(btnDisiplin);
		btnDisiplin.setForeground(new Color(178, 34, 34));
		JLabel lblNewLabel_1 = new JLabel(bayrakp);
		lblNewLabel_1.setBounds(10, 11, 159, 104);
		panel_3.add(lblNewLabel_1);
		
		JButton btnGeiciGrev = new JButton("Geçici Görev");
		btnGeiciGrev.setBounds(10, 467, 159, 23);
		panel_3.add(btnGeiciGrev);
		btnGeiciGrev.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGeiciGrev.setForeground(new Color(0, 0, 255));
		
		JButton btnYedekler = new JButton("Yedekler");
		btnYedekler.setBounds(10, 433, 159, 23);
		panel_3.add(btnYedekler);
		btnYedekler.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnYedekler.setForeground(new Color(0, 0, 255));
		
		JButton btnEksikler = new JButton("Eksikler");
		btnEksikler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AnaMenu.this.dispose();
				Eksikler eksikler=new Eksikler();
				eksikler.setVisible(true);
				
				
			}
		});
		btnEksikler.setForeground(new Color(178, 34, 34));
		btnEksikler.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEksikler.setBounds(10, 126, 159, 23);
		panel_3.add(btnEksikler);
		btnYedekler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/yedekler.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnGeiciGrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path ="Dosyalar/gecicigorev.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnDisiplin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AnaMenu.this.dispose();
				disiplin dspln=new disiplin();
				dspln.setVisible(true);
				
				
				/*String path ="Dosyalar/disiplin.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}*/
			}
		});
		btnYasakllar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				   AnaMenu.this.dispose();
					Yasakli mPane2l=new Yasakli();
					mPane2l.setVisible(true);
				
				
				
			}
		});
		btnAriv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 	AnaMenu.this.dispose();
					ArsivAra arsivAra=new ArsivAra();
					arsivAra.setVisible(true);
			
			}
			
			
		});
		btnNormikbs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaMenu.this.dispose();
				NormIKBS amenu=new NormIKBS();
				amenu.setVisible(true);
			}
		});
		btnNormhakedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path ="Dosyalar/normhakedis.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnReferans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path ="Dosyalar/referans.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(199, 11, 183, 583);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnDisiplin_1_1_1_1_1_1_1_1_1 = new JButton("İletişim");
		btnDisiplin_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin_1_1_1_1_1_1_1_1_1.setBounds(11, 215, 158, 23);
		panel_4.add(btnDisiplin_1_1_1_1_1_1_1_1_1);
		
		JButton btnKdemTazminat = new JButton("Kıdem Tazminatı");
		btnKdemTazminat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKdemTazminat.setBounds(11, 181, 158, 23);
		panel_4.add(btnKdemTazminat);
		
		JButton btnFirmaSicilleri = new JButton("Firma Sicilleri");
		btnFirmaSicilleri.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFirmaSicilleri.setBounds(11, 147, 158, 23);
		panel_4.add(btnFirmaSicilleri);
		
		JButton btnDisiplin_1_1 = new JButton("Örnek Yazılar");
		btnDisiplin_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin_1_1.setBounds(11, 113, 158, 23);
		panel_4.add(btnDisiplin_1_1);
		
		JButton btnDisiplin_1_1_1_1_1_1 = new JButton("Sırtlık");
		btnDisiplin_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin_1_1_1_1_1_1.setBounds(11, 249, 158, 23);
		panel_4.add(btnDisiplin_1_1_1_1_1_1);
		
		JButton btnDisiplin_1_1_1_2 = new JButton("Mevzuat");
		btnDisiplin_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin_1_1_1_2.setBounds(11, 283, 158, 23);
		panel_4.add(btnDisiplin_1_1_1_2);
		
		JButton btnDisiplin_1_1_1 = new JButton("Sözleşmeler");
		btnDisiplin_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin_1_1_1.setBounds(11, 317, 158, 23);
		panel_4.add(btnDisiplin_1_1_1);
		
		JButton btnMdrListe = new JButton("Müdür Liste");
		btnMdrListe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMdrListe.setBounds(11, 385, 159, 23);
		panel_4.add(btnMdrListe);
		
		Icon icon558=new ImageIcon("ikonlar/pttkus.png");
		
		JButton btnDisiplin_1 = new JButton("Önemli Tebliğler");
		btnDisiplin_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin_1.setBounds(11, 419, 158, 23);
		panel_4.add(btnDisiplin_1);
		
		JButton btnDisiplin_1_1_1_1 = new JButton("SGK Meslek Kodları");
		btnDisiplin_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin_1_1_1_1.setBounds(11, 11, 158, 23);
		panel_4.add(btnDisiplin_1_1_1_1);
		
		JButton btnDisiplin_1_1_1_1_1 = new JButton("SGK Çıkış Kodları");
		btnDisiplin_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin_1_1_1_1_1.setBounds(11, 45, 158, 23);
		panel_4.add(btnDisiplin_1_1_1_1_1);
		
		JButton btnDisiplin_1_1_1_1_1_1_1 = new JButton("İşe Giriş Kapak");
		btnDisiplin_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin_1_1_1_1_1_1_1.setBounds(11, 79, 158, 23);
		panel_4.add(btnDisiplin_1_1_1_1_1_1_1);
		
		
		
		JButton btnAkrabaPersonel = new JButton("Akraba Personel");
		btnAkrabaPersonel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAkrabaPersonel.setBounds(10, 351, 159, 23);
		panel_4.add(btnAkrabaPersonel);
		
		JButton btnofrGrev = new JButton("Şoför Görev");
		btnofrGrev.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnofrGrev.setBounds(11, 453, 159, 23);
		panel_4.add(btnofrGrev);
		
		JButton btnAyrlBalay = new JButton("Ayrılış / Başlayış (Eski)");
		btnAyrlBalay.setBounds(10, 518, 159, 23);
		panel_4.add(btnAyrlBalay);
		btnAyrlBalay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAyrlBalay.setForeground(SystemColor.desktop);
		
		JButton btnArivExcel = new JButton("Arşiv EXCEL");
		btnArivExcel.setBounds(10, 486, 159, 23);
		panel_4.add(btnArivExcel);
		btnArivExcel.setForeground(SystemColor.desktop);
		btnArivExcel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnDisiplin_1_1_1_1_1_1_1_1_1_1 = new JButton("Diğer Klasörler");
		btnDisiplin_1_1_1_1_1_1_1_1_1_1.setBounds(11, 549, 158, 23);
		panel_4.add(btnDisiplin_1_1_1_1_1_1_1_1_1_1);
		btnDisiplin_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisiplin_1_1_1_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/diger";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
				
			}
		});
		btnArivExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String pass2= JOptionPane.showInputDialog(null,"Sifre Giriniz.","ACCESS_DB GIRIS",JOptionPane.QUESTION_MESSAGE);	
				
				
				if(pass2.equals("tas.ik")) {
				
				
					String path ="Dosyalar/arsivexcel.xlsx";
					File file = new File(path);
					Desktop desktop = Desktop.getDesktop();
					try {
					desktop.open(file);
					} catch (IOException e1){
					e1.printStackTrace();
					
					}
				
				}
				
				else {														
				JOptionPane.showInputDialog("Sifre Hatali... Tekrar Giriniz.");
			
		}
				
					
				
			}
		});
		btnAyrlBalay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path ="Dosyalar/ayrilisbaslayis.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnofrGrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/soforgorev.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnAkrabaPersonel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/akrabapersonel.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
				
			}
		});
		btnDisiplin_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/ise_giris_kapak.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnDisiplin_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/sgk_cikis_kodlari.pdf";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnDisiplin_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/sgkmeslekkodlari.pdf";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnDisiplin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/tebligler";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnMdrListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path ="Dosyalar/mudurler.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnDisiplin_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/sozlesmeler";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnDisiplin_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/mevzuat";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnDisiplin_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/sirtlik.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnDisiplin_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/ornekyazilar";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnFirmaSicilleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String path ="Dosyalar/firma_sicil.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
				
			}
		});
		btnKdemTazminat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path ="Dosyalar/kidemtazminati.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		btnDisiplin_1_1_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path ="Dosyalar/iletisim.xlsx";
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file);
				} catch (IOException e1){
				e1.printStackTrace();}
			}
		});
		
		
		Icon icon2=new ImageIcon("ikonlar/foto.jpg");
		
		Icon iconbrr=new ImageIcon("ikonlar/bayrakgif.gif");
		
		Icon inno=new ImageIcon("ikonlar/PTT_logo.gif");
		
		
		Icon icon545=new ImageIcon("ikonlar/pttkus.png");
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(392, 11, 873, 488);
		contentPane.add(scrollPane);
		
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.BOLD, 10));
		list.setForeground(Color.WHITE);
		list.setBackground(new Color(95, 158, 160));
		list.setListData(notListele().toArray());
		
		textFieldNot = new JTextField();
		textFieldNot.setBackground(new Color(95, 158, 160));
		textFieldNot.setForeground(new Color(165, 42, 42));
		textFieldNot.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNot.setBounds(392, 537, 873, 28);
		contentPane.add(textFieldNot);
		textFieldNot.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Not Gir:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(392, 512, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNotEkle = new JButton("Ekle");
		btnNotEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textFieldNot.getText().equals("")) { 
						JOptionPane.showMessageDialog(null,"Notu Giriniz..");
				}					
				else {
				      try {						    	  
				    	  NotDomain addNot=new NotDomain();						    	  
				    	  addNot.setNot(textFieldNot.getText());
				    	 					    	  
				    	  notEkle(addNot);	
				    	  
							JOptionPane.showMessageDialog(null,"Kayit Basarili");									
							textFieldNot.setText("");
														    																			
				      }						
					 catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Baglanti Hatasi");								
					}													
				}		
				
				
				list.setListData(notListele().toArray());
				
				
			}
		});
		btnNotEkle.setBounds(392, 576, 122, 23);
		contentPane.add(btnNotEkle);
		
		
		
		JButton btnNotSil = new JButton("Sil");
		btnNotSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NotDomain silinecekNotDomain =(NotDomain)list.getSelectedValue();
				if(silinecekNotDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Notu Silmek istedigine Emin Misin?","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						
						notSil(silinecekNotDomain);
						
						list.setListData(notListele().toArray());	
						
						System.out.println(silinecekNotDomain.toString());
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek Not secilmedi");}
				
				
				
			}
		});
		btnNotSil.setBounds(524, 576, 122, 23);
		contentPane.add(btnNotSil);
		
		
		
		setLocationRelativeTo(null); 
		
		JButton btnNewButton = new JButton("Yenile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AnaMenu.this.dispose();
				AnaMenu aMenu=new AnaMenu();
				aMenu.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(656, 576, 122, 23);
		contentPane.add(btnNewButton);
		
		
		Icon icon66=new ImageIcon("ikonlar/PTTweblogo.gif.gif");
		
	
		
		
		
		
			 
		       
			
		                        
	 //	list.setListData(notListele().toArray());
		                    
		       
		
		
		
		
		
		
		
		
		//*************************************************************************************
	}

	
	

	public static void notEkle(NotDomain eklenecekNot) {	
		Connection baglanti=DataBaseConn.baglantiAl();
		//tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO nots (not) VALUES (?)");
			sorguPreparedStatement.setString(1, eklenecekNot.getNot().toUpperCase());
								
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}
	
	public static ArrayList<NotDomain> notListele(){	
		ArrayList<NotDomain> not= new ArrayList<NotDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM nots ORDER BY id DESC");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				NotDomain siradakiDomain2=new NotDomain();					
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setNot(rs2.getString("not"));	
				
											
				not.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return not;	
	}
	
	public static void notSil(NotDomain silinecekNotDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM nots WHERE id=?");
			sorgu.setInt(1, silinecekNotDomain.getId());
			sorgu.executeUpdate();	
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




