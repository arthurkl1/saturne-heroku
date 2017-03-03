package hei.projet.services;

import java.util.List;

import hei.projet.dao.impl.CategorieDaoImpl;
import hei.projet.entities.Categorie;


public class CategorieService {

	private CategorieDaoImpl categorieDao = new CategorieDaoImpl();
	
	private static class CatogrieServiceHolder{
		private static CategorieService instance = new CategorieService();
	}
	
	public static CategorieService getInstance(){
		return CatogrieServiceHolder.instance;
	}
	
	private CategorieService(){
	}
	
	public List<Categorie> listCategorie(){
		return categorieDao.listCategories();
	}
	
	public Categorie getCategorie(Integer id){
		return categorieDao.getCategorie(id);
	
	}
	
	public void addCategorie(String nom){
		categorieDao.addCategorie(nom);
	}
	
	public void removeCategorie(Integer categorieId){
		categorieDao.removeCategorie(categorieId);
	}

}
