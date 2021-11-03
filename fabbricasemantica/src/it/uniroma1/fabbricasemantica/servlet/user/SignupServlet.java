package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.uniroma1.fabbricasemantica.data.DBManager;
import it.uniroma1.fabbricasemantica.data.StandardTask;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet per la gestione della registrazione di un nuovo utente
 * @author Federico Tudini
 *
 */
@WebServlet(name="SignupServlet", urlPatterns="/signup.jsp")
public class SignupServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;
	
	/**
	 * Il metodo doSomething effettua un primo controllo per controllare che un utente non sia già loggato, 
	 * se così fosse lo disconnette. 
	 * Una volta ottenuti tutti i parametri inseriti in input nel lato front-end ne controlla la validità,
	 * nel caso in cui non lo siano ricarica la pagina.
	 * Successivamente controlla che l'utente non esista sulla base di dati e, nel caso esista, reindirizza
	 * alla pagina di Login.
	 * Una volta passati i seguenti controlli, i dati del nuovo utente vengono inseriti nella
	 * base di dati come elemento "user", con l'attributo id che corrisponde all'indirizzo email, un figlio
	 * per la password, uno o due figli per le lingue madri, uno o due figli per le altre lingue conosciute (opzionali) e
	 * un figlio tasks che ha a sua volta un figlio per ogni Task.
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = "";
		
		//Get the session and logout the user if online
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) session.setAttribute("username",null);
		
		//Get all the inputs
		String username = request.getParameter("signupEmail");
		String password = request.getParameter("signupPassword");
		String repeatPassword = request.getParameter("signupRepeatPassword");
		String English = request.getParameter("English (EN)");
		String Italian = request.getParameter("Italian (IT)");
		String Select1 = request.getParameter("Select1");
		String Radio1 = request.getParameter("Radio1");
		String Select2 = request.getParameter("Select2");
		String Radio2 = request.getParameter("Radio2");
		
		//Control the inputs and save the user on the DB
		if (username != null && (password.equals(repeatPassword) && password != null && repeatPassword != null) && (English != null || Italian != null)) {
			try {
				//Get the root of the XML Tree
				Document doc = DBManager.getDoc();
				Element root = doc.getDocumentElement();
				
				//Check if the user is already on the DB
				NodeList users = doc.getElementsByTagName("user");
				
				for (int temp = 0; temp < users.getLength(); temp++){
			        Node nNode = users.item(temp);
			        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			            Element element = (Element) nNode;
			            if(element.getAttribute("id").equals(username));
			            page = "Login.html";
			        }
			    }
				
				
				//Create a new child and append it to the root
				Element user = doc.createElement("user");
				root.appendChild(user);
				//Set id attribute to the element
				user.setAttribute("id", username);
				//Add password element
				Element pass = doc.createElement("password");
	            pass.appendChild(doc.createTextNode(password));
	            user.appendChild(pass);
	            //Add native languages checkboxes if checked
	            if (Italian != null) {
	            	Element it = doc.createElement("Italian");
		            it.appendChild(doc.createTextNode("True"));
		            user.appendChild(it);
	            }
	            if (English != null) {
	            	Element en = doc.createElement("English");
		            en.appendChild(doc.createTextNode("True"));
		            user.appendChild(en);
	            }
	            //Add other languages (optional)
	            if (Select1 != null && !Select1.equals("")) {
	            	switch(Select1) {
	            	
		            case "Italian" : 
		            	if (Italian == null) {
		            		Element otherLanguage1 = doc.createElement(Select1);
			            	otherLanguage1.appendChild(doc.createTextNode(Radio1));
				            user.appendChild(otherLanguage1);
		            	}
		            	break;
		            case "English" : 
		            	if (English == null) {
		            		Element otherLanguage1 = doc.createElement(Select1);
			            	otherLanguage1.appendChild(doc.createTextNode(Radio1));
				            user.appendChild(otherLanguage1);
		            	}
		            	break;
		            default :
		            	Element otherLanguage1 = doc.createElement(Select1);
		            	otherLanguage1.appendChild(doc.createTextNode(Radio1));
			            user.appendChild(otherLanguage1);
		            }
	            }
	         
	            if (Select2 != null && !Select2.equals(Select1) && !Select2.equals("")) {
	            	switch(Select2) {
	            	
		            case "Italian" : 
		            	if (Italian == null) {
		            		Element otherLanguage2 = doc.createElement(Select2);
			            	otherLanguage2.appendChild(doc.createTextNode(Radio2));
				            user.appendChild(otherLanguage2);
		            	}
		            	break;
		            case "English" : 
		            	if (English == null) {
		            		Element otherLanguage2 = doc.createElement(Select2);
			            	otherLanguage2.appendChild(doc.createTextNode(Radio2));
				            user.appendChild(otherLanguage2);
		            	}
		            	break;
		            default :
		            	Element otherLanguage2 = doc.createElement(Select2);
		            	otherLanguage2.appendChild(doc.createTextNode(Radio2));
			            user.appendChild(otherLanguage2);
		            }
	            }
	            //Add answers element
	            Element answers = doc.createElement("tasks");
	            user.appendChild(answers);
	            //Add an element for every task under the answer element
	            List<String> tasks = Arrays.stream(StandardTask.values()).map(t -> t.getTaskID()).collect(Collectors.toList());
	            for (String task : tasks) {
	            	Element eTask = doc.createElement(task);
	            	answers.appendChild(eTask);
	            }
	            DBManager.saveDoc(doc);
	            session.setAttribute("username",username);
	            page = "Home.html";
				
			} catch (SAXException | ParserConfigurationException | TransformerException e) {
				e.printStackTrace();
			}
		}
		else {
			page = "SignUp.html";
		}
		response.sendRedirect(page);
	}
	



}
