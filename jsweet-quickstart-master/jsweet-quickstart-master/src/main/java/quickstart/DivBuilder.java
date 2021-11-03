package quickstart;

import static def.dom.Globals.document;
import def.dom.HTMLDivElement;
import jsweet.util.StringTypes;

/**
 * Classe builder per i DivElement
 * @author FedericoTudini
 *
 */
public class DivBuilder extends HTMLBuilder<HTMLDivElement>{
	
	private HTMLDivElement div;
	
	public DivBuilder() {
		super(document.createElement(StringTypes.div));
		div = super.build();
	}
	
	
	
	
}
