package PersonelDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import PersonelDomain.PersDomain;

public class ArsivSQL {
	
	static DefaultTableModel model;
	/*		
	public static void tabloOlustur() {		
		Connection baglanti= DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorguStatement=
					baglanti.prepareStatement("CREATE TABLE IF NOT EXISTS arsiv (id INTEGER NOT NULL, tckn VARCHAR(50), sicil VARCHAR(50), adisoyadi VARCHAR(50), klasorno VARCHAR(50), aciklama VARCHAR(50))");		
	sorguStatement.executeUpdate();		
		} catch (SQLException e) {			
			if(e.getSQLState().equals("X0Y32")) {				
				System.out.println("tablo mevcut");
			}else 
			{			
			e.printStackTrace();		
			}
}
}
	*/
	public static void personelEkle(PersDomain eklenecekKisiDomain1) {	
		Connection baglanti=DataBaseConn.baglantiAl();
		//tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO arsiv (tckn,sicil,adisoyadi,klasorno,aciklama) VALUES (?,?,?,?,?)");
			sorguPreparedStatement.setString(1, eklenecekKisiDomain1.getTckn().toUpperCase());
			sorguPreparedStatement.setString(2, eklenecekKisiDomain1.getSicil().toUpperCase());
			sorguPreparedStatement.setString(3, eklenecekKisiDomain1.getAdiSoyadi().toUpperCase());
			sorguPreparedStatement.setString(4, eklenecekKisiDomain1.getDosyaNo().toUpperCase());
			sorguPreparedStatement.setString(5, eklenecekKisiDomain1.getAciklama().toUpperCase());
						
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}
	
	public static void personelSil(PersDomain silinecekKisiDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM arsiv WHERE id=?");
			sorgu.setInt(1, silinecekKisiDomain.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void kisiGuncelle(PersDomain guncellenecekKisiDomain) {
		
		Connection baglanti=DataBaseConn.baglantiAl();
		try {                                                        
			PreparedStatement sorgu =baglanti.prepareStatement("UPDATE arsiv SET tckn=? , sicil=? , adisoyadi=? , klasorno=? , aciklama=? WHERE id=?");
		sorgu.setString(1, guncellenecekKisiDomain.getTckn().toUpperCase());	
		sorgu.setString(2, guncellenecekKisiDomain.getSicil().toUpperCase());	
		sorgu.setString(3, guncellenecekKisiDomain.getAdiSoyadi().toUpperCase());	
		sorgu.setString(4, guncellenecekKisiDomain.getDosyaNo().toUpperCase());	
		sorgu.setString(5, guncellenecekKisiDomain.getAciklama().toUpperCase());
		
		sorgu.setInt(6, guncellenecekKisiDomain.getId());
		
		
		sorgu.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}
		
	public static boolean kontrol(String tckn) {
		
		boolean sonuc=false;
		
		Connection baglanti= DataBaseConn.baglantiAl();
		 try {
			 
			 PreparedStatement sorgu= baglanti.prepareStatement("SELECT * FROM arsiv WHERE tckn=?");
			 sorgu.setString(1,tckn);
			 
			 ResultSet rs=sorgu.executeQuery();
			 
			 while(rs.next()) {
				 sonuc=true;
				 }
			
		} catch (Exception e) {
		
			JOptionPane.showMessageDialog(null, "TCKN Mevcut");
			
		}
		return sonuc;
		
	}
	
	public static ArrayList<PersDomain> personelListele(){	
		ArrayList<PersDomain> arsiv= new ArrayList<PersDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM arsiv WHERE tckn IS NOT NULL");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				PersDomain siradakiDomain2=new PersDomain();					
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setTckn(rs2.getString("tckn"));	
				siradakiDomain2.setSicil(rs2.getString("sicil"));	
				siradakiDomain2.setAdiSoyadi(rs2.getString("adisoyadi"));	
				siradakiDomain2.setDosyaNo(rs2.getString("klasorno"));	
				siradakiDomain2.setAciklama(rs2.getString("aciklama"));	
											
				arsiv.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return arsiv;	
	}
	
	public static ArrayList<PersDomain> bultckn(String tcknString){		
		ArrayList<PersDomain> bulunanKisiListesi= new ArrayList<PersDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM arsiv WHERE tckn LIKE ? ORDER BY tckn ASC");	
			sorgu.setString(1, tcknString+"%");
			ResultSet rs=sorgu.executeQuery();			
			while(rs.next()) {				
				PersDomain siradakiDomain=new PersDomain();							
				siradakiDomain.setId(rs.getInt("id"));
				siradakiDomain.setTckn(rs.getString("tckn"));
				siradakiDomain.setSicil(rs.getString("sicil"));
				siradakiDomain.setAdiSoyadi(rs.getString("adisoyadi"));
				siradakiDomain.setDosyaNo(rs.getString("klasorno"));
				siradakiDomain.setAciklama(rs.getString("aciklama"));						
				bulunanKisiListesi.add(siradakiDomain);				
			}			
		} catch (SQLException e) {		
			e.printStackTrace();
		}			
		return bulunanKisiListesi;	
	}	

	public static ArrayList<PersDomain> buladisoyadi(String adiSoyadiString){		
		ArrayList<PersDomain> bulunanKisiListesi= new ArrayList<PersDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM arsiv WHERE adisoyadi LIKE ? ORDER BY adisoyadi ASC");	
			sorgu.setString(1,adiSoyadiString+"%");
			ResultSet rs=sorgu.executeQuery();			
			while(rs.next()) {				
				PersDomain siradakiDomain=new PersDomain();							
				siradakiDomain.setId(rs.getInt("id"));
				siradakiDomain.setTckn(rs.getString("tckn"));
				siradakiDomain.setSicil(rs.getString("sicil"));
				siradakiDomain.setAdiSoyadi(rs.getString("adisoyadi"));
				siradakiDomain.setDosyaNo(rs.getString("klasorno"));
				siradakiDomain.setAciklama(rs.getString("aciklama"));						
				bulunanKisiListesi.add(siradakiDomain);				
			}			
		} catch (SQLException e) {		
			e.printStackTrace();
		}			
		return bulunanKisiListesi;	
	}

	public static ArrayList<PersDomain> bulsicil(String sicilString){		
		ArrayList<PersDomain> bulunanKisiListesi2= new ArrayList<PersDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM arsiv WHERE sicil LIKE ?");	
			sorgu.setString(1, sicilString+"%");
			ResultSet rs=sorgu.executeQuery();			
			while(rs.next()) {				
				PersDomain siradakiDomain=new PersDomain();							
				siradakiDomain.setId(rs.getInt("id"));
				siradakiDomain.setTckn(rs.getString("tckn"));
				siradakiDomain.setSicil(rs.getString("sicil"));
				siradakiDomain.setAdiSoyadi(rs.getString("adisoyadi"));
				siradakiDomain.setDosyaNo(rs.getString("klasorno"));
				siradakiDomain.setAciklama(rs.getString("aciklama"));						
				bulunanKisiListesi2.add(siradakiDomain);				
			}			
		} catch (SQLException e) {		
			e.printStackTrace();
		}			
		return bulunanKisiListesi2;	
		
		
	}
	
