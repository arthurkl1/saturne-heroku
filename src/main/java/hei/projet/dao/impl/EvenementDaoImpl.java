package hei.projet.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.DateTimeSyntax;

import hei.projet.dao.EvenementDao;
import hei.projet.entities.Categorie;
import hei.projet.entities.Etudiant;
import hei.projet.entities.Evenement;


public class EvenementDaoImpl implements EvenementDao {

	@Override
	public List<Evenement> listEvenements() {
		String query = "SELECT * FROM evenement JOIN categorie ON evenement.idCategorie = categorie.idCategorie  ORDER BY idEvenement";
		List<Evenement> evenements = new ArrayList<>(); 
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						Categorie categorie = new Categorie(resultSet.getInt("idCategorie"), resultSet.getString("titreCategorie"));
						Evenement evenement = new Evenement(resultSet.getInt("idEvenement"), resultSet.getString("titreEvenement"), resultSet.getString("lieuEvenement"),resultSet.getDate("dateEvenement").toLocalDate(),categorie);
						evenements.add(evenement);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return evenements;
	}

	@Override
	public Evenement getEvenement(Integer id) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM evenement WHERE idEvenement = ?")) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						Categorie categorie = new Categorie(resultSet.getInt("idCategorie"), resultSet.getString("titreCategorie"));
						return new Evenement(resultSet.getInt("idEvenement"), resultSet.getString("titreEvenement"), resultSet.getString("lieuEvenement"),resultSet.getDate("dateEvenement").toLocalDate(),categorie);
					}

				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		}
	

	@Override
	public void addEvenement(Evenement evenement) {
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Evenement(titreEvenement, lieuEvenement, dateEvenement, idCategorie) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS)
						){
			
			statement.setString(1, evenement.getTitleEvenement());
			statement.setString(2, evenement.getLieuEvenement());
			statement.setDate(3, Date.valueOf(evenement.getDateEvenement()));
			statement.setInt(4, evenement.getCategorie().getId());
			statement.executeUpdate();
			
			try (ResultSet resultSet = statement.getGeneratedKeys()) {
				if(resultSet.next()) {
					evenement.setIdEvenement(resultSet.getInt(1));
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeEvenement(Integer idEvenement){
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM evenement WHERE idEvenement=?")
						){
			statement.setInt(1,idEvenement);
			statement.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}

	

}
