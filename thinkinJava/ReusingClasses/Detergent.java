package ReusingClasses;

//: reusing/Detergent.java
// Inheritance syntax & properties.

class Cleaner {
    protected String s = "Cleanser";
    public void append(String a) {
        s += a;
    }
    public void dilute() {
        append(" dilute()");
    }
    public void apply() {
        append(" apply()");
    }
    public void scrub() {
        append(" scrub() " + s);
    }
    public String toString() {
        return s;
    }
    public static void main(String[] args) {
        Cleaner x = new Cleaner();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

/**
 * Created by saima on 6/02/16.
 */
public class Detergent extends Cleaner{
    String b = "Detergent";
    // change method
    public void scrub() {
        append(" Detergent.scrub() " + super.s);
        // super.scrub();  // Call base-class version
    }
    // Add methods to the interface:
    public void foam() {
        append(" foam()");
    }
    // Test the new class:
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleaner.main(args);
    }
} /* Output:
Cleanser dilute() apply() Detergent.scrub() scrub() foam()
Testing base class:
Cleanser dilute() apply() scrub()
*///:~
