package tr.com.bgss.complexcontract;

public class KategoriContractComplex {

	private int id;
	private String adi;
	private int parentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + adi;
	}
}
