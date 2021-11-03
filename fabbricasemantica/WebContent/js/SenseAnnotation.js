/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class SenseAnnotation {
        static main(args) {
            let form = quickstart.TemplatePage.getForm("senseAnnotation");
            let divWrapper = quickstart.TemplatePage.getDivWrapper();
            $(divWrapper).append(form);
            let Navbar = quickstart.TemplatePage.getNavbar();
            let divTitle = quickstart.TemplatePage.getDivTitle("given a word and a sentence in which the word appears, select the correct meaning of the word");
            $(form).append(divTitle);
            let divWordAndDescription = quickstart.TemplatePage.getDivWordOrDescription();
            $(form).append(divWordAndDescription);
            $.getJSON(SenseAnnotation.REST_URL, "task=SENSE_ANNOTATION", ((divWordAndDescription, form) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    let sID = (json["id"]);
                    let ID = quickstart.TemplatePage.getHiddenWord();
                    ID.value = sID;
                    let word = quickstart.TemplatePage.getWord(sWord);
                    let description = quickstart.TemplatePage.getDescription(sDescription);
                    $(divWordAndDescription).append(word, ID, description);
                    let senses = (json["senses"]);
                    let strings = senses.toString().split(",");
                    for (let k = 0; k < strings.length; k++) {
                        {
                            strings[k] = strings[k].split("##").join(",");
                        }
                        ;
                    }
                    let divRadio = quickstart.TemplatePage.getDivRadio(false, "radio", strings);
                    $(form).append(divRadio);
                    let divButtons = quickstart.TemplatePage.getDivButtons("senseAnnotation.jsp");
                    $(form).append(divButtons);
                    return null;
                };
            })(divWordAndDescription, form));
            $("body").append(Navbar);
            $("body").append(divWrapper);
            $("body").css("overflow", "hidden");
            $("body").css("height", "100%");
            $("body").css("background-image", "linear-gradient(to bottom right, #1d2c41, #395771)");
        }
    }
    SenseAnnotation.REST_URL = "nextExample.jsp";
    quickstart.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "quickstart.SenseAnnotation";
})(quickstart || (quickstart = {}));
quickstart.SenseAnnotation.main(null);
