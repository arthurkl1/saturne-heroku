package hei.projet.dao;

import java.util.List;

import hei.projet.entities.Etudiant;

public interface EtudiantDao {
	
	public List<Etudiant> listEtudiants();
	
	public Etudiant getEtudiant(Integer id);
	
	public void addEtudiant(Etudiant etudiant);
	
	public void removeEtudiant(Integer id);

}
