package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import static jsweet.util.StringTypes.mouseleave;
import static jsweet.util.StringTypes.mouseover;

import java.util.Arrays;
import java.util.List;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLOptionElement;
import def.dom.HTMLSelectElement;
import def.dom.HTMLTextAreaElement;
import jsweet.util.StringTypes;

/**
 * Classe con metodi getter statici che forniscono elementi già settati per 
 * le pagine HTML
 * @author Federico Tudini
 *
 */
public class TemplatePage {
	
	public static HTMLFormElement getForm(String page) {
		
		HTMLFormElement form = new FormBuilder()
				.setAction(page + ".jsp")
				.setAttribute("id", "form")
				.setCss("width","460px")
				.setCss("height", "auto")
				.setCss("text-align", "center")
				.setCss("border", "1px groove rgba(255,255,255,0.1)")
				.setCss("border-radius", "10px 10px 10px 10px")
				.setCss("background", "linear-gradient(rgba(0,0,0,0.1), rgba(97,97,97,0.1)")
				.setCss("margin", "0px 0px 5% 0px")
				.build();
		return form;
		
	}
	
	public static HTMLDivElement getDivWrapper() {
		
		HTMLDivElement divWrapper = new DivBuilder()
				.setCss("width", "100%")
				.setCss("height", "100%")
				.setCss("display", "flex")
				.setCss("justify-content", "center")
				.setCss("flex-direction", "column")
				.setCss("align-items", "center")
				.build();
		return divWrapper;
		
	}
	
	public static HTMLDivElement getNavbar() {
		
		HTMLDivElement Navbar = new DivBuilder()
				.setClassName("navbar")
				.setCss("height", "50px")
				.setCss("background", "linear-gradient(rgba(229,45,39,1), rgba(179,18,23,1)")
				.setCss("padding","0px 80px")
				.setCss("border-bottom", "2px groove rgba(255,255,255,1)")
				.build();
		
		HTMLDivElement divNavbarHeader = new DivBuilder()
				.setClassName("navbar-header")
				.setCss("height", "50px")
				.setCss("width", "auto")
				.setCss("padding","0px 0px")
				.setCss("float", "left")
				.build();
		
		
		HTMLAnchorElement navLabel = new HTMLBuilder<>(document.createElement(StringTypes.a))
				.setAttribute("type","nav-item")
				.setClassName("nav-link disabled")
				.setCss("color", "white")
				.setCss("font-weight", "bold")
				.setCss("font-size", "20px")
				.setCss("font-family", "Barlow Condensed")
				.setCss("padding","10px 5px")
				.setCss("margin","0px 0px 0px 0px")
				.build();
		navLabel.text = "WELCOME TO FABBRICA SEMANTICA!";
		
		
		$(divNavbarHeader).append(navLabel);
		
		HTMLAnchorElement linkHome = new AnchorBuilder("HOME","Home.html")
				.setAttribute("type","nav-item")
				.setClassName("nav-link")
				.setCss("color", "white")
				.setCss("font-size", "20px")
				.setCss("font-family", "Barlow Condensed")
				.setCss("padding","10px 20px")
				.build();
		
		$(Navbar).append(linkHome);
		
		HTMLAnchorElement linkLogout = new AnchorBuilder("LOGOUT","Login.html")
				.setAttribute("type","nav-item")
				.setClassName("nav-link")
				.setCss("color", "white")
				.setCss("font-size", "20px")
				.setCss("font-family", "Barlow Condensed")
				.setCss("padding","10px 20px")
				.build();
		
		$(Navbar).append(divNavbarHeader);
		$(Navbar).append(linkLogout);
		
		linkHome.addEventListener(mouseover, (event) -> {
			linkHome.style.background = "linear-gradient(rgba(179,18,23,1), rgba(229,45,39,1)";
			return null;
		});
		linkHome.addEventListener(mouseleave, (event) -> {
			linkHome.style.background = "none";
			return null;
		});
		
		linkLogout.addEventListener(mouseover, (event) -> {
			linkLogout.style.background = "linear-gradient(rgba(179,18,23,1), rgba(229,45,39,1)";
			return null;
		});
		linkLogout.addEventListener(mouseleave, (event) -> {
			linkLogout.style.background = "none";
			return null;
		});
		
		return Navbar;
		
	}
	
