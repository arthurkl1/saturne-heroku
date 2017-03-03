package hei.projet.dao;

import java.util.List;

import hei.projet.entities.Evenement;

public interface EvenementDao {
	
	public List<Evenement> listEvenements();
	
	public Evenement getEvenement(Integer id);
	
	public void addEvenement(Evenement evenement);
	
	public void removeEvenement(Integer idEvenement);

}
