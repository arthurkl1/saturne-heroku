package hei.projet.dao;

import java.util.List;

import hei.projet.entities.Publication;

public interface PublicationDao {
	
	public List<Publication> listPublications();
	
	public Publication getPublication (Integer id);
	
	public Publication addPublication(Publication publication);
	
	public void removePublication(Integer id);
	
	
}
