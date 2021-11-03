package quickstart;

import static def.jquery.Globals.$;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class SenseAnnotation {
	
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) {
		
		HTMLFormElement form = TemplatePage.getForm("senseAnnotation");
		HTMLDivElement divWrapper = TemplatePage.getDivWrapper();
		$(divWrapper).append(form);
		HTMLDivElement Navbar = TemplatePage.getNavbar();
		HTMLDivElement divTitle = TemplatePage.getDivTitle("given a word and a sentence in which the word appears, select the correct meaning of the word");
		$(form).append(divTitle);
		HTMLDivElement divWordAndDescription = TemplatePage.getDivWordOrDescription();
		$(form).append(divWordAndDescription);
		
		
//		<---------------------------------------------------------------------------------------->
		
		$.getJSON(REST_URL, "task=SENSE_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("description"); 
			String sID = json.$get("id"); 
			
			HTMLInputElement ID = TemplatePage.getHiddenWord();
			ID.value = sID;
			HTMLLabelElement word = TemplatePage.getWord(sWord);
			HTMLLabelElement description = TemplatePage.getDescription(sDescription);
			$(divWordAndDescription).append(word,ID,description);
			String senses = json.$get("senses");
			String[] strings = senses.toString().split(",");
			for(int k = 0; k < strings.length; k++) {
				strings[k] = strings[k].replace("##", ",");
			}
			HTMLDivElement divRadio = TemplatePage.getDivRadio(false, "radio", strings);
			$(form).append(divRadio);
			HTMLDivElement divButtons = TemplatePage.getDivButtons("senseAnnotation.jsp");
			$(form).append(divButtons);
			return null;
		});

//		<---------------------------------------------------------------------------------------->		
		
		$("body").append(Navbar);
		$("body").append(divWrapper);
		$("body").css("overflow","hidden");
		$("body").css("height","100%");
		$("body").css("background-image","linear-gradient(to bottom right, #1d2c41, #395771)");
		
	}

}
