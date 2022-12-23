package PersonelDomain;

public class AyrilisDomain {
	
	int id;
	String tarih;
	String tckn;
	String adiSoyadi;
	String merkez;
	String unvan;
	String neden;
	String bildirge;
	String dilekcebelge;
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
	public String getNeden() {
		return neden;
	}
	public void setNeden(String neden) {
		this.neden = neden;
	}
	public String getBildirge() {
		return bildirge;
	}
	public void setBildirge(String bildirge) {
		this.bildirge = bildirge;
	}
	public String getDilekcebelge() {
		return dilekcebelge;
	}
	public void setDilekcebelge(String dilekcebelge) {
		this.dilekcebelge = dilekcebelge;
	}
	@Override
	public String toString() {
		return tarih + " --- TCKN: " + tckn + " --- ISIM: " + adiSoyadi;
				
	}
	
	
	

}
