package quickstart;

import static def.jquery.Globals.$;
import static jsweet.util.StringTypes.mouseleave;
import static jsweet.util.StringTypes.click;
import static jsweet.util.StringTypes.mouseover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class MyAnnotation {
	
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) {
		
		HTMLFormElement form = TemplatePage.getForm("myAnnotation");
		HTMLDivElement divWrapper = TemplatePage.getDivWrapper();
		$(divWrapper).append(form);
		HTMLDivElement Navbar = TemplatePage.getNavbar();
		HTMLDivElement divTitle = TemplatePage.getDivTitle("rearrange the words to form the correct sentence");
		$(form).append(divTitle);
		HTMLDivElement divWordAndDescription = TemplatePage.getDivWordOrDescription();
		$(form).append(divWordAndDescription);	
		
		HTMLDivElement divInputs = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin","0% 5% 1% 5%")
				.setCss("margin-top", "15px")
				.build();	
		
//		<--------------------------------------------------------------------------------------------->		
		
		$.getJSON(REST_URL, "task=MY_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String phrase = json.$get("description"); 
			String sID = json.$get("id"); 
			
			HTMLInputElement ID = TemplatePage.getHiddenWord();
			ID.value = sID;
			
			HTMLInputElement assembled = TemplatePage.getHiddenWord();
			assembled.setAttribute("name", "assembled");
			assembled.value = "";
			
			HTMLLabelElement word = TemplatePage.getWord(sWord);
			HTMLLabelElement description = TemplatePage.getDescription("");
			$(divWordAndDescription).append(word,ID,description,assembled);
			
			List<String> ls = Arrays.asList(phrase.split(" "));
			
			List<String> ris = new ArrayList<>();
			
			for(int i = ls.size()-1; i != -1; i--) {
				int n = (int)Math.round(Math.random()*i);
				ris.add(ls.get(n));
				ls.remove(n);
			}
			
			for(String s : ris) {
				HTMLInputElement splittedword = new InputBuilder()
						.setType("button")
						.setValue(s)
						.setCss("color", "white")
						.setClassName("btn btn-primary")
						.setCss("border-radius", "15px 15px 15px 15px")
						.setCss("background","linear-gradient(to bottom right, rgba(0,0,69,0.5), rgba(57,94,133,0.5))")
						.setCss("border", "1px groove rgba(255,255,255,0.3)")
						.setCss("text-align", "center")
						.setCss("min-width", "90px")
						.setCss("width", "auto")
						.setCss("height", "25px")
						.setCss("font-family", "Gruppo")
						.setCss("font-style", "italic")
						.setCss("font-size", "14px")
						.setCss("margin", "3px 3px 3px 3px")
						.setCss("padding", "0px 5px 0px 5px")
						.build();
				
				splittedword.addEventListener(click, event -> {
					switch(splittedword.className) {
					case "btn btn-primary":
						splittedword.className = "btn btn-primary active";
						description.textContent += " " + splittedword.value;
						assembled.value += " " + splittedword.value;
						splittedword.style.opacity = "0.3";
						break;
					case "btn btn-primary active":
						description.textContent = description.textContent.replace(" "+splittedword.value, "");
						assembled.value = assembled.value.replace(" "+splittedword.value, "");
						splittedword.className = "btn btn-primary";
						splittedword.style.opacity = "1";
						break;
					}
					return null;
				});
				
				splittedword.addEventListener(mouseover, event -> {
					splittedword.style.transform = "scale(1.1,1.2)";
					return null;
				});
				splittedword.addEventListener(mouseleave, event -> {
					splittedword.style.transform = "none";
					return null;
				});
				
				$(divInputs).append(splittedword);
				
			}
			
			return null;
		});
		
		$(form).append(divInputs);
		
		HTMLDivElement divButtons = TemplatePage.getDivButtons("myAnnotation.jsp");
		$(form).append(divButtons);
		
//		<--------------------------------------------------------------------------------------------->			
		
		$("body").append(Navbar);
		$("body").append(divWrapper);
		$("body").css("overflow","hidden");
		$("body").css("height","100%");
		$("body").css("background-image","linear-gradient(to bottom right, #1d2c41, #395771)");
	}

}
