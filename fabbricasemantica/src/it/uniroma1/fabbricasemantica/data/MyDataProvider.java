package it.uniroma1.fabbricasemantica.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import it.uniroma1.fabbricasemantica.WordNet.*;

/**
 * La classe MyDataProvider si occupa di ottenere gli esempi da un'istanza di WordNet,
 * posta come campo statico e con un singleton pattern che ne garantisce l'unicità.
 * Ha inoltre un campo "traducibili" che rappresenta la lista di Synset che hanno una 
 * traduzione possibile in ItalWordNet, versione italiana di WordNet che ha gli stessi ID dei Synset
 * della versione 3.0 di WordNet (utilizzata in questo contesto). 
 * @author Federico Tudini
 * */
public class MyDataProvider implements DataProvider<String> {
	
	private static final WordNet wordnet = WordNet.getInstance("3.0");
	private static final List<Synset> traducibili = wordnet.stream().filter(s -> s.getTraduzioni()!=null).collect(Collectors.toList());
	private static final Random random = new Random();
	
	/**
	 * Il metodo getData si occupa di fornire ai task i dati necessari in maniera casuale.
	 * A seconda del Task che viene passato come parametro il metodo parte o dalla lista "traducibili"
	 * o dall'intero insieme di Synset di WordNet.
	 * Inoltre, se necessario, la struttura dati di partenza viene filtrata con un dovuto Predicate
	 * per evitare che venga scelto un Synset che non ha abbastanza informazioni per quel Task, o semplicemente
	 * per semplificare alcuni Task che altrimenti risulterebbero troppo difficili da svolgere.
	 * Ritorna una stringa JSON che verrà poi presa nel lato front-end per creare gli elementi.
	 * @param task : oggetto di tipo Task che definisce la pagina per cui si necessitano le parole
	 * @return s : stringa JSON
	 */
	@Override 
	public String getData(Task task) {
		if (task == StandardTask.TRANSLATION_ANNOTATION) {
			
			Synset s = traducibili.get(random.nextInt(traducibili.size()));
			Collections.shuffle(s.getSynonyms());
			String word = s.getSynonyms().get(0).replace("_", " ");
			String description = s.getGloss();
			String id = s.getID();
			
			return "{\"word\" : \"" + word +
					"\" , " + "\"description\" : \"" + description +
					"\" , " + "\"id\" : \"" + id +
					"\"" + "}";
		}else if (task == StandardTask.WORD_ANNOTATION) {
			
			List<Synset> ls = traducibili.stream()
					.filter(s -> s.getGloss().length() <= 35)
					.collect(Collectors.toList());
			Synset s = ls.get(random.nextInt(ls.size()));
			String description = s.getGloss();
			String id = s.getID();

			return "{\"description\" : \"" + description +
					"\" , " + "\"id\" : \"" + id +
					"\"" + "}";
		}else if (task == StandardTask.DEFINITION_ANNOTATION) {
			Collections.shuffle(traducibili);
			for(Synset s : traducibili) {
				List<Synset> related = wordnet.getRelatedSynsets(s, "@");
				if(related.size() != 0) {
					Collections.shuffle(s.getSynonyms());
					String word = s.getSynonyms().get(0).replace("_", " ");
					String hypernym = related.get(0).getSynonyms().get(0);
					String id = s.getID();
					return "{\"word\" : \"" + word +
							"\" , " + "\"hypernym\" : \"" + hypernym +
							"\" , " + "\"id\" : \"" + id +
							"\"" + "}";
				}
			}		
		}else if (task == StandardTask.SENSE_ANNOTATION) {
			List<Synset> ls = traducibili.stream()
					.filter(s -> s.getExamples().size() != 0)
					.collect(Collectors.toList());
			Synset s = ls.get(random.nextInt(ls.size()));
			Collections.shuffle(s.getSynonyms());
			String word = s.getSynonyms().get(0).replace("_", " ");
			String description = s.getExamples().get(0);
			List<Synset> lsSamePos = ls.stream().filter(syn -> syn.getPOS().equals(s.getPOS())).collect(Collectors.toList());
			List<String> glosse = new ArrayList<>();
			glosse.add(s.getGloss().replaceAll(",","##"));
			glosse.add(lsSamePos.get(random.nextInt(lsSamePos.size())).getGloss().replaceAll(",","##"));
			glosse.add(lsSamePos.get(random.nextInt(lsSamePos.size())).getGloss().replaceAll(",","##"));
			glosse.add(lsSamePos.get(random.nextInt(lsSamePos.size())).getGloss().replaceAll(",","##"));
			Collections.shuffle(glosse);
			String id = s.getID();
			
			return "{\"word\" : \"" + word +
					"\" , " + "\"description\" : \"" + description + 
					"\" , " + "\"id\" : \"" + id + 
					"\" , " + "\"senses\": [\"" + glosse.get(0) + "\", \"" + glosse.get(1) + "\", \"" + glosse.get(2) + "\", \"" + glosse.get(3) + "\"]" + 
					"}";
		}else if (task == StandardTask.TRANSLATION_VALIDATION) {
			
			List<Synset> ls = traducibili.stream()
					.filter(s -> s.getGlossaItaliana() != null)
					.collect(Collectors.toList());
			Synset s = ls.get(random.nextInt(ls.size()));
			Collections.shuffle(s.getSynonyms());
			String word = s.getSynonyms().get(0).replace("_", " ");
			String description = s.getGloss();
			List<String> glosse = new ArrayList<>();
			List<Synset> lsSamePos = ls.stream().filter(syn -> syn.getPOS().equals(s.getPOS())).collect(Collectors.toList());
			glosse.add(s.getGlossaItaliana().replaceAll(",","##"));
			glosse.add(lsSamePos.get(random.nextInt(lsSamePos.size())).getGlossaItaliana().replaceAll(",","##"));
			glosse.add(lsSamePos.get(random.nextInt(lsSamePos.size())).getGlossaItaliana().replaceAll(",","##"));
			Collections.shuffle(glosse);
			String id = s.getID();
			return "{\"word\" : \"" + word +
					"\" , " + "\"description\" : \"" + description + 
					"\" , " + "\"id\" : \"" + id + 
					"\" , " + "\"translations\": [\"" + glosse.get(0) + "\", \"" + glosse.get(1) + "\", \"" + glosse.get(2) + "\"]" + 
					"}";
		}else if (task == StandardTask.SENSE_VALIDATION) {
			
			List<Synset> ls = wordnet.stream()
					.filter(s -> s.getExamples().size() != 0)
					.collect(Collectors.toList());
			Synset s = ls.get(random.nextInt(ls.size()));
			Collections.shuffle(s.getSynonyms());
			String word = s.getSynonyms().get(0).replace("_", " ");
			String description = s.getExamples().get(0);
			List<String> glosse = new ArrayList<>();
			List<Synset> lsSamePos = ls.stream().filter(syn -> syn.getPOS().equals(s.getPOS())).collect(Collectors.toList());
			glosse.add(s.getGloss());
			glosse.add(lsSamePos.get(random.nextInt(lsSamePos.size())).getGloss());
			Collections.shuffle(glosse);
			String id = s.getID();
			return "{\"word\" : \"" + word +
					"\" , " + "\"description\" : \"" + description +
					"\" , " + "\"id\" : \"" + id +
					"\" , " + "\"sense\" : \"" + glosse.get(random.nextInt(1)) +
					"\"" +
					"}";
		}else if (task == StandardTask.MY_ANNOTATION) {

			List<Synset> ls = wordnet.stream()
					.filter(s -> s.getGloss().split(" ").length <= 8 && s.getGloss().split(" ").length >= 4)
					.collect(Collectors.toList());
			Synset s = ls.get(random.nextInt(ls.size()));
			Collections.shuffle(s.getSynonyms());
			String word = s.getSynonyms().get(0).replace("_", " ");
			String description = s.getGloss().substring(0, 1).toUpperCase() + s.getGloss().substring(1)+".";
			String id = s.getID();
			return "{\"word\" : \"" + word +
					"\" , " + "\"description\" : \"" + description +
					"\" , " + "\"id\" : \"" + id +
					"\"" + "}";
		}
		return null; 
	}
	

}
