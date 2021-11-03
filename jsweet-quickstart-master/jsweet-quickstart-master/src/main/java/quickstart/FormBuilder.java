package quickstart;

import static def.dom.Globals.document;
import def.dom.HTMLFormElement;
import jsweet.util.StringTypes;

/**
 * Classe builder per i FormElement
 * @author Federico Tudini
 *
 */
public class FormBuilder extends HTMLBuilder<HTMLFormElement> {
	
	private HTMLFormElement form;
	
	public FormBuilder() {
		super(document.createElement(StringTypes.form));
		form = super.build();
		form.method = "POST";
	}
	
	/**
	 * Metodo setter per l'action della Form
	 * @param action
	 * @return
	 */
	public FormBuilder setAction(String action) {
		form.action = action;
		return this;
	}
	
	/**
	 * Metodo setter per il method della Form
	 * @param method
	 * @return
	 */
	public FormBuilder setMethod(String method) {
		form.method = method;
		return this;
	}
	
}
