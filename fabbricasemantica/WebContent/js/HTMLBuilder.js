/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class HTMLBuilder {
        constructor(element) {
            if (this.element === undefined)
                this.element = null;
            this.element = element;
        }
        setClassName(className) {
            this.element.className = className;
            return this;
        }
        setAttribute(name, value) {
            this.element.setAttribute(name, value);
            return this;
        }
        setCss(type, value) {
            $(this.element).css(type, value);
            return this;
        }
        build() {
            return this.element;
        }
    }
    quickstart.HTMLBuilder = HTMLBuilder;
    HTMLBuilder["__class"] = "quickstart.HTMLBuilder";
})(quickstart || (quickstart = {}));
