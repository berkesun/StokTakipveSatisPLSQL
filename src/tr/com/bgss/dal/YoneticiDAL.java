package tr.com.bgss.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.bgss.core.ObjectHelper;
import tr.com.bgss.interfaces.DALInterfaces;
import tr.com.bgss.contract.YoneticiContract;

public class YoneticiDAL extends ObjectHelper implements DALInterfaces<YoneticiContract> {

	@Override
	public void Insert(YoneticiContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			//statement.executeUpdate("INSERT INTO Personel (Id, AdiSoyadi, Email) VALUES(seq_personel.nextval, '" + entity.getAdiSoyadi() + "','"
					//+ entity.getEmail() + "')");
			
			statement.executeUpdate("INSERT INTO Yonetici (Id, PersonelId, YetkiId, Sifre) VALUES(seq_yonetici.nextval," + entity.getPersonelId()
					+ "," + entity.getYetkiId() + ",'" + entity.getSifre() + "')");
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public YoneticiContract GetPersonelIdveSifre(int personelId, String sifre) {

		YoneticiContract contract = new YoneticiContract();
		List<YoneticiContract> listele = new ArrayList<YoneticiContract>();
		Connection baglanti = getConnection();
		try {
			Statement sorgu = baglanti.createStatement();
			ResultSet rs = sorgu.executeQuery(
					"SELECT *FROM yonetici WHERE PersonelId=" + personelId + " AND Sifre='" + sifre.trim() + "'");

			while (rs.next()) {
				contract.setId(rs.getInt("Id"));
				contract.setPersonelId(rs.getInt("PersonelId"));
				contract.setSifre(rs.getString("Sifre"));
				contract.setYetkiId(rs.getInt("YetkiId"));

			}
			sorgu.close();
			baglanti.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return contract;

	}

	public YoneticiContract GetYetkiId(int personelId) {

		YoneticiContract contract = new YoneticiContract();
		List<YoneticiContract> listele = new ArrayList<YoneticiContract>();
		Connection baglanti = getConnection();
		try {
			Statement sorgu = baglanti.createStatement();
			ResultSet rs = sorgu.executeQuery("SELECT *FROM yonetici WHERE PersonelId=" + personelId + "");

			while (rs.next()) {
				contract.setId(rs.getInt("Id"));
				contract.setPersonelId(rs.getInt("PersonelId"));
				contract.setYetkiId(rs.getInt("YetkiId"));

			}
			sorgu.close();
			baglanti.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return contract;

	}

	@Override
	public List<YoneticiContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(YoneticiContract entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void Update(YoneticiContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<YoneticiContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
