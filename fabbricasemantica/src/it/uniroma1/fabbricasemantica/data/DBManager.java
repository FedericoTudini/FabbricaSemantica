package it.uniroma1.fabbricasemantica.data;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
/**
 * La classe DBManager si occupa di gestire il file database.xml utilizzando la libreria DOM.
 * @author Federico Tudini
 *
 */
public class DBManager {
	
	private static final File DB = new File("database.xml");
	
	/**
	 * Il metodo statico getDoc permette di ottenere il file database.xml e dunque la sua struttura ad albero
	 * in modo da poter essere modificata per salvare i dati.
	 * @return doc : un oggetto di tipo Document che rappresenta l'albero del file database.xml
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public static Document getDoc() throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(DB);
		return doc;
	}
	
	/**
	 * Il metodo statico saveDoc prende in input un oggetto di tipo Document (ottenuto con il metodo getDoc)
	 * e salva le modifiche che sono state effettuate, sovrascrivendo il file database.xml 
	 * @param doc : un oggetto di tipo Document che rappresenta l'albero del file databse.xml
	 * @throws TransformerException
	 */
	public static void saveDoc(Document doc) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(DB);
        transformer.transform(domSource, streamResult);
	}

}
