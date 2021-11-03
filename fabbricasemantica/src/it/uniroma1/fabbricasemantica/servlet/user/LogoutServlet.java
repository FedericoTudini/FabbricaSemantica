package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
/**
 * Servlet per la gestione del Logout degli utenti
 * @author Federico Tudini
 *
 */
@WebServlet(name="LogoutServlet", urlPatterns="/logout.jsp")
public class LogoutServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;
	/**
	 * Il metodo doSomething setta l'attributo username della sessione HTTP a null e 
	 * reindirizza alla pagina di Login.
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username", null);
		response.sendRedirect("Login.html");
	}

}
