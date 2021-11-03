package it.uniroma1.fabbricasemantica.WordNet;

/**
 * La classe Relation rappresenta gli oggetti "relazione" ovvero tutte le relazioni 
 * di un Synset, caratterizzate da un simbolo che rappresenta il tipo di relazione,
 * l'offset del Synset destinazione e il suo POS.
 * @author Federico Tudini
 *
 */

public class Relation {
	
	private String type;
	private String offset;
	private String pos;
	
	//Costruttore
	public Relation(String type, String offset, String pos) {
		this.type = type;
		this.offset = offset;
		this.pos = pos;
	}
	
	/**
	 * Getter per il tipo del Synset della relazione
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Getter per l'offset del Synset della relazione
	 * @return offset
	 */
	public String getOffset() {
		return offset;
	}
	
	/**
	 * Getter per il POS del Synset della relazione
	 * @return
	 */
	public String getPos() {
		return pos;
	}
	
	public String toString() {
		return "Rel: "+ type + " " + offset + " " + pos;
	}
	

}
