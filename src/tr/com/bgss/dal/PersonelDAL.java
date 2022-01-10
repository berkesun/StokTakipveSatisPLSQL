package tr.com.bgss.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tr.com.bgss.core.ObjectHelper;
import tr.com.bgss.interfaces.DALInterfaces;
import tr.com.bgss.complexcontract.PersonelContractComplex;
import tr.com.bgss.complexcontract.UrunlerContractComplex;
import tr.com.bgss.contract.PersonelContract;

public class PersonelDAL extends ObjectHelper implements DALInterfaces<PersonelContract> {

	@Override
	public void Insert(PersonelContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Personel (Id, AdiSoyadi, Email) VALUES(seq_personel.nextval, '" + entity.getAdiSoyadi() + "','"
					+ entity.getEmail() + "')");
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<PersonelContract> GetAll() {

		List<PersonelContract> datacontract = new ArrayList<PersonelContract>();

		Connection connection = getConnection();
		PersonelContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Personel");
			while (resultSet.next()) {
				contract = new PersonelContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
				contract.setEmail(resultSet.getString("Email"));

				datacontract.add(contract);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	public List<PersonelContractComplex> GetAll2() {
		List<PersonelContractComplex> datacontract = new ArrayList<PersonelContractComplex>();
		Connection connection = getConnection();
		PersonelContractComplex contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Personel");
			while (resultSet.next()) {
				contract = new PersonelContractComplex();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
				contract.setEmail(resultSet.getString("Email"));
				datacontract.add(contract);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;

	}

	@Override
	public void Delete(PersonelContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			System.out.println(entity.getId());
			String sorgu = "Delete from personel where Id=" + entity.getId();
			statement.executeUpdate(sorgu);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Update(PersonelContract entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			String sorgu = "Update personel set AdiSoyadi='" + entity.getAdiSoyadi() + "',Email='" + entity.getEmail()
					+ "' where Id=" + entity.getId();
			statement.executeUpdate(sorgu);

			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<PersonelContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
