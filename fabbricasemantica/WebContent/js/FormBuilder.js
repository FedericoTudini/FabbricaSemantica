/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class FormBuilder extends quickstart.HTMLBuilder {
        constructor() {
            super(document.createElement("form"));
            if (this.form === undefined)
                this.form = null;
            this.form = super.build();
            this.form.method = "POST";
        }
        setAction(action) {
            this.form.action = action;
            return this;
        }
        setMethod(method) {
            this.form.method = method;
            return this;
        }
    }
    quickstart.FormBuilder = FormBuilder;
    FormBuilder["__class"] = "quickstart.FormBuilder";
})(quickstart || (quickstart = {}));
