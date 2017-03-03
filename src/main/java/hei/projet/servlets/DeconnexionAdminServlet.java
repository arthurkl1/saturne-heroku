package hei.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/priveAdmin/deconnexion")
public class DeconnexionAdminServlet extends HttpServlet{
	
	private static final long serialVersionUID = -3032812618526895052L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("utilisateurAdminConnecte");
		resp.sendRedirect("authentificationAdmin");
	}

}