	//dftmodel
	
	public static DefaultTableModel dosyaNobulDefaultTableModel(String klasorString) {
		 model=new DefaultTableModel();
		 
		 
		 Object[] kolonlar= {"KLASOR NO", "TCKN", "SICIL","ADI SOYADI",};
		 
		 
		 Object[] satirlar=new Object[20];
		 Connection baglanti =DataBaseConn.baglantiAl();			 		 
		 model.setColumnIdentifiers(kolonlar);					 		
		try {
			PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM arsiv WHERE klasorno LIKE ?");
			
			sorgu.setString(1, klasorString);
			ResultSet rs=sorgu.executeQuery();
			
			
			
			while(rs.next()) {									
				satirlar[0]=rs.getString("klasorno");
				satirlar[1]=rs.getString("tckn");
				satirlar[2]=rs.getString("sicil");
				satirlar[3]=rs.getString("adisoyadi");
				model.addRow(satirlar);				
			}
						
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;				
	}

	public static DefaultTableModel tcknBulDefaultTableModel(String tcknString ) {
		 model=new DefaultTableModel();
		 
		 
		 Object[] kolonlar= {"KLASOR NO", "TCKN", "SICIL","ADI SOYADI","ACIKLAMA"};  
		 
		 Object[] satirlar=new Object[20];
		 Connection baglanti =DataBaseConn.baglantiAl();			 		 
		 model.setColumnIdentifiers(kolonlar);					 		
		try {				
						
			PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM arsiv WHERE (tckn + sicil + adisoyadi) LIKE ?");
			
			sorgu.setString(1, "%"+tcknString+"%");
			ResultSet rs=sorgu.executeQuery();	
			
			
			while(rs.next()) {									
				
				
				satirlar[0]=rs.getString("klasorno");
				satirlar[1]=rs.getString("tckn");
				satirlar[2]=rs.getString("sicil");
				satirlar[3]=rs.getString("adisoyadi");
				satirlar[4]=rs.getString("aciklama");
				
				model.addRow(satirlar);				
			}
						
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;				
	}
	
	public static DefaultTableModel sicilBulDefaultTableModel(String sicilString ) {
		 model=new DefaultTableModel();
		 
		 
		 Object[] kolonlar= {"SICIL", "TCKN","ADI SOYADI","KLASOR NO", "ACIKLAMA"};  
		 Object[] satirlar=new Object[20];
		 Connection baglanti =DataBaseConn.baglantiAl();			 		 
		 model.setColumnIdentifiers(kolonlar);					 		
		try {
						
			PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM arsiv WHERE sicil LIKE ?");
			
			sorgu.setString(1,"%"+ sicilString+"%");
			ResultSet rs=sorgu.executeQuery();	
			
			
			while(rs.next()) {									
				
				satirlar[0]=rs.getString("sicil");
				satirlar[1]=rs.getString("tckn");
				
				satirlar[2]=rs.getString("adisoyadi");
				satirlar[3]=rs.getString("klasorno");
				satirlar[4]=rs.getString("aciklama");
				
				model.addRow(satirlar);				
			}
						
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;				
	}	
		
	public static DefaultTableModel adisoyadiBulDefaultTableModel(String adisoyadi ) {
		 model=new DefaultTableModel();		 	 
		 Object[] kolonlar= {"ADI SOYADI", "SICIL", "TCKN","KLASOR NO", "ACIKLAMA"}; 		 		 
		 Object[] satirlar=new Object[20];
		 Connection baglanti =DataBaseConn.baglantiAl();			 		 
		 model.setColumnIdentifiers(kolonlar);					 		
		try {						
			PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM arsiv WHERE adisoyadi LIKE ?");			
			sorgu.setString(1,"%"+adisoyadi+"%");			
			ResultSet rs=sorgu.executeQuery();							
			while(rs.next()) {													
				satirlar[0]=rs.getString("adisoyadi");
				satirlar[1]=rs.getString("sicil");
				satirlar[2]=rs.getString("tckn");				
				satirlar[3]=rs.getString("klasorno");
				satirlar[4]=rs.getString("aciklama");				
				model.addRow(satirlar);				
			}												
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;				
	}

	//----
	public static int klasorNoBulsay(String klasorNoBulSayString){		
		ArrayList<PersDomain> bulunanKisiListesi= new ArrayList<PersDomain>();
		Connection baglanti = DataBaseConn.baglantiAl();
		int say=0;
		try {
			PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM arsiv WHERE klasorno LIKE ?");	
			sorgu.setString(1, klasorNoBulSayString);
			ResultSet rs=sorgu.executeQuery();	
			
			while(rs.next()) {	
				say++;
				PersDomain siradakiDomain=new PersDomain();
								
				siradakiDomain.setId(rs.getInt("id"));
				siradakiDomain.setTckn(rs.getString("tckn"));
				siradakiDomain.setSicil(rs.getString("sicil"));
				siradakiDomain.setAdiSoyadi(rs.getString("adisoyadi"));
				siradakiDomain.setDosyaNo(rs.getString("klasorno"));
				siradakiDomain.setAciklama(rs.getString("aciklama"));
						
				bulunanKisiListesi.add(siradakiDomain);				
			}			
		} catch (SQLException e) {		
			e.printStackTrace();
		}			
		return say;	
	}
	
	public static DefaultTableModel klasorNoBulsaySirala(){		
		
		model=new DefaultTableModel();		 	 
		 Object[] kolonlar= {"ADI SOYADI","KLASOR NO"};	 		 
		 Object[] satirlar=new Object[20];
		 Connection baglanti1 =DataBaseConn.baglantiAl();			 		 
		 model.setColumnIdentifiers(kolonlar);	
		
		try {						
			PreparedStatement sorgu=baglanti1.prepareStatement("SELECT * FROM arsiv ORDER BY klasorno ASC");									
			ResultSet rs=sorgu.executeQuery();							
			while(rs.next()) {
				
				
				satirlar[0]=rs.getString("adisoyadi");
				satirlar[1]=rs.getString("klasorno");
							
				model.addRow(satirlar);				
			}												
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;	
		
		
	}

}
