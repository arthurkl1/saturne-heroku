package hei.projet.entities;

import java.sql.Date;
import java.time.LocalDate;



public class Evenement {
	
	private Integer idEvenement;
	private String titleEvenement;
	private String lieuEvenement;
	private LocalDate dateEvenement;
	private Categorie categorie;
	
	public Evenement(Integer idEvenement, String titleEvenement, 
			String lieuEvenement, LocalDate dateEvenement,
			Categorie categorie){		
	super();
	this.idEvenement = idEvenement;
	this.titleEvenement = titleEvenement;
	this.lieuEvenement = lieuEvenement;
	this.dateEvenement = dateEvenement;
	this.categorie = categorie; 
	}

	public Integer getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(Integer idEvenement) {
		this.idEvenement = idEvenement;
	}

	public String getTitleEvenement() {
		return titleEvenement;
	}

	public void setTitleEvenement(String titleEvenement) {
		this.titleEvenement = titleEvenement;
	}

	public String getLieuEvenement() {
		return lieuEvenement;
	}

	public void setLieuEvenement(String lieuEvenement) {
		this.lieuEvenement = lieuEvenement;
	}

	public LocalDate getDateEvenement() {
		return dateEvenement;
	}

	public void setDateEvenement(LocalDate dateEvenement) {
		this.dateEvenement = dateEvenement;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	
	
}