	public static HTMLDivElement getDivButtons(String href) {
		
		HTMLInputElement buttonNext = new InputBuilder()
				.setValue("NEXT")
				.setType("submit")
				.setClassName("btn btn-primary")
				.setCss("background", "linear-gradient(rgba(229,45,39,1), rgba(179,18,23,1)")
				.setCss("float", "right")
				.setAttribute("name", "buttonNext")
				.setAttribute("href", href)
				.setCss("width", "180px")
				.setCss("border", "1px groove rgba(255,255,255,0.2)")
				.setCss("border-radius", "10px 10px 10px 10px")
				.build();
		
		HTMLInputElement buttonSkip = new InputBuilder()
				.setValue("SKIP")
				.setType("submit")
				.setClassName("btn btn-primary")
				.setAttribute("name", "buttonSkip")
				.setCss("background", "linear-gradient(rgba(229,45,39,1), rgba(179,18,23,1)")
				.setCss("float", "left")
				.setAttribute("href", href)
				.setCss("border-radius", "10px 10px 10px 10px")
				.setCss("border", "1px groove rgba(255,255,255,0.2)")
				.setCss("width", "180px")
				.build();
		
		HTMLDivElement divButtons = new DivBuilder()
				.setClassName("form-group form-input-group")
				.setCss("height", "38px")
				.setCss("margin-right", "5%")
				.setCss("margin-left", "5%")
				.setCss("margin-top", "15px")
				.setCss("margin-bottom", "15px")
				.build();
		
		buttonSkip.addEventListener(mouseover, event -> {
			buttonSkip.style.transform = "scale(1.05,1.1)";
			return null;
		});
		
		buttonSkip.addEventListener(mouseleave, event -> {
			buttonSkip.style.transform = "none";
			return null;
		});
		
		buttonNext.addEventListener(mouseover, event -> {
			buttonNext.style.transform = "scale(1.05,1.1)";
			return null;
		});
		
		buttonNext.addEventListener(mouseleave, event -> {
			buttonNext.style.transform = "none";
			return null;
		});
		
		$(divButtons).append(buttonSkip);
		$(divButtons).append(buttonNext);
		
		return divButtons;
	}
	
	public static HTMLDivElement getDivTextarea() {
		
		HTMLTextAreaElement textarea = new HTMLBuilder<>(document.createElement(StringTypes.textarea))
				.setClassName("form-control")
				.setCss("background", "none")
				.setAttribute("name", "textArea")
				.setCss("border", "1px groove rgba(255,255,255,0.5)")
				.setCss("border-radius", "10px 10px 10px 10px")
				.setAttribute("placeholder", "Enter your translation here:")
				.setCss("color", "#fff")
				.setCss("font-family", "Barlow Condensed" )
				.setCss("font-size", "20px")
				.setCss("min-height", "130px")
				.setCss("max-height", "130px")
				.build();
		
		HTMLDivElement divTextarea = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin","1% 5% 1% 5%")
				.build();
		$(divTextarea).append(textarea);
		
		return divTextarea;
	}
	
	public static HTMLDivElement getDivTitle(String textContent) {
		
		HTMLLabelElement title = new LabelBuilder()
				.setTextContent(textContent)
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Barlow Condensed")
				.setCss("font-size", "18px")
				.setCss("text-transform", "uppercase")
				.setClassName("form-control-plaintext")
				.build();
		
		HTMLDivElement divTitle = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin","1% 5% 1% 5%")
				.setCss("margin-top", "15px")
				.build();	
		
		$(divTitle).append(title);
		
		return divTitle;
	}
	
	public static HTMLLabelElement getWord(String word) {
		
		HTMLLabelElement wordLabel = new LabelBuilder()
				.setTextContent(word)
				.setAttribute("name", "word")
				.setAttribute("value", word)
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Barlow Condensed")
				.setCss("font-size", "26px")
				.setCss("font-weight", "bold")
				.setCss("text-transform", "uppercase")
				.setClassName("form-control-plaintext")
				.setCss("text-decoration", "underline")
				.setCss("padding", "0px 10px 0px 10px")
				.build();
		
		return wordLabel;
		
	}

	public static HTMLInputElement getHiddenWord() {
		
		HTMLInputElement hiddenWord = new InputBuilder()
				.setType("hidden")
				.setAttribute("name", "synsetID")
				.build();
		
		return hiddenWord;
		
	}
	
	public static HTMLInputElement getHiddenDescription(String description) {
			
			HTMLInputElement hiddenWord = new InputBuilder()
					.setType("hidden")
					.setAttribute("name", "hDescription")
					.build();
			
			return hiddenWord;
			
		}
	
	public static HTMLLabelElement getDescription(String description) {
		HTMLLabelElement descriptionLabel = new LabelBuilder()
				.setTextContent(description)
				.setAttribute("name", "description")
				.setAttribute("value", description)
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Gruppo")
				.setCss("font-style", "italic")
				.setCss("font-size", "16px")
				.setClassName("form-control-plaintext")
				.setCss("border", "1px groove rgba(255,255,255,0.1)")
				.setCss("border-radius", "15px 15px 15px 15px")
				.setCss("padding", "6px 10px 6px 10px")
				.build();
		
		return descriptionLabel;
	}
	
