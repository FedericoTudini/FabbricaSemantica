/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class SignUp {
        static main(args) {
            let form = quickstart.TemplatePage.getForm("signup");
            form.style.width = "380px";
            form.style.marginBottom = "0px";
            let divForm = quickstart.TemplatePage.getDivWrapper();
            $(divForm).append(form);
            let logo = new quickstart.HTMLBuilder(document.createElement("img")).setCss("width", "85px").build();
            logo.setAttribute("src", "LOGODEF.png");
            let divLogo = new quickstart.DivBuilder().setClassName("form-header").setCss("width", "90%").setCss("height", "auto").setCss("display", "flex").setCss("justify-content", "center").setCss("align-items", "center").setCss("margin", "15px 0px 10px 0px").build();
            $(divLogo).append(logo);
            let signuplabel = new quickstart.LabelBuilder().setTextContent("SIGN UP").setCss("color", "rgb(255,255,255)").setCss("font-family", "Barlow Condensed").setCss("font-size", "28px").setCss("font-weight", "bold").setCss("margin", "0px 0px 0px 15px").build();
            let divLabel = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "0px 0px 0px").build();
            $(divLabel).append(signuplabel);
            $(divLogo).append(divLabel);
            let creatAccountLabel = new quickstart.LabelBuilder().setTextContent("Create your account to start playing and improving your language skills").setCss("color", "rgb(255,255,255)").setCss("font-family", "Gruppo").setCss("font-style", "italic").setCss("font-size", "13px").setCss("margin", "0px 0px 0px 0px").build();
            let divCreateAccountLabel = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "0px 0px 0px").build();
            $(divCreateAccountLabel).append(creatAccountLabel);
            let otherSpokenLanguages = new quickstart.LabelBuilder().setTextContent("Other spoken languages (optional) :").setCss("color", "rgb(255,255,255)").setCss("font-family", "Gruppo").setCss("font-style", "italic").setCss("font-size", "15px").setCss("margin", "0px 0px 0px 0px").build();
            let divOtherSpokenLanguages = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "0px 0px 0px").build();
            $(divOtherSpokenLanguages).append(otherSpokenLanguages);
            let email = quickstart.TemplatePage.getInputField("email", "name@example.com", "signupEmail");
            email.style.margin = "10px auto 10px auto";
            let divInput = new quickstart.DivBuilder().setClassName("form-input-group").setCss("margin", "10px auto 10px auto").setCss("width", "90%").build();
            $(divInput).append(email);
            let password = quickstart.TemplatePage.getInputField("password", "password", "signupPassword");
            password.style.margin = "10px auto 10px auto";
            $(divInput).append(password);
            let repeatpassword = quickstart.TemplatePage.getInputField("password", "repeat password", "signupRepeatPassword");
            repeatpassword.style.margin = "10px auto 10px auto";
            $(divInput).append(repeatpassword);
            let divCheck = quickstart.TemplatePage.getDivCheckBox("Italian (IT)");
            let divCheck2 = quickstart.TemplatePage.getDivCheckBox("English (EN)");
            divCheck2.style.marginLeft = "20px";
            let divCheckbox = new quickstart.DivBuilder().setClassName("form-input-group custom-checkbox custom-control-inline").setCss("width", "auto").setCss("position", "center").setCss("margin", "0px 0px 0px 0px").build();
            let inseriscilingua = new quickstart.LabelBuilder().setTextContent("Native Language:").setClassName("form-group").setCss("color", "rgb(255,255,255)").setCss("font-family", "Gruppo").setCss("margin", "0px 20px 0px 0px").setCss("float", "left").build();
            $(divCheckbox).append(inseriscilingua, divCheck, divCheck2);
            let divSelect = quickstart.TemplatePage.getDivSelect("Select1", "", "Italian", "English", "Spanish", "French");
            let strings = ["A1", "A2", "B1", "B2", "C1", "C2"];
            let divRadio1 = quickstart.TemplatePage.getDivRadio(true, "Radio1", strings);
            let divSelect2 = quickstart.TemplatePage.getDivSelect("Select2", "", "Italian", "English", "Spanish", "French");
            let divRadio2 = quickstart.TemplatePage.getDivRadio(true, "Radio2", strings);
            let btnsubmit = new quickstart.InputBuilder().setType("submit").setClassName("btn btn-primary").setCss("background", "#ee471a").setCss("float", "right").setCss("margin-right", "5%").setCss("width", "90%").setCss("margin-bottom", "10px").setCss("margin-top", "8px").setAttribute("value", "Submit").build();
            let divSubmit = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "0px 0px 0px").setCss("position", "center").build();
            $(divSubmit).append(btnsubmit);
            let login = new quickstart.AnchorBuilder("Already have an account? Sign in", "Login.html").setCss("color", "rgb(255,255,255)").setCss("font-family", "Barlow Condensed").build();
            let divLogin = new quickstart.DivBuilder().setClassName("form-group").setCss("margin-bottom", "10px").build();
            $(divLogin).append(login);
            $(form).append(divLogo, divCreateAccountLabel, divInput, divCheckbox, divOtherSpokenLanguages, divSelect, divRadio1, divSelect2, divRadio2, divSubmit, divLogin);
            $("body").append(divForm);
            $("body").css("overflow", "hidden");
            $("body").css("height", "100%");
            $("body").css("background", "linear-gradient(to bottom right, #1d2c41, #395771)");
        }
    }
    quickstart.SignUp = SignUp;
    SignUp["__class"] = "quickstart.SignUp";
})(quickstart || (quickstart = {}));
quickstart.SignUp.main(null);
