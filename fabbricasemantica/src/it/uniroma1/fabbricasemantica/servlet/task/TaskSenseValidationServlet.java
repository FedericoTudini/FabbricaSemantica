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

import it.uniroma1.fabbricasemantica.data.StandardTask;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet per i dati inviati dalla pagina senseValidation
 * @author Uar
 *
 */
@WebServlet(name = "TaskSenseValidationServlet", urlPatterns = "/senseValidation.jsp")
public class TaskSenseValidationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Riceve l'ID del Synset e controlla che sia stato premuto il pulsante Next.
	 * Se è stato premuto Next chiama il metodo check e successivamente il metodo getPage 
	 * per reindirizzare casualmente al task successivo.
	 * Se è stato premuto skip reindirizza a un task casuale.
	 * N.B. Se l'utente non è autenticato alla sessione reindirizza in ogni caso alla pagina di Login.
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SAXException, ParserConfigurationException, TransformerException {
		HttpSession session = request.getSession();
		String page = TaskServletManager.getPage(session);
		String ID = request.getParameter("synsetID");
		String buttonNext = request.getParameter("buttonNext");
		if(buttonNext != null && buttonNext.equals("NEXT")) TaskServletManager.check(ID, StandardTask.SENSE_VALIDATION, request, response);
		response.sendRedirect(page);
	}

}
