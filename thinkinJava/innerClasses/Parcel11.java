package innerClasses;

/*
If you don’t need a connection between the inner-class object and the outerclass object, then
you can make the inner class static. This is commonly called a nested class. To understand
the meaning of static when applied to inner classes, you must remember that the object of
an ordinary inner class implicitly keeps a reference to the object of the enclosing class that
created it. This is not true, however, when you say an inner class is static. A nested class
means:
    1. You don’t need an outer-class object in order to create an object of a nested class.
    2. You can’t access a non-static outer-class object from an object of a nested class.

Nested classes are different from ordinary inner classes in another way, as well. Fields and
methods in ordinary inner classes can only be at the outer level of a class, so ordinary inner
classes cannot have static data, static fields, or nested classes.

*/

//: innerclasses/Parcel11.java
// Nested classes (static inner classes).

/**
 * Created by saima on 10/02/16.
 */
public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;
        public int value() { return i; }
    }
    protected static class ParcelDestination
            implements Destination {
        private String label;
        private ParcelDestination(String whereTo) {
            label = whereTo;
        }
        public String readLabel() { return label; }
        // Nested classes can contain other static elements:
        public static void f() {}
        static int x = 10;
        static class AnotherLevel {
            public static void f() {}
            static int x = 10;
        }
    }
    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }
    public static Contents contents() {
        return new ParcelContents();
    }
    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }
} ///:~
