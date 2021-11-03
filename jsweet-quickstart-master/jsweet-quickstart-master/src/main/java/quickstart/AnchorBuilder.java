package quickstart;

import def.dom.HTMLAnchorElement;
import jsweet.util.StringTypes;
import static def.dom.Globals.document;

/**
 * Classe builder per AnchorElement
 * @author Federico Tudini
 *
 */
public class AnchorBuilder extends HTMLBuilder<HTMLAnchorElement> {

	private HTMLAnchorElement anchor;
	
	public AnchorBuilder(String text, String href) {
		super(document.createElement(StringTypes.a));
		anchor = super.build();
		anchor.text = text;
		anchor.href = href;
	}

}
