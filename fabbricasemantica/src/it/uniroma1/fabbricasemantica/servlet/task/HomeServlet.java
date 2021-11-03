package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet per i dati inviati dalla pagina Home
 * @author Federico Tudini
 *
 */
@WebServlet(name = "HomeServlet", urlPatterns = "/home.jsp")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	 /**
	  * Una volta premuto il pulsante play, chiama il metodo getPage() e reindirizza
	  * ad uno dei task in maniera casuale
	  */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SAXException, ParserConfigurationException, TransformerException {
		HttpSession session = request.getSession();
		String page = TaskServletManager.getPage(session);
		response.sendRedirect(page);
	}

}
