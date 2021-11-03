package it.uniroma1.fabbricasemantica.WordNet;

/**
 * Enum di tutte le relazioni possibili in WordNet
 * @author Federico Tudini
 *
 */

public enum EnumRelazioni implements WordNetRelation {
	
	ANTONYM("!"),
	HYPERNYM("@"),
	INSTANCE_HYPERNYM("@i"),
	HYPONYM("~"),
	INSTANCE_HYPONYM("~i"),
	MEMBER_HOLONYM("#m"),
	SUBSTANCE_HOLONYM("#s"),
	PART_HOLONYM("#p"),
	MEMBER_MERONYM("%m"),
	SUBSTANCE_MERONYM("%s"),
	PART_MERONYM("%p"),
	ATTRIBUTE("="),
	DERIVATIONALLY_RELATED_FORM("+"),
	ENTAILMENT("*"),
	CAUSE(">"),
	ALSO_SEE("^"),
	VERB_GROUP("$"),
	SIMILAR_TO("&"),
	PARTICIPLE_OF_VERB("<"),
	PERTAINYM("\\"),
	DOMAIN_OF_SYNSET_TOPIC(";c"),
	DOMAIN_OF_SYNSET_REGION(";r"),
	DOMAIN_OF_SYNSET_USAGE(";u"),
	MEMBER_OF_THIS_DOMAIN_TOPIC("-c"),
	MEMBER_OF_THIS_DOMAIN_REGION("-r"),
	MEMBER_OF_THIS_DOMAIN_USAGE("-u");
	
	private String rel;
	
	EnumRelazioni(String rel) {this.rel = rel;}

	public String getRel() {
		return rel;
	}
	
}
