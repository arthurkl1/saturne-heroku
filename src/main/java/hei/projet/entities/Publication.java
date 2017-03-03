package hei.projet.entities;

import java.net.URL;
import java.time.LocalDate;

public class Publication {
	
	private Integer id;
	private String titre;
	private LocalDate releaseDate;
	private String lienYouTube;
	private Categorie categorie;
	
	
	public Publication(Integer id, String titre, LocalDate releaseDate,
			String lienYouTube, Categorie categorie){
		super();
		this.id = id;
		this.titre = titre;
		this.releaseDate = releaseDate;
		this.lienYouTube = lienYouTube; 
		this.categorie = categorie;
		}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String title) {
		this.titre = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getLienYouTube() {
		return lienYouTube;
	}

	public void setLienYouTube(String lienYouTube) {
		this.lienYouTube = lienYouTube;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
