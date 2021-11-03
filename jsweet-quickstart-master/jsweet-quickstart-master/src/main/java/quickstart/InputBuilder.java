package quickstart;

import def.dom.HTMLInputElement;
import jsweet.util.StringTypes;
import static def.dom.Globals.document;

/**
 * Classe builder per gli InputElement
 * @author FedericoTudini
 *
 */
public class InputBuilder extends HTMLBuilder<HTMLInputElement> {
	
	private HTMLInputElement input;
	
	public InputBuilder() {
		super(document.createElement(StringTypes.input));
		input = super.build();
	}
	
	/**
	 * Metodo setter per il contenuto di testo all'interno dell'InputElement
	 * @param placeholder
	 * @return
	 */
	public InputBuilder setPlaceholder(String placeholder) {
		input.placeholder = placeholder;
		return this;
	}
	
	/**
	 * Metodo setter per il tipo di InputElement
	 * @param type
	 * @return
	 */
	public InputBuilder setType(String type) {
		input.type = type;
		return this;
	}
	
	/**
	 * Metodo setter per il value dell'InputElement
	 * @param value
	 * @return
	 */
	public InputBuilder setValue(String value) {
		input.value = value;
		return this;
	}
	
	
	

	
	
	

}
