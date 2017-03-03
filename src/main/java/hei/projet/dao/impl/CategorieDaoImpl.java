package hei.projet.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import hei.projet.dao.CategorieDao;
import hei.projet.entities.Categorie;

public class CategorieDaoImpl implements CategorieDao{

	@Override
	public List<Categorie> listCategories() {
		String query = "SELECT * FROM categorie WHERE deleted=false ORDER BY titreCategorie";
		List<Categorie> categories = new ArrayList<>(); 
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						Categorie categorie = new Categorie(resultSet.getInt("idCategorie"), resultSet.getString("titreCategorie"));
						categories.add(categorie);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
		
	}

	@Override
	public Categorie getCategorie(Integer id) {	
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM categorie WHERE idCategorie = ? AND deleted=false")) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						return new Categorie(resultSet.getInt("idCategorie"), resultSet.getString("titreCategorie"));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Categorie addCategorie(String nom) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO categorie(titreCategorie) VALUES(?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, nom);
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						return new Categorie(resultSet.getInt(1), nom);
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void removeCategorie(Integer id){
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM categorie WHERE idCategorie=?")
						){
			statement.setInt(1,id);
			statement.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
	
	}
