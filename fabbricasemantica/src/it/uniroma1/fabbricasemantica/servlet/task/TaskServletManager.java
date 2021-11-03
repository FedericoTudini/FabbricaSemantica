package it.uniroma1.fabbricasemantica.servlet.task;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

import it.uniroma1.fabbricasemantica.WordNet.*;
import it.uniroma1.fabbricasemantica.data.DBManager;
import it.uniroma1.fabbricasemantica.data.StandardTask;
import it.uniroma1.fabbricasemantica.data.Task;

/**
 * Classe con metodi statici per gestire le Servlet dei vari Task,
 * ovvero controllare che la risposta data sia corretta, salvare la risposta nella base di dati,
 * reindirizzare l'utente ad uno dei task in maniera casuale.
 * @author Federico Tudini
 *
 */
public class TaskServletManager {
	//Istanza di WordNet
	private static final WordNet wordnet = WordNet.getInstance("3.0");
	//Lista dei link dei task per il reindirizzamento casuale
	private static final List<String> taskLinks = Arrays.stream(StandardTask.values()).map(t -> t.getLink()).collect(Collectors.toList()); 
	
	/**
	 * Controlla che l'utente sia loggato alla sessione e lo reindirizza ad uno dei task in maniera casuale.
	 * Se l'utente non è loggato lo manda alla pagina di Login.
	 * @param session
	 * @return String : link della pagina alla quale reindirizzare l'utente
	 * @throws IOException
	 */
	public static String getPage(HttpSession session) throws IOException {
		if (session.getAttribute("username") == null) return "Login.html";
		return taskLinks.get(new Random().nextInt(taskLinks.size()));
	}
	
	/**
	 * Salva l'ID del Synset e la risposta data dall'utente nella base di dati come elemento "result" 
	 * sotto il task corrispondente.
	 * Nell'elemento "result" viene salvato l'ID del Synset e un valore booleano ottenuto dal metodo check
	 * che rappresenta la correttezza della risposta data.
	 * @param result
	 * @param ID
	 * @param task
	 * @param request
	 * @param response
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	public static void save(boolean result, String ID, Task task, HttpServletRequest request, HttpServletResponse response) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		HttpSession session = request.getSession();
		String taskID = task.getTaskID();
		String username = (String) session.getAttribute("username");
		Document doc = DBManager.getDoc();
		NodeList users = doc.getElementsByTagName("user");
		for (int temp = 0; temp < users.getLength(); temp++){
	        Node nNode = users.item(temp);
	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element element = (Element) nNode;
	            if(element.getAttribute("id").equals(username)) {
	            	Element answers = (Element) element.getElementsByTagName("tasks").item(0);
	            	Element eTask = (Element) answers.getElementsByTagName(taskID).item(0);
	            	Element taskAnswer = doc.createElement("result");
	            	eTask.appendChild(taskAnswer);
	            	taskAnswer.setAttribute("id", ID);
	            	Element isCorrect = doc.createElement("isCorrect");
		            isCorrect.appendChild(doc.createTextNode(String.valueOf(result)));
		            taskAnswer.appendChild(isCorrect);
//	            	
            	}
            }	            	
        }
		DBManager.saveDoc(doc);
    }
	
	/**
	 * Prende i dati spediti dal client e controlla la corretteza della risposta.
	 * In seguito richiama il metodo Save per salvare i dati nel database.
	 * @param ID
	 * @param task
	 * @param request
	 * @param response
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	public static void check(String ID, Task task, HttpServletRequest request, HttpServletResponse response) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		Synset syn = wordnet.getSynsetFromID(ID);
		
		if (task == StandardTask.TRANSLATION_ANNOTATION) {
			String textArea = request.getParameter("textArea").trim().toLowerCase();
			List<String> traduzioni = syn.getTraduzioni().stream().map(s -> s.trim().toLowerCase()).collect(Collectors.toList());
			TaskServletManager.save(traduzioni.contains(textArea), ID, task, request, response);
			return;
		}else if (task == StandardTask.WORD_ANNOTATION) {
			String textArea = request.getParameter("textArea").trim().toLowerCase();
			List<String> traduzioni = syn.getTraduzioni().stream().map(s -> s.trim().toLowerCase()).collect(Collectors.toList());
			TaskServletManager.save(traduzioni.contains(textArea), ID, task, request, response);
			return;
		}else if (task == StandardTask.DEFINITION_ANNOTATION) {
			String textArea = request.getParameter("textArea").trim().toLowerCase();
			List<String> traduzioni = syn.getTraduzioni().stream().map(s -> s.trim().toLowerCase()).collect(Collectors.toList());
			TaskServletManager.save(traduzioni.contains(textArea), ID, task, request, response);
			return;
		}else if (task == StandardTask.SENSE_ANNOTATION) {
			String radio = request.getParameter("radio");
			TaskServletManager.save(syn.getGloss().equals(radio), ID, task, request, response);
			return;
		}else if (task == StandardTask.TRANSLATION_VALIDATION) {
			String radio = request.getParameter("radio");
			TaskServletManager.save(syn.getGlossaItaliana().equals(radio), ID, task, request, response);
			return;
		}else if (task == StandardTask.SENSE_VALIDATION) {
			String radio = request.getParameter("radio");
			String sense = request.getParameter("sense");
			boolean result = false;
			if((radio.equals("Yes") && syn.getGloss().equals(sense)) || (radio.equals("No") && !syn.getGloss().equals(sense))) result = true; 
			TaskServletManager.save(result, ID, task, request, response);
			return;
		}else if (task == StandardTask.MY_ANNOTATION) {
			String assembled = request.getParameter("assembled");
			String gloss = syn.getGloss().substring(0, 1).toUpperCase() + syn.getGloss().substring(1)+".";
			TaskServletManager.save(assembled.equals(gloss), ID, task, request, response);
			return;
		}
		return; 
	}
}
