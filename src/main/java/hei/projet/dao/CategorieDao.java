package hei.projet.dao;

import java.util.List;

import hei.projet.entities.Categorie;

public interface CategorieDao {
	
	public List<Categorie> listCategories();
	
	public Categorie getCategorie(Integer id);
	
	public Categorie addCategorie (String libelle);
	
	public void removeCategorie(Integer idCategorie);

}