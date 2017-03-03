package hei.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.entities.Etudiant;
import hei.projet.services.EtudiantService;

@WebServlet("/ajouterEtudiant")
public class AjoutEtudiantServlet extends HttpServlet {

	
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setCharacterEncoding("UTF-8");
			
			String mailEtudiant = req.getParameter("email");
			String motDePasse = req.getParameter("password");
			System.out.println(mailEtudiant);
			System.out.println(motDePasse);
			
			Etudiant etudiantToAdd = new Etudiant(null,mailEtudiant,motDePasse);
			EtudiantService.getInstance().addEtudiant(etudiantToAdd);
			resp.sendRedirect("authentification");
			
		}
	}


