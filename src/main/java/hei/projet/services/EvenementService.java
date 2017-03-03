package hei.projet.services;

import java.util.List;

import hei.projet.dao.impl.EvenementDaoImpl;
import hei.projet.entities.Evenement;


public class EvenementService {

	private EvenementDaoImpl evenementDao = new EvenementDaoImpl();
	

	private static class EvenementServiceHolder{
		private static EvenementService instance = new EvenementService();
	}
	
	public static  EvenementService getInstance(){
		return EvenementServiceHolder.instance;
	}
	
	private EvenementService(){
	}
	
	public List<Evenement> listEvenement(){
		return evenementDao.listEvenements();
	}
	
	public Evenement getCategorie(Integer id){
		return evenementDao.getEvenement(id);
	
	}
	
	public Evenement addEvenement(Evenement evenement){
		evenementDao.addEvenement(evenement);
		return evenement;
	}
	
	public void removeEvenement(Integer idEvenement){
		evenementDao.removeEvenement(idEvenement);
	}
	
	
}
