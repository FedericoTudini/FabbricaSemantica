package it.uniroma1.fabbricasemantica.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;


public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 6784574842574L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doSomething(request, response);
		} catch (SAXException | ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doSomething(request, response);
		} catch (SAXException | ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo che implementa la logica richiesta nelle specifiche del backend.
	 * @throws TransformerException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 * */
	protected abstract void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SAXException, ParserConfigurationException, TransformerException;
	
	
}
