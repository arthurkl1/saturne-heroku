package hei.projet.services;

import java.util.List;


import hei.projet.dao.CategorieDao;
import hei.projet.dao.PublicationDao;
import hei.projet.dao.impl.CategorieDaoImpl;
import hei.projet.dao.impl.PublicationDaoImpl;
import hei.projet.entities.Categorie;
import hei.projet.entities.Publication;

public class PublicationService {
	
	private static class PublicationServiceHolder{
		private static PublicationService instance = new PublicationService();
	}
	
	public static PublicationService getInstance(){
		return PublicationServiceHolder.instance;
	}
	
	//private PublicationDaoImpl publicationDao = new PublicationDaoImpl();
	private PublicationDao publicationDao = new PublicationDaoImpl();
	//
	private CategorieDao categorieDao = new CategorieDaoImpl();
	
	private PublicationService(){	
	}
	
	//public List<Publication> listPublication(){     il y avait pas de S
	public List<Publication> listPublications(){
		return publicationDao.listPublications();
	}
	
	public Publication getPublication(Integer id){
		return publicationDao.getPublication(id);
	}
	
	public void addPublication(Publication publication){
		publicationDao.addPublication(publication);
	}
	
	public void removePublication(Integer id){
		publicationDao.removePublication(id);
	}
	
	//Ajout : 
	//
	//
	public List<Categorie> listCategories() {
		return categorieDao.listCategories();
	}

	public Categorie getCategorie(Integer id) {
		return categorieDao.getCategorie(id);
	}

	public Categorie addCategorie(String nom) {
		return categorieDao.addCategorie(nom);
	}
	
	
}