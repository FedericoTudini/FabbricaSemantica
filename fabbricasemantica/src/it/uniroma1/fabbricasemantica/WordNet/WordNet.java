package it.uniroma1.fabbricasemantica.WordNet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * La classe WordNet crea(o ritorna) l'oggetto WordNet alla chiamata del metodo getInstance
 * leggendo dalla cartella relativa alla versione i file "data" e operando sulle righe dei file 
 * per riorganizzare la stringa.
 * In seguito crea per ogni riga un oggetto Synset e lo aggiunge ad un HashSet di Synset.
 * @author Federico Tudini
 *
 */

public class WordNet implements Iterable<Synset> {
	
	//Campi
	private static final String PERCORSO = "." + File.separator + "wordnet-releases"+File.separator+"releases"+File.separator;
	
	private static List<WordNet> instances = new ArrayList<WordNet>();
	
	private String versione;
	
	private HashSet<Synset> set;
	
	/**
	 * 
	 * Costruttore di WordNet con accesso privato in modo da poter essere richiamato solo all'interno del 
	 * metodo getInstance
	 * @param versione
	 */
	private WordNet(String versione) {
		
		this.versione = versione;
		
		this.set = new HashSet<Synset>();
		
		String path = PERCORSO +"WordNet-" + versione + File.separator + "dict" + File.separator; 
		
		HashMap<String, List<String>> traduzioni = new HashMap<>();
		HashMap<String, String> glosseItaliane = new HashMap<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(PERCORSO + "wn-data-ita.tab"+File.separator)))
		{
			while(br.ready()) {
				//Creazione delle mappe delle glosse italiane e delle traduzioni italiane
				//entrambe con l'ID del Synset come chiave
				String line = br.readLine();
				if(!line.startsWith("#")) {
					String[] parti = line.split("\t");
					String offset = parti[0].replace("-", "");
				
					List<String> ls = new ArrayList<String>();
					ls.add(parti[2]);
					
					if (parti[1].equals("ita:lemma")) {
						if (traduzioni.containsKey(offset)) traduzioni.get(offset).addAll(ls);
						else traduzioni.put(offset, ls);
					}
					else if(parti[1].contains("ita:def")) {
						if(!glosseItaliane.containsKey(offset)) glosseItaliane.put(offset, parti[3]); 
					}
				}
				
								
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(File f : new File(path).listFiles()) {
			//Controllo per file interessati
			if(f.getName().contains("data")) {
				//Lettura file per riga(Synset)
				try(BufferedReader br = new BufferedReader(new FileReader(f)))
				{
					while(br.ready())
					{
						String s = br.readLine();
						if(!s.startsWith("  ")) {
							//Split e divisione in array delle parti del synset
							String[] parts = s.split("\\|");
							String part1 = parts[0];
							String part2 = parts[1].trim();
							String[] elements = part1.split(" ");
				
							//Gestione offset, nparole, lista parole
							String offset = elements[0];
							String pos = elements[2];
							int nparole = Integer.parseInt(elements[3], 16);
							List<String> parole = new ArrayList<String>();
							int index=0;
							for(int i = 0; i < nparole; i++) {
								index=i*2+4;
								parole.add(elements[index]);
							}
							
							//Gestione relazioni
							int NRelation = Integer.parseInt(elements[index+2]);
							List<Relation> relazioni = new ArrayList<Relation>();
							int start = index+3;
							for(int i = 0; i < NRelation; i++) {
								relazioni.add(new Relation(elements[start],elements[start+1],elements[start+2]));
								start+=4;
							}
							
							
							//Gestione glossa ed esempi
							int indice = part2.indexOf("\"");
							String gloss = "";
							List<String> esempi = new ArrayList<>();
							
							if(indice == -1) gloss = part2.trim();
							else {
								gloss = indice != 0 ? part2.substring(0,indice-1) : null;
								if(gloss != null && gloss.endsWith(";")) gloss = gloss.trim().substring(0,gloss.length()-1);
								String[] array = part2.substring(indice).trim().split(";");
								for(String str : array) {
									str = str.trim();
									if(str.startsWith("\"")) {
										str = str.substring(1);
									}
									if(str.endsWith("\"")) {
										str = str.substring(0,str.length()-1);
									}
									esempi.add(str);
								}
							}
							
							//Creazione Synset e archiviazione in struttura dati
							Synset syn=new Synset(offset, nparole, pos, NRelation, parole, relazioni, gloss, esempi, traduzioni.get(offset+pos),glosseItaliane.get(offset+pos));
							set.add(syn);
							
						}
					}
				}
				//Gestione eccezione
				catch(IOException e)
				{
					e.printStackTrace();
				}
				
			}
			
		}
			
	}
	/**
	 * Metodo getInstance che presa in input una stringa identificativa della versione
	 * controlla che l'oggetto WordNet di quella versione sia gi� stato instanziato e in quel caso lo ritorna.
	 * Se l'oggetto non � stato instanziato lo crea.
	 * @param versione
	 * @return WordNet(versione)
	 */
	public static WordNet getInstance(String versione) {
		File f = new File("wordnet-releases"+File.separator+"releases");
		for(File w : f.listFiles()) {
			if(w.getName().contains("WordNet-"+versione)) {
				for(WordNet wn : instances) {
					if(wn.versione.equals(versione)) {
						return wn;
					}
				}	
				WordNet obj = new WordNet(versione);
				instances.add(obj);
				return obj;
			}
		}
		return null;
	}
	
	public Iterator<Synset> iterator() {
		return set.iterator();
	};
	
	/**
	 * Getter per la stringa versione
	 * @return versione
	 */
	public String getVersion() {
		return versione;
	}
	
	/**
	 * Getter per il Synset a partire dall'ID
	 * @return Synset
	 */
	public Synset getSynsetFromID(String s) {
		for(Synset syn : set) {
			if(syn.getID().equals(s)) return syn;
		}
		return null;
	}
	
	public Stream<Synset> stream() {
		return set.stream();
	}
	
	/**
	 * Getter per i Synset 
	 * @param lemma
	 * @param p
	 * @return ls : Lista di Synset
	 */
	public List<Synset> getSynsets(String lemma, Enum<POS> p) {
		List<Synset> ls = set.stream()
							.filter(s -> s.getPOS() == p )
							.filter(s -> s.getSynonyms().contains(lemma))
							.collect(Collectors.toList());
		return ls;
	}
	
	
	public List<Synset> getSynsets(String lemma) {
		List<Synset> listaSyn = new ArrayList<Synset>();
		for(Synset syn : set) {
			for(String parola : syn.getSynonyms()) {
				if(lemma.equals(parola) || lemma.equals(parola.substring(0, 1).toUpperCase() + parola.substring(1).toLowerCase())) {
					listaSyn.add(syn);
				}
			}
		}
		return listaSyn;
	}
	
	/**
	 * Getter per i Synset in relazione con il Synset sorgente
	 * @param src
	 * @param s
	 * @return related
	 */
	public List<Synset> getRelatedSynsets(Synset src, String s) {
		List<Synset> related = new ArrayList<Synset>();
		for(Relation r : src.getRelations()) {
			if(r.getType().equals(s)) {
				related.add(getSynsetFromID(r.getOffset()+r.getPos()));
			}
		}
		return related;
		
	}
	
	/**
	 *Getter per la struttura dati contenente i Synset
	 * @return set
	 */
	public HashSet<Synset> getSet() {
		return set;
	}
}
			
