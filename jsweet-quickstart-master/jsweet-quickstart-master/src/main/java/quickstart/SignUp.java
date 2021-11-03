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

public class SignUp {
	
	public static void main(String[] args) {
		
//		<-----Form Settings-------------------------------------------------------->
		
		HTMLFormElement form = TemplatePage.getForm("signup");
		form.style.width = "380px";
		form.style.marginBottom = "0px";

		HTMLDivElement divForm = TemplatePage.getDivWrapper();
		$(divForm).append(form);
		
//		<-----Form Groups-------------------------------------------------------->
		
//		<----------------------Logo---------------------------------------------->
		
		//Logo
		HTMLImageElement logo = new HTMLBuilder<>(document.createElement(StringTypes.img))
				.setCss("width", "85px")
				.build();
		logo.setAttribute("src","LOGODEF.png");

	
		HTMLDivElement divLogo = new DivBuilder()
				.setClassName("form-header")
				.setCss("width", "90%")
				.setCss("height", "auto")
				.setCss("display", "flex")
				.setCss("justify-content", "center")
				.setCss("align-items", "center")
				.setCss("margin","15px 0px 10px 0px")
				.build();
		$(divLogo).append(logo);
		
		
//		<----------------------Labels---------------------------------------------->
		
		//Signup text
		HTMLLabelElement signuplabel = new LabelBuilder()
				.setTextContent("SIGN UP")
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Barlow Condensed")
				.setCss("font-size", "28px")
				.setCss("font-weight", "bold")
				.setCss("margin","0px 0px 0px 15px")
				.build();
		HTMLDivElement divLabel = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin","0px 0px 0px")
				.build();
		$(divLabel).append(signuplabel);
		$(divLogo).append(divLabel);
		
		//Create ypur account text
		HTMLLabelElement creatAccountLabel = new LabelBuilder()
				.setTextContent("Create your account to start playing and improving your language skills")
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Gruppo")
				.setCss("font-style", "italic")
				.setCss("font-size", "13px")
				.setCss("margin", "0px 0px 0px 0px")
				.build();
		HTMLDivElement divCreateAccountLabel = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin","0px 0px 0px")
				.build();
		$(divCreateAccountLabel).append(creatAccountLabel);
		
		HTMLLabelElement otherSpokenLanguages = new LabelBuilder()
				.setTextContent("Other spoken languages (optional) :")
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Gruppo")
				.setCss("font-style", "italic")
				.setCss("font-size", "15px")
				.setCss("margin", "0px 0px 0px 0px")
				.build();
		HTMLDivElement divOtherSpokenLanguages = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin","0px 0px 0px")
				.build();
		
		$(divOtherSpokenLanguages).append(otherSpokenLanguages);
		
//		<----------------------Input---------------------------------------------->
		
		//Email Input
		HTMLInputElement email = TemplatePage.getInputField("email", "name@example.com", "signupEmail");
		email.style.margin = "10px auto 10px auto";
		HTMLDivElement divInput = new DivBuilder()
				.setClassName("form-input-group")
				.setCss("margin", "10px auto 10px auto")
				.setCss("width","90%")
				.build();
		$(divInput).append(email);
		
		//Password Input
		HTMLInputElement password = TemplatePage.getInputField("password", "password","signupPassword");
		password.style.margin = "10px auto 10px auto";
		$(divInput).append(password);
		
		//Repeat Password Input
		HTMLInputElement repeatpassword = TemplatePage.getInputField("password", "repeat password","signupRepeatPassword");
		repeatpassword.style.margin = "10px auto 10px auto";
		$(divInput).append(repeatpassword);
		
//		<----------------------Checkboxs Languages---------------------------------------------->
		
		HTMLDivElement divCheck = TemplatePage.getDivCheckBox("Italian (IT)");
		HTMLDivElement divCheck2 = TemplatePage.getDivCheckBox("English (EN)");
		divCheck2.style.marginLeft = "20px";
		
		HTMLDivElement divCheckbox = new DivBuilder()
				.setClassName("form-input-group custom-checkbox custom-control-inline")
				.setCss("width", "auto")
				.setCss("position", "center")
				.setCss("margin", "0px 0px 0px 0px")
				.build();
		HTMLLabelElement inseriscilingua = new LabelBuilder()
				.setTextContent("Native Language:")
				.setClassName("form-group")
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Gruppo")
				.setCss("margin", "0px 20px 0px 0px")
				.setCss("float", "left")
				.build();
		
		$(divCheckbox).append(inseriscilingua, divCheck,divCheck2);
		
//		<----------------------Select Menus with Radio---------------------------------------------->
		
		HTMLDivElement divSelect = TemplatePage.getDivSelect("Select1","","Italian","English","Spanish","French");
		
		String[] strings = new String[] {"A1","A2","B1","B2","C1","C2"};
		
		HTMLDivElement divRadio1 = TemplatePage.getDivRadio(true, "Radio1", strings);
		
		HTMLDivElement divSelect2 = TemplatePage.getDivSelect("Select2", "","Italian","English","Spanish","French");
		
		HTMLDivElement divRadio2 = TemplatePage.getDivRadio(true, "Radio2", strings);
		
//		<----------------------Submit Button---------------------------------------------------------------->
		
		
		HTMLInputElement btnsubmit = new InputBuilder()
				.setType("submit")
				.setClassName("btn btn-primary")
				.setCss("background", "#ee471a")
				.setCss("float", "right")
				.setCss("margin-right", "5%")
				.setCss("width", "90%")
				.setCss("margin-bottom", "10px")
				.setCss("margin-top", "8px")
				.setAttribute("value", "Submit")
				.build();
		
		HTMLDivElement divSubmit = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin","0px 0px 0px")
				.setCss("position", "center")
				.build();
		
		$(divSubmit).append(btnsubmit);
		
//		<----------------------Login Link---------------------------------------------------------------->		
		
		HTMLAnchorElement login = new AnchorBuilder("Already have an account? Sign in","Login.html")
				.setCss("color", "rgb(255,255,255)")
				.setCss("font-family", "Barlow Condensed")
				.build();
		
		HTMLDivElement divLogin = new DivBuilder()
				.setClassName("form-group")
				.setCss("margin-bottom", "10px")
				.build();
		$(divLogin).append(login);
		
		//Form Append
		$(form).append(divLogo, divCreateAccountLabel, divInput, divCheckbox, divOtherSpokenLanguages, divSelect, divRadio1, divSelect2, divRadio2, divSubmit, divLogin);
		
		//Body Settings
		$("body").append(divForm);
		$("body").css("overflow","hidden");
		$("body").css("height","100%");
		$("body").css("background","linear-gradient(to bottom right, #1d2c41, #395771)");
		
	}

}
