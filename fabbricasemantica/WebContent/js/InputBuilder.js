/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class InputBuilder extends quickstart.HTMLBuilder {
        constructor() {
            super(document.createElement("input"));
            if (this.input === undefined)
                this.input = null;
            this.input = super.build();
        }
        setPlaceholder(placeholder) {
            this.input.placeholder = placeholder;
            return this;
        }
        setType(type) {
            this.input.type = type;
            return this;
        }
        setValue(value) {
            this.input.value = value;
            return this;
        }
    }
    quickstart.InputBuilder = InputBuilder;
    InputBuilder["__class"] = "quickstart.InputBuilder";
})(quickstart || (quickstart = {}));
