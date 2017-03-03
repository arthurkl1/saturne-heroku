package hei.projet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthentificationAdminFilter implements Filter{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String identifiantAdmin = (String) httpRequest.getSession().getAttribute("utilisateurAdminConnecte");
		if(identifiantAdmin == null || "".equals(identifiantAdmin)) {
			System.out.println("Connectez vous pour accéder à cette page Administrateur.");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("../authentificationAdmin");
			return;
			}
		chain.doFilter(request, response); 
		}
		
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	
		
	}
	
	

}