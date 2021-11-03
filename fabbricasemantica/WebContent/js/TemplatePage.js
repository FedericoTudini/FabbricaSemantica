/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class TemplatePage {
        static getForm(page) {
            let form = new quickstart.FormBuilder().setAction(page + ".jsp").setAttribute("id", "form").setCss("width", "460px").setCss("height", "auto").setCss("text-align", "center").setCss("border", "1px groove rgba(255,255,255,0.1)").setCss("border-radius", "10px 10px 10px 10px").setCss("background", "linear-gradient(rgba(0,0,0,0.1), rgba(97,97,97,0.1)").setCss("margin", "0px 0px 5% 0px").build();
            return form;
        }
        static getDivWrapper() {
            let divWrapper = new quickstart.DivBuilder().setCss("width", "100%").setCss("height", "100%").setCss("display", "flex").setCss("justify-content", "center").setCss("flex-direction", "column").setCss("align-items", "center").build();
            return divWrapper;
        }
        static getNavbar() {
            let Navbar = new quickstart.DivBuilder().setClassName("navbar").setCss("height", "50px").setCss("background", "linear-gradient(rgba(229,45,39,1), rgba(179,18,23,1)").setCss("padding", "0px 80px").setCss("border-bottom", "2px groove rgba(255,255,255,1)").build();
            let divNavbarHeader = new quickstart.DivBuilder().setClassName("navbar-header").setCss("height", "50px").setCss("width", "auto").setCss("padding", "0px 0px").setCss("float", "left").build();
            let navLabel = new quickstart.HTMLBuilder(document.createElement("a")).setAttribute("type", "nav-item").setClassName("nav-link disabled").setCss("color", "white").setCss("font-weight", "bold").setCss("font-size", "20px").setCss("font-family", "Barlow Condensed").setCss("padding", "10px 5px").setCss("margin", "0px 0px 0px 0px").build();
            navLabel.text = "WELCOME TO FABBRICA SEMANTICA!";
            $(divNavbarHeader).append(navLabel);
            let linkHome = new quickstart.AnchorBuilder("HOME", "Home.html").setAttribute("type", "nav-item").setClassName("nav-link").setCss("color", "white").setCss("font-size", "20px").setCss("font-family", "Barlow Condensed").setCss("padding", "10px 20px").build();
            $(Navbar).append(linkHome);
            let linkLogout = new quickstart.AnchorBuilder("LOGOUT", "Login.html").setAttribute("type", "nav-item").setClassName("nav-link").setCss("color", "white").setCss("font-size", "20px").setCss("font-family", "Barlow Condensed").setCss("padding", "10px 20px").build();
            $(Navbar).append(divNavbarHeader);
            $(Navbar).append(linkLogout);
            linkHome.addEventListener("mouseover", ((linkHome) => {
                return (event) => {
                    linkHome.style.background = "linear-gradient(rgba(179,18,23,1), rgba(229,45,39,1)";
                    return null;
                };
            })(linkHome));
            linkHome.addEventListener("mouseleave", ((linkHome) => {
                return (event) => {
                    linkHome.style.background = "none";
                    return null;
                };
            })(linkHome));
            linkLogout.addEventListener("mouseover", ((linkLogout) => {
                return (event) => {
                    linkLogout.style.background = "linear-gradient(rgba(179,18,23,1), rgba(229,45,39,1)";
                    return null;
                };
            })(linkLogout));
            linkLogout.addEventListener("mouseleave", ((linkLogout) => {
                return (event) => {
                    linkLogout.style.background = "none";
                    return null;
                };
            })(linkLogout));
            return Navbar;
        }
        static getDivButtons(href) {
            let buttonNext = new quickstart.InputBuilder().setValue("NEXT").setType("submit").setClassName("btn btn-primary").setCss("background", "linear-gradient(rgba(229,45,39,1), rgba(179,18,23,1)").setCss("float", "right").setAttribute("name", "buttonNext").setAttribute("href", href).setCss("width", "180px").setCss("border", "1px groove rgba(255,255,255,0.2)").setCss("border-radius", "10px 10px 10px 10px").build();
            let buttonSkip = new quickstart.InputBuilder().setValue("SKIP").setType("submit").setClassName("btn btn-primary").setAttribute("name", "buttonSkip").setCss("background", "linear-gradient(rgba(229,45,39,1), rgba(179,18,23,1)").setCss("float", "left").setAttribute("href", href).setCss("border-radius", "10px 10px 10px 10px").setCss("border", "1px groove rgba(255,255,255,0.2)").setCss("width", "180px").build();
            let divButtons = new quickstart.DivBuilder().setClassName("form-group form-input-group").setCss("height", "38px").setCss("margin-right", "5%").setCss("margin-left", "5%").setCss("margin-top", "15px").setCss("margin-bottom", "15px").build();
            buttonSkip.addEventListener("mouseover", ((buttonSkip) => {
                return (event) => {
                    buttonSkip.style.transform = "scale(1.05,1.1)";
                    return null;
                };
            })(buttonSkip));
            buttonSkip.addEventListener("mouseleave", ((buttonSkip) => {
                return (event) => {
                    buttonSkip.style.transform = "none";
                    return null;
                };
            })(buttonSkip));
            buttonNext.addEventListener("mouseover", ((buttonNext) => {
                return (event) => {
                    buttonNext.style.transform = "scale(1.05,1.1)";
                    return null;
                };
            })(buttonNext));
            buttonNext.addEventListener("mouseleave", ((buttonNext) => {
                return (event) => {
                    buttonNext.style.transform = "none";
                    return null;
                };
            })(buttonNext));
            $(divButtons).append(buttonSkip);
            $(divButtons).append(buttonNext);
            return divButtons;
        }
        static getDivTextarea() {
            let textarea = new quickstart.HTMLBuilder(document.createElement("textarea")).setClassName("form-control").setCss("background", "none").setAttribute("name", "textArea").setCss("border", "1px groove rgba(255,255,255,0.5)").setCss("border-radius", "10px 10px 10px 10px").setAttribute("placeholder", "Enter your translation here:").setCss("color", "#fff").setCss("font-family", "Barlow Condensed").setCss("font-size", "20px").setCss("min-height", "130px").setCss("max-height", "130px").build();
            let divTextarea = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "1% 5% 1% 5%").build();
            $(divTextarea).append(textarea);
            return divTextarea;
        }
        static getDivTitle(textContent) {
            let title = new quickstart.LabelBuilder().setTextContent(textContent).setCss("color", "rgb(255,255,255)").setCss("font-family", "Barlow Condensed").setCss("font-size", "18px").setCss("text-transform", "uppercase").setClassName("form-control-plaintext").build();
            let divTitle = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "1% 5% 1% 5%").setCss("margin-top", "15px").build();
            $(divTitle).append(title);
            return divTitle;
        }
        static getWord(word) {
            let wordLabel = new quickstart.LabelBuilder().setTextContent(word).setAttribute("name", "word").setAttribute("value", word).setCss("color", "rgb(255,255,255)").setCss("font-family", "Barlow Condensed").setCss("font-size", "26px").setCss("font-weight", "bold").setCss("text-transform", "uppercase").setClassName("form-control-plaintext").setCss("text-decoration", "underline").setCss("padding", "0px 10px 0px 10px").build();
            return wordLabel;
        }
        static getHiddenWord() {
            let hiddenWord = new quickstart.InputBuilder().setType("hidden").setAttribute("name", "synsetID").build();
            return hiddenWord;
        }
        static getHiddenDescription(description) {
            let hiddenWord = new quickstart.InputBuilder().setType("hidden").setAttribute("name", "hDescription").build();
            return hiddenWord;
        }
        static getDescription(description) {
            let descriptionLabel = new quickstart.LabelBuilder().setTextContent(description).setAttribute("name", "description").setAttribute("value", description).setCss("color", "rgb(255,255,255)").setCss("font-family", "Gruppo").setCss("font-style", "italic").setCss("font-size", "16px").setClassName("form-control-plaintext").setCss("border", "1px groove rgba(255,255,255,0.1)").setCss("border-radius", "15px 15px 15px 15px").setCss("padding", "6px 10px 6px 10px").build();
            return descriptionLabel;
        }
        static getDivWordOrDescription() {
            let divWordOrDescription = new quickstart.DivBuilder().setClassName("form-group").setCss("margin", "1% 5% 3% 5%").setCss("border", "1px groove rgba(255,255,255,0.1)").setCss("border-radius", "15px 15px 15px 15px").build();
            return divWordOrDescription;
        }
        static getDivRadio(inline, name, strings) {
            let divRadioWrapper = new quickstart.DivBuilder().setClassName("container").setCss("margin-left", "5%").setCss("margin-right", "5%").setCss("margin-bottom", "0px").setCss("padding", "0px 0px 0px 0px").setCss("width", "90%").setCss("text-align", "center").build();
            let ls = strings.slice(0);
            for (let index122 = 0; index122 < ls.length; index122++) {
                let s = ls[index122];
                {
                    let radio = new quickstart.InputBuilder().setType("radio").setClassName("custom-control-input").setAttribute("name", name).setAttribute("id", name + " " + s).setAttribute("value", s).build();
                    let label = new quickstart.LabelBuilder().setTextContent(s).setClassName("custom-control-label").setCss("color", "rgb(255,255,255)").setCss("font-family", "Gruppo").setCss("font-style", "italic").setCss("font-size", "16px").build();
                    label.htmlFor = name + " " + s;
                    let divRadio = new quickstart.DivBuilder().setCss("margin", "0px 10px 0px 0px").build();
                    if (!inline) {
                        divRadio.className = "custom-control custom-radio custom-control-block";
                        divRadio.style.justifyContent = "center";
                    }
                    else
                        divRadio.className = "custom-control custom-radio custom-control-inline";
                    $(divRadio).append(radio, label);
                    $(divRadioWrapper).append(divRadio);
                }
            }
            if (!inline) {
                divRadioWrapper.style.textAlign = "left";
            }
            return divRadioWrapper;
        }
        static getDivProgressBar(progressbar) {
            let divProgress = new quickstart.DivBuilder().setClassName("progress").setCss("margin-bottom", "25px").build();
            $(divProgress).append(progressbar);
            return divProgress;
        }
        static getProgressBar() {
            let divProgress = new quickstart.DivBuilder().setClassName("progress").build();
            let progressbar = new quickstart.DivBuilder().setClassName("progress-bar progress-bar-danger").setAttribute("role", "progressbar").setCss("width", "460px").setAttribute("aria-valuemin", "1").setAttribute("aria-valuemax", "10").setAttribute("aria-valuenow", "5").build();
            $(divProgress).append(progressbar);
            return progressbar;
        }
        static getDivSelect(name, ...strings) {
            let divSelect = new quickstart.DivBuilder().setClassName("form-group").build();
            let select = new quickstart.HTMLBuilder(document.createElement("select")).setClassName("custom-select custom-select-sm").setAttribute("name", name).setCss("width", "90%").setCss("float", "left").setCss("margin", "2% 5% 2% 5%").build();
            let ls = strings.slice(0);
            for (let index123 = 0; index123 < ls.length; index123++) {
                let s = ls[index123];
                {
                    let option = new quickstart.HTMLBuilder(document.createElement("option")).build();
                    option.text = s;
                    $(select).append(option);
                }
            }
            $(divSelect).append(select);
            return divSelect;
        }
        static getInputField(type, placeholder, name) {
            let input = new quickstart.InputBuilder().setPlaceholder(placeholder).setType(type).setAttribute("name", name).setClassName("form-control").setCss("border-radius", "8px 8px 8px 8px").build();
            return input;
        }
        static getDivCheckBox(s) {
            let check = new quickstart.InputBuilder().setType("checkbox").setClassName("custom-control-input").setAttribute("id", s).setAttribute("name", s).build();
            let label = new quickstart.LabelBuilder().setTextContent(s).setClassName("custom-control-label").setCss("color", "rgb(255,255,255)").setCss("font-family", "Barlow Condensed").setAttribute("for", s).build();
            let divCheck = new quickstart.DivBuilder().setClassName("custom-control custom-checkbox").build();
            $(divCheck).append(check, label);
            return divCheck;
        }
    }
    quickstart.TemplatePage = TemplatePage;
    TemplatePage["__class"] = "quickstart.TemplatePage";
})(quickstart || (quickstart = {}));
