/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class AnchorBuilder extends quickstart.HTMLBuilder {
        constructor(text, href) {
            super(document.createElement("a"));
            if (this.anchor === undefined)
                this.anchor = null;
            this.anchor = super.build();
            this.anchor.text = text;
            this.anchor.href = href;
        }
    }
    quickstart.AnchorBuilder = AnchorBuilder;
    AnchorBuilder["__class"] = "quickstart.AnchorBuilder";
})(quickstart || (quickstart = {}));
