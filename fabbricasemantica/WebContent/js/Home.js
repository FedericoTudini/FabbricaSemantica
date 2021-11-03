/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Home {
        static main(args) {
            let divWrapper = quickstart.TemplatePage.getDivWrapper();
            let form = quickstart.TemplatePage.getForm("home");
            form.style.background = "none";
            form.style.border = "none";
            $(divWrapper).append(form);
            let divNavbar = quickstart.TemplatePage.getNavbar();
            let readyplay = new quickstart.LabelBuilder().setTextContent("READY? PLAY!").setCss("color", "white").setCss("font-weight", "bold").setCss("font-size", "60px").setCss("font-family", "Barlow Condensed").setCss("border", "1px groove rgba(255,255,255,0.5)").setCss("border-radius", "10px 10px 10px 10px").setCss("padding-left", "10px").setCss("padding-right", "10px").setCss("margin-top", "10px").build();
            let divLabel = new quickstart.DivBuilder().setClassName("form-group").setCss("margin-top", "20px").build();
            $(divLabel).append(readyplay);
            let play = new quickstart.InputBuilder().setType("image").setAttribute("src", "playbutton-01.png").setCss("width", "200px").setCss("margin-top", "50px").setCss("margin-bottom", "20px").build();
            let divInput = new quickstart.DivBuilder().setClassName("form-group").build();
            $(divLabel).append(readyplay);
            $(divInput).append(play);
            play.addEventListener("mouseover", ((play) => {
                return (event) => {
                    play.style.transform = "scale(1.1,1.1)";
                    return null;
                };
            })(play));
            play.addEventListener("mouseleave", ((play) => {
                return (event) => {
                    play.style.transform = "none";
                    return null;
                };
            })(play));
            $("body").append(divNavbar);
            $(form).append(divLabel);
            $(form).append(divInput);
            $("body").append(divWrapper);
            $("body").css("overflow", "hidden");
            $("body").css("height", "100%");
            $("body").css("background-image", "linear-gradient(to bottom right, #1d2c41, #395771)");
        }
    }
    quickstart.Home = Home;
    Home["__class"] = "quickstart.Home";
})(quickstart || (quickstart = {}));
quickstart.Home.main(null);
