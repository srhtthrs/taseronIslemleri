package PersonelDomain;

public class DisiplinDomain {
	int id;
	private String tarih;
	private String adiSoyadi;
	private String sayi;
	private String mudurluk;
	private String aciklama;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public String getAdiSoyadi() {
		return adiSoyadi;
	}
	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}
	public String getSayi() {
		return sayi;
	}
	public void setSayi(String sayi) {
		this.sayi = sayi;
	}
	public String getMudurluk() {
		return mudurluk;
	}
	public void setMudurluk(String mudurluk) {
		this.mudurluk = mudurluk;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	@Override
	public String toString() {
		return tarih + "  ("+"sayi: "+sayi+")"+"     "+ adiSoyadi;
				
				
	}

	
	
}
