package PersonelDomain;

public class PersDomain {
	
	private int id;
	
	private String tckn;
	private String sicil;
	private String adiSoyadi;
	private String dosyaNo;
	private String aciklama;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTckn() {
		return tckn;
	}
	public void setTckn(String tckn) {
		this.tckn = tckn;
	}
	public String getSicil() {
		return sicil;
	}
	public void setSicil(String sicil) {
		this.sicil = sicil;
	}
	public String getAdiSoyadi() {
		return adiSoyadi;
	}
	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}
	public String getDosyaNo() {
		return dosyaNo;
	}
	public void setDosyaNo(String dosyaNo) {
		this.dosyaNo = dosyaNo;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	@Override
	public String toString() {
		return "TCKN-->" + tckn + "     ADI SOYADI-->" + adiSoyadi+ "     Sicil-->" + sicil;
	}
	
	

}
