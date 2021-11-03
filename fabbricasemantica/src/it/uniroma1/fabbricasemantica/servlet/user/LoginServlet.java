package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.uniroma1.fabbricasemantica.data.DBManager;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet per la gestione del Login degli utenti
 * @author Federico Tudini
 *
 */
@WebServlet(name="LoginServlet", urlPatterns="/login.jsp")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;
	/**
	 * Il metodo doSomething effettua un primo controllo per controllare che un utente non sia già loggato, 
	 * se così fosse lo disconnette. 
	 * Successivamente controlla che l'utente esista e che la password sia corretta.
	 * Se l'utente non esiste lo reindirizza alla pagina di SignUp
	 * Se la password è errata ricarica la pagina di Login
	 * Se non vi è nessun errore l'utente viene reindirizzato alla pagina Home
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = "";
		
		//Get the session and logout the user if online
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) session.setAttribute("username",null);
		
		//Get the inputs
		String username = request.getParameter("loginEmail");
		String password = request.getParameter("loginPassword");
		
		try {
			//Get the XML doc
			Document doc = DBManager.getDoc();
			
			//Check if the user exists
			NodeList users = doc.getElementsByTagName("user");
			for (int temp = 0; temp < users.getLength(); temp++){
		        Node nNode = users.item(temp);
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		            Element element = (Element) nNode;
		            if(element.getAttribute("id").equals(username)) {
		            	//Check if the password is correct
		            	if (element.getElementsByTagName("password").item(0).getTextContent().equals(password)) {
		            		//Set the user attribute and redirect the user
		            		session.setAttribute("username", username);
		            		page = "Home.html";

		            	}
		            	//If the password is wrong refresh the page
		            	else page = "Login.html";

		            }
		            //If there's no user with that id on the DB, redirect to the signup page
		            else page = "SignUp.html";		            	
		        }
		    }
			
		} catch (SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		response.sendRedirect(page);
	}

}
