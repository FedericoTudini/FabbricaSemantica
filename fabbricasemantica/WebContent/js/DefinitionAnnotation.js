/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class DefinitionAnnotation {
        static main(args) {
            let form = quickstart.TemplatePage.getForm("definitionAnnotation");
            let divWrapper = quickstart.TemplatePage.getDivWrapper();
            $(divWrapper).append(form);
            let Navbar = quickstart.TemplatePage.getNavbar();
            let divTitle = quickstart.TemplatePage.getDivTitle("translate the word with the help of one of its hypernym");
            $(form).append(divTitle);
            let divWordAndDescription = quickstart.TemplatePage.getDivWordOrDescription();
            $(form).append(divWordAndDescription);
            let divTextarea = quickstart.TemplatePage.getDivTextarea();
            $(form).append(divTextarea);
            let divButtons = quickstart.TemplatePage.getDivButtons("definitionAnnotation.jsp");
            $(form).append(divButtons);
            $.getJSON(DefinitionAnnotation.REST_URL, "task=DEFINITION_ANNOTATION", ((divWordAndDescription) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["hypernym"]);
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
    DefinitionAnnotation.REST_URL = "nextExample.jsp";
    quickstart.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "quickstart.DefinitionAnnotation";
})(quickstart || (quickstart = {}));
quickstart.DefinitionAnnotation.main(null);
