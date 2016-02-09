package Interfaces;

/*
An interface is more than just an abstract class taken to the extreme, since it allows
you to perform a variation of "multiple inheritance" by creating a class that can be upcast to
more than one base type.

To create an interface, use the interface keyword instead of the class keyword. As with a
class, you can add the public keyword before the interface keyword (but only if that
interface is defined in a file of the same name). If you leave off the public keyword, you get
package access, so the interface is only usable within the same package. An interface can also
contain fields, but these are implicitly static and final.

To make a class that conforms to a particular interface (or group of interfaces), use the
implements keyword, which says, "The interface is what it looks like, but now I’m going to
say how it works." Other than that, it looks like inheritance.

*/

//: interfaces/music5/Music5.java
// Interfaces.

interface NewInstrument {
    // Compile-time constant:
    int VALUE = 5; // static & final
    // Cannot have method definitions:
    void play(Note n); // Automatically public
    void adjust();
}
class Wind implements NewInstrument {
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public String toString() { return "Wind"; }
    public void adjust() { System.out.println(this + ".adjust()"); }
}
class Percussion implements NewInstrument {
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public String toString() { return "Percussion"; }
    public void adjust() { System.out.println(this + ".adjust()"); }
}
class Stringed implements NewInstrument {
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public String toString() { return "Stringed"; }
    public void adjust() { System.out.println(this + ".adjust()"); }
}
class Brass extends Wind {
    public String toString() { return "Brass"; }
}
class Woodwind extends Wind {
    public String toString() { return "Woodwind"; }
}

/**
 * Created by saima on 9/02/16.
 */
public class Music5 {
    // Doesn’t care about type, so new types
    // added to the system still work right:
    static void tune(NewInstrument i) {
    // ...
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(NewInstrument[] e) {
        for(NewInstrument i : e)
            tune(i);
    }

    public static void main(String[] args) {
    // Upcasting during addition to the array:
        NewInstrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~
