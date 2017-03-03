package hei.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

@WebServlet("/priveAdmin/admingestionsiteconnexion")
public class AdminGSCServlet extends AbstractGenericServlet {

private static final long serialVersionUID = -3032812618526895052L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		templateEngine.process("administration-gestionsite-connexion", context, resp.getWriter());
	}
	
}
