/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class TranslationAnnotation {
        static main(args) {
            let form = quickstart.TemplatePage.getForm("translationAnnotation");
            let divWrapper = quickstart.TemplatePage.getDivWrapper();
            $(divWrapper).append(form);
            let Navbar = quickstart.TemplatePage.getNavbar();
            let divTitle = quickstart.TemplatePage.getDivTitle("Translate the word with the help of the sentence");
            $(form).append(divTitle);
            let divWordAndDescription = quickstart.TemplatePage.getDivWordOrDescription();
            $(form).append(divWordAndDescription);
            let divTextarea = quickstart.TemplatePage.getDivTextarea();
            $(form).append(divTextarea);
            let divButtons = quickstart.TemplatePage.getDivButtons("translationAnnotation.jsp");
            $(form).append(divButtons);
            $.getJSON(TranslationAnnotation.REST_URL, "task=TRANSLATION_ANNOTATION", ((divWordAndDescription) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    let sID = (json["id"]);
                    let word = quickstart.TemplatePage.getWord(sWord);
                    let ID = quickstart.TemplatePage.getHiddenWord();
                    ID.value = sID;
                    let description = quickstart.TemplatePage.getDescription(sDescription);
                    $(divWordAndDescription).append(word, ID, description);
                    return null;
                };
            })(divWordAndDescription));
            $("body").append(Navbar);
            $("body").append(divWrapper);
            $("body").css("overflow", "hidden");
            $("body").css("height", "100%");
            $("body").css("background-image", "linear-gradient(to bottom right, #1d2c41, #395771)");
        }
    }
    TranslationAnnotation.REST_URL = "nextExample.jsp";
    quickstart.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "quickstart.TranslationAnnotation";
})(quickstart || (quickstart = {}));
quickstart.TranslationAnnotation.main(null);
