package hei.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;


import hei.projet.services.PublicationService;

@WebServlet("/priveAdmin/admingestioncategories")
public class AdminCategoriesServlet extends AbstractGenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		context.setVariable("categories", PublicationService.getInstance().listCategories());
		
		templateEngine.process("administration-listcategories", context, resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String categorieNom = req.getParameter("categorieName");
			PublicationService.getInstance().addCategorie(categorieNom);
			
			resp.sendRedirect("admingestioncategories");
		}
	}