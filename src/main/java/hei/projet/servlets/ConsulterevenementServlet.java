package hei.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import hei.projet.services.EvenementService;

@WebServlet("/prive/consulterevenement")
public class ConsulterevenementServlet extends AbstractGenericServlet {
	
	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("evenements", EvenementService.getInstance().listEvenement());
		templateEngine.addDialect(new Java8TimeDialect());
		templateEngine.process("calendrier", context, resp.getWriter());
	}
	
}

