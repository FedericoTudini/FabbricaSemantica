package quickstart;

import static def.jquery.Globals.$;
import static def.dom.Globals.document;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLImageElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import jsweet.util.StringTypes;

public class Login {
	
	public static void main(String[] args) {
		
//		<-----Form Settings-------------------------------------------------------->
		
		HTMLFormElement form = TemplatePage.getForm("login");
		form.style.width = "380px";
		form.style.height = "500px";
		form.style.margin = "0px 0px 0px";
		
//		<-----Form Content-------------------------------------------------------->
		
//		<-----------------------------Logo---------------------------------------->
		HTMLImageElement logo = new HTMLBuilder<HTMLImageElement>(document.createElement(StringTypes.img))
				.setCss("width", "200px")
				.setAttribute("src", "LOGODEF.png")
				.build();
		
		HTMLDivElement divWrapper = TemplatePage.getDivWrapper();
		
//		<-----------------------------Labels-------------------------------------->
		
		HTMLLabelElement welcome = new LabelBuilder()
				.setTextContent("WELCOME TO FABBRICA SEMANTICA")
				.setCss("width", "100%")
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Barlow Condensed")
				.setCss("font-size", "28px")
				.setCss("margin", "0px 0px 0px")
				.build();
		
		HTMLLabelElement insert = new LabelBuilder()
				.setTextContent("Enter your credentials to start playing:")
				.setCss("width", "100%")
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Gruppo")
				.setCss("font-style", "italic")
				.setCss("font-size", "16px")
				.setCss("margin", "0px 0px 0px")
				.build();
		
//		<-----------------------------Login Button---------------------------------------->
		
		HTMLInputElement button = new InputBuilder()
				.setType("submit")
				.setValue("LOGIN")
				.setClassName("btn btn-primary")
				.setCss("width", "100%")
				.setCss("background", "#ee471a")
				.setCss("border-radius", "8px 8px 8px 8px")
				.build();
		
//		<-----------------------------Sign Up Link---------------------------------------->
		
		HTMLAnchorElement signUp = new AnchorBuilder("Don't have an account? Sign Up","SignUp.html")
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Barlow Condensed")
				.build();
		
//		<-----------------------------Div & Input Fields---------------------------------------->
		
		HTMLDivElement divLogo = new DivBuilder()
				.setClassName("form-header")
				.setCss("margin", "25px auto 20px auto")
				.build();
		$(divLogo).append(logo);
		
		HTMLDivElement divWelcome = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin", "0px 0px 0px")
				.build();
		$(divWelcome).append(welcome);
		
		HTMLDivElement divInsert = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin", "0px 0px 0px")
				.build();
		$(divInsert).append(insert);
		
		HTMLDivElement divEmail = new DivBuilder()
				.setClassName("form-input-group")
				.setCss("margin", "10px auto 10px auto")
				.setCss("width","90%")
				.build();
		$(divEmail).append(TemplatePage.getInputField("email", "name@example.com","loginEmail"));
		
		HTMLDivElement divPassword = new DivBuilder()
				.setClassName("form-input-group")
				.setCss("margin", "10px auto 10px auto")
				.setCss("width","90%")
				.build();
		
		$(divPassword).append(TemplatePage.getInputField("password", "password","loginPassword"));
		
		HTMLDivElement divButton = new DivBuilder()
				.setCss("margin", "10px auto 10px auto")
				.setCss("width","90%")
				.setClassName("form-group")
				.build();
		$(divButton).append(button);
		
		HTMLDivElement divSignUp = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin", "auto auto auto auto")
				.build();
		$(divSignUp).append(signUp);
		
		
		$(form).append(divLogo, divWelcome, divInsert, divEmail, divPassword, divButton, divSignUp);
		$(divWrapper).append(form);
		
//		<------Body Settings--------------------------------------------------------------->
		
		$("body").append(divWrapper);
		$("body").css("overflow","hidden");
		$("body").css("height","100%");
		$("body").css("background-image","linear-gradient(to bottom right, #1d2c41, #395771)");
			
		
	}
	
}
