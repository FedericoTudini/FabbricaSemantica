package it.uniroma1.fabbricasemantica.WordNet;

import java.util.List;

public class Synset {
	
	private String offset;
	private int NParole;
	private List<String> parole;
	private String ID;
	private String pos;
	private int NRelation;
	private List<Relation> relazioni;
	private String gloss;
	private List<String> examples;
	private List<String> traduzioni;
	private String glossaItaliana;
	
	
	//Costruttore
	public Synset(String offset, int nParole, String pos, int nRelation, List<String> parole, List<Relation> relazioni, String gloss, List<String> examples, List<String> traduzioni, String glossaItaliana) {
		
		this.offset = offset;
		this.NParole = nParole;
		this.pos = pos;
		this.ID = offset+pos;
		this.NRelation = nRelation;
		this.relazioni = relazioni;
		this.parole = parole;
		this.gloss = gloss;
		this.examples = examples;
		this.traduzioni = traduzioni;
		this.glossaItaliana = glossaItaliana;
	}
	
	/**
	 * Getter per la lista di sinonimi del Synset
	 * @return parole : Lista dei sinonimi
	 */
	public List<String> getSynonyms() {
		return parole;
	}
	
	/**
	 * Getter per la lista di oggetti relazione del Synset
	 * @return relazioni : Lista degli oggetti Relazione collegati al Synset
	 */
	public List<Relation> getRelations() {
		return relazioni;
	}
	
	/**
	 * Getter per l'offset del Synset
	 * @return offset
	 */
	public String getOffset() {
		return offset;
	}
 	
	/**
	 * Getter per l'ID del Synset
	 * @return ID
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * Controlla che la parola passata in input sia contenuta nella lista dei sinonimi
	 * @param s
	 * @return boolean
	 */
	public boolean contains(String s) {
		return parole.contains(s);
	}
	
	/**
	 * Getter per l'enum POS associato al Synset
	 * @return POS : Restituisce l'enum POS del Synset
	 */
	public Enum<POS> getPOS() {
		switch(pos) {
		case("n") : return POS.NOUN;
		case("v") : return POS.VERB;
		case("a") : return POS.ADJECTIVE;
		case("s") : return POS.ADJECTIVE;
		case("r") : return POS.ADVERB;
		default : return null;
		}
	}
	
	/**
	 * Getter per la glossa del Synset
	 * @return gloss
	 */
	public String getGloss() {
		return gloss;
	}
	
	/**
	 * Getter per la lista degli esempi del Synset
	 * @return examples : Restituisce la lista degli esempi del Synset
	 */
	public List<String> getExamples() {
		return examples;
	}
	/**
	 * Getter per la lista delle traduzioni
	 * @return traduzioni : Restituisce la lista delle traduzioni italiane del Synset, altrimenti null
	 */
	public List<String> getTraduzioni() {
		return traduzioni;
	}
	/**
	 * Getter per la glossa italiana
	 * @return glossaItaliana : stringa della glossa italiana se esistente, altrimenti null
	 */
	public String getGlossaItaliana() {
		return glossaItaliana;
	}
	
	public String toString() {
		String ret = offset + " " + pos + " " + NParole;
		for (String s : parole) ret+= " "+s;
		ret += " " + NRelation ;
		for (Relation r : relazioni) ret += " " + r.toString();
		ret += gloss;
		for(String s : examples) ret += s;
		
		return ret;
	}

	
	
	
	

}
