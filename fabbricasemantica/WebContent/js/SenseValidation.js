/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class SenseValidation {
        static main(args) {
            let form = quickstart.TemplatePage.getForm("senseValidation");
            let divWrapper = quickstart.TemplatePage.getDivWrapper();
            $(divWrapper).append(form);
            let Navbar = quickstart.TemplatePage.getNavbar();
            let divTitle = quickstart.TemplatePage.getDivTitle("given a word and a sentence in which the word appears, check if the meaning of the word is correct");
            $(form).append(divTitle);
            let divWordAndDescription = quickstart.TemplatePage.getDivWordOrDescription();
            $(form).append(divWordAndDescription);
            let strings = ["Yes", "No"];
            let divRadio = quickstart.TemplatePage.getDivRadio(true, "radio", strings);
            $(form).append(divRadio);
            let divButtons = quickstart.TemplatePage.getDivButtons("senseValidation.jsp");
            $(form).append(divButtons);
            $.getJSON(SenseValidation.REST_URL, "task=SENSE_VALIDATION", ((divWordAndDescription) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    let sSense = (json["sense"]);
                    let sID = (json["id"]);
                    let ID = quickstart.TemplatePage.getHiddenWord();
                    ID.value = sID;
                    let word = quickstart.TemplatePage.getWord(sWord);
                    let description = quickstart.TemplatePage.getDescription(sDescription);
                    description.style.border = "none";
                    let sense = quickstart.TemplatePage.getDescription(sSense);
                    sense.setAttribute("name", "sense");
                    $(divWordAndDescription).append(word, ID, description, sense);
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
    SenseValidation.REST_URL = "nextExample.jsp";
    quickstart.SenseValidation = SenseValidation;
    SenseValidation["__class"] = "quickstart.SenseValidation";
})(quickstart || (quickstart = {}));
quickstart.SenseValidation.main(null);
