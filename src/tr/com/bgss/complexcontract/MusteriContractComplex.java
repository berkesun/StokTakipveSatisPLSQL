package tr.com.bgss.complexcontract;

public class MusteriContractComplex {

	private int id;
	private String adiSoyadi;
	private String telefon;
	private String adres;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdiSoyadi() {
		return adiSoyadi;
	}

	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + adiSoyadi;
	}
}
