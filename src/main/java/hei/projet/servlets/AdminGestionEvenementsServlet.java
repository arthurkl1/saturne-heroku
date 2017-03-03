package hei.projet.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.projet.entities.Categorie;
import hei.projet.services.PublicationService;

@WebServlet("/priveAdmin/admingestionevenements")
public class AdminGestionEvenementsServlet extends AbstractGenericServlet {
	

	private static final long serialVersionUID = -3032812618526895052L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		List<Categorie> categories = PublicationService.getInstance().listCategories();
		context.setVariable("categories", categories);
		
		templateEngine.process("administration-gestionevenements", context, resp.getWriter());
	}

}
