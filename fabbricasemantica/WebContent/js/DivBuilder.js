/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class DivBuilder extends quickstart.HTMLBuilder {
        constructor() {
            super(document.createElement("div"));
            if (this.div === undefined)
                this.div = null;
            this.div = super.build();
        }
    }
    quickstart.DivBuilder = DivBuilder;
    DivBuilder["__class"] = "quickstart.DivBuilder";
})(quickstart || (quickstart = {}));
