package tr.com.bgss.dal;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.bgss.core.ObjectHelper;
import tr.com.bgss.interfaces.DALInterfaces;
import tr.com.bgss.complexcontract.MusteriContractComplex;
import tr.com.bgss.complexcontract.PersonelContractComplex;
import tr.com.bgss.complexcontract.StokContractComplex;
import tr.com.bgss.contract.MusteriContract;
import tr.com.bgss.contract.UrunlerContract;

public class MusteriDAL extends ObjectHelper implements DALInterfaces<MusteriContract> {

	@Override
	public void Insert(MusteriContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(
					"INSERT INTO musteri (Id, AdiSoyadi, Telefon, Adres) VALUES (seq_musteri.nextval, '" + entity.getAdiSoyadi() + "','"
							+ entity.getTelefon() + "','" + entity.getAdres() + "')");
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<MusteriContract> GetAll() {
		
List<MusteriContract> datacontract = new ArrayList<MusteriContract>();
		
		Connection connection = getConnection();
		MusteriContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Musteri");
			while(resultSet.next()) {
				contract = new MusteriContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
				contract.setTelefon(resultSet.getString("Telefon"));
				contract.setAdres(resultSet.getString("Adres"));
				datacontract.add(contract);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;
	
	}
	public List<MusteriContractComplex> GetAll2() {
		List<MusteriContractComplex> datacontract = new ArrayList<MusteriContractComplex>();
		Connection connection = getConnection();
		MusteriContractComplex contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Musteri");
			while (resultSet.next()) {
				contract = new MusteriContractComplex();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
				contract.setTelefon(resultSet.getString("Telefon"));
				contract.setAdres(resultSet.getString("Adres"));
				datacontract.add(contract);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;

	}
	
	

	@Override
	public void Delete(MusteriContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			System.out.println(entity.getId());
			String sorgu = "Delete from musteri where Id=" + entity.getId();
			statement.executeUpdate(sorgu);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Update(MusteriContract entity) {
		
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			String sorgu = "Update musteri set AdiSoyadi='" + entity.getAdiSoyadi() + "',Telefon='" + entity.getTelefon()
					+ "',Adres ='"+entity.getAdres()+"' where Id=" + entity.getId();
			statement.executeUpdate(sorgu);

			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<MusteriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
