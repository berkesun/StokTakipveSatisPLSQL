package tr.com.bgss.contract;

public class YoneticiContract {
	
	private int id;
	private int yetkiId;
	private int personelId;
	private String sifre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYetkiId() {
		return yetkiId;
	}
	public void setYetkiId(int yetkiId) {
		this.yetkiId = yetkiId;
	}
	public int getPersonelId() {
		return personelId;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	public String toString() {
		
		return id+" "+yetkiId+" "+personelId+" "+sifre;
	}

}
