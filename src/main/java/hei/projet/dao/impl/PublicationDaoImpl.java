package hei.projet.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.dao.impl.DataSourceProvider;
import hei.projet.dao.PublicationDao;
import hei.projet.entities.Categorie;
import hei.projet.entities.Publication;

public class PublicationDaoImpl implements PublicationDao {

	@Override
	public List<Publication> listPublications() {
		//jointure a ajouter avec la table etudiant
		String query = "SELECT * FROM publication JOIN categorie ON publication.idCategorie = categorie.idCategorie ORDER BY titrePublication";
		List<Publication> publications = new ArrayList<>(); 
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						Categorie categorie = new Categorie(resultSet.getInt("idCategorie"), resultSet.getString("titreCategorie"));
						Publication publication = new Publication(resultSet.getInt("idPublication"), resultSet.getString("titrePublication"), 
								resultSet.getDate("datePublication").toLocalDate(), resultSet.getString("lienPublication"), categorie);
						publications.add(publication);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publications;
	}

	@Override
	public Publication getPublication(Integer id) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM publication JOIN categorie ON publication.idCategorie = categorie.idCategorie WHERE idPublication = ?")) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						Categorie categorie = new Categorie(resultSet.getInt("idCategorie"), resultSet.getString("titreCategorie"));
						return  new Publication(resultSet.getInt("idPublication"), resultSet.getString("titrePublication"), 
								resultSet.getDate("datePublication").toLocalDate(), resultSet.getString("lienPublication"),categorie);
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Publication addPublication(Publication publication) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO publication(titrePublication,datePublication,lienPublication,categorie) VALUES(?,?,?,?)")) {
				statement.setDate(1, Date.valueOf(publication.getReleaseDate()));
				statement.setString(2, publication.getLienYouTube());
				statement.setInt(3, publication.getCategorie().getId());
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						publication.setId(resultSet.getInt(1));
						return publication;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void removePublication(Integer id){
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM publication WHERE idPublication=?")
						){
			statement.setInt(1,id);
			statement.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}

}
