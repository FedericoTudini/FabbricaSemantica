package quickstart;

import static def.jquery.Globals.$;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class DefinitionAnnotation {
	
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) {
		
		HTMLFormElement form = TemplatePage.getForm("definitionAnnotation");
		HTMLDivElement divWrapper = TemplatePage.getDivWrapper();
		$(divWrapper).append(form);
		HTMLDivElement Navbar = TemplatePage.getNavbar();
		HTMLDivElement divTitle = TemplatePage.getDivTitle("translate the word with the help of one of its hypernym");
		$(form).append(divTitle);
		HTMLDivElement divWordAndDescription = TemplatePage.getDivWordOrDescription();
		$(form).append(divWordAndDescription);
		HTMLDivElement divTextarea = TemplatePage.getDivTextarea();
		$(form).append(divTextarea);
		HTMLDivElement divButtons = TemplatePage.getDivButtons("definitionAnnotation.jsp");
		$(form).append(divButtons);
			
//		<---------------------------------------------------------------------------------------->
		
		$.getJSON(REST_URL, "task=DEFINITION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("hypernym"); 
			String sID = json.$get("id"); 
			HTMLLabelElement word = TemplatePage.getWord(sWord);
			HTMLInputElement ID = TemplatePage.getHiddenWord();
			ID.value = sID;
			HTMLLabelElement description = TemplatePage.getDescription(sDescription);
			$(divWordAndDescription).append(word,ID,description);
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
