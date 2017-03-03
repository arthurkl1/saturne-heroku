package hei.projet.saturne.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hei.projet.dao.CategorieDao;
import hei.projet.dao.impl.CategorieDaoImpl;
import hei.projet.dao.impl.DataSourceProvider;
import hei.projet.entities.Categorie;



public class CategorieDaoTestCase {
	
	private CategorieDao categorieDao = new CategorieDaoImpl();

	@Before
	public void initDb() throws Exception {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement stmt = connection.createStatement()) {
			stmt.executeUpdate("DELETE FROM categorie");
			stmt.executeUpdate("INSERT INTO `categorie`(`idCategorie`,`titreCategorie`,`deleted`) VALUES (1,'Administration',false)");
			stmt.executeUpdate("INSERT INTO `categorie`(`idCategorie`,`titreCategorie`,`deleted`) VALUES (2,'BDA',false)");
			stmt.executeUpdate("INSERT INTO `categorie`(`idCategorie`,`titreCategorie`,`deleted`) VALUES (3,'BDE',false)");
			stmt.executeUpdate("INSERT INTO `categorie`(`idCategorie`,`titreCategorie`,`deleted`) VALUES (4,'BDS',false)");
		}
	}

	@Test
	public void shouldListCategories() {
		// WHEN
		List<Categorie> categories = categorieDao.listCategories();
		// THEN
		assertThat(categories).hasSize(4);
		assertThat(categories).extracting("id", "nom").containsOnly(tuple(4, "BDS"), tuple(3, "BDE"),tuple(2,"BDA"),tuple(1,"Administration"));
	}

	@Test
	public void shouldGetCategorie() {
		// WHEN
		Categorie categorie = categorieDao.getCategorie(1);
		// THEN
		assertThat(categorie).isNotNull();
		assertThat(categorie.getId()).isEqualTo(1);
		assertThat(categorie.getNom()).isEqualTo("Administration");
	}

	@Test
	public void shouldAddCategorie() throws Exception {
		// WHEN
		Categorie categorie = categorieDao.addCategorie("test");
		// THEN
		assertThat(categorie.getId()).isNotNull();
		assertThat(categorie.getNom()).isEqualTo("test");

		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM categorie WHERE idCategorie = ?")) {
			stmt.setInt(1, categorie.getId());
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getInt("idCategorie")).isEqualTo(categorie.getId());
				assertThat(rs.getString("titreCategorie")).isEqualTo("test");
				assertThat(rs.next()).isFalse();
			}
		}
	}

}