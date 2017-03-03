package hei.projet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.dao.EtudiantDao;
import hei.projet.entities.Etudiant;



public class EtudiantDaoImpl implements EtudiantDao {

	@Override
	public List<Etudiant> listEtudiants() {
		String query = "SELECT * FROM etudiant";
		List<Etudiant> etudiants = new ArrayList<>(); 
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						Etudiant etudiant = new Etudiant(resultSet.getInt("idEtudiant"), resultSet.getString("mailEtudiant"), resultSet.getString("mdpEtudiant"));
						etudiants.add(etudiant);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return etudiants;
		
	}

	@Override
	public Etudiant getEtudiant(Integer id) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM etudiant WHERE idEtudiant = ?")) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						return  new Etudiant(resultSet.getInt("idEtudiant"), resultSet.getString("mailEtudiant"), resultSet.getString("mdpEtudiant"));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addEtudiant(Etudiant etudiant) {
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Etudiant(mailEtudiant,mdpEtudiant) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)
						){
			statement.setString(1,etudiant.getEmail());
			statement.setString(2, etudiant.getMotDePasse());
			statement.executeUpdate();
			try (ResultSet resultSet = statement.getGeneratedKeys()) {
				if(resultSet.next()) {
					etudiant.setId(resultSet.getInt(1));
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeEtudiant(Integer id){
	try(Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM etudiant WHERE idEtudiant=?")
					){
		statement.setInt(1,id);
		statement.executeUpdate();
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}

	


