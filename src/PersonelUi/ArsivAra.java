package PersonelUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PersonelDataBase.ArsivSQL;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArsivAra extends JFrame {

	private JPanel contentPane;
	private JTextField textField1ara;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArsivAra frame = new ArsivAra();
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
	public ArsivAra() {
		setTitle("Dosya Ara (Taseron Arsiv)");
		setResizable(false);
		setBackground(new Color(95, 158, 160));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 511);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField1ara = new JTextField();
		textField1ara.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					
					textField1ara.setText("");
				
				}
				else {table.setModel(ArsivSQL.tcknBulDefaultTableModel(textField1ara.getText().toUpperCase()));
			}
			}
		});
		textField1ara.setForeground(new Color(165, 42, 42));
		textField1ara.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		textField1ara.setBackground(SystemColor.text);
		textField1ara.setBounds(99, 11, 431, 51);
		contentPane.add(textField1ara);
		textField1ara.setColumns(10);
		
		setLocationRelativeTo(null);
		
		Icon imageAra=new ImageIcon("ikonlar/search.jpg");
		JLabel lblNewLabel = new JLabel(imageAra);
		lblNewLabel.setBounds(10, 11, 79, 51);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(95, 158, 160));
		scrollPane.setBounds(10, 73, 883, 382);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setForeground(new Color(165, 42, 42));
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArsivAra.this.dispose();
				AnaMenu amenu=new AnaMenu();
				amenu.setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setBounds(819, 11, 74, 51);
		contentPane.add(btnNewButton);
		
		Icon iconks=new ImageIcon("ikonlar/pttkus.png");
		lblNewLabel_1 = new JLabel(iconks);
		lblNewLabel_1.setBounds(540, 11, 125, 51);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(iconks);
		lblNewLabel_2.setBounds(684, 11, 125, 51);
		contentPane.add(lblNewLabel_2);
	}
}
