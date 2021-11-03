/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Login {
        static main(args) {
            let form = quickstart.TemplatePage.getForm("login");
            form.style.width = "380px";
            form.style.height = "500px";
            form.style.margin = "0px 0px 0px";
            let logo = new quickstart.HTMLBuilder(document.createElement("img")).setCss("width", "200px").setAttribute("src", "LOGODEF.png").build();
            let divWrapper = quickstart.TemplatePage.getDivWrapper();
            let welcome = new quickstart.LabelBuilder().setTextContent("WELCOME TO FABBRICA SEMANTICA").setCss("width", "100%").setCss("color", "rgb(255,255,255)").setCss("font-family", "Barlow Condensed").setCss("font-size", "28px").setCss("margin", "0px 0px 0px").build();
            let insert = new quickstart.LabelBuilder().setTextContent("Enter your credentials to start playing:").setCss("width", "100%").setCss("color", "rgb(255,255,255)").setCss("font-family", "Gruppo").setCss("font-style", "italic").setCss("font-size", "16px").setCss("margin", "0px 0px 0px").build();
            let button = new quickstart.InputBuilder().setType("submit").setValue("LOGIN").setClassName("btn btn-primary").setCss("width", "100%").setCss("background", "#ee471a").setCss("border-radius", "8px 8px 8px 8px").build();
            let signUp = new quickstart.AnchorBuilder("Don\'t have an account? Sign Up", "SignUp.html").setCss("color", "rgb(255,255,255)").setCss("font-family", "Barlow Condensed").build();
            let divLogo = new quickstart.DivBuilder().setClassName("form-header").setCss("margin", "25px auto 20px auto").build();
            $(divLogo).append(logo);
            let divWelcome = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "0px 0px 0px").build();
            $(divWelcome).append(welcome);
            let divInsert = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "0px 0px 0px").build();
            $(divInsert).append(insert);
            let divEmail = new quickstart.DivBuilder().setClassName("form-input-group").setCss("margin", "10px auto 10px auto").setCss("width", "90%").build();
            $(divEmail).append(quickstart.TemplatePage.getInputField("email", "name@example.com", "loginEmail"));
            let divPassword = new quickstart.DivBuilder().setClassName("form-input-group").setCss("margin", "10px auto 10px auto").setCss("width", "90%").build();
            $(divPassword).append(quickstart.TemplatePage.getInputField("password", "password", "loginPassword"));
            let divButton = new quickstart.DivBuilder().setCss("margin", "10px auto 10px auto").setCss("width", "90%").setClassName("form-group").build();
            $(divButton).append(button);
            let divSignUp = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "auto auto auto auto").build();
            $(divSignUp).append(signUp);
            $(form).append(divLogo, divWelcome, divInsert, divEmail, divPassword, divButton, divSignUp);
            $(divWrapper).append(form);
            $("body").append(divWrapper);
            $("body").css("overflow", "hidden");
            $("body").css("height", "100%");
            $("body").css("background-image", "linear-gradient(to bottom right, #1d2c41, #395771)");
        }
    }
    quickstart.Login = Login;
    Login["__class"] = "quickstart.Login";
})(quickstart || (quickstart = {}));
quickstart.Login.main(null);
