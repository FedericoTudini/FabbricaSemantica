/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class WordAnnotation {
        static main(args) {
            let form = quickstart.TemplatePage.getForm("wordAnnotation");
            let divWrapper = quickstart.TemplatePage.getDivWrapper();
            $(divWrapper).append(form);
            let Navbar = quickstart.TemplatePage.getNavbar();
            let divTitle = quickstart.TemplatePage.getDivTitle("Translate the word described in this the sentence");
            $(form).append(divTitle);
            let divDescription = quickstart.TemplatePage.getDivWordOrDescription();
            $(form).append(divDescription);
            let divTextarea = quickstart.TemplatePage.getDivTextarea();
            $(form).append(divTextarea);
            let divButtons = quickstart.TemplatePage.getDivButtons("wordAnnotation.jsp");
            $(form).append(divButtons);
            $.getJSON(WordAnnotation.REST_URL, "task=WORD_ANNOTATION", ((divDescription) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sDescription = (json["description"]);
                    let sID = (json["id"]);
                    let ID = quickstart.TemplatePage.getHiddenWord();
                    ID.value = sID;
                    let description = quickstart.TemplatePage.getDescription(sDescription);
                    $(divDescription).append(description, ID);
                    return null;
                };
            })(divDescription));
            $("body").append(Navbar);
            $("body").append(divWrapper);
            $("body").css("overflow", "hidden");
            $("body").css("height", "100%");
            $("body").css("background-image", "linear-gradient(to bottom right, #1d2c41, #395771)");
        }
    }
    WordAnnotation.REST_URL = "nextExample.jsp";
    quickstart.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "quickstart.WordAnnotation";
})(quickstart || (quickstart = {}));
quickstart.WordAnnotation.main(null);
