package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import bean.Newsletter;
import bean.TestDrive;
import bean.Auto;
import bean.Accessorio;
import utils.DriverManagerConnectionPool;

public class AutoModel 
{
	
//	public void doSave(Auto auto) throws SQLException
//	{
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		String insertSQL = "INSERT INTO " + AutoModel.Auto + " VALUES (?, ?, ?, ?)";
//		String insertSQL2 = "INSERT INTO " + AutoModel.Auto + " VALUES (?)";
//		
//		
//		try
//		{
//			connection = DriverManagerConnectionPool.getConnection();
//			preparedStatement = connection.prepareStatement(insertSQL);
//			preparedStatement.setString(1, auto.getNome());
//			preparedStatement.setString(2, auto.getPrezzo());
//			preparedStatement.setString(3, auto.getDescrizione());
//			preparedStatement.executeUpdate();
//			
//			preparedStatement = connection.prepareStatement(insertSQL2);
//			preparedStatement.setString(1, auto.getOptional());
//			preparedStatement.executeUpdate();
//			connection.commit();
//		}
//		finally
//		{
//			try
//			{
//				if(preparedStatement != null)
//					preparedStatement.close();
//			}
//			finally
//			{
//				DriverManagerConnectionPool.releaseConnection(connection);
//			}
//		}
//	}

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

	public Auto doRetrieveByKey(int code) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Auto auto = new Auto();

		String selectSQL = "SELECT * FROM " + AutoModel.Auto + " WHERE id_auto = ?";

		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next())
			{
				auto.setCodice(rs.getInt("id_auto"));
				auto.setNome(rs.getString("nome"));
				auto.setDescrizione(rs.getString("descrizione"));
				auto.setPrezzo(rs.getInt("costo"));
				auto.setImmagine("immagine");
			}
			
			String selectSQL2 = "SELECT * FROM " + AutoModel.Possiede + " NATURAL JOIN " + AutoModel.Accessorio +" WHERE id_auto = ?";
			preparedStatement = connection.prepareStatement(selectSQL2);
			preparedStatement.setInt(1, code);
			rs = preparedStatement.executeQuery();
			
			
			while(rs.next())
			{
				Accessorio acc = new Accessorio();
				acc.setCosto(rs.getInt("prezzo"));
				acc.setNome(rs.getString("nome"));
				acc.setBase(rs.getBoolean("tipo"));
				auto.addAccessorio(acc);
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
		return auto;
	}

	public ArrayList<Auto> doRetrieveAll() throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Auto> listaAuto = new ArrayList<Auto>();

		String selectSQL = "SELECT * FROM " + AutoModel.Auto + " ORDER BY id_auto";
		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next())
			{
				Auto auto = new Auto();
				auto.setCodice(rs.getInt("id_auto"));
				auto.setNome(rs.getString("nome"));
				auto.setDescrizione(rs.getString("descrizione"));
				auto.setPrezzo(rs.getInt("costo"));
				auto.setImmagine(rs.getString("foto"));
				listaAuto.add(auto);
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
		return listaAuto;
	}
	
	public void doSave(Newsletter news) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + AutoModel.Newsletter + " (nome, cognome, email, id_auto) VALUES (?, ?, ?, ?)";
		
		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, news.getNome());
			preparedStatement.setString(2, news.getCognome());
			preparedStatement.setString(3, news.getEmail());
			preparedStatement.setInt(4, news.getCodiceAuto());

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
		
		String insertSQL = "INSERT INTO " + AutoModel.TestDrive + " (nome, cognome, codice_fiscale, data, email, id_auto) VALUES (?, ?, ?, ?, ?, ?)";
		
		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, test.getNome());
			preparedStatement.setString(2, test.getCognome());
			preparedStatement.setString(3, test.getCodiceFiscale());
			preparedStatement.setDate(4, test.getData());
			preparedStatement.setString(5, test.getEmail());
			preparedStatement.setInt(6, test.getCodiceAuto());

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
	

	private static final String Auto = "auto";
	private static final String Noleggio = "noleggio";
	private static final String TestDrive = "testdrive";
	private static final String Newsletter = "newsletter";
	private static final String Possiede = "possiede";
	private static final String Accessorio = "accessorio";
}
