package hei.projet.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.entities.Categorie;
import hei.projet.entities.Evenement;
import hei.projet.services.CategorieService;
import hei.projet.services.EvenementService;

@WebServlet("/priveAdmin/addEvenement")
public class AddEvenementServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");		
		String nomEvenement = req.getParameter("titre");
		String lieuEvenement = req.getParameter("lieu");
		
		String dateEvenementAsString = req.getParameter("date");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateEvenement = LocalDate.parse(dateEvenementAsString,formatter);
		
		Integer categorieId = Integer.parseInt(req.getParameter("categorie"));
		Categorie categorie = CategorieService.getInstance().getCategorie(categorieId);
		
		Evenement nouvelleEvenement = new Evenement(null, nomEvenement, lieuEvenement, dateEvenement, categorie);
		Evenement evenementAjoutee = EvenementService.getInstance().addEvenement(nouvelleEvenement);
		resp.sendRedirect("admingestionevenements");
		
		
		
		
	}
	
	
}
