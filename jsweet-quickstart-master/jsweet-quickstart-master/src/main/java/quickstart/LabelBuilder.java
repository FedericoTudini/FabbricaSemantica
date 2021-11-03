package quickstart;

import static def.dom.Globals.document;
import def.dom.HTMLLabelElement;
import jsweet.util.StringTypes;

/**
 * Classe builder per i LabelElement
 * @author FedericoTudini
 *
 */
public class LabelBuilder extends HTMLBuilder<HTMLLabelElement> {
	
	private HTMLLabelElement label;
	
	public LabelBuilder() {
		super(document.createElement(StringTypes.label));
		label = super.build();
	}
	
	/**
	 * Metodo setter per il contenuto di testo della label
	 * @param textContent
	 * @return
	 */
	public LabelBuilder setTextContent(String textContent) {
		label.textContent = textContent;
		return this;
	}
	
	
}
