package hei.projet.entities;

public class Etudiant {
	
		private Integer id;
		private String email;
		private String motDePasse;
		
		
		public Etudiant(Integer id, String email, String motDePasse){
			super();
			this.id = id;
			this.email = email;
			this.motDePasse = motDePasse;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMotDePasse() {
			return motDePasse;
		}

		public void setMotDePasse(String motDePasse) {
			this.motDePasse = motDePasse;
		}

	
		
		
}
