package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class SenseValidation {
	
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) {
		
		HTMLFormElement form = TemplatePage.getForm("senseValidation");
		HTMLDivElement divWrapper = TemplatePage.getDivWrapper();
		$(divWrapper).append(form);
		HTMLDivElement Navbar = TemplatePage.getNavbar();
		HTMLDivElement divTitle = TemplatePage.getDivTitle("given a word and a sentence in which the word appears, check if the meaning of the word is correct");
		$(form).append(divTitle);
		HTMLDivElement divWordAndDescription = TemplatePage.getDivWordOrDescription();
		$(form).append(divWordAndDescription);
		String[] strings = new String[] {"Yes","No"};
		HTMLDivElement divRadio = TemplatePage.getDivRadio(true, "radio", strings);
		$(form).append(divRadio);
		HTMLDivElement divButtons = TemplatePage.getDivButtons("senseValidation.jsp");
		$(form).append(divButtons);
		
//		<---------------------------------------------------------------------------------------->
		
		$.getJSON(REST_URL, "task=SENSE_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("description"); 
			String sSense = json.$get("sense"); 
			String sID = json.$get("id"); 
			
			HTMLInputElement ID = TemplatePage.getHiddenWord();
			ID.value = sID;
			HTMLLabelElement word = TemplatePage.getWord(sWord);
			HTMLLabelElement description = TemplatePage.getDescription(sDescription);
			description.style.border = "none";
			HTMLLabelElement sense = TemplatePage.getDescription(sSense);
			sense.setAttribute("name", "sense");
			$(divWordAndDescription).append(word,ID,description,sense);
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