	public static HTMLDivElement getDivWordOrDescription() {
		
		HTMLDivElement divWordOrDescription = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin","1% 5% 3% 5%")
				.setCss("border", "1px groove rgba(255,255,255,0.1)")
				.setCss("border-radius", "15px 15px 15px 15px")
				.build();
		
		return divWordOrDescription;
		
		
	} 
	
	public static HTMLDivElement getDivRadio(boolean inline, String name, String[] strings) {
		
		HTMLDivElement divRadioWrapper = new DivBuilder()
				.setClassName("container")
				.setCss("margin-left", "5%")
				.setCss("margin-right", "5%")
				.setCss("margin-bottom", "0px")
				.setCss("padding", "0px 0px 0px 0px")
				.setCss("width", "90%")
				.setCss("text-align", "center")
				.build();
		
		List<String> ls = Arrays.asList(strings);
		
		for(String s : ls) {
			
			HTMLInputElement radio = new InputBuilder()
					.setType("radio")
					.setClassName("custom-control-input")
					.setAttribute("name", name)
					.setAttribute("id", name + " " + s)
					.setAttribute("value", s)
					.build();
			
			HTMLLabelElement label = new LabelBuilder()
					.setTextContent(s)
					.setClassName("custom-control-label")
					.setCss("color", "rgb(255,255,255)")
					.setCss("font-family", "Gruppo")
					.setCss("font-style", "italic")
					.setCss("font-size", "16px")
					.build();
			label.htmlFor = name + " " + s;
			
			HTMLDivElement divRadio = new DivBuilder()
					.setCss("margin", "0px 10px 0px 0px")
					.build();
			if(!inline) {
				divRadio.className = "custom-control custom-radio custom-control-block";
				divRadio.style.justifyContent = "center";
			}
			else divRadio.className = "custom-control custom-radio custom-control-inline" ;
			
			$(divRadio).append(radio,label);
			
			$(divRadioWrapper).append(divRadio);
		}
		
		if(!inline) {
			divRadioWrapper.style.textAlign = "left";
		}
		
		return divRadioWrapper;
		
	}
	
	public static HTMLDivElement getDivProgressBar(HTMLDivElement progressbar) {
		HTMLDivElement divProgress = new DivBuilder()
				.setClassName("progress")
				.setCss("margin-bottom", "25px")
				.build();
		
		$(divProgress).append(progressbar);
		
		return divProgress;
		
	}
	
	public static HTMLDivElement getProgressBar() {
		
		HTMLDivElement divProgress = new DivBuilder()
				.setClassName("progress")
				.build();
		
		HTMLDivElement progressbar = new DivBuilder()
				.setClassName("progress-bar progress-bar-danger")
				.setAttribute("role", "progressbar")
				.setCss("width", "460px")
				.setAttribute("aria-valuemin","1")
				.setAttribute("aria-valuemax","10")
				.setAttribute("aria-valuenow","5")
				.build();
		
		
		$(divProgress).append(progressbar);
		
		return progressbar;
	}

	public static HTMLDivElement getDivSelect(String name, String ...strings) {
		
		HTMLDivElement divSelect = new DivBuilder()
				.setClassName("form-group")
				.build();
		
		HTMLSelectElement select = new HTMLBuilder<>(document.createElement(StringTypes.select))
				.setClassName("custom-select custom-select-sm")
				.setAttribute("name", name)
				.setCss("width", "90%")
				.setCss("float", "left")
				.setCss("margin", "2% 5% 2% 5%")
				.build();
		
		List<String> ls = Arrays.asList(strings);
		
		for(String s : ls) {
			
			HTMLOptionElement option = new HTMLBuilder<>(document.createElement(StringTypes.option))
					.build(); 
			
			option.text = s;
			
			$(select).append(option);
			
		}
		
		$(divSelect).append(select);
		
		return divSelect;
	}

	public static HTMLInputElement getInputField(String type, String placeholder, String name) {
		
		HTMLInputElement input = new InputBuilder()
				.setPlaceholder(placeholder)
				.setType(type)
				.setAttribute("name", name)
				.setClassName("form-control")
				.setCss("border-radius", "8px 8px 8px 8px")
				.build();
		return input;
	}

	public static HTMLDivElement getDivCheckBox(String s) {
		
		HTMLInputElement check = new InputBuilder()
				.setType("checkbox")
				.setClassName("custom-control-input")
				.setAttribute("id", s)
				.setAttribute("name", s)
				.build();
		HTMLLabelElement label = new LabelBuilder()
				.setTextContent(s)
				.setClassName("custom-control-label")
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Barlow Condensed")
				.setAttribute("for", s)
				.build();
		HTMLDivElement divCheck = new DivBuilder()
				.setClassName("custom-control custom-checkbox")
				.build();
		$(divCheck).append(check,label);
		return divCheck;
	}
	
	
}