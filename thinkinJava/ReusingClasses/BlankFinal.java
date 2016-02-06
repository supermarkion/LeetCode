package ReusingClasses;

/*
Java allows the creation of blank finals, which are fields that are declared as final but are not
given an initialization value. In all cases, the blank final must be initialized before it is used,
and the compiler ensures this. However, blank finals provide much more flexibility in the use
of the final keyword since, for example, a final field inside a class can now be different for
each object, and yet it retains its immutable quality.

*/

//: reusing/BlankFinal.java
// "Blank" final fields.

class Poppet {
    private int i;
    Poppet(int ii) { i = ii; }
}

/**
 * Created by saima on 6/02/16.
 */
public class BlankFinal {
    private final int i = 0;    // Initialized final
    private final int j;        // Blank final
    private final Poppet p;     // Blank final reference
    // Blank finals MUST be initialized in the constructor:
    public BlankFinal() {
        j = 1;                  // Initialize blank final
        p = new Poppet(1);      // Initialize blank final reference
    }
    public BlankFinal(int x) {
        j = x;                  // Initialize blank final
        p = new Poppet(x);      // Initialize blank final reference
    }
    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
} ///:~
