package it.uniroma1.fabbricasemantica.data;

/**
 * Questa interfaccia rappresenta il metodo usato per ottenere i dati necessari ai vari task per funzionare.
 * Il tipo di ritorno T e' generico in quanto a seconda del target della nostra applicazione possiamo restituire formati diversi
 * (e.g. una applicazione Client-Server o una applicazione Java GUI potranno gestire i dati in maniera diversa).
 * 
 *  nel caso si decidesse di implementare la propria versione per ottenere i dati, bastera' implementare questa interfaccia
 * 		e definire la logica al suo interno nella maniera che si ritiene piu' opportuna. 
 * */
public interface DataProvider<T> {
	
	/**
	 * @param task : Un oggetto di tipo Task
	 * */
	T getData(Task task);

}
