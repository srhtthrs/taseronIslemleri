package PersonelDomain;

public class BaslayisDomain {
	int id;
	private String tckn;
	private String adiSoyadi;
	private String tarih;
	private String merkez;
	private String unvan;
	private String aciklama;
	private String yasakliKontrol;
	private String kimlik;
	private String ehliyet;
	private String src;
	private String psikoTeknik;
	private String adliSicil;
	private String saglikRaporu;
	private String ikametgah;
	private String diploma;
	private String sozlesme;
	private String bildirge;
	private String takipCikar;
	
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
	public String getAdiSoyadi() {
		return adiSoyadi;
	}
	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public String getMerkez() {
		return merkez;
	}
	public void setMerkez(String merkez) {
		this.merkez = merkez;
	}
	public String getUnvan() {
		return unvan;
	}
	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public String getYasakliKontrol() {
		return yasakliKontrol;
	}
	public void setYasakliKontrol(String yasakliKontrol) {
		this.yasakliKontrol = yasakliKontrol;
	}
	public String getKimlik() {
		return kimlik;
	}
	public void setKimlik(String kimlik) {
		this.kimlik = kimlik;
	}
	public String getEhliyet() {
		return ehliyet;
	}
	public void setEhliyet(String ehliyet) {
		this.ehliyet = ehliyet;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getPsikoTeknik() {
		return psikoTeknik;
	}
	public void setPsikoTeknik(String psikoTeknik) {
		this.psikoTeknik = psikoTeknik;
	}
	public String getAdliSicil() {
		return adliSicil;
	}
	public void setAdliSicil(String adliSicil) {
		this.adliSicil = adliSicil;
	}
	public String getSaglikRaporu() {
		return saglikRaporu;
	}
	public void setSaglikRaporu(String saglikRaporu) {
		this.saglikRaporu = saglikRaporu;
	}
	public String getIkametgah() {
		return ikametgah;
	}
	public void setIkametgah(String ikametgah) {
		this.ikametgah = ikametgah;
	}
	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}
	public String getSozlesme() {
		return sozlesme;
	}
	public void setSozlesme(String sozlesme) {
		this.sozlesme = sozlesme;
	}
	public String getBildirge() {
		return bildirge;
	}
	public void setBildirge(String bildirge) {
		this.bildirge = bildirge;
	}
	
	public String getTakipCikar() {
		return takipCikar;
	}
	public void setTakipCikar(String takipCikar) {
		this.takipCikar = takipCikar;
	}
	
	
	
	
	@Override
	public String toString() {
		return  //""+id+"-->"+
	
				"TCKN: "+  tckn 
				+"----->ISIM: " +adiSoyadi;  
				
			/*	+"TARIH:"+ tarih
				 +"MERKEZ: "+ merkez +"UNVAN: "+  unvan +"ACIKLAMA: "+ aciklama 
				 +"YASAKLI: "+yasakliKontrol+ 
				 "KIMLIK: "+kimlik +
				 "EHLIYET: "+ehliyet+
				 "SRC: "+src+
				 "PSIKOTEKNIK: "+psikoTeknik+
				 "ADLI SICIL: "+adliSicil+
				 "SAGLIK RAPORU: "+saglikRaporu+
				 "IKAMETGAH: "+ikametgah+
				 "DIPLOMA: "+diploma+
				 "SOZLESME: "+sozlesme+
				 "BILDIRGE: "+bildirge;*/
	
	}
	
	
	

}
