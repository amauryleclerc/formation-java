module formation.java8 {
    requires java.base;
    requires java.desktop;
    requires java.prefs;
    requires java.logging;

    exports fr.sii.java8.ex01Functions;
    opens fr.sii.java8.ex01Functions;
}