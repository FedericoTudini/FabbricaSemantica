package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class TranslationValidation {
	
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) {
		
		HTMLFormElement form = TemplatePage.getForm("translationValidation");
		HTMLDivElement divWrapper = TemplatePage.getDivWrapper();
		$(divWrapper).append(form);
		HTMLDivElement Navbar = TemplatePage.getNavbar();
		HTMLDivElement divTitle = TemplatePage.getDivTitle("Choose the best translation for the word, with the help of the sentence");
		$(form).append(divTitle);
		HTMLDivElement wordDescription = TemplatePage.getDivWordOrDescription();
		$(form).append(wordDescription);

		
//		<---------------------------------------------------------------------------------------->
		
		$.getJSON(REST_URL, "task=TRANSLATION_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("description"); 
			String sID = json.$get("id");
			
			HTMLLabelElement word = TemplatePage.getWord(sWord);
			HTMLLabelElement description = TemplatePage.getDescription(sDescription);
			HTMLInputElement ID = TemplatePage.getHiddenWord();
			ID.value = sID;
			
			$(wordDescription).append(word,ID,description);
			String translations = json.$get("translations") + ",None of the previous";
			String[] strings = translations.toString().split(",");
			for(int k = 0; k < strings.length; k++) {
				strings[k] = strings[k].replace("##", ",");
			}
			HTMLDivElement divRadio = TemplatePage.getDivRadio(false, "radio", strings);
			$(form).append(divRadio);
			HTMLDivElement divButtons = TemplatePage.getDivButtons("translationValidation.jsp");
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
