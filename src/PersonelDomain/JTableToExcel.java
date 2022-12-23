package PersonelDomain;

import javax.swing.table.*;

import PersonelUi.Eksikler;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;


public class JTableToExcel extends JFrame
{

  static JTable table;
  JPanel panel = new JPanel(new BorderLayout());
  JButton btn = new JButton("Excele Aktar");
  
  public static void main(String[] args){
      new JTableToExcel();
      MudurlukveSicilGetir(table);
      
}

  
  public JTableToExcel(){
	  setResizable(false);
    setSize(850,550);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setTitle("Excele Aktar");
    panel.add(btn, BorderLayout.SOUTH);
    panel.add(new JScrollPane(table), BorderLayout.NORTH);
    add(panel);
    setVisible(true);
    btn.addActionListener(new MyListener());
    btn.setBackground(UIManager.getColor("Button.light"));
    btn.setForeground(new Color(128, 0, 0));
  }

  
  public void export(JTable table, File file){
    try
    {
      TableModel m = table.getModel();
      FileWriter fw = new FileWriter(file);
      for(int i = 0; i < m.getColumnCount(); i++){
        fw.write(m.getColumnName(i) + "\t");
      }
      fw.write("\n");
      for(int i=0; i < m.getRowCount(); i++) {
        for(int j=0; j < m.getColumnCount(); j++) {
          fw.write(m.getValueAt(i,j).toString()+"\t");
        }
        fw.write("\n");
      }
      fw.close();
    }
    catch(IOException e){ System.out.println(e); }
  }
  
  
  class MyListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if(e.getSource() == btn){
        	
        	 
        	 JFileChooser fchoose = new JFileChooser();
           int option = fchoose.showSaveDialog(JTableToExcel.this);
           if(option == JFileChooser.APPROVE_OPTION){
        	   
             String name = fchoose.getSelectedFile().getName(); 
                     	         	   
             String path = fchoose.getSelectedFile().getParentFile().getPath();
             
             
             
             String file = path + "\\" + name + ".xls"; 
             
             export(table, new File(file));
             
             
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             	String path2 =file;
				File file2 = new File(path2);
				Desktop desktop = Desktop.getDesktop();
				try {
				desktop.open(file2);
				} catch (IOException e1){
				e1.printStackTrace();}				
				JTableToExcel.this.dispose();
				
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
			}
           }
         }
      }
  

  
  public static void MudurlukveSicilGetir(JTable table2) {
		
	  table=table2;
		
	}







}