package hei.projet.entities;

import java.sql.Date;

public class Video {

	private Integer id;
	private Evenement evenement;
	private String titreVideo;
	private String description;
	private Date dateVideo;
	
	
	
	
	
	public Video(Integer id, Evenement evenement, String titreVideo, String description, Date dateVideo) {
		super();
		this.id = id;
		this.evenement = evenement;
		this.titreVideo = titreVideo;
		this.description = description;
		this.dateVideo = dateVideo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Evenement getEvenement() {
		return evenement;
	}
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}
	public String getTitreVideo() {
		return titreVideo;
	}
	public void setTitreVideo(String titreVideo) {
		this.titreVideo = titreVideo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateVideo() {
		return dateVideo;
	}
	public void setDateVideo(Date dateVideo) {
		this.dateVideo = dateVideo;
	}
	

	
	
	


}
