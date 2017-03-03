package hei.projet.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public class AbstractGenericServlet extends HttpServlet{
	
	private static final long serialVersionUID = -3032812618526895052L;
	
	protected TemplateEngine createTemplateEngine(HttpServletRequest request){
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(request.getServletContext());
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		
		return templateEngine;
	}

}
