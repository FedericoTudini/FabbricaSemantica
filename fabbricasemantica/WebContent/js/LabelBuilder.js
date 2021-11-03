/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class LabelBuilder extends quickstart.HTMLBuilder {
        constructor() {
            super(document.createElement("label"));
            if (this.label === undefined)
                this.label = null;
            this.label = super.build();
        }
        setTextContent(textContent) {
            this.label.textContent = textContent;
            return this;
        }
    }
    quickstart.LabelBuilder = LabelBuilder;
    LabelBuilder["__class"] = "quickstart.LabelBuilder";
})(quickstart || (quickstart = {}));
