package it.uniroma1.fabbricasemantica.data;

/**
 * 
 * Enum dei possibili Task con associati i loro Link
 * @author Federico Tudini
 *
 */
public enum StandardTask implements Task {
	
	TRANSLATION_ANNOTATION ("translationAnnotation.html"),
	WORD_ANNOTATION ("wordAnnotation.html"),
	DEFINITION_ANNOTATION ("definitionAnnotation.html"),
	SENSE_ANNOTATION ("senseAnnotation.html"),
	TRANSLATION_VALIDATION ("translationValidation.html"),
	SENSE_VALIDATION ("senseValidation.html"),
	MY_ANNOTATION ("myAnnotation.html");
	
	private String link;
	
	StandardTask(String link) {this.link = link;}
	
	public String getLink() {return link;}
	
}
