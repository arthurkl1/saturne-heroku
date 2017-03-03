package hei.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.utils.MotDePasseUtils;


@WebServlet("/authentificationAdmin")
public class ConnexionAdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3032812618526895052L;
	private Map<String, String> utilisateurAdminAutorise;
	
	
	//pour l'instant car pas de bdd TP3 
	@Override
	public void init() throws ServletException {
		utilisateurAdminAutorise = new HashMap<>();
		utilisateurAdminAutorise.put("admin@hei.fr","17d993100ed7200b93360d74ed2295810405605a00e58bfa:fdc24f290145c8721ea78718ca0d9906690258c850252ed0"); //MotDePasseUtils.java >Run As > Java Application
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.println("<title>Saturne Authentification</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		out.println("<link rel=\"stylesheet\" href=\"css/css_authentification.css\">");
		out.println("</head>");
		
		String adminConnecte = (String) req.getSession().getAttribute("utilisateurAdminConnecte");
		
		if (adminConnecte == null || "".equals(adminConnecte)){
			
		out.println("<body>");
		out.println("<img id=\"bg\" src=\"img/accueil.png\">");	
		out.println("<div class=\"container\">");
		out.println("<div class=\"col-md-6\">");
	    out.println("<img id=\"logo\" src=\"img/icon-saturne.png\">");
		out.println("</div>");
		
		out.println("<form class=\"form-signin\"  method=\"post\">"); //action=\"#\"
		out.println("<label for=\"emailEtudiant\"></label>");
		out.println("<input type=\"text\" name=\"email\" id=\"emailEtudiant\" class=\"form-control\" placeholder=\"Mail administrateur Saturne\" maxlength=\"70\" required=\"@hei.yncrea.fr\" autofocus/>");
		out.println("<label for=\"passwordEtudiant\" class=\"sr-only\"></label>");
		out.println("<input type=\"password\" name=\"password\" id=\"passewordEtudiant\" class=\"form-control\" placeholder=\"Mot de passe\" required/>");
		out.println("<input type=\"submit\" class=\"btn btn-lg btn-primary btn-block\" value=\"Se connecter\">");
		out.println("</form>");
		out.println("<br>");
        out.println("<a class=\"btn btn-danger\" href=\"authentification\">");
        out.println("<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span> Annuler");
        out.println("</a>");
		out.println("</div> ");
		
		}else{
			out.println("<body>");
			out.println("<img id=\"bg\" src=\"img/accueil.png\">");
			out.println("<div class=\"container\">");
			out.println("<div class=\"col-md-6\">");
		    out.println("<img id=\"logo\" src=\"img/icon-saturne.png\">");
			out.println("</div>");
			
			out.println("<div class=\"col-md-6\">");
			out.println("<a style=\"background-color:orange; border-color:orange; width:100%;\" class=\"btn btn-primary\" href=\"priveAdmin/admingestionvideos\">");
            out.println("<span class=\"glyphicon glyphicon-globe\" aria-hidden=\"true\"></span>");
            out.println("Aller au site Admin</a>");
            out.println("</div> ");
		}
				  
    	out.println("</div>");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
		out.println("<script src=\"js/bootstrap.min.js\"></script>");
		out.println("</body>");
		
    	out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String email = req.getParameter("email");
		String motDePasse = req.getParameter("password");
		
		try {
			if (utilisateurAdminAutorise.containsKey(email) 
					&& MotDePasseUtils.validerMotDePasse(motDePasse, utilisateurAdminAutorise.get(email))){
				req.getSession().setAttribute("utilisateurAdminConnecte", email); 
			}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			}
		resp.sendRedirect("authentificationAdmin");
	}
	}



