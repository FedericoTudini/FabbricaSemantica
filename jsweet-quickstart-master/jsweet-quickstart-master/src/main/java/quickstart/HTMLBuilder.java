package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLElement;

/**
 * Superclasse dei builder di elementi HTML e builder generico per ogni tipo di HTML
 * @author Federico Tudini
 *
 */
public class HTMLBuilder<E extends HTMLElement> {
	
	private E element;
	
	public HTMLBuilder(E element) {
		this.element = (E)element;
	}
	
	/**
	 * Metodo setter per il className
	 * @param className
	 * @return
	 */
	public HTMLBuilder<E> setClassName(String className) {
		element.className = className;
		return this;
	}
	
	/**
	 * Metodo setter per gli attributi HTML
	 * @param name
	 * @param value
	 * @return
	 */
	public HTMLBuilder<E> setAttribute(String name, String value){
		element.setAttribute(name,value);
		return this;
	}
	
	/**
	 * Metodo per settare gli stili CSS
	 * @param type
	 * @param value
	 * @return
	 */
	public HTMLBuilder<E> setCss(String type, String value) {
		$(element).css(type,value);
		return this;
	}
	
	/**
	 * Metodo build che restituisce l'elemento
	 * @return
	 */
	public E build() {
		return element;
	}

}
