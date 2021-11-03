/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class TranslationValidation {
        static main(args) {
            let form = quickstart.TemplatePage.getForm("translationValidation");
            let divWrapper = quickstart.TemplatePage.getDivWrapper();
            $(divWrapper).append(form);
            let Navbar = quickstart.TemplatePage.getNavbar();
            let divTitle = quickstart.TemplatePage.getDivTitle("Choose the best translation for the word, with the help of the sentence");
            $(form).append(divTitle);
            let wordDescription = quickstart.TemplatePage.getDivWordOrDescription();
            $(form).append(wordDescription);
            $.getJSON(TranslationValidation.REST_URL, "task=TRANSLATION_VALIDATION", ((form, wordDescription) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    let sID = (json["id"]);
                    let word = quickstart.TemplatePage.getWord(sWord);
                    let description = quickstart.TemplatePage.getDescription(sDescription);
                    let ID = quickstart.TemplatePage.getHiddenWord();
                    ID.value = sID;
                    $(wordDescription).append(word, ID, description);
                    let translations = json["translations"] + ",None of the previous";
                    let strings = translations.toString().split(",");
                    for (let k = 0; k < strings.length; k++) {
                        {
                            strings[k] = strings[k].split("##").join(",");
                        }
                        ;
                    }
                    let divRadio = quickstart.TemplatePage.getDivRadio(false, "radio", strings);
                    $(form).append(divRadio);
                    let divButtons = quickstart.TemplatePage.getDivButtons("translationValidation.jsp");
                    $(form).append(divButtons);
                    return null;
                };
            })(form, wordDescription));
            $("body").append(Navbar);
            $("body").append(divWrapper);
            $("body").css("overflow", "hidden");
            $("body").css("height", "100%");
            $("body").css("background-image", "linear-gradient(to bottom right, #1d2c41, #395771)");
        }
    }
    TranslationValidation.REST_URL = "nextExample.jsp";
    quickstart.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "quickstart.TranslationValidation";
})(quickstart || (quickstart = {}));
quickstart.TranslationValidation.main(null);
