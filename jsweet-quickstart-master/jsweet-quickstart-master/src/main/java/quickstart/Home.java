package quickstart;

import static def.jquery.Globals.$;
import static jsweet.util.StringTypes.mouseleave;
import static jsweet.util.StringTypes.mouseover;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;

public class Home {
	
	public static void main(String[] args) {
		
		
		
		HTMLDivElement divWrapper = TemplatePage.getDivWrapper();
		
		HTMLFormElement form = TemplatePage.getForm("home");
		form.style.background = "none";
		form.style.border = "none";
		
		$(divWrapper).append(form);
		
		
		HTMLDivElement divNavbar = TemplatePage.getNavbar();
		
		HTMLLabelElement readyplay = new LabelBuilder()
				.setTextContent("READY? PLAY!")
				.setCss("color", "white")
				.setCss("font-weight", "bold")
				.setCss("font-size", "60px")
				.setCss("font-family", "Barlow Condensed")
				.setCss("border", "1px groove rgba(255,255,255,0.5)")
				.setCss("border-radius", "10px 10px 10px 10px")
				.setCss("padding-left", "10px")
				.setCss("padding-right", "10px")
				.setCss("margin-top", "10px")
				.build();
		
		HTMLDivElement divLabel = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin-top", "20px")
				.build();
		$(divLabel).append(readyplay);
		
		HTMLInputElement play = new InputBuilder()
				.setType("image")
				.setAttribute("src", "playbutton-01.png")
				.setCss("width", "200px")
				.setCss("margin-top", "50px")
				.setCss("margin-bottom", "20px")
				.build();
		
		HTMLDivElement divInput = new DivBuilder()
				.setClassName("form-group")
				.build();
		$(divLabel).append(readyplay);
		
		$(divInput).append(play);
		
		play.addEventListener(mouseover, event -> {
			play.style.transform = "scale(1.1,1.1)";
			return null;
		});
		
		play.addEventListener(mouseleave, event -> {
			play.style.transform = "none";
			return null;
		});
		
		
		
		$("body").append(divNavbar);
		$(form).append(divLabel);
		$(form).append(divInput);
		$("body").append(divWrapper);
		$("body").css("overflow","hidden");
		$("body").css("height","100%");
		$("body").css("background-image","linear-gradient(to bottom right, #1d2c41, #395771)");
		
	}

}
