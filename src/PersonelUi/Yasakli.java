package PersonelUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import PersonelDataBase.ArsivSQL;
import PersonelDataBase.DataBaseConn;

import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Yasakli extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yasakli frame = new Yasakli();
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
	public Yasakli() {
		setTitle("Yasakli Kontrol");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ana Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Yasakli.this.dispose();
					AnaMenu mPane2l=new AnaMenu();
					mPane2l.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 452, 131, 34);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 32));
		textField.setForeground(new Color(165, 42, 42));
		textField.setBackground(SystemColor.info);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
						if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					
							textField.setText("");
				
				}
				else {table.setModel(yasakliBulDefaultTableModel(textField.getText().toUpperCase()));
			}
				
				
				
				
				
				
			}
		});
		textField.setBounds(154, 26, 560, 53);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 913, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(table);
		
		
		Icon iconara=new ImageIcon("ikonlar/search.jpg");
		JLabel lblNewLabel = new JLabel(iconara);
		lblNewLabel.setBounds(45, 23, 99, 56);
		contentPane.add(lblNewLabel);
		
		JButton btnGeribaslayis = new JButton("Geri (Baslayis)");
		btnGeribaslayis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Yasakli.this.dispose();
				baslayis mPane2l=new baslayis();
				mPane2l.setVisible(true);
			}
		});
		btnGeribaslayis.setBounds(151, 452, 131, 34);
		contentPane.add(btnGeribaslayis);
		setLocationRelativeTo(null); 
		
	}
			static DefaultTableModel model;
		
		public static DefaultTableModel yasakliBulDefaultTableModel(String adisoyadi) {
			
			 model=new DefaultTableModel();		 	 
			 Object[] kolonlar= {"TCKN", "ISIM", "ACIKLAMA-1","ACIKLAMA-2","ACIKLAMA-3"}; 		 		 
			 Object[] satirlar=new Object[20];
			 Connection baglanti =DataBaseConn.baglantiAl();			 		 
			 model.setColumnIdentifiers(kolonlar);					 		
			try {						
				PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM yasaklilar WHERE (tckn + adisoyadi) LIKE ?");			
				sorgu.setString(1,"%"+adisoyadi+"%");			
				ResultSet rs=sorgu.executeQuery();							
				while(rs.next()) {													
					satirlar[0]=rs.getString("tckn");
					satirlar[1]=rs.getString("adisoyadi");
					satirlar[2]=rs.getString("aciklama1");				
					satirlar[3]=rs.getString("aciklama2");
					satirlar[4]=rs.getString("aciklama3");				
					model.addRow(satirlar);				
				}												
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return model;		
		}
	}

