package hei.projet.services;

import java.util.List;

import hei.projet.dao.impl.EtudiantDaoImpl;
import hei.projet.entities.Etudiant;


public class EtudiantService {

	private EtudiantDaoImpl etudiantDao = new EtudiantDaoImpl();
	
	private static class EtudiantServiceHolder{
		private static EtudiantService instance = new EtudiantService();
	}
	
	public static EtudiantService getInstance(){
		return EtudiantServiceHolder.instance;
	}
	
	private EtudiantService(){
	}
	
	public List<Etudiant> listEtudiant(){
		return etudiantDao.listEtudiants();
	}
	
	public Etudiant getEtudiant(Integer id){
		return etudiantDao.getEtudiant(id);
	}
	
	public void addEtudiant(Etudiant etudiant){
		etudiantDao.addEtudiant(etudiant);
	}
	
	public void removeEtudiant(Integer id){
		etudiantDao.removeEtudiant(id);
	}
}
