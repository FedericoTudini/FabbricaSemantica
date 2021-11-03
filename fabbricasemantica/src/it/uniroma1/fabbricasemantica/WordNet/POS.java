package it.uniroma1.fabbricasemantica.WordNet;

/**
 * Enum delle possibili parti del discorso in WordNet
 * @author Federico Tudini
 *
 */

public enum POS {
	
	NOUN("n"), ADJECTIVE("a"), VERB("v"), ADVERB("r");
	
	private String pos;
	
	POS(String pos) {this.pos = pos;}

	public String getPos() {
		return pos;
	}
	

}
