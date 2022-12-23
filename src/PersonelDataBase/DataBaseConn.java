package PersonelDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConn {
	
	//static //private static final String YOL ="jdbc:derby:arsivv;create=true";
	//private static final String KULLANICI ="";
	////private static final String PAROLA ="";
//	public static String databaseURL = "jdbc:ucanaccess://e://Java//JavaSE//MsAccess//arsiv.accdb";
	
	
	public static Connection baglantiAl() {
		
		 
		
		
		
		Connection baglanti=null;
		
		try {
		//	baglanti =DriverManager.getConnection(YOL, KULLANICI, PAROLA);
			
		//	baglanti =DriverManager.getConnection("jdbc:mariadb://127.0.0.1/arsivv?user=root&password=Sen6378/*-");
			
        //	baglanti =DriverManager.getConnection(databaseURL);
			
		
			
	         baglanti= DriverManager.getConnection("jdbc:ucanaccess://database//arsiv.accdb");//Establishing Connection
			
		
			
			
			System.out.println("baglandi");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return baglanti;
	}
	

}
