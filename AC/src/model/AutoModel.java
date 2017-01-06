package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import utils.DriverManagerConnectionPool;

public class AutoModel 
{
	
	public void doSave(Auto auto) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + AutoModel.Auto + " VALUES (?, ?, ?, ?)";
		String insertSQL2 = "INSERT INTO " + AutoModel.Auto + " VALUES (?)";
		
		
		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, auto.getNomeAuto());
			preparedStatement.setString(2, auto.getPrezzo());
			preparedStatement.setString(3, auto.getDescrizione());
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(insertSQL2);
			preparedStatement.setString(1, auto.getOptional());
			preparedStatement.executeUpdate();
			connection.commit();
		}
		finally
		{
			try
			{
				if(preparedStatement != null)
					preparedStatement.close();
			}
			finally
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	public boolean doDelete(int code) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String deleteSQL = "DELETE FROM " + AutoModel.Auto + " WHERE ID = ?";
		
		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			result = preparedStatement.executeUpdate();

		}
		finally
		{
			try
			{
				if (preparedStatement != null)
					preparedStatement.close();
			}
			finally
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return result != 0;
	}

	

	public Collection<Auto> doRetrieveAll() throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Auto> products = new LinkedList<Auto>();

		String selectSQL = "SELECT * FROM " + AutoModel.Auto + " ORDER BY ID";
		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next())
			{
				Auto auto = new Auto();
				auto.setId(rs.getInt("ID"));
				auto.setNomeAuto(rs.getString("NomeAuto"));
				auto.setDescrizione(rs.getString("Descrizione"));
				auto.setPrezzo(rs.getString("Prezzo"));
				auto.setOptionalBase(rs.getString("OptionalBase"));
				products.add(auto);
			}

		}
		finally
		{
			try
			{
				if (preparedStatement != null)
					preparedStatement.close();
			}
			finally
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	public void doSave(Newsletter news) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + AutoModel.Newsletter + " VALUES (?, ?, ?, ?)";
		
		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, news.getId());
			preparedStatement.setString(2, news.getNome());
			preparedStatement.setString(3, news.getCognome());
			preparedStatement.setString(4, news.getEmail());

			preparedStatement.executeUpdate();

			connection.commit();
		}
		finally
		{
			try
			{
				if(preparedStatement != null)
					preparedStatement.close();
			}
			finally
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	public void doSave(TestDrive test) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + AutoModel.TestDrive + " VALUES (?, ?, ?, ?, ?)";
		
		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setDate(1, test.getData());
			preparedStatement.setString(2, test.getNome());
			preparedStatement.setString(3, test.getCognome());
			preparedStatement.setString(4, test.getCodiceFiscale());
			preparedStatement.setString(5, test.getEmail());

			preparedStatement.executeUpdate();

			connection.commit();
		}
		finally
		{
			try
			{
				if(preparedStatement != null)
					preparedStatement.close();
			}
			finally
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	public void doSave(Noleggio noleggio) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + AutoModel.Noleggio + " VALUES (?, ?, ?, ?, ?, ?)";
		
		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, noleggio.getNome());
			preparedStatement.setString(2, noleggio.getCognome());
			preparedStatement.setString(3, noleggio.getCodiceFiscale());
			preparedStatement.setDate(4, noleggio.getDataInizio());
			preparedStatement.setDate(5, noleggio.getDataFine());
			preparedStatement.setString(6, noleggio.getEmail());

			preparedStatement.executeUpdate();

			connection.commit();
		}
		finally
		{
			try
			{
				if(preparedStatement != null)
					preparedStatement.close();
			}
			finally
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	

	private static final String Auto = "Auto";
	private static final String Noleggio = "Noleggio";
	private static final String TestDrive = "TestDrive";
	private static final String Newsletter = "Newsletter";
}
