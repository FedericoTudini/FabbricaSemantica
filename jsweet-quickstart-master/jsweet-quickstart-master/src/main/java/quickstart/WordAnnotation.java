package quickstart;

import static def.jquery.Globals.$;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class WordAnnotation {
	
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) {
		
		HTMLFormElement form = TemplatePage.getForm("wordAnnotation");
		HTMLDivElement divWrapper = TemplatePage.getDivWrapper();
		$(divWrapper).append(form);
		HTMLDivElement Navbar = TemplatePage.getNavbar();
		HTMLDivElement divTitle = TemplatePage.getDivTitle("Translate the word described in this the sentence");
		$(form).append(divTitle);
		HTMLDivElement divDescription = TemplatePage.getDivWordOrDescription();
		$(form).append(divDescription);
		HTMLDivElement divTextarea = TemplatePage.getDivTextarea();
		$(form).append(divTextarea);
		HTMLDivElement divButtons = TemplatePage.getDivButtons("wordAnnotation.jsp");
		$(form).append(divButtons);

//		<---------------------------------------------------------------------------------------->
		
		$.getJSON(REST_URL, "task=WORD_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sDescription = json.$get("description"); 
			String sID = json.$get("id"); 
			
			HTMLInputElement ID = TemplatePage.getHiddenWord();
			ID.value = sID;
			HTMLLabelElement description = TemplatePage.getDescription(sDescription);
			$(divDescription).append(description,ID);
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
