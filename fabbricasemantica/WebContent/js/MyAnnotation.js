/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class MyAnnotation {
        static main(args) {
            let form = quickstart.TemplatePage.getForm("myAnnotation");
            let divWrapper = quickstart.TemplatePage.getDivWrapper();
            $(divWrapper).append(form);
            let Navbar = quickstart.TemplatePage.getNavbar();
            let divTitle = quickstart.TemplatePage.getDivTitle("rearrange the words to form the correct sentence");
            $(form).append(divTitle);
            let divWordAndDescription = quickstart.TemplatePage.getDivWordOrDescription();
            $(form).append(divWordAndDescription);
            let divInputs = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "0% 5% 1% 5%").setCss("margin-top", "15px").build();
            $.getJSON(MyAnnotation.REST_URL, "task=MY_ANNOTATION", ((divWordAndDescription, divInputs) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let phrase = (json["description"]);
                    let sID = (json["id"]);
                    let ID = quickstart.TemplatePage.getHiddenWord();
                    ID.value = sID;
                    let assembled = quickstart.TemplatePage.getHiddenWord();
                    assembled.setAttribute("name", "assembled");
                    assembled.value = "";
                    let word = quickstart.TemplatePage.getWord(sWord);
                    let description = quickstart.TemplatePage.getDescription("");
                    $(divWordAndDescription).append(word, ID, description, assembled);
                    let ls = phrase.split(" ").slice(0);
                    let ris = ([]);
                    for (let i = ls.length - 1; i !== -1; i--) {
                        {
                            let n = (Math.round(Math.random() * i) | 0);
                            /* add */ (ris.push(/* get */ ls[n]) > 0);
                            /* remove */ ls.splice(n, 1)[0];
                        }
                        ;
                    }
                    for (let index121 = 0; index121 < ris.length; index121++) {
                        let s = ris[index121];
                        {
                            let splittedword = new quickstart.InputBuilder().setType("button").setValue(s).setCss("color", "white").setClassName("btn btn-primary").setCss("border-radius", "15px 15px 15px 15px").setCss("background", "linear-gradient(to bottom right, rgba(0,0,69,0.5), rgba(57,94,133,0.5))").setCss("border", "1px groove rgba(255,255,255,0.3)").setCss("text-align", "center").setCss("min-width", "90px").setCss("width", "auto").setCss("height", "25px").setCss("font-family", "Gruppo").setCss("font-style", "italic").setCss("font-size", "14px").setCss("margin", "3px 3px 3px 3px").setCss("padding", "0px 5px 0px 5px").build();
                            splittedword.addEventListener("click", (event) => {
                                switch ((splittedword.className)) {
                                    case "btn btn-primary":
                                        splittedword.className = "btn btn-primary active";
                                        description.textContent += " " + splittedword.value;
                                        assembled.value += " " + splittedword.value;
                                        splittedword.style.opacity = "0.3";
                                        break;
                                    case "btn btn-primary active":
                                        description.textContent = description.textContent.split(" " + splittedword.value).join("");
                                        assembled.value = assembled.value.split(" " + splittedword.value).join("");
                                        splittedword.className = "btn btn-primary";
                                        splittedword.style.opacity = "1";
                                        break;
                                }
                                return null;
                            });
                            splittedword.addEventListener("mouseover", (event) => {
                                splittedword.style.transform = "scale(1.1,1.2)";
                                return null;
                            });
                            splittedword.addEventListener("mouseleave", (event) => {
                                splittedword.style.transform = "none";
                                return null;
                            });
                            $(divInputs).append(splittedword);
                        }
                    }
                    return null;
                };
            })(divWordAndDescription, divInputs));
            $(form).append(divInputs);
            let divButtons = quickstart.TemplatePage.getDivButtons("myAnnotation.jsp");
            $(form).append(divButtons);
            $("body").append(Navbar);
            $("body").append(divWrapper);
            $("body").css("overflow", "hidden");
            $("body").css("height", "100%");
            $("body").css("background-image", "linear-gradient(to bottom right, #1d2c41, #395771)");
        }
    }
    MyAnnotation.REST_URL = "nextExample.jsp";
    quickstart.MyAnnotation = MyAnnotation;
    MyAnnotation["__class"] = "quickstart.MyAnnotation";
})(quickstart || (quickstart = {}));
quickstart.MyAnnotation.main(null);
