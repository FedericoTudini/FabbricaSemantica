package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.js.JSON;
import def.jquery.JQueryXHR;

public class TranslationAnnotation {
	
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) {
		
		HTMLFormElement form = TemplatePage.getForm("translationAnnotation");
		HTMLDivElement divWrapper = TemplatePage.getDivWrapper();
		$(divWrapper).append(form);
		HTMLDivElement Navbar = TemplatePage.getNavbar();
		HTMLDivElement divTitle = TemplatePage.getDivTitle("Translate the word with the help of the sentence");
		$(form).append(divTitle);
		HTMLDivElement divWordAndDescription = TemplatePage.getDivWordOrDescription();
		$(form).append(divWordAndDescription);
		HTMLDivElement divTextarea = TemplatePage.getDivTextarea();
		$(form).append(divTextarea);
		HTMLDivElement divButtons = TemplatePage.getDivButtons("translationAnnotation.jsp");
		$(form).append(divButtons);
		
//		<--------------------------------------------------------------------------------------------->			
		
		$.getJSON(REST_URL, "task=TRANSLATION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("description"); 
			String sID = json.$get("id"); 
			
			HTMLLabelElement word = TemplatePage.getWord(sWord);
			HTMLInputElement ID = TemplatePage.getHiddenWord();
			ID.value = sID;
			HTMLLabelElement description = TemplatePage.getDescription(sDescription);
			$(divWordAndDescription).append(word,ID,description);
			return null;
		});
		
//		<--------------------------------------------------------------------------------------------->	
		
		$("body").append(Navbar);
		$("body").append(divWrapper);
		$("body").css("overflow","hidden");
		$("body").css("height","100%");
		$("body").css("background-image","linear-gradient(to bottom right, #1d2c41, #395771)");
		
	}

}
